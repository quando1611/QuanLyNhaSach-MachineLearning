/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAL.*;
import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author 19522
 */
public class Login extends javax.swing.JFrame {

    DBConnection connection;
    public String role = "";
    /**
     * Creates new form Login
     */
    public Login() {
        connection = new DBConnection();
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        EmailTxb = new javax.swing.JTextField();
        PasswordTxb = new javax.swing.JPasswordField();
        Divider1 = new javax.swing.JPanel();
        Divider2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CloseBtn = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(null);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(213, 203, 231));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_book_250px.png"))); // NOI18N
        jLabel5.setText(" ");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 3, 36)); // NOI18N
        jLabel4.setText("BOOK-KEEPER");

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        jLabel1.setText("For a bright feature ...");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(144, 208, 231));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EmailTxb.setBackground(new java.awt.Color(144, 193, 223));
        EmailTxb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmailTxb.setForeground(new java.awt.Color(255, 255, 255));
        EmailTxb.setText("admin@gmail.com");
        EmailTxb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EmailTxb.setPreferredSize(new java.awt.Dimension(74, 26));
        jPanel5.add(EmailTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 281, 50));

        PasswordTxb.setBackground(new java.awt.Color(144, 193, 223));
        PasswordTxb.setForeground(new java.awt.Color(255, 255, 255));
        PasswordTxb.setText("admin");
        PasswordTxb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.add(PasswordTxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 281, 50));

        Divider1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Divider1Layout = new javax.swing.GroupLayout(Divider1);
        Divider1.setLayout(Divider1Layout);
        Divider1Layout.setHorizontalGroup(
            Divider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        Divider1Layout.setVerticalGroup(
            Divider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel5.add(Divider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 280, 3));

        Divider2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout Divider2Layout = new javax.swing.GroupLayout(Divider2);
        Divider2.setLayout(Divider2Layout);
        Divider2Layout.setHorizontalGroup(
            Divider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        Divider2Layout.setVerticalGroup(
            Divider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel5.add(Divider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 280, 3));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_user_35px_1.png"))); // NOI18N
        jLabel3.setText("  ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_unlock_35px.png"))); // NOI18N
        jLabel2.setText("  ");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 40, 40));

        CloseBtn.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        CloseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Component/icons8_multiply_35px.png"))); // NOI18N
        CloseBtn.setText(" ");
        CloseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseBtnMouseClicked(evt);
            }
        });
        jPanel5.add(CloseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 6, 35, 30));

        LoginBtn.setBackground(new java.awt.Color(204, 204, 255));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginBtn.setText("ENTER");
        LoginBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        LoginBtn.setBorderPainted(false);
        LoginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginBtn.setDoubleBuffered(true);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel5.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 100, 40));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LOGIN");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloseBtnMouseClicked

    //Login & Check Exist account
    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        String email = EmailTxb.getText().trim();
        String password = String.valueOf(PasswordTxb.getPassword()).trim();
        if(CheckLogin(email, password))
        {
            System.out.println(role);
            JOptionPane.showMessageDialog(this, "Login with ROLE : ADMIN!", "Successful",JOptionPane.OK_OPTION);
            Home home = new Home();
            home.setData(role);
            home.show();
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Login failed!!", "Fail",JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed
    private boolean CheckLogin(String email, String pass)
    {
        boolean result = false;
        String query = "select * from TaiKhoan where Email = '" + email + "' and MatKhau = '" + pass + "'";
        System.out.println(query);
        ResultSet rs = connection.ExcuteQueryGetTable(query);
        try{
            if (rs.next()) {
                result = true;
                role = rs.getString("MaPhanQuyen");
                PublicClass.StaffID = rs.getString("MaTK");
                
            }
        }catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }
        return result;
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseBtn;
    private javax.swing.JPanel Divider1;
    private javax.swing.JPanel Divider2;
    private javax.swing.JTextField EmailTxb;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordTxb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
