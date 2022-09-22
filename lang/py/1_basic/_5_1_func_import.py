'''
Author: your name
Date: 2021-03-15 11:31:38
LastEditTime: 2021-03-15 12:37:00
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_5_1_func_import.py
'''
# store funcs in modules ----------------------------------
# module: file with .py
# module's name should up to standard (not start with num)

# each module_name.py can be import: -----------------------
# import entire module:
# import module_name
# use: module_name.func_name()

# import specific func:
# from module_name import func_0, func_1, func_2
# use: func_name()

# import all func in module: (not use)
# use: func_name()

# alias ---------------------------------------------------
# func's alias
# when: conflict with imported func
#       imported func name too long

# module's alias
import _5_0_func
from _5_0_func import eat
from _5_0_func import *
from _5_0_func import eat as e
import _5_0_func as func
print()
_5_0_func.eat("a", ["peach", "apple"])
# 2-ways to pass value:------------------------------------
# 1. positional arguments (same order with para)
print()

# ! 2. keyword arguments (each argument is name-value pair -> any order, no confusion)
_5_0_func.eat(fruits=["banana"], name="b")
print()
# fruit -- parameter, ["apple"] -- argument

# pass the copy of a list, not change the original list -----------------------------------
fruits_c = ["peach", "apple"]
_5_0_func.eat("c", fruits_c)
print(f"origin:{fruits_c}")
print()

fruits_d = ["peach", "apple"]
_5_0_func.eat("d", fruits_d[:])  # slice
print(f"origin:{fruits_d}")
print()
# how to choose pass copy / original list ?
#   mostly original list, not create a new list, save time and storage
