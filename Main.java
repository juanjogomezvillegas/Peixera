package Peixera;
/*
 * We import the following classes:
 * @see acm.program.GraphicsProgram
 * @see acm.graphics.GImage
 * @see acm.graphics.GLabel
 * @see javax.swing.JOptionPane
 * @see javax.swing.JButton
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see java.util.ArrayList
 * */
import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Create class "Main", inherited from the class "GraphicsProgram"
 * @see GraphicsProgram
 * @version 1
 * **/
public class Main extends GraphicsProgram {
    /*Create array the string, with the name of the images, of type private, static and final*/
    private static final String[] array_nom_images = new String[]{
            "emoji1.png","emoji2.png","emoji3.png","emoji4.png","emoji5.png","emoji6.png","emoji7.png","emoji8.png","emoji9.png"
    };
    /*Create Variables private, static or final*/
    private static final ArrayList<Emoji> array_emojis = new ArrayList<>();
    private static final String RUTA = "src/Peixera/Images/";
    private static GImage wallpaper;
    private String level;
    private Vaccine vaccine;
    private int PAUSE = 5;
    /*Create Button private*/
    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;
    private JButton measures;
    private JButton RelaxMeasures;
    private JButton Day;
    private JButton Night;

    /**
     * Create method setter and static main
     * @param args array the Strings
     * **/
    public static void main(String[] args) {new Main().start(args);}

    /**
     * Create method setter init
     * **/
    public void init() {
        /*
         * setSize set the size window in 1500 the width and 1000 the height
         * setBackground set the color window in DARK GRAY
         * */
        setSize(1500, 1000);
        setBackground(Color.DARK_GRAY);

        /*Add to game wallpaper*/
        wallpaper = new GImage(RUTA+"wallpaper1.jpg");
        wallpaper.setSize(getWidth(), getHeight());
        add(wallpaper, 0, 0);

        /*Show message "Start the COVID-19 Pandemic!"*/
        GLabel start = new GLabel("Start the COVID-19 Pandemic!");
        Main.setStyleLabel(start, "70");
        add(start, getWidth() / 2.0 - start.getWidth() / 2.0, getHeight() / 2.0);

        waitForClick();/*Wait until the user click on the window*/
        remove(start);/*Remove message "Start the COVID-19 Pandemic!"*/

        /*Ask the user the game level*/
        level = JOptionPane.showInputDialog("Levels\n1 : Easy | 2 : medium | 3 : difficult");
        int numEmojis = 0;
        switch (level) {
            case "1":
                numEmojis = 5;
                break;
            case "2":
                numEmojis = 10;
                break;
            case "3":
                numEmojis = 15;
                break;
            default:
                break;
        }

        /*Add to ArrayList "array_emojis" the images of the covid*/
        array_emojis.add(new Emoji("", true));

        /*Add to ArrayList "array_emojis" the images of the emojis and add the images of the emojis in the window*/
        for (int i = 0; i < numEmojis; i++) {
            array_emojis.add(new Emoji(array_nom_images[Random.getNumberRandom(0,array_nom_images.length-1)], false));

            double positionX = Random.getNumberRandom(60, getWidth() - 75);
            double positionY = Random.getNumberRandom(60, getHeight() - 75);
            add(array_emojis.get(i).getImage(), positionX, positionY);
        }

        /*Add the vaccine in the window*/
        vaccine = new Vaccine();
        double positionX = Random.getNumberRandom(60, getWidth() - 75);
        double positionY = Random.getNumberRandom(60, getHeight() - 75);
        add(vaccine.getImage(), positionX, positionY);

        /*Add the Buttons*/
        left = new JButton("LEFT");
        left.setBackground(Color.CYAN);
        add(left, 1235, 865);
        right = new JButton("RIGHT");
        right.setBackground(Color.CYAN);
        add(right, 1375, 865);
        up = new JButton("UP");
        up.setBackground(Color.CYAN);
        add(up, 1310, 850);
        down = new JButton("DOWN");
        down.setBackground(Color.CYAN);
        add(down, 1300, 880);
        measures = new JButton("containment measures");
        measures.setBackground(Color.CYAN);
        add(measures, 50, 870);
        RelaxMeasures = new JButton("Relax Confinement");
        RelaxMeasures.setBackground(Color.CYAN);
        add(RelaxMeasures, 220, 870);
        Day = new JButton("Day");
        Day.setBackground(Color.CYAN);
        add(Day, 160, 900);
        Night = new JButton("Night");
        Night.setBackground(Color.CYAN);
        add(Night, 220, 900);
        /*Add the Action Listeners*/
        addActionListeners();
    }

