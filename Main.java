package com.example;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayDeque;
public class Main implements ActionListener {
    public static void main(String[] args) throws Exception {
        ReadImageComponent image = new ReadImageComponent();
        Menu menu = new Menu("UNK");
        MenuBar menu2 = new MenuBar();
        menu2.add(menu);
        Color col = new Color(100,0,0);
        Color col2 = new Color(200,40,0);
        Color col3 = new Color(0,0,50);
        Frame frame = new Frame();
        frame.setBackground(col2);
        frame.addWindowListener ( new WindowAdapter () {public void windowClosing (WindowEvent we) {System.exit(0);}});
        frame.setTitle("ホシノ推し");
        frame.setSize(720 ,480);
        frame.setMenuBar(menu2);
        Button btn = new Button("停止");
        btn.setPreferredSize(new Dimension(100, 100));
        btn.setVisible(true);
        GridBagLayout gnt = new GridBagLayout(); 
        GridBagConstraints cont = new GridBagConstraints();
        frame.setLayout(gnt);
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridheight = 1;
        cont.gridwidth = 1;
        gnt.setConstraints(btn, cont);
        frame.add(btn);
        TextArea text = new TextArea();
        text.setPreferredSize(new Dimension(100, 100));
        text.setVisible(true);
        cont.gridx = 0;
        cont.gridy = -1;
        cont.gridheight =1;
        cont.gridwidth = 1;
        gnt.setConstraints(text, cont);
        frame.add(text);
        frame.setVisible(true);
        Label label = new Label();
        label.setText("Blackjack");
        label.setForeground(col3);
        label.setPreferredSize(new Dimension(100,100));
        label.setVisible(true);
        cont.gridx =1;
        cont.gridy =1;
        cont.gridheight =1;
        cont.gridwidth = 1;
        gnt.setConstraints(label,cont);
        frame.add(label);

        
        Button btn3 = new Button("表示");
        btn3.setBackground(col);
        btn3.setPreferredSize(new Dimension(100,100));
        btn3.setVisible(true);
         cont.gridx = 1;
        cont.gridy = 0;
        cont.gridheight = 1;
        cont.gridwidth = 1;
        gnt.setConstraints(btn3, cont);
        frame.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Clipboard crip = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection select = new StringSelection("");
                try {
                   label.setText((String) crip.getData(DataFlavor.stringFlavor));
                } catch (UnsupportedFlavorException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
               
            }
        });
        

        

        Button btn2 = new Button("コピー");
        btn2.setPreferredSize(new Dimension(100,100));
        cont.gridx = 2;
        cont.gridy = 0;
        cont.gridheight = 1;
        cont.gridwidth = 1;
        gnt.setConstraints(btn2, cont);
        btn2.setVisible(true);
        frame.add(btn2);
        cont.gridx = 3;
        cont.gridy = 0;
        cont.gridheight =2;
        cont.gridwidth = 2;
        cont.insets = new Insets(0, 0, 100, 0);
        gnt.setConstraints(image, cont);
        frame.add(image);
        Button btn4 = new Button("移動");
        btn4.setPreferredSize(new Dimension(100,100));
        btn4.setVisible(true);
         cont.gridx = 4;
        cont.gridy = 0;
        cont.gridheight = 2;
        cont.gridwidth = 1;
        cont.insets = new Insets(0, 0, 100, 0);
        gnt.setConstraints(btn4, cont);
        frame.add(btn4);
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                Clipboard crip = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection select = new StringSelection(text.getText());
                crip.setContents(select, null);

            }
        });
        

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            btn.resize(100,50);
            frame.setVisible(false);
            }
        });
        
        
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                try {
                    Robot robot = new Robot();
                    robot.mouseMove(500, 1000);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                } catch (AWTException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
               
            }
        });
        Card card2 = new Card();
        ArrayDeque<String> card = card2.setDeck();
text.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
        if(text.getText().equals("引く")){
        String b = card.poll();
        label.setText(b);
        Judge.playerpoint += Integer.parseInt(b.substring(5));
        if(Judge.turn == 1){
        Judge.dealerpoint += Integer.parseInt(b.substring(5));
            Judge.turn--;
        }
        Judge.turn++;
        if(Judge.playerpoint > Judge.dealerpoint && 21 > Judge.playerpoint){
        
        }if(Judge.playerpoint < Judge.dealerpoint){

        }

        }
    }
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
        if(text.getText().equals("待つ")){
        for(; true ;){
            String b = card.poll();
            label.setText(b);
            Judge.dealerpoint += Integer.parseInt(b.substring(5));
            if(21/1.5 < Judge.dealerpoint){
        if(Judge.playerpoint > Judge.dealerpoint && 21 > Judge.dealerpoint && 21 > Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }
        if(Judge.playerpoint < Judge.dealerpoint && 21 > Judge.dealerpoint && 21 > Judge.playerpoint){
            label.setText("ディーラー勝利");
              break;
        }
           if(Judge.playerpoint > Judge.dealerpoint && 21 < Judge.dealerpoint && 21 < Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }if(Judge.playerpoint < Judge.dealerpoint && 21 < Judge.dealerpoint && 21 < Judge.playerpoint){
            label.setText("ディーラー勝利");
              break;
        }
        if(Judge.playerpoint > Judge.dealerpoint && 21 < Judge.dealerpoint && 21 > Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }if(Judge.playerpoint < Judge.dealerpoint && 21 < Judge.dealerpoint && 21 > Judge.playerpoint){
            label.setText("ディーラー勝利");
              break;
        }
        if(Judge.playerpoint > Judge.dealerpoint && 21 > Judge.dealerpoint && 21 < Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }if(Judge.playerpoint < Judge.dealerpoint && 21 > Judge.dealerpoint && 21 < Judge.playerpoint){
            label.setText("ディーラー勝利");
              break;
        }
        if(Judge.playerpoint < Judge.dealerpoint && 21 < Judge.dealerpoint && 21 < Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }if(Judge.playerpoint > Judge.dealerpoint && 21 > Judge.dealerpoint && 21 > Judge.playerpoint){
            label.setText("プレイヤー勝利");
              break;
        }
        
    }
    }
        }
    }

    }
});
        
        

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    

    }