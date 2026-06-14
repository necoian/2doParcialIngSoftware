package test;

import dominio.Usuario;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class parameterUserTest {

    private String newPassInput;
    private int expectedPass;
    private Usuario usuario;

    public parameterUserTest(String newPassInput, int expectedPass) {
        this.newPassInput = newPassInput;
        this.expectedPass = expectedPass;
    }

    @Before
    public void setUp() {
        
        usuario = new Usuario("usr", 0);
    }

    @Parameterized.Parameters(name = "{index}: cambioPassword({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1234", 1234 },   
                { "123", 1234 },    
                { "12a34", 1234 }   
        });
    }

    @Test
    public void testCambioPasswordParam() {
        try {
            usuario.cambioPassword(newPassInput);
            Assert.assertEquals("Se esperaba que la contraseña fuera " + expectedPass,
                                expectedPass, usuario.getPass());
        } catch (NumberFormatException e) {
            
            Assert.fail("Formato inválido para newPass: " + newPassInput);
        }
    }
}
