package com.greenjerk;

import com.greenjerk.wrap.Shape;
import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by greenjerk on 14.12.14
 */
public class Rectangle extends com.greenjerk.wrap.Rectangle implements Serializable {

    @Override
    public void draw(Double x, Double y, Double positionX, Double positionY) {
        setWidth(Math.abs(positionX - x));
        setHeight(Math.abs(positionY - y));
        setX(x);
        setY(y);
        if (positionX - x < 0 && positionY - y < 0) {
            setX(x + (positionX - x));
            setY(y + (positionY - y));
        } else if(positionX - x < 0) {
            setX(x + (positionX - x));
        } else if (positionY - y < 0) {
            setY(y + (positionY - y));
        }
    }

    @Override
    public void pointInit(double x, double y, Double positionX, Double positionY, Color currentColor) {
        setX(positionX);
        setY(positionY);
        setFill(null);
        setStrokeWidth((4));
        setStroke(currentColor);
    }

}
