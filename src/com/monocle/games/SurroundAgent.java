package com.monocle.games;

import com.monocle.games.inputs.XYZRadius;
import com.monocle.models.Agent;
import com.monocle.models.Tuple;

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

    public static final int MAX_COUNT   = 12;
    public static final int MAX_LENGTH  = 500;

    private JFrame      _frame;
    private Canvas      _canvas;
    private GameLogic   _surroundAgentLogic;
    private Random      _random;
    private int         _agentCount;
    private int         _cursorX;
    private int         _cursorY;
    private int         _cursorZ;
    private int         _lineColorRed;
    private int         _lineColorGreen;
    private int         _lineColorBlue;
    private int         _distance;

    public SurroundAgent() throws InterruptedException {
        _random             = new Random();
        _agentCount         = _random.nextInt(MAX_COUNT - 3) + 3;
        _canvas             = new Canvas();
        _surroundAgentLogic = new SurroundAgentLogic(_agentCount, _distance);
        _frame              = new JFrame();
        init();
    }

    private void init() throws InterruptedException {
        _frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        _frame.setBackground(Color.BLACK);
        _frame.add(_canvas);
        _frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
        _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseAdapter();
        _distance = 5;
//        run();
    }

    @Override
    public JFrame createGame() {
        return _frame;
    }

    private void tick() {
        Random random               = new Random();
        Tuple coordinates           = getCoordinates();
        Input input                 = new XYZRadius(_cursorX, _cursorY, coordinates.getE2(), _distance, _agentCount);
        ArrayList<Tuple> plotList   = new ArrayList<>();

        Collection<Agent> agents    = _surroundAgentLogic.runLogic(input);
        Graphics graphics           = _canvas.getGraphics();

        for(Agent agent : agents) {
            System.out.println("DRAWING AGENT: (" + agent.getX() + ", " + agent.getY() + ")");
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            graphics.setColor(new Color(r, g, b));
//            graphics.fillOval(agent.getX() - 4, agent.getY() - 4, 8, 8);
            plotList.add(new Tuple(agent.getX(), agent.getY()));
        }

        boolean drawLine = random.nextBoolean();
        if(true) {
            graphics.setColor(new Color(_lineColorRed, _lineColorGreen, _lineColorBlue));
//            graphics.setColor(Color.BLUE);
            for(int i = 0; i < plotList.size(); i++) {
                Tuple p0;
                Tuple p1;
                if(i > 0) {
                    p0 = plotList.get(i - 1);
                    p1 = plotList.get(i);
                }
                else {
                    p0 = plotList.get(i);
                    p1 = plotList.get(plotList.size() - 1);
                }
                graphics.drawLine(p0.getE0(), p0.getE1(), p1.getE0(), p1.getE1());
            }
        }
    }

    protected Tuple getCoordinates() {
        return new Tuple(_cursorX, _cursorY);
    }

    private void handleMouseEvent(final MouseEvent mouseEvent) throws InterruptedException {
        Thread rootThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        rootThread.start();
//        _cursorX = mouseEvent.getX();
//        _cursorY = mouseEvent.getY();
//        for(int i = 0; i < _agentCount; i++) {
//            _distance += 4;
//            _cursorZ +=4;
//            tick();
//        }
////        _distance = 32;
//        _agentCount = _random.nextInt(48 - 3) + 3;
//        _distance = _agentCount;
    }

    private void runGame() throws InterruptedException {
        while(true) {
//            Thread runThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Random random = new Random();
//                    for (int i = 0; i < 10; i++) {
//                        _lineColorRed = random.nextInt(255);
//                        _lineColorGreen = random.nextInt(255);
//                        _lineColorBlue = random.nextInt(255);
//                        _cursorX = _random.nextInt(_frame.getWidth());
//                        _cursorY = _random.nextInt(_frame.getHeight());
//                        for (int j = 0; j < _agentCount; j++) {
//                            _distance += 4;
//                            _cursorZ = _distance;
//                            _cursorX = _cursorX + 0;
//                            _cursorY = _cursorY + 0;
//                            tick();
//                        }
////            _distance = 32;
////            _agentCount = _random.nextInt(48 - 3) + 3;
//                        _agentCount = _random.nextInt(48 - 3) + 3;
//                        _distance = _agentCount;
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });

//            runThread.start();

            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                _lineColorRed = random.nextInt(255);
                _lineColorGreen = random.nextInt(255);
                _lineColorBlue = random.nextInt(255);
                _cursorX = _random.nextInt(_frame.getWidth());
                _cursorY = _random.nextInt(_frame.getHeight());
                for (int j = 0; j < _agentCount; j++) {
                    _distance += 4;
                    _cursorZ = _distance;
                    _cursorX = _cursorX + 0;
                    _cursorY = _cursorY + 0;
                    tick();
                }
//            _distance = 32;
//            _agentCount = _random.nextInt(48 - 3) + 3;
                _agentCount = _random.nextInt(48 - 3) + 3;
                _distance = _agentCount;
                try {
                    long waitLength = random.nextInt(MAX_LENGTH - 25) + 25;
                    Thread.sleep(waitLength);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            Thread.sleep(1000);
        }
//        _canvas.repaint();
//        Thread.sleep(2000);

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
                try {
                    handleMouseEvent(e);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
