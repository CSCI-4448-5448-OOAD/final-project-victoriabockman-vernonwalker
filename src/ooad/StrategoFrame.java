package ooad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StrategoFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private JButton exit;
    private JButton reset;
    private StrategoPanel panel;
    private Controller control;

    StrategoFrame(StrategoPanel p, String str){
        this.exit = new JButton("Exit");
        this.add(exit, BorderLayout.EAST);
        exit.addActionListener(this);

        this.reset = new JButton("Reset");
        this.add(reset, BorderLayout.CENTER);
        reset.addActionListener(this);
        
        this.panel = p;
        this.add(panel, BorderLayout.WEST);

        this.setTitle(str);

        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exit){
            control = new ExitControl();
            control.update();
            control = null;
        }
        if(e.getSource() == reset){
            control = new RestartControl();
            control.update(this.panel);
            control = null;
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        panel.mousePressedCaller(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        panel.mouseReleasedCaller(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // do nothing
    }

    
    
}
