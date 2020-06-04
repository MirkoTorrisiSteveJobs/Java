package SnakeGame.view;

import BombField.Field;
import SnakeGame.Snake.SnakeGame;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rubric.CSV;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameViewManager extends Application {

    private Rectangle rect;
    private Rectangle fruit;
    private Group root;
    private AnchorPane pane;
    private ArrayList<Circle> snake;
    SnakeGame snakeGame = new SnakeGame(20, 20);

    private final int GAME_HEIGTH = snakeGame.getGrid().length * 50;
    private final int GAME_WIDTH = snakeGame.getGrid()[0].length * 50;
    private final String BG_PATH = "C:\\Users\\User\\IdeaProjects\\Games\\src\\SnakeGame\\view\\resources\\grass.jfif";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Basic JavaFX demo");
        createContent(stage);
    }

    private Scene createContent(Stage stage) {
        Group root = new Group();
        root.setLayoutX(25);
        root.setLayoutY(25);
        pane = new AnchorPane();
        createBackground();

        pane.getChildren().add(root);
        Scene scene = new Scene(pane, GAME_WIDTH, GAME_HEIGTH);

        Circle head = new Circle();
        head.setCenterX(snakeGame.getSnake().getHead()[1] * 50);
        head.setCenterY(snakeGame.getSnake().getHead()[0] * 50);
        head.setRadius(25);
        head.setFill(Color.CRIMSON);
        root.getChildren().add(head);
        snake = new ArrayList<>();

        for (int[] coords : snakeGame.getSnake().getTail()) {
            Circle piece = new Circle();
            piece.setCenterX(coords[1] * 50);
            piece.setCenterY(coords[0] * 50);
            piece.setRadius(25);
            piece.setFill(Color.BLUE);
            root.getChildren().add(piece);
            snake.add(piece);

        }

        snake.add(head);
        Circle fruit = new Circle();
        fruit.setCenterX(snakeGame.getFruit()[1] * 50);
        fruit.setCenterY(snakeGame.getFruit()[0] * 50);
        fruit.setRadius(25);
        fruit.setFill(Color.CHOCOLATE);
        root.getChildren().add(fruit);
        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();

        keyboardNode.setOnKeyPressed(this::handle); // call to the EventHandler

        root.getChildren().add(keyboardNode);
        stage.setScene(scene);
        stage.show();
        Text points = new Text();
        root.getChildren().add(points);
        Text bestScore = new Text();
        bestScore.setText("BEST SCORE: " + snakeGame.getBestScore());
        bestScore.setFont(Font.font("Verdana", 40));
        bestScore.setFill(Color.BLACK);
        bestScore.setX(GAME_WIDTH - 400);
        bestScore.setY(10);
        root.getChildren().add(bestScore);
        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                points.setText(String.valueOf(snakeGame.getSnake().getPoints()));
                points.setFont(Font.font("Verdana", 40));
                points.setFill(Color.BLACK);
                points.setX(10);
                points.setY(10);
                if (!snakeGame.gameOver) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(200 - snakeGame.getSnake().getPoints());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int count = 0;
                    for (Circle piece : snake) {
                        if (count < snakeGame.getSnake().getTail().size()) {
                            piece.setCenterX(snakeGame.getSnake().getTail().get(count)[1] * 50);
                            piece.setCenterY(snakeGame.getSnake().getTail().get(count)[0] * 50);
                            count++;
                        } else {
                            piece.setCenterX(snakeGame.getSnake().getHead()[1] * 50);
                            piece.setCenterY(snakeGame.getSnake().getHead()[0] * 50);
                        }
                    }
                    if (snakeGame.hasAte) {
                        Circle newPiece = new Circle();
                        newPiece.setCenterX((snakeGame.getSnake().getTail().get(0)[1] * 50));
                        newPiece.setCenterY((snakeGame.getSnake().getTail().get(0)[0] * 50));
                        newPiece.setRadius(25);
                        newPiece.setFill(Color.BLUE);
                        snake.add(0,newPiece);
                        root.getChildren().add(newPiece);
                        fruit.setCenterX(snakeGame.getFruit()[1] * 50);
                        fruit.setCenterY(snakeGame.getFruit()[0] * 50);
                        snakeGame.hasAte = false;
                    }
                    snakeGame.snakePlay();
                } else {
                    Text youlose = new Text();
                    if (!snakeGame.isNewRecord()) {
                        youlose.setText("HAI PERSO :)");
                    }
                    else{
                        youlose.setText("NUOVO RECORD!");
                    }
                        youlose.setFont(Font.font("Verdana", 40));
                        Random rand = new Random();
                        youlose.setX(rand.nextInt(GAME_WIDTH));
                        youlose.setY(rand.nextInt(GAME_HEIGTH));
                        youlose.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                        try {
                            TimeUnit.MILLISECONDS.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        root.getChildren().add(youlose);
                    }
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
    public void handle(KeyEvent arg0) {

        if (arg0.getCode() == KeyCode.UP )
        {
            if(snakeGame.getSnake().getDirection()!=2) {
                snakeGame.getSnake().setDirection(8);
            }
        }
        else if (arg0.getCode() == KeyCode.DOWN )
        {
            if(snakeGame.getSnake().getDirection()!=8) {
                snakeGame.getSnake().setDirection(2);
            }
        }
        else if (arg0.getCode() == KeyCode.LEFT )
        {
            if(snakeGame.getSnake().getDirection()!=6) {
                snakeGame.getSnake().setDirection(4);
            }
        }
        else if (arg0.getCode() == KeyCode.RIGHT )
        {
            if(snakeGame.getSnake().getDirection()!=4) {

                snakeGame.getSnake().setDirection(6);
            }
        }
    }
}
