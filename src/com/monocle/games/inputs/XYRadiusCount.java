package com.monocle.games.inputs;

/**
 * Created by visitor15 on 7/5/2016.
 */
public class XYRadiusCount extends XYRadius {

    private final int _count;

    public XYRadiusCount(int x, int y, int r, int count) {
        super(x, y, r);
        _count = count;
    }

    @Override
    public int getCount() {
        return _count;
    }
}
