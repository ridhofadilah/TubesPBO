/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.koneksi;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ILM
 */
public class TransactionView extends javax.swing.JFrame {
    private Connection conn ;
    private ResultSet rs;
    private PreparedStatement pst;
     private DefaultTableModel _tabel;
     private ResultSet rxs;
     private koneksi data = new koneksi();
    /**
     * Creates new form InputBarang
     */
    public TransactionView() {
        super("Barang");
        initComponents();
        data.connect();
        //Random();
        //LoadData();

            
    }

    public void setTharga(String s) {
        this.Tharga.setText(s);
    }

    public void setTnama(String s) {
        this.Tnama.setText(s);
    }

    public void setTnota(String s) {
        this.Tnota.setText(s);
    }

  


//    public void Random() {
//        Random rd = new Random();
//        Tid1.setText(""+rd.nextInt(1000+1));
//        String sql = "select max(Nota) from transaksi";
//        try{
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            while (rs.next()){
//                int a = rs.getInt(1);
//                Tnota.setText(""+ Integer.toString(a+1));
//            }
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }

//    }
    
//     public String RandomKodeTransaksi() {
//            Random rd = new Random();
//            String x;
//            x = ""+rd.nextInt(1000+1);
//            return x;
//    }
     
    public void Kosong(){
        Tnota.setText(null);
        Ttanggal.setDate(null);
        //Random();
    }
    
    public void KosongtambahTrans(){
      //  Tnota.setText(null);
        Tid.setText(null);
        Tnama.setText(null);
        Tharga.setText(null);
        Ttotal.setText(null);
        ComboJumlah.setSelectedItem(null);
        //Random();
    }
    
    public void Kosong2(){
        Tcari.setText(null);
        Tid2.setText(null);
        Tjkel.setText(null);
        Tnama2.setText(null);
        
    }
    
