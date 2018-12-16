package com.jc.tictactoe.models;

/**
 * @author miguel.reyes on 2018-12-16.
 */
public class Player {
    private final String id;
    private final String description;

    public Player(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
