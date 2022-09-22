'''
Author: your name
Date: 2021-05-31 14:55:17
LastEditTime: 2021-06-07 15:40:08
LastEditors: your name
Description: In User Settings Edit
FilePath: \py\2_test\lab\event_loop.py
'''
'''
show game window
print the ascii you entered in terminal
'''




from pygame.locals import KEYDOWN
import pygame
def event_loop(handle_key, delay=10):
    while True:
        pygame.event.pump()
        event = pygame.event.poll()
        if event.type == KEYDOWN:
            handle_key(event.key)
        pygame.time.delay(delay)


def print_handler(val):
    print(val)


if __name__ == '__main__':
    pygame.init()
    pygame.display.set_mode((400, 300))
    event_loop(print_handler)
