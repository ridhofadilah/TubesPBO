/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.Main;
import Model.Member;
import Model.User;
import View.CustomerView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author hanif salafi
 */
public class ControllerCustomerView implements ActionListener{
    private Main model;
    private CustomerView view;
    private koneksi data = new koneksi();
    private Member m;
    
    ControllerCustomerView(Main model) {
            this.model=model;
            data.connect();
            view= new CustomerView();
            view.setVisible(true);
            view.addListener(this);
            Random r = new Random();
            int randId = r.nextInt(999-111) + 111;
            view.setTid1(Integer.toString(randId));
            model.showTable(view);
            
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())){
            
            try {
                if(view.getTnama1().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All data must be filled");
                }else{
                    String nama = view.getTnama1().getText();
                    String id = view.getTid1().getText();
                    String JK = view.getRadioL().isSelected()?"Male":"Female";
                    Member m = new Member(id,nama,JK,0);
                    model.addPelanggan(m);
                    model.showTable(view);
                    view.setTnama1("");
                    Random r = new Random();
                    int randId = r.nextInt(999-111) + 111;
                    view.setTid1(Integer.toString(randId));
                    
                }   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if (source.equals(view.getBtnSearch())){
            if (view.getTcari().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill search field first");
            }
            else {
                String cari = view.getTcari().getText();
                if (model.cariPelanggan(cari)!=null){
                    Member m = model.cariPelanggan(cari);
                    view.setTid2(m.getId_Pelanggan());
                    view.setTnama2(m.getName());
                    view.setTjkel(m.getJenisKelamin());
                    view.setTjumlah(Integer.toString(m.getJumBelanja()));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Name Not Found");
                }
            }
        }
        else if (source.equals(view.getBtnSimpan())){
            m = new Member(view.getTid2().getText(),view.getTnama2().getText(),view.getTjkel().getText(),Integer.parseInt(view.getTjumlah().getText()));
            model.updatePelanggan(m);
            model.showTable(view);
            view.setTcari("");
            view.setTid2("");
            view.setTjkel("");
            view.setTjumlah("");
            view.setTnama2("");
            
        } 
        
        
        else if (source.equals(view.getBtnBack())){
            new ControllerHome(model);
            view.dispose();
        }
        else if (source.equals(view.getBtnBacklogin())){
            new ControllerLogin(model);
            view.dispose();
        }
        
       
    }
    
    
    
    
}
