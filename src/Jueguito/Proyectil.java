package Jueguito;

/**
 *
 * @author ian
 */
public class Proyectil {
    
    public enum Tipo { HIELO, FUEGO, ACIDO }

    private Tipo tipo;
    private int cantidad;        // número de unidades de proyectil
    private int danio;           // daño por unidad
    private String efecto;       // "congela", "quema", "envenena"
    private int disparosRestantes;

    public Proyectil(Tipo tipo, int cantidad, int danio, String efecto) {
        this.tipo = tipo;
        this.cantidad = Math.max(0, cantidad);
        this.danio = danio;
        this.efecto = efecto;
        this.disparosRestantes = this.cantidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDanio() {
        return danio;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getDisparosRestantes() {
        return disparosRestantes;
    }
    
    public int consumirParaDisparo(int n) {
        if (n <= 0 || disparosRestantes <= 0) {
            return 0;
        }
            
        int consumido = Math.min(n, disparosRestantes);
        disparosRestantes -= consumido;
        cantidad = Math.max(0, cantidad - consumido);
        return consumido * danio;
    }
    
    //no calcula daño
    public void consumir(int n) {
        if (n <= 0) return;
        int consumido = Math.min(n, disparosRestantes);
        disparosRestantes -= consumido;
        cantidad = Math.max(0, cantidad - consumido);
    }
    
    //Returna true en cualquiera de las situaciones
    public boolean estaAgotado() {
        return disparosRestantes <= 0 || cantidad <= 0;
    }
    
    public void agregarMunicion(int n) {
        if (n <= 0) {
            return;
        }
        cantidad += n;
        disparosRestantes += n;
    }
    
    
}
