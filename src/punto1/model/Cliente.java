package punto1.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cedula;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String zona;
    private List<String> codigosEnvio;

    public Cliente(String cedula, String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String telefono, String zona, List<String> codigosEnvio) {
        this.cedula = cedula;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.zona = zona;
        this.codigosEnvio = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<String> getCodigosEnvio() {
        return codigosEnvio;
    }

    public void setCodigosEnvio(List<String> codigosEnvio) {
        this.codigosEnvio = codigosEnvio;
    }

    public void agregarCodigoEnvio (String codigoEnvio) {
        this.codigosEnvio.add(codigoEnvio);
    }

    public String generarRegistro() {
        StringBuilder sb = new StringBuilder();
        sb.append(cedula).append("@")
                .append(tipoIdentificacion).append("@")
                .append(numeroIdentificacion).append("@")
                .append(nombres).append("@")
                .append(apellidos).append("@")
                .append(telefono).append("@")
                .append(zona).append("@");
        for (int i = 0; i < codigosEnvio.size(); i++) {
            sb.append(codigosEnvio.get(i));
            if (i < codigosEnvio.size() - 1) {
                sb.append("%");
            }
        }
        return sb.toString();
    }
}
