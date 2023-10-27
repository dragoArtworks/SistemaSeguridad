package modelo;

public class Usuario extends Persona{
    
    private int id; 
    private String nickName;
    private String correo;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }
    
    public Usuario(int id, String nickName, String correo, String contraseña, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.id = id;
        this.nickName = nickName;
        this.correo = correo;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nickName=" + nickName + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
