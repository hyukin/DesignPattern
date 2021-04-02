package stratagy;

import flyweight.SetResult;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImagePrint implements PrintGui{
    SetResult setresult;
    String str;
    Image image;
    
    @Override
    public void print() {
        try {
            URL url = new URL(str);
            image = ImageIO.read(url);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImagePrint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImagePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setElement(Object tmp) {
        int index=(Integer)tmp;
        str=setresult.videoList.get(index).thumnail;
    }

    public Image getElement() {
        return (Image)image;
    }
}



