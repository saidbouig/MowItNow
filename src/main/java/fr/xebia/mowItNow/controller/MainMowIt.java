package fr.xebia.mowItNow.controller;

import fr.xebia.mowItNow.utils.MowerFileHelper;

public class MainMowIt {

    private MainMowIt() {
    }

    public static void main(final String[] args) {
        if (null != args && args.length > 0 && null != args[0]) {
            new MowerFileHelper(args[0]);
        } else {
            System.err.println("Please add the path of input file");
        }
    }
}
