package Views;

import Models.Robot;

import java.util.Random;

public class DisplayWinnerView {
    public static void display(Robot player, Robot target) {
        if (player.getHealth() <= 0) {
            System.out.println(target.getRobotName() + " gewinnt!");
            player.setKnockedOut(true);
        } else if (target.getHealth() <= 0) {
            System.out.println(player.getRobotName() + " gewinnt!");
            target.setKnockedOut(true);
        }
    }
}
