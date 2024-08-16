package excepciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class reingresoDatos {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<String> listaNombres = new ArrayList<>();
	static ArrayList<Integer> listaPrecios = new ArrayList<>();
	boolean hayErrores = false;
	boolean finalizoIngreso = false;

	public static void mostrarDatos() {
		System.out.println("------------------");
		System.out.println("Lista de precios y productos: ");
		for (int i = 0; i < listaNombres.size(); i++) {
			System.out.println("Nombre: " + listaNombres.get(i));
			System.out.println("Precio: " + '$' + +listaPrecios.get(i));
			System.out.println("--------");
		}
	}

	public static void ingresarDatos() {

		boolean hayErrores = false;
		boolean finalizoIngreso = false;
		System.out.println("Ingrese FIN para finalizar.");

		// SIN TRY CATCH:
//	        do {
//	            // Ingreso del nombre del producto
//	            System.out.println("Ingrese el nombre del producto: ");
//	            String nombreProducto = entrada.nextLine();
		//
//	            // Verificar si el usuario desea finalizar
//	            if (nombreProducto.equalsIgnoreCase("fin")) {
//	                finalizoIngreso = true;
//	                break; // Salir del bucle
//	            }
		//
//	            // Agregar el nombre a la lista
//	            listaNombres.add(nombreProducto);
		//
//	            // Ingreso del valor del producto
//	            System.out.println("Ingrese el valor del producto: ");
//	            int valorProducto = entrada.nextInt();
		//
//	            // Agregar el valor a la lista
//	            listaPrecios.add(valorProducto);
		//
//	            // Consumir el salto de línea pendiente después de la entrada de int
//	            entrada.nextLine();
		//
//	        } while (!finalizoIngreso);
//			

		// CON TRY CATCH:
		do {
			try {

				System.out.println("Ingrese el nombre del producto: ");
				String nombreProducto = entrada.nextLine();

				if (nombreProducto.equalsIgnoreCase("fin")) {
					finalizoIngreso = true;
					break; // break sirve para salir del bucle do while
				}

				// agregamos la variable ingresada (nombreProducto) a la lista (listaNombres)
				listaNombres.add(nombreProducto);

				System.out.println("Ingrese el valor del producto: ");
				int valorProducto = entrada.nextInt();
				// agregamos la variable ingresada (valorProducto) a la lista (listaPrecios)
				listaPrecios.add(valorProducto);

				// Consumir el salto de línea pendiente después de la entrada de int
				entrada.nextLine();

			} catch (Exception e) {
				listaNombres.remove(listaNombres.size() - 1); // borrar el ultimo elemento
				hayErrores = true;
				System.out.println("Ocurrio un error: " + e.getMessage());
				System.out.println("Ingrese los datos nuevamente.");
				System.out.println("------------");
				entrada.nextLine();
			}
		} while (hayErrores == true || finalizoIngreso == false);

	}

	public static void main(String[] args) {
		ingresarDatos();
		mostrarDatos();
	}
}