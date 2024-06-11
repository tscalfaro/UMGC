import random
from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def calculate():
    x = random.randint(1, 100)
    y = 2
    return x + y

def say_hello(request):
    x = calculate()
    return render(request, 'hello.html', { 'name': x})