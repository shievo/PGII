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
        
        for (int i = 0; i < size; i++)
            matriz.add(valueDef);
        
        return matriz;
    }
    
    public static List<Coordenada> somarMatrizCoordenada(List<Coordenada> a, List<Coordenada> b) {
        if (a.size() != a.size())
            return null;
        List<Coordenada> s = new ArrayList<>();
        
        for (int i = 0; i < a.size(); i++) {
            Coordenada coordA = a.get(i);
            Coordenada coordB = b.get(i);
            Coordenada coordS = coordA.add(coordB);
            s.add(coordS);
        }
        return s;
    }
    
}
