package com.jc.tictactoe.services;

import com.jc.tictactoe.exceptions.PlayerNotFoundException;
import com.jc.tictactoe.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author miguel.reyes on 2018-12-16.
 */
@Service
public class PlayersService {

    List<Player> players;

    public PlayersService() {
        players = new ArrayList<>(2);
        players.add(new Player("X", "Player 1"));
        players.add(new Player("O", "Player 2"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(String player) {
        List<Player> collect = players.stream()
                .filter(e -> e.getId().equals(player))
                .collect(Collectors.toList());
        if (collect.size() > 0) {
            return collect.get(0);
        }
        throw new PlayerNotFoundException("Player " + player + " not found");
    }


}
