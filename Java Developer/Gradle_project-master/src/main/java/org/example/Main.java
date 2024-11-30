package org.example;

import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "Valentyn");
        jsonObject.addProperty("lastname", "Protsiv");

        System.out.println(jsonObject);
    }
}