'''
Created on Nov 24, 2023
Created by: Antonio Scalfaro
SDEV 300 / 7381
Lab 6 - Web application
This program is a web app using flask, there are 4 routes
'/' - landing page
'/utley' - Utley info page
'/trout' - Trout info page
'/harper' - Harper info page

Updated: 11/28/2024
Lab 7
This update adds Login and registration functionality. Two new routes are added,
'/home' - Displays home page
'/register' - Displays register page with register form
credentials.txt file was added to store registered users.
Additionally, the route '/' now directs to the login page.
A user must be logged in to reach any other page on the site and a gif was added to 
'/'. I adjusted the player images to better fit the pages as well. Also a table has
been added to '/home'.
Additionally, these functions have been added to help with added functionality:
login_required() - This is a decorator with a wrapper function embedded, prevents
                   pages being reached without logging in first.
handle_registration() - Handles the registration form, catches already registered users,
                        invalid passwords, or displays home page upon successful registration
                        and sets session to logged in.
handle_login() - Handles login form, catches incorrect credentials or displays home page upon
                 successful login and sets session to logged in.
check_pass() - Validates a password is of the correct form
username_exists() - Checks if a username already exists in the database (i.e credentials.txt)
generate_salt() - Generates a salt to use with the sha256 encryption
store_credentials() - Stores a newly registered user's credentials if valid
check_credentials() - Validates credentials are in database for logging in.

Try logging in with a newly registered account or for ease try username: tony
and password: tony (created before password criteria was implemented)

Updated: 12/06/2023
Lab 8
This update adds an Update Password feature and a logger feature. One new route
was added (/update_password) and it is added to the navbar on the home page.
'/update_password' - Displays update password form
There are three additional functions:
show_update_password() - Displays update_password html
check_common_pass() - Checks if a password is found on the list of common passwords
                      found in the CommonPassword.txt file
update_password() - Finds user credentials from credentials.txt, if existing, and
                    creates new user credentials with updated password. Writes
                    credentials to temporary file and replaces credentials.txt
                    with temporary file using shutil library.
Two functions were updated:
check_pass() - Adds additional validation for password by calling
               check_common_pass()
handle_login() - Now contains code for logging failed login attempts, storing
                 date, time, username, and IP address in logger.txt
I added imports 'logging', 'shutil', and from tempfile 'NamedTemporaryFile'
to assist in logging, failed logins, and overwriting the credentials file to update
passwords.
Lastly, a logger.txt file was added to record all the failed logins.
Note: The common password list is essentially moot with the password criteria as is
      and to test that passwords were correctly compared to the list I added one to 
      the CommonPassword.txt. The first entry 'Apass4nico!!' is placed to test the
      functionality. To test this for yourself feel free to use username: nico and
      password: Apass4nico@@ and attempt to update the password. This also works if
      you register a new user and attempt to use a password found on the common
      password list.

@author: tscal
'''
from datetime import datetime
from functools import wraps
import logging
import re
import secrets
import shutil
from tempfile import NamedTemporaryFile
from flask import Flask, render_template, request, redirect, url_for, flash
from flask import session, get_flashed_messages
from passlib.hash import sha256_crypt

app = Flask(__name__, static_url_path='/static')
app.secret_key = 'lab6_secret_key'

def login_required(view):
    """Decorator to require login for a view."""
    @wraps(view)
    def wrapped_view(*args, **kwargs):
        """Wrapper"""
        if 'logged_in' in session and session['logged_in']:
            return view(*args, **kwargs)
        flash('You need to log in first.')
        return redirect(url_for('index'))
    return wrapped_view

@app.route('/', methods=['GET', 'POST'])
def index():
    """Default route, home page"""
    session['logged_in'] = False
    message = None
    if request.method == 'POST':
        print("Login")
        return handle_login()
    return show_login(message)

def show_login(message=None):
    """render login page"""
    message = get_flashed_messages()
    return render_template('login.html', message=message)

@app.route('/register', methods=['GET', 'POST'])
def show_register(message=None):
    """render registration page"""
    message = get_flashed_messages()
    print("REgister page")
    if request.method == 'POST':
        print("Registering")
        return handle_registration()
    return render_template('register.html', message=message)

@app.route('/update_password', methods=['GET', 'POST'])
@login_required
def show_update_password(message=None):
    """render update_password page"""
    message = get_flashed_messages()
    if request.method == 'POST':
        print("Updating Password")
        return update_password()
    return render_template('update_password.html', message=message)

@app.route('/home')
@login_required
def show_home():
    """set date time, render home.html"""
    current_datetime = datetime.now()
    formatted_datetime = current_datetime.strftime('%A, %B %d, %Y %I:%M:%S %p')
    return render_template('home.html', formatted_datetime=formatted_datetime)

@app.route('/utley')
@login_required
def show_utley():
    """render utley.html, route /utley"""
    return render_template('utley.html')

@app.route('/trout')
@login_required
def show_trout():
    """render trout.html, route /trout"""
    return render_template('trout.html')

