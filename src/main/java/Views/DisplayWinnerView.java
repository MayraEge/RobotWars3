package Views;

import Models.Robot;

public class DisplayWinnerView {
    public static void display(Robot player, Robot target) {
        if (player.getHealth() <= 0) {
            System.out.println(target.getName() + " gewinnt!");
            player.setKnockedOut(true);
        } else if (target.getHealth() <= 0) {
            System.out.println(player.getName() + " gewinnt!");
            target.setKnockedOut(true);
        }
    }
}
