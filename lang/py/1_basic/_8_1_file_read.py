'''
Author: your name
Date: 2021-03-08 18:21:36
LastEditTime: 2021-03-16 19:24:10
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /learn_py/8_file.py
'''
# +: user can choose what data to enter and when to enter
# can close the program and continue afterwards

# file path -------------------------------------------------
# win sys use '\'. in py can use '/' or '\\'

# relative
#   to current file's dir
file_path_rel = "text_file/pi_digits.txt"

# absolute
#   when text_file not in current file's dir, can't use relative
file_path_abs = "/mnt/c/coding/py/1_basic/text_file/pi_digits.txt"

# read data -------------------------------------------------

# with-block: file auto close when not needed
# can be replace with open() and close()
# recommand
#   avoid data lose due to not close
#   close() too early, can't access

# open(file_path): search the file and return an obj represent the file
#   file's size no limit, as long as the memory is enough
#   the obj only can be used inside the with-block
#   so, we can use the list outside the with-block

# read entire file
try:
    with open(file_path_abs) as f:  # always named 'f'
        print("1. entire:")
        contents = f.read()
        print(contents + '|')
        # diff with orginal: extra blank line at end
        #   why: read() reach end of file, return a an empty str,
        #        which shows up as a blank line
except FileNotFoundError:
    print(f"{file_path_abs} not found")

# read each line
try:
    with open(file_path_rel) as f:
        print("\n2. each line:")
        for line in f:
            print(line + '|')
        # diff with orginal: '\n' at the end of each line
except FileNotFoundError:
    print(f"{file_path_abs} not found")

try:
    # create a list of lines
    with open(file_path_rel) as f:
        print("\n3. list:")
        lines = f.readlines()
except FileNotFoundError:
    print(f"{file_path_abs} not found")

for line in lines:
    print(line + "|")
    # diff with orginal:
