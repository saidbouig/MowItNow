package fr.xebia.mowItNow.service;

import fr.xebia.mowItNow.model.Direction;
import fr.xebia.mowItNow.model.Lawn;
import fr.xebia.mowItNow.model.Move;
import fr.xebia.mowItNow.model.Position;
import lombok.Getter;
import lombok.Setter;

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

    }

    @Override
    public String toString() {
        return this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection().getDirection();
    }

}
