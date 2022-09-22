'''
Author: your name
Date: 2021-03-16 10:19:07
LastEditTime: 2021-03-25 09:29:18
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/2_test/_2_.py
'''

# test the method of the class, samilar to test a func
from survey import Survey
import unittest


class SurveyTestCase(unittest.TestCase):
    '''test the Survey class'''

    # setUp() auto called bf test_xxx
    #
    # what always do in setup() ?
    # create instances as TestCase's attr,(using "self")
    #           and set instance's attr
    # can be used in every test_xxx, to avoid duplicated create
    def setUp(self):
        '''set the survey and answers'''
        self.survey = Survey("how old are you? ")  # using "self" to set attr
        self.answers = [10, 19, 5]

    def test_add_single_answer(self):
        self.survey.add_answer(self.answers[0])
        self.assertIn(self.answers[0], self.survey.answers)
        # many types of assert

    def test_add_three_answer(self):
        for answer in self.answers:
            self.survey.add_answer(answer)
        for answer in self.answers:
            self.assertIn(answer, self.survey.answers)


if __name__ == "__main__":
    unittest.main()
