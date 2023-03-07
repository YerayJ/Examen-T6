package examen;

import java.util.Scanner;

public class Funciones {
    // Creación de array con las palabras
    static String palabras[] = {"humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza", "brazo"
            , "familia"};
    // Creación de constante que contiene el número de intentos disponibles
    static int NUMINTENTOS = 7;
    // Creación de variable estática de tipo cadena que contiene la palabra a acertar
    static String palabraSecreta;
    // Creación de variable estática de tipo cadena que contiene la pista para el jugador
    static String palabraPista = "";
    // Creación de variable estática de tipo cadena que contiene las letras no acertadas
    static String noAcertadas = "";
    // Creación de escáner para leer datos
    static Scanner key = new Scanner(System.in);

    static void rellenarPista() {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraPista += "-";
        }
    }

    /**
     * Función que genera un número aleatorio para ver que posición del array palabras asignaremos
     * a palabra secreta
     */
    static void generaPalabra() {
        // Genera un número de manera aleatorio según la longitud del array y se le asigna ese valor a la palabra secreta
        palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
    }

    /**
     * Función que imprime el menú y pide la opción al usuario y devuelve esta
     *
     * @return Devuelve la opción elegida por el usuario
     */
    static int menu() {
        // Imprime el menú
        System.out.println("Seleccione una de las siguientes opciones:\n" +
                "1. Introducir letra.\n" +
                "2. Introducir palabra.");
        // Pide una opción por teclado y la almacena
        int opc = key.nextInt();
        // Devuelve la opción
        return opc;
    }

    /**
     * Función que comprueba una letra pasada y busca todas las ocurrencias en la palabra a adivinar, en el caso de que
     * la encuentre la introduce en la pista. Si no hay ocurrencias se añade la letra a noAcertadas
     * @param letra Contiene la letra pasada por el usuario
     */
    static void compruebaLetra(String letra) {
        // Array que contiene las letras
        char letras[] = palabraPista.toCharArray();
        // Contiene la posición anterior buscada
        int posAnterior = 0;
        // Contiene la posición actual buscada
        int posActual = palabraSecreta.indexOf(letra, posAnterior);

        // Comprueba que la letra está en palabraSecreta
        if (posActual < 0) {
            noAcertadas += letra;
        } else {
            // Mientras encuentre la letra se ejecuta
            while (posActual >= 0) {
                // Recorre la palabra
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    // Si la posición es igual a la posición encontrada de la letra se sustituye en el array
                    if (i == posActual) {
                        letras[i] = palabraSecreta.charAt(i);
                    }
                }
                    // Sobreescribe la posActual en la posAnterior
                    posAnterior = posActual;
                    // Vuelve a buscar la letra desde la posición anterior
                    posActual = palabraSecreta.indexOf(letra, posAnterior + 1);
                 // Fin de bucle
            }
        }
        // Devuelve a una cadena la pista
        palabraPista = String.valueOf(letras);
    }

    /**
     * Función que comprueba simplemente si la palabra dada por el usuario ha sido acertada
     * @param palabra Palabra que pasa el usuario para adivinar
     */
    static void compruebaPalabra(String palabra){
        // Comprueba si las palabras son iguales
        if (palabra.equals(palabraSecreta)) {
            // Si lo son sustituye el valor en la palabraPista
            palabraPista = palabraSecreta;
        }
    }

    /**
     * Función que imprime las letras no acertadas y la palabra con la pista
     */
    static void pintaPista(){
        // Variable auxiliar para rellenarla con espacios
        String letrasNoAcertadas = "";
        // Separa por espacios las letras y las imprime
        for (int i = 0; i < noAcertadas.length(); i++) {
            letrasNoAcertadas += noAcertadas.charAt(i) + " ";
        }
        System.out.println("Estas son las letras no acertadas " + letrasNoAcertadas);
        // Imprime la palabra pista
        System.out.println("La palabra pista es: " + palabraPista);

    }

}
