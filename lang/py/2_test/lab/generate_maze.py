'''
Author: your name
Date: 2021-05-24 15:58:37
LastEditTime: 2021-05-31 15:35:29
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /py/2_test/lab/generate_maze.py
'''
import random

XMAX, YMAX = 12, 7


def create_grid_string(dots, xx, yy):
    grid = ""
    for y in range(yy):
        for x in range(xx):
            grid += "#" if (x, y) not in dots else "."
        grid += "\n"
    return grid


def get_all_dot_positions(xsize, ysize):
    return [(x, y) for x in range(1, xsize - 1) for y in range(1, ysize - 1)]


def get_neighbors(x, y):
    return [
        (x, y - 1), (x, y + 1), (x - 1, y), (x+1, y),
        (x - 1, y - 1), (x + 1, y - 1), (x - 1, y + 1), (x+1, y + 1)
    ]


def generate_dot_positions(xsize, ysize):
    positions = get_all_dot_positions(xsize, ysize)
    dots = set()
    while positions != []:
        x, y = random.choice(positions)
        neighbors = get_neighbors(x, y)
        free = [nb in dots for nb in neighbors]
        if free.count(True) < 5:
            dots.add((x, y))
        positions.remove((x, y))
    return dots


def create_maze(xsize, ysize):
    dots = generate_dot_positions(xsize, ysize)
    maze = create_grid_string(dots, xsize, ysize)
    return maze


if __name__ == '__main__':
    dots = set(((1, 1), (1, 2), (1, 3), (2, 2), (3, 1), (3, 2), (3, 3)))
    print(create_grid_string(dots, 5, 5))

    positions = get_all_dot_positions(5, 5)
    print(create_grid_string(positions, 5, 5))

    neighbors = get_neighbors(3, 2)
    print(create_grid_string(neighbors, 5, 5))

    maze = create_maze(20, 20)
    print(maze)
