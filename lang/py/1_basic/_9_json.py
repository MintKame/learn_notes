'''
Author: your name
Date: 2021-03-15 21:33:44
LastEditTime: 2021-03-16 19:49:47
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/_9_jsom.py
'''
import json
# json module: save user data, to avoid lose when program stop running


def get_stored_name(file_path):
    try:
        with open(file_path) as f:
            name = json.load(f)  # para: file
    except FileNotFoundError:
        return None  # ! easy to tst
    else:
        return name


def save_user_name(file_path):
    name = input("What's your name? ")
    with open(file_path, "w") as f:
        json.dump(name, f)  # para: data_to_save, file
    return name


def greet(file_path):
    '''greet when already name, else save name'''
    name = get_stored_name(file_path)
    if name:
        print("I remember you,", name)
    else:  # !
        name = save_user_name(file_path)
        print("Hello, World," name)


greet("text_file/user_name.json")
