'''
Author: your name
Date: 2021-03-16 10:07:38
LastEditTime: 2021-03-24 20:19:12
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/2_test/_1_.py
'''
# can run this test file whenever change the tested file

from city_country import get_desc  # func to be tested
import unittest  # tool used to test

# define a cls contains a set of method,
# each method is a unitest, test a diff aspect
#
# how to name class:
# XxxxTestCase: Xxxx should related to the func to be tested


class CityTestCase(unittest.TestCase):  # extend
    '''test city_country'''

    # how to name method:
    # test_xx:
    # "test_" will be auto called
    # xx is descriptive which related to the aspect to be tested
    #   so that, we can easily know which aspect through the name

    def test_city_country_title(self):
        desc = get_desc("China", "beijing")
        self.assertEqual(desc, "China, Beijing")

    def test_city_country_notitle(self):
        desc = get_desc("China", "beijing")
        self.assertEqual(desc, "China, beijing")

    def test_country(self):
        desc = get_desc("China")
        self.assertEqual(desc, "China")


# __name__ is setted when the program running
if __name__ == '__main__':
    # true if this file is running as a main program
    unittest.main()

# result:
# 1st line: many chars printed at runtime,
#           each represent a finished unittests,
#           can be observed bf entire program ended
# . pass
# F fail
# E error
#
# the last 2 lines are msg for this entire file

# what if not passed ?
# not fix the tst file,
# find the modification which lead to the problem
# and fix it
