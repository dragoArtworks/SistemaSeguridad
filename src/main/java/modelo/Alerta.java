/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Alerta {
    private int id;
    private String mensaje;
    private String fecha;
    private String lugarOcurrencia;
    private String peligro;
    private int usuarioId;

    public Alerta() {
    }

    public Alerta(int id) {
        this.id = id;
    }

    public Alerta(String mensaje, String fecha, String lugarOcurrencia, String peligro) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.lugarOcurrencia = lugarOcurrencia;
        this.peligro = peligro;
    }

    public Alerta(String mensaje, String fecha, String lugarOcurrencia, String peligro, int usuarioId) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.lugarOcurrencia = lugarOcurrencia;
        this.peligro = peligro;
        this.usuarioId = usuarioId;
    }

    public Alerta(int id, String mensaje, String fecha, String lugarOcurrencia, String peligro, int usuarioId) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.lugarOcurrencia = lugarOcurrencia;
        this.peligro = peligro;
        this.usuarioId = usuarioId;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugarOcurrencia() {
        return lugarOcurrencia;
    }

    public void setLugarOcurrencia(String lugarOcurrencia) {
        this.lugarOcurrencia = lugarOcurrencia;
    }

    public String getPeligro() {
        return peligro;
    }

    public void setPeligro(String peligro) {
        this.peligro = peligro;
    }
    
    
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Alerta{" + "id=" + id + ", mensaje=" + mensaje + ", fecha=" 
                + fecha + ", lugarOcurrencia=" + lugarOcurrencia + ", usuarioId=" + usuarioId + '}';
    }
    
    
}
