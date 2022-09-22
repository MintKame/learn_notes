'''
Author: your name
Date: 2021-03-13 12:25:36
LastEditTime: 2021-03-15 10:08:08
LastEditors: Please set LastEditors
# Description: In User Settings Edit
FilePath: /1_basic/5_io.py
'''
# input
# para: prompt
msg = input("tell me sth, I'll repeat it back to you:\n")
print(msg)

# use multi lines -> more clear
prompt = "If you tell us who you are, we can personalize the messages you see."
prompt += "\nWhat is your first name? "
name = input(prompt)
print(f"\nHello, {name}!")

# trans type
age = input("how old are you?\n")
age = int(age)

# output --------------------------------------
print("str", end='')  # default: '\n'
