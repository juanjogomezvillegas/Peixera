package Peixera;
/*
 * We import the following classes:
 * @see acm.graphics.GImage
 * */
import acm.graphics.GImage;

/**
 * Create class "Emoji"
 * @version 1
 * **/
public class Emoji {
    /*Create array the string, with the name of the images, of type private, static and final*/
    private static final String[] array_nom_images = new String[]{
            "emoji1.png","emoji2.png","emoji3.png","emoji4.png","emoji5.png","emoji6.png","emoji7.png","emoji8.png","emoji9.png"
    };
    /*Create Variables private, static or final*/
    private static final String RUTA = "src/Peixera/Images/";
    private final GImage IMAGE_EMOJI;
    private boolean covid;
    private double speedX;
    private double speedY;

    /**
     * Create method constructor the class "Emoji"
     * @param rutaEmoji path folder where are the images
     * @param covid variable boolean, what indicate if emoji is a covid or no
     * **/
    public Emoji(String rutaEmoji, boolean covid) {
        /*If emoji is not covid*/
        if (!covid) {
            /*we create one instance of the image the param "rutaEmoji"*/
            IMAGE_EMOJI = new GImage(RUTA+rutaEmoji);
        } else {/*If is covid*/
            /*we create one instance of the image "coronavirus.png"*/
            IMAGE_EMOJI = new GImage(RUTA+"coronavirus.png");
        }
        /*assign the variable "covid" the value of the param "covid"*/
        this.covid = covid;

        /*Generate number random between 0 and 5*/
        int numRandom = Random.getNumberRandom(0, 5);
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
     * Create method getter "getImage"
     * @return IMAGE_EMOJI
     * **/
    public GImage getImage() {return IMAGE_EMOJI;}

    /**
     * Create method setter "setCovid"
     * @param covid will be true, if is covid, and will be false, if is not covid
     * **/
    public void setCovid(boolean covid) {
        if (covid) {
            IMAGE_EMOJI.setImage(RUTA+"coronavirus.png");
        } else {
            IMAGE_EMOJI.setImage(RUTA+array_nom_images[Random.getNumberRandom(0,array_nom_images.length-1)]);
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