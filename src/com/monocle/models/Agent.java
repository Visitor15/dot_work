package com.monocle.models;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class Agent {

    private int _x;
    private int _y;

    public Agent() {
        _x = 0;
        _y = 0;
    }

    public Agent(final int x, final int y) {
        _x = x;
        _y = y;
    }

    public Agent updatAgent(final int x, final int y) {
        _x = x;
        _y = y;
        return this;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}
