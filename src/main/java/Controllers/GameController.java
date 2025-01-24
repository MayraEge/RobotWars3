package Controllers;

import Enums.Directions;
import Models.Battlefield;
import Models.Coordinates;
import Models.Robot;
import Service.RobotService;
import Service.GameService;
import Views.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.RobotsApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    private List<Robot> robotList = new ArrayList<>();
    private RobotsApi robotsApi;

    @Autowired
    private GameService gameService;


    public static void main(String[] args) throws IOException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/");
        RobotsApi robotsApi1 = new RobotsApi(apiClient);
        try {
            List<Robot> robots = robotsApi.getRobots();
            robots.forEach(robot -> System.out.println(robot.getName()));
        } catch (ApiException e) {
            System.err.println("Exception when calling RobotsApi#getRobots");
            e.printStackTrace();
        }

        IntroScreenView.display();
        Battlefield battlefield = new Battlefield(15, 10);
        String robotName = AskRobotNameView.display();
        Coordinates defaultCoordinates = new Coordinates(0, 0, 15, 10);
        Robot player = new Robot("1", robotName, 1, 1, 1, 1, false);
        Robot target = new Robot("2", "[O]", 1, 1, 1, 1, false);

        AskSkillPointsView.setStats(player);
        AskSkillPointsView.display(player);
        List<Robot> robots = new ArrayList<>();
        robots.add(player);
        robots.add(target);
        System.out.println("Sie haben folgenden Roboter ausgewählt: " + player.getName());

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
