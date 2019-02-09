package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongMoveException;
import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.Constant.*;
import static fr.xebia.mowItNow.utils.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    /**
     * Front move test.
     */
    @Test
    public void frontMoveTest() {

        Move move = Move.to(AVANCE);

        assertEquals(move, FRONT_MOVE);
        assertEquals(move.getCommand(), AVANCE);
    }

    /**
     * Initialize move test.
     */
    @Test
    public void initMoveTest() {

        Move move = new Move();

        assertEquals(move, FRONT_MOVE);
        assertEquals(move.getCommand(), AVANCE);
    }

    /**
     * Left move test.
     */
    @Test
    public void leftMoveTest() {
        Move move = Move.to(GAUCHE);

        assertEquals(move, LEFT_MOVE);
        assertEquals(move.getCommand(), GAUCHE);
    }

    /**
     * Right move test.
     */
    @Test
    public void rightMoveTest() {

        Move move = Move.to(DROITE);

        assertEquals(move, RIGHT_MOVE);
        assertEquals(move.getCommand(), DROITE);
    }

    /**
     * Wrong move test.
     */
    @Test
    public void wrongMoveTest() {
        assertThrows(WrongMoveException.class, () -> {
            Move.to(WRONG_MOVE);
        });

    }

}

