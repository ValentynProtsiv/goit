import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class Reqests {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static List<JsonObject> getPostsByUserId(int userId) throws IOException {
        String url = BASE_URL + "/users/" + userId + "/posts";
        String response = sendGetRequest(url);
        JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
        List<JsonObject> posts = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            posts.add(jsonElement.getAsJsonObject());
        }
        return posts;
    }

    public static List<JsonObject> getCommentsByPostId(int postId) throws IOException {
        String url = BASE_URL + "/posts/" + postId + "/comments";
        String response = sendGetRequest(url);
        JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
        List<JsonObject> comments = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            comments.add(jsonElement.getAsJsonObject());
        }
        return comments;
    }

    public static List<JsonObject> getTodosByUserId(int userId) throws IOException {
        String url = BASE_URL + "/users/" + userId + "/todos";
        String response = sendGetRequest(url);
        JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
        List<JsonObject> todos = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            todos.add(jsonElement.getAsJsonObject());
        }
        return todos;
    }

    public static String sendGetRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        if (responseCode >= 200 && responseCode < 300) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            throw new IOException("Failed to send GET request: " + responseCode);
        }
    }

    public static String sendPostRequest(String url, String body) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = body.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();

        if (responseCode >= 200 && responseCode < 300) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            throw new IOException("Failed to send POST request: " + responseCode);
        }
    }

    public static String sendPutRequest(String url, String body) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("PUT");

        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = body.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();

        if (responseCode >= 200 && responseCode < 300) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            throw new IOException("Failed to send PUT request: " + responseCode);
        }
    }

    public static int sendDeleteRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("DELETE");

        return con.getResponseCode();
    }
}
