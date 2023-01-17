package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static tictactoe.TicTacToe.isPlayer1Robot;
import static tictactoe.TicTacToe.isPlayer2Robot;

public class Board extends JPanel {
    static final int SIZE = 3; // size of field - board
    static boolean players;    // change order of players' moves X,O,X,O,X,O,X,O ... X-true, O-false
    static boolean isAnyWin = false;   // checks whether one of the players is the winner
    boolean once = false;
    static byte[][] wasClicked = new byte[SIZE][SIZE]; // -1 = empty, 0 = O, 1 = X
    static Button ButtonA3;
    static Button ButtonB3;
    static Button ButtonC3;
    static Button ButtonA1;
    static Button ButtonB1;
    static Button ButtonC1;
    static Button ButtonA2;
    static Button ButtonB2;
    static Button ButtonC2;


    static void robotMove(JLabel LabelStatus) {
//        System.out.println(isPlayer1Robot + "  and  " + isPlayer2Robot);

        anyWinCheck(LabelStatus);
        if (!isAnyWin) {
            if (isPlayer1Robot && isPlayer2Robot) {
                do {
                    if (!isAnyWin) {
                        getButton(robotPutCross()).setText("X");
                        anyWinCheck(LabelStatus);
                    } else {
                        continue;
                    }
                    if (!isAnyWin) {
                        getButton(robotPutZero()).setText("O");
                        anyWinCheck(LabelStatus);
                    }
                } while (!isAnyWin);

            } else if (!isPlayer1Robot && isPlayer2Robot) {
                getButton(robotPutZero()).setText("O");
                anyWinCheck(LabelStatus);
                players = true;
            } else if (isPlayer1Robot && !isPlayer2Robot) {
                getButton(robotPutCross()).setText("X");
                anyWinCheck(LabelStatus);
                players = false;

            } else {
                anyWinCheck(LabelStatus);
            }
        }
    }

    public void initComponents(JLabel LabelStatus) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                wasClicked[i][j] = -1;
            }
        }

