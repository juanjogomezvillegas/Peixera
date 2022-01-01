package Peixera;
/*
 * We import the following classes:
 * @see acm.graphics.GImage
 * */
import acm.graphics.GImage;

/**
 * Create class "Vaccine"
 * @version 1
 * **/
public class Vaccine {
    /*Create Variables private, static or final*/
    private static final String RUTA = "src/Peixera/Images/";
    private final GImage IMAGE_VACCINE;
    private double speedX;
    private double speedY;

    /**
     * Create method constructor the class "Vaccine"
     * **/
    public Vaccine() {
        IMAGE_VACCINE = new GImage(RUTA+"vaccine.png");

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
     * @return IMAGE_VACCINE
     * **/
    public GImage getImage() {return IMAGE_VACCINE;}

    /**
     * Create method setter "setSpeedX"
     * @param speedX speed X the Vaccine
     * **/
    public void setSpeedX(double speedX) {this.speedX = speedX;}

    /**
     * Create method setter "setSpeedY"
     * @param speedY speed Y the Vaccine
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