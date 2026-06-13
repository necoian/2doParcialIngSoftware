package Jueguito;

/**
 *
 * @author ian
 */
public class Muralla extends ObjetoInmovil {
    
    private int nivelRecuperacion;
    private int mejorasDefensa;
    
    public Muralla(int x, int y, int nivelRecuperacion, int mejorasDefensa) {
        super(x, y);
        this.nivelRecuperacion = nivelRecuperacion;
        this.mejorasDefensa = mejorasDefensa;
    }

    public int getNivelRecuperacion() {
        return nivelRecuperacion;
    }

    public int getMejorasDefensa() {
        return mejorasDefensa;
    }
    
    public void recuperar() {
        nivelRecuperacion++;
    }
    
}
