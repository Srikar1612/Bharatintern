
/**
 * Write a description of class TempConv here.
 *
 * @author V.Srikar
 * @version (18.10.2023)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TempConv extends JFrame implements ItemListener
{
    static JFrame f=new JFrame("Temperature Converter");
    static JPanel p=new JPanel();
    static JComboBox c1,c2;
    static JTextField tf1,tf2;
    Double result;
    public static void main(String[] args)
    {
        TempConv t=new TempConv();
        f.setSize(800,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setForeground(Color.white);
        String units[]={"None","Celsius","Fahrenheit","Kelvin"};
        c1=new JComboBox(units);
        c1.setBackground(Color.white);
        c1.setRenderer(new DefaultListCellRenderer() {
      @Override public Component getListCellRendererComponent(
          JList list, Object value, int index,
          boolean isSelected, boolean hasFocus) {
        JLabel l = (JLabel) super.getListCellRendererComponent(
            list, value, index, isSelected, hasFocus);
        if (isSelected) {
          l.setForeground(Color.black);
          l.setBackground(Color.cyan);
        } else {
          l.setForeground(Color.black);
          l.setBackground(Color.white);
        }
        return l;
      }
    });
        c2=new JComboBox(units);
        c2.setBackground(Color.white);
        c2.setRenderer(new DefaultListCellRenderer() {
      @Override public Component getListCellRendererComponent(
          JList list, Object value, int index,
          boolean isSelected, boolean hasFocus) {
        JLabel l = (JLabel) super.getListCellRendererComponent(
            list, value, index, isSelected, hasFocus);
        if (isSelected) {
          l.setForeground(Color.black);
          l.setBackground(Color.cyan);
        } else {
          l.setForeground(Color.black);
          l.setBackground(Color.white);
        }
        return l;
      }
    });
        tf1=new JTextField(20);
        tf2=new JTextField(20);
        p.add(tf1);
        p.add(c1);
        p.add(tf2);
        p.add(c2);
        c1.addItemListener(t);
        c2.addItemListener(t);
        setDefaultLookAndFeelDecorated(true);
        f.add(p);
        f.show();
    }
    public void itemStateChanged(ItemEvent ie)
    {
        String u1=(String)c1.getSelectedItem();
        String u2=(String)c2.getSelectedItem();
        if(u1==u2)
        {
            tf2.setText(tf1.getText());
        }
        else if(u1=="Celsius")
        {
            Double x=Double.parseDouble(tf1.getText());
            if(u2=="Fahrenheit")
            {
                result=(Double)9.0/5*x+32;
                tf2.setText(""+result);
            }
            else if(u2=="Kelvin")
            {
                result=x+273.15;
                tf2.setText(""+result);
        
            }
        }
        else if(u1=="Fahrenheit")
        {
            Double x=Double.parseDouble(tf1.getText());
            if(u2=="Celsius")
            {
                result=(Double)(x-32)*5.0/9;
            }
            else if(u2=="Kelvin")
            {
                result=(Double)(x-32)*5.0/9+273.15;
            }
            tf2.setText(""+result);
        }
        else if(u1=="Kelvin")
        {
            Double x=Double.parseDouble(tf1.getText());
            if(u2=="Celsius")
            {
                result=x-273.15;
            }
            else if(u2=="Fahrenheit")
            {
                result=(Double)(x-273.15)*9.0/5+32;
            }
            tf2.setText(""+result);
        }
    }
}