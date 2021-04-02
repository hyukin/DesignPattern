package memento;

import java.util.ArrayList;
import java.util.List;
import test.*;

public class ReturnSearch {
     private List<SavePoint> mementoList =new ArrayList<SavePoint>();

  public void add(SavePoint saveSearch) {
      mementoList.add(saveSearch);
  }
  public SavePoint get(int index) {
      return mementoList.get(index);
  }

}
