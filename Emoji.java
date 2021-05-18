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
 * **/
import acm.program.*;
import acm.graphics.*;

/**
 * Create class "Emoji", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Emoji extends GraphicsProgram {
    /**Create Variables private, final and static**/
    private static final String RUTA = "src/Peixera/Imatges/";
    /**Create Variables private**/
    private GImage IMAGE_EMOJI;
    private boolean covid;
    private int numRandom;
    private double speedX;
    private double speedY;

    /**
     * Create method constructor the class "Emoji"
     * @param rutaEmoji path folder where are the images
     * @param covid variable boolean, what indicate if emoji is a covid or no
     * **/
    public Emoji(String rutaEmoji, boolean covid) {
        /*we create one instance of the image the param "rutaEmoji"*/
        IMAGE_EMOJI = new GImage(RUTA+rutaEmoji);
        /*assign the variable "zoombie" the value of the param "zoombie"*/
        this.covid = covid;

        /*Generate number random between 0 and 5*/
        numRandom = Aleatori.getNumeroAleatori(0, 5);
        if (numRandom == 0) {/*If "numRandom" equals 0*/
            speedX = 4;
            speedY = 2;
        } else if (numRandom == 1) {/*If "numRandom" is equals to 1*/
            speedX = 4;
            speedY = -2;
        } else if (numRandom == 2) {/*If "numRandom" is equals to 2*/
            speedX = -4;
            speedY = 2;
        } else if (numRandom == 3) {/*If "numRandom" is equals to 3*/
            speedX = -4;
            speedY = -2;
        } else {/*If "numRandom" is not equals to the previous*/
            speedX = -4;
            speedY = -2;
        }
    }

    /**
     * Create method getter "getImatge"
     * @return IMAGE_EMOJI
     * **/
    public GImage getImatge() {return IMAGE_EMOJI;}

    /**
     * Create method setter "setCovid"
     * @param covid will be true, if is covid, and will be false, if is not covid
     * **/
    public void setCovid(boolean covid) {
        if (covid) {
            IMAGE_EMOJI.setImage(RUTA+"coronavirus.png");
        }
        this.covid = covid;
    }

    /**
     * Create method getter "isCovid"
     * @return covid
     * **/
    public boolean isCovid() {return covid;}

    /**
     * Create method setter "setSpeedX"
     * @param speedX speed X the emoji
     * **/
    public void setSpeedX(double speedX) {this.speedX = speedX;}

    /**
     * Create method setter "setSpeedY"
     * @param speedY speed Y the emoji
     * **/
    public void setSpeedY(double speedY) {this.speedY = speedY;}

    /**
     * Create method getter "getSpeedX"
     * @return speedX
     * **/
    public double getSpeedX() {return speedX;}

    /**
     * Create method getter "getSpeedY"
     * @return speedY
     * **/
    public double getSpeedY() {return speedY;}
}