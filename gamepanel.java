package TicTacToeGame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gamepanel extends JPanel implements ActionListener,KeyListener
{
    Random random = new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;
    boolean gameOver = false;
    

    gamepanel()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
         frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(101,29,50));
        textfield.setForeground(Color.white);
        textfield.setFont(new Font("INK FREE", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC TAC TOE");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(25,25,600,100);

        button_panel.setBounds(50,50,600,100);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.BLACK);

        for (int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV BOLI", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);

        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void paint(Graphics g) 
    {
        //TODO Auto-generated method stub
        super.paint(g);

        if (gameOver)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font ("Helvetica",Font.BOLD,50));
            g.drawString("GAME OVER !!", 300, 300);

            g.setFont(new Font ("Helvetica",Font.PLAIN,20));
            g.drawString("PRESS SPACEBAR OR ENTER \nTO RESTART GAME !!", 275, 350);
            gameOver = false;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

        for (int i=0;i<9;i++)
        {
            if (e.getSource()==buttons[i])
            {
                if (player1_turn)
                {
                    if (buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText(" O TURN");
                        check();
                    }
                }

                else{
                    if (buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText(" X TURN !! ");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        if (random.nextInt(2)==0)
        {
            player1_turn=true;
            textfield.setText("  X TURN  !! ");
        }

        else{
            player1_turn=false;
            textfield.setText("O TURN !! ");
        }

    }

    public void check()
    {

        // HORIZONTAL CHECK

        if ((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
        {
            xWins(0,1,2);
        }

        else if ((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
        }

        else if ((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }

        else if ((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
        {
            oWins(3,4,5);
        }

        else if ((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }

        else if ((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
        }

        //VERTICAL CHECK

        if ((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }

        else if ((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(0,3,6);
        }

        else if ((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }

        else if ((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
        {
            oWins(1,4,7);
        }

        else if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }

        else if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }

        // DIAGONAL CHECK

        if ((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }

        else if ((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(0,4,8);
        }

        else if ((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(2,4,6);
        }

        else if ((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(2,4,6);
        }


        else{
            
            tie();
        }

       
    }

    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);

        }

        textfield.setText("X WINS");
    }

    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);

        }

        textfield.setText("O WINS");
    }

    public void tie()
    {
        int flag=0;
        for (int i=0;i<9;i++)
        {
            if (buttons[i].getText()!="")
            {
                flag=1;
                continue;

            }

            else{
                flag=0;
                break;
            }
            
        }

        if (flag==1)
        {
            for (int i=0;i<9;i++)
            {   
                buttons[i].setEnabled(false);
            }
            textfield.setText("IT'S A TIE !!");
            restart();
        }

        
    }

    public void restart()
    {
        gameOver = true;
        //gamepanel gp= new gamepanel();
        firstTurn();
        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");

        if (e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            restart();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }


}
