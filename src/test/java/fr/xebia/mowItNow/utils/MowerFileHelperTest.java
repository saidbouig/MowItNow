package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.exception.WrongFileException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MowerFileHelperTest {

    /**
     * Wrong input file test.
     */
    @Test
    public void should_throw_exception_when_wrong_file_content() {
        assertThrows(WrongFileException.class, () -> {
            new MowerFileHelper(getPath("wrong_file.txt"));
        });

    }

    /**
     * Empty input file test.
     */
    @Test
    public void should_throw_exception_when_empty_file() {
        assertThrows(WrongFileException.class, () -> {
            new MowerFileHelper(getPath("empty_file.txt"));
        });

    }

    /**
     * un-existed input file test.
     */
    @Test
    public void should_throw_exception_when_file_not_exists() {
        assertThrows(NullPointerException.class, () -> {
            getPath("un_existed_file.txt");
        });

    }

    /**
     * Right input file test.
     */
    @Test
    public void should_return_correct_result_when_one_line_input() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new MowerFileHelper(getPath("right_file_1.txt"));
        assertEquals("1 3 N".trim(), outContent.toString().trim());

    }

    /**
     * Right input file test.
     */
    @Test
    public void should_return_correct_result_when_multiple_line_input() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new MowerFileHelper(getPath("right_file_2.txt"));
        assertEquals("1 3 N\n5 1 E".trim(), outContent.toString().trim());

    }


    /**
     * Right input file test 2.
     */
    @Test
    public void should_return_correct_result_when_mower_crosses_lawn() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new MowerFileHelper(getPath("right_file_3.txt"));
        assertEquals("4 4 E".trim(), outContent.toString().trim());

    }




    private String getPath(final String nameFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(nameFile).getFile());
        return file.getAbsolutePath();
    }

}