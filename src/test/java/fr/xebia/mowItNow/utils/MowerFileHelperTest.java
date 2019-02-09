package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.exception.WrongFileException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MowerFileHelperTest {

    /**
     * Wrong input file test.
     */
    @Test
    public void wrongFileTest() {
        assertThrows(WrongFileException.class, () -> {
            new MowerFileHelper(getPath("wrongFile.txt"));
        });

    }

    /**
     * Empty input file test.
     */
    @Test
    public void emptyFileTwoTest() {
        assertThrows(WrongFileException.class, () -> {
            new MowerFileHelper(getPath("emptyFile.txt"));
        });

    }

    private String getPath(final String nameFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(nameFile).getFile());
        return file.getAbsolutePath();
    }

}