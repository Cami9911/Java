package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(e -> load(e));
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void reset(ActionEvent actionEvent) {
       frame.canvas.createOffscreenImage();
       frame.canvas.repaint();
    }

    private void exit(java.awt.event.ActionEvent actionEvent) {
        JComponent comp = (JComponent) actionEvent.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("test.png"));
            frame.canvas.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void save(java.awt.event.ActionEvent actionEvent) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("./test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
