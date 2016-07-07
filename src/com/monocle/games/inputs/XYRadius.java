package com.monocle.games.inputs;

/**
 * Created by visitor15 on 7/5/2016.
 */
public class XYRadius extends XYInput {

    private final int _radius;

    public XYRadius(int x, int y, int r) {
        super(x, y);
        _radius = r;
    }

    @Override
    public int getRadius() {
        return _radius;
    }
}
