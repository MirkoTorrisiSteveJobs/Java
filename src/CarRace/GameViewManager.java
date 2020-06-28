package CarRace;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.ColorConvertOp;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameViewManager extends Application {


    private AnchorPane pane;

    private final int GAME_HEIGTH = 10 * 50;
    private final int GAME_WIDTH = 10 * 50;
    private final String BG_PATH = "C:\\Users\\Mirko\\Desktop\\demo\\SnakeGame\\src\\SnakeGame\\view\\resources\\grass.jfif";
    private final String HEAD_PATH = "C:\\Users\\Mirko\\Desktop\\demo\\SnakeGame\\src\\SnakeGame\\view\\resources\\zequila.JPG";
    private final String BODY_PATH = "C:\\Users\\Mirko\\Desktop\\demo\\SnakeGame\\src\\SnakeGame\\view\\resources\\snakepatt.JPG";
    Car ferrari = new Car("ferrari");
    Car porsche = new Car("porsche");
    Car maserati = new Car("maserati");


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Race");
        ferrari.start();
        porsche.start();
        maserati.start();
        createContent(stage);
    }

    private Scene createContent(Stage stage) {
        Group root = new Group();


        pane = new AnchorPane();
        createBackground();

        pane.getChildren().add(root);
        Scene scene = new Scene(pane, GAME_WIDTH, GAME_HEIGTH);

        Circle ferCircle = new Circle();
        ferCircle.setCenterX(ferrari.getPosition());
        ferCircle.setCenterY(25);
        ferCircle.setRadius(25);
        ferCircle.setFill(Color.RED);
        Circle porCircle = new Circle();
        porCircle.setCenterX(porsche.getPosition());
        porCircle.setCenterY(75);
        porCircle.setRadius(25);
        porCircle.setFill(Color.BLUE);
        Circle masCircle = new Circle();
        masCircle.setCenterX(maserati.getPosition());
        masCircle.setCenterY(90);
        masCircle.setRadius(25);
        masCircle.setFill(Color.GREEN);

        root.getChildren().addAll(ferCircle,porCircle,masCircle);

        stage.setScene(scene);
        stage.show();

        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long arg0) {

                ferCircle.setCenterX(ferrari.getPosition());
                porCircle.setCenterX(porsche.getPosition());
                masCircle.setCenterX(maserati.getPosition());
            }
        };
        animator.start();
        return scene;
    }



    public static void Main(String[] args){
        launch(args);
    }


    private void createBackground(){
        File file = new File(BG_PATH);
        javafx.scene.image.Image img = new Image(file.getAbsoluteFile().toURI().toString());
        BackgroundImage bgImg = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(bgImg));
    }

}

