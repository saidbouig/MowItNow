package fr.xebia.mowItNow.utils;

import fr.xebia.mowItNow.exception.WrongFileException;
import fr.xebia.mowItNow.model.Direction;
import fr.xebia.mowItNow.model.Lawn;
import fr.xebia.mowItNow.model.Move;
import fr.xebia.mowItNow.model.Position;
import fr.xebia.mowItNow.service.MowerService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static fr.xebia.mowItNow.utils.Constant.*;

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
                processMoves(initStartPositionFromFile(lines[N_1 + (i * N_2)]),
                        initStartDirectionFromFile(lines[N_1 + (i * N_2)]), initLawnFromFile(lines[N_0]),
                        initMovesFromFile(lines[N_2 + (i * N_2)]));
            }

        }
    }

    private void processMoves(final Position newPosition, final Direction newDirection, final Lawn initLawn,
                              final List<Move> movesList) {
        MowerService mowerService = new MowerService(newPosition, newDirection, initLawn);
        for (Move move : movesList) {
            mowerService.moveTo(move);
        }

        System.out.println(mowerService.toString());
    }

    private List<Move> initMovesFromFile(final String line) throws WrongFileException {
        String regex = "[AGD]*";
        if (checkLine(regex, line)) {
            List<Move> movesTmp;
            try {
                movesTmp = new ArrayList<>();
                for (char c : line.trim().toCharArray()) {
                    movesTmp.add(Move.to(String.valueOf(c)));
                }
                return movesTmp;

            } catch (Exception e) {
                throw new WrongFileException(String.format("Wrong input file line 3 : %s", line));
            }
        } else {
            throw new WrongFileException(String.format("Wrong input file line 3 : %s", line));
        }

    }

    private Position initStartPositionFromFile(final String line) throws WrongFileException {
        String regex = "[0-9]*\\s[0-9]*\\s[ENSW]";
        if (checkLine(regex, line)) {
            try {
                return new Position(Integer.parseInt(line.trim().split(" ")[0]),
                        Integer.parseInt(line.trim().split(" ")[1]));
            } catch (Exception e) {
                throw new WrongFileException(String.format("Wrong input file line 2 : %s", line));
            }
        } else {
            throw new WrongFileException(String.format("Wrong input file line 2 : %s", line));
        }

    }

    private Direction initStartDirectionFromFile(final String line) throws WrongFileException {
        String regex = "[0-9]*\\s[0-9]*\\s[ENSW]";
        if (checkLine(regex, line)) {
            try {
                return Direction.of(line.trim().split(" ")[2]);
            } catch (Exception e) {
                throw new WrongFileException(String.format("Wrong input file line 2 : %s", line));
            }
        } else {
            throw new WrongFileException(String.format("Wrong input file line 2 : %s", line));
        }

    }

    private Lawn initLawnFromFile(final String line) throws WrongFileException {
        String regex = "[0-9]*\\s[0-9]*";
        if (checkLine(regex, line)) {
            try {
                return new Lawn(Integer.parseInt(line.trim().split(" ")[0]),
                        Integer.parseInt(line.trim().split(" ")[1]));
            } catch (Exception e) {
                throw new WrongFileException(String.format("Wrong input file line 1 : %s", line));
            }
        } else {
            throw new WrongFileException(String.format("Wrong input file line 1 : %s", line));
        }
    }

    private boolean checkLine(final String regex, final String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line.trim());
        try {
            matcher.find();
            return matcher.group(0).equals(line.trim());
        } catch (Exception e) {
            return false;
        }
    }
}
