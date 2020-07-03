package CardGames;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class BJmain extends Application {
    BlackJackGame game = new BlackJackGame();
    int bet = 5;

    private final String PATH_MUSIC = "/src/CardGames/media/Las_Vegas_Casino_Music_Video__For_Night_.mp3";
    private final String PATH_GREEN = "/src/CardGames/media/green.jpg";
    private final String LOSE_PATH = "/src/CardGames/media/zequila.jpg";
    private final String WIN_PATH = "/src/CardGames/media/scotti.jpg";
    private final String DRAW_PATH = "/src/CardGames/media/Ezio_Greggio.jpg";
    private final String BJ_PATH = "/src/CardGames/media/10049_blackjack_body_lightv2_600_3.1424199920.gif";
    private final String PATH_BG = "/src/CardGames/media/BGblackjack.jpg";
    private final String PATH_2C = "/src/CardGames/media/JPEG/2C.jpg";
    private final String PATH_2D = "/src/CardGames/media/JPEG/2D.jpg";
    private final String PATH_2H = "/src/CardGames/media/JPEG/2H.jpg";
    private final String PATH_2S = "/src/CardGames/media/JPEG/2S.jpg";
    private final String PATH_3D = "/src/CardGames/media/JPEG/3D.jpg";
    private final String PATH_3H = "/src/CardGames/media/JPEG/3H.jpg";
    private final String PATH_3C = "/src/CardGames/media/JPEG/3C.jpg";
    private final String PATH_3S = "/src/CardGames/media/JPEG/3S.jpg";
    private final String PATH_4D = "/src/CardGames/media/JPEG/4D.jpg";
    private final String PATH_4H = "/src/CardGames/media/JPEG/4H.jpg";
    private final String PATH_4C = "/src/CardGames/media/JPEG/4C.jpg";
    private final String PATH_4S = "/src/CardGames/media/JPEG/4S.jpg";
    private final String PATH_5C = "/src/CardGames/media/JPEG/5C.jpg";
    private final String PATH_5D = "/src/CardGames/media/JPEG/5D.jpg";
    private final String PATH_5H = "/src/CardGames/media/JPEG/5H.jpg";
    private final String PATH_5S = "/src/CardGames/media/JPEG/5S.jpg";
    private final String PATH_6C = "/src/CardGames/media/JPEG/6C.jpg";
    private final String PATH_6D = "/src/CardGames/media/JPEG/6D.jpg";
    private final String PATH_6H = "/src/CardGames/media/JPEG/6H.jpg";
    private final String PATH_6S = "/src/CardGames/media/JPEG/6S.jpg";
    private final String PATH_7D = "/src/CardGames/media/JPEG/7D.jpg";
    private final String PATH_7C = "/src/CardGames/media/JPEG/7C.jpg";
    private final String PATH_7H = "/src/CardGames/media/JPEG/7H.jpg";
    private final String PATH_7S = "/src/CardGames/media/JPEG/7S.jpg";
    private final String PATH_8C = "/src/CardGames/media/JPEG/8C.jpg";
    private final String PATH_8D = "/src/CardGames/media/JPEG/8D.jpg";
    private final String PATH_8H = "/src/CardGames/media/JPEG/8H.jpg";
    private final String PATH_8S = "/src/CardGames/media/JPEG/8S.jpg";
    private final String PATH_9D = "/src/CardGames/media/JPEG/9D.jpg";
    private final String PATH_9H = "/src/CardGames/media/JPEG/9H.jpg";
    private final String PATH_9C = "/src/CardGames/media/JPEG/9C.jpg";
    private final String PATH_9S = "/src/CardGames/media/JPEG/9S.jpg";
    private final String PATH_10D = "/src/CardGames/media/JPEG/10D.jpg";
    private final String PATH_10H = "/src/CardGames/media/JPEG/10H.jpg";
    private final String PATH_10S = "/src/CardGames/media/JPEG/10S.jpg";
    private final String PATH_10C = "/src/CardGames/media/JPEG/10C.jpg";
    private final String PATH_AC = "/src/CardGames/media/JPEG/AC.jpg";
    private final String PATH_AS = "/src/CardGames/media/JPEG/AS.jpg";
    private final String PATH_AD = "/src/CardGames/media/JPEG/AD.jpg";
    private final String PATH_AH = "/src/CardGames/media/JPEG/AH.jpg";
    private final String PATH_JD = "/src/CardGames/media/JPEG/JD.jpg";
    private final String PATH_JC = "/src/CardGames/media/JPEG/JC.jpg";
    private final String PATH_JS = "/src/CardGames/media/JPEG/JS.jpg";
    private final String PATH_JH = "/src/CardGames/media/JPEG/JH.jpg";
    private final String PATH_QD = "/src/CardGames/media/JPEG/QD.jpg";
    private final String PATH_QC = "/src/CardGames/media/JPEG/QC.jpg";
    private final String PATH_QS = "/src/CardGames/media/JPEG/QS.jpg";
    private final String PATH_QH = "/src/CardGames/media/JPEG/QH.jpg";
    private final String PATH_KD = "/src/CardGames/media/JPEG/KD.jpg";
    private final String PATH_KC = "/src/CardGames/media/JPEG/KC.jpg";
    private final String PATH_KS = "/src/CardGames/media/JPEG/KS.jpg";
    private final String PATH_KH = "/src/CardGames/media/JPEG/KH.jpg";
    private final String PATH_FOLDED = "/src/CardGames/media/JPEG/blue_back.jpg";
    private boolean handOver;

    public static void Main(String[] args){
        launch(args);
    }


    private void startNewHand(Stage stage){
        game.initHand(bet);
        handOver = false;
        this.game.getCasino().getHand().get(0).unFold();
        stage.setScene(refresh(stage));
    }

    @Override
    public void start(Stage stage) throws Exception {

        Media media = new Media(new File(createFilePath(PATH_MUSIC)).toURI().toString());
        System.out.println(media.getError());
        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.play();
        game.initHand(bet);
        handOver = false;
        this.game.getCasino().getHand().get(0).unFold();
        stage.setScene(refresh(stage));
        stage.show();
    }
    private VBox getMoneys(){
        VBox box = new VBox();
        StackPane pane = new StackPane();
        StackPane pane2 = new StackPane();
        pane.setStyle("-fx-background-color: black;");
        pane2.setStyle("-fx-background-color: white;");
        Text yourMoneys =  new Text("Your money: "+String.valueOf(game.getPlayer().getMoney()));
        Text casinoMoneys =  new Text("Casino's money: "+String.valueOf(game.getCasino().getMoney()));
        yourMoneys.setFont(Font.font(null, FontWeight.BOLD, 30));
        yourMoneys.setFill(Color.CRIMSON);
        pane.setTranslateY(500);
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);
        casinoMoneys.setEffect(is);

        casinoMoneys.setFill(Color.YELLOW);
        casinoMoneys.setFont(Font.font(null, FontWeight.BOLD, 30));
        pane.getChildren().addAll(yourMoneys);
        pane2.getChildren().addAll(casinoMoneys);

        box.getChildren().addAll(pane, pane2);

        return box;
    }
    private Scene refresh(Stage stage) {
        GridPane gridCard = new GridPane();
        gridCard.setPadding(new Insets(5));
        gridCard.setHgap(5);
        gridCard.setVgap(100);
        File file = new File(createFilePath(PATH_GREEN));
        javafx.scene.image.Image img = new Image(file.getAbsoluteFile().toURI().toString());
        BackgroundImage bgImg = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        gridCard.setBackground(new Background(bgImg));
        Button call = new Button("Call");
        Button stay = new Button("Stay");
        call.setMinWidth(100);
        stay.setMinWidth(100);
        call.setMinHeight(50);
        stay.setMinHeight(50);

        ScrollPane scrollPane = new ScrollPane();
        if(!handOver) {
            if (game.getPlayer().isBlackJack()) {
                createAlert(false, "++++BLACKJACK++++", "", stage, BJ_PATH);
            }
            int colCount = 0;
            for (Card card : this.game.getPlayer().getHand()) {
                Button cardBtn = genCard(card);
                gridCard.add(cardBtn, colCount, 3);
                colCount++;
            }
            colCount = 0;
            for (Card card : this.game.getCasino().getHand()) {
                Button cardBtn = genCard(card);
                gridCard.add(cardBtn, colCount, 0);
                colCount++;
            }

            if (!game.getPlayer().isBlackJack() && !game.getPlayer().isOver()) {
                call.setOnAction(e -> {

                    game.getPlayer().callsCard(game.getDeck1());
                    game.getPlayer().countPoints();
                    if (game.getPlayer().isOver()) {
                        game.getCasino().setMoney(game.getCasino().getMoney() + bet * 2);
                        stage.setScene(refresh(stage));
                        createAlert(true, "****BUST****", "Wanna Play Again with the same bet?", stage, LOSE_PATH);
                    }
                    stage.setScene(refresh(stage));
                });
            }

            stay.setOnAction(e -> {
                this.game.getCasino().getHand().get(0).fold();
                game.getCasino().callsCard(game.getDeck1());
                if (game.getCasino().isOver()) {
                    game.getPlayer().setMoney(game.getPlayer().getMoney() + bet * 2);
                    stage.setScene(refresh(stage));
                    createAlert(true, "****BANCO BUST, YOU WIN****", "Wanna Play Again with the same bet?", stage, WIN_PATH);
                }
                else if (game.getPlayer().countPoints() > game.getCasino().countPoints()) {
                    if (game.getPlayer().isBlackJack()) {
                        game.getPlayer().setMoney(game.getPlayer().getMoney() + bet * 2);
                    }
                    game.getPlayer().setMoney(game.getPlayer().getMoney() + bet * 2);
                    stage.setScene(refresh(stage));
                    createAlert(true, "****YOU WIN****", "YOUR POINTS = " + game.getPlayer().countPoints() +
                            "\nCASINO POINTS = " + game.getCasino().countPoints() + "\nWanna Play Again with the same bet?", stage, WIN_PATH);

                } else if (game.getPlayer().countPoints() == game.getCasino().countPoints()) {
                    game.getPlayer().setMoney(game.getPlayer().getMoney() + bet);
                    game.getCasino().setMoney(game.getCasino().getMoney() + bet);
                    stage.setScene(refresh(stage));
                    createAlert(true, "****DRAW****", "YOUR POINTS = " + game.getPlayer().countPoints() +
                            "\nCASINO POINTS = " + game.getCasino().countPoints() + "\nWanna Play Again with the same bet?", stage, DRAW_PATH);

                } else {
                    game.getCasino().setMoney(game.getCasino().getMoney() + bet * 2);
                    stage.setScene(refresh(stage));
                    createAlert(true, "****YOU LOSE****", "YOUR POINTS = " + game.getPlayer().countPoints() +
                            "\nCASINO POINTS = " + game.getCasino().countPoints() + "\nWanna Play Again with the same bet?", stage, LOSE_PATH);
                }
                stage.setScene(refresh(stage));
            });
            scrollPane = new ScrollPane(gridCard);

        }
        BorderPane borderPane = new BorderPane();
        HBox box = new HBox();
        box.getChildren().addAll(call, stay);
        box.setAlignment(Pos.BASELINE_CENTER);
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(box);
        borderPane.setRight(getMoneys());
        borderPane.setMinSize(500,500);
        File file2 = new File(createFilePath(PATH_BG));
        javafx.scene.image.Image img2 = new Image(file2.getAbsoluteFile().toURI().toString());
        BackgroundImage bgImg2 = new BackgroundImage(img2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,false,false,false,true));
        borderPane.setBackground(new Background(bgImg2));
        Scene scene = new Scene(borderPane);
        return scene;
    }

    private String createFilePath(String path) {
        String finalPath = new File("").getAbsolutePath();
        return finalPath + path;
    }

    private Button createCards(String path){
        File file = new File(createFilePath(path));
        javafx.scene.image.Image img = new Image(file.getAbsoluteFile().toURI().toString());
        Button button = new Button();
        BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(150.0,100.0,false,false,true,false));
        Background bg = new Background(bgImg);
        button.setBackground(bg);
        button.setMinHeight(200);
        button.setMinWidth(160);
        return button;
        }

    private Button genCard(Card card){
        if(card.isFolded()){
            return createCards(PATH_FOLDED);
        }
        if(card.getValue().contains("Hearts")){
            switch (card.getNumValue()){
                case 11:
                    return createCards(PATH_AH);
                case 2:
                    return createCards(PATH_2H);
                case 3:
                    return createCards(PATH_3H);
                case 4:
                    return createCards(PATH_4H);
                case 5:
                    return createCards(PATH_5H);
                case 6:
                    return createCards(PATH_6H);
                case 7:
                    return createCards(PATH_7H);
                case 8:
                    return createCards(PATH_8H);
                case 9:
                    return createCards(PATH_9H);
                case 10:
                    if(card.getValue().contains("King")){
                        return createCards(PATH_KH);
                    }
                    else if(card.getValue().contains("Jack")){
                        return createCards(PATH_JH);
                    }
                    else if(card.getValue().contains("Queen")){
                        return createCards(PATH_QH);
                    }
                    else{
                        return createCards(PATH_10H);
                    }
            }
    }
        else if(card.getValue().contains("Diamonds")){
            switch (card.getNumValue()){
                case 11:
                    return createCards(PATH_AD);
                case 2:
                    return createCards(PATH_2D);
                case 3:
                    return createCards(PATH_3D);
                case 4:
                    return createCards(PATH_4D);
                case 5:
                    return createCards(PATH_5D);
                case 6:
                    return createCards(PATH_6D);
                case 7:
                    return createCards(PATH_7D);
                case 8:
                    return createCards(PATH_8D);
                case 9:
                    return createCards(PATH_9D);
                case 10:
                    if(card.getValue().contains("King")){
                        return createCards(PATH_KD);
                    }
                    else if(card.getValue().contains("Jack")){
                        return createCards(PATH_JD);
                    }
                    else if(card.getValue().contains("Queen")){
                        return createCards(PATH_QD);
                    }
                    else{
                        return createCards(PATH_10D);
                    }
            }
    }
        else if(card.getValue().contains("Clubs")){
            switch (card.getNumValue()){
                case 11:
                    return createCards(PATH_AC);
                case 2:
                    return createCards(PATH_2C);
                case 3:
                    return createCards(PATH_3C);
                case 4:
                    return createCards(PATH_4C);
                case 5:
                    return createCards(PATH_5C);
                case 6:
                    return createCards(PATH_6C);
                case 7:
                    return createCards(PATH_7C);
                case 8:
                    return createCards(PATH_8C);
                case 9:
                    return createCards(PATH_9C);
                case 10:
                    if(card.getValue().contains("King")){
                        return createCards(PATH_KC);
                    }
                    else if(card.getValue().contains("Jack")){
                        return createCards(PATH_JC);
                    }
                    else if(card.getValue().contains("Queen")){
                        return createCards(PATH_QC);
                    }
                    else{
                        return createCards(PATH_10C);
                    }
            }

    }
        else if(card.getValue().contains("Spades")){
            switch (card.getNumValue()){
                case 11:
                    return createCards(PATH_AS);
                case 2:
                    return createCards(PATH_2S);
                case 3:
                    return createCards(PATH_3S);
                case 4:
                    return createCards(PATH_4S);
                case 5:
                    return createCards(PATH_5S);
                case 6:
                    return createCards(PATH_6S);
                case 7:
                    return createCards(PATH_7S);
                case 8:
                    return createCards(PATH_8S);
                case 9:
                    return createCards(PATH_9S);
                case 10:
                    if(card.getValue().contains("King")){
                        return createCards(PATH_KS);
                    }
                    else if(card.getValue().contains("Jack")){
                        return createCards(PATH_JS);
                    }
                    else if(card.getValue().contains("Queen")){
                        return createCards(PATH_QS);
                    }
                    else{
                        return createCards(PATH_10S);
                    }
            }
    }
        return new Button("ERROR -NO CARD IMG MATCHES");
    }

    private void createAlert(boolean newGame, String headerText, String contentText, Stage stage,String path){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);


        alert.getDialogPane().setGraphic(createCards(path));
        if(newGame){
            Optional<ButtonType> result = alert.showAndWait();
            handOver = true;
            if(!result.isPresent() || result.get() == ButtonType.CANCEL){
                stage.close();
            }
            else if(result.get() == ButtonType.OK)
            {
                startNewHand(stage);
            }
        }
        else{
            alert.show();
        }
    }
}

