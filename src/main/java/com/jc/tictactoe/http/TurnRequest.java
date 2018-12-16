package com.jc.tictactoe.http;

import javax.validation.constraints.*;

/**
 * @author miguel.reyes on 2018-12-16.
 */
public class TurnRequest {

    @Size(max = 1, message = "Value should be 'x' or 'o'.")
    @NotBlank
    private String playerId;

    @Max(8)
    @Min(0)
    @NotNull
    private Integer position;

    @Override
    public String toString() {
        return "TurnRequest{" +
                "playerId='" + playerId + '\'' +
                ", position=" + position +
                '}';
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
