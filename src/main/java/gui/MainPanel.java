/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static gui.ListPanel.writetext;


/**
 *
 * @author bhi84
 */
class MainPanel extends JPanel{
         Image img1 =null;
         Image img2 =null;
         Image img3 =null;
         
         String str = null;
         
         String sv = "[영상첨부";
         String sp = "[사진첨부";
         String sm = "[음악첨부";
         
         JButton mainbutton =new JButton("글쓰기");
         JButton readbutton =new JButton("글읽기");
         private JpanelChange win;
         JList list=new JList(new DefaultListModel());
         DefaultListModel model;
         public static ListPanel listpanel =null;
         JLabel calltext =new JLabel("기본");
         
         JLabel files1;
         JLabel files2;
         JLabel files3;
         
         public void sv(){
             files1 =new JLabel(new ImageIcon(img1));
             files1.setBounds(800, 600, 50, 50);
             add(files1);
         }
         
         public void sp(){
             files2 =new JLabel(new ImageIcon(img2));
             files2.setBounds(900, 600, 50, 50);
             add(files2);
         }
         
         public void sm(){
             files3 =new JLabel(new ImageIcon(img3));
             files3.setBounds(1000, 600, 50, 50);
             add(files3);
         }
         
    public MainPanel(JpanelChange win){
        setLayout(null);
        this.win =win;
        setBounds(0, 520,1280,480);
       
        mainbutton.setBounds(220,560,100,30);
        add(mainbutton);
        mainbutton.addActionListener(new MainPanel.MyActionListener());
        
        readbutton.setBounds(330,560,100,30);
        add(readbutton);
        readbutton.addActionListener(new MainPanel.ReadActionListener());

        model=(DefaultListModel)list.getModel();
        model.add(0, "게시판 게시글");
        
        list.setFont( new Font("고딕", Font.PLAIN, 20) );
        list.setBounds(0, 600, 490, 300);
        calltext.setBounds(600,560,300,400);
        add(list);
        add(calltext);
        
        try {
             img1 = ImageIO.read(new File(".\\video.png"));
             img2 = ImageIO.read(new File(".\\picture.png"));
             img3 = ImageIO.read(new File(".\\music.png"));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
                System.exit(0);
            }
    }
    
     class MyActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
            win.change("panelM");
        }
     }
     
     class ReadActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
            int reindex = list.getSelectedIndex();
            
            calltext.setText(writetext.get(reindex-1));
            calltext.setBounds(600,560,300,400);
            calltext.setFont(new Font("Serif", Font.BOLD, 20));
            add(calltext);
          
          str = ListPanel.arrtit.get(reindex).toString();
          String[] array = str.split("]");
          
            
          if(array[1].equals(sv)){
             sv();
          } if(array[1].equals(sp)){
             sp();
          } if(array[1].equals(sm)){
             sm();
          } if(array[1].equals(sv) && array[2].equals(sp)){
             sv();
             sp();
          } if(array[1].equals(sv) && array[2].equals(sm)){
             sv();
             sm();
          } if(array[1].equals(sp) && array[2].equals(sv)){
             sp();
             sv();
          } if(array[1].equals(sp) && array[2].equals(sm)){
             sp();
             sm();
          } if(array[1].equals(sm) && array[2].equals(sv)){
             sm();
             sv();
          } if(array[1].equals(sm) && array[2].equals(sp)){
             sm();
             sp();
          } if(array[1].equals(sv) && array[2].equals(sp) && array[3].equals(sm)){
             sv();
             sp();
             sm();
          } if(array[1].equals(sv) && array[2].equals(sm) && array[3].equals(sp)){
             sv();
             sm();
             sp();
          } if(array[1].equals(sp) && array[2].equals(sv) && array[3].equals(sm)){
             sp();
             sv();
             sm();
          } if(array[1].equals(sp) && array[2].equals(sm) && array[3].equals(sv)){
             sp();
             sm();
             sv();
          } if(array[1].equals(sm) && array[2].equals(sv) && array[3].equals(sp)){
             sm();
             sv();
             sp();
          } if(array[1].equals(sm) && array[2].equals(sp) && array[3].equals(sv)){
             sm();
             sp();
             sv();
          }
             
          
        }
     }
     
}

   