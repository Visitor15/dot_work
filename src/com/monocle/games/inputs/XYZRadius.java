package com.monocle.games.inputs;

/**
 * Created by visitor15 on 7/5/2016.
 */
public class XYZRadius extends XYRadiusCount {

    private final int _z;

    public XYZRadius(int x, int y, int z, int r, int count) {
        super(x, y, r, count);
        _z = z;
    }

    @Override
    public int getZ() {
        return _z;
    }
}
