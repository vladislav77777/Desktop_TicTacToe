package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    static boolean isStart = false;
    static boolean isPlayer1Robot;
    static boolean isPlayer2Robot;

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);
        settings();
        setLayout(null);
        setVisible(true);
    }

    private void settings() {
        Board board = new Board();
        board.setBounds(35, 55, 370, 330);
        add(board);

        JLabel LabelStatus = new JLabel(BoardStatus.NO_ACTIVE.getText());
        LabelStatus.setName("LabelStatus");
        LabelStatus.setBounds(30, 390, 200, 13);
        LabelStatus.setFont(new Font("Roboto", Font.BOLD, 13));
        LabelStatus.setHorizontalAlignment(SwingConstants.LEFT);
        LabelStatus.setForeground(Color.BLACK);
        add(LabelStatus);

        JPanel upperPanel = new JPanel();
        upperPanel.setBounds(5, 5, 440, 40);
        upperPanel.setLayout(null);
        add(upperPanel);

        JButton ButtonStartReset = new JButton("Start");
        ButtonStartReset.setName("ButtonStartReset");
        ButtonStartReset.setBorder(new RoundedBorder(10));
        ButtonStartReset.setBounds(170, 15, 90, 20);
        ButtonStartReset.setFocusPainted(false);
        ButtonStartReset.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonStartReset.setText("Start");
        ButtonStartReset.setFont(new Font("Roboto", Font.BOLD, 10));
        ButtonStartReset.setBackground(Color.BLACK);
        ButtonStartReset.setForeground(Color.white);
        ButtonStartReset.addActionListener(e -> {
            if (ButtonStartReset.getText().equals("Start")) {
                ButtonStartReset.setText("Reset");
                isStart = true;
                board.initComponents(LabelStatus);
                if (isPlayer1Robot && isPlayer2Robot) {
                    LabelStatus.setText(BoardStatus.ACTIVE.getText());
                    Board.robotMove(LabelStatus);
                } else if (!isPlayer1Robot && isPlayer2Robot) {
                    Board.players = true;
                } else if (isPlayer1Robot && !isPlayer2Robot) {
                    LabelStatus.setText(BoardStatus.ACTIVE.getText());
                    Board.robotMove(LabelStatus);
                    Board.players = false;
                } else {
                    Board.players = true;
                }
            } else {
                ButtonStartReset.setText("Start");
                isStart = false;
                board.initComponents(LabelStatus);
            }
        });
        upperPanel.add(ButtonStartReset);

        JButton ButtonPlayer1 = new JButton("Human");
        ButtonPlayer1.setName("ButtonPlayer1");
        ButtonPlayer1.setFocusPainted(false);
        ButtonPlayer1.setBounds(36, 15, 100, 20);
        ButtonPlayer1.setBorder(new RoundedBorder(10));
        ButtonPlayer1.setBackground(Color.white);
        ButtonPlayer1.setFont(new Font("Roboto", Font.BOLD, 10));
        ButtonPlayer1.addActionListener(e -> {
            if (ButtonPlayer1.getText().equals("Human")) {
                ButtonPlayer1.setText("Robot");
                isPlayer1Robot = true;
            } else {
                ButtonPlayer1.setText("Human");
                isPlayer1Robot = false;
            }
        });

        JButton ButtonPlayer2 = new JButton("Robot");
        ButtonPlayer2.setName("ButtonPlayer2");
        ButtonPlayer2.setFocusPainted(false);
        ButtonPlayer2.setBounds(295, 15, 100, 20);
        ButtonPlayer2.setBorder(new RoundedBorder(10));
        ButtonPlayer2.setBackground(Color.white);
        ButtonPlayer2.setFont(new Font("Roboto", Font.BOLD, 10));
        isPlayer2Robot = true;
        ButtonPlayer2.addActionListener(e -> {
            if (ButtonPlayer2.getText().equals("Human")) {
                ButtonPlayer2.setText("Robot");
                isPlayer2Robot = true;
            } else {
                ButtonPlayer2.setText("Human");
                isPlayer2Robot = false;
            }
        });

        upperPanel.add(ButtonPlayer1);
        upperPanel.add(ButtonPlayer2);
        board.initComponents(LabelStatus);

    }
}

