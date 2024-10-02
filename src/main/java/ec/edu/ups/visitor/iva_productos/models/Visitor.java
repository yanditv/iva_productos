package ec.edu.ups.visitor.iva_productos.models;

// Visitor.java
public interface Visitor {
    void visitarAlimento(Alimento alimento);

    void visitarElectrodomestico(Electrodomestico electrodomestico);

    void visitarMedicamento(Medicamento medicamento);

    void visitarProductoDeLujo(ProductoDeLujo productoDeLujo);

    void visitarEducacion(Educacion educacion);
}
