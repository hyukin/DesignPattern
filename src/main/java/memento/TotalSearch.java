package memento;
import test.*;

public class TotalSearch {
  private String saveSearch;

  public void setsaveSearch(String saveSearch) {
      this.saveSearch =saveSearch;
  }

  public String getsaveSearch() {
      return saveSearch;
  }

  public SavePoint savesaveSearchToMemento() {
      return new SavePoint(saveSearch);
  }

  public void getsaveSearchfromMemento(SavePoint SavePoint) {
      saveSearch = SavePoint.getsaveSearch();
  }

}
