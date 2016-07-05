package com.monocle.games;

import com.monocle.games.inputs.XYInput;
import com.monocle.models.Agent;
import com.monocle.models.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by visitor15 on 7/4/2016.
 */
public class SurroundAgent implements Game {

    private static final int DISTANCE = 64;

    private JFrame      _frame;
    private Canvas      _canvas;
    private GameLogic   _soundAgentLogic;
    private int         _cursorX;
    private int         _cursorY;

    public SurroundAgent() {
        _canvas = new Canvas();
        _soundAgentLogic = new SurroundAgentLogic(8, DISTANCE);
        _frame = new JFrame();
        init();
    }

    private void init() {
        _frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        _frame.setBackground(Color.BLACK);
        _frame.add(_canvas);
        _frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
        addMouseAdapter();
    }

    @Override
    public JFrame createGame() {
        return _frame;
    }

    private void tick() {
        Random random               = new Random();
        Input input                 = new XYInput(_cursorX, _cursorY);
        ArrayList<Pair> plotList    = new ArrayList<>();

        Collection<Agent> agents    = _soundAgentLogic.runLogic(input);
        Graphics graphics           = _canvas.getGraphics();

        for(Agent agent : agents) {
            System.out.println("DRAWING AGENT: (" + agent.getX() + ", " + agent.getY() + ")");
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            graphics.setColor(new Color(r, g, b));
            graphics.fillOval(agent.getX() - 2, agent.getY() - 2, 4, 4);
            plotList.add(new Pair(agent.getX(), agent.getY()));
        }

        boolean drawLine = random.nextBoolean();
        if(drawLine) {
            graphics.setColor(Color.BLUE);
            for(int i = 0; i < plotList.size(); i++) {
                Pair p0;
                Pair p1;
                if(i > 0) {
                    p0 = plotList.get(i - 1);
                    p1 = plotList.get(i);
                }
                else {
                    p0 = plotList.get(i);
                    p1 = plotList.get(plotList.size() - 1);
                }
                graphics.drawLine(p0.getFirstVal(), p0.getSecondVal(), p1.getFirstVal(), p1.getSecondVal());
            }
        }
    }

    private void handleMouseEvent(final MouseEvent mouseEvent) {
        _cursorX = mouseEvent.getX();
        _cursorY = mouseEvent.getY();
        for(int i = 0; i < 10; i++) {
            tick();
        }
    }

    private void addMouseAdapter() {
        _canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

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
                System.out.println("Firing: " + e.getXOnScreen() + " ," + e.getYOnScreen());
                handleMouseEvent(e);
            }
        });
    }
}
