package fr.xebia.mowItNow.model;

import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.Constant.*;
import static fr.xebia.mowItNow.utils.Constant.WEST;
import static fr.xebia.mowItNow.utils.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    /**
     * North direction test.
     */
    @Test
    public void northDirectionTest() {

        Direction direction = Direction.of(NORTH);

        assertEquals(direction, NORTH_DIRECTION);
        assertEquals(direction.getDirection(), NORTH);
    }

    /**
     * South direction test.
     */
    @Test
    public void southDirectionTest() {
        Direction direction = Direction.of(SOUTH);

        assertEquals(direction, SOUTH_DIRECTION);
        assertEquals(direction.getDirection(), SOUTH);
    }

    /**
     * East direction test.
     */
    @Test
    public void eastDirectionTest() {

        Direction direction = Direction.of(EAST);

        assertEquals(direction, EAST_DIRECTION);
        assertEquals(direction.getDirection(), EAST);
    }

    /**
     * West direction test.
     */
    @Test
    public void westDirectionTest() {

        Direction direction = Direction.of(WEST);

        assertEquals(direction, WEST_DIRECTION);
        assertEquals(direction.getDirection(), WEST);
    }


}
