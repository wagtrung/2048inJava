/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048_wt;

/**
 *
 * @author WagTrung
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;


/**
 *
 * @author WagTrung
 */
public class Tile { 
      
    int value;

    public Tile() { // INITIAL contructor 0 
      this(0);
    }

    public Tile(int num) { //contructor with parameter
        
      value = num;
    }

    public boolean isEmpty() {
      return value == 0; 
    }

    public Color getForeground() { // color for a number of tile

if(value<16){
    return new Color(0x776e65); // dark gray on light background if 2,4,8
}
else{
    return  new Color(0xf9f6f2);//light gray
}
    }

    public Color getBackground() { //color for background of title  
      switch (value) {
          
        case 2:    return new Color(0xeee4da);
        case 4:    return new Color(0xede0c8);
        case 8:    return new Color(0xf2b179);
        case 16:   return new Color(0xf59563);
        case 32:   return new Color(0xf67c5f);
        case 64:   return new Color(0xf65e3b);
        case 128:  return new Color(0xedcf72);
        case 256:  return new Color(0xedcc61);
        case 512:  return new Color(0xedc850);
        case 1024: return new Color(0xedc53f);
        case 2048: return new Color(0xedc22e);
      }
      return new Color(0x252525);// blue color for the background of the other tiles
    }
  }
    

