package Service;

import Models.Robot;
import Models.NewRobot;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.GamesApi;
import io.swagger.client.api.RobotsApi;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot";
    protected static String mapURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps";
    protected static String gameURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game";
    protected static String mapId = "";
    protected static String robotId = "";
    protected static String gameId = "";
    protected static String playerId = "";

    private RobotsApi robotsApi;
    private GamesApi gamesApi;

    public ApiService() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(baseURL);
        this.robotsApi = new RobotsApi(apiClient);
        this.gamesApi = new GamesApi(apiClient);
    }

    public String convertRobotToJson(Robot robot) {
        JsonConverter converter = new JsonConverter();
        return converter.convertToJson(robot);
    }

    public void sendRobotToApi(NewRobot newRobot) {
        JsonConverter converter = new JsonConverter();
        String robotJson = converter.convertToJson(newRobot);
        if (robotJson != null){
            try {
                robotsApi.addRobot(robotJson); // API-Aufruf zum Hinzufügen des Roboters
                System.out.println("Robot successfully sent to API");
            } catch (ApiException e) {
                System.err.println("Error sending robot to API: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("Error converting robot to JSON");
        }
    }

    public List<Robot> getRobotsFromApi() {
        try {
            return robotsApi.getRobots();
            } catch (ApiException e) {
                System.err.println("Error getting robots from API: " + e.getMessage());
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
    }

    public Robot getRobotById(String robotId) {
        try {
            return robotsApi.getRobotById(robotId);
        } catch (ApiException e) {
            System.err.println("Error getting robot by ID from API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
public void joinGame(String gameId, String playerId, String robotId) {
    try {
        JoinGame joinGame = new JoinGame(gameId, playerId, robotId);
        gamesApi.joinGame(gameId, joinGame); // API-Aufruf zum Beitreten des Spiels
        System.out.println("Successfully joined the game");
    } catch (ApiException e) {
        System.err.println("Error joining the game: " + e.getMessage());
        e.printStackTrace();
    }
}


