import com.google.gson.JsonObject;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class TaskThree {
    public static List<JsonObject> getOpenTodosByUserId(int userId) throws IOException {
        List<JsonObject> todos = Reqests.getTodosByUserId(userId);
        List<JsonObject> openTodos = new ArrayList<>();
        for (JsonObject todo : todos) {
            if (!todo.get("completed").getAsBoolean()) {
                openTodos.add(todo);
            }
        }
        return openTodos;
    }
}
