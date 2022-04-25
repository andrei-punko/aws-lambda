package by.andd3dfx.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonResponse {

    private String message;

    public PersonResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
