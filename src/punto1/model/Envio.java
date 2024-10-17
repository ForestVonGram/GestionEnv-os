package punto1.model;

import java.io.Serializable;
import java.util.List;

public class Envio implements Serializable {
    private String codigo;
    private String fechaEnvio;
    private String zona;
    private double total;
    private String cliente;
    private List<Paquete> paquetes;

    public Envio() {}

    public Envio(String codigo, String fechaEnvio, String zona, double total, String cliente, List<Paquete> paquetes) {
        this.codigo = codigo;
        this.fechaEnvio = fechaEnvio;
        this.zona = zona;
        this.total = total;
        this.cliente = cliente;
        this.paquetes = paquetes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
