package Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Service.ApiService;

@Service
public class GameService {

    private static String gameURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    private static String gameId = "123456";
    private static String robotId = "JeddelohBot";
    private static String playerId;

    public void joinGame() throws IOException {
        URL url = new URL(gameURL + gameId + "/join");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotId", robotId);

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println("Response Code: " + code);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            robotId = responseObject.getString("id");
            playerId = responseObject.getString("playerId");
            System.out.println(robotId);
            System.out.println(playerId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }
    }
}
