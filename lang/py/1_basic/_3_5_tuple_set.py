'''
Author: your name
Date: 2021-03-10 11:36:47
LastEditTime: 2021-03-14 22:46:57
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/3_3_list_tuple.py
'''
# tuple: elem not changae (more simple)
t = ('1', 2, '3')

# special cases
emp = ()    # correct
print(emp)
sigl = (1,)   # (1) is not a tuple, must add ","
print(sigl)

# set: elem not repeat --------------------
s = {'1', '2', '2'}
print(s)
# attention: ------------------------------
# set & dict: both use "{ }"
# diff set with list & dict: not specific order
