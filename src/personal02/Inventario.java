package personal02;

/**
 * @author YosyGIT
 */
public class Inventario{
    private Producto[] productos;
    private int posicion = 0;

    /**
     * En la creación del inventario he dejado la posibilidad de especificar el tamaño para el inventario
     * o de forma predeterminada se cree el inventario con un tamaño de 50 productos.
     * @param tamano
     */
    public Inventario(int tamano) {
        this.productos = new Producto[tamano];
    }

    public Inventario(){
        this.productos = new Producto[50];
    }

    /**
     * He creado el metodo que devuelve el array de productos
     * ya que puede ser útil el tamaño o directamente para mostrarlos
     * utilizando un for-each
     * @return Devuelve el array
     */
    public Producto[] getProductos() {
        return productos;
    }

    /**
     * Un metodo para introducir los productos que creamos
     * en el inventario
     * @param producto Hay que introducir el producto en el parametro,
     *                 por lo que el producto debe estar creado.
     * @return Devuelve un verdadero o falso para asegurarse de su creación
     */
    public boolean agragarProducto(Producto producto) {
        boolean encontrado = false;

        if (!this.comprobarTamnio()){
            for(Producto p : productos){
                if (p ==  producto){
                    encontrado = false;
                }else {
                    encontrado = true;
                }
            }
            if(encontrado){
                this.productos[posicion] = producto;
                posicion++;
            }
        }

        return encontrado;
    }

    /**
     * Metodo para crear un informe de productos que tienen el stock
     * por debajo del limite que se especifica
     * @param limiteRepsicion Limite de reposición para detectar productos de la lista
     * @return Devuelve un array de productos con los productos que cumplen con el limite o menos
     */
    public Producto[] generarInforme(int limiteRepsicion){
        Producto[] reponer = new Producto[productos.length];

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCantidad() <= limiteRepsicion) {
                reponer[i] = this.productos[i];
            }
        }
        return reponer;
    }

    /**
     * Metodo para buscar productos de manera que si encuentra coincidencias
     * con el nombre que se da de busqueda mostrara todos los productos relacionados
     * sin necesidad de introducir el nombre completo
     * @param nombre Nombre de busqueda
     * @return Devuelve un array con las coincidencias que encuentre
     */
    public Producto[] buscarProductos(String nombre){
        Producto[] busqueda;
        int tamanio = 0;

        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != null){
                if (this.productos[i].getNonbre().toLowerCase().contains(nombre.toLowerCase().trim())){
                    tamanio++;
                }
            }
        }
        if (tamanio > 0) {
            busqueda = new Producto[tamanio];
        }else {
            busqueda = new Producto[1];
            busqueda[0].setNonbre(this.warning() + "No existe el producto:" + nombre);
        }

        tamanio = 0;
        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != null){
                if (this.productos[i].getNonbre().toLowerCase().contains(nombre.toLowerCase().trim())){
                    busqueda[tamanio] = this.productos[i];
                    tamanio++;
                }
            }
        }
       return busqueda;
    }

    /**
     * Metodo para comprobar el tamaño del array de productos,
     * principalmente creado para metodos de esta clase que pueda ser util
     * para futuros metodos.
     * @return Devuelve true en caso de no llegar al limite del array
     */
    private boolean comprobarTamnio(){
        boolean mayor = false;

        if (posicion >= productos.length){
            mayor = true;
        }
        return mayor;
    }

    /**
     * Metodo para comprobaciones, salta warning en caso de encontrar errores
     * @return Devuelve un String con el mensaje
     */
    public String warning(){
        return "::ERROR::";
    }
}