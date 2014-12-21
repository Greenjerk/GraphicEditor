package com.greenjerk;

import com.greenjerk.wrap.Shape;
import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by greenjerk on 14.12.14
 */
public class Ellipse extends com.greenjerk.wrap.Ellipse implements Serializable {

    @Override
    public void draw(Double x, Double y, Double positionX, Double positionY) {
        setRadiusX(Math.abs(positionX - x) / 2);
        setRadiusY(Math.abs(positionY - y) / 2);
        setCenterX(x + ((positionX - x) / 2));
        setCenterY(y + ((positionY - y) / 2));
    }

    @Override
    public void pointInit(double x, double y, Double positionX, Double positionY, Color currentColor) {
        setCenterX(positionX);
        setCenterY(positionY);
        setFill(null);
        setStrokeWidth((4));
        setStroke(currentColor);
    }

}
