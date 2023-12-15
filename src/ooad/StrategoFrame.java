package ooad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StrategoFrame extends JFrame implements ActionListener {

    // exit button
    private JButton exit;
    // reset button
    private JButton reset;
    // the board panel
    private StrategoPanel panel;
    // interface with the controller (command pattern)
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

    }

    // call on the appropriate control based on the action performed
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
    
    
}
