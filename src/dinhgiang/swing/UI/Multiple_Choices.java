/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dinhgiang.swing.UI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import dinhgiang.model.ConnectDB;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhgiang1
 */
public final class Multiple_Choices extends javax.swing.JFrame {
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    int TEMP_ISCORRECT = 0;
    String TAIKHOAN = "";
    String MABT = "";
    String MALOP = "";
    
    // Tạo biến tính điểm
    int soDapAnDung = 0;
    int soDapAnSai = 0;
    int soLuongCauHoi = 0;
    
    //Đếm số câu hỏi được load lên component
    int questionIndex = 0;

    /**
     * Creates new form Multiple_Choices
     */
    public Multiple_Choices() {
        initComponents();
    }
    public Multiple_Choices(String TAIKHOAN, String MABT, String MALOP) {
        initComponents();
        this.TAIKHOAN = TAIKHOAN;
        this.MABT = MABT;
        this.MALOP = MALOP;
        
        // Điền thông tin 
        tftaikhoan.setText(TAIKHOAN);
        tfmabt.setText(MABT);
        load_soLuongCauHoi();
        labeldangocauthu.setText("Đang ở câu thứ: " + (questionIndex + 1) + "/"+soLuongCauHoi);
        
        // Tắt chỉnh sửa các text field
        tftaikhoan.setEditable(false);
        tfmabt.setEditable(false);
        tfsoluongcauhoi.setEditable(false);
        tfthoiluong.setEditable(false);
        btnnopbai0.setEnabled(false);
        btnnopbai1.setEnabled(false);
        
        // Gọi hàm load câu hỏi và đáp án
        load_CauHoi(0);
        
    }
    
