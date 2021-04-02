/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import decorate.*;
import javax.swing.JOptionPane;

/**
 *
 * @author bhi84
 */
public class DecorateSwitch {
         
         static NoticeBoard b2 = new Health();
         static NoticeBoard b3 = new Gag();  
         static NoticeBoard b4 = new Review();
         static NoticeBoard b5 = new Game();
         static NoticeBoard b6 = new Edu();
         static NoticeBoard b7 = new Tech();  
         static NoticeBoard b8 = new Music();
         String files ;
         static String writetitle ;
         
    public DecorateSwitch(int a,int b){
        NoticeBoard b1 = new Food();
        if(a ==1){
                      
                     if(b == 1){
                        b1 = new PictureFile(b1);
                        
                     }
                     else if(b == 2){
                        b1 = new VideoFile(b1);
                     files =".\\video.png";
                     }
                     else if(b == 3){
                        b1 = new MusicFile(b1);
                     files =".\\music.png";
                     }
                    
                      
                      writetitle=b1.getAddContents()+"("+b1.getKeyword()+")";
                      System.out.println(b1.getAddContents()+"("+b1.getKeyword()+")");
        }
        switch(a){
                
               
                 case 2:
                     if(b == 1){
                        b2 = new PictureFile(b2);
                      files =".\\pictur.png";
                     }
                     else if(b == 2){
                        b2 = new VideoFile(b2);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b2 = new MusicFile(b2);
                         files =".\\music.png";
                     }
                     
                      
                      writetitle=b2.getAddContents()+"("+b2.getKeyword()+")";
                     System.out.println(b2.getAddContents()+"("+b2.getKeyword()+")");
                   
                     break;
                 case 3:
                      if(b == 1){
                        b3 = new PictureFile(b3);
                         files =".\\picture.png";
                     }
                     else if(b == 2){
                        b3 = new VideoFile(b3);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b3 = new MusicFile(b3);
                         files =".\\music.png";
                     }
                     writetitle=b3.getAddContents()+"("+b3.getKeyword()+")";
                      System.out.println(b3.getAddContents()+"("+b3.getKeyword()+")");
                     
                     break;
                 case 4:
                     if(b == 1){
                        b4 = new PictureFile(b4);
                         files =".\\picture.png";
                     }
                     else if(b == 2){
                        b4 = new VideoFile(b4);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b4 = new MusicFile(b4);
                         files =".\\music.png";
                     }
                      
                      writetitle=b4.getAddContents()+"("+b4.getKeyword()+")";
                      System.out.println(b4.getAddContents()+"("+b4.getKeyword()+")");
                      
                     break;
                     
                 case 5:
                    if(b == 1){
                        b5 = new PictureFile(b5);
                         files =".\\picture.png";
                     }
                     else if(b == 2){
                        b5 = new VideoFile(b5);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b5 = new MusicFile(b5);
                         files =".\\music.png";
                     }
                     
                      
                      writetitle=b5.getAddContents()+"("+b5.getKeyword()+")";
                      System.out.println(b5.getAddContents()+"("+b5.getKeyword()+")");
                    
                     break;
                 case 6:
                      if(b == 1){
                        b6 = new PictureFile(b6);
                         files =".\\picture.png";
                     }
                     else if(b == 2){
                        b6 = new VideoFile(b5);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b6 = new MusicFile(b6);
                         files =".\\music.png";
                     }
                     
                      
                      writetitle=b6.getAddContents()+"("+b6.getKeyword()+")";
                      System.out.println(b6.getAddContents()+"("+b6.getKeyword()+")");
                      
                     break;
                 case 7:
                     if(b == 1){
                        b7 = new PictureFile(b7);
                         files =".\\pictur.png";
                     }
                     else if(b == 2){
                        b7 = new VideoFile(b7);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b7 = new MusicFile(b7);
                         files =".\\music.png";
                     }
                     
                      
                       writetitle=b7.getAddContents()+"("+b7.getKeyword()+")";
                       System.out.println(b7.getAddContents()+"("+b7.getKeyword()+")");
                      
                     break;
                 case 8:
                     if(b == 1){
                        b8 =new PictureFile(b8);
                         files =".\\picture.png";
                     }
                     else if(b == 2){
                        b8 = new VideoFile(b8);
                         files =".\\video.png";
                     }
                     else if(b == 3){
                        b8 = new MusicFile(b8);
                         files =".\\music.png";
                     }
                     
                      
                      writetitle=b8.getAddContents()+"("+b8.getKeyword()+")";
                      System.out.println(b8.getAddContents()+"("+b8.getKeyword()+")");
                  
                     break;
                     
                 case 0:
                     JOptionPane.showMessageDialog(null, "카테고리를 설정해 주세요.");
                     break;
             }
    }
   
}
