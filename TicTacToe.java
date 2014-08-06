import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TicTacToe extends JPanel implements ActionListener
{   
    JFrame fr;
    boolean win=false;
    JMenuBar menubar;
    JButton arr[];
    int count=0;
    String c;
    int win_combos[][]=new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public static void main(String args[])
    {
        TicTacToe p1=new TicTacToe();
        p1.start();
    }
    public void start()
    {       
        fr=new JFrame("Tic Tac Toe");
        fr.setResizable(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(370,370);
        fr.setLocationRelativeTo(null);
        
        menubar=new JMenuBar();
        arr = new JButton[9];
        for(int i=0;i<9;i++)
        {
            arr[i]=new JButton("");
            arr[i].setBackground(Color.BLACK);
            arr[i].setActionCommand("i");
            arr[i].addActionListener(this);
            fr.add(arr[i]);
        }
        JMenu menu1,menu2;
        JMenuItem item1,Close,objective;
        fr.setLayout(new GridLayout(3,3));
        menu1=new JMenu("GAME");
        menu2=new JMenu("HELP");
        objective=new JMenuItem("Objective");
        objective.addActionListener(this);
        menu2.add(objective);
        item1=new JMenuItem("New");
        item1.addActionListener(this);
        Close=new JMenuItem("Exit");
        Close.addActionListener(this);      
        menu1.add(item1);
        menu1.add(Close);
        menubar.add(menu1);
        menubar.add(menu2);
        fr.setBackground(Color.BLACK);
        fr.setJMenuBar(menubar);
        fr.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        Object s=e.getSource();
        Object src=e.getActionCommand();
        if(src=="Exit")
        {
        int i=JOptionPane.showConfirmDialog(null,"Wanna exit??","EXIT",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        else
        {
            JOptionPane.getFrameForComponent(menubar);
        }
        }
        else if(src=="Objective")
            JOptionPane.showMessageDialog(null,"The goal is to be the first player to get 3 Xs or Os horizontally,vertically or diagonally","Objective",JOptionPane.INFORMATION_MESSAGE);
        else if(src=="New")
        {
            int i=JOptionPane.showConfirmDialog(null,"This game won't be saved! Continue?","New Game",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION)
            {
            fr.setVisible(false);
            TicTacToe t2=new TicTacToe();
            t2.start();
            }
            else
                JOptionPane.getFrameForComponent(menubar);
        }
        else
        {
            JButton got=(JButton)s;
            if(count%2==0)
            {
                got.setText("X");
                got.setEnabled(false);
                count++;
            }
            else
            {
                got.setText("O");
                got.setEnabled(false);
                count++;
            }
            
        
        for(int i=0;i<=7;i++)
        {   if(arr[win_combos[i][0]].getText().equals("")==false)
            {
                
            if((arr[win_combos[i][0]].getText().equals(arr[win_combos[i][1]].getText())) && (arr[win_combos[i][0]].getText().equals(arr[win_combos[i][2]].getText())))
            {
                //System.out.println("Hi");
                win=true;
                c=arr[win_combos[i][0]].getText();
                if(c.equals("X"))
                                JOptionPane.showMessageDialog(menubar,"X wins the game");
                else
                                JOptionPane.showMessageDialog(menubar,"O wins the game");
                newgame();
            }
            }
        }
        if(count==9 && win==false)
            {
               JOptionPane.showMessageDialog(null,"Game was a tie");
               newgame(); 
            }
        }
        }
        
    public void newgame()
    {
        int i=JOptionPane.showConfirmDialog(null,"Wanna start a new game??","New Game",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {
            fr.setVisible(false);
            TicTacToe t1=new TicTacToe();
            t1.start();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Thanks for Playing");
            System.exit(0);
        }
        
    }
    }
        
        
    

        
        
        
        
        
    


