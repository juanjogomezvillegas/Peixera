package Peixera;
/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 * **/

/**
 * We import the following classes:
 * @see acm.program
 * @see acm.graphics
 * @see javax.swing
 * @see java.awt.Color
 * @see java.util.ArrayList
 * **/
import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Create class "Vacuna", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Vacuna extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private static final String RUTA = "src/Peixera/Imatges/";
    /**Create Variables private**/
    private GImage IMAGE_VACUNA;

    /**
     * Create method constructor the class "Emoji"
     * **/
    public Vacuna() {
        IMAGE_VACUNA = new GImage(RUTA+"vacuna.png");
    }
}