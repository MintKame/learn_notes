'''
Author: your name
Date: 2021-03-16 11:46:55
LastEditTime: 2021-03-16 17:46:51
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /py/1_basic/_7_2_file_write.py
'''

# does func add / read new line ?
#
# input()   not read \n
# print()       add  \n (default)
#
# read()        read \n
# write()   not add  \n

# open()'s second para -> diff privilege
# file: exist       not-exist
# r                   err       (default)
# w     clear       create
# a     append      create
# r+ (r + w)

file_path_abs = "/mnt/c/coding/py/1_basic/text_file/output.txt"

with open(file_path_abs, 'w') as file_obj:
    # write multi lines: add \n
    file_obj.write("hello\n")
    file_obj.write("world\n")

with open(file_path_abs, 'a') as file_obj:
    file_obj.write(str(123))    # can only write string
