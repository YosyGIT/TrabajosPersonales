package personal02;
import java.util.*;

/**
 * @author YosyGIT
 */
public class AppSmartStock {
    //Pendiente de modificar
    private static Inventario[] almacen = new Inventario[10];
    private static int contadorInventario = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        /**
         * Menu de interación
         */
        while(opcion != 6){
            System.out.println("\n=====MENU SMART STOCK=====");
            System.out.println("1. Crear inventario");
            System.out.println("2. Añadir producto");
            System.out.println("3. Ver Inventario Ordenado");
            System.out.println("4. Buscar");
            System.out.println("5. Informe de Stock");
            System.out.println("6. Salir");
            System.out.print("->");
            opcion = sc.nextInt();
            sc.nextLine();

            while(opcion > 6 || opcion < 1){
                System.out.print("\nElección incorrecta, vuelva a intentarlo: ");
                opcion = sc.nextInt();
            }

            switch(opcion){
                case 1:
                    crearInventario();
                    break;

                case 2:
                    if (contadorInventario == 0){
                        System.out.println("::ERROR:: Debes crear un inventario");
                    }else{
                        Inventario seleccionado = escogerInventario();
                        agregarProducto(seleccionado);
                    }
                    break;

                case 3:
                    if (contadorInventario == 0){
                        System.out.println("::ERROR:: Debes crear un inventario");
                    }else{
                        Inventario seleccionadoLista = escogerInventario();
                        listarInventario(seleccionadoLista);
                    }
                    break;

                case 4:
                    if (contadorInventario == 0){
                        System.out.println("::ERROR:: Debes crear un inventario");
                    }else{
                        Inventario seleccionadoBusqueda = escogerInventario();
                        buscarProducto(seleccionadoBusqueda);
                    }
                    break;

                case 5:
                    if (contadorInventario == 0){
                        System.out.println("::ERROR:: Debes crear un inventario");
                    }else{
                        Inventario seleccionadoStock = escogerInventario();
                        informeStock(seleccionadoStock);
                    }
                    break;

                case 6:
                    System.out.println("-::EXIT::-");
                    break;
            }
        }
    }

    /**
     * Metodo para crear el Inventario, tiene un numero que se asigna en
     * funcion de la posicion del array de almacen
     */
    public static void crearInventario(){
        Scanner sc = new Scanner(System.in);
        int tamanioInventario;

        if (contadorInventario >=almacen.length){
            System.out.println("::ERROR:: No se pueden crear más inventarios");

        }else{
            System.out.print("\n" + "Introduce el tamaño del inventario: ");
            tamanioInventario = sc.nextInt();

            almacen[contadorInventario] = new Inventario(tamanioInventario);
            contadorInventario++;

            System.out.println("-::Creado correctamente::-  Se le asigno el número " + (contadorInventario - 1) + " al inventario.");
        }
    }

    /**
     * Metodo para poder elejir entre los inventarios del array de almacenes
     * @return Devuelve el inventario que se elija
     */
    public static Inventario escogerInventario(){
        Scanner sc = new Scanner(System.in);
        int inventario;

        System.out.println("----INVENTARIOS EXISTENTES----");
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i] != null){
                System.out.println("-: NUMERO DE INVENTARIO [" + i + "] :-");
            }
        }

        System.out.print("\n- Elije el inventario al que quieres añadir el producto: ");
        inventario = sc.nextInt();

        while (inventario < 0 || inventario > almacen.length){
            System.out.print("\n::ERROR:: El inventario no existe, vuelva a introducirlo: ");
            inventario = sc.nextInt();
        }

        return almacen[inventario];
    }

    /**
     * Metodo para agregar productos al inventario que se escoja
     * @param inventario Inventario seleccionado
     */
    public static void agregarProducto(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        String precioLimpieza;

        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el precio: ");
        precioLimpieza = sc.nextLine();
        double precio = Double.parseDouble(precioLimpieza.replaceAll(",", "."));
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();

        Producto nuevo = new Producto(nombre, precio, cantidad);
        System.out.println(inventario.agragarProducto(nuevo)?"-::Producto agregado correctamente::- [ID]: " + nuevo.getId():
                                                            "::ERROR:: No se pudo agregar (Inventario lleno o duplicado)");
    }

    /**
     * Metodo para mostrar los productos del inventario
     * @param inventario Inventario seleccionado
     */
    public static void listarInventario(Inventario inventario){
        for (Producto p : inventario.getProductos()){
            if (p != null) {
                System.out.println("-------------------------------------------");
                System.out.println(p.mostrar());
                System.out.println("-------------------------------------------");
            }
        }
    }

    /**
     * Metodo para buscar productos relacionados con la busqueda
     * @param inventario Inventario seleccionado
     */
    public static void buscarProducto(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        String busqueda;

        System.out.println("\n¿Qué deseas buscar?");
        System.out.print("->");
        busqueda = sc.next();

        for (Producto p : inventario.buscarProductos(busqueda)){
            System.out.println("-------------------------------------------");
            System.out.println(p.mostrar());
            System.out.println("-------------------------------------------");
        }
    }

    /**
     * Metodo para crear el informe de productos con poco stock
     * que necesitan ser repuestos
     * @param inventario Inventrario seleccionado
     */
    public static void informeStock(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMostrar productos con stock menor o igual a: ");
        int limite = sc.nextInt();

        for (Producto p : inventario.generarInforme(limite)) {
            System.out.println(p.mostrar());
            System.out.println("::NECESITA REPOSICIÓN::");
        }
    }
}
