package ec.edu.ups.visitor.iva_productos.models;

public interface Producto {
    void accept(Visitor visitor);

    String getNombre();

    double getPrecio();

    double getPrecioConIVA(); // Nuevo método

    void setPrecioConIVA(double precioConIVA); // Nuevo método
}
