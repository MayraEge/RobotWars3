package Service;

import com.google.gson.Gson;

public class JsonConverter {
    private String jsonInputString;
    private Gson gson;

    public JsonConverter(){
        this.gson = new Gson();
    }

    public String convertToJson(Object t) {
        if (t instanceof String) {
            jsonInputString = (String) t;
        } else {
            jsonInputString = gson.toJson(t);
        }
        return jsonInputString;
    }

    public String getJsonInputString() {
        return jsonInputString;
    }

    public Gson getGson() {
        return new Gson();
    }
}
