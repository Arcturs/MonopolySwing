package ru.vsu.csf.Sashina;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class Dice extends JPanel {

    Random rnd = new Random();
    int faceValue = 1;

    public Dice(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(faceValue == 1) {
            g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
        } else if(faceValue == 2) {
            g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
        } else if(faceValue == 3) {
            g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
        } else if(faceValue == 4) {
            g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
        } else if(faceValue == 5) {
            g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 - 5/2, getHeight()/2 - 5/2, 5, 5);
        } else {
            g.fillOval(getWidth()/2 - 15, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 - 15, getHeight()/2 - 15, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 + 10, 5, 5);
            g.fillOval(getWidth()/2 - 15, getHeight()/2 - 5/2, 5, 5);
            g.fillOval(getWidth()/2 + 10, getHeight()/2 - 5/2, 5, 5);
        }
    }

    public int getFaceValue(){
        return faceValue;
    }

    public Dice(int xCoord, int yCoord, int width, int height, String labelString) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);
    }
}