    /**
     * Create method setter actionPerformed
     * Listen for a button action
     * @param e type ActionEvent
     * **/
    public void actionPerformed(ActionEvent e) {
        /*Save the action in the variable "command"*/
        String command = e.getActionCommand();

        /*If "command" is equals to "UP"*/
        if (command.equals("UP")) {
            if (level.equals("1") || level.equals("2")) {
                vaccine.getImage().move(0, -50);
            } else if (level.equals("3")) {
                vaccine.getImage().move(0, -25);
            }
        }
        /*If "command" is equals to "DOWN"*/
        if (command.equals("DOWN")) {
            if (level.equals("1") || level.equals("2")) {
                vaccine.getImage().move(0, 50);
            } else if (level.equals("3")) {
                vaccine.getImage().move(0, 25);
            }
        }
        /*If "command" is equals to "LEFT"*/
        if (command.equals("LEFT")) {
            if (level.equals("1") || level.equals("2")) {
                vaccine.getImage().move(-50, 0);
            } else if (level.equals("3")) {
                vaccine.getImage().move(-25, 0);
            }
        }
        /*If "command" is equals to "RIGHT"*/
        if (command.equals("RIGHT")) {
            if (level.equals("1") || level.equals("2")) {
                vaccine.getImage().move(50, 0);
            } else if (level.equals("3")) {
                vaccine.getImage().move(25, 0);
            }
        }
        /*If "command" is equals to "containment measures"*/
        if (command.equals("containment measures")) {
            if (level.equals("1") || level.equals("2")) {
                PAUSE += 5;
            } else if (level.equals("3")) {
                PAUSE += 1;
            }
        }
        /*If "command" is equals to "Relax Confinement"*/
        if (command.equals("Relax Confinement")) {
            if (level.equals("1") || level.equals("2")) {
                PAUSE -= 5;
            } else if (level.equals("3")) {
                PAUSE -= 1;
            }
        }
        /*If "command" is equals to "Day"*/
        if (command.equals("Day")) {
            wallpaper.setImage(RUTA+"wallpaper2.jpg");
            wallpaper.setSize(getWidth(), getHeight());
        }
        /*If "command" is equals to "Night"*/
        if (command.equals("Night")) {
            wallpaper.setImage(RUTA+"wallpaper1.jpg");
            wallpaper.setSize(getWidth(), getHeight());
        }
    }

