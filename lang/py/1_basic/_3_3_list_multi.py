'''
Author: your name
Date: 2021-03-10 01:28:59
LastEditTime: 2021-03-14 22:42:02
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/3_list_change.py
'''
# func ---------------------------------
nums = [1, 2, 3]
print(f"min in {nums} is {min(nums)}, sum is {sum(nums)}\n")

# reverse ----------------------------
print("\n4")
items = [1, 4, 2, 3]
print(items)
items.reverse()  # forever
print(items)

# sort ----------------------------------
print("\n5")

# forever
items.sort()  # bigger
print(f"{items} after call sort")

items.sort(reverse=True)  # smaller
print(f"{items} after call sort + reverse\n")

# temporary
print(f"{items} original")
print(f"{sorted(items)} sorted")  # bigger
print(f"{items} after call sorted\n")

print(f"{sorted(items, reverse=True)} sorted")  # smaller

# slice: sub list of list------------------------------
nums = [0, 1, 2, 3, 4, 5]
# listName[from:to:gap]
print(nums[0:-2:2])
# default: from = 0, to = n (last index + 1), gap = 1
print(nums[::])
print(nums)  # not change original
print()

# usage*2 ?
# traverse sub list
total = 0
for i in nums[1:3]:
    total += i
print(total)

# copy list
nums_0 = [0, 1, 2, 3]
nums_1 = nums_0[:]  # create new list
del nums_1[0]
print(f"nums_0: {nums_0} nums_1: {nums_1}")

nums_0 = [0, 1, 2, 3]
nums_2 = nums_0  # ref to the same list
del nums_2[0]
print(f"nums_0: {nums_0} nums_2: {nums_2}\n")
