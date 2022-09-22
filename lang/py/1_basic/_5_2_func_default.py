'''
Author: your name
Date: 2021-03-08 18:21:36
LastEditTime: 2021-03-15 08:24:36
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/6_func.py
'''

# default value:
# why default must at rightmost when define func ?
# positional arguments -> to pass args to the no-default value (left)

# 2 usage:

# 1. simplify, give the typical usage ----------------------


def favorite_fruit(name, fruit="apple"):
    """display the fruits passed"""
    print(f"{name}'s favorite fruit is {fruit}.\n")


favorite_fruit("yz")

# 2. making an argument optional ---------------------------
# diff with 1: 2 have multi cases, depends on whether pass the optional argu
# no matter pass the optional, 1 will use the passed or default


def get_msg(first_, last_, middle_="", age_=None):  # optional: middle_, age_
    """get messge of a person"""
    msg = {
        "first": first_,
        "last": last_,
    }
    # how to judge whether pass the optional arg ?
    # optional arg default set to special value
    # eg False value: None / "" / [] / {}
    if middle_:
        msg["middle"] = middle_
    if age_:
        msg["age"] = age_
    return msg


print(get_msg("Yan", "Zhao", age_=19))
