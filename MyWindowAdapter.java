/*
 * Decompiled with CFR 0_114.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MyWindowAdapter
extends WindowAdapter {
    Heditor menuFrame;

    public MyWindowAdapter(Heditor menuFrame) {
        this.menuFrame = menuFrame;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.menuFrame.jjj.setVisible(false);
        this.menuFrame.jjj.setDefaultCloseOperation(3);
    }
}

