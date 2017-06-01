package particles;
public class Vector2D {
    
    private double x;
    private double y;
    
    public Vector2D() {
        x = 0;
        y = 0;
    }
    
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double mag() {
        return Math.sqrt((x*x) + (y*y));
    }
    
    public void add(Vector2D a) {
        x += a.getX();
        y += a.getY();
    }
    
    public Vector2D sub(Vector2D a) {
        x -= a.getX();
        y -= a.getY();
        return this;
    }
    
    public void mult(int a) {
        x*=a;
        y*=a;
    }
    
    public void setMag(double mag) {
        // 1   2
        // 3   4
        int quad = 1;
        if (x > 0 && y > 0) quad = 2;
        else if (x > 0 && y < 0) quad = 4;
        else if (x < 0 && y > 0) quad = 1;
        else quad = 3;
        
        double angle = 0;
        if (x == 0) {
            if (y > 0) angle = Math.PI / 2;
            else if (y < 0) angle = Math.PI * (3/2);
        } else { angle = Math.atan(y/x); }
        
        switch(quad) {
            case 1:
                angle = (Math.PI/2 - angle) + (Math.PI/2); break;
            case 3:
                angle = angle + Math.PI;
            case 4:
                angle = 2*Math.PI - angle;
        }
        
        x = mag*Math.cos(angle);
        y = mag*Math.sin(angle);
    }
    
    public void limit(double min, double max) {
        if (mag() < min) setMag(min);
        else if (mag() > max) setMag(max);
    }
    
    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }
    
    public double getX() {return x;}
    public double getY() {return y;}
    public void setX(double a) { x = a; }
    public void setY(double a) { y = a; }
    
    public String toString() {
        return "("+x+", "+y+")";
    }
    
}