/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import test.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author bhi84
 */

public class Start {
    public static void main(String[] args){
        JpanelChange win = new JpanelChange();

        win.setTitle("검색형 비디오 플레이어");//상태표시줄에 보이는 제목 지정
        win.setSize(1280,1000);//창 크기
        win.setResizable(false);//창 크기 조절가능
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SearchPanel sp = new SearchPanel(win);//체크박스
        
        win.videopanel = new VideoPanel(win);
        win.mainpanel = new MainPanel(win);
        win.listpanel = new ListPanel(win);
        //win.readyvideopanel = new ReadyVideoPanel(win);
        win.searchpanel = sp;
        win.add(sp);//체크박스 윈도우에 추가
        win.add(win.mainpanel);//초기상태:mainpanel (게시판 이동 버튼)
        //win.add(win.readyvideopanel);
        win.setVisible(true);
    }
}
