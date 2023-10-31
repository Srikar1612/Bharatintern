
/**
 * Write a description of class Calculator here.
 *
 * @author V.Srikar
 * @version (17.10.2023)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

public class Calculator extends JFrame implements ActionListener{
    BigDecimal op1,op2,result;
    String op;
    static JButton b[]=new JButton[10];
    static JButton add,sub,mul,div,mod,allclear,eq,dec,clear;
    static JFrame f=new JFrame("Calculator");
    static JPanel p=new JPanel();
    static JTextField t=new JTextField(10);
    public static void main(String[] args){
        Calculator c=new Calculator();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,200);
        f.setBackground(Color.white);
        GridBagLayout l=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        p.setLayout(l);
        add=new JButton("+");
        add.setForeground(Color.orange);
        add.setBackground(Color.white);
        sub=new JButton("-");
        sub.setForeground(Color.orange);
        sub.setBackground(Color.white);
        mul=new JButton("*");
        mul.setForeground(Color.orange);
        mul.setBackground(Color.white);
        div=new JButton("/");
        div.setForeground(Color.orange);
        div.setBackground(Color.white);
        mod=new JButton("%");
        mod.setForeground(Color.orange);
        mod.setBackground(Color.white);
        allclear=new JButton("AC");
        allclear.setForeground(Color.green);
        allclear.setBackground(Color.white);
        eq=new JButton("=");
        eq.setForeground(Color.orange);
        eq.setBackground(Color.white);
        dec=new JButton(".");
        dec.setForeground(Color.orange);
        dec.setBackground(Color.white);
        clear=new JButton("C");
        clear.setForeground(Color.red);
        clear.setBackground(Color.white);
        for(int i=0;i<10;i++)
        {
            b[i]=new JButton(""+i);
            b[i].setForeground(Color.orange);
            b[i].setBackground(Color.white);
        }
        gbc.gridx=0;
        gbc.gridx=0;
        gbc.gridwidth=5;
        t.setColumns(22);
        p.add(t,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        p.add(clear,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        p.add(allclear,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        p.add(b[0],gbc);
        gbc.gridx=3;
        gbc.gridy=1;
        p.add(b[1],gbc);
        gbc.gridx=4;
        gbc.gridy=1;
        p.add(b[2],gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        p.add(b[3],gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        p.add(b[4],gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        p.add(b[5],gbc);
        gbc.gridx=3;
        gbc.gridy=2;
        p.add(b[6],gbc);
        gbc.gridx=4;
        gbc.gridy=2;
        p.add(b[7],gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        p.add(b[8],gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        p.add(b[9],gbc);
        gbc.gridx=2;
        gbc.gridy=3;
        p.add(dec,gbc);
        gbc.gridx=3;
        gbc.gridy=3;
        p.add(add,gbc);
        gbc.gridx=4;
        gbc.gridy=3;
        p.add(sub,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        p.add(mul,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        p.add(div,gbc);
        gbc.gridx=2;
        gbc.gridy=4;
        p.add(mod,gbc);
        gbc.gridx=3;
        gbc.gridy=4;
        p.add(eq,gbc);
        for(int i=0;i<10;i++)
        {
            b[i].addActionListener(c);
        }
        clear.addActionListener(c);
        dec.addActionListener(c);
        add.addActionListener(c);
        sub.addActionListener(c);
        mul.addActionListener(c);
        div.addActionListener(c);
        mod.addActionListener(c);
        allclear.addActionListener(c);
        eq.addActionListener(c);
        f.add(p);
        setDefaultLookAndFeelDecorated(true);
        f.show();
    }
    public void actionPerformed(ActionEvent ae)
    {
        String str=ae.getActionCommand();
        char ch=str.charAt(0);
        if(Character.isDigit(ch) || ch=='.')
        {
            t.setText(t.getText()+str);
        }
        else
        {
            if(str.equals("+"))
            {
                op1=new BigDecimal(t.getText());
                op="+";
                t.setText("");
            }
            else if(str.equals("-"))
            {
                op1=new BigDecimal(t.getText());
                op="-";
                t.setText("");
            }
            else if(str.equals("*"))
            {
                op1=new BigDecimal(t.getText());
                op="*";
                t.setText("");
            }
            else if(str.equals("/"))
            {
                op1=new BigDecimal(t.getText());
                op="/";
                t.setText("");
            }
            else if(str.equals("%"))
            {
                op1=new BigDecimal(t.getText());
                op="%";
                t.setText("");
            }
            if(str.equals("C"))
            {
                String temp=t.getText();
                temp=temp.substring(0,temp.length()-1);
                t.setText(temp);
            }
            if(str.equals("AC"))
            {
                t.setText("");
            }
            if(str.equals("="))
            {
                op2=new BigDecimal(t.getText());
                if(op.equals("+"))
                {
                    result=op1.add(op2);
                }
                else if(op.equals("-"))
                {
                    result=op1.subtract(op2);
                }
                else if(op.equals("*"))
                {   
                    result=op1.multiply(op2);
                }
                else if(op.equals("/"))
                {
                    result=op1.divide(op2);
                }
                else if(op.equals("%"))
                {
                    result=op1.remainder(op2);
                }
                t.setText(""+result);
            }
        }
    }
}