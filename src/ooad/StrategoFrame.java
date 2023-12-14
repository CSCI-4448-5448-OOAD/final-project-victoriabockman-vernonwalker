package ooad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StrategoFrame extends JFrame implements ActionListener {

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

    
    
}
