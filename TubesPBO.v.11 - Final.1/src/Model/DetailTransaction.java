/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hanif salafi
 */
public class DetailTransaction {
    private String kodeTransaksi;
    private String id;
    private String idTransaksi;
    private int jumlah;
    private int total;

    public DetailTransaction(String kodeTransaksi, String id, String idTransaksi, int jumlah, int total) {
        this.kodeTransaksi = kodeTransaksi;
        this.id = id;
        this.idTransaksi = idTransaksi;
        this.jumlah = jumlah;
        this.total = total;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
