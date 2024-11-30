import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static List<JsonObject> getCommentsOfLastPostByUserId(int userId) throws IOException {
        List<JsonObject> posts = Reqests.getPostsByUserId(userId);
        int maxId = -1;
        for (JsonObject post : posts) {
            int id = post.get("id").getAsInt();
            if (id > maxId) {
                maxId = id;
            }
        }

        if (maxId == -1) {
            return new ArrayList<>();
        }

        return Reqests.getCommentsByPostId(maxId);
    }

    public static void writeCommentsOfLastPostByUserIdToFile(int userId) throws IOException {
        List<JsonObject> posts = Reqests.getPostsByUserId(userId);
        int maxId = -1;
        for (JsonObject post : posts) {
            int id = post.get("id").getAsInt();
            if (id > maxId) {
                maxId = id;
            }
        }

        if (maxId == -1) {
            return;
        }

        List<JsonObject> comments = Reqests.getCommentsByPostId(maxId);
        String fileName = "user-" + userId + "-post-" + maxId + "-comments.json";
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(comments, writer);
        }
    }
}
