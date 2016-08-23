package uteis;

/**
 *
 * @author Kelvin
 */
public class ViewPort {
    //tamanho da janela
    private Integer xWMin, xWMax, yWMin, yWMax;
    //tamanho do view port
    private Integer xVpMin, xVpMax, yVpMin, yVpMax;
    //modificadores de posição e zoom
    private Integer zoom, xMov, yMov;
    
    public ViewPort() {
        //Inicializador padrao
    }

    public ViewPort(Integer xWMin, Integer xWMax, Integer yWMin, Integer yWMax, Integer xVpMin, Integer xVpMax, Integer yVpMin, Integer yVpMax) {
        this.xWMin = xWMin;
        this.xWMax = xWMax;
        this.yWMin = yWMin;
        this.yWMax = yWMax;
        this.xVpMin = xVpMin;
        this.xVpMax = xVpMax;
        this.yVpMin = yVpMin;
        this.yVpMax = yVpMax;
    }

    public ViewPort(Integer xWMin, Integer xWMax, Integer yWMin, Integer yWMax, Integer xVpMin, Integer xVpMax, Integer yVpMin, Integer yVpMax, Integer xMov, Integer yMov, Integer zoom) {
        this.xWMin = xWMin;
        this.xWMax = xWMax;
        this.yWMin = yWMin;
        this.yWMax = yWMax;
        this.xVpMin = xVpMin;
        this.xVpMax = xVpMax;
        this.yVpMin = yVpMin;
        this.yVpMax = yVpMax;
        this.xMov = xMov;
        this.yMov = yMov;
        this.zoom = zoom;
    }
    
    public Integer getxWMin() {
        return xWMin;
    }

    public void setxWMin(Integer xWMin) {
        this.xWMin = xWMin;
    }

    public Integer getxWMax() {
        return xWMax;
    }

    public void setxWMax(Integer xWMax) {
        this.xWMax = xWMax;
    }

    public Integer getyWMin() {
        return yWMin;
    }

    public void setyWMin(Integer yWMin) {
        this.yWMin = yWMin;
    }

    public Integer getyWMax() {
        return yWMax;
    }

    public void setyWMax(Integer yWMax) {
        this.yWMax = yWMax;
    }

    public Integer getxVpMin() {
        return xVpMin;
    }

    public void setxVpMin(Integer xVpMin) {
        this.xVpMin = xVpMin;
    }

    public Integer getxVpMax() {
        return xVpMax;
    }

    public void setxVpMax(Integer xVpMax) {
        this.xVpMax = xVpMax;
    }

    public Integer getyVpMin() {
        return yVpMin;
    }

    public void setyVpMin(Integer yVpMin) {
        this.yVpMin = yVpMin;
    }

    public Integer getyVpMax() {
        return yVpMax;
    }

    public void setyVpMax(Integer yVpMax) {
        this.yVpMax = yVpMax;
    }

    
}
