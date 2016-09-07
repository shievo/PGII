package uteis;

public class Coordenada {
    private int x, y, z;

    public Coordenada() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public Coordenada(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;//por hora nao sera impresso z
    }
    
    public Coordenada add(Coordenada other) {
        int x, y, z;
        
        x = this.getX();
        x += other.getX();
        
        y = this.getY();
        y += other.getY();
        
        z = this.getZ();
        z += other.getZ();
        
        return new Coordenada(x, y, z);
    }
    
    
}
