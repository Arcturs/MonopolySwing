package ru.vsu.csf.Sashina;

import ru.vsu.csf.Sashina.player.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private Player player;
    JLabel lblPlayerName;
    static int totalPlayers = 0;

    public Player getPlayer() {
        return player;
    }

    public PlayerPanel(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 20, 20);
        this.setLayout(null);
    }

    public PlayerPanel(Player player, Color color) {
        this.player = player;
        this.setBackground(color);
        lblPlayerName = new JLabel(player.getName());
        lblPlayerName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblPlayerName.setForeground(Color.WHITE);
        this.add(lblPlayerName);
        this.setBounds(6, 33, 20, 28);
        totalPlayers++;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    int[] xLocationsOfPlayer1 = {31, 131, 231, 331, 431, 531,
            531, 531, 531, 531, 531,
            431, 331, 231, 131, 31,
            31, 31, 31, 31};

    int[] yLocationsOfPlayer1 = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            533, 533, 533, 533, 533,
            433, 333, 233, 133};

    int[] xLocationsOfPlayer2 = {61, 191, 291, 361, 461, 561,
            561, 561, 561, 561, 561,
            461, 361, 261, 161, 61,
            61, 61, 61, 61};

    int[] yLocationsOfPlayer2 = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            533, 533, 533, 533, 533,
            433, 333, 233, 133};


    public void move() {
        int targetSquare = player.getPosition();

        if(!player.isInJail() && !player.isBankrupt()) {
            this.setLocation(xLocationsOfPlayer1[targetSquare], yLocationsOfPlayer1[targetSquare]);
        }
    }

}
