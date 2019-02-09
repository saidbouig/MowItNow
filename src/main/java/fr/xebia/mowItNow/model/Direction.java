package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongDirectionException;
import lombok.Getter;

import java.util.Objects;

import static fr.xebia.mowItNow.utils.Constant.*;

@Getter
public final class Direction {

    private final String direction;

    private Direction(final String newDirection) throws WrongDirectionException {
        if (newDirection.equals(NORTH) || newDirection.equals(SOUTH) || newDirection.equals(EAST)
                || newDirection.equals(WEST)) {
            this.direction = newDirection;
        } else {
            throw new WrongDirectionException(String.format("Direction %s is not supported", newDirection));
        }
    }

    public static Direction of(final String direction) {
        return new Direction(direction);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction that = (Direction) o;
        return Objects.equals(direction, that.direction);
    }

}