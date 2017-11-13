/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanif salafi
 */
public class Member{
    private List<Transaction> listTransaction = new ArrayList<>();
    private double sumTransaction;
    private String name;
    private String Id_Pelanggan;
    private String JenisKelamin;
    private int jumBelanja;

    public Member( String Id_Pelanggan, String name, String JenisKelamin, int jumBelanja) {
        this.name = name;
        this.Id_Pelanggan = Id_Pelanggan;
        this.JenisKelamin = JenisKelamin;
        this.jumBelanja = jumBelanja;
    }

    
    
    public Member() {
        
    }

    public String getId_Pelanggan() {
        return Id_Pelanggan;
    }

    public void setId_Pelanggan(String Id_Pelanggan) {
        this.Id_Pelanggan = Id_Pelanggan;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String JenisKelamin) {
        this.JenisKelamin = JenisKelamin;
    }

    public int getJumBelanja() {
        return jumBelanja;
    }

    public void setJumBelanja(int jumBelanja) {
        this.jumBelanja = jumBelanja;
    }
    

    public void addTransaction(Transaction t){
        listTransaction.add(t);
    }
    
    public Transaction getTransaction(int x){
        return listTransaction.get(x);
    }
    
    public double getSumTransaction() {
        for(int i=0; i<listTransaction.size();i++){
            sumTransaction += getTransaction(i).getTotalPrice();
        }
        return sumTransaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
