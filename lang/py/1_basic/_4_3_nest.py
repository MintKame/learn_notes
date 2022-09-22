'''
Author: your name
Date: 2021-03-12 13:36:56
LastEditTime: 2021-03-13 12:16:47
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/4_3_next.py
'''
# list of dicts  -------------------------------------
aliens = []
for num in range(30):  # 30 times
    new_alien = {"color": "green", "speed": "slow"}
    aliens.append(new_alien)  # same but separate dictionaries


# dict of lists --------------------------------------
    # when need to connect the key with many values
favorite_fruit = {
    "a": ["apple", "banana"],
    "b": ["apple"]
}

for name, fruits in favorite_fruit.items():
    print(f"{name}'s favorite fruit ")
    if len(fruits) <= 1:
        print("is: ")
    else:
        print("are: ")
    for fruit in fruits:
        print(fruit)
    print()


# dict of dicts --------------------------------------
# each inner dicts have same structure -> easy to manage
users = {
    "a": {
        "city": "BJ",
        "age": 18
    },
    "b": {
        "city": "SH",
        "age": 20
    },
}
for name, msg in users.items():
    print(f"{name} is {msg['age']} years old, lives in {msg['city']}")
