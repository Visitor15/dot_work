package com.monocle.games.inputs;

import com.monocle.games.Input;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class XYInput implements Input {

    private final int _x;
    private final int _y;

    public XYInput(final int x, final int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}
