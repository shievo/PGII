/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelvin
 */
public class Calcular {

    public static List<Coordenada> genDefMatiz(int size, Coordenada valueDef) {
        List<Coordenada> matriz = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            matriz.add(valueDef);
        }

        return matriz;
    }

    public static List<Coordenada> somarMatrizCoordenada(List<Coordenada> a, List<Coordenada> b) {
        if (a.size() != a.size()) {
            return null;
        }
        List<Coordenada> s = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            Coordenada coordA = a.get(i);
            Coordenada coordB = b.get(i);
            Coordenada coordS = coordA.add(coordB);
            s.add(coordS);
        }
        return s;
    }

    public static List<Coordenada> multiplicarMatrizCoordenada(List<Coordenada> a, List<Coordenada> b) {
        List<Coordenada> s = new ArrayList<>();
        if (b.size() != 3) {
            return null;
        }
        for (Coordenada coordenadaA : a) {
            int x, y, z;
            x = y = z = 0;
            for (int i = 0; i < b.size(); i++) {
                Coordenada coordenadaB = b.get(i);
                x += coordenadaB.getX() * coordenadaA.get(i);
                y += coordenadaB.getY() * coordenadaA.get(i);
                z += coordenadaB.getZ() * coordenadaA.get(i);
            }
            Coordenada coordenadaS = new Coordenada(x, y, z);
            s.add(coordenadaS);
        }
        return s;
    }

    public static Coordenada multiplicarMatrizCoordenada(Coordenada coordenadaA, List<Coordenada> b) {
        if (b.size() != 3) {
            return null;
        }
        int x, y, z;
        x = y = z = 0;
        for (int i = 0; i < b.size(); i++) {
            Coordenada coordenadaB = b.get(i);
            x += coordenadaB.getX() * coordenadaA.get(i);
            y += coordenadaB.getY() * coordenadaA.get(i);
            z += coordenadaB.getZ() * coordenadaA.get(i);
        }
        return new Coordenada(x, y, z);
    }

    public static List<Coordenada> getMatrizTranslacao(Coordenada coordenada) {
        List<Coordenada> matrizTranslacao = new ArrayList<>();
        matrizTranslacao.add(new Coordenada(1, 0, 0));
        matrizTranslacao.add(new Coordenada(0, 1, 0));
        matrizTranslacao.add(coordenada);
        return matrizTranslacao;
    }

    public static List<Coordenada> getMatrizEscalonamento(Coordenada coordenada) {
        List<Coordenada> matrizTranslacao = new ArrayList<>();
        matrizTranslacao.add(new Coordenada(coordenada.getX(), 0, 0));
        matrizTranslacao.add(new Coordenada(0, coordenada.getY(), 0));
        matrizTranslacao.add(new Coordenada(0, 0, coordenada.getZ()));
        return matrizTranslacao;
    }
}
