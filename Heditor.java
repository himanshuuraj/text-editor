/*
 * Decompiled with CFR 0_114.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Heditor {
    JFrame jjj;
    JTextArea jt;
    String fname;
    JPanel jp;
    Box bb;
    JLabel jb;

    public Heditor() {
        JTextArea jta;
        JFrame jfrm;
        this.jjj = jfrm = new JFrame("Untited");
        this.jb = new JLabel("it:");
        this.jp = new JPanel();
        this.bb = new Box(0);
        this.jjj.setLayout(new BorderLayout());
        this.jjj.setSize(400, 400);
        this.jjj.setDefaultCloseOperation(3);
        this.jp.add(this.bb);
        this.bb.add(this.jb);
        this.jt = jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(this.jt);
        this.jjj.add((Component)jsp, "Center");
        this.jjj.add((Component)this.jp, "South");
        JMenuBar mbar = new JMenuBar();
        this.jjj.setJMenuBar(mbar);
        JMenu file = new JMenu("File");
        file.addSeparator();
        file.setMnemonic('F');
        JMenuItem item1 = new JMenuItem("New...");
        file.add(item1);
        JMenuItem item2 = new JMenuItem("Open...");
        file.add(item2);
        JMenuItem item3 = new JMenuItem("Save");
        file.add(item3);
        JMenuItem item4 = new JMenuItem("--");
        file.add(item4);
        JMenuItem item5 = new JMenuItem("Exit");
        file.add(item5);
        mbar.add(file);
        JMenu edit = new JMenu("Edit");
        JMenuItem item6 = new JMenuItem("Cut");
        edit.add(item6);
        JMenuItem item7 = new JMenuItem("Copy");
        edit.add(item7);
        JMenuItem item8 = new JMenuItem("Paste");
        edit.add(item8);
        mbar.add(edit);
        edit.setMnemonic('E');
        this.jjj.setVisible(true);
        JMenu format = new JMenu("Format");
        file.addSeparator();
        file.setMnemonic('M');
        JMenuItem item10 = new JMenuItem("Font...");
        format.add(item10);
        mbar.add(format);
        this.jt.addCaretListener(new CaretListener(){

            @Override
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linenum = 1;
                int columnnum = 1;
                try {
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);
                    ++linenum;
                }
                catch (Exception caretpos) {
                    // empty catch block
                }
                Heditor.this.updateStatus(linenum, columnnum);
            }
        });
        this.updateStatus(1, 1);
        MyWindowAdapter adapter = new MyWindowAdapter(this);
        this.jjj.addWindowListener(adapter);
        MyMenuHandler handler = new MyMenuHandler(this);
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item10.addActionListener(handler);
        KeyStroke k = KeyStroke.getKeyStroke(78, 2);
        item1.setAccelerator(k);
        k = KeyStroke.getKeyStroke(79, 2);
        item2.setAccelerator(k);
        k = KeyStroke.getKeyStroke(83, 2);
        item3.setAccelerator(k);
        k = KeyStroke.getKeyStroke(80, 2);
        item8.setAccelerator(k);
        k = KeyStroke.getKeyStroke(69, 2);
        item5.setAccelerator(k);
        k = KeyStroke.getKeyStroke(67, 2);
        item7.setAccelerator(k);
        k = KeyStroke.getKeyStroke(88, 2);
        item6.setAccelerator(k);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Heditor();
            }
        });
    }

    private void updateStatus(int linenumber, int columnnnumber) {
        this.jb.setText("Line: " + linenumber + "  Column: " + columnnnumber);
    }

}

