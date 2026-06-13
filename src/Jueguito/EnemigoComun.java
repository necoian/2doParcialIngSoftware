package Jueguito;

/**
 *
 * @author ian
 */
public class EnemigoComun extends Personaje {

    public EnemigoComun(int x, int y, int nivelEnergia, int vidas, int capacidadOfensiva, int vidaMaxima, int energiaMaxima) {
        super(x, y, nivelEnergia, vidas, capacidadOfensiva, vidaMaxima, energiaMaxima);
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
}
