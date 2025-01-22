package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import Models.Robot;
import Service.ApiService;

@RestController
public class UserController {

    private static Map<String, Robot> userDatabase = new HashMap<>();
    private ApiService apiService = new ApiService();

    static {
        // Beispielroboter hinzufügen
        userDatabase.put("987654321", new Robot("987654321", "BenderRodriguez", 5, 3, 2, 5, false));
    }

    @Operation(summary = "Get user by ID", responses = {
            @ApiResponse(description = "Erfolgreich ausgeführt!", responseCode = "200", content = @Content(schema = @Schema(implementation = Robot.class))),
            @ApiResponse(description = "Benutzer nicht gefunden. ", responseCode = "404")
    })
    @GetMapping("/users/{id}")
    public ResponseEntity<Robot> getUserById(@PathVariable String id) {
        int maxAttempts = 5;
        int attempts = 0;
        Robot robot = null;

        while (attempts < maxAttempts) {
            robot = userDatabase.get(id);
            if (robot != null) {
                return ResponseEntity.ok(robot);
            }
            attempts++;
            try {
                Thread.sleep(5000); // Wartet 5 Sekunden vor dem nächsten Versuch
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Operation(summary = "Add new robot to the list", responses = {
            @ApiResponse(description = "Erfolgreich ausgeführt!", responseCode = "200", content = @Content(schema = @Schema(implementation = Robot.class))),
            @ApiResponse(description = "Fehler beim Hinzufügen des Roboters.", responseCode = "500")
    })
    @GetMapping("/addRobot")
    public ResponseEntity<List<Robot>> addRobot() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/robots";
        ResponseEntity<Robot[]> response = restTemplate.getForEntity(apiUrl, Robot[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Robot[] robotsArray = response.getBody();
            List<Robot> robotList = new ArrayList<>(List.of(robotsArray));

            // Neuen Roboter hinzufügen
            Robot newRobot = new Robot("999", "Bubberle", 4, 2, 1, 4, false);
            robotList.add(newRobot);

            return ResponseEntity.ok(robotList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Get all robots", responses = {
            @ApiResponse(description = "Erfolgreich ausgeführt!", responseCode = "200", content = @Content(schema = @Schema(implementation = Robot.class))),
            @ApiResponse(description = "Keine Roboter gefunden.", responseCode = "404")
    })
    @GetMapping("/robots")
    public ResponseEntity<List<Robot>> getAllRobots() throws IOException {
        List<Robot> robotList = apiService.getRobotsFromApi();
        if (robotList == null || robotList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(robotList);
    }
}
