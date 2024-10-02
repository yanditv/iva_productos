package ec.edu.ups.visitor.iva_productos.controllers;

// ProductoController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ec.edu.ups.visitor.iva_productos.services.ProductoService;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    // Maneja la raíz para mostrar los productos
    @GetMapping("/")
    public String getProductos(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());
        return "index"; // Nombre de la vista (index.html)
    }

    // Método para agregar un producto, también maneja la raíz
    @PostMapping("/agregarProducto")
    public String agregarProducto(@RequestParam String nombre, @RequestParam double precio, @RequestParam String tipo) {
        productoService.agregarProducto(nombre, precio, tipo);
        return "redirect:/"; // Redirige a la raíz después de agregar el producto
    }
}