    /**
     * Create method setter run
     * **/
    public void run() {
        int counterInfected = 1;
        int counterNotInfected  = array_emojis.size()-1;
        boolean output = false;

        /*show the population the emoji's*/
        GLabel labelNotInfected = new GLabel("Population the Emoji's: " + counterNotInfected);
        Main.setStyleLabel(labelNotInfected, "35");
        /*show the number emoji's infected*/
        GLabel labelInfected = new GLabel("Emoji's Infected: " + counterInfected);
        Main.setStyleLabel(labelInfected, "35");

        /*Repeat the loop, while variable "output" be false*/
        while (!output) {
            /*show the population the emoji's*/
            labelNotInfected.setLabel("Population the Emoji's: " + counterNotInfected);
            add(labelNotInfected, getWidth() / 2.0 - labelInfected.getWidth() / 1.5, 50);
            /*show the number emoji's infected*/
            labelInfected.setLabel("Emoji's Infected: " + counterInfected);
            add(labelInfected, getWidth() / 2.0 - labelInfected.getWidth() / 2.0, 100);

            /*All emojis advanced*/
            for (Emoji x1 : array_emojis) {
                setMoveEmoji(x1);
            }

            /*check if an emoji is next to covid if there is an emoji is next to an covid, the emoji convert in covid*/
            for (Emoji x1 : array_emojis) {
                for (Emoji x2 : array_emojis) {
                    /*If emoji "x1" is covid and emoji "actual2" is not covid*/
                    if (x1.isCovid() && !x2.isCovid()) {
                        /*Storage the two images of the emoji1 "x1" and the emoji2 "x2", run method "getImage" of the class "Emoji"*/
                        GImage img1 = x1.getImage();
                        GImage img2 = x2.getImage();

                        /*If the two images collision*/
                        if (img1.getBounds().intersects(img2.getBounds())) {
                            x2.setCovid(true);/*emoji is convert to covid*/
                            x1.setSpeedX(-x1.getSpeedX());
                            x2.setSpeedX(-x2.getSpeedX());
                            counterNotInfected--;/*less 1 the variable "counterNotInfected"*/
                            counterInfected++;/*more 1 the variable "counterInfected"*/
                        }
                    }
                }
            }

            /*check if an vaccine is next to covid if there is an vaccine is next to an covid, the covid convert in emoji*/
            for (Emoji x1 : array_emojis) {
                /*If emoji "x1" is covid*/
                if (x1.isCovid()) {
                    /*Storage the two images of the emoji "x1" and the vaccine "x2", run method "getImage" of the class "Emoji" and "Vaccine"*/
                    GImage img1 = x1.getImage();
                    GImage img2 = vaccine.getImage();

                    /*If the two images collision*/
                    if (img1.getBounds().intersects(img2.getBounds())) {
                        x1.setCovid(false);/*covid is convert to emoji*/
                        x1.setSpeedX(-x1.getSpeedX());
                        vaccine.setSpeedX(-vaccine.getSpeedX());
                        counterNotInfected++;/*more 1 the variable "counterNotInfected"*/
                        counterInfected--;/*less 1 the variable "counterInfected"*/
                    }
                }
            }

            /*If counter of infect is equals to size the array "array_emojis" or counter of not infect is equals to size the array "array_emojis"*/
            if (counterInfected == array_emojis.size() || counterNotInfected == array_emojis.size()) {
                /*"output" will be equals to "true"*/
                output = true;
            }
        }

        /*Run method setter "setDeleteObjects"*/
        setDeleteObjects();

        /*If counter of infect is equals to size the array "array_emojis"*/
        if (counterInfected == array_emojis.size()) {
            /*Show a message "All Emoji's Infected"*/
            remove(labelNotInfected);
            labelInfected.setLabel("All Emoji's Infected");
            labelInfected.setLocation(getWidth() / 2.0 - labelInfected.getWidth() / 2.0, 50);

            /*Change the game wallpaper*/
            wallpaper.setImage(RUTA+"wallpaper-final-2.jpg");
            wallpaper.setSize(getWidth(), getHeight());

            /*Show a message "Humanity has become extinct!"*/
            GLabel end = new GLabel("Humanity has become extinct!");
            Main.setStyleLabel(end, "70");
            add(end, getWidth() / 2.0 - end.getWidth() / 2.0, getHeight() / 2.0);
        } else if (counterNotInfected == array_emojis.size()) {/*Else If counter of not infect is equals to size the array "array_emojis"*/
            /*Remove the messages*/
            remove(labelNotInfected);
            remove(labelInfected);

            /*Change the game wallpaper*/
            wallpaper.setImage(RUTA+"wallpaper-final-1.jpg");
            wallpaper.setSize(getWidth(), getHeight());

            /*Show a message "Humanity has become extinct!"*/
            GLabel end = new GLabel("Humanity has been saved!");
            Main.setStyleLabel(end, "70");
            add(end, getWidth() / 2.0 - end.getWidth() / 2.0, getHeight() / 2.0);
        }

        pause(1000);/*establishes the pause time, in the value of the variable "1000"*/

        waitForClick();/*wait until the user click on the window*/
        System.exit(0);/*Close the window of the game*/
    }

    /**
     * Create method setter "setMoveEmoji" of type private
     * @param emoji the emoji that needs to be moved
     * **/
    private void setMoveEmoji(Emoji emoji) {
        /*Storage in the variables "positionX" and "positionY", the position X and Y to the emoji to param*/
        double positionX = emoji.getImage().getX();
        double positionY = emoji.getImage().getY();

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
        emoji.getImage().move(emoji.getSpeedX(), emoji.getSpeedY());

        /*establishes the pause time, in the value of the variable "PAUSE"*/
        pause(PAUSE);
    }

    /**
     * Create method setter "setDeleteObjects" of type private
     * **/
    private void setDeleteObjects() {
        /*Makes all the button disappear*/
        up.setVisible(false);
        down.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);
        measures.setVisible(false);
        RelaxMeasures.setVisible(false);
        Day.setVisible(false);
        Night.setVisible(false);

        /*Makes all the emojis disappear*/
        for (Emoji actual1 : array_emojis) {
            actual1.getImage().setVisible(false);

            pause(50);
        }

        /*Makes all the vaccine disappear*/
        vaccine.getImage().setVisible(false);
    }

    /**
     * Create method setter "setStyleLabel" of type private and static
     * @param label label to apply color and font family and size
     * @param fontSize size of the letter of the label
     * **/
    private static void setStyleLabel(GLabel label, String fontSize) {
        label.setFont("Arial-"+fontSize);
        label.setColor(Color.GRAY);
    }
}