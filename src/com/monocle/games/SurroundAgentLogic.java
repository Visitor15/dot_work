package com.monocle.games;

import com.monocle.math.Quadrant;
import com.monocle.models.Agent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class SurroundAgentLogic implements GameLogic {

    private final int _distance;

    private final int _agentCount;

    private double _theta;

    private Random _random;

    private static final Quadrant QUADRANT_I    = new Quadrant(1, 1);
    private static final Quadrant QUADRANT_II   = new Quadrant(-1, 1);
    private static final Quadrant QUADRANT_III  = new Quadrant(-1, -1);
    private static final Quadrant QUADRANT_IV   = new Quadrant(1, -1);

    public SurroundAgentLogic(final int agentCount, final int distance) {
        _random      = new Random();
        _agentCount = agentCount;
        _distance   = distance;
    }

    @Override
    public Collection<Agent> runLogic(final Input input) {
        Agent[] agents = new Agent[_random.nextInt(_agentCount - 1) + 1];
//        Agent[] agents = new Agent[_agentCount];
        _theta      = (360.0 / agents.length);
        double  beta;
        int     x, y;
        for(int i = 0; i < agents.length; i++) {
            beta        = Math.toRadians(i * _theta);
            x           = (int) (input.getX() + (_distance * Math.cos(beta)));
            y           = (int) (input.getY() + (_distance * Math.sin(beta)));
            agents[i]   = new Agent(x, y);
        }
        return Arrays.asList(agents);
    }

    private Quadrant getQuandrant(final int theta) {
        double result = theta / 90.0;
        if (result <= 1.0) {
            return QUADRANT_I;
        }
        if (result <= 2.0 && result > 1.0) {
            return QUADRANT_II;
        }
        if(result <= 3.0 && result > 2.0) {
            return QUADRANT_III;
        }
        if(result <= 4.0 && result > 3.0) {
            return QUADRANT_IV;
        }
        throw new IllegalArgumentException("No quadrant found");
    }
}
