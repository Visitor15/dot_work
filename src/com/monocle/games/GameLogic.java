package com.monocle.games;

import com.monocle.models.Agent;

import java.util.Collection;

/**
 * Created by visitor15 on 7/4/2016.
 */
public interface GameLogic {

    Collection<Agent> runLogic(Input input);
}
