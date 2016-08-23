package uteis;

/**
 *
 * @author Kelvin Classe responsavel por efetura calculo para conversão de
 * valores
 */
public class Convert {

    private static Integer calcX(Coordenada coordenada, ViewPort viewPort) {
        float subtracao1 = coordenada.getX() - viewPort.getxWMin();
        float subtracao2 = viewPort.getxWMax() - viewPort.getxWMin();
        float divisao = subtracao1 / subtracao2;
        float subtracao3 = viewPort.getxVpMax() - viewPort.getxVpMin();
        float x = viewPort.getxVpMin() + (divisao * subtracao3);
        return Math.round(x);
    }

    private static Integer calcY(Coordenada coordenada, ViewPort viewPort) {
        float subtracao1 = coordenada.getY() - viewPort.getyWMin();
        float subtracao2 = viewPort.getyWMax() - viewPort.getyWMin();
        float divisao = subtracao1 / subtracao2;
        float subtracao3 = viewPort.getyVpMax() - viewPort.getyVpMin();
        float y = viewPort.getyVpMax() - (divisao * subtracao3);
        return Math.round(y);
    }

    public static Coordenada toViewPort(Coordenada coordenada, ViewPort viewPort) {
        int x = calcX(coordenada, viewPort);
        int y = calcY(coordenada, viewPort);
        return new Coordenada(x, y);
    }

}
