package Jueguito;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class Armadura {
    
    private int resistencia;
    private int duracion;
    private List<PiezaArmadura> piezas = new ArrayList<>();

    public Armadura(int resistencia, int duracion) {
        this.resistencia = resistencia;
        this.duracion = Math.max(0, duracion);
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getDuracion() {
        return duracion;
    }

    public List<PiezaArmadura> getPiezas() {
        return piezas;
    }
    
    public void agregarPieza(PiezaArmadura p) {
        if (p == null) {
            return;
        }
        if (piezas.size() < 5) piezas.add(p);
    }
    
    public void recibirDanio(int d) {
        duracion -= d;
        if (duracion <= 0) {
            duracion = 0;
            piezas.clear();
        }
    }
}
