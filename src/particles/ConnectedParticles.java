package particles;
import java.awt.EventQueue;

public class ConnectedParticles {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable()
       {
           @Override
           public void run()
           {
               view v = new view();
               model m = new model();
               control c = new control(m, v);
               v.setVisible(true);
           }
       }
       );
    }
    
}
