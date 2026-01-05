package personal02;
import java.util.*;
public class AppSmartStock {
    private static Inventario[] almacen = new Inventario[10];
    private static int contadorInventario = 0;
    private static Producto[] productos = new Producto[500];
    private static int contadorProducto = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int opcion = 0;

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

            while(opcion > 6 || opcion < 1){
                System.out.print("\n" + "Elección incorrecta, vuelva a intentarlo: ");
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
                    System.out.println("::EXIT");
                    System.exit(0);
                    break;
            }
        }
    }

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

    public static Inventario escogerInventario(){
        Scanner sc = new Scanner(System.in);
        int inventario, pos = 0;

        System.out.println("----INVENTARIOS EXISTENTES----");
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i] != null){
                System.out.println("-INTRODUCE:" + i + " :-");
                pos++;
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

    public static void agregarProducto(Inventario inventario){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.next();
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();

        Producto nuevo = new Producto(nombre, precio, cantidad);

        if (inventario.agragarProducto(nuevo)){
            System.out.println("-::Producto agregado correctamente::- [ID]: " + nuevo.getId());
            productos[contadorProducto] = nuevo;
            contadorProducto++;
        } else {
            System.out.println("::ERROR:: No se pudo agregar (Inventario lleno o duplicado)");
        }
    }

    public static void listarInventario(Inventario inventario){
        Producto[] lista = inventario.getProductos();
        for (int i = 0; i < lista.length; i++){
            if (lista[i] != null) {
                System.out.println("-------------------------------------------");
                System.out.println(lista[i].toString());
                System.out.println("-------------------------------------------");
            }
        }
    }

    public static void buscarProducto(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        String busqueda;

        System.out.println("\n¿Qué deseas buscar?");
        System.out.print("->");
        busqueda = sc.next();

        inventario.buscarProductos(busqueda);
    }

    public static void informeStock(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMostrar productos con stock menor o igual a: ");
        int limite = sc.nextInt();

        for (Producto p : inventario.getProductos()) {
            if (p != null && p.getCantidad() <= limite) {
                System.out.println(p.toString());
            }
        }
    }
}
