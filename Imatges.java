package Peixera;
/*
 * We import the following classes:
 * @see acm.graphics.GImage
 * @see java.awt.Image
 * */
import acm.graphics.GImage;
import java.awt.Image;

/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 *
 * Create abstract class "Imatges"
 * @version 1
 * **/
public abstract class Imatges {
    /*Create Variables private, static and final*/
    private static final String RUTA = "src/Peixera/Imatges/";
    private static final String imatge_covid = "coronavirus.png";
    private static final String imatge_vacuna = "vacuna.png";
    /*Create array the string, with the name of the images, of type private, static and final*/
    private static final String[] array_nom_imatges = new String[]{
            "emoji1.png","emoji2.png","emoji3.png","emoji4.png","emoji5.png","emoji6.png","emoji7.png","emoji8.png","emoji9.png"
    };

    /**
     * Create method getter "getRUTA" of type static
     * @return value of the variable "RUTA"
     * **/
    public static String getRUTA() {return RUTA;}

    /**
     * Create method getter "getGImageCovid" of type static
     * @return instance of image the covid
     * **/
    public static GImage getGImageCovid() {return new GImage(RUTA+imatge_covid);}

    /**
     * Create method getter "getGImageVacuna" of type static
     * @return instance of image the vaccine
     * **/
    public static GImage getGImageVacuna() {return new GImage(RUTA+imatge_vacuna);}

    /**
     * Create method getter "getImageCovid" of type static
     * @return image of the covid
     * **/
    public static Image getImageCovid() {
        GImage imatge = new GImage(RUTA+imatge_covid);
        return imatge.getImage();
    }

    /**
     * Create method getter "getStringImageEmoji" of type static
     * @return random value of the array "array_nom_imatges"
     * **/
    public static String getStringImageEmoji() {return array_nom_imatges[Aleatori.getNumeroAleatori(0,array_nom_imatges.length-1)];}

    /**
     * Create method getter "getImageEmoji" of type static
     * @return random image of the emoji
     * **/
    public static Image getImageEmoji() {
        GImage imatge = new GImage(RUTA+array_nom_imatges[Aleatori.getNumeroAleatori(0,array_nom_imatges.length-1)]);
        return imatge.getImage();
    }
}