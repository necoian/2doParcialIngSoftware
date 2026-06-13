package Jueguito;

/**
 *
 * @author ian
 */
public abstract class Personaje extends ObjetoMovil {
    
    protected int nivelEnergia;
    protected int vidas;
    protected int capacidadOfensiva;
    protected double ancho;
    protected double alto;
    protected String textura;
    protected String habNormales;
    protected String habEspeciales;
    protected int vidaMaxima;
    protected int vidaActual;
    protected int energiaMaxima;
    protected int energiaActual;
    
    public Personaje(int x, int y, int nivelEnergia, int vidas, int capacidadOfensiva,
                     int vidaMaxima, int energiaMaxima) {
        super(x, y);
        this.nivelEnergia = nivelEnergia;
        this.vidas = vidas;
        this.capacidadOfensiva = capacidadOfensiva;
        this.vidaMaxima = Math.max(1, vidaMaxima);
        this.vidaActual = this.vidaMaxima;
        this.energiaMaxima = Math.max(0, energiaMaxima);
        this.energiaActual = this.energiaMaxima;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public int getEnergiaActual() {
        return energiaActual;
    }
    
    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima > 0) {
            this.vidaMaxima = vidaMaxima;
            if (this.vidaActual > vidaMaxima) {
                this.vidaActual = vidaMaxima;
            }
        }
    }
    
    public void setVidaActual(int vidaActual) {
        this.vidaActual = Math.max(0, Math.min(vidaActual, vidaMaxima));
    }
    
    public void setEnergiaActual(int energiaActual) {
        this.energiaActual = Math.max(0, Math.min(energiaActual, energiaMaxima));
    }
    
    public void setEnergiaMaxima(int energiaMaxima) {
        if (energiaMaxima >= 0) {
            this.energiaMaxima = energiaMaxima;
            if (this.energiaActual > energiaMaxima) {
                this.energiaActual = energiaMaxima;
            }
        }
    }
    
    
    public void caminar() {
        this.x += 1;
    }
    
     public void correr() {
        this.x += 2;
        setEnergiaActual(this.energiaActual - 5);
    }
    
    public void saltar() {
        
        this.y += 1;
        
    }
    
    //Se trabaja en sus subclases
    public abstract void disparar(Personaje objetivo);
    
    public abstract void disparar();
    
    
    protected void morir() {
        this.x = -1;
        this.y = -1;
    }
    
    public void recibirDanio(int danio) {
        int danioReal = Math.max(0, danio);
        vidaActual -= danioReal;
        if (vidaActual <= 0) {
            vidaActual = 0;
            morir();
        }
    }
        
    public boolean estaMuerto() {
        boolean estaFueraDelMapa = false;
        if (this.x == -1 && this.y == -1) {
            estaFueraDelMapa = true;
        }
        return vidaActual <= 0 || estaFueraDelMapa;
    }
    
}
