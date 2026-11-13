package modelo;

public class Proveedor {
    private int idProveedor;
    private String nit;
    private String razonSocial;
    private String telefono;
    private String correo;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(String nit, String razonSocial, String telefono, String correo, boolean estado) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public Proveedor(int idProveedor, String nit, String razonSocial, String telefono, String correo, boolean estado) {
        this.idProveedor = idProveedor;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}