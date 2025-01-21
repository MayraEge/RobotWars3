package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import Models.Robot;

public class ApiService {

    private static final String API_URL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/robots";

    public List<Robot> getRobotsFromApi() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        ObjectMapper mapper = new ObjectMapper();
        Robot[] robotsArray = mapper.readValue(content.toString(), Robot[].class);
        return new ArrayList<>(List.of(robotsArray));
    }
}
