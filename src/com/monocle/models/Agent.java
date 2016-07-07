package com.monocle.models;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class Agent {

    private int _x;
    private int _y;
    private int _z;

    public Agent() {
        _x = 0;
        _y = 0;
        _z = 0;
    }

    public Agent(final int x, final int y) {
        _x = x;
        _y = y;
        _z = 0;
    }

    public Agent(final int x, final int y, final int z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public Agent updatAgent(final int x, final int y, final int z) {
        _x = x;
        _y = y;
        _z = z;
        return this;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}
