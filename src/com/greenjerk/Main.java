package com.greenjerk;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    final MapDBConnector connector = new MapDBConnector();

    private static final Image ICON_DOT_48 = new Image(Main.class.getResourceAsStream("image/button-dot.png"), 48, 48, false, false);
    private static final Image ICON_LINE_48 = new Image(Main.class.getResourceAsStream("image/button-line.png"), 48, 48, false, false);
    private static final Image ICON_RECT_48 = new Image(Main.class.getResourceAsStream("image/button-rect.png"), 48, 48, false, false);
    private static final Image ICON_ELLIPSE_48 = new Image(Main.class.getResourceAsStream("image/button-ellipse.png"), 48, 48, false, false);

    private static final String STYLE_CSS = Main.class.getResource("css/style.css").toExternalForm();

    public static final int DOT = 0;
    public static final int LINE = 1;
    public static final int RECTANGLE = 2;
    public static final int ELLIPSE = 3;
    private Integer type;

    private Color currentColor = Color.BLACK;

    private Double positionX, positionY = 0d;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, Color.LIGHTSTEELBLUE));
        BorderPane borderPane = new BorderPane();

        // Main Menu Panel
        ToolBar toolBar = createToolBar("top_bar");
        toolBar.getStylesheets().add(STYLE_CSS);
        borderPane.setTop(toolBar);

        // Tools Panel
        final ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        final Button[] buttons = createButtons(ICON_DOT_48, ICON_LINE_48, ICON_RECT_48, ICON_ELLIPSE_48);
        final Text coloredText = new Text("Color");
        Font font = new Font(18);
        coloredText.setFont(font);
        Color c = colorPicker.getValue();
        coloredText.setFill(c);

        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Color newColor = colorPicker.getValue();
                currentColor = colorPicker.getValue();
                coloredText.setFill(newColor);
            }
        });

        VBox leftVBox = createVBox("tool_panel", buttons);
        leftVBox.getChildren().add(coloredText);
        leftVBox.getChildren().add(colorPicker);
        leftVBox.getStylesheets().add(STYLE_CSS);

        // Tab Panel
        final TabPane tabPane = createTabPane("tab_panel");
        tabPane.getStylesheets().add(STYLE_CSS);
        final Tab tab1 = new Tab();
        tab1.setText("Tab 1");
        final Tab tab2 = new Tab();
        tab2.setText("Tab 2");
        tabPane.getTabs().addAll(tab1, tab2);
        addPaneToTabs(tab1, tab2);
        SingleSelectionModel<Tab>  selectionModel = tabPane.getSelectionModel();
        selectionModel.select(connector.getDefaultTab());

        final SplitPane splitPane = SplitPaneBuilder.create().id("hidden_splitter").items(
                leftVBox,
                tabPane).dividerPositions(new double[]{0.1, 0.9}).build();
        splitPane.getStylesheets().add(STYLE_CSS);
        borderPane.setCenter(splitPane);

        root.getChildren().add(borderPane);
    }

    private void addPaneToTabs(Tab... tabs) {
        for(Tab tab : tabs) {
            final Pane pane = new Pane();
            tab.setContent(pane);

            pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(type != null && type == LINE) {
                        Line line = new Line();
                        line.setStartX(mouseEvent.getX());
                        line.setStartY(mouseEvent.getY());
                        line.setEndX(mouseEvent.getX());
                        line.setEndY(mouseEvent.getY());
                        line.setFill(null);
                        line.setStroke(currentColor);
                        line.setStrokeWidth(4);
                        pane.getChildren().add(line);
                    } else if(type != null && type == RECTANGLE) {
                        positionX = mouseEvent.getX();
                        positionY = mouseEvent.getY();
                        Rectangle rectangle = new Rectangle(positionX, positionY, 1, 1);
                        rectangle.setFill(null);
                        rectangle.setStrokeWidth((4));
                        rectangle.setStroke(currentColor);
                        pane.getChildren().add(rectangle);
                    } else if(type != null && type == ELLIPSE) {
                        positionX = mouseEvent.getX();
                        positionY = mouseEvent.getY();
                        Ellipse ellipse = new Ellipse(positionX, positionY, 1, 1);
                        ellipse.setFill(null);
                        ellipse.setStrokeWidth((4));
                        ellipse.setStroke(currentColor);
                        pane.getChildren().add(ellipse);
                    } else {
                        Line line = new Line();
                        line.setStartX(mouseEvent.getX());
                        line.setStartY(mouseEvent.getY());
                        line.setEndX(mouseEvent.getX());
                        line.setEndY(mouseEvent.getY());
                        line.setFill(null);
                        line.setStroke(currentColor);
                        line.setStrokeWidth((4));
                        pane.getChildren().add(line);
                    }
                }
            });

            pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(type != null && type == LINE) {
                        Line line = (Line) pane.getChildren().get(pane.getChildren().size() - 1);
                        line.setEndX(mouseEvent.getX());
                        line.setEndY(mouseEvent.getY());
                    } else if(type != null && type == RECTANGLE) {
                        Rectangle rectangle = (Rectangle) pane.getChildren().get(pane.getChildren().size() - 1);
                        rectangle.setWidth(Math.abs(positionX - mouseEvent.getX()));
                        rectangle.setHeight(Math.abs(positionY - mouseEvent.getY()));
                        rectangle.setX(mouseEvent.getX());
                        rectangle.setY(mouseEvent.getY());
                        if (positionX - mouseEvent.getX() < 0 && positionY - mouseEvent.getY() < 0) {
                            rectangle.setX(mouseEvent.getX() + (positionX - mouseEvent.getX()));
                            rectangle.setY(mouseEvent.getY() + (positionY - mouseEvent.getY()));
                        } else if(positionX - mouseEvent.getX() < 0) {
                            rectangle.setX(mouseEvent.getX() + (positionX - mouseEvent.getX()));
                        } else if (positionY - mouseEvent.getY() < 0) {
                            rectangle.setY(mouseEvent.getY() + (positionY - mouseEvent.getY()));
                        }
                    } else if(type != null && type == ELLIPSE) {
                        Ellipse ellipse = (Ellipse) pane.getChildren().get(pane.getChildren().size() - 1);
                        ellipse.setRadiusX(Math.abs(positionX - mouseEvent.getX()) / 2);
                        ellipse.setRadiusY(Math.abs(positionY - mouseEvent.getY()) / 2);
                        ellipse.setCenterX(mouseEvent.getX() + ((positionX - mouseEvent.getX()) / 2));
                        ellipse.setCenterY(mouseEvent.getY() + ((positionY - mouseEvent.getY()) / 2));
                    } else {
                        Line line = new Line();
                        line.setStartX(mouseEvent.getX());
                        line.setStartY(mouseEvent.getY());
                        line.setEndX(mouseEvent.getX());
                        line.setEndY(mouseEvent.getY());
                        line.setFill(null);
                        line.setStroke(currentColor);
                        line.setStrokeWidth((4));
                        pane.getChildren().add(line);
                    }

                }
            });
        }
    }

    private Button[] createButtons(Image... images) {
        List<Button> buttonList = new ArrayList<Button>();
        Integer count = 0;
        for(Image image : images) {
            ImageView imageView = new ImageView(image);
            Button button = new Button(count.toString(), imageView);
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            button.setId("tool_button");
            button.getStylesheets().add(STYLE_CSS);
            final Integer finalCount = count;
            button.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    type = finalCount;
                }
            });
            buttonList.add(button);
            count++;
        }
        return buttonList.toArray(new Button[buttonList.size()]);
    }

    private VBox createVBox(String id, Control... controls) {
        VBox leftVBox = new VBox(15);
        leftVBox.setId(id);
        for(Control control : controls) {
            leftVBox.getChildren().add(control);
        }
        leftVBox.setPrefWidth(60);
        return leftVBox;
    }

    private TabPane createTabPane(String id) {
        final TabPane tabPane = new TabPane();
        tabPane.setId(id);
        tabPane.setPrefSize(800, 600);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        return tabPane;
    }

    private ToolBar createToolBar(String id) {
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                final Stage stage = new Stage();
                Group root = new Group();
                stage.setResizable(false);
                stage.setScene(new Scene(root, 300, 200, Color.LIGHTSTEELBLUE));
                ToggleGroup tg = new ToggleGroup();
                VBox vbox = new VBox();
                vbox.setAlignment(Pos.CENTER);
                vbox.setMinWidth(300);
                vbox.setMinHeight(120);
                vbox.setSpacing(10);

                final Text text = new Text("Select a tab by default:");

                List<RadioButton> radioButtons = new ArrayList<RadioButton>();

                final RadioButton rb1 = new RadioButton("Tab 1");
                rb1.setToggleGroup(tg);
                rb1.setSelected(true);
                radioButtons.add(rb1);

                RadioButton rb2 = new RadioButton("Tab 2");
                rb2.setToggleGroup(tg);
                radioButtons.add(rb2);

                Integer defaultTab = connector.getDefaultTab();
                for(int i=0; i <radioButtons.size(); i++) {
                    final RadioButton button = radioButtons.get(i);
                    button.setId(String.valueOf(i));
                    if(i == defaultTab) {
                        button.setSelected(true);
                    }
                    button.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            connector.setDefaultTab(button.getId());
                        }
                    });
                }

                vbox.getChildren().addAll(text, rb1, rb2);
                root.getChildren().add(vbox);

                stage.centerOnScreen();
                stage.show();
            }
        });
        return ToolBarBuilder.create().id(id).items(
                new Button("Menu"),
                editButton).build();
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.setTitle("Graphics Editor 1.0");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
            }
        });
    }

    public static void main(String[] args) { launch(args); }
}
