package ec.edu.ups.visitor.iva_productos.models;

public class IVAVisitor implements Visitor {

    @Override
    public void visitarAlimento(Alimento alimento) {
        alimento.setPrecioConIVA(alimento.getPrecio()); // Exento de IVA
        alimento.setDescripcionIVA("Exento de IVA");
    }

    @Override
    public void visitarElectrodomestico(Electrodomestico electrodomestico) {
        double iva = electrodomestico.getPrecio() * 0.12;
        electrodomestico.setPrecioConIVA(electrodomestico.getPrecio() + iva);
        electrodomestico.setDescripcionIVA("IVA (12%)");
    }

    @Override
    public void visitarMedicamento(Medicamento medicamento) {
        medicamento.setPrecioConIVA(medicamento.getPrecio()); // Exento de IVA
        medicamento.setDescripcionIVA("Exento de IVA");
    }

    @Override
    public void visitarProductoDeLujo(ProductoDeLujo productoDeLujo) {
        double iva = productoDeLujo.getPrecio() * 0.15;
        productoDeLujo.setPrecioConIVA(productoDeLujo.getPrecio() + iva);
        productoDeLujo.setDescripcionIVA("IVA (15%)");
    }

    @Override
    public void visitarEducacion(Educacion educacion) {
        educacion.setPrecioConIVA(educacion.getPrecio()); // Exento de IVA
        educacion.setDescripcionIVA("Exento de IVA");
    }
}