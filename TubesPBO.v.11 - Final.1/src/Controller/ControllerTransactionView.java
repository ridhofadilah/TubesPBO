/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.koneksi;
import Model.DetailTransaction;
import Model.Main;
import Model.Member;
import Model.Product;
import Model.Transaction;
import View.ProductView;
import View.SignUp;
import View.TransactionView;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

/**
 *
 * @author hanif salafi
 */
public class ControllerTransactionView implements ActionListener {

    private Main model;
    private TransactionView view;
    private DetailTransaction dt;
    private Product p;
    private koneksi data = new koneksi();

    public ControllerTransactionView(Main model) {
        this.model = model;
        data.connect();
        view = new TransactionView();
        view.setVisible(true);
        view.addListener(this);
        Random r = new Random();
        int randId = r.nextInt(9999 - 001) + 001;
        view.setTnota(Integer.toString(randId));
        model.showTableT(view);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getCariPelanggan())) {
            if (view.getCariNama().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill The Name First");
            } else {
                String nama = view.getCariNama().getText();
                if (model.cariNama(nama) == null) {
                    JOptionPane.showMessageDialog(null, "The name has not been recorded");
                } else {
                    JOptionPane.showMessageDialog(null, "The name has been recorded");
                }
            }
        } else if (source.equals(view.getBtnTambahPelanggan())) {
            new ControllerCustomerView(model);
            view.dispose();
        } else if (source.equals(view.getBtnSimpan())) {
            if (view.getCariNama().getText().equals("") || (view.getTtanggal().getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Complete the data first");
            } else {
                String nama = view.getCariNama().getText();
                if (model.cariNama(nama) == null) {
                    JOptionPane.showMessageDialog(null, "Customer not found. Please register first !");
                } else {
                    Member m = model.cariPelanggan(nama);
                    String tanggal = view.getTtanggal().getText();
                    String nota = view.getTnota().getText();
                    String id = m.getId_Pelanggan();
                    Transaction t = new Transaction(nota, tanggal, id, 0);
                    model.addNota(t);
                }
            }
        } else if (source.equals(view.getBtnCari())) {
            if (view.getTid().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill Id First");
            } else {
                String id = view.getTid().getText();
                if (model.cariBarang(id) != null) {
                    Product p = model.cariBarang(id);
                    view.setTnama(p.getName());
                    view.setTharga(Integer.toString(p.getPrice()));
                } else {
                    JOptionPane.showMessageDialog(null, "Product not found");
                }
            }
        } else if (source.equals(view.getBtnTotal())) {
            String x = view.getComboJumlah().getSelectedItem().toString();
            int y = Integer.parseInt(x);
            int z = Integer.parseInt(view.getTharga().getText());
            int totalHarga = y * z;
            String a = "" + totalHarga;
            view.setTtotal(a);
        } else if (source.equals(view.getBtnTambah())) {
            if (view.getTid().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "silahkan isi data cari barang terlebih dahulu");
            } else {
                if (view.getTjumlah().getText().equals("0")) {
                    JOptionPane.showMessageDialog(null, "Silahkan tekan tombol tambah terlebih dahulu");
                } else {
                    String nota = view.getTnota().getText();
                    int jumlah = Integer.parseInt(view.getComboJumlah().getSelectedItem().toString());
                    Random r = new Random();
                    int kode = r.nextInt(9999 - 001) + 001;
                    String kodeTrans = Integer.toString(kode);
                    String idBarang = view.getTid().getText();
                    int totalHarga = Integer.parseInt(view.getTtotal().getText());
                    dt = new DetailTransaction(kodeTrans, idBarang, nota, jumlah, totalHarga);
                    if (model.cekstok(dt) == "Kosong") {
                        JOptionPane.showMessageDialog(null, "Stocks are low or empty");
                    } else {
                        model.addDetailTransaction(dt);
                        model.showTableR(view);
                        //int ambilStok = model.ambilStok(dt);
                        String id = view.getTid().getText();
                        String sa = view.getComboJumlah().getSelectedItem().toString();
                        int stokAmbil = Integer.parseInt(sa);
                        String nama = view.getTnama().getText();
                        String harga = view.getTharga().getText();
                        model.updateStok(id,nama,stokAmbil,harga);
                        view.setTtotal("0");
                        view.setTid("");
                        view.setTnama("");
                        view.setComboJumlah(1);
                        view.setTharga("");
                    }
                }
            }
        } else if (source.equals(view.getBtnBack())) {
            new ControllerHome(model);
            view.dispose();
        } else if (source.equals(view.getBtnBayar())) {
            if (view.getTbayar().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan isi data belanja terlebih dahulu");
            } else {
                String nota = view.getTnota().getText();
                int total = Integer.parseInt(view.getTbayar().getText());
                String nama = view.getCariNama().getText();
                String date = view.getTtanggal().getText();
                model.updateNota(total, nota, nama, date);    
                //update jumlah belanja
                if (model.cariNama(nama) != null) {
                    Member m = model.cariNama(nama);
                    model.updatePelanggan(m);
                }
                model.showTableT(view);
                Random r = new Random();
                int randId = r.nextInt(9999 - 001) + 001;
                view.setTnota(Integer.toString(randId));
                view.setTtanggal(null);
                view.setCariNama("");
                view.setTbayar("");
                
            }
        } else if (source.equals(view.getToLogin())) {
            new ControllerLogin(model);
            view.dispose();
        } else if (source.equals(view.getBtnToProduct())) {
            new ControllerProductView(model);
           // view.dispose();
        }
        
    }
}
