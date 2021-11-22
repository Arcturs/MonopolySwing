package ru.vsu.csf.Sashina;

import ru.vsu.csf.Sashina.cell.Cell;
import ru.vsu.csf.Sashina.streets.Colour;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Arrays;

public class Square extends JPanel {

    private Cell cell;
    private JLabel nameLabel;

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Square(int xCoord, int yCoord, int width, int height, int rotationDegrees, Cell cell) {
        x = xCoord;
        y = yCoord;
        this.width = width;
        this.height = height;
        this.cell = cell;

        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(x, y, width, height);
        this.setLayout(null);

        if (rotationDegrees == 0) {
            nameLabel = new JLabel(centralizeName(cell.getName()));
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setVerticalAlignment(SwingConstants.CENTER);
            nameLabel.setBounds(0, 25, width,20);
            this.add(nameLabel);
        } else {
            nameLabel = new JLabel(centralizeName(cell.getName())) {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth() / 2.0;
                    double y = getHeight() / 2.0;
                    aT.rotate(Math.toRadians(rotationDegrees), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            if(rotationDegrees == 90) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == -90) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 180) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 135 || rotationDegrees == -135 || rotationDegrees == -45 || rotationDegrees == 45) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setVerticalAlignment(SwingConstants.CENTER);

            this.add(nameLabel);
        }

    }

    public int[] getCoordinates() {
        return new int[]{x, y};
    }

    public int[] getSquareSize() {
        return new int[]{width, height};
    }

    public Cell getCell() {
        return cell;
    }

    private String centralizeName(String name) {
        String[] str = name.split(" ");
        StringBuilder sb = new StringBuilder("<html>");
        Arrays.stream(str).forEach(word -> sb.append(word).append("<br>"));
        return sb.append("</html>").toString();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cell.getStreet() != null) {
            if (cell.getStreet().getColour() == Colour.BROWN || cell.getStreet().getColour() == Colour.CYAN
                    || cell.getPosition() == 5) {
                g.drawRect(0, this.getHeight() - 20, this.getWidth(), 20);
                g.setColor(cell.getStreet().getColour().getColor());
                g.fillRect(0, this.getHeight() - 20, this.getWidth(), 20);
            }
            if (cell.getStreet().getColour() == Colour.PINK || cell.getStreet().getColour() == Colour.ORANGE
            || cell.getPosition() == 12 || cell.getPosition() == 15) {
                g.drawRect(0, 0, 20, this.getHeight());
                g.setColor(cell.getStreet().getColour().getColor());
                g.fillRect(0, 0, 20, this.getHeight());
            }
            if (cell.getStreet().getColour() == Colour.RED || cell.getStreet().getColour() == Colour.YELLOW
                    || cell.getPosition() == 28 || cell.getPosition() == 25) {
                g.drawRect(0, 0, this.getWidth(), 20);
                g.setColor(cell.getStreet().getColour().getColor());
                g.fillRect(0, 0, this.getWidth(), 20);
            }
            if (cell.getStreet().getColour() == Colour.GREEN || cell.getStreet().getColour() == Colour.BLUE
                    || cell.getPosition() == 35) {
                g.drawRect(this.getWidth() - 20, 0, 20, this.getHeight());
                g.setColor(cell.getStreet().getColour().getColor());
                g.fillRect(this.getWidth() - 20, 0, 20, this.getHeight());
            }
        }

    }
}
