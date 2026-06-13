package Jueguito;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ian
 */
public class Heroe extends Personaje {

    private Mochila miMochila;
    private Armadura miArmadura; 
    private List<Proyectil> proyectilesInventario = new ArrayList<>();
    private List<EnemigoComun> enemigosEnCombate = new ArrayList<>();
    private List<JefeMaximo> jefesEnCombate = new ArrayList<>();
    private Arma armaEquipada;
    
    public Heroe(int x, int y,
                 int nivelEnergia, int vidas, int capacidadOfensiva,
                 int vidaMaxima, int energiaMaxima) {
        super(x, y, nivelEnergia, vidas, capacidadOfensiva, vidaMaxima, energiaMaxima);
        this.miMochila = new Mochila(3);
    }

    public Mochila getMiMochila() {
        return miMochila;
    }

    public Armadura getMiArmadura() {
        return miArmadura;
    }

    public List<Proyectil> getProyectilesInventario() {
        return proyectilesInventario;
    }

    public void setMiArmadura(Armadura miArmadura) {
        this.miArmadura = miArmadura;
    }
    
    public void agregarProyectilInventario(Proyectil p) {
        if (p == null) {
            return;
        }
        for (Proyectil inv : proyectilesInventario) {
            if (inv.getTipo() == p.getTipo()) {
                inv.agregarMunicion(p.getCantidad());
                return;
            }
        }
        proyectilesInventario.add(p);
    }
    
    public void equiparArma(Arma a) {
        this.armaEquipada = a; 
    }
    
    public Arma getArmaEquipada() {
        return armaEquipada; 
        
        
    }
    
    public void desequiparArma() {
        this.armaEquipada = null; 
    }

    public List<EnemigoComun> getEnemigosEnCombate() {
        return enemigosEnCombate;
    }

    public List<JefeMaximo> getJefesEnCombate() {
        return jefesEnCombate;
    }
    
    public void agregarEnemigoEnCombate(EnemigoComun e) {
        if (e != null) {
            enemigosEnCombate.add(e);
        } 
    }
    public void agregarJefeEnCombate(JefeMaximo j) {
        if (j != null) {
            jefesEnCombate.add(j);
        } 
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
        if (armaEquipada != null) {
            armaEquipada.disparar();
            if (armaEquipada.estaDestruida()) {
                List<Proyectil> restos = armaEquipada.extraerProyectiles();
                for (Proyectil p : restos) agregarProyectilInventario(p);
                armaEquipada = null;
            }
        }
    }
    
    //dispara a un objetivo
    @Override
    public void disparar(Personaje objetivo) {
        if (objetivo == null) return;
        int danioTotal = capacidadOfensiva;

        if (armaEquipada != null) {
            int danioArma = armaEquipada.disparar();
            danioTotal += danioArma;

            if (armaEquipada.estaDestruida()) {
                List<Proyectil> restos = armaEquipada.extraerProyectiles();
                for (Proyectil p : restos) agregarProyectilInventario(p);
                armaEquipada = null;
            }
        }

        objetivo.recibirDanio(danioTotal);
    }
    
    public void comer(Comida comida) {
        if (comida == null) return;
        int curacion = comida.usar();
        setVidaActual(getVidaActual() + curacion);
        if (comida.estaVacia()) miMochila.removerItem(comida);
    }
    
    public boolean recogerObjeto(ObjetoMovil objeto) {
        return miMochila.agregarItem(objeto);
    }
    
}