    public void KosongSemua(){
        Tnota.setText(null);
        Ttanggal.setDate(null);
        cariNama.setText(null);
        Tid.setText(null);
        Tnama.setText(null);
        Tharga.setText(null);
        Ttotal.setText(null);
        ComboJumlah.setSelectedItem(null);
        Tbayar.setText(null);
        //Random();
    }
//    public void SearchPelanggan(){
//        String a = cariNama.getText();
//        String sql = "SELECT * from customer where Nama_Pelanggan='"+a+"'";
//        try {
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()){
//                JOptionPane.showMessageDialog(null, "Nama Sudah Terdata");
//                rs.close();
//                pst.close();
//            } else {
//                JOptionPane.showMessageDialog(null, "Nama Pelanggan Tidak Ditemukan");
//            } 
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//    }
    
//    public void SearchBarang(){
//        String a = Tid.getText();
//        String sql = "SELECT * from barang where Id_Barang='"+a+"'";
//        try {
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()){
//                Tnama.setText(rs.getString(2));
//                Tharga.setText(rs.getString(4));
//                rs.close();
//                pst.close();
//            } else {
//                JOptionPane.showMessageDialog(null, "Id Barang Tidak Ditemukan");
//            } 
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//    }
        
//    public void LoadDataTabelTrans(){
//        String[] kolom = {"Nama Barang","Harga","Jumlah","Total Harga"};
//        _tabel = new DefaultTableModel(null,kolom){
//            Class[] types = new Class [] {
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class
//            };
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//            // Agar table tidak bisa diedit
//            public boolean isCellEditable(int row, int col) {
//                int cola = _tabel.getColumnCount();
//                return (col < cola) ? false : true;
//            }
//        };
//        tabelTrans.setModel(_tabel);
//        try{
//            HapusTabel();
//            String a = Tnota.getText();
//            String sql = "Select Nama_Barang, Harga, Jumlah, Total_Harga from customer natural join transaksi natural join detiltransaksi natural join barang where Nota='"+a+"'" ;
//            Statement stat = conn.createStatement();
//            rs = stat.executeQuery(sql);
//            while(rs.next()){
//                String Nama_Barang = rs.getString(1);
//                String Harga = rs.getString(2);
//                String Jumlah = rs.getString(3);
//                String Total_Harga = rs.getString(4);
//                Object[] data = {Nama_Barang,Harga,Jumlah,Total_Harga};
//                _tabel.addRow(data);
//            }
//            tabelTrans.getColumnModel().getColumn(0).setPreferredWidth(50);
//            tabelTrans.getColumnModel().getColumn(1).setPreferredWidth(50);
//            tabelTrans.getColumnModel().getColumn(2).setPreferredWidth(50);
//            tabelTrans.getColumnModel().getColumn(3).setPreferredWidth(50);
//        } catch(Exception e) {
//            JOptionPane.showMessageDialog(this,"Error : " + e);
//        }
////}
//private void LoadDataTransaksi(){
//        String[] kolom = {"No. Nota","Tanggal","Nama Pelanggan","Total Bayar" };
//        _tabel = new DefaultTableModel(null,kolom){
//            Class[] types = new Class [] {
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class,
//               java.lang.String.class
//            };
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//            // Agar table tidak bisa diedit
//            public boolean isCellEditable(int row, int col) {
//                int cola = _tabel.getColumnCount();
//                return (col < cola) ? false : true;
//            }
//        };
//        tabel.setModel(_tabel);
//        try{
//            HapusTabel();
//            String sql = "SELECT DISTINCT Nota,Tanggal,Nama_Pelanggan,Total_Bayar from customer natural join transaksi natural join detiltransaksi natural join barang order by Id_Pelanggan asc";
//            Statement stat = conn.createStatement();
//            rs = stat.executeQuery(sql);
//            while(rs.next()){
//                String Nota = rs.getString(1);
//                Date Tanggal = rs.getDate(2);
//                String Nama_Pelanggan = rs.getString(3);
//                String Total_Bayar = rs.getString(4);
//                Object[] data = {Nota,Tanggal,Nama_Pelanggan,Total_Bayar};
//                _tabel.addRow(data);
//            }
//            tabel.getColumnModel().getColumn(0).setPreferredWidth(30);
//            tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
//            tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
//            tabel.getColumnModel().getColumn(3).setPreferredWidth(30);
//        } catch(Exception e) {
//            JOptionPane.showMessageDialog(this,"Error : " + e);
//        }
//    }
//    public void HapusTabel(){
//        int row = _tabel.getRowCount();
//        for (int i = 0;i < row;i++){
//            _tabel.removeRow(0);
//        }
//    }
//    
//    public void TotalBayar() {
////        int jumlahBaris = tabelTrans.getRowCount();
////        int TotalBayar = 0;
////        int TotalHarga;
////        
////        TableModel tabelModel;
////        tabelModel =  tabelTrans.getModel();
////        
////        for (int i=0; i<jumlahBaris;i++){
////            TotalHarga = Integer.parseInt(tabelModel.getValueAt(i, 3).toString());
////            TotalBayar = TotalBayar + TotalHarga;
////        }
////        Tbayar.setText(String.valueOf(TotalBayar));
//    }
//    
//    public void PrintOutput(){
//        String x="";
//        x = x+  "Terimakasih Telah Berbelanja di Toko Kami ^_^";
//        x = x+"\n";
//        x = x+"\n  No. Nota       : "+Tnota.getText();
//        x = x+"\n  Tanggal        : "+Ttanggal.getDate();
//        x = x+"\n  Nama Pelanggan : "+cariNama.getText();
//        x = x+"\n---------------------------------------------";
//        x = x+"\n  Total Belanja  : "+Tbayar.getText();   
//        JOptionPane.showMessageDialog(null, x);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tcari = new javax.swing.JTextField();
        Tjkel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Tid2 = new javax.swing.JTextField();
        bntSearch = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Tnama2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Tjumlah = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        trans = new javax.swing.JLabel();
        toLogin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnTambahPelanggan1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cariNama = new javax.swing.JTextField();
        btnSimpan1 = new javax.swing.JButton();
        Tnota = new javax.swing.JTextField();
        cariPelanggan1 = new javax.swing.JButton();
        Ttanggal = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        Tnama = new javax.swing.JTextField();
        ComboJumlah = new javax.swing.JComboBox<>();
        Ttotal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Tid = new javax.swing.JTextField();
        btnCari1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        btnTotal1 = new javax.swing.JButton();
        Tharga = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        btnTambah1 = new javax.swing.JButton();
        btnToProduct = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnBayar1 = new javax.swing.JButton();
        Tbayar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTrans = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("DAFTAR BELANJA");

        Tjkel.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cari Nama");

        jLabel11.setText("Id");

        Tid2.setEditable(false);
        Tid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tid2ActionPerformed(evt);
            }
        });

        bntSearch.setText("Search");
        bntSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSearchActionPerformed(evt);
            }
        });

        jLabel13.setText("Nama");

        Tnama2.setEditable(false);

        jLabel10.setText("Jumlah Belanja");

        Tjumlah.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tnama2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tid2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(Tjkel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(Tjumlah)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(Tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(bntSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel6)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(bntSearch))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Tid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tjkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tnama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(Tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel7.setBackground(new java.awt.Color(40, 48, 90));

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.png"))); // NOI18N
        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/home.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        trans.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        trans.setForeground(new java.awt.Color(255, 255, 255));
        trans.setText("Transaction");

        toLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        toLogin.setBorder(null);
        toLogin.setBorderPainted(false);
        toLogin.setContentAreaFilled(false);
        toLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(trans)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(trans)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setForeground(new java.awt.Color(70, 130, 180));
        jTabbedPane3.setFocusable(false);
        jTabbedPane3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setFocusable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnTambahPelanggan1.setBackground(new java.awt.Color(255, 255, 255));
        btnTambahPelanggan1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnTambahPelanggan1.setForeground(new java.awt.Color(70, 130, 180));
        btnTambahPelanggan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/signup.png"))); // NOI18N
        btnTambahPelanggan1.setContentAreaFilled(false);
        btnTambahPelanggan1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTambahPelanggan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPelanggan1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Customer not found? Register Here.");

        btnSimpan1.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnSimpan1.setForeground(new java.awt.Color(70, 130, 180));
        btnSimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnSimpan1.setText("Save Data");
        btnSimpan1.setContentAreaFilled(false);
        btnSimpan1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });

        Tnota.setEditable(false);
        Tnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnotaActionPerformed(evt);
            }
        });

        cariPelanggan1.setBackground(new java.awt.Color(255, 255, 255));
        cariPelanggan1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        cariPelanggan1.setForeground(new java.awt.Color(70, 130, 180));
        cariPelanggan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        cariPelanggan1.setContentAreaFilled(false);
        cariPelanggan1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cariPelanggan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPelanggan1ActionPerformed(evt);
            }
        });

        Ttanggal.setBackground(new java.awt.Color(255, 255, 255));
        Ttanggal.setDateFormatString("yyyy-MM-dd");
        Ttanggal.setFocusable(false);
        Ttanggal.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/barcode.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/name.png"))); // NOI18N
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel23.setText("Transaction");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/date.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel25.setText("Search Customer");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shop.png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Tnama.setEditable(false);

        ComboJumlah.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        ComboJumlah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        Ttotal.setEditable(false);
        Ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtotalActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel28.setText("Shopping");

        btnCari1.setBackground(new java.awt.Color(255, 255, 255));
        btnCari1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnCari1.setForeground(new java.awt.Color(70, 130, 180));
        btnCari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        btnCari1.setContentAreaFilled(false);
        btnCari1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari1ActionPerformed(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/barcode.png"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnTotal1.setBackground(new java.awt.Color(255, 255, 255));
        btnTotal1.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btnTotal1.setForeground(new java.awt.Color(70, 130, 180));
        btnTotal1.setText("Total Price");
        btnTotal1.setContentAreaFilled(false);
        btnTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotal1ActionPerformed(evt);
            }
        });

        Tharga.setEditable(false);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/price.png"))); // NOI18N
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnTambah1.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnTambah1.setForeground(new java.awt.Color(70, 130, 180));
        btnTambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnTambah1.setText("Add to Wishlist");
        btnTambah1.setContentAreaFilled(false);
        btnTambah1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah1ActionPerformed(evt);
            }
        });

        btnToProduct.setBackground(new java.awt.Color(255, 255, 255));
        btnToProduct.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnToProduct.setForeground(new java.awt.Color(70, 130, 180));
        btnToProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/namaProduk.png"))); // NOI18N
        btnToProduct.setContentAreaFilled(false);
        btnToProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnToProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnTambah1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnToProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tnama)
                            .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnTotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnToProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Tnota)
                                    .addComponent(Ttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTambahPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cariPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(111, 111, 111))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Tnota))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cariNama)
                            .addComponent(cariPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnTambahPelanggan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFocusable(false);

        btnBayar1.setBackground(new java.awt.Color(255, 255, 255));
        btnBayar1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnBayar1.setForeground(new java.awt.Color(70, 130, 180));
        btnBayar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/checkout.png"))); // NOI18N
        btnBayar1.setText("Check Out");
        btnBayar1.setContentAreaFilled(false);
        btnBayar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBayar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayar1ActionPerformed(evt);
            }
        });

        Tbayar.setEditable(false);
        Tbayar.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N

        tabelTrans.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        tabelTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Harga", "Jumlah", "Total Harga"
            }
        ));
        jScrollPane3.setViewportView(tabelTrans);

        jLabel33.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel33.setText("Wishlist");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tbayar)
                            .addComponent(btnBayar1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addComponent(jLabel33))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(Tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBayar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        jTabbedPane3.addTab("Add Transaction", new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png")), jPanel9); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFocusable(false);
        jPanel11.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jPanel11.setInheritsPopupMenu(true);

        tabel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Nota", "Tanggal", "Nama Pelanggan", "Total Bayar"
            }
        ));
        tabel.setFocusable(false);
        tabel.setGridColor(new java.awt.Color(255, 255, 255));
        tabel.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Transaction List", new javax.swing.ImageIcon(getClass().getResource("/Icon/list3.png")), jPanel11); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(901, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