@app.route('/harper')
@login_required
def show_harper():
    """render harper.html, route /harper"""
    return render_template('harper.html')

def handle_registration():
    """Handle registration request"""
    username = request.form.get('username')
    password = request.form.get('password')

    if not check_pass(password):
        flash("Invalid password. Please try again.")
        return redirect(url_for('show_register'))
    # Store and hash credentials
    if store_credentials(username, password):
        # Registration successful, load home page
        # Set session to logged in
        session['logged_in'] = True
        return show_home()
    #Registration failed, reload registration page
    print("Registration Failed")
    flash("Registration failed")
    return redirect(url_for('show_register'))

def handle_login():
    """Handle login request"""
    username = request.form.get('username')
    password = request.form.get('password')

    # Check if the credentials are valid
    if check_credentials(username, password):
        # Set session to logged in
        session['logged_in'] = True
        # Reset logging configuration to default
        logging.disable(logging.CRITICAL)
        return show_home()
    #Log failed login attempt
    log_message = f"Failed login attempt for: {username} from IP: {request.remote_addr}"
    logging.basicConfig(filename='static/logger.txt',
                        level=logging.ERROR, format='%(asctime)s - %(levelname)s - %(message)s')
    logging.error(log_message)
    #Login failed, reload login page
    print("Invalid credentials. Please try again.")
    flash("Invalid credentials. Please try again.")
    return redirect(url_for('index'))

def check_pass(password):
    """Ensure password meets criteria"""
    # Check if the password is at least 12 characters long and password not
    # on common list of passwords
    if len(password) < 12 or check_common_pass(password):
        return False

    # Check for at least one uppercase letter
    if not re.search(r'[A-Z]', password):
        return False

    # Check for at least one lowercase letter
    if not re.search(r'[a-z]', password):
        return False

    # Check for at least one digit
    if not re.search(r'\d', password):
        return False

    # Check for at least one special character
    if not re.search(r'[!@#$%^&*(),.?":{}|<>]', password):
        return False

    # All conditions met
    return True

def check_common_pass(password):
    """Check password is on CommonPassword.txt list"""
    with open('static/CommonPassword.txt', 'r', encoding='utf-8') as file:
        print("Checking common passes")
        for line in file:
            if password == line.strip():
                print("found common pass")
                return True
    return False

def username_exists(username):
    """Check if a username already exists in credentials.txt"""
    with open('static/credentials.txt', 'r', encoding='utf-8') as file:
        for line in file:
            stored_username = line.strip().split(',')[0]
            if username == stored_username:
                return True
    return False

def update_password():
    """Update existing user's password"""
    username = request.form.get('username')
    old_password = request.form.get('old-password')
    new_password = request.form.get('new-password')
    updated_token = False
    #Check that new password is valid password
    if not check_pass(new_password):
        flash("Update Password failed. New Password is not valid, must be 12 characters long" +
              ", 1 upper, 1 lower, and 1 special character")
        return redirect(url_for('show_update_password'))
    #Create temporary file to write updated credentials
    with NamedTemporaryFile(mode='w', delete=False, encoding='utf-8') as temp_file:
        with open('static/credentials.txt', 'r', encoding='utf-8') as file:
            for line in file:
                stored_username, stored_salt, stored_password = line.strip().split(',')
                if(
                    username == stored_username and
                    sha256_crypt.using(salt=stored_salt).verify(old_password, stored_password)
                ):
                    #Update the password for the specified user
                    hashed_new_password = sha256_crypt.using(salt=stored_salt).hash(new_password)
                    update_line = f'{stored_username},{stored_salt},{hashed_new_password}\n'
                    temp_file.write(update_line)
                    updated_token = True #Keeps track if a username was updated
                    print(f"Change made to password for {stored_username}")
                else:
                    #Write other lines unchanged
                    temp_file.write(line)
    #Replace original credentials file with updated one
    if updated_token:
        shutil.move(temp_file.name, 'static/credentials.txt')
        flash("Password updated")
    else:
        #No update made
        print("Update password failed, credentials not found")
        flash("Update password failed, credentials not found")
    return redirect(url_for('show_update_password'))

def generate_salt():
    """Generate a random salt."""
    return secrets.token_hex(8)  # You can adjust the length of the salt

def store_credentials(username, password):
    """generate hashed password, save username and hashed password in credentials.txt"""
    if username_exists(username):
        print(f"Username '{username}' already exists. Registration failed.")
        return False
    salt = generate_salt()
    hashed_password = sha256_crypt.using(salt=salt).hash(password)
    with open('static/credentials.txt', 'a', encoding='utf-8') as file:
        file.write(f'{username},{salt},{hashed_password}\n')
    return True

def check_credentials(username, password):
    """Check credentials are in 'database' """
    with open('static/credentials.txt', 'r', encoding='utf-8') as file:
        for line in file:
            stored_username, stored_salt, stored_password = line.strip().split(',')
            if (
                username == stored_username and
                sha256_crypt.using(salt=stored_salt).verify(password, stored_password)
            ):
                return True
    return False
