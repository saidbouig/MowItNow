package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.model.Move;

import static fr.xebia.mowItNow.utils.Constant.*;

public final class ConstantTest {

    private ConstantTest() {
    }

    public static final String WRONG_MOVE = "M";


    /**
     * Front move.
     */
    public static final Move FRONT_MOVE = Move.to(AVANCE);

    /**
     * Left move.
     */
    public static final Move LEFT_MOVE = Move.to(GAUCHE);

    /**
     * Right move.
     */
    public static final Move RIGHT_MOVE = Move.to(DROITE);


}
