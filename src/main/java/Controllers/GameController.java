package Controllers;

import Enums.Directions;
import Models.Battlefield;
import Models.Robot;
import Service.RobotService;
import Service.GameService;
import Views.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    private List<Robot> robotList = new ArrayList<>();

    @Autowired
    private GameService gameService;

    @PostMapping("/robots")
    public ResponseEntity<String> addRobot(@RequestBody Robot robot) {
        if (robot != null) {
            robotList.add(robot);
            try{
                gameService.joinGame();
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fehler beim Betreten des Spiels!");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Roboter erfolgreich hinzgefügt!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ungültige Roboter Daten");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String response = HttpRequestController.sendGetRequest("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/");
        System.out.println(response);
        IntroScreenView.display();
        Battlefield battlefield = new Battlefield(15, 10);
        String robotName = AskRobotNameView.display();
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
