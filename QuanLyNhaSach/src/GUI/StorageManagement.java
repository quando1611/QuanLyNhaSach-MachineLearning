/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author 19522
 */
public class StorageManagement extends javax.swing.JFrame {

    /**
     * Creates new form StorageManagement
     */
    public StorageManagement() {
        initComponents();
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
        SearchTable = new javax.swing.JTable();
        SearchBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        EditChangeBtn = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        NewChangeBtn = new javax.swing.JButton();
        SearchTxb6 = new javax.swing.JTextField();
        AuthorCb = new javax.swing.JComboBox<>();
        TypeCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddTab = new javax.swing.JPanel();
        SearchTxb1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SearchTxb2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SearchTxb3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SearchTxb4 = new javax.swing.JTextField();
        AddCustomerBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        UpdateCustomerBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        ViewTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SearchTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 200));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STORAGE MANAGEMENT");

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_previous_70px.png"))); // NOI18N

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

        SearchTable.setModel(new javax.swing.table.DefaultTableModel(
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
        SearchTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchTable.setCellSelectionEnabled(true);
        SearchTable.setGridColor(new java.awt.Color(0, 0, 0));
        SearchTable.setShowGrid(true);
        jScrollPane1.setViewportView(SearchTable);
        SearchTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        SearchTab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1000, 490));

        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn.setToolTipText("Search");
        SearchTab.add(SearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 110, 50));

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setText("DELETE");
        SearchTab.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 520, 116, 51));

        EditChangeBtn.setBackground(new java.awt.Color(255, 204, 204));
        EditChangeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditChangeBtn.setText("EDIT");
        EditChangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditChangeBtnMouseClicked(evt);
            }
        });
        SearchTab.add(EditChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 440, 116, 51));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("All");
        SearchTab.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("Filter");
        jRadioButton2.setToolTipText("");
        SearchTab.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        NewChangeBtn.setBackground(new java.awt.Color(153, 255, 153));
        NewChangeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NewChangeBtn.setText("NEW");
        NewChangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewChangeBtnMouseClicked(evt);
            }
        });
        SearchTab.add(NewChangeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 360, 116, 51));

        SearchTxb6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb6.setText("Search name ...");
        SearchTxb6.setToolTipText("Search Here....");
        SearchTab.add(SearchTxb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 321, 42));

        AuthorCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchTab.add(AuthorCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 182, 42));

        TypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchTab.add(TypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 182, 42));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Type");
        SearchTab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Author");
        SearchTab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, -1, -1));

        ParentPanel.addTab("Search Book", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), SearchTab); // NOI18N

        AddTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchTxb1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb1.setToolTipText("");
        AddTab.add(SearchTxb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 431, 52));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Name :");
        AddTab.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Author(s) :");
        AddTab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        SearchTxb2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb2.setToolTipText("");
        AddTab.add(SearchTxb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 260, 52));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Amount :");
        AddTab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        SearchTxb3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb3.setToolTipText("");
        AddTab.add(SearchTxb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 259, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Price :");
        AddTab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        SearchTxb4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb4.setToolTipText("");
        AddTab.add(SearchTxb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 370, 50));

        AddCustomerBtn.setBackground(new java.awt.Color(153, 255, 153));
        AddCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddCustomerBtn.setText("ADD BOOK");
        AddTab.add(AddCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 471, 244, 51));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_open_book_250px.png"))); // NOI18N
        AddTab.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 99, -1, -1));

        UpdateCustomerBtn.setBackground(new java.awt.Color(255, 204, 204));
        UpdateCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpdateCustomerBtn.setText("UPDATE BOOK");
        AddTab.add(UpdateCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 471, 244, 51));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Type :");
        AddTab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddTab.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 200, 50));

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

        ParentPanel.addTab("Add Book", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), AddTab); // NOI18N

        ViewTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        SearchTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchTable1.setCellSelectionEnabled(true);
        SearchTable1.setGridColor(new java.awt.Color(0, 0, 0));
        SearchTable1.setShowGrid(true);
        jScrollPane3.setViewportView(SearchTable1);
        SearchTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        ViewTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 935, 590));

        ParentPanel.addTab("View Book", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_eye_35px.png")), ViewTab); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void EditChangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditChangeBtnMouseClicked
        ParentPanel.setSelectedIndex(2);
    }//GEN-LAST:event_EditChangeBtnMouseClicked

    private void NewChangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewChangeBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NewChangeBtnMouseClicked

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
            java.util.logging.Logger.getLogger(StorageManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StorageManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomerBtn;
    private javax.swing.JPanel AddTab;
    private javax.swing.JComboBox<String> AuthorCb;
    private javax.swing.JLabel BackBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditChangeBtn;
    private javax.swing.JButton NewChangeBtn;
    private javax.swing.JTabbedPane ParentPanel;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JPanel SearchTab;
    private javax.swing.JTable SearchTable;
    private javax.swing.JTable SearchTable1;
    private javax.swing.JTextField SearchTxb1;
    private javax.swing.JTextField SearchTxb2;
    private javax.swing.JTextField SearchTxb3;
    private javax.swing.JTextField SearchTxb4;
    private javax.swing.JTextField SearchTxb6;
    private javax.swing.JComboBox<String> TypeCb;
    private javax.swing.JButton UpdateCustomerBtn;
    private javax.swing.JPanel ViewTab;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
