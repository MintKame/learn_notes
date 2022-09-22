'''
Author: your name
Date: 2021-03-10 11:34:09
LastEditTime: 2021-03-14 22:45:38
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/3_1_list_range.py
'''
# range: get nums -------------------------------------
nums_1 = range(1, 4)
print(nums_1)
for num in nums_1:
    print(num)  # last isn't contained(1 2 3)
# overload
print(range(2, 11, 2))  # range(start, stop, step)
print(range(1, 4))  # step = 1
print(range(4))  # start = 0
for i in range(4):
    print(i)
print()

# create a list from range ----------------------------
# 1. (direct) to get each elem in range
items = list(nums_1)
print(items)
print()

# 2. (undirect) need change elem

#   a. using loop
squares = []  # a list of squares
for num in range(1, 4):
    squares.append(num ** 2)
print(squares)
print()

#   b. list comprehensions (just 1 line)
# no : after for
squares = [num ** 2 for num in range(1, 4) if num > 0]
print(squares)
print()

# eg check name unused (not diff cases)
current_users = ["a", "B", "c"]
new_users = ["b", "C", "d", "E"]
tmp_current = [str(user).lower() for user in current_users]
# print(tmp_current)
for user in new_users:
    if str(user).lower() in tmp_current:
        print("N")
    else:
        print(f"hello {user}")
