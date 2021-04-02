/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import test.*;
import state.*;
/**
 *
 * @author donny
 */
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;

public class VideoPanel extends JPanel {
    JButton subscribe = new JButton("구독하기");
    JButton recommendation = new JButton("추천하기");
    JButton exitvideo = new JButton("X");
    JButton playvideo= new JButton("Play");
    Image image;
    Graphics g;
    Icon testpic = new ImageIcon(".\\video1.gif");
    JLabel playytb = new JLabel(testpic);

    JLabel videoname = new JLabel("영상제목");
    private static JpanelChange win = new JpanelChange();
    WatchInfo watchInfo = new WatchInfo();//영상정보 객체 생성
    
    public VideoPanel(JpanelChange win){
        
        this.win=win;
        setLayout(null);
        setBounds(650, 0, 640, 499);
       
        image = Toolkit.getDefaultToolkit().createImage(".\\video1.gif");
      
        subscribe.setBounds(740,400,100,30);
        recommendation.setBounds(990,400,100,30);
        exitvideo.setBounds(1200,370,50,50);
        playvideo.setBounds(865,400,100,30);
       
        add(playvideo);         //nowatch->watch
        add(subscribe);         //watch->sub or rec->all
        add(recommendation);    //watch->rec or sub->all
        add(exitvideo);         //->nowatch
      
        subscribe.addActionListener(new VideoPanel.SubscribeActionListener());
        recommendation.addActionListener(new VideoPanel.RecommendationListener());
        exitvideo.addActionListener(new VideoPanel.ExitvideoListener());  
        playvideo.addActionListener(new VideoPanel.PlayvideoListener());
        }//생성자
    
      
      
    class SubscribeActionListener implements ActionListener{//구독버튼         
        public void actionPerformed(ActionEvent e) {
           
            if(watchInfo.getState().equals(watchInfo.getClickedRecommendationState())||    //추천상태가 아니고
               watchInfo.getState().equals(watchInfo.getNoSelectedState())){               //추천/구독 상태가 아닐때
                 JOptionPane.showMessageDialog(null, "구독 하였습니다! 구독자 수:"+(watchInfo.subcount+1));
            }else if(watchInfo.getState().equals(watchInfo.getNoWatchedState())){
                JOptionPane.showMessageDialog(null, "영상을 시청해야 구독 할 수 있습니다.");
            }else{
                 JOptionPane.showMessageDialog(null, "이미 구독한 채널입니다.!");
            }
             watchInfo.subscribe();      //구독버튼 눌러짐 출력
        } 
    }//구독클래스
    
    class RecommendationListener implements ActionListener{//추천버튼
        public void actionPerformed(ActionEvent e){
            
            if(watchInfo.getState().equals(watchInfo.getClickedSubscribeState())||      //추천상태가 아니고
               watchInfo.getState().equals(watchInfo.getNoSelectedState())){                //추천/구독 상태가 아닐때
                 JOptionPane.showMessageDialog(null, "추천 하였습니다! 추천 수:"+(watchInfo.reccount+1));
            }else if(watchInfo.getState().equals(watchInfo.getNoWatchedState())){
                JOptionPane.showMessageDialog(null, "영상을 시청해야 추천 할 수 있습니다.");
            }else{
                 JOptionPane.showMessageDialog(null, "이미 추천한 영상입니다.!");
            }
            watchInfo.recommendation();//추천이 눌러짐을 출력
        }     
    }//추천클래스
    
    class ExitvideoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
            watchInfo.exitvideo();  //영상에서 나가짐 출력
            remove(playytb);
            win.change("panelV");
            JOptionPane.showMessageDialog(null, "영상을 종료합니다.");
       
        }
    }//재생나가기클래스
    
    class PlayvideoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            playytb.setBounds(700,0,500,500);
            playytb.setVisible(true);
            add(playytb);            
            if(watchInfo.getState().equals(watchInfo.getNoWatchedState())){
                 JOptionPane.showMessageDialog(null, "영상을 시청합니다.");
            }else{
                 JOptionPane.showMessageDialog(null, "이미 영상을 시청하고 있습니다.");
            }
            watchInfo.entervideo();//영상에 들어가짐 재생 재생을 해야 추천 구독 가능)
        }
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            win.change("panelR");
        }
     }
    
}//클래스