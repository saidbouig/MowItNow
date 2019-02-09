package fr.xebia.mowItNow.model;

import fr.xebia.mowItNow.exception.WrongLawnException;
import lombok.Getter;
import lombok.Setter;

import static fr.xebia.mowItNow.utils.Constant.N_0;

@Getter
@Setter
public class Lawn {

    private int topRightAbscissa;
    private int topRightOrdinate;

    public Lawn(final int x, final int y) throws WrongLawnException {
        if ((x == N_0 && y == N_0) || (x < N_0 || y < N_0)) {
            throw new WrongLawnException("Illegal coordinate top right corner of lawn");
        } else {
            this.setTopRightAbscissa(x);
            this.setTopRightOrdinate(y);
        }
    }

}
