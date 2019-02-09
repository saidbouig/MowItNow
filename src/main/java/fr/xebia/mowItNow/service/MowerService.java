package fr.xebia.mowItNow.service;

import fr.xebia.mowItNow.exception.WrongLawnException;
import fr.xebia.mowItNow.model.Direction;
import fr.xebia.mowItNow.model.Lawn;
import fr.xebia.mowItNow.model.Move;
import fr.xebia.mowItNow.model.Position;
import lombok.Getter;
import lombok.Setter;

import static fr.xebia.mowItNow.utils.Constant.*;

@Getter
@Setter
public class MowerService {

    private Position position;
    private Direction direction;
    private Lawn lawn;

    public MowerService(final Direction startDirection, final Lawn initLawn) {
        this.position = new Position(initLawn);
        this.direction = startDirection;
    }

    public MowerService(final Position startPosition, final Direction startDirection, final Lawn initLawn) {
        this.setPosition(startPosition);
        this.getPosition().setLawn(initLawn);
        this.setDirection(startDirection);
    }

    public MowerService(final Position startPosition, final Direction startDirection) {
        this.setPosition(startPosition);
        this.setDirection(startDirection);
    }

    public void moveTo(final Move move) {

        switch (move.getCommand()) {
            case AVANCE:
                try {
                    if (Direction.of(NORTH).equals(direction)) {
                        this.getPosition().incrementY();
                    } else if (Direction.of(SOUTH).equals(direction)) {
                        this.getPosition().decrementY();
                    } else if (Direction.of(EAST).equals(direction)) {
                        this.getPosition().incrementX();
                    } else {
                        this.getPosition().decrementX();
                    }
                } catch (WrongLawnException e) {
                    assert e.getMessage().equals(String.format("Position (%s, %s) out of bounds: ",
                            this.getPosition().getX(), this.getPosition().getY()));
                }

                break;

            case DROITE:
                switchDirection(EAST, WEST, SOUTH, NORTH);

                break;

            case GAUCHE:
                switchDirection(WEST, EAST, NORTH, SOUTH);
                break;

            default:
                break;

        }

    }

    private void switchDirection(String east, String west, String south, String north) {
        if (Direction.of(NORTH).equals(direction)) {
            this.setDirection(Direction.of(east));
        } else if (Direction.of(SOUTH).equals(direction)) {
            this.setDirection(Direction.of(west));
        } else if (Direction.of(EAST).equals(direction)) {
            this.setDirection(Direction.of(south));
        } else {
            this.setDirection(Direction.of(north));
        }
    }

    @Override
    public String toString() {
        return this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection().getDirection();
    }

}
