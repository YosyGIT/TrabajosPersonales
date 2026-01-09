package personal02;

/**
 *
 * @author YosyGIT
 */
public class Producto {
    private static int contador = 1;
    private String nombre;
    private String id;
    private double precio;
    private int cantidad;

    /**
     * Constructor para crear productos con IDs dinamicos
      * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param cantidad Unidades con las que inicia el stock del producto
     */
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

    /**
     * Metodos getters and setters para manipular los datos y mostrarlos de manera más segura
     */
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

    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo para mostrar los datos del producto
     * @return Devuelve el String que contiene los datos
     */
    public String mostrar() {
        return "--PRODUCTO [ID] " + this.id + "--" + "\n" +
                "NOMBRE: " + this.nombre + "\n" +
                "CANTIDAD: " + this.cantidad + "\n" +
                "PRECIO: " + this.precio + "€";
    }
}
