package test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class parameterMailTest {

    private String email;
    private boolean expected;

    public parameterMailTest(String email, boolean expected) {
        this.email = email;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: validarMail({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "jorgesys@tototita.com", true },
                { "jorgesys@tototitacom", false },
                { "jorgesystototita. com", false },
                { "@jorgesystototita. com", false },
                { ". jorgesystototita@com", false }
        });
    }

    
    
    public static boolean validarMail(String email) {
        if (email == null) {
            return false;
        }
        
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }


    @Test
    public void testValidarMailParam() {
        Assert.assertEquals(expected, validarMail(email));
    }
}
