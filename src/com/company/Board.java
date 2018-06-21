package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int WIDTH = 60;
    int x = 0;
    private GraphicsContext gc;
    List<Circle> nodes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        for (int i = 0; i < 2; i++) {
            nodes.add(new Circle(gc, nodes));
        }
    }
    public void move() {
        for (Circle shape : nodes) {
            shape.move();
        }
    }
    public void draw() {
        for (Circle shape : nodes) {
            shape.draw();
        }
    }
}
