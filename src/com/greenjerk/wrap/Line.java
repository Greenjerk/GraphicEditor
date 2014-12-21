//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.greenjerk.wrap;

import com.sun.javafx.css.StyleableProperty;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Line2D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.sg.PGLine;
import com.sun.javafx.sg.PGNode;
import com.sun.javafx.sg.PGShape.Mode;
import com.sun.javafx.tk.Toolkit;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public abstract class Line extends com.greenjerk.wrap.Shape {
    private final Line2D shape = new Line2D();
    private DoubleProperty startX;
    private DoubleProperty startY;
    private DoubleProperty endX;
    private DoubleProperty endY;

    public Line() {
        StyleableProperty var1 = StyleableProperty.getStyleableProperty(this.fillProperty());
        var1.set(this, (Object)null);
        StyleableProperty var2 = StyleableProperty.getStyleableProperty(this.strokeProperty());
        var2.set(this, Color.BLACK);
    }

    public Line(double var1, double var3, double var5, double var7) {
        StyleableProperty var9 = StyleableProperty.getStyleableProperty(this.fillProperty());
        var9.set(this, (Object)null);
        StyleableProperty var10 = StyleableProperty.getStyleableProperty(this.strokeProperty());
        var10.set(this, Color.BLACK);
        this.setStartX(var1);
        this.setStartY(var3);
        this.setEndX(var5);
        this.setEndY(var7);
    }

    public final void setStartX(double var1) {
        if(this.startX != null || var1 != 0.0D) {
            this.startXProperty().set(var1);
        }

    }

    public final double getStartX() {
        return this.startX == null?0.0D:this.startX.get();
    }

    public final DoubleProperty startXProperty() {
        if(this.startX == null) {
            this.startX = new DoublePropertyBase() {
                public void invalidated() {
                    Line.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Line.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Line.this;
                }

                public String getName() {
                    return "startX";
                }
            };
        }

        return this.startX;
    }

    public final void setStartY(double var1) {
        if(this.startY != null || var1 != 0.0D) {
            this.startYProperty().set(var1);
        }

    }

    public final double getStartY() {
        return this.startY == null?0.0D:this.startY.get();
    }

    public final DoubleProperty startYProperty() {
        if(this.startY == null) {
            this.startY = new DoublePropertyBase() {
                public void invalidated() {
                    Line.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Line.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Line.this;
                }

                public String getName() {
                    return "startY";
                }
            };
        }

        return this.startY;
    }

    public final void setEndX(double var1) {
        if(this.endX != null || var1 != 0.0D) {
            this.endXProperty().set(var1);
        }

    }

    public final double getEndX() {
        return this.endX == null?0.0D:this.endX.get();
    }

    public final DoubleProperty endXProperty() {
        if(this.endX == null) {
            this.endX = new DoublePropertyBase() {
                public void invalidated() {
                    Line.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Line.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Line.this;
                }

                public String getName() {
                    return "endX";
                }
            };
        }

        return this.endX;
    }

    public final void setEndY(double var1) {
        if(this.endY != null || var1 != 0.0D) {
            this.endYProperty().set(var1);
        }

    }

    public final double getEndY() {
        return this.endY == null?0.0D:this.endY.get();
    }

    public final DoubleProperty endYProperty() {
        if(this.endY == null) {
            this.endY = new DoublePropertyBase() {
                public void invalidated() {
                    Line.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Line.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Line.this;
                }

                public String getName() {
                    return "endY";
                }
            };
        }

        return this.endY;
    }

    /** @deprecated */
    @Deprecated
    protected PGNode impl_createPGNode() {
        return Toolkit.getToolkit().createPGLine();
    }

    PGLine getPGLine() {
        return (PGLine)this.impl_getPGNode();
    }

    /** @deprecated */
    @Deprecated
    public BaseBounds impl_computeGeomBounds(BaseBounds var1, BaseTransform var2) {
        if(this.impl_mode != Mode.FILL && this.impl_mode != Mode.EMPTY && this.getStrokeType() != StrokeType.INSIDE) {
            double var3 = this.getStartX();
            double var5 = this.getEndX();
            double var7 = this.getStartY();
            double var9 = this.getEndY();
            double var11 = this.getStrokeWidth();
            if(this.getStrokeType() == StrokeType.CENTERED) {
                var11 /= 2.0D;
            }

            double var17;
            double var19;
            double var13;
            double var15;
            if(var2.isTranslateOrIdentity()) {
                var11 = Math.max(var11, 0.5D);
                if(var2.getType() == 1) {
                    var17 = var2.getMxt();
                    var19 = var2.getMyt();
                    var3 += var17;
                    var7 += var19;
                    var5 += var17;
                    var9 += var19;
                }

                if(var7 == var9 && var3 != var5) {
                    var15 = var11;
                    var13 = this.getStrokeLineCap() == StrokeLineCap.BUTT?0.0D:var11;
                } else if(var3 == var5 && var7 != var9) {
                    var13 = var11;
                    var15 = this.getStrokeLineCap() == StrokeLineCap.BUTT?0.0D:var11;
                } else {
                    if(this.getStrokeLineCap() == StrokeLineCap.SQUARE) {
                        var11 *= Math.sqrt(2.0D);
                    }

                    var15 = var11;
                    var13 = var11;
                }

                if(var3 > var5) {
                    var17 = var3;
                    var3 = var5;
                    var5 = var17;
                }

                if(var7 > var9) {
                    var17 = var7;
                    var7 = var9;
                    var9 = var17;
                }

                var3 -= var13;
                var7 -= var15;
                var5 += var13;
                var9 += var15;
                var1 = var1.deriveWithNewBounds((float)var3, (float)var7, 0.0F, (float)var5, (float)var9, 0.0F);
                return var1;
            } else {
                var13 = var5 - var3;
                var15 = var9 - var7;
                var17 = Math.sqrt(var13 * var13 + var15 * var15);
                if(var17 == 0.0D) {
                    var13 = var11;
                    var15 = 0.0D;
                } else {
                    var13 = var11 * var13 / var17;
                    var15 = var11 * var15 / var17;
                }

                double var21;
                if(this.getStrokeLineCap() != StrokeLineCap.BUTT) {
                    var19 = var13;
                    var21 = var15;
                } else {
                    var21 = 0.0D;
                    var19 = 0.0D;
                }

                double[] var23 = new double[]{var3 - var15 - var19, var7 + var13 - var21, var3 + var15 - var19, var7 - var13 - var21, var5 + var15 + var19, var9 - var13 + var21, var5 - var15 + var19, var9 + var13 + var21};
                var2.transform(var23, 0, var23, 0, 4);
                var3 = Math.min(Math.min(var23[0], var23[2]), Math.min(var23[4], var23[6]));
                var7 = Math.min(Math.min(var23[1], var23[3]), Math.min(var23[5], var23[7]));
                var5 = Math.max(Math.max(var23[0], var23[2]), Math.max(var23[4], var23[6]));
                var9 = Math.max(Math.max(var23[1], var23[3]), Math.max(var23[5], var23[7]));
                var3 -= 0.5D;
                var7 -= 0.5D;
                var5 += 0.5D;
                var9 += 0.5D;
                var1 = var1.deriveWithNewBounds((float)var3, (float)var7, 0.0F, (float)var5, (float)var9, 0.0F);
                return var1;
            }
        } else {
            return var1.makeEmpty();
        }
    }

    /** @deprecated */
    @Deprecated
    public Line2D impl_configShape() {
        this.shape.setLine((float)this.getStartX(), (float)this.getStartY(), (float)this.getEndX(), (float)this.getEndY());
        return this.shape;
    }

    /** @deprecated */
    @Deprecated
    public void impl_updatePG() {
        super.impl_updatePG();
        if(this.impl_isDirty(DirtyBits.NODE_GEOMETRY)) {
            PGLine var1 = this.getPGLine();
            var1.updateLine((float)this.getStartX(), (float)this.getStartY(), (float)this.getEndX(), (float)this.getEndY());
        }

    }

    /** @deprecated */
    @Deprecated
    protected Paint impl_cssGetFillInitialValue() {
        return null;
    }

    /** @deprecated */
    @Deprecated
    protected Paint impl_cssGetStrokeInitialValue() {
        return Color.BLACK;
    }

    /** @deprecated */
    @Deprecated
    public static List<StyleableProperty> impl_CSS_STYLEABLES() {
        return Shape.impl_CSS_STYLEABLES();
    }

    /** @deprecated */
    @Deprecated
    public List<StyleableProperty> impl_getStyleableProperties() {
        return impl_CSS_STYLEABLES();
    }
}
