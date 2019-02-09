package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongMoveException;
import lombok.Getter;

import java.util.Objects;

import static fr.xebia.mowItNow.utils.Constant.*;

@Getter
public final class Move {

    private final String command;

    public Move() {
        command = AVANCE;
    }

    public static Move to(final String command) {
        return new Move(command);
    }

    private Move(final String newCommand) throws WrongMoveException {
        if (newCommand.equals(AVANCE) || newCommand.equals(DROITE) || newCommand.equals(GAUCHE)) {
            this.command = newCommand;
        } else {
            throw new WrongMoveException(String.format("Move command %s is not supported", newCommand));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Move that = (Move) o;
        return Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}
