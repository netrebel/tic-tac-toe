Tic Tac Toe - API

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [How to run](#how-to-run)
- [Endpoints](#endpoints)
	- [1. GET /state](#1-get-state)
	- [2. GET /players](#2-get-players)
	- [3. POST /turn](#3-post-turn)
		- [Sample request](#sample-request)
		- [Sample response - Ongoing game](#sample-response-ongoing-game)
		- [Sample response - Game finished](#sample-response-game-finished)
- [TODOs](#todos)

<!-- /TOC -->

This Tic Tac Toe game has a grid of 3x3, the playerIds are "X" and "O". At the moment, it doesn't validate the player turns, i.e. any player can take more than one turn at a time.

This API exposes three endpoints:

 1. GET /state
 2. GET /players
 3. POST /turn
 
# How to run

```bash
$ ./gradlew build && java -jar build/libs/tictactoe-0.0.1-SNAPSHOT.jar
```

# Endpoints

## 1. GET /state
Returns the current state of the board as a Map of String key and values. _key_ is the position and _value_ is the playerId.

**Sample response**

Initial state is:
```json
{
    "0": null,
    "1": null,
    "2": null,
    "3": null,
    "4": null,
    "5": null,
    "6": null,
    "7": null,
    "8": null,
    "9": null
}
```

## 2. GET /players
Returns a list of the available players.

**Sample response**
```json
[
    {
        "id": "X",
        "description": "Player 1"
    },
    {
        "id": "O",
        "description": "Player 2"
    }
]
``` 

## 3. POST /turn 
Called every time a player takes a turn on the board.

### Sample request

There are validations on both fields used in the POST payload.

```json
{
	"playerId" : "X",
	"position" : 5
}
```

### Sample response - Ongoing game

`gameOver` field will be false as long as the game is ongoing.

```json
{
    "gameOver": false,
    "winner": null,
    "state": {
        "0": null,
        "1": null,
        "2": null,
        "3": null,
        "4": null,
        "5": "X",
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

### Sample response - Game finished

Once there is a winner POST requests will still be 200 and return the winner, but they will not affect the state of the board.

  - `gameOver` - true once there is a winner in the game.
  - `winner` - contains the winner.
 

```json
{
    "gameOver": true,
    "winner": {
        "id": "X",
        "description": "Player 1"
    },
    "state": {
        "0": "X",
        "1": "X",
        "2": "X",
        "3": "O",
        "4": "O",
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    }
}
```

# TODOs

- Validate that players take alternate turns.
- Endpoint to reset the game