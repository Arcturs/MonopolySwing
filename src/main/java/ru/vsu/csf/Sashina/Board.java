package ru.vsu.csf.Sashina;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {

    private List<Square> streetCells = new ArrayList<>();
    private List<Square> otherCells = new ArrayList<>();

    public List<Square> getOtherCells(){
        return otherCells;
    }

    public List<Square> getStreetCells(){
        return streetCells;
    }

    public Square getSquareAtIndex(int location) {
        return streetCells.get(location);
    }

    public Board(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 900, 720);
        this.setLayout(null);
        initializeSquares();
    }

    private void initializeSquares() {

        String[] squareNames = {
                "Go",
                "Oriental Ave",
                "Community Chest",
                "Vermont Ave",
                "Connecticut Ave",
                "Roll once",
                "St. Charles Place",
                "Chance",
                "States Ave",
                "Virginia Ave",
                "Free Parking",
                "St. James Place",
                "Community Chest",
                "Tennessee Ave",
                "New York Ave",
                "Squeeze Play",
                "Pacific Ave",
                "North Carolina Ave",
                "Chance",
                "Pennsylvania Ave"
        };


        // squares on the top
        Square square00 = new Square(6,6,100,100,squareNames[0],135);
        this.add(square00);
        streetCells.add(square00);
        otherCells.add(square00);

        Square square01 = new Square(106,6,100,100,squareNames[1],180);
        this.add(square01);
        streetCells.add(square01);

        Square square02 = new Square(206,6,100,100,squareNames[2],180);
        this.add(square02);
        streetCells.add(square02);
        otherCells.add(square02);

        Square square03 = new Square(306,6,100,100,squareNames[3],180);
        this.add(square03);
        streetCells.add(square03);

        Square square04 = new Square(406,6,100,100,squareNames[4],180);
        this.add(square04);
        streetCells.add(square04);

        Square square05 = new Square(506,6,100,100,squareNames[5],-135);
        this.add(square05);
        streetCells.add(square05);
        otherCells.add(square05);

        // squares on the right
        Square square06 = new Square(506,106,100,100,squareNames[6],-90);
        this.add(square06);
        streetCells.add(square06);

        Square square07 = new Square(506,206,100,100,squareNames[7],-90);
        this.add(square07);
        streetCells.add(square07);
        otherCells.add(square07);

        Square square08 = new Square(506,306,100,100,squareNames[8],-90);
        this.add(square08);
        streetCells.add(square08);

        Square square09 = new Square(506,406,100,100,squareNames[9],-90);
        this.add(square09);
        streetCells.add(square09);

        Square square10 = new Square(506,506,100,100,squareNames[10],-45);
        this.add(square10);
        streetCells.add(square10);
        otherCells.add(square10);

        // squares on the bottom
        Square square11 = new Square(406,506,100,100,squareNames[11],0);
        this.add(square11);
        streetCells.add(square11);

        Square square12 = new Square(306,506,100,100,squareNames[12],0);
        this.add(square12);
        streetCells.add(square12);
        otherCells.add(square12);

        Square square13 = new Square(206,506,100,100,squareNames[13],0);
        this.add(square13);
        streetCells.add(square13);

        Square square14 = new Square(106,506,100,100,squareNames[14],0);
        this.add(square14);
        streetCells.add(square14);

        Square square15 = new Square(6,506,100,100,squareNames[15],45);
        this.add(square15);
        streetCells.add(square15);
        otherCells.add(square15);

        // squares on the left
        Square square16 = new Square(6,406,100,100,squareNames[16],90);
        this.add(square16);
        streetCells.add(square16);

        Square square17 = new Square(6,306,100,100,squareNames[17],90);
        this.add(square17);
        streetCells.add(square17);

        Square square18 = new Square(6,206,100,100,squareNames[18],90);
        this.add(square18);
        streetCells.add(square18);
        otherCells.add(square18);

        Square square19 = new Square(6,106,100,100,squareNames[19],90);
        this.add(square19);
        streetCells.add(square19);

        // setting prices
        square01.setPrice(100);
        square03.setPrice(100);
        square04.setPrice(120);

        square06.setPrice(140);
        square08.setPrice(140);
        square09.setPrice(160);

        square11.setPrice(180);
        square13.setPrice(180);
        square14.setPrice(200);

        square16.setPrice(300);
        square17.setPrice(300);
        square19.setPrice(320);

        // setting rent prcies
        square01.setRentPrice(6);
        square03.setRentPrice(6);
        square04.setRentPrice(8);

        square06.setRentPrice(10);
        square08.setRentPrice(10);
        square09.setRentPrice(12);

        square11.setRentPrice(14);
        square13.setRentPrice(14);
        square14.setRentPrice(16);

        square16.setRentPrice(26);
        square17.setRentPrice(26);
        square19.setRentPrice(28);




        JLabel lblMonopoly = new JLabel("MONOPOLY"){
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform aT = g2.getTransform();
                Shape oldshape = g2.getClip();
                double x = getWidth()/2.0;
                double y = getHeight()/2.0;
                aT.rotate(Math.toRadians(-35), x, y);
                g2.setTransform(aT);
                g2.setClip(oldshape);
                super.paintComponent(g);
            }
        };
        lblMonopoly.setForeground(Color.WHITE);
        lblMonopoly.setBackground(Color.RED);
        lblMonopoly.setOpaque(true);
        lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonopoly.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        lblMonopoly.setBounds(179, 277, 263, 55);
        this.add(lblMonopoly);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }




}
