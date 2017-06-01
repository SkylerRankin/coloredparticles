package particles;
import java.awt.Graphics;
import java.util.Random;
import java.util.Vector;

public class Particle {
    
    private Vector2D pos;
    private Vector2D vel;
    private Vector2D acc = new Vector2D();
    
    private double radius = 6;
    
    public Particle(int xMax, int yMax, int a) {
        pos = new Vector2D(random(0, xMax), random(0, yMax));
        switch (random(1, 4)) {
            case 1:
                double dir = (double) random(31415, 62831) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 2:
                dir = (double) random(15707, 47123) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 3:
                dir = (double) random(0, 31415) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 4:
                dir = (double) random(-15707, 15707) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
        }
    }
    public Particle(int xMax, int yMax) {
        switch (random(1, 4)) { //1 = top, 2 = right, 3 = bottom, 4 = left
            case 1:
                pos = new Vector2D(random(0, xMax), 1);
                //double dir = (double) random(31415, 62831) / 10000;
                double dir = (double) random(0, 31415) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 2:
                pos = new Vector2D(xMax - 1, random(0, yMax));
                dir = (double) random(15707, 47123) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 3:
                pos = new Vector2D(random(0, xMax), yMax - 1);
                //dir = (double) random(0, 31415) / 10000;
                dir = (double) random(31415, 62831) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
            case 4:
                pos = new Vector2D(1, random(0, yMax));
                dir = (double) random(-15707, 15707) / 10000;
                vel = new Vector2D(Math.cos(dir), Math.sin(dir));
                break;
        }
        
    }
    
    public void draw(Graphics g) {
        g.fillOval((int)(pos.getX() - radius / 2), (int)(pos.getY() - radius / 2), (int)radius, (int)radius);
    }
    public void move() {
        pos.add(vel);
        vel.add(acc);
        acc.mult(0);
        radius = random(3, 8);
    }
    public boolean outOfBounds(double xMax, double yMax) {
        return (pos.getX() < 0 || pos.getX() > xMax || pos.getY() < 0 || pos.getY() > yMax);
    }
    
    public void repel(Vector2D target) {
        Vector2D a = pos.copy();
        Vector2D force = a.sub(target);
        double dist = force.mag();
        double strength = 200/(dist*dist);
        force.setMag(strength);
        force.limit(-20, 20);
        acc.add(force);
    }
        
    public double getX() {return pos.getX(); }
    public double getY() {return pos.getY(); }
    public double getAX() { return acc.getX(); }
    public double getAY() { return acc.getY(); }
    //public void setAX(double a) { ax = a; }
    //public void setAY(double a) {  ay = a; }
    
    public int random(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}


/*
public Particle(int xMax, int yMax) {
        switch (random(1, 4)) { //1 = top, 2 = right, 3 = bottom, 4 = left
            case 1:
                x = random(0, xMax);
                y = 1;
                //double dir = (double) random(31415, 62831) / 10000;
                double dir = (double) random(0, 31415) / 10000;
                vx = Math.cos(dir);
                vy = Math.sin(dir);
                break;
            case 2:
                x = xMax - 1;
                y = random(0, yMax);
                dir = (double) random(15707, 47123) / 10000;
                vx = Math.cos(dir);
                vy = Math.sin(dir);
                break;
            case 3:
                x = random(0, xMax);
                y = yMax - 1;
                //dir = (double) random(0, 31415) / 10000;
                dir = (double) random(31415, 62831) / 10000;
                vx = Math.cos(dir);
                vy = Math.sin(dir);
                break;
            case 4:
                x = 1;
                y = random(0, yMax);
                dir = (double) random(-15707, 15707) / 10000;
                vx = Math.cos(dir);
                vy = Math.sin(dir);
                break;
        }
        
    }
*/