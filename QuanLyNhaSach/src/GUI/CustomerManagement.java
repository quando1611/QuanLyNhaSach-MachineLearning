/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.KhachHang;
import BUS.*;
import DAL.DBConnection;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.swing.JOptionPane;

/**
 *
 * @author 19522
 */
public class CustomerManagement extends javax.swing.JFrame {

    DBConnection connection;
    /**
     * Creates new form CustomerManagement
     */
    public CustomerManagement() {
        initComponents();
        loadAllCustomer();
    }
    //Load ALL CustomerList
    public void loadAllCustomer() // load Data from beginning
    {
        DefaultTableModel tableModel = (DefaultTableModel) SearchCustomerTable.getModel();
        ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
        KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
        arr = khachHang_BUS.getAllKhachHang();
        KhachHang khachHang = new KhachHang();
        try {
            for(int i = 0; i< arr.size(); i++)
            {
                khachHang = arr.get(i);
                String id = khachHang.getMaKH();
                String name = khachHang.getTenKH();
                String address = khachHang.getDiaChi();
                String SDT = khachHang.getDienThoai();
                String email = khachHang.getEmail();
                String sPDaMua = khachHang.getSoSPDaMua();
                Object[] row = {id, name, address, SDT, email, sPDaMua};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        SearchCustomerTable.setModel(tableModel);
    }
    
    public void reset() // reset the Jtable to null
    {
        DefaultTableModel tableModel = (DefaultTableModel) SearchCustomerTable.getModel();
        tableModel.setRowCount(0);
        SearchCustomerTable.setModel(tableModel);
    }
    
    public void resetText() // reset textfield after event done!
    {
        
    }
    
    public String randomID() // get random to generate ID for all of things
    {
        LocalDateTime local = LocalDateTime.now();
        long milis = local.getNano();
        String id = Long.toString(milis);
        System.err.println(id);
        return id;
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CustomerTypeGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JLabel();
        ParentPanel = new javax.swing.JTabbedPane();
        SearchTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchCustomerTable = new javax.swing.JTable();
        SearchTxb = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        EditChangeBtn = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        NewChangeBtn = new javax.swing.JButton();
        AddTab = new javax.swing.JPanel();
        NameTxb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddressTxb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PhoneNumberTxb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EmailTxb = new javax.swing.JTextField();
        AddCustomerBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        UpdateCustomerBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ProductTxb = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ViewTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ViewTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(153, 153, 200));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CUSTOMER MANAGEMENT");

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

        SearchCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "PhoneNumber", "Email", "SoSPDaMua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SearchCustomerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchCustomerTable.setGridColor(new java.awt.Color(0, 0, 0));
        SearchCustomerTable.setShowGrid(true);
        jScrollPane1.setViewportView(SearchCustomerTable);
        SearchCustomerTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        SearchTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 590));

        SearchTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb.setText("Search here ...");
        SearchTxb.setToolTipText("Search Here....");
        SearchTab.add(SearchTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 115, 310, 42));

        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn.setToolTipText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        SearchTab.add(SearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1067, 170, -1, 52));

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setText("DELETE");
        SearchTab.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 470, 116, 51));

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
        SearchTab.add(EditChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 380, 116, 51));

        CustomerTypeGroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("All");
        SearchTab.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 9, -1, -1));

        CustomerTypeGroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("Familiar customers");
        jRadioButton2.setToolTipText("");
        SearchTab.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 43, -1, -1));

        CustomerTypeGroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton3.setText("Loyal customers");
        SearchTab.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(953, 77, -1, -1));

        NewChangeBtn.setBackground(new java.awt.Color(153, 255, 153));
        NewChangeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NewChangeBtn.setText("NEW");
        NewChangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewChangeBtnMouseClicked(evt);
            }
        });
        NewChangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewChangeBtnActionPerformed(evt);
            }
        });
        SearchTab.add(NewChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 290, 116, 51));

        ParentPanel.addTab("Search Customer", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), SearchTab); // NOI18N

        AddTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameTxb.setToolTipText("");
        AddTab.add(NameTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 431, 52));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Name :");
        AddTab.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Address :");
        AddTab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        AddressTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddressTxb.setToolTipText("");
        AddTab.add(AddressTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 544, 52));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Phonenumber :");
        AddTab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        PhoneNumberTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhoneNumberTxb.setToolTipText("");
        AddTab.add(PhoneNumberTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 259, 52));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Email :");
        AddTab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        EmailTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EmailTxb.setToolTipText("");
        AddTab.add(EmailTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 370, 52));

        AddCustomerBtn.setBackground(new java.awt.Color(153, 255, 153));
        AddCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddCustomerBtn.setText("ADD CUSTOMER");
        AddCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerBtnActionPerformed(evt);
            }
        });
        AddTab.add(AddCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 244, 51));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/istockphoto-1223671392-612x612-1.jpg"))); // NOI18N
        AddTab.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 99, -1, -1));

        UpdateCustomerBtn.setBackground(new java.awt.Color(255, 204, 204));
        UpdateCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpdateCustomerBtn.setText("UPDATE CUSTOMER");
        UpdateCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCustomerBtnActionPerformed(evt);
            }
        });
        AddTab.add(UpdateCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 244, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Products have bought :");
        AddTab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        ProductTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProductTxb.setToolTipText("");
        AddTab.add(ProductTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 110, 52));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        AddTab.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 15, 3, 490));

        ParentPanel.addTab("Add Customer", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), AddTab); // NOI18N

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ViewTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ViewTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ViewTable.setCellSelectionEnabled(true);
        ViewTable.setGridColor(new java.awt.Color(0, 0, 0));
        ViewTable.setShowGrid(true);
        jScrollPane2.setViewportView(ViewTable);

        javax.swing.GroupLayout ViewTabLayout = new javax.swing.GroupLayout(ViewTab);
        ViewTab.setLayout(ViewTabLayout);
        ViewTabLayout.setHorizontalGroup(
            ViewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewTabLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        ViewTabLayout.setVerticalGroup(
            ViewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        ParentPanel.addTab("View Customer", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_eye_35px.png")), ViewTab); // NOI18N

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //New Customer
    private void EditChangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditChangeBtnMouseClicked
        
        
    }//GEN-LAST:event_EditChangeBtnMouseClicked

    private void NewChangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewChangeBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NewChangeBtnMouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // Return to Home
        this.dispose(); 
    }//GEN-LAST:event_BackBtnMouseClicked

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // Search Customer
        reset(); //reset to null table
        String search = SearchTxb.getText();
        DefaultTableModel tableModel = (DefaultTableModel) SearchCustomerTable.getModel();
        ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
        KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
        arr = khachHang_BUS.seacrhKhachHang(search);
        KhachHang khachHang = new KhachHang();
        try {
            for(int i = 0; i< arr.size(); i++)
            {
                khachHang = arr.get(i);
                String id = khachHang.getMaKH();
                String name = khachHang.getTenKH();
                String address = khachHang.getDiaChi();
                String SDT = khachHang.getDienThoai();
                String email = khachHang.getEmail();
                String sPDaMua = khachHang.getSoSPDaMua();
                Object[] row = {id, name, address, SDT, email, sPDaMua};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("No thing!");
        }
        SearchCustomerTable.setModel(tableModel);
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void EditChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditChangeBtnActionPerformed
        // Move to Add Tab and set Textfield's text to update Customer
        ParentPanel.setSelectedIndex(1);
    }//GEN-LAST:event_EditChangeBtnActionPerformed

    private void NewChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewChangeBtnActionPerformed
        // Move to Add Tab, no thing to set
        ParentPanel.setSelectedIndex(1);
    }//GEN-LAST:event_NewChangeBtnActionPerformed

    private void AddCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerBtnActionPerformed
        // Add Customer
        KhachHang khachHang = new KhachHang();
        if(NameTxb.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill atleast the name of customer...");
        }
        else
        {
            khachHang.setMaKH("C" + randomID());
            khachHang.setTenKH(NameTxb.getText());
            khachHang.setDiaChi(AddressTxb.getText());
            khachHang.setDienThoai(PhoneNumberTxb.getText());
            khachHang.setEmail(EmailTxb.getText());
            khachHang.setSoSPDaMua(ProductTxb.getText());
        }
        KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
        khachHang_BUS.addKhachHang(khachHang);
        JOptionPane.showMessageDialog(this, "Add Customer success!");
        reset();
        loadAllCustomer();
        ParentPanel.setSelectedIndex(0);
    }//GEN-LAST:event_AddCustomerBtnActionPerformed

    private void UpdateCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCustomerBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateCustomerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomerBtn;
    private javax.swing.JPanel AddTab;
    private javax.swing.JTextField AddressTxb;
    private javax.swing.JLabel BackBtn;
    private javax.swing.ButtonGroup CustomerTypeGroup;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditChangeBtn;
    private javax.swing.JTextField EmailTxb;
    private javax.swing.JTextField NameTxb;
    private javax.swing.JButton NewChangeBtn;
    private javax.swing.JTabbedPane ParentPanel;
    private javax.swing.JTextField PhoneNumberTxb;
    private javax.swing.JTextField ProductTxb;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTable SearchCustomerTable;
    private javax.swing.JPanel SearchTab;
    private javax.swing.JTextField SearchTxb;
    private javax.swing.JButton UpdateCustomerBtn;
    private javax.swing.JPanel ViewTab;
    private javax.swing.JTable ViewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
