package Peixera;
/*
 * We import the following classes:
 * @see acm.program.GraphicsProgram
 * @see acm.graphics.GImage
 * @see acm.graphics.GLabel
 * @see javax.swing.JOptionPane
 * @see java.awt.Color
 * @see java.util.ArrayList
 * */
import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Juan José Gómez Villegas
 * @author Jorge Luís Martínez Bermudez
 *
 * Create class "Partida", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Partida extends GraphicsProgram {
    /*Create Variables private, final and static*/
    private static final ArrayList<Emoji> array_emojis = new ArrayList<>();
    private static final ArrayList<Vacuna> array_vacunes = new ArrayList<>();
    /*Create Variables private and static*/
    private static GImage fons = new GImage(Imatges.getRUTA()+"fons.jpg");

    /**
     * Create method setter and static main
     * @param args array the Strings
     * **/
    public static void main(String[] args) {new Partida().start(args);}

    /**
     * Create method setter init
     * **/
    public void init() {
        /*
         * setSize set the size window in 900 the width and 900 the height
         * setBackground set the color window in DARK_GRAY
         * */
        setSize(1500, 1000);
        setBackground(Color.DARK_GRAY);

        /*
         * Add to wallpapper of the game
         * */
        fons.setSize(getWidth(), getHeight());
        add(fons, 0, 0);

        String nomPandemia = JOptionPane.showInputDialog("Write the name of pandemy: ");

        /*Show message "Start the COVID-19 Pandemy!"*/
        GLabel start = new GLabel("Start the " + nomPandemia + " Pandemy!");
        Partida.setStyleLabel(start, "70");
        add(start, getWidth() / 2.0 - start.getWidth() / 2.0, getHeight() / 2.0);

        waitForClick();/*wait until the user click on the window*/
        remove(start);/*Remove label "start"*/

        /*
         * add to ArrayList "array_emojis" the images of the covid
         * */
        array_emojis.add(new Emoji("", true));

        /*
         * Ask the user the number of emojis
         * */
        String numEmojis = JOptionPane.showInputDialog("Write the population of emojis: ");

        /*
         * Ask the user the number of vacunes
         * */
        String numVacunes = JOptionPane.showInputDialog("Write the number of Vaccines: ");

        /*
         * add to ArrayList "array_emojis" the images of the emojis
         * and add the images of the emojis in the window
         * */
        for (int i = 0; i < Integer.parseInt(numEmojis); i++) {
            array_emojis.add(new Emoji(Imatges.getStringImageEmoji(), false));

            double positionX = Aleatori.getNumeroAleatori(60, getWidth() - 75);
            double positionY = Aleatori.getNumeroAleatori(60, getHeight() - 75);
            add(array_emojis.get(i).getImatge(), positionX ,positionY);
        }

        /*
         * add to ArrayList "array_vacunes" the images of the vacunes
         * and add the images of the vacunes in the window
         * */
        for (int i = 0; i < Integer.parseInt(numVacunes); i++) {
            array_vacunes.add(new Vacuna());

            double positionX = Aleatori.getNumeroAleatori(60, getWidth() - 75);
            double positionY = Aleatori.getNumeroAleatori(60, getHeight() - 75);
            add(array_vacunes.get(i).getImatge(), positionX, positionY);
        }
    }

    /**
     * Create method setter run
     * **/
    public void run() {
        int ComptadorInfectats = 1;
        int ComptadorSans = array_emojis.size()-1;
        boolean sortir = false;

        /*show the population the emoji's*/
        GLabel comptaSans = new GLabel("Population the Emoji's: " + ComptadorSans);
        Partida.setStyleLabel(comptaSans, "35");
        /*show the number emoji's infected*/
        GLabel comptaInfectats = new GLabel("Emoji's Infected: " + ComptadorInfectats);
        Partida.setStyleLabel(comptaInfectats, "35");

        /*Repeat the loop, while variable "sortir" be false*/
        while (!sortir) {
            /*show the population the emoji's*/
            comptaSans.setLabel("Population the Emoji's: " + ComptadorSans);
            add(comptaSans, getWidth() / 2.0 - comptaInfectats.getWidth() / 1.5, 50);
            /*show the number emoji's infected*/
            comptaInfectats.setLabel("Emoji's Infected: " + ComptadorInfectats);
            add(comptaInfectats, getWidth() / 2.0 - comptaInfectats.getWidth() / 2.0, 100);

            /*All emojis advanced*/
            for (Emoji actual1 : array_emojis) {
                setMoureEmoji(actual1);
            }

            /*All vacunes advanced*/
            for (Vacuna actual1 : array_vacunes) {
                setMoureVacunes(actual1);
            }

            /*check if an emoji is next to covid
             * if there is an emoji is next to an covid, the emoji convert in covid*/
            for (Emoji actual1 : array_emojis) {
                for (Emoji actual2 : array_emojis) {
                    /*If emoji "actual1" is covid and emoji "actual2" is not covid*/
                    if (actual1.isCovid() && !actual2.isCovid()) {
                        /*Storage the two images of the emoji1 ("actual1") and the emoji2 ("actual2"),
                         * run method "getImatge" of the class "Emoji"*/
                        GImage img1 = actual1.getImatge();
                        GImage img2 = actual2.getImatge();

                        /*If the two images collision*/
                        if (img1.getBounds().intersects(img2.getBounds())) {
                            actual2.setCovid(true);/*emoji is convert to covid*/
                            actual1.setSpeedX(-actual1.getSpeedX());
                            actual2.setSpeedX(-actual2.getSpeedX());
                            ComptadorSans--;/*less 1 the variable "ComptadorSans"*/
                            ComptadorInfectats++;/*more 1 the variable "ComptadorInfectats"*/
                        }
                    }
                }
            }

            /*check if an vaccine is next to covid
             * if there is an vaccine is next to an covid, the covid convert in emoji*/
            for (Emoji actual1 : array_emojis) {
                for (Vacuna actual2 : array_vacunes) {
                    /*If emoji "actual1" is covid*/
                    if (actual1.isCovid()) {
                        /*Storage the two images of the emoji ("actual1") and the vaccine ("actual2"),
                         * run method "getImatge" of the class "Emoji" and "Vacuna"*/
                        GImage img1 = actual1.getImatge();
                        GImage img2 = actual2.getImatge();

                        /*If the two images collision*/
                        if (img1.getBounds().intersects(img2.getBounds())) {
                            actual1.setCovid(false);/*covid is convert to emoji*/
                            actual1.setSpeedX(-actual1.getSpeedX());
                            actual2.setSpeedX(-actual2.getSpeedX());
                            ComptadorSans++;/*more 1 the variable "ComptadorSans"*/
                            ComptadorInfectats--;/*less 1 the variable "ComptadorInfectats"*/
                        }
                    }
                }
            }

            /*If counter of infect is equals to size the array "array_emojis"
             * or counter of not infect is equals to size the array "array_emojis"*/
            if (ComptadorInfectats == array_emojis.size() || ComptadorSans == array_emojis.size()) {
                /*"sortir" will be equals to "true"*/
                sortir = true;
            }
        }

        /*Run method setter "setEsborrarObjectes"*/
        setEsborrarObjectes(array_emojis, array_vacunes);

        /*If counter of infect is equals to size the array "array_emojis"*/
        if (ComptadorInfectats == array_emojis.size()) {
            /*Show a message "All Emoji's Infected"*/
            remove(comptaSans);
            comptaInfectats.setLabel("All Emoji's Infected");
            comptaInfectats.setLocation(getWidth() / 2.0 - comptaInfectats.getWidth() / 2.0, 50);

            /*Change wallpapper of the game*/
            fons.setImage(Imatges.getRUTA()+"fons-final2.jpg");
            fons.setSize(getWidth(), getHeight());

            /*Show a message "Humanity has become extinct!"*/
            GLabel end = new GLabel("Humanity has become extinct!");
            Partida.setStyleLabel(end, "70");
            add(end, getWidth() / 2.0 - end.getWidth() / 2.0, getHeight() / 2.0);
        } else if (ComptadorSans == array_emojis.size()) {/*Else If counter of not infect is equals to size the array "array_emojis"*/
            /*Remove the messages*/
            remove(comptaSans);
            remove(comptaInfectats);

            /*Change wallpapper of the game*/
            fons.setImage(Imatges.getRUTA()+"fons-final1.jpg");
            fons.setSize(getWidth(), getHeight());

            /*Show a message "Humanity has become extinct!"*/
            GLabel end = new GLabel("Humanity has been saved!");
            Partida.setStyleLabel(end, "70");
            add(end, getWidth() / 2.0 - end.getWidth() / 2.0, getHeight() / 2.0);
        }

        pause(1000);/*establishes the pause time, in the value of the variable "1000"*/

        waitForClick();/*wait until the user click on the window*/
        System.exit(0);/*Close the window of the game*/
    }

    /**
     * Create method setter "setMoureEmoji" of type private
     * @param emoji the emoji that needs to be moved
     * **/
    private void setMoureEmoji(Emoji emoji) {
        /*Storage in the variables "positionX" and "positionY", the position X and Y to the emoji to param*/
        double positionX = emoji.getImatge().getX();
        double positionY = emoji.getImatge().getY();

        /*Check what "locX" be less that 0 or "locX" be greater that width to the window less 50
         * if is complies, will do the following*/
        if (positionX < 0 || positionX > getWidth() - 65) {
            emoji.setSpeedX(-emoji.getSpeedX());
        }
        /*Check what "locY" be less that 0 or "locY" be greater that height to the window less 50
         * if is complies, will do the following*/
        if (positionY < 0 || positionY > getHeight() - 65) {
            emoji.setSpeedY(-emoji.getSpeedY());
        }

        /*Move the emoji*/
        emoji.getImatge().move(emoji.getSpeedX(), emoji.getSpeedY());

        /*establishes the pause time, in the value of the variable "3"*/
        pause(3);
    }

    /**
     * Create method setter "setMoureVacunes" of type private
     * @param vacuna the vacuna that needs to be moved
     * **/
    private void setMoureVacunes(Vacuna vacuna) {
        /*Storage in the variables "positionX" and "positionY", the position X and Y to the vaccine to param*/
        double positionX = vacuna.getImatge().getX();
        double positionY = vacuna.getImatge().getY();

        /*Check what "locX" be less that 0 or "locX" be greater that width to the window less 50
         * if is complies, will do the following*/
        if (positionX < 0 || positionX > getWidth() - 65) {
            vacuna.setSpeedX(-vacuna.getSpeedX());
        }
        /*Check what "locY" be less that 0 or "locY" be greater that height to the window less 50
         * if is complies, will do the following*/
        if (positionY < 0 || positionY > getHeight() - 65) {
            vacuna.setSpeedY(-vacuna.getSpeedY());
        }

        /*Move the vaccine*/
        vacuna.getImatge().move(vacuna.getSpeedX(), vacuna.getSpeedY());

        /*establishes the pause time, in the value of the variable "3"*/
        pause(3);
    }


    /**
     * Create method setter "setEsborrarObjectes" of type private
     * @param array_emojis array of emojis
     * @param array_vacunes array of vaccines
     * **/
    private void setEsborrarObjectes(ArrayList<Emoji> array_emojis, ArrayList<Vacuna> array_vacunes) {
        /*Makes all the emojis disappear*/
        for (Emoji actual1 : array_emojis) {
            actual1.getImatge().setVisible(false);

            pause(50);
        }

        /*Makes all the vaccine disappear*/
        for (Vacuna actual1 : array_vacunes) {
            actual1.getImatge().setVisible(false);

            pause(50);
        }
    }

    /**
     * Create method setter "setStyleLabel" of type private and static
     * @param label label to apply color and font family and size
     * @param fontSize size of the letter of the label
     * **/
    private static void setStyleLabel(GLabel label, String fontSize) {
        label.setFont("CourierNew-"+fontSize);
        label.setColor(Color.LIGHT_GRAY);
    }
}