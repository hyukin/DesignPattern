/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import test.*;
import flyweight.SetResult;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import stratagy.BtnClass;
import stratagy.ListClass;
import stratagy.MoveLeftClass;
import stratagy.MoveRightClass;
import stratagy.PrintImgClass;

/**
 *
 * @author bhi84
 */
//키워드 체크박스 있는 클래스
class SearchPanel extends JPanel{
        String b = new String();
        String Rmemento = new String();
        
        JCheckBox chkfood = new JCheckBox("먹방");
        JCheckBox chkhealth = new JCheckBox("운동");
        JCheckBox chkgag = new JCheckBox("예능");
        JCheckBox chkreview = new JCheckBox("리뷰");
        JCheckBox chkgame = new JCheckBox("게임");
        JCheckBox chkedu = new JCheckBox("교육");
        JCheckBox chktech = new JCheckBox("기술");
        JCheckBox chkmusic = new JCheckBox("음악");
        JButton search =new JButton("검색");
        JButton lastsearch =new JButton("돌아가기");
        JButton watchvideo = new JButton("영상시청");
        JButton btnnext =new JButton(">");
        JButton btnpre =new JButton("<");


        JTextField textfield = new JTextField();    
        
        private static JpanelChange win = new JpanelChange();
        
        StringBuilder totalsearch = new StringBuilder();
        StringBuilder chksearch = new StringBuilder();
        SearchHistoryView shv= new SearchHistoryView();
        memento.TotalSearch mTotalSearch = new memento.TotalSearch();
        memento.ReturnSearch r = new memento.ReturnSearch();
        
        SetResult setResult=new SetResult();
        URL url;
        JLabel thumText=new JLabel("썸네일:");
        Image image = null;
        static int indexList=0;
        static int lock=0;
        
        
        
    public SearchPanel(JpanelChange winp){   //지정된 위치에 체크박스 추가
       
        this.win=winp;
        setLayout(null);
       
        setBounds(0, 0, 640,500);  
        
        chkfood.setBounds(20,60,70,30);
        add(chkfood);
        chkhealth.setBounds(90,60,70,30);
        add(chkhealth);
        chkgag.setBounds(160,60,70,30);
        add(chkgag);
        chkreview.setBounds(230,60,70,30);
        add(chkreview);
        chkgame.setBounds(20,90,70,30);
        add(chkgame);
        chkedu.setBounds(90,90,70,30);
        add(chkedu);
        chktech.setBounds(160,90,70,30);
        add(chktech);
        chkmusic.setBounds(230,90,70,30);
        add(chkmusic);
        
        textfield.setBounds(60,20, 400,30);    
        add(textfield);
        search.setBounds(470,20, 80,30);    
        add(search);
        lastsearch.setBounds(455,70,100,30);    
        add(lastsearch);
        watchvideo.setBounds(250,400,100,30);
        add(watchvideo);
        
        shv.test();
        add(shv.combox);
        
        setResult.setList();
        add(setResult.returnList());
        
        btnpre.setBounds(200, 310, 50, 30);
        btnpre.setFont(new Font("고딕",Font.BOLD,14));
        add(btnpre);
        btnnext.setBounds(280, 310, 50, 30);
        btnnext.setFont(new Font("고딕",Font.BOLD,14));
        add(btnnext);
        
        thumText.setBounds(50, 320, 80, 80);
        add(thumText);
        
        PrintImgClass printimgclass=new PrintImgClass("https://www.evernote.com/shard/s449/sh/29c143ab-d389-416d-90ac-591f2e5a7ec3/586689b69a6125aec7399f3272e1d282/res/02b2f9f7-2a75-452a-baa1-e2924e918cd6/ytubeMain.PNG");
        setResult.setLabelImage(printimgclass.getImage());
        setResult.returnLabel().setBounds(100,320,200,150);
        add(setResult.returnLabel());
        
        setResult.returnLoadLabel().setText("None");
        setResult.returnLoadLabel().setBounds(480, 302, 50, 50);
        add(setResult.returnLoadLabel());
        
        search.addActionListener(new btnActionListener());
        btnpre.addActionListener(new btnPreActionListener());
        btnnext.addActionListener(new btnNextActionListener());
        lastsearch.addActionListener(new LastActionListener());
        watchvideo.addActionListener(new PlayActionListener());
        setResult.returnList().addListSelectionListener(new SelectListListener());
        
    }
    
    public class btnActionListener implements ActionListener {    // 버튼 누르면 작동
        public void actionPerformed(ActionEvent e) {
            
            if(textfield.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Plz input keyword!");}
            else{
                
                lock=1;
                indexList=0;
                search.setEnabled(false);
                String str=textfield.getText();
                if(chkfood.isSelected() )
                           totalsearch.append("먹방+");
                if(chkhealth.isSelected())
                    totalsearch.append("운동+");
                if(chkgag.isSelected())
                    totalsearch.append("예능+");
                if(chkreview.isSelected())
                    totalsearch.append("리뷰+");
                if(chkgame.isSelected())
                    totalsearch.append("게임+");
                if(chkedu.isSelected())
                    totalsearch.append("교육+");
                if(chktech.isSelected())
                    totalsearch.append("기술+");
                if(chkmusic.isSelected())
                    totalsearch.append("음악+");

                totalsearch.append(textfield.getText());
                shv.combox.addItem(textfield.getText());
                mTotalSearch.setsaveSearch(totalsearch.toString());
                r.add(mTotalSearch.savesaveSearchToMemento());
           
                totalsearch.setLength(0);
                textfield.setText("");
                chkfood.setSelected(false);
                chkhealth.setSelected(false);
                chkgag.setSelected(false); 
                chkreview.setSelected(false); 
                chkgame.setSelected(false);
                chkedu.setSelected(false);
                chktech.setSelected(false);
                chkmusic.setSelected(false);

                str=mTotalSearch.getsaveSearch();
                
                BtnClass btnclass=new BtnClass(str);
                search.setEnabled(true);
                lock=0;
            }
            
        }
     }
    
    class btnPreActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lock=1;
            MoveLeftClass btnmove=new MoveLeftClass(indexList);
            indexList=btnmove.getIndex();
            lock=0;
        }
        
    }
    
    class btnNextActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lock=1;
            MoveRightClass btnmove=new MoveRightClass(indexList);
            indexList=btnmove.getIndex();
            lock=0;
        }
    }
    
    
    class LastActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
        
            search.setEnabled(false);
            lock=1;
            indexList=0;
            int reindex = shv.combox.getSelectedIndex()-1;
            System.out.println(reindex);
            mTotalSearch.getsaveSearchfromMemento(r.get(reindex));

            textfield.setText(mTotalSearch.getsaveSearch());    

            String str=textfield.getText();

            BtnClass btnclass=new BtnClass(str);
            lock=0;
            
            search.setEnabled(true);
            
        }
     }
    
    class PlayActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
            win.change("panelR");
        }
    }
    
    public class SelectListListener implements ListSelectionListener{
        // 리스트의 항목이 선택이 되면 실행
        @Override
        public void valueChanged(ListSelectionEvent e){
            if(!e.getValueIsAdjusting()){
                if(lock==0){
                    int index=setResult.returnList().getSelectedIndex();

                    ListClass listclass=new ListClass(index+indexList);
                    setResult.setLabelImage(listclass.getImage());
                }
               }
            }
        }
    
}
