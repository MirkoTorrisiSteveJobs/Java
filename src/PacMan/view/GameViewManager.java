package PacMan.view;

import PacMan.PacManGame;
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
import java.io.File;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameViewManager extends Application {


    private AnchorPane pane;
    PacManGame pacManGame = new PacManGame();

    private final int GAME_HEIGTH = pacManGame.getMaze().length * 50;
    private final int GAME_WIDTH = pacManGame.getMaze()[0].length * 50;
    private final String BG_PATH = "/src/PacMan/view/resources/bg.jfif";
    private final String HEAD_PATH = "/src/PacMan/view/resources/zequila.JPG";
    private final String WAKA_PATH = "/src/PacMan/view/resources/waka.mp3";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("PacMan");
        createContent(stage);
    }
    private String createFilePath(String path){
        String finalPath = new File("").getAbsolutePath();
        return finalPath + path;
    }
    private Scene createContent(Stage stage) {
        Group root = new Group();
        AudioClip waka = new AudioClip(new File(createFilePath(WAKA_PATH)).toURI().toString());


        pane = new AnchorPane();
        createBackground();

        pane.getChildren().add(root);
        Scene scene = new Scene(pane, GAME_WIDTH, GAME_HEIGTH);

        Circle pacMan = new Circle();
        pacMan.setCenterX(pacManGame.getPlayer().getCoords()[1] * 50+25);
        pacMan.setCenterY(pacManGame.getPlayer().getCoords()[0] * 50+25);
        pacMan.setRadius(25);

        Circle phantom1 = new Circle();
        phantom1.setCenterX(pacManGame.getPhantom().getCoords()[1] * 50+25);
        phantom1.setCenterY(pacManGame.getPhantom().getCoords()[0] * 50+25);
        phantom1.setRadius(25);
        phantom1.setFill(Color.BLACK);

        Circle phantom2 = new Circle();
        phantom2.setCenterX(pacManGame.getPhantom2().getCoords()[1] * 50+25);
        phantom2.setCenterY(pacManGame.getPhantom2().getCoords()[0] * 50+25);
        phantom2.setRadius(25);
        phantom2.setFill(Color.GREEN);

        Circle phantom3 = new Circle();
        phantom3.setCenterX(pacManGame.getPhantom3().getCoords()[1] * 50+25);
        phantom3.setCenterY(pacManGame.getPhantom3().getCoords()[0] * 50+25);
        phantom3.setRadius(25);
        phantom3.setFill(Color.CRIMSON);

        Circle phantom4 = new Circle();
        phantom4.setCenterX(pacManGame.getPhantom4().getCoords()[1] * 50+25);
        phantom4.setCenterY(pacManGame.getPhantom4().getCoords()[0] * 50+25);
        phantom4.setRadius(25);
        phantom4.setFill(Color.CHOCOLATE);

        File file = new File(createFilePath(HEAD_PATH));
        javafx.scene.image.Image img = new Image(file.getAbsoluteFile().toURI().toString());

        pacMan.setFill(new ImagePattern(img));

        for (int i = 0; i < pacManGame.getMaze().length; i ++) {
            for(int j = 0 ; j <pacManGame.getMaze()[i].length;j++){
                if (pacManGame.getMaze()[i][j] == 1){
                    Rectangle rect = new Rectangle(50,50);
                    rect.setX(j*50);
                    rect.setY(i*50);
                    rect.setFill(Color.BLUE);
                    root.getChildren().add(rect);
                }
                else if (pacManGame.getMaze()[i][j] == 2){
                    Circle circle = new Circle(10);
                    circle.setCenterX(j*50+25);
                    circle.setCenterY(i*50+25);
                    circle.setFill(Color.ALICEBLUE);
                    circle.setId(i+"-"+j);
                    root.getChildren().add(circle);
                }
            }
        }
        root.getChildren().addAll(pacMan,phantom1,phantom2,phantom3,phantom4);

        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();

        keyboardNode.setOnKeyPressed(this::handle); // call to the EventHandler

        root.getChildren().add(keyboardNode);
        stage.setScene(scene);
        stage.show();
        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                if (!pacManGame.gameOver && !pacManGame.gameWin) {
                    pacManGame.gamePlay();
                    for (int i = 0; i < pacManGame.getMaze().length; i ++) {
                        for (int j = 0; j < pacManGame.getMaze()[i].length; j++) {
                            if (pacManGame.getMaze()[i][j] == 0) {
                                root.getChildren().remove(root.lookup("#"+i + "-" + j));
                            }
                        }
                    }
                    try {
                            TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(pacManGame.eatToken()){
                        waka.play();
                    }
                    pacMan.setCenterX(pacManGame.getPlayer().getCoords()[1]*50+25);
                    pacMan.setCenterY(pacManGame.getPlayer().getCoords()[0]*50+25);
                    phantom1.setCenterX(pacManGame.getPhantom().getCoords()[1]*50+25);
                    phantom1.setCenterY(pacManGame.getPhantom().getCoords()[0]*50+25);
                    phantom2.setCenterX(pacManGame.getPhantom2().getCoords()[1]*50+25);
                    phantom2.setCenterY(pacManGame.getPhantom2().getCoords()[0]*50+25);
                    phantom3.setCenterX(pacManGame.getPhantom3().getCoords()[1]*50+25);
                    phantom3.setCenterY(pacManGame.getPhantom3().getCoords()[0]*50+25);
                    phantom4.setCenterX(pacManGame.getPhantom4().getCoords()[1]*50+25);
                    phantom4.setCenterY(pacManGame.getPhantom4().getCoords()[0]*50+25);

                } else{

                    if(pacManGame.gameOver){
                        Text youlose = new Text();
                        youlose.setText("HAI PERSO :)");
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
                    else if(pacManGame.gameWin){

                    }

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
        File file = new File(createFilePath(BG_PATH));
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
                pacManGame.getPlayer().setDirection(8);

        }
        else if (arg0.getCode() == KeyCode.DOWN )
        {
                pacManGame.getPlayer().setDirection(2);
        }
        else if (arg0.getCode() == KeyCode.LEFT )
        {
                pacManGame.getPlayer().setDirection(4);
        }
        else if (arg0.getCode() == KeyCode.RIGHT )
        {
                pacManGame.getPlayer().setDirection(6);
        }
    }
}

