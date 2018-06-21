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

    void checkDistance() {
        double AC = nodes.get(1).getX() - nodes.get(0).getX();
        double BC = nodes.get(1).getY() - nodes.get(0).getY();
        double AB = Math.sqrt(AC * AC + BC * BC);
    }


    @Override
    public void move() {
        x += speedX;
        y += speedY;

        double AC = nodes.get(1).getX() - nodes.get(0).getX();
        double BC = nodes.get(1).getY() - nodes.get(0).getY();
        double AB = Math.sqrt(AC * AC + BC * BC);

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
        if (AB < 100) {
            speedX = -speedX;
            speedY = -speedY;
        }
//        if ((Math.abs(nodes.get(0).getX() - nodes.get(1).getX()) <= 100) && (Math.abs(nodes.get(0).getY() - nodes.get(1).getY()) <= 100)) {
//            speedX = -speedX;
//        }if ((Math.abs(nodes.get(0).getX() - nodes.get(2).getX()) <= 100) && (Math.abs(nodes.get(0).getY() - nodes.get(2).getY()) <= 100)) {
//            speedX = -speedX;
//        }if ((Math.abs(nodes.get(1).getX() - nodes.get(2).getX()) <= 100) && (Math.abs(nodes.get(1).getY() - nodes.get(2).getY()) <= 100)) {
//            speedX = -speedX;
//        }

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
