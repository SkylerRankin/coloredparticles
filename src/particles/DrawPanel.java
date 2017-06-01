package particles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
    
    private ArrayList<Particle> particles;
    private ArrayList<Line> lines;
    
    public DrawPanel() {
        particles = new ArrayList<>();
        lines = new ArrayList<>();
        setPreferredSize(new Dimension(1000, 500));
        setBackground(new Color(10, 10, 10));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Line l : lines)
            l.draw(g);
        g.setColor(Color.white);
        for (Particle p : particles) {
            //p.draw(g);
        }
    }
    
    public void setParticles(ArrayList<Particle> p) { particles = p; }
    public void setLines(ArrayList<Line> l) { lines = l; }
    
}