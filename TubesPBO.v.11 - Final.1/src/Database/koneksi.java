/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import Model.DetailTransaction;
import Model.Member;
import Model.Product;
import Model.Transaction;
import Model.User;
import View.CustomerView;
import View.Login;
import View.ProductView;
import View.SignUp;
import View.TransactionView;
import com.mysql.jdbc.Driver;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author hanif salafi
 */
public class koneksi {
    private static Connection conn;
    private String server="jdbc:mysql://localhost/minimarket";
    private String dbUser ="root";
    private String dbPasswd="";
    Statement statement;
    Connection connection;
    private ResultSet rs;
    private PreparedStatement pst;
    private CustomerView CV;
    private ProductView PV;
    private TransactionView TV;
    private DefaultTableModel _tabel;
    
    public void connect(){
        try{
            connection = DriverManager.getConnection(server, dbUser, dbPasswd);
            statement =  connection.createStatement();
        }catch(SQLException ex){
            System.out.println("Tidak konek");
        }
    }
    
    public void tambahPelanggan(Member m){
        try {
            
            String sql = "INSERT INTO customer (Id_Pelanggan,Nama_Pelanggan,Jenis_Kelamin,Jumlah_Belanja) VALUES ("+
                    "'"+m.getId_Pelanggan()+"',"+
                    "'"+m.getName()+"',"+
                    "'"+m.getJenisKelamin()+"',"+
                    "'"+m.getJumBelanja()+"')";
            statement.execute(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Saved Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Name Already Exists");
        }
    }
   
    
    public void createAccount(User U){
        try {
            String sql = "INSERT INTO account (Username,Name,Password,Sec_Q,Answer) VALUES ("+
                    "'"+U.getUsername()+"',"+
                    "'"+U.getName()+"',"+
                    "'"+U.getPassword()+"',"+
                    "'"+U.getPertanyaanKeamanan()+"',"+
                    "'"+U.getJawaban()+"')";
            statement.execute(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            
            JOptionPane.showMessageDialog(null, "New Account Created");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public User getUser(String username,String password){
        User U = null;
        try{
            String query="SELECT * FROM account WHERE username= '"+username+"' "
                    +"AND password = '"+password+"'";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                U=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            return U;
        }catch(SQLException ex){
            System.out.println("Login Failed"+ex);
            return null;
        }
    }
    
    public User getUsername(String username) {
        User U = null;
        try{
            String query="SELECT * FROM account WHERE username= '"+username+"'";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                U=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            return U;
        }catch(SQLException ex){
            System.out.println("Process Failed"+ex);
            return null;
        }
    }


    public User getUserAnswer(String username, String answer) {
        User U = null;
        try{
            String query="SELECT * FROM account WHERE username= '"+username+"' "+"AND Answer = '"+answer+"'";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                U=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            return U;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Process Failed");
            return null;
        }
    }

    public void updateProduct(Product p) {
        try {
            String sql = "UPDATE barang SET Nama_Barang= '"+p.getName()+
                    "', Harga= '"+Integer.toString(p.getPrice())+
                    "', Stok= '"+Integer.toString(p.getStock())+
                    "' WHERE Id_Barang= '"+p.getId()+"'";
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Update Data Successfully");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Update Data Failed");
        }
    }

    public Member getPelanggan(String cari) {
        Member m = null;
        String sql = "SELECT * from customer where Nama_Pelanggan='"+cari+"'";
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                m = new Member(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)));
                
            } 
            
            return m;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Name not Found");
            return null;
        }
    }

    public void updateCustomer(Member m) {
        try {
            int jumlah = 0 ;
            String sql1 = "select count(nota) from customer natural join transaksi where id_pelanggan="+m.getId_Pelanggan()+"";
            statement.execute(sql1);
            rs = statement.executeQuery(sql1);
            while(rs.next()){
                jumlah = rs.getInt(1);
            }
            String sql2 = "UPDATE customer SET Nama_Pelanggan= '"+m.getName()+
                    "', Jenis_Kelamin= '"+m.getJenisKelamin()+
                    "', Jumlah_Belanja= '"+jumlah+
                    "' WHERE Id_Pelanggan= '"+m.getId_Pelanggan()+"'";
            statement.execute(sql2);
            JOptionPane.showMessageDialog(null, "Update Data Successfully");
        }catch(SQLException ex){
            System.out.println("Update Data Failed"+ex);
        }
    }

     public void LoadData(CustomerView view){
        String[] kolom = {"Id","Nama","Jenis Kelamin","Jumlah Belanja"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabel().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from customer order by Id_Pelanggan asc";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Id_Pelanggan = rs.getString(1);
                String Nama_Pelanggan = rs.getString(2);
                String Jenis_Kelamin = rs.getString(3);
                int Jumlah_Belanja = rs.getInt(4);
                Object[] data = {Id_Pelanggan,Nama_Pelanggan,Jenis_Kelamin,Jumlah_Belanja};
                _tabel.addRow(data);
            }
            view.getTabel().getColumnModel().getColumn(0).setPreferredWidth(30);
            view.getTabel().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabel().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabel().getColumnModel().getColumn(3).setPreferredWidth(30);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Failed");
        }
    }
    public void HapusTabel(){
        int row = _tabel.getRowCount();
        for (int i = 0;i < row;i++){
            _tabel.removeRow(0);
        }
    }

    public Member cariCustomer(String nama) {
        Member m = null;
        try{
            String query="SELECT * FROM customer WHERE Nama_Pelanggan= '"+nama+"'";
            rs = statement.executeQuery(query);
            while(rs.next()){
                m = new Member(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)));
            }
            return m;
        }catch(SQLException ex){
            System.out.println("Failed"+ex);
            return null;
        }
    }


    
    public void tambahNota(Transaction t) {
        
        try {
            //insert ke table transaksi
            String sql = "INSERT INTO transaksi (Nota,Tanggal,Id_Pelanggan,Total_Bayar) VALUES ("+
                    "'"+t.getNota()+"',"+
                    "'"+t.getTanggal()+"',"+
                    "'"+t.getId_Pelanggan()+"',"+
                    "'"+t.getTotal_Bayar()+"')";
            statement.execute(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Saved Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tambahProduk(Product p){
        try {
            
            String sql = "INSERT INTO barang (Id_Barang,Nama_Barang,Stok,Harga) VALUES ("+
                    "'"+p.getId()+"',"+
                    "'"+p.getName()+"',"+
                    "'"+p.getStock()+"',"+
                    "'"+p.getPrice()+"')";
            statement.execute(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Saved Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Product Already Exists");
        }
    }
    
    public Product getProduct(String cari) {
        Product p = null;
        String sql = "SELECT * from barang where Id_Barang='"+cari+"'";
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                p = new Product(rs.getString(1),rs.getString(2),rs.getInt(4),rs.getInt(3));   
            } 
            
            return p;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Id Product Not Found");
            return null;
        }
    }
    public void LoadDataP(ProductView view){
        String[] kolom = {"Id Barang","Nama Barang","Stok","Harga"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelProduct().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from barang order by Id_Barang asc";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Id_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                int Stok = rs.getInt(3);
                int Harga = rs.getInt(4);
                Object[] data = {Id_Barang,Nama_Barang,Stok,Harga};
                _tabel.addRow(data);
            }
            view.getTabelProduct().getColumnModel().getColumn(0).setPreferredWidth(30);
            view.getTabelProduct().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelProduct().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelProduct().getColumnModel().getColumn(3).setPreferredWidth(30);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Failed");
        }
    }
    
    public void LoadDataTabelTrans(TransactionView view){
        String[] kolom = {"Nama Barang","Harga","Jumlah","Total Harga"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelTrans().setModel(_tabel);
        try{
            HapusTabel();
            String a = view.getTnota().getText();
            String sql = "Select Nama_Barang, Harga, Jumlah, Total_Harga from customer natural join transaksi natural join detiltransaksi natural join barang where Nota='"+a+"'" ;
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Nama_Barang = rs.getString(1);
                String Harga = rs.getString(2);
                String Jumlah = rs.getString(3);
                String Total_Harga = rs.getString(4);
                Object[] data = {Nama_Barang,Harga,Jumlah,Total_Harga};
                _tabel.addRow(data);
            }
            view.getTabelTrans().getColumnModel().getColumn(0).setPreferredWidth(50);
            view.getTabelTrans().getColumnModel().getColumn(1).setPreferredWidth(50);
            view.getTabelTrans().getColumnModel().getColumn(2).setPreferredWidth(50);
            view.getTabelTrans().getColumnModel().getColumn(3).setPreferredWidth(50);
            int jumlahBaris = view.getTabelTrans().getRowCount();
            int TotalBayar = 0;
            int TotalHarga;
        
            TableModel tabelModel;
            tabelModel =  view.getTabelTrans().getModel();
        
            for (int i=0; i<jumlahBaris;i++){
                TotalHarga = Integer.parseInt(tabelModel.getValueAt(i, 3).toString());
                TotalBayar += TotalHarga;
            }
            view.getTbayar().setText(String.valueOf(TotalBayar));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
}

    public void tambahDetailTransaction(DetailTransaction dt) {
        try{
            String sql1 = "INSERT INTO detiltransaksi (KodeTransaksi,Id_Barang,Nota,Jumlah,Total_Harga) VALUES ("+
                    "'"+dt.getKodeTransaksi()+"',"+
                    "'"+dt.getId()+"',"+
                    "'"+dt.getIdTransaksi()+"',"+
                    "'"+dt.getJumlah()+"',"+
                    "'"+dt.getTotal()+"')";
            statement.execute(sql1,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();  
            JOptionPane.showMessageDialog(null, "Data Saved Successfully");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Saved Failed");
        }
    }

    public void updateNotaa(int total, String nota, String nama, String date) {
       try {
            String sql = "UPDATE transaksi set Total_Bayar= "+total+" where Nota= '"+nota+"'";
            statement.execute(sql);
            String x="";
            x = x+  "Terimakasih Telah Berbelanja di Toko Kami ^_^";
            x = x+"\n";
            x = x+"\n  No. Nota       : "+nota;
            x = x+"\n  Tanggal        : "+date;
            x = x+"\n  Nama Pelanggan : "+nama;
            x = x+"\n---------------------------------------------";
            x = x+"\n  Total Belanja  : "+total;   
            JOptionPane.showMessageDialog(null, x);
            HapusTabel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    
    
    public void LoadDataTransaksi(TransactionView view){
        String[] kolom = {"No. Nota","Tanggal","Nama Pelanggan","Total Bayar" };
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabel().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT DISTINCT Nota,Tanggal,Nama_Pelanggan,Total_Bayar from customer natural join transaksi natural join detiltransaksi natural join barang order by Tanggal desc";
            
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Nota = rs.getString(1);
                Date Tanggal = rs.getDate(2);
                String Nama_Pelanggan = rs.getString(3);
                String Total_Bayar = rs.getString(4);
                Object[] data = {Nota,Tanggal,Nama_Pelanggan,Total_Bayar};
                _tabel.addRow(data);
            }
            view.getTabel().getColumnModel().getColumn(0).setPreferredWidth(30);
            view.getTabel().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabel().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabel().getColumnModel().getColumn(3).setPreferredWidth(30);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }

    public String cekstok(DetailTransaction dt) {
        String a = null;
        try {
            int Stok = 0;
            String sql = "SELECT * from barang where Id_Barang='"+dt.getId()+"'";        
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Id_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                Stok = rs.getInt(3);
                int Harga = rs.getInt(4);
            }
            int stokb = dt.getJumlah();
            if (Stok < stokb) {
                a = "Kosong";
            } else {
                a = "Ada";
            }        
        } catch (Exception e){
            a = null;
        }
        return a;
        
        
    }

    public void updateStok(TransactionView view) {
        view.getTabelTrans().getModel();
        try {

        } catch (Exception e){
            
        }
    }

    public int ambilStok(DetailTransaction dt) {
        int a = 0;
        try {
            int Stok = 0;
            String sql = "SELECT * from barang where Id_Barang='"+dt.getId()+"'";        
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Id_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                Stok = rs.getInt(3);
                int Harga = rs.getInt(4);
            }
            a = Stok;    
        } catch (Exception e){
            a = 0;
        }
        return a;
    }

    public void updateStok(String id, String nama, int stokAmbil, String harga) {
        try {
            int Stok =0;
            String sql = "SELECT * from barang where Id_Barang='"+id+"'";  
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String Id_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                Stok = rs.getInt(3);
                int Harga = rs.getInt(4);
            }
            int stokL = Stok;
            int stokUpdate = stokL - stokAmbil;        
            String query = "UPDATE barang set Stok= "+stokUpdate+" where Id_Barang= '"+id+"'";
            statement.execute(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Saved Successfully");
        }
    }

    public void deleteProduct(Product p) {
      try {
            String sql = "DELETE from BARANG WHERE Id_Barang= '"+p.getId()+"'";
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Delete Data Successfully");
     } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Delete Data Failed");
        }
    }

  
    
    

}