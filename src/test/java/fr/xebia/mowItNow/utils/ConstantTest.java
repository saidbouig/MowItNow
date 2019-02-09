package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.model.Direction;
import fr.xebia.mowItNow.model.Move;

import static fr.xebia.mowItNow.utils.Constant.*;
import static fr.xebia.mowItNow.utils.Constant.NORTH;
import static fr.xebia.mowItNow.utils.Constant.SOUTH;

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

    /**
     *  Wrong direction type.
     */
    public static final String WRONG_DIRECTION = "D";

    /**
     * North direction.
     */
    public static final Direction NORTH_DIRECTION = Direction.of(NORTH);

    /**
     * South direction.
     */
    public static final Direction SOUTH_DIRECTION = Direction.of(SOUTH);

    /**
     * East direction.
     */
    public static final Direction EAST_DIRECTION = Direction.of(EAST);

    /**
     * West direction.
     */
    public static final Direction WEST_DIRECTION = Direction.of(WEST);



}
