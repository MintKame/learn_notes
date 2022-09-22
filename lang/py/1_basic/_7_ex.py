'''
Author: your name
Date: 2021-03-15 10:14:18
LastEditTime: 2021-03-16 19:19:26
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_8_ex.py
'''
# runtime err
# -> create ex: a special obj
# -> 1. handle ex / 2. print traceback


def divide_0(a, b):
    result = int(a) / int(b)  # a
    print(result)            # c
    print("func ended\n")    # d

# how to handle ex ?


def divide_1(a, b):
    '''calculate a / b'''
    try:
        result = int(a) / int(b)    # a
    except ZeroDivisionError:
        pass    # dummy, silence when err
        # print("can't divide zero!")  # b
    else:
        print(result)               # c
    print("func ended\n")  # d (continue run the code


# divide_0      # err:    a - traceback
divide_1(1, 2)  # normal: a - c - d
divide_1(1, 0)  # err:    a - b - d
