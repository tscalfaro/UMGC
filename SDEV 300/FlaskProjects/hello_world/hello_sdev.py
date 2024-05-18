'''
Created on Nov 24, 2023

@author: tscal
'''
from flask import Flask
from flask import render_template
app = Flask(__name__, static_url_path='/static')
@app.route('/')
def index():
    return show_hello()

# Can call functions as part of the returns
def show_hello():
    return hello()

# Can provide multiple route versions
# And can render template - found in /template folder
@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    print(f"hello template triggered with name: {name}")
    return render_template('hello.html', name=name)


@app.route('/myTemp/')
def myTemp():
    print("MyTemp triggered")
    return render_template('myTemp.html')