package ec.edu.ups.visitor.iva_productos.services;

import org.springframework.stereotype.Service;

import ec.edu.ups.visitor.iva_productos.models.Alimento;
import ec.edu.ups.visitor.iva_productos.models.Educacion;
import ec.edu.ups.visitor.iva_productos.models.Electrodomestico;
import ec.edu.ups.visitor.iva_productos.models.IVAVisitor;
import ec.edu.ups.visitor.iva_productos.models.Medicamento;
import ec.edu.ups.visitor.iva_productos.models.Producto;
import ec.edu.ups.visitor.iva_productos.models.ProductoDeLujo;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Precargar productos
        agregarProducto("Pan", 1.00, "Alimento");
        agregarProducto("Leche", 0.80, "Alimento");
        agregarProducto("Refrigerador", 500.00, "Electrodomestico");
        agregarProducto("Lavadora", 700.00, "Electrodomestico");
        agregarProducto("Aspirina", 5.00, "Medicamento");
        agregarProducto("Paracetamol", 3.00, "Medicamento");
        agregarProducto("Reloj de Lujo", 1000.00, "ProductoDeLujo");
        agregarProducto("Bolso de Lujo", 2000.00, "ProductoDeLujo");
        agregarProducto("Curso de Matemáticas", 100.00, "Educacion");
        agregarProducto("Curso de Inglés", 150.00, "Educacion");
    }

    public void agregarProducto(String nombre, double precio, String tipo) {
        Producto producto;
        switch (tipo) {
            case "Alimento":
                producto = new Alimento(nombre, precio);
                break;
            case "Electrodomestico":
                producto = new Electrodomestico(nombre, precio);
                break;
            case "Medicamento":
                producto = new Medicamento(nombre, precio);
                break;
            case "ProductoDeLujo":
                producto = new ProductoDeLujo(nombre, precio);
                break;
            case "Educacion":
                producto = new Educacion(nombre, precio);
                break;
            default:
                throw new IllegalArgumentException("Tipo de producto no válido");
        }
        productos.add(producto);
        IVAVisitor ivaVisitor = new IVAVisitor();
        producto.accept(ivaVisitor);
    }

    public List<Producto> getAllProductos() {
        return productos;
    }

    // public void aplicarIVA(Visitor visitor) {
    // for (Producto producto : productos) {
    // producto.accept(visitor);
    // }
    // }
}