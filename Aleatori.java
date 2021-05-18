package Peixera;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * **/

/**
 * We import the following classes:
 * @see java.util.concurrent.ThreadLocalRandom
 * **/
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create interface "Aleatori"
 * @version 1
 * **/
public interface Aleatori {
    /**
     * Create method getter "getNumeroAleatori", of type static
     * @param min minimum value
     * @param max maximum value
     * @return random number between param "min" and param "max"
     * **/
    static int getNumeroAleatori(int min, int max) {return ThreadLocalRandom.current().nextInt(min, max);}
}