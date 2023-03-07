package examen;

public class Ahorcado {
    // Método main
    public static void main(String[] args) {
        // Guarda el número de intentos del usuario
        int intentos = Funciones.NUMINTENTOS;
        // Guarda la opción del usuario
        int opc;
        // Guarda la letra introducida(Variable creada para hacer comprobaciones
        String letra = "";

        // Genera la palabra a adivinar
        Funciones.generaPalabra();
        // Rellena la palabra pista con la longitud de la palabra a adivinar
        Funciones.rellenarPista();
        // Imprime la pista
        System.out.println("La pista es: " + Funciones.palabraPista);

        // Mientras el jugador no haya acertado la palabra y tenga intentos se ejecuta
        while (!Funciones.palabraPista.equals(Funciones.palabraSecreta) && intentos > 0) {
            // Imprime el menu
            do {
                // Pide una opción al menú y al guarda
                opc = Funciones.menu();
                switch (opc) {
                    case 1 -> {
                        System.out.println("Deme una letra");
                        // Pide al usuario una letra y la comprueba en la función, directamente la convierte a minúsculas
                        letra = Funciones.key.next();
                        Funciones.compruebaLetra(letra.toLowerCase());
                    }
                    case 2 -> {
                        System.out.println("Deme una palabra");
                        // Pide al usuario una letra y la comprueba en la función, directamente la convierte a minúsculas
                        Funciones.compruebaPalabra(Funciones.key.next().toLowerCase());
                    }
                }
            } while (opc != 1 && opc != 2);

            // Se resta el número de intentos
            intentos--;

            // Se imprime la pista
            Funciones.pintaPista();
            System.out.println("El número de intentos restantes es: " + intentos);

        } // Fin de bucle

        if (intentos <= 0){
            System.out.println("GAME OVER");
        } else {
            System.out.println("¡ENHORABUENA! HAS ACERTADO");
        }
    }
}
