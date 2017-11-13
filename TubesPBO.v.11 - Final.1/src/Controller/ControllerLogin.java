/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.Main;
import Model.User;
import View.Home;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hanif salafi
 */
public class ControllerLogin implements ActionListener{
    private Main model;
    private Login view;
    private koneksi data = new koneksi();
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public ControllerLogin(Main model){
            this.model=model;
            data.connect();
            view= new Login();
            view.setVisible(true);
            view.addListener(this);
        }
    @Override
        public void actionPerformed(ActionEvent e){
            Object source=e.getSource();
            if(source.equals(view.getBtnLogin())){
                if(view.getTname().getText().equals("")||view.getTpass().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All data must be field");
                }else{
                    String username=view.getTname().getText();
                    String password=view.getTpass().getText();
                    if(model.login(username,password)!=null){
                        new ControllerHome(model);
                        view.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Password/Username");
                    }
                    view.kosong("");
                }
            }else if(source.equals(view.getBtnSignUp())){
                view.setVisible(false);
                new ControllerSignup(model);
                view.dispose();
            }
            else if (source.equals(view.getBtnForgot())){
                view.setVisible(false);
                new ControllerForgot(model);
                view.dispose();
            }
        }
}
