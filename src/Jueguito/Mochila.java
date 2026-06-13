package Jueguito;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class Mochila {
    
    private int capacidadMaxima;
    private List<ObjetoMovil> items = new ArrayList<>();
    
    public Mochila(int capacidadMaxima) {
        this.capacidadMaxima = Math.max(0, capacidadMaxima);
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public boolean agregarItem(ObjetoMovil item) {
        if (item == null) {
            return false;
        }
        if (items.size() >= capacidadMaxima) {
            return false;
        }
        items.add(item);
        return true;
    }
    
    public void removerItem(ObjetoMovil item) {
        items.remove(item);
    }

    public boolean estaLlena() {
        return items.size() >= capacidadMaxima;
    }

    public List<ObjetoMovil> obtenerItems() {
        return new ArrayList<>(items);
    }
    
    public void ampliarCapacidad(int n) {
        if (n > 0) {
            capacidadMaxima += n;
        }
    }
    
}
