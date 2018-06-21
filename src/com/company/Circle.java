package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Circle implements ShapeInterface {

    protected final GraphicsContext gc;

    protected final int WIDTH = 100;
    protected final int HEIGHT = 100;
    Board board;

    protected int x;
    protected int y;
    protected double speedX;
    protected double speedY;
    List<Circle> nodes = new ArrayList<>();

    public Circle(GraphicsContext gc, List<Circle> nodes) {
        this.gc = gc;
        this.nodes = nodes;
        Random random = new Random();

        speedX = random.nextInt(20) - 10;
        speedY = random.nextInt(20) - 10;

        x = random.nextInt(Config.WIDTH - WIDTH);
        y = random.nextInt(Config.HEIGHT - HEIGHT);
    }




    @Override
    public void move() {
        x += speedX;
        y += speedY;

        if (x + WIDTH >= Config.WIDTH) {
            speedX = -speedX;
        }
        if (x <= 0) {
            speedX = -speedX;
        }
        if (y + HEIGHT >= Config.HEIGHT) {
            speedY = -speedY;
        }
        if (y <= 0) {
            speedY = -speedY;

        }
        if(checkDistance()<100){
            speedX = -speedX;
            speedY = -speedY;
        }
    }
    double checkDistance() {
        double AC;
        double BC;
        double AB = 0;
        for (int i=0;;i++) {
            if(i==nodes.size()-1){
                i=0;
            }
            AC = getX() - nodes.get(i).getX();
            BC = getY() - nodes.get(i).getY();
            AB = Math.sqrt(AC * AC + BC * BC);
            return AB;
        }
    }

    public void draw() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
