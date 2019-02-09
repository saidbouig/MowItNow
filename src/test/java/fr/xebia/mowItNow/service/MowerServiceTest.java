package fr.xebia.mowItNow.service;

import org.junit.jupiter.api.BeforeEach;

import static fr.xebia.mowItNow.utils.ConstantTest.LAWN;
import static fr.xebia.mowItNow.utils.ConstantTest.NORTH_DIRECTION;

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

}
