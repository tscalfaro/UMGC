"""
Created by: Antonio Scalfaro Dec 12. 2023
Leah's Portfolio Site

Utilizing Python and Flask
"""
from flask import Flask, render_template

app = Flask(__name__, static_url_path='/static')

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/bio')
def bio():
    return render_template('bio.html')

if __name__ == '__main__':
    app.run(debug=True)