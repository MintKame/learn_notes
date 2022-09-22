'''
invoke generate_maze, load_tiles,
output maze in form of image,
named "maze.png"
'''
from pygame import image, Surface
from load_tiles import load_tiles, SIZE
from generate_maze import create_maze


def parse_grid(data):
    return [list(row) for row in data.strip().split("\n")]


def draw_grid(data, tile_img, tiles):
    xsize = len(data[0]) * SIZE
    ysize = len(data) * SIZE
    img = Surface((xsize, ysize))
    for y, row in enumerate(data):
        for x, char in enumerate(row):
            img.blit(tile_img, (x * SIZE, y * SIZE), tiles[char])
    return img


if __name__ == '__main__':
    tile_img, tiles = load_tiles()
    maze_string = create_maze(12, 7)
    level = parse_grid(maze_string)
    maze = draw_grid(level, tile_img, tiles)
    image.save(maze, 'maze.png')
