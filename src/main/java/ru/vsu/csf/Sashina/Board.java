package ru.vsu.csf.Sashina;

import ru.vsu.csf.Sashina.cell.Cell;
import ru.vsu.csf.Sashina.cell.TypeOfCell;
import ru.vsu.csf.Sashina.game.GameBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board extends JPanel {

    private GameBoard gameBoard;
    private List<Square> streetCells = new ArrayList<>();
    private List<Square> otherCells = new ArrayList<>();

    private static final int WIDTH = 80;
    private static final int HEIGHT = 64;

    public List<Square> getOtherCells(){
        return otherCells;
    }

    public List<Square> getStreetCells(){
        return streetCells;
    }

    public Board(int xCoord, int yCoord, GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 900, 720);
        this.setLayout(null);
        initializeSquares();
    }

    private void addSquare(int xCoord, int yCoord, Cell cell, int rotationDegrees) {
        Square square = new Square(xCoord, yCoord, WIDTH, HEIGHT, rotationDegrees, cell);
        this.add(square);
        streetCells.add(square);
        if (cell.getType() != TypeOfCell.STREET) otherCells.add(square);
    }

    private void initializeSquares() {
        Cell[] board = gameBoard.getGameBoard();
        int i = 0;
        while (i != 40) {
            addSquare(6, 6, board[i], 135);
            i++;
            for (int x = 86; x < 806; x += 80) {
                addSquare(x, 6, board[i], 180);
                i++;
            }
            addSquare(806, 6, board[i], -135);
            i++;
            for (int y = 70; y < 646; y += 64) {
                addSquare(806, y, board[i], -90);
                i++;
            }
            addSquare(806, 646, board[i], -45);
            i++;
            for (int x = 726; x > 6; x -= 80) {
                addSquare(x, 646, board[i], 0);
                i++;
            }
            addSquare(6, 646, board[i], 45);
            i++;
            for (int y = 582; y > 6; y -= 64) {
                addSquare(6, y, board[i], 90);
                i++;
            }
        }

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
        lblMonopoly.setBounds(320, 320, 263, 55);
        this.add(lblMonopoly);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
