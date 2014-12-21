//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.greenjerk.wrap;

import com.sun.javafx.css.StyleableDoubleProperty;
import com.sun.javafx.css.StyleableProperty;
import com.sun.javafx.css.converters.SizeConverter;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.RoundRectangle2D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.sg.PGNode;
import com.sun.javafx.sg.PGRectangle;
import com.sun.javafx.sg.PGShape.Mode;
import com.sun.javafx.sg.PGShape.StrokeLineJoin;
import com.sun.javafx.tk.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.value.WritableValue;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import com.greenjerk.wrap.Shape;
import javafx.scene.shape.StrokeType;

public abstract class Rectangle extends com.greenjerk.wrap.Shape {
    private final RoundRectangle2D shape;
    private static final int NON_RECTILINEAR_TYPE_MASK = -72;
    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty width;
    private DoubleProperty height;
    private DoubleProperty arcWidth;
    private DoubleProperty arcHeight;

    public Rectangle() {
        this.shape = new RoundRectangle2D();
        this.width = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "width";
            }
        };
        this.height = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "height";
            }
        };
    }

    public Rectangle(double var1, double var3) {
        this.shape = new RoundRectangle2D();
        this.width = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "width";
            }
        };
        this.height = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "height";
            }
        };
        this.setWidth(var1);
        this.setHeight(var3);
    }

    public Rectangle(double var1, double var3, Paint var5) {
        this.shape = new RoundRectangle2D();
        this.width = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "width";
            }
        };
        this.height = new DoublePropertyBase() {
            public void invalidated() {
                Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                Rectangle.this.impl_geomChanged();
            }

            public Object getBean() {
                return Rectangle.this;
            }

            public String getName() {
                return "height";
            }
        };
        this.setWidth(var1);
        this.setHeight(var3);
        this.setFill(var5);
    }

    public Rectangle(double var1, double var3, double var5, double var7) {
        this(var5, var7);
        this.setX(var1);
        this.setY(var3);
    }

    public final void setX(double var1) {
        if(this.x != null || var1 != 0.0D) {
            this.xProperty().set(var1);
        }

    }

    public final double getX() {
        return this.x == null?0.0D:this.x.get();
    }

    public final DoubleProperty xProperty() {
        if(this.x == null) {
            this.x = new DoublePropertyBase() {
                public void invalidated() {
                    Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Rectangle.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Rectangle.this;
                }

                public String getName() {
                    return "x";
                }
            };
        }

        return this.x;
    }

    public final void setY(double var1) {
        if(this.y != null || var1 != 0.0D) {
            this.yProperty().set(var1);
        }

    }

    public final double getY() {
        return this.y == null?0.0D:this.y.get();
    }

    public final DoubleProperty yProperty() {
        if(this.y == null) {
            this.y = new DoublePropertyBase() {
                public void invalidated() {
                    Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    Rectangle.this.impl_geomChanged();
                }

                public Object getBean() {
                    return Rectangle.this;
                }

                public String getName() {
                    return "y";
                }
            };
        }

        return this.y;
    }

    public final void setWidth(double var1) {
        this.width.set(var1);
    }

    public final double getWidth() {
        return this.width.get();
    }

    public final DoubleProperty widthProperty() {
        return this.width;
    }

    public final void setHeight(double var1) {
        this.height.set(var1);
    }

    public final double getHeight() {
        return this.height.get();
    }

    public final DoubleProperty heightProperty() {
        return this.height;
    }

    public final void setArcWidth(double var1) {
        if(this.arcWidth != null || var1 != 0.0D) {
            this.arcWidthProperty().set(var1);
        }

    }

    public final double getArcWidth() {
        return this.arcWidth == null?0.0D:this.arcWidth.get();
    }

    public final DoubleProperty arcWidthProperty() {
        if(this.arcWidth == null) {
            this.arcWidth = new StyleableDoubleProperty() {
                public void invalidated() {
                    Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                }

                public StyleableProperty getStyleableProperty() {
                    return Rectangle.StyleableProperties.ARC_WIDTH;
                }

                public Object getBean() {
                    return Rectangle.this;
                }

                public String getName() {
                    return "arcWidth";
                }
            };
        }

        return this.arcWidth;
    }

    public final void setArcHeight(double var1) {
        if(this.arcHeight != null || var1 != 0.0D) {
            this.arcHeightProperty().set(var1);
        }

    }

    public final double getArcHeight() {
        return this.arcHeight == null?0.0D:this.arcHeight.get();
    }

    public final DoubleProperty arcHeightProperty() {
        if(this.arcHeight == null) {
            this.arcHeight = new StyleableDoubleProperty() {
                public void invalidated() {
                    Rectangle.this.impl_markDirty(DirtyBits.NODE_GEOMETRY);
                }

                public StyleableProperty getStyleableProperty() {
                    return Rectangle.StyleableProperties.ARC_HEIGHT;
                }

                public Object getBean() {
                    return Rectangle.this;
                }

                public String getName() {
                    return "arcHeight";
                }
            };
        }

        return this.arcHeight;
    }

    /** @deprecated */
    @Deprecated
    protected PGNode impl_createPGNode() {
        return Toolkit.getToolkit().createPGRectangle();
    }

    PGRectangle getPGRect() {
        return (PGRectangle)this.impl_getPGNode();
    }

    /** @deprecated */
    @Deprecated
    public static List<StyleableProperty> impl_CSS_STYLEABLES() {
        return Rectangle.StyleableProperties.STYLEABLES;
    }

    /** @deprecated */
    @Deprecated
    public List<StyleableProperty> impl_getStyleableProperties() {
        return impl_CSS_STYLEABLES();
    }

    /** @deprecated */
    @Deprecated
    protected StrokeLineJoin toPGLineJoin(javafx.scene.shape.StrokeLineJoin var1) {
        return this.getArcWidth() > 0.0D && this.getArcHeight() > 0.0D?StrokeLineJoin.BEVEL:super.toPGLineJoin(var1);
    }

    /** @deprecated */
    @Deprecated
    public BaseBounds impl_computeGeomBounds(BaseBounds var1, BaseTransform var2) {
        if(this.impl_mode == Mode.EMPTY) {
            return var1.makeEmpty();
        } else if(this.getArcWidth() > 0.0D && this.getArcHeight() > 0.0D && (var2.getType() & -72) != 0) {
            return this.computeShapeBounds(var1, var2, this.impl_configShape());
        } else {
            double var3;
            double var5;
            if(this.impl_mode != Mode.FILL && this.getStrokeType() != StrokeType.INSIDE) {
                var3 = this.getStrokeWidth();
                if(this.getStrokeType() == StrokeType.CENTERED) {
                    var3 /= 2.0D;
                }

                var5 = 0.0D;
            } else {
                var5 = 0.0D;
                var3 = 0.0D;
            }

            return this.computeBounds(var1, var2, var3, var5, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    /** @deprecated */
    @Deprecated
    public RoundRectangle2D impl_configShape() {
        if(this.getArcWidth() > 0.0D && this.getArcHeight() > 0.0D) {
            this.shape.setRoundRect((float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight(), (float)this.getArcWidth(), (float)this.getArcHeight());
        } else {
            this.shape.setRoundRect((float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight(), 0.0F, 0.0F);
        }

        return this.shape;
    }

    /** @deprecated */
    @Deprecated
    public void impl_updatePG() {
        super.impl_updatePG();
        if(this.impl_isDirty(DirtyBits.NODE_GEOMETRY)) {
            PGRectangle var1 = this.getPGRect();
            var1.updateRectangle((float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight(), (float)this.getArcWidth(), (float)this.getArcHeight());
        }

    }

    private static class StyleableProperties {
        private static final StyleableProperty<Rectangle, Number> ARC_HEIGHT = new StyleableProperty("-fx-arc-height", SizeConverter.getInstance(), Double.valueOf(0.0D)) {
            @Override
            public boolean isSettable(Node node) {
                return false;
            }

            @Override
            public WritableValue getWritableValue(Node node) {
                return null;
            }

            public boolean isSettable(Rectangle var1) {
                return var1.arcHeight == null || !var1.arcHeight.isBound();
            }

            public WritableValue<Number> getWritableValue(Rectangle var1) {
                return var1.arcHeightProperty();
            }
        };
        private static final StyleableProperty<Rectangle, Number> ARC_WIDTH = new StyleableProperty("-fx-arc-width", SizeConverter.getInstance(), Double.valueOf(0.0D)) {
            @Override
            public boolean isSettable(Node node) {
                return false;
            }

            @Override
            public WritableValue getWritableValue(Node node) {
                return null;
            }

            public boolean isSettable(Rectangle var1) {
                return var1.arcWidth == null || !var1.arcWidth.isBound();
            }

            public WritableValue<Number> getWritableValue(Rectangle var1) {
                return var1.arcWidthProperty();
            }
        };
        private static final List<StyleableProperty> STYLEABLES;

        private StyleableProperties() {
        }

        static {
            ArrayList var0 = new ArrayList(Shape.impl_CSS_STYLEABLES());
            Collections.addAll(var0, new StyleableProperty[]{ARC_HEIGHT, ARC_WIDTH});
            STYLEABLES = Collections.unmodifiableList(var0);
        }
    }
}
