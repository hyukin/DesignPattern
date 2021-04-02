package memento;
import test.*;

public class SavePoint {
  private String saveSearch;

  public SavePoint(String saveSearch) {
      this.saveSearch = saveSearch;
  }

  public String getsaveSearch() {
      return saveSearch;
  }
}
