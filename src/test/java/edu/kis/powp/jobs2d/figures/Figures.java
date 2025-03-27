package edu.kis.powp.jobs2d.figures;

public enum Figures {
    FIG_JOE_1("Figure Joe 1"),
    FIG_JOE_2("Figure Joe 2"),
    FIG_CUSTOM("Custom Command"),
    FIG_SQUARE("Square"),
    FIR_TRIANGLE("Triangle");

    private final String figure;

    Figures(String figure){
        this.figure = figure;
    }

    public String getFigure(){
        return this.figure;
    }

}