//        setVisible(false);
//        Home ob=new Home();
//        ob.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void bntSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSearchActionPerformed
        // TODO add your handling code here:
       // Search();
    }//GEN-LAST:event_bntSearchActionPerformed

    private void Tid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tid2ActionPerformed

    private void TnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnotaActionPerformed

    private void btnBayar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBayar1ActionPerformed

    private void cariPelanggan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPelanggan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariPelanggan1ActionPerformed

    private void btnTambahPelanggan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPelanggan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahPelanggan1ActionPerformed

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpan1ActionPerformed

    private void btnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCari1ActionPerformed

    private void TtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtotalActionPerformed

    private void btnTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTotal1ActionPerformed

    private void btnTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambah1ActionPerformed

    private void toLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toLoginActionPerformed

    private void btnToProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnToProductActionPerformed

    /**
     * @param args the command line arguments
     */

    public Connection getConn() {
        return conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public JTable getTabel() {
        return tabel;
    }


    public ResultSet getRxs() {
        return rxs;
    }

    public void setTtotal(String s) {
        this.Ttotal.setText(s);
    }

    public JComboBox<String> getComboJumlah() {
        return ComboJumlah;
    }

//    public JLabel getHarga() {
//        return Harga;
//    }

    public JTextField getTbayar() {
        return Tbayar;
    }

    public JTextField getTcari() {
        return Tcari;
    }

    public JTextField getTharga() {
        return Tharga;
    }

    public JTextField getTid() {
        return Tid;
    }

    public JTextField getTid2() {
        return Tid2;
    }

    public JTextField getTjkel() {
        return Tjkel;
    }

    public JTextField getTjumlah() {
        return Tjumlah;
    }

    public JTextField getTnama() {
        return Tnama;
    }

    public JTextField getTnama2() {
        return Tnama2;
    }

    public JTextField getTnota() {
        return Tnota;
    }

    public JTextField getTtanggal() {
      return ((JTextField) Ttanggal.getDateEditor().getUiComponent());
     //return Ttanggal;
    }

    public JTextField getTtotal() {
        return Ttotal;
    }

    public JButton getBntSearch() {
        return bntSearch;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnBayar() {
        return btnBayar1;
    }

    public JButton getToLogin() {
        return toLogin;
    }
    
    

    public JButton getBtnCari() {
        return btnCari1;
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JButton getBtnSimpan() {
        return btnSimpan1;
    }
    
    public JButton getBtnTambah() {
        return btnTambah1;
    }

    public JButton getBtnTambahPelanggan() {
        return btnTambahPelanggan1;
    }

    public JButton getBtnTotal() {
        return btnTotal1;
    }

    public JTextField getCariNama() {
        return cariNama;
    }

    public JButton getCariPelanggan() {
        return cariPelanggan1;
    }

    public JTable getTabelTrans() {
        return tabelTrans;
    }

    public void setComboJumlah(int i) {
        this.ComboJumlah.setSelectedIndex(i);
    }

    public void setTid(String s) {
        this.Tid.setText(s);
    }

    public void setTnota(JTextField Tnota) {
        this.Tnota = Tnota;
    }

    public void setTtanggal(Date date) {
        this.Ttanggal.setDate(date);
    }

    public void setCariNama(String s) {
        this.cariNama.setText(s);
    }

    public void setTbayar(String s) {
        this.Tbayar.setText(s);
    }

    public JButton getBtnToProduct() {
        return btnToProduct;
    }

    
    
    
    
    
    public void addListener(ActionListener e){
        bntSearch.addActionListener(e);
        btnBack.addActionListener(e);
        btnBayar1.addActionListener(e);
        btnCari1.addActionListener(e);
        btnLogOut.addActionListener(e);
        btnSimpan1.addActionListener(e);
        btnTambah1.addActionListener(e);
        btnTambahPelanggan1.addActionListener(e);
        btnTotal1.addActionListener(e);
        cariPelanggan1.addActionListener(e);
        toLogin.addActionListener(e);
        btnToProduct.addActionListener(e);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJumlah;
    private javax.swing.JTextField Tbayar;
    private javax.swing.JTextField Tcari;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tid2;
    private javax.swing.JTextField Tjkel;
    private javax.swing.JTextField Tjumlah;
    private javax.swing.JTextField Tnama;
    private javax.swing.JTextField Tnama2;
    private javax.swing.JTextField Tnota;
    private com.toedter.calendar.JDateChooser Ttanggal;
    private javax.swing.JTextField Ttotal;
    private javax.swing.JButton bntSearch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBayar1;
    private javax.swing.JButton btnCari1;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JButton btnTambah1;
    private javax.swing.JButton btnTambahPelanggan1;
    private javax.swing.JButton btnToProduct;
    private javax.swing.JButton btnTotal1;
    private javax.swing.JTextField cariNama;
    private javax.swing.JButton cariPelanggan1;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabelTrans;
    private javax.swing.JButton toLogin;
    private javax.swing.JLabel trans;
    // End of variables declaration//GEN-END:variables
}
