import com.google.gson.JsonObject;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonObject newUser = new JsonObject();
        newUser.addProperty("name", "Valentin");
        newUser.addProperty("username", "Aphorism");
        newUser.addProperty("email", "a777mino@example.com");

        System.out.println(TaskOne.createUser(newUser));

        JsonObject updatedUser = new JsonObject();
        updatedUser.addProperty("name", "Valentin");
        updatedUser.addProperty("username", "Aphorism");
        updatedUser.addProperty("email", "a777mino@example.com");

        System.out.println("Task One");
        System.out.println(TaskOne.updateUser(1, updatedUser));
        System.out.println(TaskOne.deleteUser(1));
        System.out.println(TaskOne.getAllUsers());
        System.out.println(TaskOne.getUserById(4));
        System.out.println(TaskOne.getUserByUsername("Leopoldo_Corkery"));

        System.out.println("Task Two");
        System.out.println(TaskTwo.getCommentsOfLastPostByUserId(1));
        TaskTwo.writeCommentsOfLastPostByUserIdToFile(1);

        System.out.println("Task Three");
        System.out.println(TaskThree.getOpenTodosByUserId(1));
    }
}
