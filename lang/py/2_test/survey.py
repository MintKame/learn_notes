'''
Author: your name
Date: 2021-03-24 20:39:47
LastEditTime: 2021-03-24 20:13:58
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /py/2_test/survey.py
'''


class Survey:
    '''collect answer for the question'''

    def __init__(self, question):
        '''init the question and the collection of answer'''
        self.question = question
        self.answers = []

    def add_answer(self, answer):
        '''add the answer to answers'''
        self.answers.append(answer)
