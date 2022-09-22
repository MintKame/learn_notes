'''
Author: your name
Date: 2021-03-15 09:22:18
LastEditTime: 2021-03-15 09:23:04
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_5_0_func.py
'''

# define-----------------------------------


def eat(name, fruits):
    """eat 1 of fruits"""
    # docstring: describe the func, surround with """, used to generate the doc
    fruit_to_eat = fruits.pop()
    print(f"{name} eats {fruit_to_eat}")
    print(f"remain: {fruits}")
