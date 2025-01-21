package Views;

import Models.Robot;

import java.util.Scanner;

public class AskSkillPointsView {
    public static void setStats(Robot player) {
    int spend = 0;
    int skillpoints = 10;
    Scanner scanner = new Scanner(System.in);
    char[] points = new char[10];
    while (spend < skillpoints) {
        System.out.println("Bitte verteilen Sie 10 Skillpoints auf die folgen Attribute Ihres Roboters: \n Bewegungsrate: "+ player.getMovementRange() + "\n Schaden: "+ player.getAttackDamage() + "\n Gesundheit: " + player.getHealth() + "\n Reichweite: " + player.getAttackRange());
        System.out.println("Drücken Sie m für Movementrange, d für Damage, g für Gesundheit und r für Angriffsreichweite. Sie können noch "+(skillpoints-spend)+" Punkte verteilen.");
        String input = scanner.next();
        if (input.equals("m")) {
            player.setMovementRange(player.getMovementRange()+1);
            spend += 1;
        } else if (input.equals("d")) {
            player.setAttackDamage(player.getAttackDamage()+1);
            spend += 1;
        } else if (input.equals("g")) {
            player.setHealth(player.getHealth()+1);
            spend += 1;
        } else if (input.equals("r")) {
            player.setAttackRange(player.getAttackRange()+1);
            spend += 1;
        } else {
            System.out.println("Eingabe ungültig.");
        }

    }
}
    public static void display(Robot player) {
        System.out.println("Attribute Ihres Roboters: \n Bewegungsrate: "+ player.getMovementRange() + "\n Schaden: "+ player.getAttackDamage() + "\n Gesundheit: " + player.getHealth() + "\n Reichweite: " + player.getAttackRange());
    }
}

