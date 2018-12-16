package com.jc.tictactoe.controllers;

import com.jc.tictactoe.http.TurnRequest;
import com.jc.tictactoe.http.TurnResponse;
import com.jc.tictactoe.models.Player;
import com.jc.tictactoe.services.GameStateService;
import com.jc.tictactoe.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author miguel.reyes on 2018-12-16.
 */
@RestController
public class MainController {

    private final GameStateService gameStateService;
    private final PlayersService playersService;

    @Autowired
    public MainController(GameStateService gameStateService, PlayersService playersService) {
        this.gameStateService = gameStateService;
        this.playersService = playersService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers(@RequestParam(value = "id", defaultValue = "") String id) {
        return playersService.getPlayers();
    }

    @GetMapping("/state")
    public Map<String, String> getState() {
        return gameStateService.board;
    }

    @PostMapping("/turn")
    public TurnResponse turn(@RequestBody @Valid TurnRequest request) {
        if (gameStateService.isGameOver()) {
            System.out.println("Game is already over!");
            return new TurnResponse(findWinner(), gameStateService.board);
        } else {
            gameStateService.updateState(String.valueOf(request.getPosition()), playersService.getPlayer(request.getPlayerId()));
            return new TurnResponse(findWinner(), gameStateService.board);
        }
    }

    private Player findWinner() {
        String winner = gameStateService.checkWinner();
        Player playerWinner;

        if (winner != null) {
            switch (winner) {
                case "X":
                case "O":
                    playerWinner = playersService.getPlayer(winner);
                    gameStateService.endGame(true);
                    break;
                case "draw":
                    playerWinner = new Player("draw", "No one wins");
                    gameStateService.endGame(true);
                    break;
                default:
                    playerWinner = null;
            }
            return playerWinner;
        }

        return null;

    }
}
