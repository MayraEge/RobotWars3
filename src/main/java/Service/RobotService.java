package Service;

import Enums.Directions;
import Models.Robot;

public class RobotService {
    public static Enum<Directions> fromUserInput(int userChoice){
        return switch (userChoice) {
            case 8 -> Directions.NORD;
            case 9 -> Directions.NORDOST;
            case 6 -> Directions.OST;
            case 3 -> Directions.SUEDOST;
            case 2 -> Directions.SUED;
            case 1 -> Directions.SUEDWEST;
            case 4 -> Directions.WEST;
            case 7 -> Directions.NORDWEST;
            default -> Directions.NOMOVE;
        };
    }
    public static boolean inRange(Robot player, Robot target) {
        if (player.getX() + player.getAttackRange() >= target.getX()
                && target.getX() >= player.getX()
                && (player.getY() + player.getAttackRange() >= target.getY()
                && target.getY() >= player.getY())) {
            return true;
        } else if ((player.getX() + player.getAttackRange() >= target.getX()
                && target.getX() >= player.getX())
                && (player.getY() - player.getAttackRange() <= target.getY()
                && target.getY() <= player.getY())) {
            return true;
        } else if ((player.getX() - player.getAttackRange() <= target.getX()
                && target.getX() <= player.getX())
                && (player.getY() + player.getAttackRange() >= target.getY()
                && target.getY() >= player.getY())) {
            return true;
        } else if ((player.getX() - player.getAttackRange() <= target.getX()
                && target.getX() <= player.getX())
                && (player.getY() - player.getAttackRange() <= target.getY()
                && target.getY() <= player.getY())) {
            return true;
        }
        return false;
    }

}
