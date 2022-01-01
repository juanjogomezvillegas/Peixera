package Peixera;
/*
 * We import the following classes:
 * @see java.util.concurrent.ThreadLocalRandom
 * */
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create abstract class "Random"
 * @version 1
 * **/
public abstract class Random {
    /**
     * Create method getter "getNumberRandom", of type static
     * @param min minimum value
     * @param max maximum value
     * @return random number between param "min" and param "max"
     * **/
    public static int getNumberRandom(int min, int max) {return ThreadLocalRandom.current().nextInt(min, max);}
}