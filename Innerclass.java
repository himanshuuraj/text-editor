/*
 * Decompiled with CFR 0_114.
 */
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Innerclass
implements ListSelectionListener {
    MyMenuHandler menu;
    Integer fidx;
    Integer bidx;
    Integer sidx;
    Integer s = 20;
    Font f;
    String fid = "Times New Roman";
    String bid;
    String sid;

    public Innerclass(MyMenuHandler menu) {
        this.menu = menu;
    }

    @Override
    public void valueChanged(ListSelectionEvent le) {
        try {
            this.fidx = this.menu.font.getSelectedIndex();
            this.fid = this.menu.sfont[this.fidx];
            this.f = new Font(this.fid, 0, 18);
        }
        catch (Exception var2_2) {
            // empty catch block
        }
        try {
            this.bidx = this.menu.bold.getSelectedIndex();
            this.bid = this.menu.sbold[this.bidx];
            if (this.bidx == 0) {
                this.f = new Font(this.fid, 1, this.s);
            } else if (this.bidx == 1) {
                this.f = new Font(this.fid, 2, this.s);
            } else if (this.bidx == 2) {
                this.f = new Font(this.fid, 0, this.s);
            } else if (this.bidx == 3) {
                this.f = new Font(this.fid, 3, this.s);
            }
        }
        catch (Exception var2_3) {
            // empty catch block
        }
        try {
            this.sidx = this.menu.size.getSelectedIndex();
            this.sid = this.menu.sslen[this.sidx];
            this.s = 10;
            this.s = 10;
            this.s = Integer.parseInt(this.sid);
            this.f = new Font(this.fid, 0, this.s);
        }
        catch (Exception var2_4) {
            // empty catch block
        }
        try {
            boolean r = true;
            if (this.bidx == 0) {
                this.f = new Font(this.fid, 1, this.s);
            } else if (this.bidx == 1) {
                this.f = new Font(this.fid, 2, this.s);
            } else if (this.bidx == 2) {
                this.f = new Font(this.fid, 0, this.s);
            } else if (this.bidx == 3) {
                this.f = new Font(this.fid, 3, this.s);
            }
            this.menu.menuFrame.jt.setFont(this.f);
        }
        catch (Exception e) {
            this.f = new Font("Times New Roman", 0, 12);
            this.menu.menuFrame.jt.setFont(this.f);
        }
    }
}

