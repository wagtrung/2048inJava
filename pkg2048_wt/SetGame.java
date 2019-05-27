/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048_wt;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author WagTrung
 */


public class SetGame extends JPanel {
  
 Tile[] myTiles;
 Image bg = new ImageIcon("background.jpg").getImage();
 String font = "Arial";
 int tile_font_size = 99;
 int title_margin = 20;
  boolean checkWin = false;
  boolean checkLose = false;
  int Score = 0;

  public SetGame() { //contructor
      
  }
  
  public void startGame() {

        Score = 0;
        checkWin = false;
        checkLose = false;
        myTiles = new Tile[16];//4*4 tiles
        
        for (int i = 0; i < myTiles.length; i++) {// initial 16 tites with their value=0
            myTiles[i] = new Tile();
        }
        addTile();// add 2 tiles at the begin in random position on board 
        addTile();
    }
  
      private void addTile() {
        List<Tile> list = checkSpace();//list of available space to add new title

        if (!checkSpace().isEmpty()) { // until all tiles on the board have value >0
            int pos = (int) (Math.random() * list.size()) + 0;
            Tile newTile = list.get(pos);
            if(Math.random() < 1){
                newTile.value =  2 ;
            }
            else
                newTile.value =  4 ;
        }
    }

    private List<Tile> checkSpace() {

        final List<Tile> list = new ArrayList<Tile>(16);// add in list if value=0

        for (int k=0;k< myTiles.length;k++) { 
            if (myTiles[k].isEmpty()) {
                list.add(myTiles[k]);
            }
        }
        return list;
    }
  
      boolean checkMove() {
        if (checkSpace().size() != 0) { //cannot move if no space left
            return true;
        }
        for (int x = 0; x < 4; x++) {// cannot move if no same value next to each others
            for (int y = 0; y < 4; y++) {
                Tile t = new Tile();
                 t=tileAt(x, y);
                if ((x < 3 && t.value == tileAt(x + 1, y).value)// check the tile next in hor 
                        || ((y < 3) && t.value == tileAt(x, y + 1).value)) { //and ver if the same value then can move
                    return true;
                }
            }
        }
        return false;
    }
    
      
    private Tile tileAt(int x, int y) {
        return myTiles[x + y * 4];
    }
    
     private Tile[] arrangeLine(Tile[] array) {// arrange to easy to merge
        LinkedList<Tile> l = new LinkedList<Tile>();
        //add the valued elems in list
        for (int i = 0; i < 4; i++) {
            if (!array[i].isEmpty()) {// in input array,if value of element=0 then not add into list
                l.addLast(array[i]);
            }
        }
        //check after adding
        if (l.size() == 0) {// all of 4 elems in a line are=0 then return input array of a line
            return array;
        } 
        else {// in list has some elems 
            Tile[] newLine = new Tile[4];//will store the list in new array
            ensureSize(l);// a line must have 4 elements(incase of 1,2,3 elems in list)
            for (int i = 0; i < 4; i++) {
                newLine[i] = l.removeFirst();//pop the list then stored in new array
            }
            return newLine; // return an arranged array
        }
    }

    private Tile[] mergeLine(Tile[] array) {// in a line, same value will be merged
        LinkedList<Tile> l = new LinkedList<Tile>();
        //check to merge 
        for (int i = 0; i <=3 && !array[i].isEmpty(); i++) { // no check if elems have valued =0
            int num = array[i].value;
            if (i <=2 && array[i].value == array[i + 1].value) {
                num *= 2;
                Score += num;
                i++; // no check the next cause it already merged with the previous
            }
            l.add(new Tile(num));// add to list affter merging
        }
        if (l.size() == 0) {//cannot merge
            return array;
        } else {// success in merging
            ensureSize(l);// add for enough 4 elems in list
            return l.toArray(new Tile[4]);// covert list to array
        }
    }

    private static void ensureSize(List<Tile> l) { //be sure a list in line must have 4 elems
        while (l.size() != 4) { // will add until enough 4 in linelist
            l.add(new Tile()); //elem has value is 0 when added
        }
    }
    
    
}