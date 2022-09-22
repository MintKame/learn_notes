'''
Author: your name
Date: 2021-03-15 11:31:14
LastEditTime: 2021-03-15 21:27:55
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_6_2_cls_sub.py
'''

from _6_0_cls import User
# super must bf sub


class Admin (User):
    def __init__(
            self, first, last,
            login_attempts=0, privilege=[]):
        # super() can't used out the cls
        super().__init__(first, last, login_attempts)  # !won't auto called
        # ! not pass "self" when call method
        #       pass "self" when define method
        self.privilege = privilege

    # override: same name and paras,
    def print_info(self):
        super().print_info()
        print(f"with the privilege: {self.privilege}")


#
yz = Admin("Yan", "Zhao")
yz.print_info()  # override: call sub's
