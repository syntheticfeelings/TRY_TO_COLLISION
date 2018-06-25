package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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


    void checkDistance1(Circle circle) {
        double AC1;
        double BC1;
        double AC2;
        double BC2;
        double AC3;
        double BC3;

        AC1 = circle.getX() - nodes.get(1).getX();
        BC1 = circle.getY() - nodes.get(1).getY();
        double AB1 = Math.sqrt(AC1 * AC1 + BC1 * BC1);

        AC2 = circle.getX() - nodes.get(2).getX();
        BC2 = circle.getY() - nodes.get(2).getY();
        double AB2 = Math.sqrt(AC2 * AC2 + BC2 * BC2);

        AC3 = nodes.get(1).getX() - nodes.get(2).getX();
        BC3 = nodes.get(1).getY() - nodes.get(2).getY();
        double AB3 = Math.sqrt(AC3 * AC3 + BC3 * BC3);

        if (AB1 < 100) {
            nodes.get(1).speedX = -nodes.get(1).speedX;
            nodes.get(1).speedY = -nodes.get(1).speedY;
            circle.speedX = -circle.speedX;
            circle.speedY = -circle.speedY;

        }
        if (AB2 < 100) {
            nodes.get(2).speedX = -nodes.get(2).speedX;
            nodes.get(2).speedY = -nodes.get(2).speedY;
            circle.speedX = -circle.speedX;
            circle.speedY = -circle.speedY;
        }
        if (AB3 < 100) {
            nodes.get(2).speedX = -nodes.get(2).speedX;
            nodes.get(2).speedY = -nodes.get(2).speedY;
            nodes.get(1).speedX = -nodes.get(1).speedX;
            nodes.get(1).speedY = -nodes.get(1).speedY;
        }
    }

    @Override
    public void move() {
        x += speedX;
        y += speedY;

        checkDistance1(nodes.get(0));

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
