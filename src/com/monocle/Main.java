package com.monocle;

import com.monocle.games.Game;
import com.monocle.games.SurroundAgent;
import com.monocle.games.SurroundedAgent.SurroundAgent3D;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game surroundGame = new SurroundAgent3D();
        surroundGame.createGame();
    }
}
