package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongLawnException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    /**
     * Lawn attribute.
     */
    private Lawn lawn;

    /**
     * Test initialize.
     */
    @BeforeEach
    public void init() {
        lawn = new Lawn(N_3, N_3);
    }

    /**
     * Initial position test.
     */
    @Test
    public void initialPositionTest() {

        Position position = new Position(lawn);

        assertEquals(position, new Position(N_0, N_0));
        assertEquals(position.getX(), N_0);
        assertEquals(position.getY(), N_0);
    }

    /**
     * Top corner Right position test.
     */
    @Test
    public void topCornerRightPositionTest() {

        Position position = new Position(N_3, N_3, lawn);

        assertEquals(position.getX(), N_3);
        assertEquals(position.getY(), N_3);
    }

    /**
     * Set specific position test.
     */
    @Test
    public void setSpecificPositionTest() {

        Position position = new Position(N_1, N_2, lawn);

        assertEquals(position.getX(), N_1);
        assertEquals(position.getY(), N_2);
    }

    /**
     * Increment x test.
     */
    @Test
    public void incrementXTest() {

        Position position = new Position(N_1, N_2, lawn);
        position.incrementX();
        assertEquals(position.getX(), N_2);
        assertEquals(position.getY(), N_2);
        assertEquals(lawn.getTopRightAbscissa(), N_3);
        assertEquals(lawn.getTopRightOrdinate(), N_3);
    }

    /**
     * Increment y test.
     */
    @Test
    public void incrementYTest() {

        Position position = new Position(N_1, N_2, lawn);
        position.incrementY();
        assertEquals(position.getX(), N_1);
        assertEquals(position.getY(), N_3);
    }

    /**
     * Decrement x test.
     */
    @Test
    public void decrementXTest() {

        Position position = new Position(N_1, N_2, lawn);
        position.decrementX();
        assertEquals(position.getX(), N_0);
        assertEquals(position.getY(), N_2);
    }

    /**
     * Decrement y test.
     */
    @Test
    public void decrementYTest() {

        Position position = new Position(N_1, N_2, lawn);
        position.decrementY();
        assertEquals(position.getX(), N_1);
        assertEquals(position.getY(), N_1);
    }

    /**
     * Wrong increment x test.
     */
    @Test
    public void wrongIncrementXTest() {
        Position position = new Position(N_3, N_3, lawn);
        assertThrows(WrongLawnException.class, position::incrementX);

    }

    /**
     * Wrong increment Y test.
     */
    @Test
    public void wrongIncrementYTest() {
        Position position = new Position(N_3, N_3, lawn);
        assertThrows(WrongLawnException.class, position::incrementY);

    }

    /**
     * Wrong decrement x test.
     */
    @Test
    public void wrongDecrementXTest() {
        Position position = new Position(N_0, N_3, lawn);
        assertThrows(WrongLawnException.class, position::decrementX);

    }

    /**
     * Wrong decrement y test.
     */
    @Test
    public void wrongDecrementYTest() {
        Position position = new Position(N_3, N_0, lawn);
        assertThrows(WrongLawnException.class, position::decrementY);

    }

}