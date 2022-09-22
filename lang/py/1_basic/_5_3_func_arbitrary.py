'''
Author: your name
Date: 2021-03-15 00:27:34
LastEditTime: 2021-03-15 11:23:47
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/5_3_func_arbitrary.py
'''

#! arbitary at last, pack all values it receives

# pass arbitrary num of positional arguments --------------------------------
# when not know how many info will passed
# often see the generic para name *args


def make_sandwich(size, *addings):  # an empty tuple
    '''make a sandwich of size with adding'''
    print(f"make a {size} sandwich, with the following:")
    for adding in addings:
        print(adding)
    print()


make_sandwich("big", "egg", "tomato")
make_sandwich("big", "egg")
make_sandwich("big")
# pass arbitrary num of keyword arguments --------------------------
# when not know what kind of info will passed
# often see the generic para name **kwargs
# can mix use with keyword arg and positional arg same time


def build_profile(name_, **user_info):  # an empty dictionary
    '''build user's profile'''
    user_info["name"] = name_
    return user_info


# passed key not surrounded with " "
profile = build_profile("yz", age="19", city="BJ")
print(profile)
