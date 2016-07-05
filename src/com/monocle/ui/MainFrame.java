package com.monocle.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by visitor15 on 7/4/2016.
 */
public abstract class MainFrame extends JFrame {

    private Canvas mainPanel;

    public MainFrame() { init(); }

    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screenSize.getWidth();
        int y = (int) screenSize.getHeight();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.BLACK);

        mainPanel = new Canvas();
        mainPanel.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        addMouseAdapter(mainPanel);
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void addMouseAdapter(final Canvas panel) {
        panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Firing: " + e.getXOnScreen() + " ," + e.getYOnScreen());
                Graphics circle = panel.getGraphics();
                circle.fillOval(e.getX() - 16, e.getY() - 16, 32, 32);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }
}
