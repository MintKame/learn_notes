'''
Author: your name
Date: 2021-03-10 13:12:13
LastEditTime: 2021-03-15 01:05:50
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/4_dict.py
'''
# ! dictionary: connect info, n*pairs of key-value

# can be empty, for what ?
#  store data provided / auto generate

# 2 types:
#   1. 1*obj's n*properties
#   2. n*obj's 1*same property (in another file)

friend = {"name": "JK", "age": "20", "sex": "male"}
# attention: the key is always a string
print(friend)
print()

# visit: 2 ways -----------------------------------------

# 1. the key must exist  (or KeyError)
print(f"{friend['name']} is {friend['age']} years old")

# 2. the key may not exist
# usage: get(key, * ret_when_not_exist) # defalut ret None
print(f"he lives in {friend.get('location', '!(location not set)')}")
print()

# change
friend["name"] = "JKL"

# add del
friend["city"] = "ShangHai"
del friend["sex"]
print(friend)
