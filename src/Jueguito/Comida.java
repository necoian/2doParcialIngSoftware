package Jueguito;

/**
 *
 * @author ian
 */
public class Comida extends ObjetoMovil {
    
    private int cantidadVidaRellena;
    private int usos;

    public Comida(int x, int y, int cantidadVidaRellena, int usos) {
        super(x, y);
        
        this.cantidadVidaRellena = cantidadVidaRellena;
        this.usos = usos;
    }

    public int getCantidadVidaRellena() {
        return cantidadVidaRellena;
    }

    public int getUsos() {
        return usos;
    }
    
    public int usar() {
        if (usos <= 0) {
            return 0;
        }
        usos--;
        return cantidadVidaRellena;
    }
    
    public boolean estaVacia() { 
        return usos <= 0; 
    }
    
}
