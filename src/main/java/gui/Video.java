/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import test.*;

/**
 *
 * @author 345
 */
public class Video {
    //변수 나중에 빌더 적용하고 private으로 바꿀 것 
    public String id;
    public String thumnail;
    public String title;
    public boolean checkCode=false;
    public boolean checkCode2=false;
    
    public Video(){
    }
    
    public Video(String id, String title, String thumnail){
        this.id=String.format("ID=https://www.youtube.com/watch?v=%s",id);;
        this.title=title;
        this.thumnail=thumnail;
    }
    
    public void setVideo(String id, String title, String thumnail){
        this.id=String.format("ID=https://www.youtube.com/watch?v=%s",id);;
        this.title=title;
        this.thumnail=thumnail;
    }
    
    public void printVideo(){
        System.out.println("title:"+title);
        System.out.println("Url:"+id);
    }
}
