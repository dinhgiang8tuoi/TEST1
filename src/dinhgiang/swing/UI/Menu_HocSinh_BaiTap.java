/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package dinhgiang.swing.UI;

import com.formdev.flatlaf.FlatClientProperties;
import dinhgiang.model.ConnectDB;
import dinhgiang.model.ImageRenderer;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.image.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinhgiang1
 */
public class Menu_HocSinh_BaiTap extends javax.swing.JInternalFrame {
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    String IMGPATH = "";
    int FLAG = 1; //0: XemSUA || 1: Default
    String TAIKHOAN = "";
    String MABT1 = "";
    String MALOP = "";
    String HOTEN = "";

    /**
     * Creates new form LopHoc
     */
    public Menu_HocSinh_BaiTap(String TAIKHOAN) {
        initComponents();
        this.TAIKHOAN = TAIKHOAN;
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
     
        load_dbcb();
        
        btnsua.setEnabled(false);
        btnxoa.setEnabled(false);
        btnback.setEnabled(false);
        btnxem.setEnabled(false);
        btnthemcauhoi.setEnabled(false);
        btnlamthu.setEnabled(false);
    }

    public void load_dbcb() {
        try {
            conn = cn.gConnection();
            String query = "SELECT MALOP FROM TAIKHOAN WHERE TAIKHOAN = '"+TAIKHOAN+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                cblop.addItem(rs.getString("MALOP"));
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
    public void load_db() {
         MALOP = cblop.getSelectedItem().toString();
         String SOCAU = "";
        
        try {
            conn = cn.gConnection();
             DefaultTableModel model = new DefaultTableModel(new String[]{"ẢNH", "Mã bài tập", "Tên bài tập", "Số câu", "Số điểm", "Mã lớp"}, 0) {
                @Override
                    public boolean isCellEditable(int row, int column) {
                        // Tất cả các ô sẽ không thể chỉnh sửa
                        return false;
                    }
                    };
            String query = "SELECT * FROM BAITAP WHERE MALOP = '"+MALOP+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                String ANH = rs.getString("ANH");
                IMGPATH = ANH;
                String MABT = rs.getString("MABT");
                String TENBT = rs.getString("TENBT");
                String MALOP1 = rs.getString("MALOP");
                double SODIEM = Double.parseDouble(rs.getString("SODIEM"));
                ImageIcon imageIcon = new ImageIcon(ANH);
                Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(image);
                model.addRow(new Object[] {resizedIcon, MABT, TENBT, SOCAU, SODIEM, MALOP1});
            }
            table.setRowHeight(35);
            table.setModel(model);
            
             // Gán ImageRenderer cho cột "ẢNH HÀNG"
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            
            String query2 = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='"+TAIKHOAN+"'";
            rs = stm.executeQuery(query2);
            while (rs.next()) {
                HOTEN = rs.getString("HOTEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void load_dbCAUHOI() {
         String MABT = "";
         int selectedRow = table.getSelectedRow();
         if (selectedRow >= 0) {
             MABT = table.getValueAt(selectedRow, 1).toString();
         }
       
        try {
            conn = cn.gConnection();
             DefaultTableModel model = new DefaultTableModel(new String[]{"Mã câu hỏi", "Câu hỏi", "Mã bài tập", "Mã lớp", "A1", "A2", "A3", "A4", "IS_CORRECT"}, 0) {
                @Override
                    public boolean isCellEditable(int row, int column) {
                        // Tất cả các ô sẽ không thể chỉnh sửa
                        return false;
                    }
                    };
            String query = "SELECT * FROM CAUHOI WHERE MABT = '"+MABT+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                String QID = rs.getString("QID");
                String QTEXT = rs.getString("QTEXT");
                String MABT1 = rs.getString("MABT");
                String MALOP = rs.getString("MALOP");
                String A1 = rs.getString("A1");
                String A2 = rs.getString("A2");
                String A3 = rs.getString("A3");
                String A4 = rs.getString("A4");
                int IS_CORRECT = Integer.parseInt(rs.getString("IS_CORRECT"));
           
                model.addRow(new Object[] {QID, QTEXT, MABT1, MALOP, A1, A2, A3, A4, IS_CORRECT});
            }
            table.setRowHeight(35);
            table.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        tfsearch = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnlambai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnxem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cblop = new javax.swing.JComboBox<>();
        btnthemcauhoi = new javax.swing.JButton();
        btnlamthu = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfsearch.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        tfsearch.setToolTipText("");
        tfsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        tfsearch.setFocusTraversalKeysEnabled(false);

        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp Xếp", "Tăng dần", "Giảm dần" }));

        btnlambai.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnlambai.setText("Làm bài");
        btnlambai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlambaiActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ảnh", "Mã bài tập", "Tên bài tập", "Số câu", "Số điểm", "Mã lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnxem.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnxem.setText("Xem");
        btnxem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel1.setText("BÀI TẬP");

        cblop.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        cblop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn một lớp để hiển thị --" }));
        cblop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cblopItemStateChanged(evt);
            }
        });

        btnthemcauhoi.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnthemcauhoi.setText("Thêm câu hỏi");
        btnthemcauhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemcauhoiActionPerformed(evt);
            }
        });

        btnlamthu.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnlamthu.setText("Làm thử");
        btnlamthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamthuActionPerformed(evt);
            }
        });

        btnback.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnback)
                                .addGap(15, 15, 15)
                                .addComponent(btnthemcauhoi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                            .addComponent(cblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxem, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnlamthu)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnlambai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnxoa)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlambai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnxem)
                        .addComponent(btnxoa)
                        .addComponent(btnsua)
                        .addComponent(btnthemcauhoi)
                        .addComponent(btnlamthu)
                        .addComponent(btnback))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1018, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cblopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cblopItemStateChanged
        // TODO add your handling code here:
       load_db();
        
    }//GEN-LAST:event_cblopItemStateChanged

    private void btnlambaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlambaiActionPerformed
        // TODO add your handling code here:
        Multiple_Choices lamthu = new Multiple_Choices(HOTEN, MABT1, MALOP);
        lamthu.setVisible(true);
    }//GEN-LAST:event_btnlambaiActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        // 1: Form danh sách bài tập  ||  0: Form danh sách câu hỏi
        if (FLAG == 1) {
        int selectedRow = table.getSelectedRow();
         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bài tập để sửa!");
            return;
        }
        String MABT = "";
        if (selectedRow >= 0) {
            MABT = table.getValueAt(selectedRow, 1).toString();
        }
        
       Form_TaoBaiTap tbt = new Form_TaoBaiTap(1, MABT);
        
        // Lắng nghe sự kiện khi cửa sổ Form_TaoLopHoc đóng lại
        tbt.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Gọi hàm load_db() để load lại dữ liệu khi cửa sổ đóng
                load_db();
            }
        });
        tbt.setVisible(true);
        }
        
        //0: Sửa câu hỏi
        if (FLAG == 0) {
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
           JOptionPane.showMessageDialog(this, "Vui lòng chọn một câu hỏi để sửa!");
           return;
        }
        String MACAUHOI = "";
        String MALOP = "";
        if (selectedRow >= 0) {
            MACAUHOI = table.getValueAt(selectedRow, 0).toString();
            MALOP = table.getValueAt(selectedRow, 3).toString();
        }
        
        Form_ThemCauHoi tch = new Form_ThemCauHoi(MACAUHOI, MALOP, 0);
        
        //Lắng nghe sự kiện khi cửa sổ Form_TaoLopHoc đóng lại
        tch.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Gọi hàm load_db() để load lại dữ liệu khi cửa sổ đóng
                load_db();
            }
        });
        tch.setVisible(true);
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        conn = cn.gConnection();
        // Xóa bài tập:
        if (FLAG == 1) {
        try {
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn bài tập để xóa!");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa bài tập này chứ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
            return;
            }
            
            String MABT = table.getValueAt(selectedRow, 1).toString();
            String query = "DELETE FROM BAITAP WHERE MAHS = '"+MABT+"'";
            Statement statement = conn.createStatement();
            int rowDeleted = statement.executeUpdate(query);
            
            if (rowDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                load_db();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
        }
        // Xóa câu hỏi:
        if (FLAG == 0) {
        try {
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn câu hỏi để xóa!");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa câu hỏi này chứ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
            return;
            }
            
            String QID = table.getValueAt(selectedRow, 0).toString();
            String query = "DELETE FROM CAUHOI WHERE MAHS = '"+QID+"'";
            Statement statement = conn.createStatement();
            int rowDeleted = statement.executeUpdate(query);
            
            if (rowDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                load_db();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnthemcauhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemcauhoiActionPerformed
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bài tập để thêm câu hỏi!");
            return;
        }
        String MABT = "";
        String MALOP = "";
        if (selectedRow >= 0) {
            MABT = table.getValueAt(selectedRow, 1).toString();
            MALOP = table.getValueAt(selectedRow, 5).toString();
        }
        
       Form_ThemCauHoi tch = new Form_ThemCauHoi(MABT, MALOP, 1);
        
        // Lắng nghe sự kiện khi cửa sổ Form_TaoLopHoc đóng lại
//        tch.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
//                // Gọi hàm load_db() để load lại dữ liệu khi cửa sổ đóng
//                load_db();
//            }
//        });
        tch.setVisible(true);
    }//GEN-LAST:event_btnthemcauhoiActionPerformed

    private void btnxemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemActionPerformed
        // TODO add your handling code here:
        FLAG = 0;
        try {
            conn = cn.gConnection();
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn một lớp để xem!");
                return;
            }
            load_dbCAUHOI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnxemActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        FLAG = 1;
        load_db();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnlamthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamthuActionPerformed
        // TODO add your handling code here:
//        Multiple_Choices lamthu = new Multiple_Choices(TAIKHOAN, MABT1, MALOP1);
//        lamthu.setVisible(true);
      
    }//GEN-LAST:event_btnlamthuActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
         if (selectedRow >= 0) {
            MABT1 = table.getValueAt(selectedRow, 1).toString();
        }        
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlambai;
    private javax.swing.JButton btnlamthu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthemcauhoi;
    private javax.swing.JButton btnxem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}
