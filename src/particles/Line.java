package particles;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line {
    
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double length;
    private Color color;
    
    public Line(double x1, double y1, double x2, double y2, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow((y2 - y1), 2));
        color = c;
    }
    
    public void draw(Graphics g) {
        Color c = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)map(length, 0, 120, 255, 0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(c);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }
    
    public double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
}
