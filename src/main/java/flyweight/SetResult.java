/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import gui.Video;

/**
 *
 * @author hjk
 */
public class SetResult {
    private static DefaultListModel model=new DefaultListModel();
    private static JList list=new JList(model);
    private static int lock;
    private static JLabel label=new JLabel();
    
    private static JLabel loadingState=new JLabel();
    public static ArrayList<Video> videoList=new ArrayList<Video>();
    
    public void setList(){
        model=(DefaultListModel)list.getModel();
        model.addElement("키워드를 입력해주세요.");
        
        list.setFont( new Font("고딕", Font.PLAIN, 20) ); 
        list.setBounds(50, 130, 500, 170);
    }
    public JList returnList(){
        return list;
    }
    public void setLabelImage(Image image){
         label.setIcon(new ImageIcon(image));
    }
    public JLabel returnLabel(){
        return label;
    }
    public void getLabel(JLabel label){
        this.label=label;
    }
    public JLabel returnLoadLabel(){
        return loadingState;
    }
    public DefaultListModel returnMode(){
        return model;
    }
    public void removeModel(){
        model.removeAllElements();
    }
    public void addModel(int index){
        String str=videoList.get(index).title;
        model.add(index%5, str);
    }
    public void addElementModel(String str){
        model.addElement(str);
    }
    public int getLock(){
        return lock;
    }
    public void setLock(int lock){
        this.lock=lock;
    }
}
