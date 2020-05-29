package BombField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.Scanner;

public class MainGui extends Application{
    static Field field = new Field(9);
    public static void Main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("select difficult level: \n1 (9x9) \n2(16x16) \n3(30x30)");
        int choice = Integer.parseInt(scan.nextLine());
        if(choice == 1){
            field = new Field(9);
        }
        else if(choice == 2){
            field = new Field(16);
        }
        else{
            field = new Field(30);
        }
        launch(args);
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
                    button.setOnAction(e -> {
                        field.getField()[x][y].setCover(false);
                        field.uncoverBox(x, y);
                        if(field.checkBomb(x,y)){
                            field.showBombs();
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("");
                            alert.setHeaderText("HAI PERSO");
                            alert.setContentText("");
                            alert.showAndWait();
                        }
                        else if(field.checkWin()){
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("");
                                alert.setHeaderText("HAI VINTO!!!");
                            alert.setContentText("");
                            alert.showAndWait();
                        }
                        button.setText(field.getField()[x][y].toString());
                        stage.setScene(refresh(stage));
                    });
                    grid.add(button, c, r);
                } else {
                    Button button = new Button(field.getField()[r][c].toString());
                    grid.add(button, c, r);
                }
            }
        }
        ScrollPane scrollPane = new ScrollPane(grid);
        return new Scene(scrollPane);
    }
    public void start(Stage stage) {
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
                    button.setOnAction(e -> {
                        field.getField()[x][y].setCover(false);
                        field.uncoverBox(x, y);
                        button.setText(field.getField()[x][y].toString());
                        ScrollPane scrollPane = new ScrollPane(grid);

                        stage.setScene(refresh(stage));
                    });
                    grid.add(button, c, r);
                } else {
                    Button button = new Button(field.getField()[r][c].toString());
                    grid.add(button, c, r);
                }
            }

        }
        ScrollPane scrollPane = new ScrollPane(grid);

        stage.setScene(new Scene(scrollPane));
        stage.show();
        }
    }

