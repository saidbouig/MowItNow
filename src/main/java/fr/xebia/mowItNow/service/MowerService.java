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
                if (Direction.of(NORTH).equals(direction)) {
                    this.setDirection(Direction.of(EAST));
                } else if (Direction.of(SOUTH).equals(direction)) {
                    this.setDirection(Direction.of(WEST));
                } else if (Direction.of(EAST).equals(direction)) {
                    this.setDirection(Direction.of(SOUTH));
                } else {
                    this.setDirection(Direction.of(NORTH));
                }

                break;

            case GAUCHE:
                if (Direction.of(NORTH).equals(direction)) {
                    this.setDirection(Direction.of(WEST));
                } else if (Direction.of(SOUTH).equals(direction)) {
                    this.setDirection(Direction.of(EAST));
                } else if (Direction.of(EAST).equals(direction)) {
                    this.setDirection(Direction.of(NORTH));
                } else {
                    this.setDirection(Direction.of(SOUTH));
                }
                break;

            default:
                break;

        }

    }

    @Override
    public String toString() {
        return this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection().getDirection();
    }

}
