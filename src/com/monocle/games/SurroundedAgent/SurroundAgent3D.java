package com.monocle.games.SurroundedAgent;

import com.monocle.games.SurroundAgent;
import com.monocle.models.Tuple;

/**
 * Created by visitor15 on 7/5/2016.
 */
public class SurroundAgent3D extends SurroundAgent {

    private final static int MAX_INTERVAL = 10;

    private int _cursorZ = MAX_INTERVAL;

    public SurroundAgent3D() throws InterruptedException { }

    @Override
    protected Tuple getCoordinates() {
        _cursorZ = MAX_INTERVAL % (_cursorZ + 1);
        return new Tuple(0, 0, _cursorZ);
    }
}
