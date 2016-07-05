package com.monocle;

import com.monocle.games.Game;
import com.monocle.games.SurroundAgent;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class Main {

    public static void main(String[] args) {
        Game surroundGame = new SurroundAgent();
        surroundGame.createGame();
    }
}
