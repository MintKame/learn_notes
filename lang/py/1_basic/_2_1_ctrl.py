'''
Author: your name
Date: 2021-03-09 20:00:09
LastEditTime: 2021-03-15 20:32:29
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/2_ctrl.py
'''
# if -------------------------------------------------------------
alphabet = ["a", "A"]
if alphabet[0] != alphabet[1]:
    print("\ndiff char")

# when ignore case, both use lower case
# not change original string
if alphabet[0].lower() == alphabet[1].lower():
    print("same alphabet\n")

# ! check element (not) in list
fruits = ["apple", "banana", "peach"]
if "apple" in fruits:
    print("we have apple")
if "potato" not in fruits:
    print("potatos aren't fruit\n")

# ! check list is(not) empty
items = []
if not items:
    print("i have nothing\n")

# multi condition: use and, or
# readable: surround each condition with ()
if (alphabet[0] != alphabet[1]) and (alphabet[0].lower() == alphabet[1].lower()):
    print("same case, but diff char\n")

# other if-statements
age = 12
if age < 4:
    price = 0
elif age < 12:
    price = 5
elif age < 18:
    price = 10
else:
    price = 20
print(f"your cost is {price}")

# for --------------------------------------------------------------------
fruits = ["apple", "banana", "peach"]
# in range / list
for fruit in fruits:  # single elem's name should be meaningful
    # blocks contain all indent lines
    print(fruit)
    print(f"{fruit} delicious!\n")
print(f"there are {len(fruits)} types\n")
