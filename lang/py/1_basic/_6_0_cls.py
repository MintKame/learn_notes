'''
Author: your name
Date: 2021-03-15 21:27:18
LastEditTime: 2021-03-15 21:29:30
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_6_0_cls.py
'''
'''a class represent User'''  # doc string for module


class User:
    '''the info of user'''  # doc string: describe the function of the cls

    # method = func in cls

    #! why each method need pass "self" bf other para ?
    # "self": ref to the obj
    # auto pass "self" arg when called
    # so that instance can visit attr and method by "self"

    # default method add __ -> to avoid conflict
    # if not add __, not call __init__ when create an instance

    def __init__(self, first, last, login_attempts=0):  # can have default value
        '''create an instance & init the attr & return the instance'''
        self.first = first  # attr: can be visit using "self"
        self.last = last
        self.login_attempts = login_attempts

    def print_info(self):
        '''print user's info'''
        print(f"{self.first} {self.last}".title(),
              f"login in {self.login_attempts} times.")


a = User("a", "b")
a.print_info()
