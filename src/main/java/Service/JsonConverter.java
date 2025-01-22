package Service;

import com.google.gson.Gson;

public class JsonConverter {
    private String jsonInputString;

    public void convertToJson(Object t) {
        if (t instanceof String) {
            jsonInputString = (String) t;
        } else {
            Gson gson = new Gson();
            jsonInputString = gson.toJson(t);
        }
    }

    public String getJsonInputString() {
        return jsonInputString;
    }

    public Gson getGson() {
        return new Gson();
    }
}
