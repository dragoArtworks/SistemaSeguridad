package modelo;

public class Usuario extends Persona{
    
    private int id; 
    private String nickName;
    private String correo;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String nickName, String correo, String contrasena, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.nickName = nickName;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    public Usuario(int id, String nickName, String correo, String contrasena, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.id = id;
        this.nickName = nickName;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nickName=" + nickName + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }

  
    
}
