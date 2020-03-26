package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // desenam poligonul regulat
    JLabel sidesLabel;
    JSpinner sidesField; // dam numarul de laturi
    JComboBox colorCombo; // alegem culoarea formelor

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label=new JLabel("Execution number: ");
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        String colors[] = { "BLACK","YELLOW"};
        colorCombo= new JComboBox(colors);
        sidesField.setValue(6);
        frame.add(colorCombo);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

}
