package Jueguito;

/**
 *
 * @author ian
 */
public class Edificio extends ObjetoInmovil {
    
    private int vida;
    private int resistenciaDisparos;
    
    public Edificio(int x, int y, int vida, int resistenciaDisparos) {
        super(x, y);
        this.vida = vida;
        this.resistenciaDisparos = resistenciaDisparos;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void recibirDanio(int danio) {
        int danioReal = Math.max(0, danio - resistenciaDisparos);
        vida -= danioReal;
    }
    
    public boolean estaDestruido() {
        return vida <= 0; 
        
    }
    
}
