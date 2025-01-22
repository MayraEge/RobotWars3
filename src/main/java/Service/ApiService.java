package Service;

import Controllers.HttpRequestController;
import Models.Robot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot";
    protected static String mapURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps";
    protected static String gameURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game";
    protected static String mapId = "";
    protected static String robotId ="";
    protected static String gameId = "";
    protected static String playerId = "";

    public String convertRobotToJson(Robot robot) {
        JsonConverter converter = new JsonConverter();
        converter.convertToJson(robot);
        return converter.getJsonInputString();
    }
    public void sendRobotToApi(Robot robot) {
        String robotJson = convertRobotToJson(robot);
        try {
            String response = HttpRequestController.sendPostRequest(botURL, robotJson);
            System.out.println("Response from API: " + response);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending robot to API: " + e.getMessage());
            e.printStackTrace();
        }
    }
        public List<Robot> getRobotsFromApi() {
        try {
            String response = HttpRequestController.sendGetRequest(botURL);
            ObjectMapper mapper = new ObjectMapper();
            Robot[] robotsArray = mapper.readValue(response, Robot[].class);
            return new ArrayList<>(List.of(robotsArray));

        } catch (IOException e) {
            System.err.println("IOException occurred while processing the response: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        } catch (InterruptedException e) {
            System.err.println("Request was interrupted: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public Robot getRobotById(String robotId) {
        try {
            String url = botURL + "/" + robotId;
            String response = HttpRequestController.sendGetRequest(url);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, Robot.class);
        } catch (IOException e) {
            return null;
        } catch (InterruptedException e) {
            System.err.println("Request was interrupted: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
