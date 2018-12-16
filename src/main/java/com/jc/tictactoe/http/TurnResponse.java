package com.jc.tictactoe.http;

import com.jc.tictactoe.models.Player;

import java.util.Map;

/**
 * @author miguel.reyes on 2018-12-16.
 */
public class TurnResponse {
    public Boolean gameOver = false;
    public Player winner;
    public Map<String, String> state;

    public TurnResponse(Player winner, Map<String, String> state) {
        if(winner != null) {
            this.winner = winner;
            this.gameOver = true;
        }
        this.state = state;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setState(Map<String, String> state) {
        this.state = state;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public Map<String, String> getState() {
        return state;
    }


}
