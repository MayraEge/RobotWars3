package Controllers;

import Enums.Directions;
import Models.Battlefield;
import Models.Robot;
import Service.RobotService;
import Views.*;

import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class GameController {
    public static void main(String[] args) {
        try {
            String response = HttpRequest.sendGetRequest("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/");
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        IntroScreenView.display();
        Battlefield battlefield = new Battlefield(15, 10);
        String robotName = (AskRobotNameView.display());
        Robot player = new Robot(robotName, 1, 1, 1, 1, 1, 1,   false);
        Robot target = new Robot("[Z]", 1, 9, 9, 7, 1, 1,  false);
        AskSkillPointsView.setStats(player);
        AskSkillPointsView.display(player);
        List<Robot> robots = new ArrayList<Robot>();
        robots.add(player);
        robots.add(target);
        System.out.println("Sie haben folgenden Roboter ausgewählt: " + player.getRobotName());

        BattlefieldView.display(robots, battlefield);
        while (!player.isKnockedOut() && !target.isKnockedOut()) {
            DisplayWinnerView.display(player, target);
            int move = 1;
            while (move <= player.getMovementRange() && !player.isKnockedOut() && !target.isKnockedOut()) {
                Directions direction = MoveRobotView.turn();
                if (Battlefield.validTurn(direction, player)) {
                    player.setX(player.getX() + direction.getX());
                    player.setY(player.getY() + direction.getY());
                    move += 1;
                } else {
                    System.out.println("Zug ungültig.");
                }
                BattlefieldView.display(robots, battlefield);
                if (RobotService.inRange(player, target)) {
                    Robot.attack(player, target);
                    DisplayWinnerView.display(player, target);
                }
            }
        }

    }

}