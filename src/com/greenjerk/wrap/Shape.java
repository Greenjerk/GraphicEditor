package com.greenjerk.wrap;

import com.greenjerk.*;
import com.sun.javafx.Utils;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.sg.PGShape;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * Created by greenjerk on 21.12.14
 */
public abstract class Shape extends javafx.scene.shape.Shape {

    public abstract void draw(Double x, Double y, Double positionX, Double positionY);

    public abstract void pointInit(double x, double y, Double positionX, Double positionY, Color currentColor);

    BaseBounds computeShapeBounds(BaseBounds var1, BaseTransform var2, com.sun.javafx.geom.Shape var3) {
        if(this.impl_mode == PGShape.Mode.EMPTY) {
            return var1.makeEmpty();
        } else {
            float[] var4 = new float[]{(float) (1.0F / 0.0), (float) (1.0F / 0.0), (float) (-1.0F / 0.0), (float) (-1.0F / 0.0)};
            boolean var5 = this.impl_mode != PGShape.Mode.STROKE;
            boolean var6 = this.impl_mode != PGShape.Mode.FILL;
            if(var6 && this.getStrokeType() == StrokeType.INSIDE) {
                var5 = true;
                var6 = false;
            }

            if(var6) {
                com.sun.javafx.sg.PGShape.StrokeType var7 = this.toPGStrokeType(this.getStrokeType());
                double var8 = Utils.clampMin(this.getStrokeWidth(), 0.0D);
                com.sun.javafx.sg.PGShape.StrokeLineCap var10 = this.toPGLineCap(this.getStrokeLineCap());
                com.sun.javafx.sg.PGShape.StrokeLineJoin var11 = this.toPGLineJoin(this.getStrokeLineJoin());
                float var12 = (float)Utils.clampMin(this.getStrokeMiterLimit(), 1.0D);
                Toolkit.getToolkit().accumulateStrokeBounds(var3, var4, var7, var8, var10, var11, var12, var2);
                var4[0] = (float)((double)var4[0] - 0.5D);
                var4[1] = (float)((double)var4[1] - 0.5D);
                var4[2] = (float)((double)var4[2] + 0.5D);
                var4[3] = (float)((double)var4[3] + 0.5D);
            } else if(var5) {
                com.sun.javafx.geom.Shape.accumulate(var4, var3, var2);
            }

            if(var4[2] >= var4[0] && var4[3] >= var4[1]) {
                var1 = var1.deriveWithNewBounds(var4[0], var4[1], 0.0F, var4[2], var4[3], 0.0F);
                return var1;
            } else {
                return var1.makeEmpty();
            }
        }
    }

    BaseBounds computeBounds(BaseBounds var1, BaseTransform var2, double var3, double var5, double var7, double var9, double var11, double var13) {
        if(var11 >= 0.0D && var13 >= 0.0D) {
            double var15 = var7;
            double var17 = var9;
            double var23 = var5;
            double var19;
            double var21;
            double var25;
            double var27;
            if(var2.isTranslateOrIdentity()) {
                var19 = var11 + var7;
                var21 = var13 + var9;
                if(var2.getType() == 1) {
                    var25 = var2.getMxt();
                    var27 = var2.getMyt();
                    var15 = var7 + var25;
                    var17 = var9 + var27;
                    var19 += var25;
                    var21 += var27;
                }

                var23 = var5 + var3;
            } else {
                var15 = var7 - var3;
                var17 = var9 - var3;
                var19 = var11 + var3 * 2.0D;
                var21 = var13 + var3 * 2.0D;
                var25 = var2.getMxx();
                var27 = var2.getMxy();
                double var29 = var2.getMyx();
                double var31 = var2.getMyy();
                double var33 = var15 * var25 + var17 * var27 + var2.getMxt();
                double var35 = var15 * var29 + var17 * var31 + var2.getMyt();
                var25 *= var19;
                var27 *= var21;
                var29 *= var19;
                var31 *= var21;
                var15 = Math.min(Math.min(0.0D, var25), Math.min(var27, var25 + var27)) + var33;
                var17 = Math.min(Math.min(0.0D, var29), Math.min(var31, var29 + var31)) + var35;
                var19 = Math.max(Math.max(0.0D, var25), Math.max(var27, var25 + var27)) + var33;
                var21 = Math.max(Math.max(0.0D, var29), Math.max(var31, var29 + var31)) + var35;
            }

            var15 -= var23;
            var17 -= var23;
            var19 += var23;
            var21 += var23;
            var1 = var1.deriveWithNewBounds((float)var15, (float)var17, 0.0F, (float)var19, (float)var21, 0.0F);
            return var1;
        } else {
            return var1.makeEmpty();
        }
    }

    com.sun.javafx.sg.PGShape.StrokeType toPGStrokeType(StrokeType var1) {
        return var1 == StrokeType.INSIDE?com.sun.javafx.sg.PGShape.StrokeType.INSIDE:(var1 == StrokeType.OUTSIDE?com.sun.javafx.sg.PGShape.StrokeType.OUTSIDE:com.sun.javafx.sg.PGShape.StrokeType.CENTERED);
    }

    com.sun.javafx.sg.PGShape.StrokeLineCap toPGLineCap(StrokeLineCap var1) {
        return var1 == StrokeLineCap.SQUARE?com.sun.javafx.sg.PGShape.StrokeLineCap.SQUARE:(var1 == StrokeLineCap.BUTT?com.sun.javafx.sg.PGShape.StrokeLineCap.BUTT:com.sun.javafx.sg.PGShape.StrokeLineCap.ROUND);
    }

}
