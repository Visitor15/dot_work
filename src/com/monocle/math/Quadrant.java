package com.monocle.math;

/**
 * Created by visitor15 on 7/5/2016.
 */
public class Quadrant {
    private final int _x;
    private final int _y;

    public Quadrant(final int x, final int y) {
        this._x = x;
        this._y = y;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}
