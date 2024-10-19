/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dinhgiang.swing.UI;

import dinhgiang.model.ConnectDB;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dinhgiang1
 */
public class Form_ThemCauHoi extends javax.swing.JFrame {
    String MABT_QID = "";
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    int FLAG = -1; //0:Sửa || 1:Thêm
    
    /**
     * Creates new form Form_ThemCauHoi
     */
    public Form_ThemCauHoi() {
        initComponents();
    }
    public Form_ThemCauHoi(String MABT_QID, String MALOP, int FLAG) {
        initComponents();
        this.MABT_QID = MABT_QID;
        this.FLAG = FLAG;
        cbmabt.addItem(MABT_QID);
        cbmabt.setEnabled(false);
        cblop.addItem(MALOP);
        cblop.setEnabled(false);
        if (FLAG == 1) {
            FLAG1();
        }
        if (FLAG == 0) {
            FLAG0();
            load_db();
        }
    }
    
    public void FLAG1() {
        btnluu.setEnabled(false);
        lbheading.setText("THÊM CÂU HỎI");
    }
    
    public void FLAG0() {
        btnthem.setEnabled(false);
        btnclear.setEnabled(false);
        lbheading.setText("SỬA CÂU HỎI");
    }
    
    public void load_db() {
        String CAUHOI = "";
        String A1 = "";
        String A2 = "";
        String A3 = "";
        String A4 = "";
        int IS_CORRECT = -1;
        
        try {
            conn = cn.gConnection();
            String query = "SELECT * FROM CAUHOI WHERE QID = '"+MABT_QID+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                CAUHOI = rs.getString("QTEXT");
                A1 = rs.getString("A1");
                A2 = rs.getString("A2");
                A3 = rs.getString("A3");
                A4 = rs.getString("A4");
                IS_CORRECT = Integer.parseInt(rs.getString("IS_CORRECT"));
            }
            
            tfcauhoi.setText(CAUHOI);
            tftraloi1.setText(A1);
            tftraloi2.setText(A2);
            tftraloi3.setText(A3);
            tftraloi4.setText(A4);
            switch (IS_CORRECT) {
                case 1:
                    r1.setSelected(true);
                    break;
                case 2:
                    r2.setSelected(true);
                    break;
                case 3:
                    r3.setSelected(true);
                    break;
                case 4:
                    r4.setSelected(true);
                    break;
                default:
                    throw new AssertionError();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbheading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfcauhoi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbmabt = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tftraloi1 = new javax.swing.JTextField();
        r1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        tftraloi2 = new javax.swing.JTextField();
        r2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        tftraloi3 = new javax.swing.JTextField();
        r3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tftraloi4 = new javax.swing.JTextField();
        r4 = new javax.swing.JRadioButton();
        btnthem = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnhuy = new javax.swing.JButton();
        cblop = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lbheading.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        lbheading.setText("THÊM CÂU HỎI");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel1.setText("Mã bài tập");

        tfcauhoi.setColumns(20);
        tfcauhoi.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        tfcauhoi.setRows(5);
        jScrollPane1.setViewportView(tfcauhoi);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel2.setText("Câu hỏi:");

        cbmabt.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel3.setText("Answer #1");

        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel4.setText("Answer #2");

        buttonGroup1.add(r2);
        r2.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel5.setText("Answer #3");

        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel6.setText("Answer #4");

        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        btnthem.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnluu.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnluu.setText("Luuw");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
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

        cblop.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel7.setText("Mã lớp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbmabt, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbheading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                                .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(362, 362, 362))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(r1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tftraloi1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(r4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(tftraloi4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(r2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tftraloi2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(r3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tftraloi3, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbheading)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tftraloi1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(r1)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tftraloi2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(r2)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tftraloi3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(r3)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbmabt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tftraloi4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(r4)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String QTEXT = tfcauhoi.getText();
        String MABT = cbmabt.getSelectedItem().toString();
        String MALOP = cblop.getSelectedItem().toString();
        String A1 = tftraloi1.getText();
        String A2 = tftraloi2.getText();
        String A3 = tftraloi3.getText();
        String A4 = tftraloi4.getText();
            
        // Lấy đáp án đúng từ các JRadioButton
        int IS_CORRECT = -1;
        if (r1.isSelected()) {
            IS_CORRECT = 1;
        } else if (r2.isSelected()) {
            IS_CORRECT = 2;
        } else if (r3.isSelected()) {
            IS_CORRECT = 3;
        } else if (r4.isSelected()) {
            IS_CORRECT = 4;
        }
            
        // Kiểm tra nếu không có đáp án đúng được chọn
        if (IS_CORRECT == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đáp án!");
            return;
        }

        try {
            conn = cn.gConnection();
            Statement stm = conn.createStatement();
            String query1 = "INSERT INTO CAUHOI (QTEXT, MABT, A1, A2, A3, A4, IS_CORRECT, MALOP) VALUES ('"+QTEXT+"', '"+MABT+"', '"+A1+"', '"+A2+"', '"+A3+"', '"+A4+"', '"+IS_CORRECT+"', '"+MALOP+"')";
            int rowInserted = stm.executeUpdate(query1);
            if (rowInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        //TODO add your handling code here:
        String CAUHOI = tfcauhoi.getText();
        String A1 = tftraloi1.getText();
        String A2 = tftraloi2.getText();
        String A3 = tftraloi3.getText();
        String A4 = tftraloi4.getText();
        int IS_CORRECT = -1;
        if (r1.isSelected()) {
            IS_CORRECT = 1;
        } else if (r2.isSelected()) {
            IS_CORRECT = 2;
        } else if (r3.isSelected()) {
            IS_CORRECT = 3;
        } else if (r4.isSelected()) {
            IS_CORRECT = 4;
        }
        // Kiểm tra nếu không có đáp án đúng được chọn
        if (IS_CORRECT == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đáp án!");
            return;
        }
        
        try {
            conn = cn.gConnection();
            Statement stm = conn.createStatement();

            String query = "UPDATE CAUHOI SET QTEXT = '"+CAUHOI+"', A1 = '"+A1+"', A2 = '"+A2+"', A3 = '"+A3+"', A4 = '"+A4+"', IS_CORRECT = '"+IS_CORRECT+"' WHERE QID = '"+MABT_QID+"'";
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

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
//        tfmabt.setText("");
//
//        lbanhminhhoa.setIcon(null);
//        IMGPATH = null;

    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnhuyActionPerformed

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
            java.util.logging.Logger.getLogger(Form_ThemCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_ThemCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_ThemCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_ThemCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ThemCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JComboBox<String> cbmabt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbheading;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JTextArea tfcauhoi;
    private javax.swing.JTextField tftraloi1;
    private javax.swing.JTextField tftraloi2;
    private javax.swing.JTextField tftraloi3;
    private javax.swing.JTextField tftraloi4;
    // End of variables declaration//GEN-END:variables
}
