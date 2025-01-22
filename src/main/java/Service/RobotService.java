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
        int dx = Math.abs(player.getX() - target.getX());
        int dy = Math.abs(player.getY() - target.getY());
        return dx <= player.getAttackRange() && dy <= player.getAttackRange();
    }
}
