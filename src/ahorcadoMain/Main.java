package ahorcadoMain;

import java.util.Arrays;
import java.util.Scanner;

//Comentario de prueba para la modificación
//Comentarios de pruebas 2
//Prueba 3

public class Main {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Introduce una palabra:");
		String palabraOriginal = sc1.nextLine();
		char palabra[] = palabraOriginal.toCharArray();
		String palabraIntentos = "";
		char letraIntento = ' ';
		int fallos = 0;
		char correctas[] = new char[0];
		char incorrectas[] = new char[0];
		System.out.println("La palabra que buscas tiene ("+palabra.length+") letras.");
		do {
			System.out.println("Escribe una letra para saber si está en la palabra que buscas:");
			letraIntento = sc1.next().charAt(0);
			boolean esCorrecta = false;
			boolean esNueva = false;
			System.out.println();
			for (int i=0;i<palabra.length;i++) {
				if (palabra[i]==letraIntento) {
					esCorrecta=true;
				}
			}
			if (esCorrecta==true) {
				int largo = correctas.length;
				if (largo == 0) {
					esNueva = true;
				} else {
					boolean encontrada = false;
					for (int i=0; i<largo;i++) {
						if (correctas[i] == letraIntento) {
							encontrada = true;
						}
					}
					if (encontrada == false) {
						esNueva = true;
					}
				}
			}
			
			if (esCorrecta==true && esNueva==true) {
				System.out.println("¡La letra ("+letraIntento+") esta en la palabra!");
				correctas = Arrays.copyOf(correctas, correctas.length+1);
				correctas[correctas.length-1] = letraIntento;
			} else if (esCorrecta==true && esNueva==false) {
				System.out.println("La letra ("+letraIntento+") esta en la palabra pero ya la has acertado antes");
			} else if (esCorrecta==false && esNueva==false) {
				int largo = incorrectas.length;
				if (largo == 0) {
					esNueva = true;
				} else {
					boolean encontrada = false;
					for (int i=0; i<largo;i++) {
						if (incorrectas[i] == letraIntento) {
							encontrada = true;
						}
					}
					if (encontrada == true) {
						
					} else {
						esNueva = true;
					}
				}
				if (esNueva==true) {
					System.out.println("La letra ("+letraIntento+") es incorrecta");
					fallos++;
					incorrectas = Arrays.copyOf(incorrectas, incorrectas.length+1);
					incorrectas[incorrectas.length-1] = letraIntento;
				} else {
					System.out.println("La letra ("+letraIntento+") es incorrecta, pero ya la has probado antes.");
				}
				
			}
			dibujarAhorcado(fallos);
			palabraIntentos = construirPalabra(palabraOriginal, correctas);
			System.out.println(palabraIntentos);
			System.out.println("Letras acertadas: "+Arrays.toString(correctas));
			System.out.println("Letras falladas: "+Arrays.toString(incorrectas));

		} while (palabraIntentos.equals(palabraOriginal)==false && fallos < 7);
		System.out.println();
		if (fallos==7) {
			System.out.println("No has logrado adivinar la palabra. Por tu culpa una persona \n"
					+ "inocente ha sido colgada. Una vergüenza. La palabra era: ("+palabraOriginal+")");
		} else {
			System.out.println("¡Has logrado adivinar la palabra!");
		}
		
	}
	
	public static String construirPalabra(String palabraOriginal, char[] correctas) {
		String respuesta = "";
		
		char palabraEntrada[] = palabraOriginal.toCharArray();
		char palabraSalida[] = new char[palabraEntrada.length];
		
		for (int i = 0; i < palabraEntrada.length;i++) {
			boolean encontrada = false;
			for (int j = 0; j<correctas.length;j++) {
				if (correctas[j] == palabraEntrada[i]) {
					palabraSalida[i] = correctas[j];
					encontrada = true;
				}
			}
			if (encontrada == false) {
				palabraSalida[i] = '-';
			} 
		}
		respuesta = String.valueOf(palabraSalida);
		return respuesta;		
	} 
	
	public static void dibujarAhorcado(int fallos) {
		switch (fallos) {
			case 0:
				System.out.println(""
						+ "FALLOS: 0\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 1:
				System.out.println(""
						+ "FALLOS: 1\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 2:
				System.out.println(""
						+ "FALLOS: 2\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 3:
				System.out.println(""
						+ "FALLOS: 3\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ " /    |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 4:
				System.out.println(""
						+ "FALLOS: 4\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ " /|   |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 5:
				System.out.println(""
						+ "FALLOS: 5\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ " /|\\  |  \r\n"
						+ "      |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 6:
				System.out.println(""
						+ "FALLOS: 6\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ " /|\\  |  \r\n"
						+ " /    |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			case 7:
				System.out.println(""
						+ "FALLOS: 7\r\n"
						+ "=========  \r\n"
						+ "  +---+  \r\n"
						+ "  |   |  \r\n"
						+ "  O   |  \r\n"
						+ " /|\\  |  \r\n"
						+ " / \\  |  \r\n"
						+ "      |  \r\n"
						+ "=========");
				break;
			default:
				System.out.println("error");
		}
				
	}

}
