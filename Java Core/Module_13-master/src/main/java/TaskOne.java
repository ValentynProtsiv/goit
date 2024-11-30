import com.google.gson.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class TaskOne {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static JsonObject createUser(JsonObject user) throws IOException {
        String url = BASE_URL + "/users";
        String response = Reqests.sendPostRequest(url, user.toString());
        return gson.fromJson(response, JsonObject.class);
    }

    public static JsonObject updateUser(int id, JsonObject user) throws IOException {
        String url = BASE_URL + "/users/" + id;
        String response = Reqests.sendPutRequest(url, user.toString());
        return gson.fromJson(response, JsonObject.class);
    }

    public static boolean deleteUser(int id) throws IOException {
        String url = BASE_URL + "/users/" + id;
        int responseCode = Reqests.sendDeleteRequest(url);
        return responseCode >= 200 && responseCode < 300;
    }

    public static List<JsonObject> getAllUsers() throws IOException {
        String url = BASE_URL + "/users";
        String response = Reqests.sendGetRequest(url);
        JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
        List<JsonObject> users = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            users.add(jsonElement.getAsJsonObject());
        }
        return users;
    }

    public static JsonObject getUserById(int id) throws IOException {
        String url = BASE_URL + "/users/" + id;
        String response = Reqests.sendGetRequest(url);
        return gson.fromJson(response, JsonObject.class);
    }

    public static List<JsonObject> getUserByUsername(String username) throws IOException {
        String url = BASE_URL + "/users?username=" + username;
        String response = Reqests.sendGetRequest(url);
        JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
        List<JsonObject> users = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            users.add(jsonElement.getAsJsonObject());
        }
        return users;
    }
}
