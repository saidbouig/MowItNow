package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongLawnException;
import org.junit.jupiter.api.Test;

import static fr.xebia.mowItNow.utils.Constant.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LawnTest {

    /**
     * Right lawn test.
     */
    @Test
    public void rightLawnTest() {

        Lawn lawn = new Lawn(N_6, N_5);
        assertEquals(lawn.getTopRightAbscissa(), N_6);
        assertEquals(lawn.getTopRightOrdinate(), N_5);
    }

    /**
     * Wrong lawn test.
     */
    @Test
    public void wrongLawnTest() {
        assertThrows(WrongLawnException.class, () -> {
            new Lawn(N_0, N_0);
        });

        assertThrows(WrongLawnException.class, () -> {
            new Lawn(N_M7, N_0);
        });
        assertThrows(WrongLawnException.class, () -> {
            new Lawn(N_0, N_M7);
        });
        assertThrows(WrongLawnException.class, () -> {
            new Lawn(N_M7, N_M7);
        });

    }

}