'''
Author: your name
Date: 2021-03-09 08:58:46
LastEditTime: 2021-03-11 11:02:08
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /py/learn_py/1_number.py
'''

# execute py's interpreter in terminal: type python3, write code after >>>
# exit: exit() or Ctrl + D
# execute .py in terminal: type python3 xx.py
# execute in editor

# var ------------------------------------------------
# const
# py not have build-in const
# use lowercase for var, uppercase for const
CONST_STR = "yz"

# multi assign
x, y, st = 1, 2, "a"

# type trans: type(var)
print(int(1.0))

# num --------------------------------------------

# float
print(0.2 + 0.1)  # extra decimal place

# float and int
# when devide any num, always get float
# even result in a whole num
print(4 / 2)

# big number, use _ (after 3.6)
big_num = 100_000_000000  # _ will not be print

# func
print(pow(2, 2))
print(2 ** 2)
print(pow(2.1, 2.1))
print(2.1 ** 2.1)
