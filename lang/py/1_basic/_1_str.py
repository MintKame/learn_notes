'''
Author: your name
Date: 2021-03-08 22:49:05
LastEditTime: 2021-03-13 12:28:54
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /py/learn_py/1_basic_type.py
'''

print("\n1")
msg = "hello "
print(msg)
msg_2 = msg + "world!"
print(msg_2)  # print in a new line

# if str too long
#  print() in separate lines (each line must has " and ")
print("abcdefghijklmno"
      "pqrstuvwxyz")
#  use + to connect str
msg = "abcdefghijklmno"
msg += "pqrstuvwxyz"

print("\n2")
# ! both " and ' can be use
# +: str can contain ' and "
str1 = " ' str1   "
str2 = ' " str2 " '
print(str1)
print(str2)
# but need \ when contain both ' and "
str3 = " ' str3 \" "
print(str3)

print("\n3")
# change case
case = "mint KAME"
print(case.title())  # each word begins with a capital letter
print(case.upper())
print(case.lower())  # always used to store data, in case user use incorrect fomat
print(case)          # not change original

print("\n4")
#! use var in string:
# f"x{xx}" (format)
first_name = "Mint"
last_name = "KAME"
full_name = f"{first_name} {last_name}"
print(f"hello, {full_name.title()}")
# before 3.6
full_name = "{} {}".format(first_name, last_name)

print("\n5")
# strip whitespace
msg = "  haha  "
# msg not changed
msg.rstrip()
print(msg + "|")
# also can use: lstrip, strip
# use: clean up user input bf store
