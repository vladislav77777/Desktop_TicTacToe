package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text) {
        super(text);
        this.setBorder(new RoundedBorder(8));
        this.setFont(new Font("Arial", Font.BOLD, 40));

    }
}
