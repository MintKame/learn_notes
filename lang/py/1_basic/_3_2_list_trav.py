'''
Author: your name
Date: 2021-03-13 18:37:54
LastEditTime: 2021-03-14 22:40:57
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/3_2_list_trav.py
'''
# 2 ways to traverse: for / while
# for: visit, but not change len----------------------------------------------
# why can't change: have trouble keeping track of items
fruits = ["apple", "banana", "peach"]
for fruit in fruits:  # in range / list
    print(f"{fruit} delicious!")
print(f"there are {len(fruits)} types\n")

# while: can change len -------------------------------------------
# case 1: mov items to another list
orders = ["rice", "sandwich", "rice"]
finished = []
while orders:  # until orders become empty
    food = orders.pop()
    print(f"making {food}...")
    finished.append(food)
print(f"finished: {finished}\n")

# case 2: del all same items
orders = ["rice", "sandwich", "rice"]
print("rice sell out")
while "rice" in orders:
    orders.remove("rice")  # remove() just delete 1
print(f"orders: {orders}")
