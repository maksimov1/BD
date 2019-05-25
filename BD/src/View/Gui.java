package View;

import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private JFrame mainframe;
    private JPanel leftpanel;
    private JScrollPane rightpanel;
    private int framew;
    private int frameh;
    private int leftfw;
    private int rightfw;

    private JPanel buttonpanel;
    private int buttonheight;

    private JPanel inputpanel;
    private int inputheight;

    private JButton hospb, patb, diagnb, notb;
    private JTable table;
    private int butsize;
    public  Gui(){
        initPanels();
        mainframe.setVisible(true);
    }

    public void changeTable(DefaultTableModel _table){
        table.setModel(_table);
        rightpanel.repaint();
    }

    private void initPanels(){

        mainframe = new JFrame();
        mainframe.setLayout(new BorderLayout());
        mainframe.setBackground(Color.WHITE);
        mainframe.setIconImage(Toolkit.getDefaultToolkit().createImage("frog.png"));
        mainframe.setTitle("Health Insurance Support System");
        framew = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()*3/4;
        frameh = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()*3/4;
        rightfw = (int) (0.75*framew);
        leftfw = framew - rightfw;
        //mainframe.setPreferredSize(new Dimension(1800, 900));
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        leftpanel = new JPanel();
        leftpanel.setLayout(new BorderLayout());
        leftpanel.setSize(leftfw,frameh);
        //leftpanel.setBackground(Color.GREEN);
        //leftpanel.setPreferredSize(new Dimension(leftfw, frameh));

        buttonpanel = new JPanel();
        buttonheight = (int)(frameh * 0.2);
        buttonpanel.setBackground(Color.WHITE);
        hospb = new JButton("Hospitals");
        patb= new JButton("Patients");
        diagnb = new JButton("Diagnosises");
        notb = new JButton("Notes");
        butsize = (int)(buttonheight * 0.2);
        hospb.setPreferredSize(new Dimension(leftfw, butsize));
        patb.setPreferredSize(new Dimension(leftfw, butsize));
        diagnb.setPreferredSize(new Dimension(leftfw, butsize));
        notb.setPreferredSize(new Dimension(leftfw, butsize));
        buttonpanel.setLayout(new FlowLayout());
        buttonpanel.add(hospb);
        buttonpanel.add(patb);
        buttonpanel.add(diagnb);
        buttonpanel.add(notb);
        buttonpanel.setPreferredSize(new Dimension(leftfw, buttonheight));

        inputpanel = new JPanel();
        inputheight = frameh - buttonheight;
        inputpanel.setPreferredSize(new Dimension(leftfw, inputheight));
        inputpanel.setBackground(Color.WHITE);
        leftpanel.add(inputpanel, BorderLayout.SOUTH);
        leftpanel.add(buttonpanel, BorderLayout.NORTH);


        rightpanel = new JScrollPane();
        rightpanel.setLayout(new ScrollPaneLayout());
        rightpanel.setSize(leftfw,frameh);
        rightpanel.setBackground(Color.WHITE);
        table = new JTable();
        //DefaultTableModel tabl = new DefaultTableModel(100,5);
        //table.setModel(tabl);
        //tabl.setRowCount(3);
        rightpanel.getViewport().add(table);
        //rightpanel.setBackground(Color.ORANGE);
        rightpanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2)));
        leftpanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2)));
        buttonpanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2)));
        inputpanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2)));
        //rightpanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f));
        rightpanel.setPreferredSize(new Dimension(rightfw, frameh));
        mainframe.add(leftpanel, BorderLayout.WEST);
        mainframe.add(rightpanel, BorderLayout.EAST);
        //mainframe.setLocationRelativeTo(null);
        mainframe.pack();
    }
}
