package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.exception.WrongFileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static fr.xebia.mowItNow.utils.Constant.N_1;
import static fr.xebia.mowItNow.utils.Constant.N_2;

public class MowerFileHelper {
    public MowerFileHelper(final String path) throws WrongFileException {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            throw new WrongFileException(String.format("Wrong input path file parameter : %s", path));
        }
        this.parser(path);

    }

    private void parser(final String filePath) throws WrongFileException {
        String[] lines;
        try {
            Stream<String> linesStream = Files.lines(Paths.get(filePath)).filter(line -> line.length() > 0);
            lines = linesStream.toArray(String[]::new);
            linesStream.close();
        } catch (IOException e1) {
            throw new WrongFileException(String.format("Wrong input path file parameter : %s", filePath));
        }

        int count = lines.length;

        if (null == lines || count == 0) {
            throw new WrongFileException("The input file is empty");
        } else if (null != lines && (count % N_2 == 0 || count == N_1)) {
            throw new WrongFileException(String.format("Wrong input path file parameter : %s", filePath));
        } else {
            for (int i = 0; i < (count / N_2); i++) {
                //TODO: Call MowerService and process every move
            }

        }
    }
}
