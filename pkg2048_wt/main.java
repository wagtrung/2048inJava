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
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author WagTrung
 */
public class main extends JFrame {

    public static void main(String[] args) {
        JFrame game = new JFrame("Game 2048 | WagTrung");

        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// add close on top right

        game.setSize(855, 600); //w|h
        game.setResizable(false);// can be zoom out

        game.add(new SetGame());

        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

}
