/*
 * Decompiled with CFR 0_114.
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;

public class MyMenuHandler
implements ActionListener,
ItemListener,
KeyListener {
    Heditor menuFrame;
    JList font;
    JList bold;
    JList size;
    boolean chg = true;
    int res;
    String str = "Untilted";
    String arg;
    int fidx;
    int bidx;
    int sidx;
    JFrame hh;
    File f;
    String[] sfont = new String[]{"Dialog", "Times New Roman", "Verdana", "Terminal"};
    String[] sbold = new String[]{"bold", "italic", "plain", "Bold and italic"};
    String[] sslen = new String[]{"10", "12", "14", "24", "28", "36", "48", "72"};

    public MyMenuHandler(Heditor menuFrame) {
        this.menuFrame = menuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.arg = ae.getActionCommand();
        if (this.arg.equals("New...")) {
            if (this.chg) {
                if (!this.str.equals("Untilted")) {
                    this.res = JOptionPane.showConfirmDialog(this.menuFrame.jjj, "Do You Want to Save", "File Exit", 1);
                    if (this.res == 0) {
                        this.filesave();
                    } else if (this.res == 2) {
                        return;
                    }
                } else {
                    this.res = JOptionPane.showConfirmDialog(this.menuFrame.jjj, "Do You Want to Save Changes", "File Exit", 1);
                    if (this.res == 0) {
                        this.filesave();
                    } else if (this.res == 2) {
                        return;
                    }
                }
            }
            Heditor heditor = new Heditor();
        }
        if (ae.getActionCommand().equals("Open...")) {
            this.fileopen();
        }
        if (ae.getActionCommand().equals("Exit")) {
            this.fileexit();
        }
        if (ae.getActionCommand().equals("Save")) {
            this.filesave();
        }
        if (ae.getActionCommand().equals("Cut")) {
            this.menuFrame.jt.setText(this.menuFrame.jt.getText());
        }
        if (ae.getActionCommand().equals("Copy")) {
            this.menuFrame.jt.copy();
        }
        if (ae.getActionCommand().equals("Paste")) {
            this.menuFrame.jt.paste();
        }
        if (ae.getActionCommand().equals("Save As")) {
            JFileChooser jfc;
            JFileChooser _tmp = jfc = new JFileChooser();
            jfc.setFileSelectionMode(1);
            this.res = jfc.showSaveDialog(this.menuFrame.jjj);
            JFileChooser _tmp1 = jfc;
            if (this.res == 0) {
                this.f = jfc.getSelectedFile();
                this.menuFrame.fname = this.f.getAbsolutePath();
                int y = this.menuFrame.fname.lastIndexOf(92);
                int z = this.menuFrame.fname.lastIndexOf(46);
                String str = this.menuFrame.fname.substring(y + 1, z);
                this.menuFrame.jjj.setTitle(str);
                this.filewrite();
            }
        }
        if (ae.getActionCommand().equals("Font...")) {
            JList<String> size;
            JList<String> bold;
            JList<String> font;
            JFrame ee = new JFrame();
            ee.setVisible(true);
            ee.setSize(400, 400);
            ee.setLayout(new FlowLayout());
            this.font = font = new JList<String>(this.sfont);
            this.bold = bold = new JList<String>(this.sbold);
            this.size = size = new JList<String>(this.sslen);
            font.setSelectionMode(2);
            bold.setSelectionMode(2);
            size.setSelectionMode(2);
            JScrollPane j = new JScrollPane(font);
            JScrollPane ja = new JScrollPane(bold);
            JScrollPane jaa = new JScrollPane(size);
            j.setPreferredSize(new Dimension(120, 90));
            ja.setPreferredSize(new Dimension(120, 90));
            jaa.setPreferredSize(new Dimension(60, 90));
            j.setLocation(20, 20);
            ee.add(j);
            ee.add(ja);
            ee.add(jaa);
            this.hh = ee;
            Innerclass in = new Innerclass(this);
            font.addListSelectionListener(in);
            bold.addListSelectionListener(in);
            size.addListSelectionListener(in);
        }
    }

    void fileexit() {
        if (this.chg) {
            this.res = JOptionPane.showConfirmDialog(this.menuFrame.jjj, "Do You Want to Save Changes", "File Exit", 1);
            if (this.res == 0) {
                this.filesave();
            } else if (this.res == 2) {
                return;
            }
        }
        System.exit(0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void filesave() {
        if (this.chg) {
            if (!this.str.equals("Untilted")) {
                this.filewrite();
                return;
            } else {
                JFileChooser jfc;
                JFileChooser _tmp = jfc = new JFileChooser();
                jfc.setFileSelectionMode(1);
                this.res = jfc.showSaveDialog(this.menuFrame.jjj);
                JFileChooser _tmp1 = jfc;
                if (this.res != 0) return;
                this.f = jfc.getSelectedFile();
                this.menuFrame.fname = this.f.getAbsolutePath();
                int y = this.menuFrame.fname.lastIndexOf(92);
                int z = this.menuFrame.fname.lastIndexOf(46);
                this.str = this.menuFrame.fname.substring(y + 1, z);
                this.menuFrame.jjj.setTitle(this.str);
                this.filewrite();
            }
            return;
        } else {
            this.filewrite();
        }
    }

    void filewrite() {
        try {
            FileWriter fw = new FileWriter(this.menuFrame.fname);
            fw.write(this.menuFrame.jt.getText());
            fw.close();
            this.chg = false;
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(this.menuFrame.jjj, e.getMessage(), "File Save Error", 0);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemevent) {
    }

    void fileopen() {
        JFileChooser jfc;
        JFileChooser _tmp = jfc = new JFileChooser();
        jfc.setFileSelectionMode(0);
        this.res = jfc.showOpenDialog(this.menuFrame.jjj);
        JFileChooser _tmp1 = jfc;
        if (this.res == 0) {
            this.f = jfc.getSelectedFile();
            try {
                String data;
                FileReader fr = new FileReader(this.f);
                BufferedReader br = new BufferedReader(fr);
                this.menuFrame.jt.setText("");
                while ((data = br.readLine()) != null) {
                    data = data + "\n";
                    this.menuFrame.jt.append(data);
                }
                this.menuFrame.fname = this.f.getAbsolutePath();
                int y = this.menuFrame.fname.lastIndexOf(92);
                int z = this.menuFrame.fname.lastIndexOf(46);
                this.str = this.menuFrame.fname.substring(y + 1, z);
                this.menuFrame.jjj.setTitle(this.str);
                br.close();
                fr.close();
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(jfc, e.getMessage(), "File Open Error", 0);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyevent) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.chg = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.chg = true;
    }
}

