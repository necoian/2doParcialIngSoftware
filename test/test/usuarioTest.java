package test;

import dominio.Usuario;
import org.junit.*;
import org.junit.runners.MethodSorters; 
import java.time.LocalDate;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class usuarioTest {

    private static Usuario usr;
    private static int testCounter = 0;

    @BeforeClass
    public static void antesDeTodo() {
        usr = new Usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }

    @AfterClass
    public static void despuesDeTodo() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas " + ayer);
    }

    @Before
    public void antesCadaTest() {
        testCounter++;
        System.out.println("----- Test #" + testCounter + " -----");
    }

    @After
    public void despuesCadaTest() {
        System.out.println("----- Fin Test #" + testCounter + " -----");
    }

    
    @Test(timeout = 30)
    public void a_testDelay() throws InterruptedException {
        usr.delay(50);
    }

    
    @Test
    public void b_testUsuariosDiferentes() {
        Usuario u1 = new Usuario("A", 1111);
        Usuario u2 = new Usuario("B", 2222);
        
        u1.usuariosDiferentes(u2);
        Assert.assertNotSame("mismo usuario", u1, u2);
    }

    
    @Test
    public void c_testValidarUsr() {
        int contra = 2222;
        Assert.assertTrue("La validacion deberia ser true , pero fallara intencionalmente",
                usr.validarPassword(contra));
    }

   
    @Test
    public void d_testValidarEmail() {
        String email = "abcde@abcde.co"; 
        boolean validacion = email.contains("@") && email.contains(".") && email.length() < 20;
        Assert.assertTrue("Email valido", validacion);
    }

    
    @Test
    public void e_TestCambioPass() {
        String newPass = "1234";
        usr.cambioPassword(newPass);
        
        System.out.println("Se ha cambiado el password correctamente al nuevo valor: " + usr.getPass());
        
        Assert.assertEquals("La contrasena debe haberse actualizado a 1234", 1234, usr.getPass());
    }
}