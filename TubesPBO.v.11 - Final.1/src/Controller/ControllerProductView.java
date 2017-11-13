/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.Main;
import Model.Product;
import View.ProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author hanif salafi
 */
public class ControllerProductView implements ActionListener {
 private Main model;
    private ProductView view;
    private koneksi data = new koneksi();

    ControllerProductView(Main model) {
            this.model=model;
            data.connect();
            view = new ProductView();
            view.setVisible(true);
            view.addListener(this);
            Random r = new Random();
            int randId = r.nextInt(9999-1111)+1111;
            view.setTid2(Integer.toString(randId));
            model.showTableP(view);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd2())){
            Random r = new Random();
            int randId = r.nextInt(9999-1111)+1111;
            
            try {
                if(view.getTnama().getText().equals("") && view.getTharga().getText().equals("") 
                        && view.getTstok().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All data must be filled");
                }else{
                    String nama = view.getTnama().getText();
                    String id = view.getTid2().getText();
                    int stok = Integer.parseInt(view.getTstok().getText());
                    int harga = Integer.parseInt(view.getTharga().getText());
                    Product p = new Product(id, nama, harga, stok);
                    model.addProduct(p);
                    model.showTableP(view);
                    view.setTid2(Integer.toString(randId));
                    view.setTharga("");
                    view.setTnama("");
                    view.setTstok("");
 
                }   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Al data must be filled");
            }
        }  
        else if (source.equals(view.getBtnBackHome())){
            new ControllerHome(model);
            view.dispose();
        }
        else if (source.equals(view.getBtnSearch())){
            if (view.getTid1().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill search field first");
            }
            else {
                String cari = view.getTid1().getText();
                if (model.cariBarang(cari)!=null){
                    Product p = model.cariBarang(cari);
                    view.setTid1(p.getId());
                    view.setTnama1(p.getName());
                    view.setTstok1(Integer.toString(p.getStock()));
                    view.setTharga1(Integer.toString(p.getPrice()));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Id Product Not Found");
                }
            }
        }
        else if (source.equals(view.getBtnUpdate())){
            Product p = new Product(view.getTid1().getText(),view.getTnama1().getText(),Integer.parseInt(view.getTharga1().getText()),Integer.parseInt(view.getTstok1().getText()));
            model.updateBarang(p);
            model.showTableP(view); 
            view.setTid1("");
            view.setTharga1("");
            view.setTnama1("");
            view.setTstok1("");
        } 
        else if (source.equals(view.getBtnBack())){
            new ControllerLogin(model);
            view.dispose();
        } 
        else if (source.equals(view.getBtnDelete())){
            if (view.getTid1().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill Id Product First");
            }
            else{
                Product p = new Product(view.getTid1().getText(),view.getTnama1().getText(),Integer.parseInt(view.getTharga1().getText()),Integer.parseInt(view.getTstok1().getText()));
                model.deleteBarang(p);
                model.showTableP(view); 
                view.setTid1("");
                view.setTharga1("");
                view.setTnama1("");
                view.setTstok1(""); 
            }
        }
        
        
    }
    
}
