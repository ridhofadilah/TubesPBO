/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Database.koneksi;
import View.CustomerView;
import View.ProductView;
import View.TransactionView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ILM
 */
public class Main {
    private List<Product> detailProduct = new ArrayList<>();
    private List<Transaction> listTransaction = new ArrayList<>();
    private koneksi data;
    private Member member;
    private Transaction transaction;
    private Connection conn;
    
    public Main(){
        this.data = new koneksi();
        data.connect();
    }
    
    public void addTransaction(Transaction t){
        listTransaction.add(t);
    }
    
    public void addAccount(User U){
        data.createAccount(U);
    }
    
    public User login(String username,String password){
        User U=data.getUser(username, password);
        if(U!= null){
            return U; 
        }else{
            return null;
        }
    }
    
    public User cariUsername(String username) {
        User U = data.getUsername(username);
        if (U!=null){
            return U;
        }
        else {
            return null;
        }
    }
    
    public void addProduct(Product p, int stock){
        if (p.getStock() >= stock){
            for (int i = 0; i<stock ;i++) {
                detailProduct.add(p);
            }
            p.setStock(p.getStock()-stock);
        }
        else {
            System.out.println("Produk tidak mencukupi");
        }
    }

    public User cariUserAnswer(String username, String answer) {
        User U = data.getUserAnswer(username,answer);
        if (U!=null){
            return U;
        }
        else {
            return null;
        }}
    
    public void addPelanggan(Member m){
        data.tambahPelanggan(m);
    }
    
//    public String randomID(){
//        return Integer.toString(data.randomId());
//    }

    public Member cariPelanggan(String cari) {
        Member m = data.getPelanggan(cari);
        if (m!=null){
            
            return m;
        }
        else{
            
            return null;
        }
    }

    public void updatePelanggan(Member m) {
        data.updateCustomer(m);
    }

    public void showTable(CustomerView view) {
        data.LoadData(view);
    }

    public Member cariNama(String nama) {
       Member m = data.cariCustomer(nama);
       if (m!=null){
           return m;
       }
       else {
           return null;
       }
    }

     public void addProduct(Product p){
         data.tambahProduk(p);
    }
     
    public void addNota(Transaction t) {
        data.tambahNota(t);
    }
public Product cariBarang(String cari) {
        Product p = data.getProduct(cari);
        if (p!=null){     
            return p;
        }
        else{           
            return null;
        }
    }
    
    
    public void showTableP (ProductView view) {
        data.LoadDataP(view);
    }

    public void updateBarang(Product p) {
        data.updateProduct(p);
    }

    public void addDetailTransaction(DetailTransaction dt) {
        data.tambahDetailTransaction(dt);
    }

    public void showTableR(TransactionView view) {
        data.LoadDataTabelTrans(view);
    }

    public void updateNota(int total, String nota, String nama, String date) {
        data.updateNotaa(total,nota,nama,date);
    }

    public void showTableT(TransactionView view) {
        data.LoadDataTransaksi(view);
    }

    public String cekstok(DetailTransaction dt) {
       String d = data.cekstok(dt);
       if (d!=null){
           return d;
       }
       else {
           return null;
       }
    }




    public int ambilStok(DetailTransaction dt) {
       int p = data.ambilStok(dt);
       if (p!=0){
           return p;
       }
       else {
           return 0;
       }
    }


    public void updateStok(String id, String nama, int stokAmbil, String harga) {
        data.updateStok(id,nama,stokAmbil,harga);
    }

    public void deleteBarang(Product p) {
        data.deleteProduct(p);
    }

    

 
}
