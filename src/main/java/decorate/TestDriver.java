/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorate;

import java.util.Scanner;

/**
 *
 * @author bhi84
 */
public class TestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        NoticeBoard b1 = new Edu();
        System.out.println(b1.getAddContents());
        
        b1 = new PictureFile(b1);
        System.out.println(b1.getAddContents()+"("+b1.getKeyword()+")");
        
        b1 = new PictureFile(b1);
       String a= b1.getAddContents()+"("+b1.getKeyword()+")";
        System.out.println(a);
        NoticeBoard b2 = new PictureFile(
                            new PictureFile(
                                new MusicFile(
                                    new Food())));
         System.out.println(b2.getAddContents()+"("+b2.getKeyword()+")");
    }
    
}
