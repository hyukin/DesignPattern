/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

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
         TotalSearch t =new TotalSearch();
         ReturnSearch r = new ReturnSearch();
         t.setsaveSearch("State1");
         t.setsaveSearch("State2");
         r.add(t.savesaveSearchToMemento());
         t.setsaveSearch("State3");
         r.add(t.savesaveSearchToMemento());
          t.setsaveSearch("State4");
          System.out.println("Current State: " + t.getsaveSearch());		
      t.getsaveSearchfromMemento(r.get(0));
      System.out.println("First saved State: " + t.getsaveSearch());
      t.getsaveSearchfromMemento(r.get(1));
      System.out.println("Second saved State: " + t.getsaveSearch());
    }
    
}
