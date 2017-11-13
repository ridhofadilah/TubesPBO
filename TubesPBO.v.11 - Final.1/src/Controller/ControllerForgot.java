/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.koneksi;
import Model.Main;
import Model.User;
import View.Forgot;
import View.Login;
import View.SignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hanif salafi
 */
public class ControllerForgot implements ActionListener {
     private Main model;
     private Forgot view;
    private koneksi data = new koneksi();
    private Connection conn;
    private PreparedStatement pst;
    private Statement statement;

    ControllerForgot(Main model) {
        this.model=model;
        view= new Forgot();
        data.connect();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object source=ae.getSource();
        if (source.equals(view.getBtnSearch())){
            if(view.getTuser().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill data field first");
            }
            else{
                String username=view.getTuser().getText();
                if(model.cariUsername(username)!=null){
                    User U=model.cariUsername(username);
                    view.setTnama(U.getName());
                    view.setTquestion(U.getPertanyaanKeamanan());
                }else{
                    JOptionPane.showMessageDialog(null, "Username Not Found");
                }
            }
        } else if(source.equals(view.getBtnRetrieve())){
            if(view.getTuser().getText().equals("")||view.getTanswer().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill data field first");
            }
            else{
                String username=view.getTuser().getText();
                String answer = view.getTanswer().getText();
                if(model.cariUserAnswer(username,answer)!=null){
                    User U=model.cariUserAnswer(username,answer);
                    view.setTpass(U.getPassword());
                }else{
                    JOptionPane.showMessageDialog(null, "Your answer is wrong");
                }
            }
        }
        else if (source.equals(view.getBtnBack())){
            new ControllerLogin(model);
            view.dispose();
        }
    }
     
}
