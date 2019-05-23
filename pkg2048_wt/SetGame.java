/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048_wt;

import java.awt.Color;
import java.awt.Image;
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
  
}