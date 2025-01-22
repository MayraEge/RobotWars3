package Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Models.Robot;
import Service.ApiService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RobotController {

    private List<Robot> robotList = new ArrayList<>();

    @Autowired
    private ApiService apiService;

    @PostMapping("/robots")
    public ResponseEntity<String> addRobot(@RequestBody Robot robot, @RequestParam int x, @RequestParam int y) {
        if (robot != null) {
            robot.setX(x);
            robot.setY(y);
            robotList.add(robot);
            return ResponseEntity.status(HttpStatus.CREATED).body("Roboter erfolgreich hinzugefügt!!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ungültiger Roboter wird nicht hinzugefügt.");
        }
    }
    @GetMapping("/robots")
    public ResponseEntity<List<Robot>> getRobots() {
        List<Robot> robots = apiService.getRobotsFromApi();
        return ResponseEntity.ok(robots);
    }
}
