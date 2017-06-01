package particles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;

public class control {
    
    private model model;
    private view view;
    private Timer timer;
    
    public control(model m, view v) {     
        
        model = m;
        view = v;
        timer = new Timer(20, new TimerListener());
        view.addMouseMoveListener(new MouseMoveListener());
        timer.start();
    }
    
    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == timer) {
                model.moveParticles();
                model.setLines();
                view.setParticles(model.getParticles());
                view.setLines(model.getLines());
                
                view.refresh();
            }
        }
    }
    
    public class MouseMoveListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent me) {}
        public void mouseMoved(MouseEvent me) {
            model.setRepulsor(me.getX(), me.getY());
        }
    }
    
}
