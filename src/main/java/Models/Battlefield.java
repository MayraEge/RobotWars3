package Models;

import Enums.Directions;

public class Battlefield {
    private int width;
    private int height;
    private int[][] map;

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

    public static boolean validTurn(Directions direction, Robot spieler) {
        if (direction.equals(Directions.SUED) && spieler.getY() + 1 <= 9) {
            return true;
        } else if (direction.equals(Directions.WEST) && spieler.getX() - 1 >= 0) {
            return true;
        } else if (direction.equals(Directions.NORD) && spieler.getY() - 1 >= 0) {
            return true;
        } else if (direction.equals(Directions.OST) && spieler.getX() + 1 <= 14) {
            return true;
        } else if (direction.equals(Directions.NORDOST) && spieler.getY() - 1 >= 0 && spieler.getX() + 1 <= 14) {
            return true;
        } else if (direction.equals(Directions.SUEDOST) && spieler.getX() + 1 <= 14 && spieler.getY() + 1 <= 9) {
            return true;
        } else if (direction.equals(Directions.SUEDWEST) && spieler.getX() - 1 >= 0 && spieler.getY() + 1 <= 9) {
            return true;
        } else if (direction.equals(Directions.NORDWEST) && spieler.getX() - 1 >= 0 && spieler.getY() - 1 >= 0) {
            return true;
        } else if (direction.equals(Directions.NOMOVE)) {
            return true;
        } else {
            return false;
        }
    }
}