package uteis;

public class Coordenada {

    private float x, y, z;

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

    public Coordenada(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    } 

    public int getX() {
        return Math.round(x);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return Math.round(y);
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return Math.round(z);
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int get(int index) {
        switch (index) {
            case 0:
                return Math.round(x);
            case 1:
                return Math.round(y);
            case 2:
                return Math.round(z);
        }
        return 0;
    }

    public float getAsFloat(int index) {
        switch (index) {
            case 0:
                return x;
            case 1:
                return y;
            case 2:
                return z;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", z=" + z;//por hora nao sera impresso z
    }

    public Coordenada add(Coordenada other) {
        float x, y, z;

        x = this.getXasFloat();
        x += other.getXasFloat();

        y = this.getYasFloat();
        y += other.getYasFloat();

        z = this.getZasFloat();
        z += other.getZasFloat();

        return new Coordenada(x, y, z);
    }
    
    public Coordenada subtract(Coordenada other) {
        float x, y, z;

        x = this.getXasFloat();
        x -= other.getXasFloat();

        y = this.getYasFloat();
        y -= other.getYasFloat();

        z = this.getZasFloat();
        z -= other.getZasFloat();

        return new Coordenada(x, y, z);
    }

    public float getXasFloat() {
        return x;
    }

    public float getYasFloat() {
        return y;
    }

    public float getZasFloat() {
        return z;
    }

}