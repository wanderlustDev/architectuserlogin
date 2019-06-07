package com.project.architect.userlogin.enums;

public enum Message {
    USER_ALREADY_EXISTS("error", "Oops! This username " +
            "exists already. Please select a different username!"),
    SUCCESS("success", "Congratulations! You have successfully been registered!!!"),
    VALIDATION_ERRORS("error", "Validation Failed");

    String message;
    String name;

    Message(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String value() {
        return name;
    }
    public String message() {
        return message;
    }
}
