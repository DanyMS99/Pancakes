import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int id = 1;
		String cadenaOrdenada;
		Queue<Estado> cola = new LinkedList();
		ArrayList<Estado> estadoslist = new ArrayList<Estado>();

		Scanner recibir = new Scanner(System.in);
		String palabra;
		System.out.println("Dame una palabra");
		String newpalabra = "";
		
	
		palabra = recibir.nextLine();
		
		System.out.println( "----------------------------------" );

		Estado raiz = new Estado(1, palabra, 0);
		cola.offer(raiz);
		estadoslist.add(raiz);
		// System.out.println(raiz.getId() + " " + raiz.getText() + " " +
		// raiz.getIdpadre());

		int aux = 2;
		int vuelta = 0;
		String palabra3 = palabra;

		while (!palabra3.equals(ordenada(palabra))) {
			id++;
			palabra = cola.peek().getText();

			// para machin revolver todo
			String palabra1 = "";
			String palabra2 = "";

			int k = palabra.length() - aux;

			for (int i = (palabra.length() - 1); i >= k; i--) {
				palabra1 = palabra1 + palabra.charAt(i);
			}
			for (int i = 0; i < palabra.length() - palabra1.length(); i++) {
				palabra2 = palabra2 + palabra.charAt(i);
			}
			
			
			palabra3 = palabra2 + palabra1;
			
			System.out.println(palabra3);
			
			Estado estado = new Estado(id, palabra3, cola.peek().getId());
			cola.offer(estado);
			estadoslist.add(estado);
			// ---------------------------------------------

			if (vuelta == palabra.length() - 2) {
				cola.remove();
				vuelta = 0;
			} else {
				vuelta++;
			}
			// System.out.println(palabra3);

			if (aux == (palabra.length())) {
				aux = 2;
			} else {
				aux++;
			}
		}

		System.out.println("--------------------------------------------------------");

		while (estadoslist.get(id - 1).getIdpadre() > 0) {
			System.out.println(estadoslist.get(id - 1).getText());
			id = estadoslist.get(id - 1).getIdpadre();
		}
		System.out.println(raiz.getText());

		System.out.println();

	}

	public static String ordenada(String palabra) {
		String newpalabra = "";
		char a[] = new char[palabra.length()];
		for (int i = 0; i < palabra.length(); i++) {
			a[i] = palabra.charAt(i);
		}
		Arrays.sort(a);
		for (int i = 0; i < palabra.length(); i++) {
			// System.out.println(a[i]);
			newpalabra += a[i];
		}
		return newpalabra;
	}

	public static String voltearCadena(String cadena) {
		String cadenaVolteada = "";
		for (int i = cadena.length() - 1; i >= 0; i--) {
			cadenaVolteada += cadena.charAt(i);
		}
		return cadenaVolteada;
	}

}
