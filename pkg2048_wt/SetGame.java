/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048_wt;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
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
  
  
}