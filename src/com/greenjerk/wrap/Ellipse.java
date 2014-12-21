//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.greenjerk.wrap;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.sg.PGEllipse;
import com.sun.javafx.sg.PGNode;
import com.sun.javafx.sg.PGShape.Mode;
import com.sun.javafx.sg.PGShape.StrokeLineJoin;
import com.sun.javafx.tk.Toolkit;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import com.greenjerk.wrap.Shape;
import javafx.scene.shape.StrokeType;

public abstract class Ellipse extends com.greenjerk.wrap.Shape {
    private final Ellipse2D shape;
    private static final int NON_RECTILINEAR_TYPE_MASK = -72;
    private DoubleProperty centerX;
    private DoubleProperty centerY;
    private DoubleProperty radiusX;
    private DoubleProperty radiusY;

    public Ellipse() {
        this.shape = new Ellipse2D();
        this.radiusX = new DoublePropertyBase() {
            public void invalidated() {
                Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Ellipse.this.impl_geomChanged();
            }

            public Object getBean() {
                return Ellipse.this;
            }

            public String getName() {
                return "radiusX";
            }
        };
        this.radiusY = new DoublePropertyBase() {
            public void invalidated() {
                Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Ellipse.this.impl_geomChanged();
            }

            public Object getBean() {
                return Ellipse.this;
            }

            public String getName() {
                return "radiusY";
            }
        };
    }

    public Ellipse(double var1, double var3) {
        this.shape = new Ellipse2D();
        this.radiusX = new DoublePropertyBase() {
            public void invalidated() {
                Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Ellipse.this.impl_geomChanged();
            }

            public Object getBean() {
                return Ellipse.this;
            }

            public String getName() {
                return "radiusX";
            }
        };
        this.radiusY = new DoublePropertyBase() {
            public void invalidated() {
                Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Ellipse.this.impl_geomChanged();
            }

            public Object getBean() {
                return Ellipse.this;
            }

            public String getName() {
                return "radiusY";
            }
        };
        this.setRadiusX(var1);
        this.setRadiusY(var3);
    }

    public Ellipse(double var1, double var3, double var5, double var7) {
        this(var5, var7);
        this.setCenterX(var1);
        this.setCenterY(var3);
    }

    public final void setCenterX(double var1) {
        if(this.centerX != null || var1 != 0.0D) {
            this.centerXProperty().set(var1);
        }

    }

    public final double getCenterX() {
        return this.centerX == null?0.0D:this.centerX.get();
    }

    public final DoubleProperty centerXProperty() {
        if(this.centerX == null) {
            this.centerX = new DoublePropertyBase() {
                public void invalidated() {
                    Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Ellipse.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Ellipse.this;
                }

                public String getName() {
                    return "centerX";
                }
            };
        }

        return this.centerX;
    }

    public final void setCenterY(double var1) {
        if(this.centerY != null || var1 != 0.0D) {
            this.centerYProperty().set(var1);
        }

    }

    public final double getCenterY() {
        return this.centerY == null?0.0D:this.centerY.get();
    }

    public final DoubleProperty centerYProperty() {
        if(this.centerY == null) {
            this.centerY = new DoublePropertyBase() {
                public void invalidated() {
                    Ellipse.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Ellipse.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Ellipse.this;
                }

                public String getName() {
                    return "centerY";
                }
            };
        }

        return this.centerY;
    }

    public final void setRadiusX(double var1) {
        this.radiusX.set(var1);
    }

    public final double getRadiusX() {
        return this.radiusX.get();
    }

    public final DoubleProperty radiusXProperty() {
        return this.radiusX;
    }

    public final void setRadiusY(double var1) {
        this.radiusY.set(var1);
    }

    public final double getRadiusY() {
        return this.radiusY.get();
    }

    public final DoubleProperty radiusYProperty() {
        return this.radiusY;
    }

    /** @deprecated */
    @Deprecated
    protected PGNode impl_createPGNode() {
        return Toolkit.getToolkit().createPGEllipse();
    }

    PGEllipse getPGEllipse() {
        return (PGEllipse)this.impl_getPGNode();
    }

    /** @deprecated */
    @Deprecated
    protected StrokeLineJoin toPGLineJoin(javafx.scene.shape.StrokeLineJoin var1) {
        return StrokeLineJoin.BEVEL;
    }

    /** @deprecated */
    @Deprecated
    public BaseBounds impl_computeGeomBounds(BaseBounds var1, BaseTransform var2) {
        if(this.impl_mode == Mode.EMPTY) {
            return var1.makeEmpty();
        } else if((var2.getType() & -72) != 0) {
            return this.computeShapeBounds(var1, var2, this.impl_configShape());
        } else {
            double var3 = this.getCenterX() - this.getRadiusX();
            double var5 = this.getCenterY() - this.getRadiusY();
            double var7 = 2.0D * this.getRadiusX();
            double var9 = 2.0D * this.getRadiusY();
            double var11;
            double var13;
            if(this.impl_mode != Mode.FILL && this.getStrokeType() != StrokeType.INSIDE) {
                var11 = this.getStrokeWidth();
                if(this.getStrokeType() == StrokeType.CENTERED) {
                    var11 /= 2.0D;
                }

                var13 = 0.0D;
            } else {
                var13 = 0.0D;
                var11 = 0.0D;
            }

            return this.computeBounds(var1, var2, var11, var13, var3, var5, var7, var9);
        }
    }

    /** @deprecated */
    @Deprecated
    public Ellipse2D impl_configShape() {
        this.shape.setFrame((float)(this.getCenterX() - this.getRadiusX()), (float)(this.getCenterY() - this.getRadiusY()), (float)(this.getRadiusX() * 2.0D), (float)(this.getRadiusY() * 2.0D));
        return this.shape;
    }

    /** @deprecated */
    @Deprecated
    public void impl_updatePG() {
        super.impl_updatePG();
        if(this.impl_isDirty(DirtyBits.NODE_GEOMETRY)) {
            PGEllipse var1 = this.getPGEllipse();
            var1.updateEllipse((float)this.getCenterX(), (float)this.getCenterY(), (float)this.getRadiusX(), (float)this.getRadiusY());
        }

    }
}
