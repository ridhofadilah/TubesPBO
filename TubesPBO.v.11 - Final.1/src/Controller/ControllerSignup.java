/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.Main;
import Model.User;
import View.SignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hanif salafi
 */
public class ControllerSignup implements ActionListener{

    private Main model;
    private SignUp view;
    private koneksi data = new koneksi();
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;
    
    ControllerSignup(Main model) {
        this.model = model;
        data.connect();
        view = new SignUp();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source=ae.getSource();
        if(source.equals(view.getBtnCreate())){
            try {
            if(view.getTnama().getText().equals("")||view.getTuser().getText().equals("")||view.getTpass().getText().equals("")||
                    view.getCquestion().getSelectedItem().toString().equals("")||view.getTanswer().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All data must be filled");
            }else{
                String nama = view.getTnama().getText();
                String username = view.getTuser().getText();
                String password = view.getTpass().getText();
                String pertanyaan = view.getCquestion().getSelectedItem().toString();
                String jawaban = view.getTanswer().getText();
                User U = new User(username,nama,password,pertanyaan,jawaban);
                model.addAccount(U);
                view.setTnama("");
                view.setTuser("");
                view.setTpass("");
                view.setTanswer("");
            }   
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            
        }
        else if (source.equals(view.getBtnBack())){
            view.setVisible(false);
            new ControllerLogin(model);
            view.dispose();
        }
    }
    
}
