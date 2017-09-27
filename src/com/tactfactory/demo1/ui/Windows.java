package com.tactfactory.demo1.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Windows extends JFrame implements ActionListener {

    private JButton btn = new JButton();
    private JPanel container = new JPanel();
    private JLabel label = new JLabel();

    public Windows() {
        this.setVisible(true);
        this.setTitle("MaSuperWindow");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.btn.setText("Hello W!");
        this.btn.addActionListener(this);
        this.container.add(this.btn, BorderLayout.SOUTH);

        this.label.setText("Hello Label");
        this.container.add(this.label, BorderLayout.NORTH);

        this.add(this.container);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.btn.setText("Clicked !!!");
    }

    public static void run() {
        new Windows();
    }

}
