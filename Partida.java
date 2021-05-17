package Peixera;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * @author Kirill Lupenkov
 * @author Edgar Peréz
 * @author Jordi Risco
 * **/

/**
 * We import the following classes:
 * @see acm.program
 * @see acm.graphics
 * @see java.awt.Color
 * **/
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

/**
 * Create class "Aleatori", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Partida extends GraphicsProgram {
    public static void main(String[] args) {new Partida().start(args);}

    public void init() {
        /*
         * setSize set the size window in 700 the width and 800 the height
         * setBackground set the color window in DARK_GRAY
         * */
        setSize(700, 800);
        setBackground(Color.DARK_GRAY);
    }

    public void run() {
        //
    }
}