    public void load_soLuongCauHoi() {
        try {
            String StrSoLuongCauHoi = "";
            conn = cn.gConnection();
            String query = "SELECT COUNT(MABT) AS SOLUONGCAUHOI FROM CAUHOI WHERE MABT = '"+MABT+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                soLuongCauHoi = Integer.parseInt(rs.getString("SOLUONGCAUHOI"));
                StrSoLuongCauHoi = rs.getString("SOLUONGCAUHOI");
            }
            tfsoluongcauhoi.setText(StrSoLuongCauHoi);            
        } catch (Exception e) {
        }
    }
    
    public void load_CauHoi(int questionIndex) {
        try {
            conn = cn.gConnection();
            String query = "SELECT QTEXT, A1, A2, A3, A4, IS_CORRECT FROM CAUHOI WHERE MABT = '"+MABT+"' LIMIT "+questionIndex+", 1";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            if (rs.next()) {
                // Lấy dữ liệu từ truy vấn
                String QTEXT = rs.getString("QTEXT");
                String A1 = rs.getString("A1");
                String A2 = rs.getString("A2");
                String A3 = rs.getString("A3");
                String A4 = rs.getString("A4");
                int IS_CORRECT = rs.getInt("IS_CORRECT");
                TEMP_ISCORRECT = IS_CORRECT;
                
                // Hiển thị câu hỏi và câu trả lời
                lbcauhoi.setText(QTEXT);
                lba1.setText("A. " + A1);
                lba2.setText("B. " + A2);
                lba3.setText("C. " + A3);
                lba4.setText("D. " + A4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Hàm kiểm tra đáp án đúng
    public void check_DapAn() {
        // Kiểm tra người dùng chọn đáp án nào
        int dapAnDuocChon = -1;
        if (r1.isSelected()) {
            dapAnDuocChon = 1;
        } else if (r2.isSelected()) {
            dapAnDuocChon = 2;
        } else if (r3.isSelected()) {
            dapAnDuocChon = 3;           
        } else if (r4.isSelected()) {
            dapAnDuocChon = 4;
        }
        
        //Đếm số lượng đáp án đúng, đáp án sai
        if (TEMP_ISCORRECT == dapAnDuocChon) {
            soDapAnDung++;
        } else {
            soDapAnSai++;
        }        
    }
    
    // Hàm tính điểm
    public void tinhDiem() {
        Double tongDiemCuaBaiKiemTra = 0.0;
        try {
            conn = cn.gConnection();
            String query = "SELECT SODIEM FROM BAITAP WHERE MABT = '"+MABT+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                tongDiemCuaBaiKiemTra = rs.getDouble("SODIEM");
            }
            
            Double diemCuaMoiCauHoi = 0.0;
            diemCuaMoiCauHoi = tongDiemCuaBaiKiemTra / soLuongCauHoi;
            Double BANGDIEM = soDapAnDung*diemCuaMoiCauHoi;
            
            try {
                conn = cn.gConnection();
                String query1 = "INSERT INTO BANGDIEM(TAIKHOAN, MABT, MALOP, BANGDIEM) VALUES ('"+TAIKHOAN+"', '"+MABT+"', '"+MALOP+"', '"+BANGDIEM+"')";
                int insertedRow = stm.executeUpdate(query1);
                if (insertedRow > 0) {
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        check0 = new javax.swing.JCheckBox();
        btnnopbai0 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        abc = new javax.swing.JLabel();
        lbcauhoi = new javax.swing.JLabel();
        lba1 = new javax.swing.JLabel();
        lba2 = new javax.swing.JLabel();
        lba3 = new javax.swing.JLabel();
        lba4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfsoluongcauhoi = new javax.swing.JTextField();
        tfmabt = new javax.swing.JTextField();
        tfthoiluong = new javax.swing.JTextField();
        r1 = new javax.swing.JCheckBox();
        r2 = new javax.swing.JCheckBox();
        r3 = new javax.swing.JCheckBox();
        r4 = new javax.swing.JCheckBox();
        btnnext = new javax.swing.JButton();
        check1 = new javax.swing.JCheckBox();
        btnnopbai1 = new javax.swing.JButton();
        labeldangocauthu = new javax.swing.JLabel();
        btnthoat = new javax.swing.JButton();
        tftaikhoan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel1.setText("Học sinh: ");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setText("Mã bài tập: ");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel3.setText("Số lượng câu hỏi: ");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel4.setText("Thời lượng: ");

        check0.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        check0.setText("Tôi muốn hoàn thành bài kiểm tra");
        check0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check0ActionPerformed(evt);
            }
        });

        btnnopbai0.setBackground(new java.awt.Color(255, 255, 0));
        btnnopbai0.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnnopbai0.setForeground(new java.awt.Color(102, 102, 0));
        btnnopbai0.setText("Nộp bài");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        abc.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        abc.setText("(Choose 1 answer)");

        lbcauhoi.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lbcauhoi.setText("Nhận định nào dưới dây không đúng khi nói về trọng tài thường trực?");

        lba1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lba1.setText("A. Trọng tài thường trục có trụ sở ổn định.");

        lba2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lba2.setText("B. Trọng tài thường trục không bị ảnh hưởng bởi yếu tố chính trị.");

        lba3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lba3.setText("C. Trọng tài thường trục không có quy tắc xét xử.");

        lba4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lba4.setText("D. Trọng tài thường trục có biểu phí trọng tài được xác định trước.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abc)
                    .addComponent(lbcauhoi)
                    .addComponent(lba1)
                    .addComponent(lba2)
                    .addComponent(lba3)
                    .addComponent(lba4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abc)
                .addGap(18, 18, 18)
                .addComponent(lbcauhoi)
                .addGap(18, 18, 18)
                .addComponent(lba1)
                .addGap(18, 18, 18)
                .addComponent(lba2)
                .addGap(18, 18, 18)
                .addComponent(lba3)
                .addGap(18, 18, 18)
                .addComponent(lba4)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Multiple choices 20/20");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Answer");

        tfsoluongcauhoi.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        tfsoluongcauhoi.setForeground(new java.awt.Color(51, 51, 255));
        tfsoluongcauhoi.setFocusTraversalKeysEnabled(false);
        tfsoluongcauhoi.setFocusable(false);

        tfmabt.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        tfmabt.setForeground(new java.awt.Color(51, 51, 255));
        tfmabt.setFocusTraversalKeysEnabled(false);
        tfmabt.setFocusable(false);

        tfthoiluong.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        tfthoiluong.setForeground(new java.awt.Color(51, 51, 255));
        tfthoiluong.setText("...");
        tfthoiluong.setFocusTraversalKeysEnabled(false);
        tfthoiluong.setFocusable(false);

        buttonGroup1.add(r1);
        r1.setText("A");

        buttonGroup1.add(r2);
        r2.setText("B");

        buttonGroup1.add(r3);
        r3.setText("C");

        buttonGroup1.add(r4);
        r4.setText("D");

        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        check1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        check1.setText("Tôi muốn hoàn thành bài kiểm tra");
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        btnnopbai1.setBackground(new java.awt.Color(255, 255, 0));
        btnnopbai1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnnopbai1.setForeground(new java.awt.Color(102, 102, 0));
        btnnopbai1.setText("Nộp bài");

        labeldangocauthu.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        labeldangocauthu.setForeground(new java.awt.Color(255, 0, 51));

        btnthoat.setBackground(new java.awt.Color(255, 51, 0));
        btnthoat.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnthoat.setForeground(new java.awt.Color(255, 255, 255));
        btnthoat.setText("Exit");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        tftaikhoan.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        tftaikhoan.setForeground(new java.awt.Color(51, 51, 255));
        tftaikhoan.setFocusTraversalKeysEnabled(false);
        tftaikhoan.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(tfmabt)
                            .addComponent(tfsoluongcauhoi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(check0)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnnopbai0))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfthoiluong)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                                .addComponent(btnthoat))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldangocauthu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnnext)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r1)
                                    .addComponent(r2)
                                    .addComponent(r3)
                                    .addComponent(r4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check1)
                .addGap(18, 18, 18)
                .addComponent(btnnopbai1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(tfthoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthoat)
                    .addComponent(tftaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(check0)
                    .addComponent(btnnopbai0)
                    .addComponent(tfmabt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(tfsoluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeldangocauthu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(r1)
                        .addGap(18, 18, 18)
                        .addComponent(r2)
                        .addGap(18, 18, 18)
                        .addComponent(r3)
                        .addGap(18, 18, 18)
                        .addComponent(r4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnext))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check1)
                    .addComponent(btnnopbai1))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        if ((questionIndex + 1) >= soLuongCauHoi) {
            btnnext.setEnabled(false);
        }
        if (!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn cần trả lời câu hỏi này trước đã!");
            return;
        }

        check_DapAn();
 
        questionIndex++;
        if (questionIndex < soLuongCauHoi) {
            load_CauHoi(questionIndex);
            labeldangocauthu.setText("Đang ở câu thứ: " + (questionIndex + 1) + "/"+soLuongCauHoi);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành tất cả câu hỏi! Vui lòng nhấn NỘP BÀI");
            //labeldangocauthu.setText("Đang ở câu thứ: " + (questionIndex - 1) + "/"+soLuongCauHoi);
        }
        
        buttonGroup1.clearSelection();
        
        
    }//GEN-LAST:event_btnnextActionPerformed

    private void check0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check0ActionPerformed
        // TODO add your handling code here:
        if (check0.isSelected()) {
            btnnopbai0.setEnabled(true);
        } else {
            btnnopbai0.setEnabled(false);
        }
    }//GEN-LAST:event_check0ActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
        if (check1.isSelected()) {
            btnnopbai1.setEnabled(true);
        } else {
            btnnopbai1.setEnabled(false);
        }
    }//GEN-LAST:event_check1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Multiple_Choices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abc;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnnopbai0;
    private javax.swing.JButton btnnopbai1;
    private javax.swing.JButton btnthoat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox check0;
    private javax.swing.JCheckBox check1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labeldangocauthu;
    private javax.swing.JLabel lba1;
    private javax.swing.JLabel lba2;
    private javax.swing.JLabel lba3;
    private javax.swing.JLabel lba4;
    private javax.swing.JLabel lbcauhoi;
    private javax.swing.JCheckBox r1;
    private javax.swing.JCheckBox r2;
    private javax.swing.JCheckBox r3;
    private javax.swing.JCheckBox r4;
    private javax.swing.JTextField tfmabt;
    private javax.swing.JTextField tfsoluongcauhoi;
    private javax.swing.JTextField tftaikhoan;
    private javax.swing.JTextField tfthoiluong;
    // End of variables declaration//GEN-END:variables
}
