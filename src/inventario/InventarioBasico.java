package inventario;
import java.util.*;
public class InventarioBasico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        final byte TAMANO = 10; //Tamaño de la tabla de inventario

        //Creacion del inventario
        String[] nombres = new String[TAMANO];
        long[] cantidad = new long[TAMANO];

        //Selecciones de menus
        byte opcionPrincipal = 0, opcionCreacion = 0, opcionProducto = 0, opcionStock = 0, opcionBusqueda = 0;

        //Datos para introducir productos
        String nombreProducto;
        long cantidadProducto;
        byte productosExistentes = 0;

        //Datos para numeración del stock
        byte numeroStock = 1;

        //Datos para busquedas de productos
        String busqueda;
        boolean encontrado = false;


        while(opcionPrincipal != 5){
            System.out.println("\t-MENÚ PRINCIPAL-");
            System.out.println("1) Ver inventario.");
            System.out.println("2) Menú de creación.");
            System.out.println("3) Menú de edición stock");
            System.out.println("4) Buscar producto");
            System.out.println("5) Salir");
            System.out.print("->");
            opcionPrincipal = sc.nextByte();
            System.out.println();
            while(opcionPrincipal < 0 || opcionPrincipal > 5){
                System.out.print("Opcion no valida, elija de nuevo: ");
                opcionPrincipal = sc.nextByte();
                System.out.println();
            }

            switch(opcionPrincipal){
                case 1:
                    System.out.println("[NOMBRE]" + "\t" + "[CANTIDAD]");
                    for(int i = 0; i < nombres.length; i++){
                        System.out.println("[" + nombres[i] + "]" + "\t\t|" + "[" + cantidad[i] + "]");
                    }
                    System.out.println();
                    break;

                case 2:
                    opcionCreacion = 0;
                    while(opcionCreacion != 2){
                        if (productosExistentes == 10){
                            System.out.println("¡¡No hay espacio para crear más productos!!");
                            break;
                        }
                        System.out.println("\t\t-MENÚ DE CREACIÓN-");
                        System.out.println("\t" + "1) Nuevo producto");
                        System.out.println("\t" + "2) Volver al menú principal");
                        System.out.print("\t" + "->");
                        opcionCreacion = sc.nextByte();
                        while(opcionCreacion < 0 || opcionCreacion > 2){
                            System.out.print("\t" + "Opcion no valida, elija de nuevo: ");
                            opcionCreacion = sc.nextByte();
                        }

                        if (opcionCreacion == 1){
                            System.out.print("\t\t" + "-Introduce un nombre para el producto: ");
                            sc.nextLine();//Limpiamos el espacio para que no lo recoja el String nombreProducto
                            nombreProducto = sc.nextLine();
                            System.out.println();

                            nombres[productosExistentes] = nombreProducto.trim();
                            System.out.print("\t\t" + "-Introduce un cantidad para el producto: ");
                            cantidadProducto = sc.nextLong();
                            cantidad[productosExistentes] = cantidadProducto;

                            productosExistentes++;
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    opcionStock = 0;
                    while(opcionStock != 3){
                        System.out.println("\t\t" + "-MENÚ DE EDICIÓN STOCK-");
                        System.out.println("\t" + "1) Añadir stock");
                        System.out.println("\t" + "2) Retirar stock");
                        System.out.println("\t" + "3) Volver al menú principal");
                        System.out.print("\t" + "->");
                        opcionStock = sc.nextByte();
                        while(opcionStock < 0 || opcionStock > 3){
                            System.out.print("\t" + "Opcion no valida, elija de nuevo: ");
                            opcionStock = sc.nextByte();
                        }

                        if (opcionStock == 1 || opcionStock == 2){
                            System.out.println("\t" + "[NOMBRE]" + "\t" + "[CANTIDAD]");
                            numeroStock = 1;
                            for(int i = 0; i < nombres.length; i++){
                                System.out.println("\t" + numeroStock + "[" + nombres[i] + "]" + "\t\t|" + "[" + cantidad[i] + "]");
                                numeroStock++;
                            }
                            System.out.println();
                        }

                        if (opcionStock == 1){
                            System.out.print("\t" + "¿A que producto desea añadir stock?: ");
                            opcionProducto = sc.nextByte();
                            opcionProducto -= 1;
                            while (opcionProducto < 0 || opcionProducto > productosExistentes){
                                System.out.print("\t" + "Opcion no valida, elija de nuevo: ");
                                opcionProducto = sc.nextByte();
                                opcionProducto -= 1;
                            }

                            System.out.print("\t" + "¿Cuánto deseas añadir al stock del producto " + nombres[opcionProducto] + "?: ");
                            cantidadProducto = sc.nextLong();
                            System.out.println("\t" + "Antes: " + "[" + nombres[opcionProducto] + "]" + "[" + cantidad[opcionProducto] + "]");
                            cantidad[opcionProducto] += cantidadProducto;
                            System.out.println("\t" + "Actualizado: " + "[" + nombres[opcionProducto] + "]" + "[" + cantidad[opcionProducto] + "]");
                            System.out.println();

                        } else if (opcionStock == 2) {
                            System.out.print("\t" + "¿A que producto desea quitar stock?: ");
                            opcionProducto = sc.nextByte();
                            opcionProducto -= 1;
                            while (opcionProducto < 0 || opcionProducto > productosExistentes){
                                System.out.print("\t" + "Opcion no valida, elija de nuevo: ");
                                opcionProducto = sc.nextByte();
                                opcionProducto -= 1;
                            }

                            System.out.print("\t" + "¿Cuánto deseas añadir al stock del producto " + nombres[opcionProducto] + "?: ");
                            cantidadProducto = sc.nextLong();
                            while (cantidadProducto > cantidad[opcionProducto]){
                                System.err.print("\t" + "No se puede quitar más stock de la que hay, introduce de nuevo la cantidad: ");
                                cantidadProducto = sc.nextLong();
                            }

                            System.out.println("\t" + "Antes: " + "[" + nombres[opcionProducto] + "]" + "[" + cantidad[opcionProducto] + "]");
                            cantidad[opcionProducto] -= cantidadProducto;
                            System.out.println("\t" + "Actualizado: " + "[" + nombres[opcionProducto] + "]" + "[" + cantidad[opcionProducto] + "]");
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    opcionBusqueda = 0;
                    System.out.println("\t\t" + "-BUSQUEDA DE PRODUCTOS-");
                    while(opcionBusqueda != 2) {
                        System.out.println("\t" + "1) Buscar producto");
                        System.out.println("\t" + "2) Volver al menú principal");
                        System.out.print("\t" + "->");
                        opcionBusqueda = sc.nextByte();
                        System.out.println();

                        while (opcionBusqueda < 0 || opcionBusqueda > 2) {
                            System.out.print("\t" + "Opcion no valida, elija de nuevo: ");
                            opcionBusqueda = sc.nextByte();
                        }

                        if (opcionBusqueda == 1) {
                            System.out.print("\t" + "Introduce texto para la busqueda: ");
                            sc.nextLine();
                            busqueda = sc.nextLine();
                            System.out.println();
                            encontrado = false;

                            for (int i = 0; i < productosExistentes; i++) {
                                if (nombres[i].toLowerCase().contains(busqueda.toLowerCase().trim())) {
                                    System.out.println("\t" + "[" + nombres[i] + "]" + "\t\t|" + "[" + cantidad[i] + "]");
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("\t" + "No se encontro productos relacionados a la busqueda: " + busqueda);
                            }
                            System.out.println();
                        }
                    }
                    break;
            }
        }
    }
}