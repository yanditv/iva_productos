package ec.edu.ups.visitor.iva_productos.models;

public class Educacion implements Producto {
    private String nombre;
    private double precio;
    private double precioConIVA;
    private String descripcionIVA;

    public Educacion(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioConIVA = precio;
        this.descripcionIVA = "Exento de IVA";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitarEducacion(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double getPrecioConIVA() {
        return precioConIVA;
    }

    @Override
    public void setPrecioConIVA(double precioConIVA) {
        this.precioConIVA = precioConIVA;
    }

    public String getDescripcionIVA() {
        return descripcionIVA;
    }

    public void setDescripcionIVA(String descripcionIVA) {
        this.descripcionIVA = descripcionIVA;
    }
}
