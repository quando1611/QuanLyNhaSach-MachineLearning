/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author 19522
 */
public class ImportManagement extends javax.swing.JFrame {

    /**
     * Creates new form Storage
     */
    public ImportManagement() {
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
        SearchTxb = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        EditChangeBtn = new javax.swing.JButton();
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
        CreateBillTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SearchTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        DeleteBtn1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        DeleteBtn2 = new javax.swing.JButton();
        DeleteBtn3 = new javax.swing.JButton();
        PurchasedBillTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SearchTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        SearchTable3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        DeleteBtn4 = new javax.swing.JButton();
        DeleteBtn5 = new javax.swing.JButton();
        SearchTxb8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TypeCb1 = new javax.swing.JComboBox<>();
        SearchBtn1 = new javax.swing.JButton();
        ReturnTab = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ViewTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 200));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPORT MANAGEMENT");

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

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchTable.setModel(new javax.swing.table.DefaultTableModel(
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
        SearchTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchTable.setCellSelectionEnabled(true);
        SearchTable.setGridColor(new java.awt.Color(0, 0, 0));
        SearchTable.setShowGrid(true);
        jScrollPane1.setViewportView(SearchTable);

        SearchTxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb.setText("Search here ...");
        SearchTxb.setToolTipText("Search Here....");

        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png"))); // NOI18N
        SearchBtn.setToolTipText("Search");

        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setText("DELETE");

        EditChangeBtn.setBackground(new java.awt.Color(255, 204, 204));
        EditChangeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditChangeBtn.setText("EDIT");
        EditChangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditChangeBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SearchTabLayout = new javax.swing.GroupLayout(SearchTab);
        SearchTab.setLayout(SearchTabLayout);
        SearchTabLayout.setHorizontalGroup(
            SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchTabLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchTabLayout.createSequentialGroup()
                        .addComponent(SearchTxb)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchTabLayout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addGroup(SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchTabLayout.createSequentialGroup()
                                    .addComponent(SearchBtn)
                                    .addGap(132, 132, 132))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchTabLayout.createSequentialGroup()
                                    .addComponent(EditChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(103, 103, 103)))))))
        );
        SearchTabLayout.setVerticalGroup(
            SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchTabLayout.createSequentialGroup()
                        .addComponent(SearchTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(EditChangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)))
        );

        ParentPanel.addTab("Search Customer", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_search_35px.png")), SearchTab); // NOI18N

        SearchTxb1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Address :");

        SearchTxb2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Phonenumber :");

        SearchTxb3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Email :");

        SearchTxb4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxb4.setToolTipText("");

        AddCustomerBtn.setBackground(new java.awt.Color(255, 204, 204));
        AddCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddCustomerBtn.setText("ADD CUSTOMER");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/istockphoto-1223671392-612x612-1.jpg"))); // NOI18N

        javax.swing.GroupLayout AddTabLayout = new javax.swing.GroupLayout(AddTab);
        AddTab.setLayout(AddTabLayout);
        AddTabLayout.setHorizontalGroup(
            AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddTabLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55)
                                .addComponent(SearchTxb1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                                .addComponent(AddCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(361, 361, 361))))
                    .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                            .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(55, 55, 55)
                            .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SearchTxb2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SearchTxb3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(55, 55, 55)
                            .addComponent(SearchTxb4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(175, 175, 175))))
                .addGap(22, 22, 22))
        );
        AddTabLayout.setVerticalGroup(
            AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTabLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddTabLayout.createSequentialGroup()
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SearchTxb1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SearchTxb2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SearchTxb3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(AddTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SearchTxb4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addComponent(AddCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTabLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)))
                .addGap(68, 68, 68))
        );

        ParentPanel.addTab("Add Supplier", new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/Minisize/icons8_Plus_+_35px.png")), AddTab); // NOI18N

        CreateBillTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        CreateBillTab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 930, 280));

        jLabel12.setText("Bill ID");
        CreateBillTab.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jTextField1.setText("jTextField1");
        CreateBillTab.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 160, 30));

        jLabel13.setText("Date");
        CreateBillTab.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));
        CreateBillTab.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, 210, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CreateBillTab.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 180, 30));

        jLabel14.setText("Supplier ID");
        CreateBillTab.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        DeleteBtn1.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn1.setText("CANCEL");
        CreateBillTab.add(DeleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 116, 51));

        jTextField2.setText("jTextField1");
        CreateBillTab.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 210, 50));

        jLabel15.setText("Total");
        CreateBillTab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 30, 30));

        DeleteBtn2.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn2.setText("DELETE");
        CreateBillTab.add(DeleteBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 360, 116, 51));

        DeleteBtn3.setBackground(new java.awt.Color(255, 51, 102));
        DeleteBtn3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn3.setText("CONFIRM");
        CreateBillTab.add(DeleteBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 116, 51));

        ParentPanel.addTab("Create Bill", CreateBillTab);

        PurchasedBillTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        SearchTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchTable2.setCellSelectionEnabled(true);
        SearchTable2.setGridColor(new java.awt.Color(0, 0, 0));
        SearchTable2.setShowGrid(true);
        jScrollPane4.setViewportView(SearchTable2);

        PurchasedBillTab.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 930, 260));

        jScrollPane5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        SearchTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SearchTable3.setCellSelectionEnabled(true);
        SearchTable3.setGridColor(new java.awt.Color(0, 0, 0));
        SearchTable3.setShowGrid(true);
        jScrollPane5.setViewportView(SearchTable3);

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

        jScrollPane6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ViewTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        ViewTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ViewTable1.setCellSelectionEnabled(true);
        ViewTable1.setGridColor(new java.awt.Color(0, 0, 0));
        ViewTable1.setShowGrid(true);
        jScrollPane6.setViewportView(ViewTable1);

        javax.swing.GroupLayout ReturnTabLayout = new javax.swing.GroupLayout(ReturnTab);
        ReturnTab.setLayout(ReturnTabLayout);
        ReturnTabLayout.setHorizontalGroup(
            ReturnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReturnTabLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        ReturnTabLayout.setVerticalGroup(
            ReturnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

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
    private javax.swing.JButton AddCustomerBtn;
    private javax.swing.JPanel AddTab;
    private javax.swing.JLabel BackBtn;
    private javax.swing.JPanel CreateBillTab;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteBtn1;
    private javax.swing.JButton DeleteBtn2;
    private javax.swing.JButton DeleteBtn3;
    private javax.swing.JButton DeleteBtn4;
    private javax.swing.JButton DeleteBtn5;
    private javax.swing.JButton EditChangeBtn;
    private javax.swing.JTabbedPane ParentPanel;
    private javax.swing.JPanel PurchasedBillTab;
    private javax.swing.JPanel ReturnTab;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JPanel SearchTab;
    private javax.swing.JTable SearchTable;
    private javax.swing.JTable SearchTable1;
    private javax.swing.JTable SearchTable2;
    private javax.swing.JTable SearchTable3;
    private javax.swing.JTextField SearchTxb;
    private javax.swing.JTextField SearchTxb1;
    private javax.swing.JTextField SearchTxb2;
    private javax.swing.JTextField SearchTxb3;
    private javax.swing.JTextField SearchTxb4;
    private javax.swing.JTextField SearchTxb8;
    private javax.swing.JComboBox<String> TypeCb1;
    private javax.swing.JTable ViewTable1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
