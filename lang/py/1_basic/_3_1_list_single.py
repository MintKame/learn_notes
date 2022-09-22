'''
Author: your name
Date: 2021-03-09 11:55:03
LastEditTime: 2021-03-14 22:37:30
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/3_list.py
'''
# visit ----------------------------------
print("\n1")
items = [1, 2, "a"]
# int items[3] = {1, 2, 3} (compare)

print(items)
print(f"length = {len(items)}")  # get length

print(items[2])  # first:  0 -> n-1
print(items[-1])  # ! last: -1 -> -n

print(items.index("a"))
# when visit [-1], only err when list is empty

# print(items.count())
# print(items.copy())

# add ----------------------------------
print("\n2")
items.append("b")  # add to last
items.append(1)

items.insert(-1, "c")  # index value

print(items)
# print(items.extend())

# delete ----------------------------------

# by value (remove leftmost)
items.remove(1)
print(items)

# by index
#   if the deleted not needed
print("\n3")
del items[-2]
print(items)

#   if the deleted need to use
item = items.pop()  # can get the poped item
print(f"{items}\t pop last: {item}")

item = items.pop(1)  # need know the index
print(f"{items}\t pop [1]:  {item}")

# clear
items.clear()
print(items)
