'''
Author: your name
Date: 2021-06-07 18:40:44
LastEditTime: 2021-06-07 19:10:52
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: \py\2_test\lab\maze_run.py
'''

'''
self control the man, eat the point
exit the game when arrive the exit
'''


from pygame import display
from pygame import Rect
from load_tiles import load_tiles
from generate_maze import create_maze
from event_loop import event_loop
from draw_maze import draw_grid, parse_grid
from moves import move, LEFT, RIGHT, UP, DOWN
import pygame
DIRECTIONS = {
    97: LEFT, 100: RIGHT,
    119: UP, 115: DOWN
}


def draw():
    img = draw_grid(maze, tile_img, tiles)
    display.blit(img, Rect((0, 0, 384, 224)), Rect((0, 0, 384, 224)))
    pygame.display.update()


def handle_key(key):
    print(key, "pushed\n")
    direction = DIRECTIONS.get(key)
    if direction:
        move(maze, direction)
    draw()


if __name__ == '__main__':
    pygame.init()
    pygame.display.set_mode((800, 600))
    display = pygame.display.get_surface()
    tile_img, tiles = load_tiles()

    maze = parse_grid(create_maze(12, 7))
    maze[1][1] = '*'
    maze[5][10] = 'x'

    draw()
    event_loop(handle_key)
