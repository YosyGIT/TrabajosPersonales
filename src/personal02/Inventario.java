package personal02;

public class Inventario{
    private Producto[] productos;
    private int posicion = 0;

    public Inventario(int tamano) {
        this.productos = new Producto[tamano];
    }

    public Inventario(){
        this.productos = new Producto[50];
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

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

    public Producto[] generarInforme(int limiteRepsicion){
        Producto[] reponer = new Producto[productos.length];

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCantidad() <= limiteRepsicion) {
                reponer[i] = this.productos[i];
            }
        }
        return reponer;
    }

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

    public boolean comprobarTamnio(){
        boolean mayor = false;

        if (posicion >= productos.length){
            mayor = true;
        }
        return mayor;
    }

    public String warning(){
        return "::ERROR::";
    }
}