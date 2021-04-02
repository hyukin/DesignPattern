package gui;

import test.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import decorate.*;
import java.util.ArrayList;
import static gui.DecorateSwitch.writetitle;
/**
 *
 * @author bhi84
 */
class ListPanel extends JPanel{
         JButton backbutton =new JButton("뒤로가기");
         JButton okbutton =new JButton("글쓰기");
         JTextArea comments = new JTextArea();
         JLabel title =new JLabel("게시판 작성");
         JLabel titlestatic =new JLabel("글 제목:");
         JTextField texttitle = new JTextField();
         JButton insertpicture =new JButton("사진첨부");
         JButton insertvideo =new JButton("비디오첨부");
         JButton insertmusic =new JButton("음악첨부");
         JComboBox catebox = new JComboBox();
         static String titstr="";
         static ArrayList<String> writetext = new ArrayList<String>();
         static ArrayList<String> arrtit = new ArrayList<String>();
         public static MainPanel mainpanel =null;
         NoticeBoard b1 = new Food();
         
         int nokey=9;
         int controlkey=0;
    
          private JpanelChange win;
         
    
    public ListPanel(JpanelChange win){
        setLayout(null);
        this.win =win;
        setBounds(0, 500,1280,500);
        
        catebox.addItem("카테고리 설정");
         catebox.addItem("[먹방]");
         catebox.addItem("[운동]");
         catebox.addItem("[예능]");
         catebox.addItem("[리뷰]");
         catebox.addItem("[게임]");
         catebox.addItem("[교육]");
         catebox.addItem("[기술]");
         catebox.addItem("[음악]");
          add(catebox);
        catebox.setBounds(420,540, 150,30); 
        titlestatic.setBounds(50,560,400,100);
        add(titlestatic);
        texttitle.setBounds(130,600,300,20);
        add(texttitle);
        title.setBounds(50,500,400,100);
        add(title);
        okbutton.setBounds(460,590,100,30);
        add(okbutton);
        backbutton.setBounds(460,630,100,30);
        add(backbutton);
        insertpicture.setBounds(160,630,100,30);
        add(insertpicture);
        insertvideo.setBounds(10,630,100,30);
        add(insertvideo);
        insertmusic.setBounds(310,630,100,30);
        add(insertmusic);
        arrtit.add("");
        
        comments.setBounds(0,680,500,250);
        add(comments);
        title.setFont(new Font("Serif", Font.PLAIN, 41));
         DecorateSwitch aa = new DecorateSwitch(nokey,controlkey);
        
         backbutton.addActionListener(new ListPanel.MyActionListener());
         okbutton.addActionListener(new ListPanel.OkActionListener());
         insertpicture.addActionListener(new ListPanel.IPPlusActionListener());
         insertvideo.addActionListener(new ListPanel.IVPlusActionListener());
         insertmusic.addActionListener(new ListPanel.IMPlusActionListener());
    }
    class IPPlusActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
            nokey = catebox.getSelectedIndex();
             controlkey = 1;
              b1 = new PictureFile(b1);
                    
                 writetitle=b1.getAddContents()+"("+b1.getKeyword()+")";
                      System.out.println(b1.getAddContents()+"("+b1.getKeyword()+")");
                  
                 
        }
     }
    
    class IVPlusActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
             nokey = catebox.getSelectedIndex();
             controlkey = 2;
                  b1 = new VideoFile(b1);
                  writetitle=b1.getAddContents()+"("+b1.getKeyword()+")";
                      System.out.println(b1.getAddContents()+"("+b1.getKeyword()+")");
        }
     }
    
    class IMPlusActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
             nokey = catebox.getSelectedIndex();
             controlkey = 3;
              b1 = new MusicFile(b1);
                 writetitle=b1.getAddContents()+"("+b1.getKeyword()+")";
                      System.out.println(b1.getAddContents()+"("+b1.getKeyword()+")");
        }
     }
    
    class MyActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
                texttitle.setText(null);
                comments.setText(null);
                win.change("panelL");
        }
     }
    
    class OkActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        public void actionPerformed(ActionEvent e) {
            nokey = catebox.getSelectedIndex();
            if(controlkey == 0){
                new DecorateSwitch(nokey,controlkey);
            }
            if(texttitle.getText().equals("")){
                JOptionPane.showMessageDialog(null, "글제목을 설정해 주세요.");
                }
            else if(nokey<0)
                JOptionPane.showMessageDialog(null, "카테고리를 설정해 주세요.");
            else if (nokey>0&&nokey<9){ 
                String catetit=catebox.getSelectedItem().toString();
                titstr= DecorateSwitch.writetitle+" "+texttitle.getText();
                writetext.add(comments.getText());
                String tmptit= titstr;
                arrtit.add(tmptit);
                texttitle.setText(null);
                comments.setText(null);
                win.change("panelL");
         
            }
        }
     }
}