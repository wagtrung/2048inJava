/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaaa;

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
    return new Color(0xffffff); // dark gray on light background if 2,4,8
}
else{
    return  new Color(0xf9f6f2);//light gray
}
    }

    public Color getBackground() { //color for background of title  
      switch (value) {
          
        case 2:    return new Color(255,255,0,100);// yellow
        case 4:    return new Color(255,153,0,100);
        case 8:    return new Color(255,153,0,200);
        case 16:   return new Color(255,0,0,100);
        case 32:   return new Color(255,0,255,100);
        case 64:   return new Color(153,0,255,100);
        case 128:  return new Color(0,0,255,100);
        case 256:  return new Color(0,255,255,100);
        case 512:  return new Color(0,105,255,100);
        case 1024: return new Color(0,105,255,200);
        case 2048: return new Color(0,105,255,250);//to green
      }
      return new Color(0,0,0,0);// blue color for the background of the other tiles
    }
  }
    

