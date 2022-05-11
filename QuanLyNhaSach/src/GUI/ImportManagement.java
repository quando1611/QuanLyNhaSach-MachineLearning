/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.HoaDon_BUS;
import BUS.Sach_BUS;
import BUS.NhaCungCap_BUS;
import DTO.NhaCungCap;
import DAL.DBConnection;
import DTO.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 19522
 */
public class ImportManagement extends javax.swing.JFrame {
    
    DBConnection connection;
    private String valueMaSach;
    public String valueMaNCC;
    private double total = 0.0;
    private int maximum = 0;
    private ArrayList<Sach> selectarr = new ArrayList<Sach>();
    private boolean exist = false;
    private String BillID;
    private String supplierSelectedID = "";
    /**
     * Creates new form Storage
     */
    public ImportManagement() {
        initComponents();
        loadAllData();
    }
    
    public void loadAllData()
    {
        loadAllBook();
        loadAllSupplier();
        loadTypeCbData();
        loadAllBill();
        loadCurrentDate();
        loadReturnBill();
    }
    
    public void loadAllBook()
    {
        DefaultTableModel table = (DefaultTableModel) SearchBookTable.getModel();
        ArrayList<Sach> arr = new ArrayList<Sach>();
        Sach_BUS sach_BUS= new Sach_BUS();
        arr = sach_BUS.getAllSach();
        Sach sach = new Sach();
        try {
            for(int i=0; i< arr.size();i++)
            {
                sach = arr.get(i);
                String id = sach.getMaSach();
                String name = sach.getTenSach();
                String author = sach.getTenTG();
                String type = sach.getTenTheLoai();
                int amount = sach.getSoLuong();
                float price = sach.getGia();
                Object[] row = {id, name, author,type,amount,price};
                table.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("Not thing to show!");
        }
        SearchBookTable.setModel(table);
    }
    
    private void loadAllSupplier() {
        DefaultTableModel tableModel = (DefaultTableModel) SearchSupplierTable.getModel();
        ArrayList<NhaCungCap> arr = new ArrayList<NhaCungCap>();
        NhaCungCap_BUS nhacungcap_BUS = new NhaCungCap_BUS();
        arr = nhacungcap_BUS.getNhaCungCap();
        NhaCungCap nhacungcap = new NhaCungCap();
        try {
            for(int i = 0; i< arr.size(); i++)
            {
                nhacungcap = arr.get(i);
                String id = nhacungcap.getMaNhaCC();
                String name = nhacungcap.getTenNhaCC();
                Object[] row = {id, name};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        SearchSupplierTable.setModel(tableModel);
    }
    
    public void loadTypeCbData()
    {
        connection = new DBConnection();
        String query = "select TenTheLoai from Sach";
        try {
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while(rs.next())
            {
                String name = rs.getString("TenTheLoai");
                TypeCb.addItem(name);
            }
        } catch (Exception e) {
            System.err.println("Not thing to show!");
        }
    }
    
    public void resetData() // reset the Jtable to null
    {
        DefaultTableModel tableModel = (DefaultTableModel) SearchBookTable.getModel();
        tableModel.setRowCount(0);
        SearchBookTable.setModel(tableModel);
    }
    
    public void resetSupplier() // reset the Jtable to null
    {
        DefaultTableModel tableModel = (DefaultTableModel) SearchSupplierTable.getModel();
        tableModel.setRowCount(0);
        SearchSupplierTable.setModel(tableModel);
    }
    public void seacrhBookWithFilter()
    {
        resetData();
        String name = SupplySearchTxb.getText();
        String type = TypeCb.getSelectedItem().toString();
        if(type == "All")
        {
            type = "";
        }
        String author = AuthorSearchTxb.getText();
        DefaultTableModel table = (DefaultTableModel) SearchBookTable.getModel();
        ArrayList<Sach> arr = new ArrayList<Sach>();
        Sach_BUS sach_BUS = new Sach_BUS();
        arr = sach_BUS.searchSach(name, type, author);
        Sach sach = new Sach();
        try {
            for(int i=0; i< arr.size();i++)
            {
                sach = arr.get(i);
                String ma = sach.getMaSach();
                String ten = sach.getTenSach();
                String tacgia = sach.getTenTG();
                String loai = sach.getTenTheLoai();
                int soluong = sach.getSoLuong();
                double gia = sach.getGia();
                Object[] row = {ma, ten, tacgia, loai, soluong, gia};
                table.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        SearchBookTable.setModel(table);
    }
    
     public void resetCbData() //Reset Combobox Data
    {
        TypeCb.removeAllItems();
        TypeCb.addItem("All");
        SupplierID.removeAllItems();
        SupplierID.addItem("All");
    }
    
    public void resetText() // reset textfield after event done!
    {
        SearchText.setText("");
        NameTxb.setText("");
        AuthorSearchTxb.setText("");
        ImportBillText.setText("");
        TotalText.setText("");
        total = 0;
    }
    
    public void resetSelectTable() { //reset SelectBookTable to Null
        DefaultTableModel tableModel = (DefaultTableModel) SearchBookTable.getModel();
        tableModel.setRowCount(0);
        SearchBookTable.setModel(tableModel);
        exist = false;
    }
    
     public String randomID() // get random to generate ID for all of things
    {
        LocalDateTime local = LocalDateTime.now();
        long milis = local.getNano();
        String id = Long.toString(milis);
        System.err.println(id);
        return id;
    }
    
    public void SelectRow()
    {
        total = 0;
        DefaultTableModel choosetable = (DefaultTableModel) SearchBookTable.getModel();
        DefaultTableModel billtable = (DefaultTableModel) BillTable.getModel();     
        String id = choosetable.getValueAt(SearchBookTable.getSelectedRow(), 0).toString();
        String name = choosetable.getValueAt(SearchBookTable.getSelectedRow(), 1).toString();
        String author = choosetable.getValueAt(SearchBookTable.getSelectedRow(), 2).toString();
        String type = choosetable.getValueAt(SearchBookTable.getSelectedRow(), 3).toString();
        int amount = Integer.parseInt(AmountTxb.getText());   
        maximum = Integer.parseInt(choosetable.getValueAt(SearchBookTable.getSelectedRow(), 4).toString());
        Float price = Float.parseFloat(choosetable.getValueAt(SearchBookTable.getSelectedRow(), 5).toString());
        System.out.println(maximum);
        if (amount >= maximum)
        {
            JOptionPane.showMessageDialog(this, "Exceeding : numbers want to buy must < numbers left in storage!");
        }else
        {
            //insert in to SelectBookTable
            Sach sach = new Sach();
            sach.setMaSach(id);
            sach.setTenSach(name);
            sach.setTenTG(author);
            sach.setTenTheLoai(type);
            sach.setSoLuong(amount);
            sach.setGia(price);
            if (selectarr.size() > 0) {
                for (Sach existsach : selectarr) {
                    if (existsach.getMaSach().equals(id)) {
                        existsach.setSoLuong(existsach.getSoLuong() + amount);
                        exist = true;
                        break;
                    } else {
                        exist = false;
                    }
                }
                if (exist == false) {
                    selectarr.add(sach);
                }
            } else {
                selectarr.add(sach);
            }
            resetSelectTable();
            for (Sach sachFinal : selectarr) {
                String idFinal = sachFinal.getMaSach();
                String nameFinal = sachFinal.getTenSach();
                String authorFinal = sachFinal.getTenTG();
                String typeFinal = sachFinal.getTenTheLoai();
                int amountFinal = sachFinal.getSoLuong();
                double priceFinal = sachFinal.getGia();
                Object[] row = {idFinal, nameFinal, amountFinal};
                choosetable.addRow(row);
                total += amountFinal * priceFinal;
            }
            BillTable.setModel(billtable);
            TotalText.setText(Double.toString(total));
        
        }
    }
    

   public void resetBillTable() { //reset SelectBookTable to Null
        DefaultTableModel tableModel = (DefaultTableModel) BillTable.getModel();
        tableModel.setRowCount(0);
        BillTable.setModel(tableModel);
        exist = false;
    }
    
   public void resetBillTableAfterConfirm() { //reset SelectTable after confirm the bill
        DefaultTableModel tableModel = (DefaultTableModel) BillTable.getModel();
        tableModel.setRowCount(0);
        BillTable.setModel(tableModel);
        selectarr.clear();
        exist = false;
    }
   
   public String getSupplierID(String search)
   {
       connection = new DBConnection();
       String query = "select * from NhaCungCap where TenNCC ='" + search + "'";
       try{
           ResultSet rs = connection.ExcuteQueryGetTable(query);
           while(rs.next())
           {
               supplierSelectedID = rs.getString("MaNCC");
           }
       }catch(Exception e)
       {
           System.err.println("NoT thing to show");
       }
       return supplierSelectedID;
   }
   
  /* public String getStaffID(String search)
   {
       connection = new DBConnection();
       String query = "select"
   }*/


    public void SelectRowSupplier()
    {
        DefaultTableModel tableModel = (DefaultTableModel) SearchSupplierTable.getModel();
            //Get Data from Table
            valueMaNCC = tableModel.getValueAt(SearchSupplierTable.getSelectedRow(), 0).toString();
            String name = tableModel.getValueAt(SearchSupplierTable.getSelectedRow(), 1).toString();
            //Set TextField
            NameTxb.setText(name);
            NameTxb.enable(false);
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchSupplierTable = new javax.swing.JTable();
        SupplySearchTxb = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        EditChangeBtn = new javax.swing.JButton();
        SelectSupplierBtn1 = new javax.swing.JButton();
        AddTab = new javax.swing.JPanel();
        NameTxb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AddSupplierBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Search = new javax.swing.JPanel();
        SearchBtn2 = new javax.swing.JButton();
        PlusBtn = new javax.swing.JButton();
        SubtractBtn = new javax.swing.JButton();
        AllRadio = new javax.swing.JRadioButton();
        FilterRadio = new javax.swing.JRadioButton();
        SelectBookBtn = new javax.swing.JButton();
        AmountTxb = new javax.swing.JTextField();
        TypeCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AuthorSearchTxb = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SearchBookTable = new javax.swing.JTable();
        SearchText = new javax.swing.JTextField();
        CreateBillTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        ImportBillText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        DateBox = new com.toedter.calendar.JDateChooser();
        SupplierID = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        DeleteBtn1 = new javax.swing.JButton();
        TotalText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        IDBtn = new javax.swing.JButton();
        ConfirmBtn = new javax.swing.JButton();
        DeleteBtn6 = new javax.swing.JButton();
        PurchasedBillTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        BillDetailTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        ShowBillTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        DeleteBtn4 = new javax.swing.JButton();
        DeleteBtn5 = new javax.swing.JButton();
        SearchTxb8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TypeCb1 = new javax.swing.JComboBox<>();
        SearchBtn1 = new javax.swing.JButton();
        ReturnTab = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        BillReturnTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 200));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPORT MANAGEMENT");

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

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchSupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SearchSupplierTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchSupplierTable.setColumnSelectionAllowed(true);
        SearchSupplierTable.setGridColor(new java.awt.Color(0, 0, 0));
        SearchSupplierTable.setShowGrid(true);
        jScrollPane1.setViewportView(SearchSupplierTable);
        SearchSupplierTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        SearchTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 935, 590));

        SupplySearchTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SupplySearchTxb.setText("Search here ...");
        SupplySearchTxb.setToolTipText("Search Here....");
        SearchTab.add(SupplySearchTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 0, 310, 52));

        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn.setToolTipText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        SearchTab.add(SearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1076, 70, -1, 52));

        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setText("DELETE");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        SearchTab.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 116, 51));

        EditChangeBtn.setBackground(new java.awt.Color(255, 204, 204));
        EditChangeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditChangeBtn.setText("EDIT");
        EditChangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditChangeBtnMouseClicked(evt);
            }
        });
        EditChangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditChangeBtnActionPerformed(evt);
            }
        });
        SearchTab.add(EditChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 330, 116, 51));

        SelectSupplierBtn1.setBackground(new java.awt.Color(153, 255, 153));
        SelectSupplierBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SelectSupplierBtn1.setText("NEW");
        SelectSupplierBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectSupplierBtn1ActionPerformed(evt);
            }
        });
        SearchTab.add(SelectSupplierBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 230, 116, 51));

        ParentPanel.addTab("Search Supplier", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), SearchTab); // NOI18N

        NameTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameTxb.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Name :");

        AddSupplierBtn.setBackground(new java.awt.Color(255, 204, 204));
        AddSupplierBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddSupplierBtn.setText("ADD SUPPLIER");
        AddSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierBtnActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/istockphoto-1223671392-612x612-1.jpg"))); // NOI18N

        javax.swing.GroupLayout AddTabLayout = new javax.swing.GroupLayout(AddTab);
        AddTab.setLayout(AddTabLayout);
        AddTabLayout.setHorizontalGroup(
            AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddTabLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(NameTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                        .addComponent(AddSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286))))
        );
        AddTabLayout.setVerticalGroup(
            AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddTabLayout.createSequentialGroup()
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NameTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(131, 131, 131)
                        .addComponent(AddSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTabLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)))
                .addGap(241, 241, 241))
        );

        ParentPanel.addTab("Add Supplier", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), AddTab); // NOI18N

        Search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn2.setToolTipText("Search");
        SearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn2ActionPerformed(evt);
            }
        });
        Search.add(SearchBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, -1, 52));

        PlusBtn.setBackground(new java.awt.Color(153, 255, 153));
        PlusBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PlusBtn.setText("+");
        PlusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusBtnActionPerformed(evt);
            }
        });
        Search.add(PlusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, 60, 51));

        SubtractBtn.setBackground(new java.awt.Color(255, 204, 204));
        SubtractBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SubtractBtn.setText("-");
        SubtractBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtractBtnActionPerformed(evt);
            }
        });
        Search.add(SubtractBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 440, 60, 51));

        AllRadio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AllRadio.setSelected(true);
        AllRadio.setText("All");
        Search.add(AllRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 9, -1, -1));

        FilterRadio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FilterRadio.setText("Filter");
        FilterRadio.setToolTipText("");
        Search.add(FilterRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1216, 9, -1, -1));

        SelectBookBtn.setBackground(new java.awt.Color(153, 255, 153));
        SelectBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SelectBookBtn.setText("SELECT");
        SelectBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectBookBtnActionPerformed(evt);
            }
        });
        Search.add(SelectBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 530, 116, 51));

        AmountTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AmountTxb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountTxb.setText("0");
        AmountTxb.setToolTipText("Search Here....");
        Search.add(AmountTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 440, 70, 50));

        TypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        Search.add(TypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1055, 116, 200, 45));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Type");
        Search.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, 127, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Author");
        Search.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, 190, -1, -1));

        AuthorSearchTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AuthorSearchTxb.setToolTipText("Search Here....");
        Search.add(AuthorSearchTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, 210, 42));

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Author", "Type", "Amout", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SearchBookTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchBookTable.setGridColor(new java.awt.Color(0, 0, 0));
        SearchBookTable.setShowGrid(true);
        jScrollPane2.setViewportView(SearchBookTable);

        Search.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 930, 590));

        SearchText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchText.setText("Search name ...");
        SearchText.setToolTipText("Search Here....");
        Search.add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(942, 56, 310, 42));

        ParentPanel.addTab("Choose Book", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), Search); // NOI18N

        CreateBillTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Author", "Type", "Amout", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BillTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        BillTable.setCellSelectionEnabled(true);
        BillTable.setGridColor(new java.awt.Color(0, 0, 0));
        BillTable.setShowGrid(true);
        jScrollPane3.setViewportView(BillTable);

        CreateBillTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 930, 280));

        jLabel12.setText("Import Bill ID");
        CreateBillTab.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        CreateBillTab.add(ImportBillText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 160, 30));

        jLabel13.setText("Date");
        CreateBillTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));
        CreateBillTab.add(DateBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, 210, 30));

        SupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CreateBillTab.add(SupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 180, 30));

        jLabel14.setText("Supplier ID");
        CreateBillTab.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        DeleteBtn1.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn1.setText("CANCEL");
        CreateBillTab.add(DeleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 116, 51));

        TotalText.setText("0.0");
        CreateBillTab.add(TotalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 210, 50));

        jLabel15.setText("Total");
        CreateBillTab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 30, 30));

        IDBtn.setBackground(new java.awt.Color(153, 204, 255));
        IDBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IDBtn.setText("GENERATE ID");
        IDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBtnActionPerformed(evt);
            }
        });
        CreateBillTab.add(IDBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 140, 30));

        ConfirmBtn.setBackground(new java.awt.Color(255, 51, 102));
        ConfirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmBtn.setText("CONFIRM");
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });
        CreateBillTab.add(ConfirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 116, 51));

        DeleteBtn6.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn6.setText("DELETE");
        CreateBillTab.add(DeleteBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 350, 116, 51));

        ParentPanel.addTab("Create Bill", CreateBillTab);

        PurchasedBillTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BillDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Author", "Type", "Amout", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BillDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        BillDetailTable.setCellSelectionEnabled(true);
        BillDetailTable.setGridColor(new java.awt.Color(0, 0, 0));
        BillDetailTable.setShowGrid(true);
        jScrollPane4.setViewportView(BillDetailTable);

        PurchasedBillTab.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 930, 260));

        jScrollPane5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ShowBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Author", "Type", "Amout", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ShowBillTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ShowBillTable.setCellSelectionEnabled(true);
        ShowBillTable.setGridColor(new java.awt.Color(0, 0, 0));
        ShowBillTable.setShowGrid(true);
        jScrollPane5.setViewportView(ShowBillTable);

        PurchasedBillTab.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 280));

        jLabel9.setText("Detail");
        PurchasedBillTab.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        DeleteBtn4.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn4.setText("RETURN");
        PurchasedBillTab.add(DeleteBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 400, 116, 51));

        DeleteBtn5.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn5.setText("CANCEL");
        PurchasedBillTab.add(DeleteBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 510, 116, 51));

        SearchTxb8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb8.setText("Search name ...");
        SearchTxb8.setToolTipText("Search Here....");
        PurchasedBillTab.add(SearchTxb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 321, 42));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Supplier ID");
        PurchasedBillTab.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, -1, -1));

        TypeCb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PurchasedBillTab.add(TypeCb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, 182, 45));

        SearchBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn1.setToolTipText("Search");
        PurchasedBillTab.add(SearchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, -1, 52));

        ParentPanel.addTab("Purchased Bills", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), PurchasedBillTab); // NOI18N

        ReturnTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BillReturnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        BillReturnTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        BillReturnTable.setCellSelectionEnabled(true);
        BillReturnTable.setGridColor(new java.awt.Color(0, 0, 0));
        BillReturnTable.setShowGrid(true);
        jScrollPane6.setViewportView(BillReturnTable);

        ReturnTab.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 0, 878, 590));

        ParentPanel.addTab("Return Bills", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_eye_35px.png")), ReturnTab); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParentPanel)
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
    }// </editor-fold>//GEN-END:initComponents

    private void EditChangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditChangeBtnMouseClicked
        ParentPanel.setSelectedIndex(2);
    }//GEN-LAST:event_EditChangeBtnMouseClicked

    private void SearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn2ActionPerformed
        // Search btn in Search Book Tab
        
    }//GEN-LAST:event_SearchBtn2ActionPerformed

    private void PlusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusBtnActionPerformed
        // Plus Btn in SearchBook Tab
        int amount = Integer.parseInt(AmountTxb.getText());
        if (amount >= 0) {
            amount += 1;
        }
        AmountTxb.setText(Integer.toString(amount));
    }//GEN-LAST:event_PlusBtnActionPerformed

    private void SubtractBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtractBtnActionPerformed
        // Subtraction Btn in SeacrhBook Tab
        int amount = Integer.parseInt(AmountTxb.getText());
        if (amount == 0) {

        } else {
            amount -= 1;
        }
        AmountTxb.setText(Integer.toString(amount));
    }//GEN-LAST:event_SubtractBtnActionPerformed

    private void SelectBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectBookBtnActionPerformed
        // Select Button in SearchBook Tab
        
    }//GEN-LAST:event_SelectBookBtnActionPerformed

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked

        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void IDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBtnActionPerformed
        // TODO add your handling code here:
        BillID ="B" + randomID();
        ImportBillText.setText(BillID);
    }//GEN-LAST:event_IDBtnActionPerformed

    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
        // TODO add your handling code here:
        PhieuNhapKho nhap = new PhieuNhapKho();
        String date = ((JTextField) DateBox.getDateEditor().getUiComponent()).getText();
        System.err.println(date);
        if(ImportBillText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please generate bill ID by cliking the button 'GENERATE ID'");
        }
        else 
            nhap.setMaPhieuNhap(ImportBillText.getText());
            nhap.setMaNhaCC(getSupplierID(SupplierID.getSelectedItem().toString()));
            nhap.setNgayTaoPhieu(date);
            nhap.setNgayNhapKho(date);
            nhap.setTongTien(total);
            nhap.setMaTK(PublicClass.StaffID);
            
    }//GEN-LAST:event_ConfirmBtnActionPerformed

                                 

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // Search Supplier
        resetSupplier(); //reset to null table
        String search = SupplySearchTxb.getText();
        DefaultTableModel tableModel = (DefaultTableModel) SearchSupplierTable.getModel();
        ArrayList<NhaCungCap> arr = new ArrayList<NhaCungCap>();
        NhaCungCap_BUS nhacungcap_BUS = new NhaCungCap_BUS();
        arr = nhacungcap_BUS.seacrhNhaCungCap(search);
        NhaCungCap nhacungcap = new NhaCungCap();
        try {
            for(int i = 0; i< arr.size(); i++)
            {
                nhacungcap = arr.get(i);
                String id = nhacungcap.getMaNhaCC();
                String name = nhacungcap.getTenNhaCC();
                
                Object[] row = {id, name};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        SearchSupplierTable.setModel(tableModel);    }//GEN-LAST:event_SearchBtnActionPerformed

    private void EditChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditChangeBtnActionPerformed
        // Move to Add Tab and set Textfield's text to update Customer
        SelectRow();
        ParentPanel.setSelectedIndex(1);
    }//GEN-LAST:event_EditChangeBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void AddSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierBtnActionPerformed
        // Add Supplier
        NhaCungCap nhacungcap = new NhaCungCap();
        if(NameTxb.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill atleast the name of supplier...");
        }
        else
        {
            nhacungcap.setMaNhaCC("C" + randomID());
            nhacungcap.setTenNhaCC(NameTxb.getText());
            
        }
        NhaCungCap_BUS nhacungcap_BUS = new NhaCungCap_BUS();
        nhacungcap_BUS.addNhaCungCap(nhacungcap);
        JOptionPane.showMessageDialog(this, "Add Customer success!");
        resetSupplier();
        loadAllSupplier();
        ParentPanel.setSelectedIndex(0);
    }//GEN-LAST:event_AddSupplierBtnActionPerformed

    private void SelectSupplierBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectSupplierBtn1ActionPerformed
        // Move to Add Tab, no thing to set
        ParentPanel.setSelectedIndex(1);
    }//GEN-LAST:event_SelectSupplierBtn1ActionPerformed

    

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
            java.util.logging.Logger.getLogger(ImportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSupplierBtn;
    private javax.swing.JPanel AddTab;
    private javax.swing.JRadioButton AllRadio;
    private javax.swing.JTextField AmountTxb;
    private javax.swing.JTextField AuthorSearchTxb;
    private javax.swing.JLabel BackBtn;
    private javax.swing.JTable BillDetailTable;
    private javax.swing.JTable BillReturnTable;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JPanel CreateBillTab;
    private com.toedter.calendar.JDateChooser DateBox;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteBtn1;
    private javax.swing.JButton DeleteBtn4;
    private javax.swing.JButton DeleteBtn5;
    private javax.swing.JButton DeleteBtn6;
    private javax.swing.JButton EditChangeBtn;
    private javax.swing.JRadioButton FilterRadio;
    private javax.swing.JButton IDBtn;
    private javax.swing.JTextField ImportBillText;
    private javax.swing.JTextField NameTxb;
    private javax.swing.JTabbedPane ParentPanel;
    private javax.swing.JButton PlusBtn;
    private javax.swing.JPanel PurchasedBillTab;
    private javax.swing.JPanel ReturnTab;
    private javax.swing.JPanel Search;
    private javax.swing.JTable SearchBookTable;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JButton SearchBtn2;
    private javax.swing.JTable SearchSupplierTable;
    private javax.swing.JPanel SearchTab;
    private javax.swing.JTextField SearchText;
    private javax.swing.JTextField SearchTxb8;
    private javax.swing.JButton SelectBookBtn;
    private javax.swing.JButton SelectSupplierBtn1;
    private javax.swing.JTable ShowBillTable;
    private javax.swing.JButton SubtractBtn;
    private javax.swing.JComboBox<String> SupplierID;
    private javax.swing.JTextField SupplySearchTxb;
    private javax.swing.JTextField TotalText;
    private javax.swing.JComboBox<String> TypeCb;
    private javax.swing.JComboBox<String> TypeCb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables

    private void loadAllBill() {
        //Load All bill to  BillShowTable
        DefaultTableModel table = (DefaultTableModel) ShowBillTable.getModel();
        ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
        HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
        arr = hoaDon_BUS.danhSachHoaDon();
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
            ShowBillTable.setModel(table);
        }
    }

    private void loadCurrentDate() {
        //get the current day by default for JDateChooser - DatePicker
        Calendar today = Calendar.getInstance();
        DateBox.setCalendar(today);
    }

    private void loadReturnBill() {
        DefaultTableModel table = (DefaultTableModel) BillReturnTable.getModel();
        ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
        HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
        arr = hoaDon_BUS.danhSachHoaDonReturn();
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
            BillReturnTable.setModel(table);
        }
    }

    
}
