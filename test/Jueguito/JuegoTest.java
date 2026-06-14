package Jueguito;

import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    // ESCENARIO 1

    /**
     * Caso A: Un héroe con ataque golpea a un enemigo
     * La vida del enemigo disminuye, pero no llega a cero
     */
    @Test
    public void testGolpeRestaVidaSinMorir() {
        Heroe heroe = new Heroe(0, 0, 100, 3, 20, 100, 100);
        EnemigoComun enemigo = new EnemigoComun(1, 1, 100, 1, 10, 100, 100);

        heroe.disparar(enemigo);

        assertEquals("La vida del enemigo deberia reducirse a 80", 80, enemigo.getVidaActual());
    }

    /**
     * Caso B: Un héroe con ataque alto golpea a un enemigo
     * Su vida llega exactamente a 0 y el enemigo muere
     */
    @Test
    public void testGolpeMataEnemigo() {
        Heroe heroe = new Heroe(0, 0, 100, 3, 30, 100, 100);
        EnemigoComun enemigo = new EnemigoComun(1, 1, 100, 1, 10, 30, 100);

        heroe.disparar(enemigo);

        assertEquals("La vida del enemigo deberia reducirse a 0", 0, enemigo.getVidaActual());
        assertTrue("El enemigo deberia estar muerto", enemigo.estaMuerto());
    }

    /**
     * Caso C: El golpe es tan fuerte que la vida del enemigo sería negativa
     * El sistema debe garantizar que la vida mínima sea 0
     */
    @Test
    public void testGolpeExcesivoNoBajaDeCero() {

        Heroe heroe = new Heroe(0, 0, 100, 3, 50, 100, 100);

        EnemigoComun enemigo = new EnemigoComun(1, 1, 100, 1, 10, 10, 100);

        heroe.disparar(enemigo);

        assertEquals("La vida no debe ser negativa, el tope inferior es 0", 0, enemigo.getVidaActual());
    }


    // ESCENARIO 2
    /**
     * Caso D: TestCurarVida
     * Se espera que la vida del héroe aumente al comer
     */
    @Test
    public void testCurarVida() {
        Heroe heroe = new Heroe(0, 0, 100, 3, 10, 100, 100);
        heroe.setVidaActual(30); 

        
        Comida manzana = new Comida(0, 0, 15, 1);
        
        heroe.comer(manzana);

        assertEquals("La vida del heroe deberia ser 45 tras curarse", 45, heroe.getVidaActual());
    }

    /**
     * Caso E: testNoPuedeCurarse
     * Debe lanzar NullPointerException si la comida es null
     */
    @Test
    public void testNoPuedeCurarse() {
        Heroe heroe = new Heroe(0, 0, 100, 3, 10, 100, 100);

        assertThrows(NullPointerException.class, () -> {
            heroe.comer(null);
        });
    }


    // ESCENARIO 3

    /**
     * Caso A: La mochila está vacía. Se guardan 3 objetos con éxito
     */
    @Test
    public void testGuardarObjetosHastaLimite() {
        Mochila mochila = new Mochila(3);
        
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);

        assertTrue("Deberia poder guardar el item 1", mochila.agregarItem(item1));
        assertTrue("Deberia poder guardar el item 2", mochila.agregarItem(item2));
        assertTrue("Deberia poder guardar el item 3", mochila.agregarItem(item3));
        
        assertEquals("La mochila deberia tener 3 objetos", 3, mochila.obtenerItems().size());
    }

    /**
     * Caso B: Mochila con 3 objetos (está llena) . Se intenta guardar un cuarto objeto
     */
    @Test
    public void testRechazarGuardarAlSuperarLimite() {
        Mochila mochila = new Mochila(3);
        
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);
        Comida item4 = new Comida(0, 0, 10, 1); 

        mochila.agregarItem(item1);
        mochila.agregarItem(item2);
        mochila.agregarItem(item3);

        boolean guardadoCuartoObjeto = mochila.agregarItem(item4);

        assertFalse("El sistema deberia rechazar el 4to objeto", guardadoCuartoObjeto);
        assertEquals("La cantidad actual de objetos sigue siendo 3", 3, mochila.obtenerItems().size());
    }

    /**
     * Caso C: Se amplía la capacidad de la mochila y se permite guardar más objetos
     */
    @Test
    public void testAmpliarCapacidad() {
        Mochila mochila = new Mochila(3);
        
        Comida item1 = new Comida(0, 0, 10, 1);
        Comida item2 = new Comida(0, 0, 10, 1);
        Comida item3 = new Comida(0, 0, 10, 1);
        Comida item4 = new Comida(0, 0, 10, 1); 

        
        mochila.agregarItem(item1);
        mochila.agregarItem(item2);
        mochila.agregarItem(item3);

        
        mochila.ampliarCapacidad(1);

        assertTrue("Ahora deberia permitir guardar el item 4 al ampliar capacidad", mochila.agregarItem(item4));
        assertEquals("La cantidad actual de objetos deberia ser 4", 4, mochila.obtenerItems().size());
    }
}