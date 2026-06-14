package dominio;

public class Usuario {
    private String user;
    private int pass;

    public Usuario() {
        this.user = "";
        this.pass = 0;
    }

    public Usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public int getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    
    public boolean validarPassword(int contra) {
        return this.pass == contra;
    }

    
    public void cambioPassword(String newPass) {
        try {
            int nuevo = Integer.parseInt(newPass);
            this.pass = nuevo;
            System.out.println("Nuevo Pass> " + this.pass);
        } catch (NumberFormatException e) {
            
            System.out.println("Formato de nueva contraseña inválido: " + newPass);
            throw e;
        }
    }

    
    public void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
            Thread.currentThread().interrupt();
        }
    }

    
    public boolean usuariosDiferentes(Usuario u2) {
        if (u2 == null) return true;
        return !(this.user.equals(u2.user) && this.pass == u2.pass);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) return false;
        Usuario other = (Usuario) obj;
        return this.user.equals(other.user) && this.pass == other.pass;
    }

    @Override
    public int hashCode() {
        return user.hashCode() * 31 + pass;
    }
}
