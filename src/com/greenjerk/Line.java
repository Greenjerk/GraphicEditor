package com.greenjerk;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by greenjerk on 14.12.14
 */

public class Line extends com.greenjerk.wrap.Line implements Serializable {

    @Override
    public void draw(Double x, Double y, Double positionX, Double positionY) {
        setEndX(x);
        setEndY(y);
    }

    @Override
    public void pointInit(double x, double y, Double positionX, Double positionY, Color currentColor) {
        setStartX(x);
        setStartY(y);
        setEndX(x);
        setEndY(y);
        setFill(null);
        setStroke(currentColor);
        setStrokeWidth(4);
    }

}
