/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanif salafi
 */
public class Transaction {
    private List<Product> detailProduct = new ArrayList<>();
    private double totalPrice;
    private String idTransaksi;
    //inibaru
    private String nota;
    private String tanggal;
    private String Id_Pelanggan;

    private double Total_Bayar;
    private static int i = 0;

    public Transaction(String nota, String tanggal, String Id_Pelanggan, double Total_Bayar) {
        this.nota = nota;
        this.tanggal = tanggal;
        this.Id_Pelanggan = Id_Pelanggan;
        this.Total_Bayar = Total_Bayar;
    }

    
    public String getIdTransaksi() {
        i++;
        return idTransaksi+i;
    }
    
    public Transaction() {
        this.totalPrice =0;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getId_Pelanggan() {
        return Id_Pelanggan;
    }


    
    

    public void setId_Pelanggan(String Id_Pelanggan) {
        this.Id_Pelanggan = Id_Pelanggan;
    }

    public double getTotal_Bayar() {
        return Total_Bayar;
    }

    public void setTotal_Bayar(double Total_Bayar) {
        this.Total_Bayar = Total_Bayar;
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
     
    public Product getProduct(int x){
        return detailProduct.get(x);
    }

    public double getTotalPrice() {
        for(int i=0; i<detailProduct.size(); i++){
            totalPrice += getProduct(i).getPrice();
        }
        return totalPrice;
    } 
}
