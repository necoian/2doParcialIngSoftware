package Jueguito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ian
 */
public class Arma extends ObjetoMovil {
    
    private int potencia;
    private int cadenciaDisparo;
    private double velocidadDisparo;
    private double factorPotenciador;
    private List<Proyectil> proyectiles = new ArrayList<>();
    private int contadorDisparos = 0;
    private static final int DURABILIDAD_DISPAROS = 30;
    
    public Arma(int x, int y, int potencia, int cadenciaDisparo, double velocidadDisparo, double factorPotenciador) {
        super(x, y);
        this.potencia = potencia;
        this.cadenciaDisparo = cadenciaDisparo;
        this.velocidadDisparo = velocidadDisparo;
        this.factorPotenciador = factorPotenciador;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getCadenciaDisparo() {
        return cadenciaDisparo;
    }

    public double getVelocidadDisparo() {
        return velocidadDisparo;
    }

    public double getFactorPotenciador() {
        return factorPotenciador;
    }

    public int getContadorDisparos() {
        return contadorDisparos;
    }

    public List<Proyectil> getProyectiles() {
        return proyectiles;
    }
    
    
    public void agregarProyectil(Proyectil p) {
        if (p != null) {
            proyectiles.add(p);
        }
    }
    
    //Crea nueva lista de proyectiles cuando el arma se destruya
    public List<Proyectil> extraerProyectiles() {
        List<Proyectil> copia = new ArrayList<>(proyectiles);
        proyectiles.clear();
        return copia;
    }
    
    public int disparar() {
        return disparar(1); 
    }
    
    public int disparar(int unidadesPorDisparo) {
        if (unidadesPorDisparo <= 0) unidadesPorDisparo = 1;

        
        contadorDisparos++;
        
        int danioBase = (int) Math.round(potencia * factorPotenciador);
        int danioProyectil = 0;


        Iterator<Proyectil> it = proyectiles.iterator();
        
        while (it.hasNext() && unidadesPorDisparo > 0) {
            Proyectil p = it.next();
            
            int danioObtenido = p.consumirParaDisparo(unidadesPorDisparo);
            danioProyectil += danioObtenido;

            if (p.estaAgotado()) {
                it.remove();
            }

            if (p.getDanio() > 0) {
                int unidadesConsumidas = danioObtenido / p.getDanio();
                unidadesPorDisparo -= unidadesConsumidas;
            } else {
                unidadesPorDisparo = 0;
            }
        }

        int danioTotal = danioBase + danioProyectil;

        // Si el arma se destruye por alcanzar la durabilidad, se extraen proyectiles restantes
        if (contadorDisparos >= DURABILIDAD_DISPAROS) {
            extraerProyectiles();
        }

        return danioTotal;
    }
    
    //Si contador disparos es igual o mayor a la durabilidad del arma, la misma ha sido destruida
    public boolean estaDestruida() {
        return contadorDisparos >= DURABILIDAD_DISPAROS;
    }
    
    
    
}
