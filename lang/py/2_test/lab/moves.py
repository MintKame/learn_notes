'''
Author: your name
Date: 2021-06-07 15:45:32
LastEditTime: 2021-06-07 18:58:10
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: \py\2_test\lab\moves.py
'''
'''
ctrl the man walk 100 steps randomly, eat dot when meet it
the output save to img
'''

from load_tiles import load_tiles
from generate_maze import create_maze
from draw_maze import draw_grid, parse_grid
from pygame import image
import random
import sys
LEFT = (-1, 0)
RIGHT = (1, 0)
UP = (0, - 1)
DOWN = (0, 1)


def get_player_pos(level, player_char='*'):
    for y, row in enumerate(level):
        for x, char in enumerate(row):
            if char == player_char:
                return x, y


def move(level, direction):
    oldx, oldy = get_player_pos(level)
    newx = oldx + direction[0]
    newy = oldy + direction[1]
    if level[newy][newx] == '.' or level[newy][newx] == ' ':
        # floor or dot
        level[oldy][oldx] = ' '
        level[newy][newx] = '*'
    elif level[newy][newx] == 'x':
        exit()
    else:
        return


if __name__ == '__main__':
    tile_img, tiles = load_tiles()
    maze = create_maze(12, 7)
    maze = parse_grid(maze)
    maze[1][1] = '*'    # put the man
    maze_img = draw_grid(maze, tile_img, tiles)
    image.save(maze_img, 'before_move.png')
    for i in range(100):  # 100 steps
        direction = random.choice([LEFT, RIGHT, UP, DOWN])
        move(maze, direction)
    img = draw_grid(maze, tile_img, tiles)
    image.save(img, 'moved.png')
