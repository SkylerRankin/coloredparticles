package particles;
import java.util.ArrayList;
import javax.swing.JFrame;

import particles.control.MouseMoveListener;

public class view extends JFrame{
    
    private DrawPanel dp;
    
    public view() {
        super("Polygon Repulsion Gravity Field");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dp = new DrawPanel();
        add(dp);
        pack();
    }
    
    public void setParticles(ArrayList<Particle> p) {  dp.setParticles(p); }
    public void setLines(ArrayList<Line> p) {  dp.setLines(p); }
    public void addMouseMoveListener(MouseMoveListener ml) {
        dp.addMouseMotionListener(ml);
    }
    public void refresh() { dp.repaint(); }    
}