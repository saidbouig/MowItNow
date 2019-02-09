package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongLawnException;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static fr.xebia.mowItNow.utils.Constant.N_0;
import static fr.xebia.mowItNow.utils.Constant.N_1;

@Getter
@Setter
public class Position {

    private int x;
    private int y;
    private Lawn lawn;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position(final int x, final int y, final Lawn lawn) {
        this.x = x;
        this.y = y;
        this.lawn = lawn;
    }

    public Position(final Lawn initLawn) {
        this.x = 0;
        this.y = 0;
        this.lawn = initLawn;
    }

    public void incrementX() throws WrongLawnException {

        if ((this.x + N_1) < N_0 || this.lawn.getTopRightAbscissa() < (this.x + 1)) {
            throw new WrongLawnException(String.format("Position (%s, %s) out of bounds: ", this.x, this.y));
        }
        this.x++;
    }

    public void decrementX() throws WrongLawnException {

        if ((this.x - N_1) < N_0 || this.lawn.getTopRightAbscissa() < (this.x - 1)) {
            throw new WrongLawnException(String.format("Position (%s, %s) out of bounds: ", this.x, this.y));
        }
        this.x--;
    }

    public void incrementY() throws WrongLawnException {

        if ((this.y + N_1) < N_0 || this.lawn.getTopRightAbscissa() < (this.y + N_1)) {
            throw new WrongLawnException(String.format("Position (%s, %s) out of bounds: ", this.x, this.y));
        }
        this.y++;
    }

    public void decrementY() throws WrongLawnException {

        if ((this.y - N_1) < N_0 || this.lawn.getTopRightAbscissa() < (this.y - N_1)) {
            throw new WrongLawnException(String.format("Position (%s, %s) out of bounds: ", this.x, this.y));
        }
        this.y--;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return (x == position.x && y == position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
