'''
Author: your name
Date: 2021-03-12 12:51:42
LastEditTime: 2021-03-13 11:52:22
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/4_dict_2.py
'''

#   2. n*obj's 1*same property
fruit_color = {       # always in separate lines
    "apple": "red",
    "banana": "yello",
    "pear": "yello",  # add , at last -> easy to add a new line
}

# traverse ---------------------------------------------------

# the diff in 2 types of dict
# 1*obj with n*properties (type 1), use "k", "v"
# n*obj with 1*same properties (type 2), use concrete name
# below are type 2

# 3 types of traverse
# all 3 types ret a list
# k - v
for fruit, color in fruit_color.items():
    print(f"{fruit}'s color is {color}")
print(fruit_color.items())
print()

# k
print("we have: ")
# for fruit in fruit_color: # same way
for fruit in fruit_color.keys():  # readable
    print(fruit)
print()

# v
print("the color mentioned: ")
for color in fruit_color.values():
    print(color)
print()

# other traverse ---------------------------
# to traverse in order:
# (in py 3.7, elems in order of added
print("we have: (in order)")
for fruit in sorted(fruit_color.keys()):
    print(fruit)
print()

# to traverse value not repeat:
print("the color mentioned: (not repeat)")
for color in set(fruit_color.values()):
    print(color)
print()

# because ret a list, another usage
if "green" not in fruit_color.values():
    print("we not mentione green\n")
