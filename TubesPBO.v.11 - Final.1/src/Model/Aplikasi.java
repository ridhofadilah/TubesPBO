/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.ControllerLogin;
/**
 *
 * @author hanif salafi
 */
public class Aplikasi {
    public static void main(String[] args) {
        Main drv = new Main();
        new ControllerLogin(drv);
    }
   
}
