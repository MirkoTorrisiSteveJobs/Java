package BombField;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.Optional;


public class MainGui extends Application{
    static Field field = new Field(9);
    public static void Main(String[] args){
        launch(args);
    }
    private VBox menu(Stage stage){
        final Menu menu1 = new Menu("Options");
        MenuItem menuItem1 = new MenuItem("Restart");
        menuItem1.setOnAction(e -> {
            field = new Field(this.field.getSize());
            stage.setScene(refresh(stage));
        });
        final Menu subMenu = new Menu("Change Difficult");
        menu1.getItems().add(menuItem1);
        MenuItem difficult1 = new MenuItem("Easy (9x9)");
        difficult1.setOnAction(e -> {
            field = new Field(9);
            stage.setScene(refresh(stage));
        });
        MenuItem difficult2 = new MenuItem("Difficult(16x16)");
        difficult2.setOnAction(e -> {
            field = new Field(16);
            stage.setScene(refresh(stage));
        });
        MenuItem difficult3 = new MenuItem("Hard(30x30)");
        difficult3.setOnAction(e -> {
            field = new Field(30);
            stage.setScene(refresh(stage));
        });
        subMenu.getItems().add(difficult1);
        subMenu.getItems().add(difficult2);
        subMenu.getItems().add(difficult3);
        menu1.getItems().add(subMenu);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1);

        return new VBox(menuBar);
    }
    public Scene refresh(Stage stage){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);

        for (int r = 0; r < field.getSize(); r++) {
            for (int c = 0; c < field.getSize(); c++) {
                final int x = r;
                final int y = c;
                if (field.getField()[r][c].isCover()) {
                    Button button = new Button("\uD83C\uDF0A");
                    button.setStyle("-fx-text-fill:darkslateblue;-fx-font-weight: bold;");
                    if(!field.gameOver) {
                        button.setOnAction(e -> {
                            field.uncoverBox(x, y);
                            if (field.checkBomb(x, y)) {
                                field.showBombs();
                                grid.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                                stage.setScene(refresh(stage));
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("");
                                alert.setHeaderText("HAI PERSO :)");

                                alert.setContentText("Do you want to play again?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if(!result.isPresent() || result.get() == ButtonType.CANCEL){
                                    stage.close();
                                }
                                else if(result.get() == ButtonType.OK)
                                {
                                    field = new Field(this.field.getSize());
                                    stage.setScene(refresh(stage));
                                }
                            } else if (field.checkWin()) {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("");
                                alert.setHeaderText("HAI VINTO!!!");
                                alert.setContentText("Do you want to play again?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if(!result.isPresent() || result.get() == ButtonType.CANCEL){
                                    stage.close();
                                }
                                else if(result.get() == ButtonType.OK)
                                {
                                    field = new Field(this.field.getSize());
                                    stage.setScene(refresh(stage));
                                }
                            }
                            stage.setScene(refresh(stage));
                        });
                    }
                    grid.add(button, c, r);
                } else {
                    Button button = new Button(field.getField()[r][c].toString());
                    button.setStyle("");
                    switch (field.getField()[x][y].getValue()){
                        case 0:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:white;-fx-font-weight: bolder;");
                            break;
                        case -1:
                            button.setStyle("-fx-background-color: red; -fx-text-fill: black;-fx-font-weight: bolder;");
                            break;
                        case 1:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:blue;-fx-font-weight: bolder;");
                            break;
                        case 2:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:green;-fx-font-weight: bolder;");
                            break;
                        case 3:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:orange;-fx-font-weight: bolder;");
                            break;
                        case 4:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:red;-fx-font-weight: bolder;");
                            break;
                        case 5:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:purple;-fx-font-weight: bolder;");
                            break;
                        case 6:
                            button.setStyle("-fx-background-color: white;-fx-text-fill:brown;-fx-font-weight: bolder;");
                            break;
                    }
                    grid.add(button, c, r);
                }
            }
        }
        ScrollPane scrollPane = new ScrollPane(grid);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menu(stage));
        borderPane.setCenter(scrollPane);
        Scene scene = new Scene(borderPane);
        return scene;
    }
    
    public void start(Stage stage) {
        stage.setScene(refresh(stage));
        stage.show();
    }
}

