/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.Main;
import View.Home;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hanif salafi
 */
public class ControllerHome implements ActionListener{
    private Main model;
    private Home view;
    private koneksi data = new koneksi();
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;
    
    ControllerHome(Main model) {
            this.model=model;
            data.connect();
            view= new Home();
            view.setVisible(true);
            view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source.equals(view.getCustomer())){
            new ControllerCustomerView(model);
            view.dispose();
        }
        else if (source.equals(view.getProduct())){
            new ControllerProductView(model);
            view.dispose();
        }
        else if (source.equals(view.getTransaction())){
            new ControllerTransactionView(model);
            view.dispose();
        }
        else if (source.equals(view.getbtnBack())){
            new ControllerLogin(model);
            view.dispose();
        }
        
    }
    
}
