import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spiel")
public class GameController {
    private gameCondition gameCondition = new gameCondition();

    @PostMapping("/bewegen")
    public String moveRobot(@RequestParam int roboterId, @RequestParam String direction) {
        Robot robot = gameCondition.getRoboterById(roboterId);
        robot.move(direction);
        return "Roboter wurde bewegt";
    }

    @PostMapping("/angreifen")
    public String attack(@RequestParam int attackerId, @RequestParam int targetId) {
        Robot attacker = gameCondition.getRoboterById(angreiferId);
        Robot target = gameCondition.getRoboterById(zielId);
        attacker.attack(target);
        return "Angriff ausgeführt";
    }
}
