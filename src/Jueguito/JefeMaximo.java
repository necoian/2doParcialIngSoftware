package Jueguito;

/**
 *
 * @author ian
 */
public class JefeMaximo extends Personaje {
    private int cantidadEvoluciones;
    private int potenciaSuperpoder;
    private boolean vuela;

    public JefeMaximo(int x, int y,int nivelEnergia, int vidas, int capacidadOfensiva,int vidaMaxima, int energiaMaxima, int cantidadEvoluciones, int potenciaSuperpoder, boolean vuela) {
        super(x, y, nivelEnergia, vidas, capacidadOfensiva, vidaMaxima, energiaMaxima);
        this.cantidadEvoluciones = Math.max(0, cantidadEvoluciones);
        this.potenciaSuperpoder = Math.max(0, potenciaSuperpoder);
        this.vuela = vuela;
    }

    public int getCantidadEvoluciones() {
        return cantidadEvoluciones; 
    }
    
    public int getPotenciaSuperpoder() {
        return potenciaSuperpoder; 
    }
    
    public boolean isVuela() { 
        return vuela; 
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela; 
    }

    
    @Override
    public void caminar() { 
        super.caminar(); 
    }

    @Override
    public void correr() { 
        super.correr(); 
    }

    @Override
    public void saltar() { 
        super.saltar(); 
    }

    @Override
    public void disparar() {
        
    }

    @Override
    public void disparar(Personaje objetivo) {
        if (objetivo == null) return;
        objetivo.recibirDanio(capacidadOfensiva);
    }


    public void evolucionar() {
        cantidadEvoluciones++;
        capacidadOfensiva += 10; 
        vidaMaxima += 20;
        setVidaActual(getVidaActual() + 20);
    }


    public void lanzarSuperpoder(Personaje objetivo) {
        if (objetivo == null) {
            return;
        }
        objetivo.recibirDanio(potenciaSuperpoder);
    }
    
}

