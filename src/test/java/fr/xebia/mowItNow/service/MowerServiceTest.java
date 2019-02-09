package fr.xebia.mowItNow.service;

import fr.xebia.mowItNow.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.ConstantTest.*;
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

    /**
     * Many commands test.
     */
    @Test
    public void manyCommandsTest() {

        /* Scenario 1 : input (3 4 N), output (2 6 N) */
        Position startPosition = new Position(N_3, N_4);
        mowerService = new MowerService(startPosition, NORTH_DIRECTION, LAWN);

        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        Position expectedPosition = new Position(N_2, N_6);

        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), NORTH_DIRECTION);

        /* Scenario 2 : input (1 4 E), output (3 1 S) */
        startPosition = new Position(N_1, N_4);
        mowerService = new MowerService(startPosition, EAST_DIRECTION, LAWN);

        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_3, N_1);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), SOUTH_DIRECTION);

        /* Scenario 3 : input (1 1 W), output (1 1 W) */
        startPosition = new Position(N_1, N_1);
        mowerService = new MowerService(startPosition, WEST_DIRECTION, LAWN);

        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_1, N_1);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), WEST_DIRECTION);

        /* Scenario 4 : input (3 4 S), output (1 5 N) */
        startPosition = new Position(N_3, N_4);
        mowerService = new MowerService(startPosition, SOUTH_DIRECTION, LAWN);

        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_1, N_5);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), NORTH_DIRECTION);

        /* Scenario 5 : input (3 4 W), output (3 3 S) */
        startPosition = new Position(N_3, N_4);
        mowerService = new MowerService(startPosition, WEST_DIRECTION, LAWN);

        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_3, N_3);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), SOUTH_DIRECTION);

        /* Scenario 6 : input (3 4 S), output (4 4 E) */
        startPosition = new Position(N_3, N_4);
        mowerService = new MowerService(startPosition, SOUTH_DIRECTION, LAWN);

        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_4, N_4);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), EAST_DIRECTION);

        /* Scenario 7 : input (1 2 N), output (1 3 N) */
        startPosition = new Position(N_1, N_2);
        mowerService = new MowerService(startPosition, NORTH_DIRECTION, LAWN);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(LEFT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_1, N_3);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), NORTH_DIRECTION);

        /* Scenario 8 : input (3 3 S), output (5 1 E) */
        startPosition = new Position(N_3, N_3);
        mowerService = new MowerService(startPosition, EAST_DIRECTION, LAWN);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(RIGHT_MOVE);
        mowerService.moveTo(FRONT_MOVE);

        expectedPosition = new Position(N_5, N_1);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), EAST_DIRECTION);

    }

    /**
     * Wrong mowItNow move test.
     */
    @Test
    public void wrongMowerTest() {
        Position startPosition = new Position(N_6, N_5);
        mowerService = new MowerService(startPosition, EAST_DIRECTION, LAWN);
        mowerService.moveTo(FRONT_MOVE);
        Position expectedPosition = new Position(N_6, N_5);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), EAST_DIRECTION);

        startPosition = new Position(N_4, N_6);
        mowerService = new MowerService(startPosition, NORTH_DIRECTION, LAWN);
        mowerService.moveTo(FRONT_MOVE);
        expectedPosition = new Position(N_4, N_6);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), NORTH_DIRECTION);

        startPosition = new Position(N_0, N_2);
        mowerService = new MowerService(startPosition, WEST_DIRECTION, LAWN);
        mowerService.moveTo(FRONT_MOVE);
        expectedPosition = new Position(N_0, N_2);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), WEST_DIRECTION);

        startPosition = new Position(N_3, N_0);
        mowerService = new MowerService(startPosition, SOUTH_DIRECTION, LAWN);
        mowerService.moveTo(FRONT_MOVE);
        expectedPosition = new Position(N_3, N_0);
        assertEquals(mowerService.getPosition(), expectedPosition);
        assertEquals(mowerService.getDirection(), SOUTH_DIRECTION);
    }

}
