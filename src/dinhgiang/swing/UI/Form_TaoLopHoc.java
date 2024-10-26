/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dinhgiang.swing.UI;

import dinhgiang.model.ConnectDB;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dinhgiang1
 */
public class Form_TaoLopHoc extends javax.swing.JFrame {
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    String MALOP = "";
    String IMGPATH = "";
    int FLAG;  //0: Thôngtin 1: Sửa 
    /**
     * Creates new form Form_LopHoc_TaoLopHoc
     */
    public Form_TaoLopHoc() {
        initComponents();
        FLAGDEFAULT();
    }
    public Form_TaoLopHoc(int FLAG, String MALOP, String IMGPATH) {
        initComponents();
        this.FLAG = FLAG;
        this.MALOP = MALOP;
        this.IMGPATH = IMGPATH;
        
        if (FLAG == 0) {
            FLAG0();
            load_db0();
        }
        if (FLAG == 1) {
            FLAG1();
            load_db0();
            tfmalop.setEnabled(false);
        }
    }
    
    public void load_db0() {
        try {
            String IMGPATH1 = "";
            String TENLOP = "";
            conn = cn.gConnection();
            String query = "SELECT * FROM LOPHOC WHERE MALOP = '"+MALOP+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            if (rs.next()) {
                IMGPATH1 = rs.getString("ANHLOP");
                TENLOP = rs.getString("TENLOP");
            }
            tfmalop.setText(MALOP);
            tftenlop.setText(TENLOP);
            
            //Hiển thị hình ảnh lên label
            ImageIcon icon = new ImageIcon(IMGPATH1);

            int labelWidth = lbanhminhhoa.getWidth();
            int labelHeight = lbanhminhhoa.getHeight();
            Image image = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            ImageIcon resize = new ImageIcon(image);

            lbanhminhhoa.setIcon(resize);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //Tắt component khi ROLE = Thông tin
    public void FLAG0 () {
        btnthem.setEnabled(false);
        btnluu.setEnabled(false);
        btnclear.setEnabled(false);
        lbheading.setText("THÔNG TIN");
        btnchonanh.setEnabled(false);
        tfmalop.setEditable(false);
        tftenlop.setEditable(false);
    }
    public void FLAG1 () {
        btnthem.setEnabled(false);
        btnluu.setEnabled(true);
        btnclear.setEnabled(false);
        lbheading.setText("SỬA LỚP HỌC");
        btnchonanh.setEnabled(true);
        tfmalop.setEditable(true);
        tftenlop.setEditable(true);
        
    }
    public void FLAGDEFAULT () {
        btnthem.setEnabled(true);
        btnluu.setEnabled(false);
        btnclear.setEnabled(true);
        lbheading.setText("THÊM LỚP HỌC");
        btnchonanh.setEnabled(true);
        tfmalop.setEditable(true);
        tftenlop.setEditable(true);
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
        lbheading = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfmalop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftenlop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnchonanh = new javax.swing.JButton();
        lbanhminhhoa = new javax.swing.JLabel();
        btnthem = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnhuy = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lbheading.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        lbheading.setText("TẠO LỚP HỌC");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin lớp học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 16), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setText("Mã Lớp");

        tfmalop.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel3.setText("Tên Lớp");

        tftenlop.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel4.setText("Ảnh");

        btnchonanh.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnchonanh.setText("Chọn File");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnchonanh)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbanhminhhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(tfmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnchonanh))
                    .addComponent(lbanhminhhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnthem.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnhuy.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnhuy.setText("Hủy");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });

        btnluu.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnluu.setText("Luuw");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbheading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(btnhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbheading)
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imgFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this, "Thêm");

        if (x==JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            IMGPATH = f.getAbsolutePath();

            ImageIcon icon = new ImageIcon(IMGPATH);

            int labelWidth = lbanhminhhoa.getWidth();
            int labelHeight = lbanhminhhoa.getHeight();
            Image image = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            ImageIcon resize = new ImageIcon(image);

            lbanhminhhoa.setIcon(resize);
        }
    }//GEN-LAST:event_btnchonanhActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
          String MALOP = tfmalop.getText();
          String TENLOP = tftenlop.getText();

        try {
            conn = cn.gConnection();
            Statement stm = conn.createStatement();
            String queryCheck = "SELECT MALOP FROM LOPHOC WHERE MALOP = '"+MALOP+"'";
            ResultSet rs = stm.executeQuery(queryCheck);
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Mã lớp đã tồn tại. Vui lòng nhập mã lớp khác");
                return;
            }
 
            String query = "INSERT INTO LOPHOC(ANHLOP, MALOP, TENLOP) VALUES ('"+IMGPATH+"', '"+MALOP+"', '"+TENLOP+"')";
            int rowInserted = stm.executeUpdate(query);
            if (rowInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                this.dispose();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnthemActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        tfmalop.setText("");
        tftenlop.setText("");
        lbanhminhhoa.setIcon(null);
        IMGPATH = null;
        
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnhuyActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        // TODO add your handling code here:
        String MALOP1 = tfmalop.getText();
        String TENLOP = tftenlop.getText();
        
        try {
            conn = cn.gConnection();
            Statement stm = conn.createStatement();
            
        
            String query = "UPDATE LOPHOC SET ANHLOP = '"+IMGPATH+"', MALOP = '"+MALOP1+"', TENLOP = '"+TENLOP+"' WHERE MALOP = '"+MALOP+"'";
            int rowInserted = stm.executeUpdate(query);
            if (rowInserted > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.dispose();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnluuActionPerformed

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
            java.util.logging.Logger.getLogger(Form_TaoLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_TaoLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_TaoLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_TaoLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_TaoLopHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnthem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbanhminhhoa;
    private javax.swing.JLabel lbheading;
    private javax.swing.JTextField tfmalop;
    private javax.swing.JTextField tftenlop;
    // End of variables declaration//GEN-END:variables
}
