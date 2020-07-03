package CardGames;

import BombField.Field;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

public class Memory extends Application {
    private boolean gameOver = false;
    private int attempt;
    private Deck deck1 = new Deck(10);
    private Deck deck2 = new Deck(10);
    private Deck deck3 = new Deck(20);
    private final String FILE_PATH = "/src/CardGames/memory.txt";
    private final String card1_PATH = "/src/CardGames/media/Adriano-Pappalardo-Vieni-da-me-1280x720.jpg";
    private final String card2_PATH = "/src/CardGames/media/amadeus.jpg";
    private final String card3_PATH = "/src/CardGames/media/bossetti.jpg";
    private final String card4_PATH = "/src/CardGames/media/Enzo-Iacchetti1.jpg";
    private final String card5_PATH = "/src/CardGames/media/fazio.jpg";
    private final String card6_PATH = "/src/CardGames/media/Ezio_Greggio.jpg";
    private final String card7_PATH = "/src/CardGames/media/luca-giurato.jpg";
    private final String card8_PATH = "/src/CardGames/media/pedro.jpg";
    private final String card9_PATH = "/src/CardGames/media/scotti.jpg";
    private final String card10_PATH = "/src/CardGames/media/zeq.jpg";
    public Memory(){
        String filePath = new File("").getAbsolutePath();
        filePath+=FILE_PATH;
        deck1.addCard(filePath);
        deck2.addCard(filePath);
        deck1.shuffle();
        deck2.shuffle();
        for (int i = 0; i < 10; i++) {
            deck3.getCard().add(deck1.getCard().get(i));
            deck3.getCard().add(deck2.getCard().get(i));
        }
        deck3.shuffle();
    }
    public static void Main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(refresh(stage));
        stage.show();
    }
    private void countUnfolded() {
        int count = 0;
        for (Card cards : deck3.getCard()) {
            if (cards.isFolded()) {
                if(!cards.getValue().equals("removed")) {
                    count++;
                }
            }
        }
        if(count > 1){
            for (Card cards:deck3.getCard()) {
                if(!cards.getValue().equals("removed")) {
                    cards.fold();
                }
            }
        }
    }

    private void checkEquals() {
        for (int i = 0; i < deck3.getCard().size(); i++) {
            if (deck3.getCard().get(i).isFolded() && !deck3.getCard().get(i).getValue().equals("removed")) {
                for (int j = 0; j < deck3.getCard().size(); j++) {
                    if (deck3.getCard().get(j).isFolded() && !deck3.getCard().get(j).equals(deck3.getCard().get(i))) {
                        if (deck3.getCard().get(j).getValue().equals(deck3.getCard().get(i).getValue()) && deck3.getCard().get(j).isFolded() && deck3.getCard().get(i).isFolded()) {
                            deck3.getCard().get(j).setValue("removed");
                            deck3.getCard().get(i).setValue("removed");
                        }
                    }
                }
            }
        }
    }

    private Button createCards(String path){
        String filePath = new File("").getAbsolutePath();
        filePath+=path;
        File file = new File(filePath);
        javafx.scene.image.Image img = new Image(file.getAbsoluteFile().toURI().toString());
        Button button = new Button();
        BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(150.0,100.0,false,false,false,false));
        Background bg = new Background(bgImg);
        button.setBackground(bg);
        button.setMinHeight(100);
        button.setMinWidth(80);
        return button;
    }


    private Text genPoints(){
        Text attempts = new Text();
        attempts.setText(String.valueOf(this.attempt));
        return attempts;
    }

    private Scene refresh(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        int countCol = -1;
        int row = 0;

        for (int r = 0; r < deck3.getCard().size(); r++) {
                if (!(deck3.getCard().get(r).isFolded())) {
                    Button button = new Button("\uD83C\uDF0A");
                    button.setStyle("-fx-text-fill:darkslateblue;-fx-font-weight: bold;");
                    button.setMinHeight(100);
                    button.setMinWidth(80);
                    int finalR = r;
                    button.setOnAction(e -> {
                        this.attempt++;
                        deck3.getCard().get(finalR).unFold();
                        stage.setScene(refresh(stage));
                        checkEquals();
                        countUnfolded();
                    });
                    if(countCol < 4) {
                        countCol++;
                    }
                    else {
                        row++;
                        countCol = 0;
                    }
                    grid.add(button, row, countCol);

                }
                else {
                    Button button;
                    switch (deck3.getCard().get(r).getNumValue()){
                        case 0:
                            button = createCards(card1_PATH);
                            break;
                        case 1:
                            button = createCards(card2_PATH);
                            break;
                        case 2:
                            button = createCards(card3_PATH);
                            break;
                        case 3:
                            button = createCards(card4_PATH);
                            break;
                        case 4:
                            button = createCards(card5_PATH);
                            break;
                        case 5:
                            button = createCards(card6_PATH);
                            break;
                        case 6:
                            button = createCards(card7_PATH);
                            break;
                        case 7:
                            button = createCards(card8_PATH);
                            break;
                        case 8:
                            button = createCards(card9_PATH);
                            break;
                        case 9:
                            button = createCards(card10_PATH);
                            break;
                        default:
                            button = new Button();
                    }
                    if(countCol < 4) {
                        countCol++;
                    }
                    else {
                        row++;
                        countCol = 0;
                    }
                    grid.add(button, row, countCol);

                }
            }
        VBox box = new VBox();
        box.getChildren().addAll(genPoints());
        ScrollPane scrollPane = new ScrollPane(grid);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(scrollPane);
        borderPane.setTop(box);
        Scene scene = new Scene(borderPane);
        return scene;
    }
}
