package fr.xebia.mowItNow.service;

import fr.xebia.mowItNow.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.ConstantTest.*;
import static fr.xebia.mowItNow.utils.ConstantTest.N_0;
import static fr.xebia.mowItNow.utils.ConstantTest.WEST_DIRECTION;
import static org.junit.Assert.assertEquals;

public class MowerServiceTest {

    /**
     * Mower service.
     */
    private MowerService mowerService;

    /**
     * Test initialize.
     */
    @BeforeEach
    public void init() {
        mowerService = new MowerService(NORTH_DIRECTION, LAWN);
    }

    /**
     * Initialize position test.
     */
    @Test
    public void initPositionTest() {
        Position mowerPosition = mowerService.getPosition();
        assertEquals(mowerPosition.getX(), N_0);
        assertEquals(mowerPosition.getY(), N_0);
    }

    /**
     * Initialize direction test.
     */
    @Test
    public void initDirectionTest() {
        assertEquals(mowerService.getDirection(), NORTH_DIRECTION);
    }

    /**
     * Front command test.
     */
    @Test
    public void frontCommandTest() {
        mowerService.moveTo(FRONT_MOVE);

        Position expectedPosition = new Position(N_0, N_1);
        assertEquals(mowerService.getPosition(), expectedPosition);
    }

    /**
     * Right command test.
     */
    @Test
    public void rightCommandTest() {
        mowerService.moveTo(RIGHT_MOVE);

        Position expectedPosition = new Position(N_0, N_0);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), EAST_DIRECTION);
    }

    /**
     * Left command test.
     */
    @Test
    public void leftCommandTest() {
        mowerService.moveTo(LEFT_MOVE);

        Position expectedPosition = new Position(N_0, N_0);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), WEST_DIRECTION);
    }




}
