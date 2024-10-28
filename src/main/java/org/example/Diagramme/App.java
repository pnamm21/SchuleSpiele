package org.example.Diagramme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class App extends JFrame implements ActionListener {
    private Diagram diagram = new Diagram();
    private DrawPanel pnlDiagram;
    private Timer tmrAnimation;
    private static App instance = null;

    public class DrawPanel extends Canvas {
        @Override
        public void paint(Graphics g) {
            if(diagram != null) {
                diagram.draw((Graphics2D)g);
                diagram.drawFan((Graphics2D)g);
                diagram.drawMuster((Graphics2D)g);
                diagram.drawSomething((Graphics2D)g);
                diagram.drawSomethingArray((Graphics2D)g);
            }
        }
    }

    private App() {
        //Main-Window
        this.setTitle("Diagram");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);

        //Draw-Panel
        this.pnlDiagram = new DrawPanel();
        this.add(this.pnlDiagram);

        //Animation-Timer
        try {
            Method getDelayMethod = this.diagram.getClass().getMethod("getDelay");
            Object res = getDelayMethod.invoke(this.diagram);
            int delay = (int) res;
            if(delay > 0) {
                this.tmrAnimation = new Timer(delay, this);
            }
            this.tmrAnimation.start();
        } catch (Exception ex) {
            //nothing to do
        }

        //make visible
        this.setVisible(true);
    }

    public static App getInstance() {
        if (App.instance == null) {
            App.instance = new App();
        }
        return instance;
    }

    public static DrawPanel getPanel() {
        return App.getInstance().pnlDiagram;
    }

    public static Timer getTimer() {
        return App.getInstance().tmrAnimation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pnlDiagram.repaint();
    }

    public static void main(String[] args) {
        App.getInstance();
    }
}