//        for (int i = 3; i > 0; i--) {
//            for (char c : new char[]{'A', 'B', 'C'}) {
//                var btn = new JButton(c + "" + i);
//                btn.setName("Button" + c + i);
//                gameField.add(btn);
//            }
//        }
        if (!once) {
            ButtonA3 = new Button(" ");
            ButtonA3.setName("ButtonA3");
            ButtonA3.setFocusPainted(false);
            ButtonA3.setBackground(Color.orange);

            ButtonA3.addActionListener(e -> {
                if (wasClicked[0][0] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText(BoardStatus.ACTIVE.getText());
                    if (players) {
                        wasClicked[0][0] = 1;
                        ButtonA3.setText("X");
                        players = false;
                    } else {
                        wasClicked[0][0] = 0;
                        ButtonA3.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);

                }
            });

            ButtonB3 = new Button(" ");
            ButtonB3.setName("ButtonB3");
            ButtonB3.setFocusPainted(false);
            ButtonB3.setBackground(Color.orange);

            ButtonB3.addActionListener(e -> {
                if (wasClicked[0][1] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[0][1] = 1;
                        ButtonB3.setText("X");
                        players = false;
                    } else {
                        wasClicked[0][1] = 0;
                        ButtonB3.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonC3 = new Button(" ");
            ButtonC3.setName("ButtonC3");
            ButtonC3.setFocusPainted(false);
            ButtonC3.setBackground(Color.orange);
            ButtonC3.addActionListener(e -> {
                if (wasClicked[0][2] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[0][2] = 1;
                        ButtonC3.setText("X");
                        players = false;
                    } else {
                        wasClicked[0][2] = 0;
                        ButtonC3.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonA2 = new Button(" ");
            ButtonA2.setName("ButtonA2");
            ButtonA2.setFocusPainted(false);
            ButtonA2.setBackground(Color.orange);
            ButtonA2.addActionListener(e -> {
                if (wasClicked[1][0] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[1][0] = 1;
                        ButtonA2.setText("X");
                        players = false;
                    } else {
                        wasClicked[1][0] = 0;
                        ButtonA2.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonB2 = new Button(" ");
            ButtonB2.setName("ButtonB2");
            ButtonB2.setFocusPainted(false);
            ButtonB2.setBackground(Color.orange);
            ButtonB2.addActionListener(e -> {
                if (wasClicked[1][1] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[1][1] = 1;
                        ButtonB2.setText("X");
                        players = false;
                    } else {
                        wasClicked[1][1] = 0;
                        ButtonB2.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonC2 = new Button(" ");
            ButtonC2.setName("ButtonC2");
            ButtonC2.setFocusPainted(false);
            ButtonC2.setBackground(Color.orange);
            ButtonC2.addActionListener(e -> {
                if (wasClicked[1][2] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[1][2] = 1;
                        ButtonC2.setText("X");
                        players = false;
                    } else {
                        wasClicked[1][2] = 0;
                        ButtonC2.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonA1 = new Button(" ");
            ButtonA1.setName("ButtonA1");
            ButtonA1.setFocusPainted(false);
            ButtonA1.setBackground(Color.orange);
            ButtonA1.addActionListener(e -> {
                if (wasClicked[2][0] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[2][0] = 1;
                        ButtonA1.setText("X");
                        players = false;
                    } else {
                        wasClicked[2][0] = 0;
                        ButtonA1.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonB1 = new Button(" ");
            ButtonB1.setName("ButtonB1");
            ButtonB1.setFocusPainted(false);
            ButtonB1.setBackground(Color.orange);
            ButtonB1.addActionListener(e -> {
                if (wasClicked[2][1] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[2][1] = 1;
                        ButtonB1.setText("X");
                        players = false;
                    } else {
                        wasClicked[2][1] = 0;
                        ButtonB1.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            ButtonC1 = new Button(" ");
            ButtonC1.setName("ButtonC1");
            ButtonC1.setFocusPainted(false);
            ButtonC1.setBackground(Color.orange);
            ButtonC1.addActionListener(e -> {
                if (wasClicked[2][2] == -1 && !isAnyWin && TicTacToe.isStart) {
                    LabelStatus.setText("Game in progress");
                    if (players) {
                        wasClicked[2][2] = 1;
                        ButtonC1.setText("X");
                        players = false;
                    } else {
                        wasClicked[2][2] = 0;
                        ButtonC1.setText("O");
                        players = true;
                    }
                    robotMove(LabelStatus);
                }
            });

            add(ButtonA3);
            add(ButtonB3);
            add(ButtonC3);
            add(ButtonA2);
            add(ButtonB2);
            add(ButtonC2);
            add(ButtonA1);
            add(ButtonB1);
            add(ButtonC1);
            setLayout(new GridLayout(3, 3, 15, 15));
            once = true;
        }

        LabelStatus.setText(BoardStatus.NO_ACTIVE.getText());
        isAnyWin = false;
        ButtonA1.setText(" ");
        ButtonB1.setText(" ");
        ButtonC1.setText(" ");
        ButtonA2.setText(" ");
        ButtonB2.setText(" ");
        ButtonC2.setText(" ");
        ButtonA3.setText(" ");
        ButtonB3.setText(" ");
        ButtonC3.setText(" ");

    }

    public static byte checkedWin(byte[][] wasClicked) {
        byte row;
        boolean isSimilar = false;

        for (int i = 0; i < SIZE; i++) {
            isSimilar = false;
            if (wasClicked[i][0] != -1) {
                row = wasClicked[i][0];
                for (int j = 0; j < SIZE; j++) {
                    if (row == wasClicked[i][j]) {
                        isSimilar = true;
                    } else {
                        isSimilar = false;
                        break;
                    }
                }
                if (isSimilar) {
                    return wasClicked[i][0];
                }
            }
        }
        byte column;
        System.out.println("===================");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(wasClicked[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < SIZE; i++) {
            isSimilar = false;
            if (wasClicked[0][i] != -1) {
                column = wasClicked[0][i];
                for (int j = 0; j < SIZE; j++) {
                    if (column == wasClicked[j][i]) {
                        isSimilar = true;
                    } else {
                        isSimilar = false;
                        break;
                    }
                }
                if (isSimilar) {
                    return wasClicked[0][i];
                }
            }
        }
        byte diagonal;
        for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
            isSimilar = false;
            if (wasClicked[0][0] != -1) {
                diagonal = wasClicked[0][0];
                if (diagonal == wasClicked[j][i]) {
                    isSimilar = true;
                } else {
                    isSimilar = false;
                    break;
                }
            }
        }
        if (isSimilar) {
            return wasClicked[0][0];
        }

        for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) {
            isSimilar = false;
            if (wasClicked[0][SIZE - 1] != -1) {
                diagonal = wasClicked[0][SIZE - 1];
                if (diagonal == wasClicked[j][i]) {
                    isSimilar = true;
                } else {
                    isSimilar = false;
                    break;
                }
            }
        }
        if (isSimilar) {
            return wasClicked[0][SIZE - 1];
        }

        return -1;

    }

    public static boolean isAllButClicked(byte[][] wasClicked) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (wasClicked[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void anyWinCheck(JLabel LabelStatus) {
        byte result = checkedWin(wasClicked);
        System.out.println("RES " + result);
        if (result == 1) {
            LabelStatus.setText(BoardStatus.X_WIN.getText());
            isAnyWin = true;
        } else if (result == 0) {
            LabelStatus.setText(BoardStatus.O_WIN.getText());
            isAnyWin = true;
        } else if (isAllButClicked(wasClicked)) {
            LabelStatus.setText(BoardStatus.NO_WINNER.getText());
            isAnyWin = true;
        }

    }


    public static String robotPutZero() {
        if (wasClicked[1][1] == -1) {
            wasClicked[1][1] = 0;
            return "B2";
        } else {
            byte sum;
            for (int i = 0; i < SIZE; i++) { // rows defend
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[i][j] == 1)
                        sum += 1;
                }
                if (sum == 2) {
                    String r = String.valueOf(3 - i);
                    if (wasClicked[i][0] == 1 && wasClicked[i][1] == 1 && wasClicked[i][2] == -1) {
                        wasClicked[i][2] = 0;
                        return String.valueOf(Character.toChars('A' + 2)) + r;
                    } else if (wasClicked[i][0] == 1 && wasClicked[i][2] == 1 && wasClicked[i][1] == -1) {
                        wasClicked[i][1] = 0;
                        return String.valueOf(Character.toChars('A' + 1)) + r;
                    } else if (wasClicked[i][0] == -1) {
                        wasClicked[i][0] = 0;
                        return String.valueOf(Character.toChars('A')) + r;
                    }
                }
            }

            for (int i = 0; i < SIZE; i++) { // columns defend
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[j][i] == 1)
                        sum += 1;
                }
                if (sum == 2) {
                    String c = String.valueOf(Character.toChars('A' + i));
                    if (wasClicked[0][i] == 1 && wasClicked[1][i] == 1 && wasClicked[2][i] == -1) {
                        wasClicked[2][i] = 0;
                        return c + 1;
                    } else if (wasClicked[0][i] == 1 && wasClicked[2][i] == 1 && wasClicked[1][i] == -1) {
                        wasClicked[1][i] = 0;
                        return c + 2;
                    } else if (wasClicked[0][i] == -1) {
                        wasClicked[0][i] = 0;
                        return c + 3;
                    }
                }
            }

            sum = 0;
            for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) { // main diagonal defend
                if (wasClicked[j][i] == 1)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][0] == 1 && wasClicked[1][1] == 1 && wasClicked[2][2] == -1) {
                    wasClicked[2][2] = 0;
                    return "C" + 1;
                } else if (wasClicked[0][0] == 1 && wasClicked[2][2] == 1 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 0;
                    return "B" + 2;
                } else if (wasClicked[0][0] == -1) {
                    wasClicked[0][0] = 0;
                    return "A" + 3;
                }
            }

            sum = 0;
            for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) { // secondary diagonal defend
                if (wasClicked[j][i] == 1)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][2] == 1 && wasClicked[1][1] == 1 && wasClicked[2][0] == -1) {
                    wasClicked[2][0] = 0;
                    return "A" + 1;
                } else if (wasClicked[0][2] == 1 && wasClicked[2][0] == 1 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 0;
                    return "B" + 2;
                } else if (wasClicked[0][2] == -1) {
                    wasClicked[0][2] = 0;
                    return "C" + 3;
                }
            }

            for (int i = 0; i < SIZE; i++) { // rows attack
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[i][j] == 0)
                        sum += 1;
                }
                if (sum == 2) {
                    String r = String.valueOf(3 - i);
                    if (wasClicked[i][0] == 0 && wasClicked[i][1] == 0 && wasClicked[i][2] == -1) {
                        wasClicked[i][2] = 0;
                        return String.valueOf(Character.toChars('A' + 2)) + r;
                    } else if (wasClicked[i][0] == 0 && wasClicked[i][2] == 0 && wasClicked[i][1] == -1) {
                        wasClicked[i][1] = 0;
                        return String.valueOf(Character.toChars('A' + 1)) + r;
                    } else if (wasClicked[i][0] == -1) {
                        wasClicked[i][0] = 0;
                        return String.valueOf(Character.toChars('A')) + r;
                    }
                }
            }

            for (int i = 0; i < SIZE; i++) { // columns attack
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[j][i] == 0)
                        sum += 1;
                }
                if (sum == 2) {
                    String c = String.valueOf(Character.toChars('A' + i));
                    if (wasClicked[0][i] == 0 && wasClicked[1][i] == 0 && wasClicked[2][i] == -1) {
                        wasClicked[2][i] = 0;
                        return c + 1;
                    } else if (wasClicked[0][i] == 0 && wasClicked[2][i] == 0 && wasClicked[1][i] == -1) {
                        wasClicked[1][i] = 0;
                        return c + 2;
                    } else if (wasClicked[0][i] == -1) {
                        wasClicked[0][i] = 0;
                        return c + 3;
                    }
                }
            }
            sum = 0;
            for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) { // main diagonal attack
                if (wasClicked[j][i] == 0)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][0] == 0 && wasClicked[1][1] == 0 && wasClicked[2][2] == -1) {
                    wasClicked[2][2] = 0;
                    return "C" + 1;
                } else if (wasClicked[0][0] == 0 && wasClicked[2][2] == 0 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 0;
                    return "B" + 2;
                } else if (wasClicked[0][0] == -1) {
                    wasClicked[0][0] = 0;
                    return "A" + 3;
                }
            }

            sum = 0;
            for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) { // secondary diagonal attack
                if (wasClicked[j][i] == 0)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][2] == 0 && wasClicked[1][1] == 0 && wasClicked[2][0] == -1) {
                    wasClicked[2][0] = 0;
                    return "A" + 1;
                } else if (wasClicked[0][2] == 0 && wasClicked[2][0] == 0 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 0;
                    return "B" + 2;
                } else if (wasClicked[0][2] == -1) {
                    wasClicked[0][2] = 0;
                    return "C" + 3;
                }
            }

        }
        int d1, d2;
        do {
            Random random = new Random();
            d1 = random.nextInt(2);
            d2 = random.nextInt(2);
        } while (wasClicked[d1][d2] != -1);
        wasClicked[d1][d2] = 0;
        return String.valueOf(Character.toChars('A' + d2)) + (3 - d1);

    }

    public static String robotPutCross() {
        if (wasClicked[1][1] == -1) {
            wasClicked[1][1] = 1;
            return "B2";
        } else {
            byte sum;

            for (int i = 0; i < SIZE; i++) { // rows attack
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[i][j] == 1)
                        sum += 1;
                }
                if (sum == 2) {
                    String r = String.valueOf(3 - i);
                    if (wasClicked[i][0] == 1 && wasClicked[i][1] == 1 && wasClicked[i][2] == -1) {
                        wasClicked[i][2] = 1;
                        return String.valueOf(Character.toChars('A' + 2)) + r;
                    } else if (wasClicked[i][0] == 1 && wasClicked[i][2] == 1 && wasClicked[i][1] == -1) {
                        wasClicked[i][1] = 1;
                        return String.valueOf(Character.toChars('A' + 1)) + r;
                    } else if (wasClicked[i][0] == -1) {
                        wasClicked[i][0] = 1;
                        return String.valueOf(Character.toChars('A')) + r;
                    }
                }
            }

            for (int i = 0; i < SIZE; i++) { // columns attack
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[j][i] == 1)
                        sum += 1;
                }
                if (sum == 2) {
                    String c = String.valueOf(Character.toChars('A' + i));
                    if (wasClicked[0][i] == 1 && wasClicked[1][i] == 1 && wasClicked[2][i] == -1) {
                        wasClicked[2][i] = 1;
                        return c + 1;
                    } else if (wasClicked[0][i] == 1 && wasClicked[2][i] == 1 && wasClicked[1][i] == -1) {
                        wasClicked[1][i] = 1;
                        return c + 2;
                    } else if (wasClicked[0][i] == -1) {
                        wasClicked[0][i] = 1;
                        return c + 3;
                    }
                }
            }

            sum = 0;
            for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) { // main diagonal attack
                if (wasClicked[j][i] == 1)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][0] == 1 && wasClicked[1][1] == 1 && wasClicked[2][2] == -1) {
                    wasClicked[2][2] = 1;
                    return "C" + 1;
                } else if (wasClicked[0][0] == 1 && wasClicked[2][2] == 1 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 1;
                    return "B" + 2;
                } else if (wasClicked[0][0] == -1) {
                    wasClicked[0][0] = 1;
                    return "A" + 3;
                }
            }

            sum = 0;
            for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) { // secondary diagonal attack
                if (wasClicked[j][i] == 1)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][2] == 1 && wasClicked[1][1] == 1 && wasClicked[2][0] == -1) {
                    wasClicked[2][0] = 1;
                    return "A" + 1;
                } else if (wasClicked[0][2] == 1 && wasClicked[2][0] == 1 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 1;
                    return "B" + 2;
                } else if (wasClicked[0][2] == -1) {
                    wasClicked[0][2] = 1;
                    return "C" + 3;
                }
            }

            for (int i = 0; i < SIZE; i++) { // rows defend
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[i][j] == 0)
                        sum += 1;
                }
                if (sum == 2) {
                    String r = String.valueOf(3 - i);
                    if (wasClicked[i][0] == 0 && wasClicked[i][1] == 0 && wasClicked[i][2] == -1) {
                        wasClicked[i][2] = 1;
                        return String.valueOf(Character.toChars('A' + 2)) + r;
                    } else if (wasClicked[i][0] == 0 && wasClicked[i][2] == 0 && wasClicked[i][1] == -1) {
                        wasClicked[i][1] = 1;
                        return String.valueOf(Character.toChars('A' + 1)) + r;
                    } else if (wasClicked[i][0] == -1) {
                        wasClicked[i][0] = 1;
                        return String.valueOf(Character.toChars('A')) + r;
                    }
                }
            }

            for (int i = 0; i < SIZE; i++) { // columns defend
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (wasClicked[j][i] == 0)
                        sum += 1;
                }
                if (sum == 2) {
                    String c = String.valueOf(Character.toChars('A' + i));
                    if (wasClicked[0][i] == 0 && wasClicked[1][i] == 0 && wasClicked[2][i] == -1) {
                        wasClicked[2][i] = 1;
                        return c + 1;
                    } else if (wasClicked[0][i] == 0 && wasClicked[2][i] == 0 && wasClicked[1][i] == -1) {
                        wasClicked[1][i] = 1;
                        return c + 2;
                    } else if (wasClicked[0][i] == -1) {
                        wasClicked[0][i] = 1;
                        return c + 3;
                    }
                }
            }
            sum = 0;
            for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) { // main diagonal defend
                if (wasClicked[j][i] == 0)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][0] == 0 && wasClicked[1][1] == 0 && wasClicked[2][2] == -1) {
                    wasClicked[2][2] = 1;
                    return "C" + 1;
                } else if (wasClicked[0][0] == 0 && wasClicked[2][2] == 0 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 1;
                    return "B" + 2;
                } else if (wasClicked[0][0] == -1) {
                    wasClicked[0][0] = 1;
                    return "A" + 3;
                }
            }

            sum = 0;
            for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) { // secondary diagonal defend
                if (wasClicked[j][i] == 0)
                    sum += 1;
            }
            if (sum == 2) {
                if (wasClicked[0][2] == 0 && wasClicked[1][1] == 0 && wasClicked[2][0] == -1) {
                    wasClicked[2][0] = 1;
                    return "A" + 1;
                } else if (wasClicked[0][2] == 0 && wasClicked[2][0] == 0 && wasClicked[1][1] == -1) {
                    wasClicked[1][1] = 1;
                    return "B" + 2;
                } else if (wasClicked[0][2] == -1) {
                    wasClicked[0][2] = 1;
                    return "C" + 3;
                }
            }
        }
        int d1, d2;
        do {
            Random random = new Random();
            d1 = random.nextInt(2);
            d2 = random.nextInt(2);
        } while (wasClicked[d1][d2] != -1);
        wasClicked[d1][d2] = 1;
        return String.valueOf(Character.toChars('A' + d2)) + (3 - d1);
    }

    static Button getButton(String string) {
        switch (string) {
            case "A3":
                return ButtonA3;
            case "B3":
                return ButtonB3;
            case "C3":
                return ButtonC3;
            case "A2":
                return ButtonA2;
            case "B2":
                return ButtonB2;
            case "C2":
                return ButtonC2;
            case "A1":
                return ButtonA1;
            case "B1":
                return ButtonB1;
            case "C1":
                return ButtonC1;
            default:
                return ButtonA3;
        }
    }
}
