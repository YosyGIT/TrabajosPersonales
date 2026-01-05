package personal02;

public class Producto {
    private static int contador = 1;
    private String nombre;
    private String id;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        if (contador < 10){
            this.id = "PROD-000" + contador;
        }else if (contador < 100){
            this.id = "PROD-00" + contador;
        } else if (contador > 100) {
            this.id = "PROD-0" + contador;
        }
        contador++;
        this.nombre = nombre.trim();
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNonbre() {
        return nombre;
    }
    public void setNonbre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "--PRODUCTO [ID] " + this.id + "--" + "\n" +
                "NOMBRE: " + this.nombre + "\n" +
                "CANTIDAD: " + this.cantidad + "\n" +
                "PRECIO: " + this.precio;
    }
}
