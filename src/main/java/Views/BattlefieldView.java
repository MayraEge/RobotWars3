package Views;
import Models.Battlefield;
import Models.Robot;

import java.util.List;

public class BattlefieldView {
    public static void display(List<Robot> robots, Battlefield battlefield) {
        for (int y = 0; y < battlefield.getHeight(); y++) {
            for (int x = 0; x < battlefield.getWidth(); x++) {
                if (x == robots.get(0).getX() && y == robots.get(0).getY()) {
                    System.out.print(robots.get(0).getRobotName());
                } else if (x == robots.get(1).getX() && y == robots.get(1).getY()) {
                    System.out.print(robots.get(1).getRobotName());
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
