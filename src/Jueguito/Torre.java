package Jueguito;

/**
 *
 * @author ian
 */
public class Torre extends ObjetoInmovil {
    
    private double alcance;
    private int potenciaDisparo;
    
    public Torre(int x, int y, double alcance, int potenciaDisparo) {
        super(x, y);
        this.alcance = alcance;
        this.potenciaDisparo = potenciaDisparo;
    }

    public double getAlcance() {
        return alcance;
    }

    public int getPotenciaDisparo() {
        return potenciaDisparo;
    }
    
    public boolean puedeAlcanzar(ElementoJuego objetivo) {
        double dx = objetivo.getX() - this.x;
        double dy = objetivo.getY() - this.y;
        double distancia = Math.hypot(dx, dy);
        if (distancia <= alcance) {
            return true;
        } else {
            return false;
        }
    }
    
}
