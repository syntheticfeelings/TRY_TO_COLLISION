package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    private GraphicsContext gc;

    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(Config.WIDTH, Config.HEIGHT);

        BorderPane group = new BorderPane();
        group.setCenter(canvas);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20) );
        text.setX(50) ;
        text.setY(130) ;
        text.setText("Hi how are you") ;


        gc = canvas.getGraphicsContext2D();
        createTimer();

        board = new Board(gc);
    }

    private void createTimer() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                clean();
                board.move();
                board.draw();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 20, 20);

    }

    private void clean() {
        gc.clearRect(0, 0, Config.WIDTH, Config.HEIGHT);
    }

}

