'''
Author: your name
Date: 2021-05-24 15:04:20
LastEditTime: 2021-06-07 19:03:06
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: \py\2_test\lab\load_tiles.py
'''

'''
split image to 3 blocks and save to new images, named tiles_combo.png
'''

import pygame
from pygame import image, Rect
TILE_POSITIONS = [
    ('#', 0, 0),  # wall
    (' ', 0, 1),  # floor
    ('.', 2, 0),  # dot
    ('*', 3, 0),  # man
    ('x', 1, 0)  # exit
]
SIZE = 32

# image = 'tiles.xpm'


def load_tiles():
    '''
    Load tiles from an image file into a dictionary.
    Returns a tuple of(image, tile_ dict)
    '''
    tiles = {}
    tile_img = image.load('images/tiles.xpm')
    for x in TILE_POSITIONS:
        rect = Rect(x[1]*SIZE, x[2]*SIZE, SIZE, SIZE)
        tiles[x[0]] = rect
    return tile_img, tiles


if __name__ == '__main__':
    tile_img, tiles = load_tiles()
    m = pygame.Surface((96, 32))
    m.blit(tile_img, tiles['#'], tiles['#'])
    m.blit(tile_img, tiles[' '], tiles[' '])
    m.blit(tile_img, tiles['.'], tiles['.'])
    m.blit(tile_img, tiles['*'], tiles['*'])
    m.blit(tile_img, tiles['*'], tiles['*'])
    image.save(m, 'tiles_combo.png')
