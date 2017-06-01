package particles;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class model {
    
    private ArrayList<Particle> particles;
    private ArrayList<Line> lines;
    private int width = 1000;
    private int height = 500;
    private Vector2D repulsor;
    
    public model() {
        particles = new ArrayList<>();
        lines = new ArrayList<>();
        repulsor = new Vector2D(500, 250);
        for (int i = 0; i < 100; ++i)
            particles.add(new Particle(width, height, 1));
    }
    
    public void setLines() {
        lines.clear();
        for (Particle p : particles) {
            for (Particle p2 : particles) {
                if (p != p2) {
                    double dist = Math.sqrt(Math.pow(p.getX() - p2.getX(), 2) + Math.pow((p.getY() - p2.getY()), 2));
                    if (dist < 120)
                        lines.add(new Line(p.getX(), p.getY(), p2.getX(), p2.getY(), getColor(p.getX())));
                }
            }
        }
    }
    public void moveParticles() {
        ArrayList<Particle> toRemove = new ArrayList<>();
        for (Particle p : particles) {
            p.repel(repulsor);
            p.move();
            if (p.outOfBounds(1000, 500)) {
                toRemove.add(p);
            }
        }
        particles.removeAll(toRemove);
        for (int i = 0; i < toRemove.size(); ++i) particles.add(new Particle(width, height));
        
    }
    
    public ArrayList<Particle> getParticles() { return particles; }
    public ArrayList<Line> getLines() { return lines; }
    
    public void setRepulsor(int a, int b) {
        repulsor.setX(a);
        repulsor.setY(b);
    }

    public Color getColor(double x) {
        /*
        Start (255, 0, 0)
        
        1 - G to 255
        2 - R to 0
        3 - B to 255
        4 - G to 0
        5 - R to 255
        6 - B to 0
        
        x value is from 0 to 1000
        
        */
        
        double range = map(x, 0, 1000, 0, 255*6);
        int section = (int)range / 255;
        int delta = (int)range - (section*255);
        
        double increment = width / 6;
        int col = (int) (x  / increment);
        Color c= new Color(0, 0, 0);
        switch (col + 1) {
            case 1:
                c = new Color(255, delta, 0);
                break;
            case 2:
                c = new Color(delta, 255, 0);
                break;
            case 3:
                c = new Color(0, 255, delta);
                break;
            case 4:
                c = new Color(0, delta, 255);
                break;
            case 5:
                c = new Color(delta, 0, 255);
                break;
            case 6:
                c = new Color(255, 0, delta);
                break;
        }
        return c;
    }
    
    public double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
