package gui;

import javax.swing.*;

/**
 *
 * @author bhi84
 */
public class JpanelChange extends JFrame {  //게시판 버튼 누르면 게시판 생김/ 뒤로가기 누르면 돌아가는 기능 구현
    public static MainPanel mainpanel =null;
    public static ListPanel listpanel =null;
    public static SearchPanel searchpanel =null;
    public VideoPanel videopanel = null;
    
    public void change(String panelName){        // 패널 1번과 2번 변경 후 재설정
        
        if(panelName.equals("panelM")){
            this.remove(mainpanel);
            getContentPane().add(listpanel);
            revalidate();
            repaint();
        }else if(panelName.equals("panelL")) {
            this.remove(listpanel);
            getContentPane().add(mainpanel);
            if(!ListPanel.titstr.equals("")){
            mainpanel.model.addElement(ListPanel.titstr);
            ListPanel.titstr ="";}
            revalidate();
            repaint();
        }else if (panelName.equals("panelV")){  //영상 안띄운 패널
            this.remove(videopanel);
            revalidate();
            repaint();
        }else if (panelName.equals("panelR")){
            getContentPane().add(videopanel);
            revalidate();
            repaint();
        }
        
    }
}
