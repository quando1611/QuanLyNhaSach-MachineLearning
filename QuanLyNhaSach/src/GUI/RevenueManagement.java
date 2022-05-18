/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import DAL.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 19522
 */
public class RevenueManagement extends javax.swing.JFrame {

    /**
     * Creates new form RevenueManagement
     */
    //Bill
    DBConnection connection;
    private String IDBill;
    private String CustomerID;
    private String dateString;
    private double totalBill;
    private double receive;
    //ImportBill
    private String IDimportBill;
    private String createDate;
    private String importDate;
    private String maTK;
    private String maNCC;
    private double totalImport;
    
    public RevenueManagement() {
        initComponents();
        loadCurrentDate();
    }
    
     public String getBookName(String id) {      //Get bookname by ID
        connection = new DBConnection();
        String name = "";
        String query = "select * from Sach where MaSach ='" + id + "'";
        try {
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next()) {
                name = rs.getString("TenSach");
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        return name;
    }

    public void reset()
    {
        resetBill();
        resetImportBill();
        resetText();
    }
    
    public void resetBill()
    {
        DefaultTableModel tableModel = (DefaultTableModel) BillShowTable.getModel();
        tableModel.setRowCount(0);
        BillShowTable.setModel(tableModel);
    }
    
    public void resetImportBill()
    {
        DefaultTableModel tableModel = (DefaultTableModel) ImportBillShowTable.getModel();
        tableModel.setRowCount(0);
        ImportBillShowTable.setModel(tableModel);
    }
    
    public void resetText()
    {
        
    }
    
    private void loadCurrentDate() {
        //get the current day by default for JDateChooser - DatePicker
        Calendar today = Calendar.getInstance();
        DateBox.setCalendar(today);
        DateImportBox.setCalendar(today);
    }
    
    public void loadAllBillInDay()
    {
        //Load All bill to  BillShowTable
        DefaultTableModel table = (DefaultTableModel) BillShowTable.getModel();
        String date = ((JTextField) DateBox.getDateEditor().getUiComponent()).getText();
        ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
        HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
        arr = hoaDon_BUS.danhSachHoaDonByDay(date);
        HoaDon hoaDon = new HoaDon();
        {
            try {
                for (int i = 0; i < arr.size(); i++) {
                    hoaDon = arr.get(i);
                    String id = hoaDon.getMaHoaDon();
                    String customerID = hoaDon.getMaKH();
                    String billDay = hoaDon.getNgayNhap();
                    Double billToTal = hoaDon.getTongTien();
                    Double billReceive = hoaDon.getTienTra();
                    String billStatus = hoaDon.getTinhTrang();
                    Object[] row = {id, customerID, billDay, billToTal, billReceive, billStatus};
                    table.addRow(row);
                }
            } catch (Exception e) {
                System.err.println("No thing!");
            }
            BillShowTable.setModel(table);
        }
    }
    
    public void loadAllImportBillInDay()
    {
        //Load All bill to  BillShowTable
        DefaultTableModel table = (DefaultTableModel) ImportBillShowTable.getModel();
        String date = ((JTextField) DateImportBox.getDateEditor().getUiComponent()).getText();
        ArrayList<PhieuNhapKho> arr = new ArrayList<PhieuNhapKho>();
        PhieuNhapKho_BUS phieuNhapKho_BUS = new PhieuNhapKho_BUS();
        arr = phieuNhapKho_BUS.danhsachPhieuNhapKhoByDate(date);
        PhieuNhapKho phieunhapkho = new PhieuNhapKho();
         try {
                for (int i = 0; i < arr.size(); i++) {
                    phieunhapkho = arr.get(i);
                    String id = phieunhapkho.getMaPhieuNhap();
                    String nhacungcap = phieunhapkho.getMaNhaCC();
                    String maTK = phieunhapkho.getMaTK();
                    String ngaynhapkho = phieunhapkho.getNgayNhapKho();
                    String ngaytaophieu = phieunhapkho.getNgayTaoPhieu();
                    double tongtien = phieunhapkho.getTongTien();     
                    Object[] row = {id, nhacungcap, maTK, ngaynhapkho, ngaytaophieu, tongtien };
                    table.addRow(row);
                }
            } catch (Exception e) {
                System.err.println("No thing!");
            }
            ImportBillShowTable.setModel(table);
    }
    
    public void selectBillRow()
    {
        DefaultTableModel selecttable = (DefaultTableModel) BillShowTable.getModel();
        IDBill = selecttable.getValueAt(BillShowTable.getSelectedRow(), 0).toString();
        CustomerID = selecttable.getValueAt(BillShowTable.getSelectedRow(), 1).toString();
        dateString = selecttable.getValueAt(BillShowTable.getSelectedRow(), 2).toString();
        totalBill = Double.parseDouble(selecttable.getValueAt(BillShowTable.getSelectedRow(), 3).toString());
        receive = Double.parseDouble(selecttable.getValueAt(BillShowTable.getSelectedRow(), 4).toString());
    }
    
    public void selectImportBillRow()
    {
        DefaultTableModel selecttable = (DefaultTableModel) ImportBillShowTable.getModel();
        IDimportBill = selecttable.getValueAt(BillShowTable.getSelectedRow(), 0).toString();
        createDate = selecttable.getValueAt(BillShowTable.getSelectedRow(), 1).toString();
        importDate = selecttable.getValueAt(BillShowTable.getSelectedRow(), 2).toString();
        maTK = selecttable.getValueAt(BillShowTable.getSelectedRow(), 3).toString();
        maNCC = selecttable.getValueAt(BillShowTable.getSelectedRow(), 4).toString();
        totalImport = Double.parseDouble(selecttable.getValueAt(BillShowTable.getSelectedRow(), 5).toString());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JLabel();
        ParentPanel = new javax.swing.JTabbedPane();
        SearchTab = new javax.swing.JPanel();
        SearchBtn = new javax.swing.JButton();
        DateBox = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        BillShowTable = new javax.swing.JTable();
        DeleteBtn = new javax.swing.JButton();
        PreviewBtn = new javax.swing.JButton();
        PrintBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PrintPreview = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        AddTab = new javax.swing.JPanel();
        DateImportBox = new com.toedter.calendar.JDateChooser();
        SearchBtn1 = new javax.swing.JButton();
        PreviewImportBtn = new javax.swing.JButton();
        PrintImportBtn = new javax.swing.JButton();
        DeleteBtn1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ImportPrintPreview = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        ImportBillShowTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        MonthlyRevenue = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ImportTotal = new javax.swing.JLabel();
        SaleTotal1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Revenue = new javax.swing.JLabel();
        ViewTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ViewTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(153, 153, 200));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REVENUE MANAGEMENT");

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_previous_70px.png"))); // NOI18N
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackBtn)
                .addGap(373, 373, 373)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ParentPanel.setBackground(new java.awt.Color(204, 204, 255));

        SearchTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn.setToolTipText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        SearchTab.add(SearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 60, 40));

        DateBox.setDateFormatString("yyyy-MM-dd");
        SearchTab.add(DateBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 40));

        jScrollPane5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BillShowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CustomerID", "Date", "Total", "Receive", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BillShowTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        BillShowTable.setGridColor(new java.awt.Color(0, 0, 0));
        BillShowTable.setShowGrid(true);
        BillShowTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillShowTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(BillShowTable);

        SearchTab.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 800, 430));

        DeleteBtn.setBackground(new java.awt.Color(153, 255, 153));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setText("DELETE");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        SearchTab.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 116, 51));

        PreviewBtn.setBackground(new java.awt.Color(153, 255, 153));
        PreviewBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PreviewBtn.setText("PREVIEW");
        PreviewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewBtnActionPerformed(evt);
            }
        });
        SearchTab.add(PreviewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 116, 51));

        PrintBtn.setBackground(new java.awt.Color(153, 255, 153));
        PrintBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrintBtn.setText("PRINT");
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });
        SearchTab.add(PrintBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 116, 51));

        PrintPreview.setColumns(20);
        PrintPreview.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrintPreview.setRows(5);
        jScrollPane1.setViewportView(PrintPreview);

        SearchTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 410, 500));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Preview Before Print");
        SearchTab.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        ParentPanel.addTab("Daily Turnover", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), SearchTab); // NOI18N

        AddTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DateImportBox.setDateFormatString("yyyy-MM-dd");
        AddTab.add(DateImportBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 40));

        SearchBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn1.setToolTipText("Search");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });
        AddTab.add(SearchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 60, 40));

        PreviewImportBtn.setBackground(new java.awt.Color(153, 255, 153));
        PreviewImportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PreviewImportBtn.setText("PREVIEW");
        PreviewImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewImportBtnActionPerformed(evt);
            }
        });
        AddTab.add(PreviewImportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 116, 51));

        PrintImportBtn.setBackground(new java.awt.Color(153, 255, 153));
        PrintImportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrintImportBtn.setText("PRINT");
        PrintImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintImportBtnActionPerformed(evt);
            }
        });
        AddTab.add(PrintImportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 116, 51));

        DeleteBtn1.setBackground(new java.awt.Color(153, 255, 153));
        DeleteBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn1.setText("DELETE");
        DeleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtn1ActionPerformed(evt);
            }
        });
        AddTab.add(DeleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 116, 51));

        ImportPrintPreview.setColumns(20);
        ImportPrintPreview.setRows(5);
        jScrollPane3.setViewportView(ImportPrintPreview);

        AddTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 410, 500));

        jScrollPane6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ImportBillShowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Import Date", "Create Date", "Staff ID", "Supplier ID", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ImportBillShowTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ImportBillShowTable.setGridColor(new java.awt.Color(0, 0, 0));
        ImportBillShowTable.setShowGrid(true);
        ImportBillShowTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportBillShowTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(ImportBillShowTable);

        AddTab.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 800, 430));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Preview Before Print");
        AddTab.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        ParentPanel.addTab("Import Report", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), AddTab); // NOI18N

        MonthlyRevenue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        MonthlyRevenue.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 630, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("REVENUE");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        MonthlyRevenue.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 520, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("IMPORT");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        MonthlyRevenue.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 520, 50));

        ImportTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ImportTotal.setForeground(new java.awt.Color(255, 102, 102));
        ImportTotal.setText("IMPORT");
        MonthlyRevenue.add(ImportTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        SaleTotal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleTotal1.setForeground(new java.awt.Color(0, 153, 0));
        SaleTotal1.setText("SALE");
        MonthlyRevenue.add(SaleTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 51));
        jLabel14.setText("SALE");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        MonthlyRevenue.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 520, 50));

        Revenue.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Revenue.setText("REVENUE");
        MonthlyRevenue.add(Revenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, -1));

        ParentPanel.addTab("Monthly Revenue", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_restart_35px.png")), MonthlyRevenue); // NOI18N

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "PhoneNumber", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ViewTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ViewTable.setGridColor(new java.awt.Color(0, 0, 0));
        ViewTable.setShowGrid(true);
        jScrollPane2.setViewportView(ViewTable);
        ViewTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout ViewTabLayout = new javax.swing.GroupLayout(ViewTab);
        ViewTab.setLayout(ViewTabLayout);
        ViewTabLayout.setHorizontalGroup(
            ViewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewTabLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        ViewTabLayout.setVerticalGroup(
            ViewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        ParentPanel.addTab("Staff KPI", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_eye_35px.png")), ViewTab); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ParentPanel)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ParentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BillShowTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillShowTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BillShowTableMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            selectBillRow();
            if(IDBill.equals(""))
            {
                System.out.println("Nothing to delete!");
            }
            else
            {
                ChiTietHoaDon_BUS chiTietHoaDon_BUS = new ChiTietHoaDon_BUS();
                chiTietHoaDon_BUS.deleteCHiTietHoaDon(IDBill);
                HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
                hoaDon_BUS.deleteHoaDon(IDBill);
                reset();
                loadAllBillInDay();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Row have selected!");
        }
        
       
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void PreviewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewBtnActionPerformed
        // TODO add your handling code here:
        
        try {
            selectBillRow();
            ArrayList<ChiTietHoaDon> arr = new ArrayList<ChiTietHoaDon>();
            ChiTietHoaDon_BUS chitiethoadon_BUS = new ChiTietHoaDon_BUS();
            arr = chitiethoadon_BUS.danhSachChiTietHoaDon(IDBill);
            ChiTietHoaDon chitiet = new ChiTietHoaDon();
            PrintPreview.setText("                                 BOOK-KEEPER STORE\n");
            PrintPreview.setText(PrintPreview.getText() + "                                __for a bright feature__  \n");
            PrintPreview.setText(PrintPreview.getText() + "-----------------------------------------------------------------\n");
            PrintPreview.setText(PrintPreview.getText() + "                                           -INVOICE-                                 \n");
            PrintPreview.setText(PrintPreview.getText() + "                                 Address : KTX Khu B \n");
            PrintPreview.setText(PrintPreview.getText() + "                                      - ĐHQG TPHCM\n");
            PrintPreview.setText(PrintPreview.getText() + "  Phone :     0345304407                   Web :  fb.com/12345    \n");
            PrintPreview.setText(PrintPreview.getText() + "-----------------------------------------------------------------\n");
            PrintPreview.setText(PrintPreview.getText() + "  InvoiceID :     " + IDBill + "         CustomerID :" + CustomerID + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                                   Date : " + dateString + "\n" );
            PrintPreview.setText(PrintPreview.getText() + "-----------------------------------------------------------------\n");
            for(int i = 0; i< arr.size();i++)
            {
                chitiet = arr.get(i);
                String bookID = chitiet.getMaSach();
                String bookName = getBookName(bookID);
                int amount = chitiet.getSoLuongMua();
                PrintPreview.setText(PrintPreview.getText() + "                      " + bookName + "      x " + amount + "\n");
            }
            PrintPreview.setText(PrintPreview.getText() + "                      ------------  ------------                " + "\n");
            PrintPreview.setText(PrintPreview.getText() + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                      Total :          " + totalBill + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                      ------------  ------------                " + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                      Receive :      " + receive + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                      ------------  ------------                " + "\n");
            PrintPreview.setText(PrintPreview.getText() + "                      Return   :      " + (receive - totalBill) + "\n");
            PrintPreview.setText(PrintPreview.getText() + "\n");
            PrintPreview.setText(PrintPreview.getText() + "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
            PrintPreview.setText(PrintPreview.getText() + "* *                      THANK YOU! COME AGAIN <3                * *\n");
            PrintPreview.setText(PrintPreview.getText() + "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Row have selected!");
        }
    }//GEN-LAST:event_PreviewBtnActionPerformed

    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        // TODO add your handling code here:
        try {
            PrintPreview.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Information!");
        }
    }//GEN-LAST:event_PrintBtnActionPerformed

    private void PreviewImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewImportBtnActionPerformed
        // TODO add your handling code here:
        try {
            selectImportBillRow();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Row have selected!");
        }
    }//GEN-LAST:event_PreviewImportBtnActionPerformed

    private void PrintImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintImportBtnActionPerformed
        // TODO add your handling code here:
        try {
            ImportPrintPreview.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No Information!");
        }
    }//GEN-LAST:event_PrintImportBtnActionPerformed

    private void DeleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtn1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DeleteBtn1ActionPerformed

    private void ImportBillShowTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportBillShowTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ImportBillShowTableMouseClicked

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
        // Search Import Bill By Date
        resetImportBill();
        loadAllImportBillInDay();
       
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // Search Bill By Date
        resetBill();
        loadAllBillInDay();
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RevenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevenueManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddTab;
    private javax.swing.JLabel BackBtn;
    private javax.swing.JTable BillShowTable;
    private com.toedter.calendar.JDateChooser DateBox;
    private com.toedter.calendar.JDateChooser DateImportBox;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteBtn1;
    private javax.swing.JTable ImportBillShowTable;
    private javax.swing.JTextArea ImportPrintPreview;
    private javax.swing.JLabel ImportTotal;
    private javax.swing.JPanel MonthlyRevenue;
    private javax.swing.JTabbedPane ParentPanel;
    private javax.swing.JButton PreviewBtn;
    private javax.swing.JButton PreviewImportBtn;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JButton PrintImportBtn;
    private javax.swing.JTextArea PrintPreview;
    private javax.swing.JLabel Revenue;
    private javax.swing.JLabel SaleTotal1;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JPanel SearchTab;
    private javax.swing.JPanel ViewTab;
    private javax.swing.JTable ViewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
