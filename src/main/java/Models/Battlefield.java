package Models;

import Enums.Directions;

public class Battlefield {
    private int width;
    private int height;
    protected static int[][] map;

    public Battlefield(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    private void boardInit() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = 0;
            }
        }
    }

    public static boolean validTurn(Directions direction, Robot player) {
        switch (direction) {
            case SUED:
                return isValidMove(player.getY() + 1, 9);
            case WEST:
                return isValidMove(player.getX() - 1, 0);
            case NORD:
                return isValidMove(player.getY() - 1, 0);
            case OST:
                return isValidMove(player.getX() + 1, 14);
            case NORDOST:
                return isValidMove(player.getY() - 1, 0) && isValidMove(player.getX() + 1, 14);
            case SUEDOST:
                return isValidMove(player.getX() + 1, 14) && isValidMove(player.getY() + 1, 9);
            case SUEDWEST:
                return isValidMove(player.getX() - 1, 0) && isValidMove(player.getY() + 1, 9);
            case NORDWEST:
                return isValidMove(player.getX() - 1, 0) && isValidMove(player.getY() - 1, 0);
            case NOMOVE:
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidMove(int coordinate, int limit) {
        return coordinate >= 0 && coordinate <= limit;
    }
}