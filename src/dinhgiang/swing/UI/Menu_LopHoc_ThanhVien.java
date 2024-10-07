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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.image.*;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dinhgiang1
 */
public class Menu_LopHoc_ThanhVien extends javax.swing.JInternalFrame {
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    String IMGPATH = "";

    /**
     * Creates new form LopHoc
     */
    public Menu_LopHoc_ThanhVien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        load_dbcb();
    }
    
    public void load_dbcb() {
        try {
            conn = cn.gConnection();
            String query = "SELECT MALOP FROM LOPHOC";
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
         String MALOP = cblop.getSelectedItem().toString();
        
        try {
            conn = cn.gConnection();
             DefaultTableModel model = new DefaultTableModel(new String[]{"ẢNH", "TÊN", "NGÀY SINH", "QUÊ QUÁN", "TRƯỜNG", "LỚP", "MAHS"}, 0) {
                @Override
                    public boolean isCellEditable(int row, int column) {
                        // Tất cả các ô sẽ không thể chỉnh sửa
                        return false;
                    }
                    };
            String query = "SELECT * FROM THANHVIEN WHERE MALOP = '"+MALOP+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                String ANH = rs.getString("ANH");
                IMGPATH = ANH;
                String TEN = rs.getString("TEN");
                String NGAYSINH = rs.getString("NGAYSINH");
                String QUEQUAN = rs.getString("QUEQUAN");
                String TRUONG = rs.getString("TRUONG");
                String MALOP1 = rs.getString("MALOP");  
                String MAHS = rs.getString("MAHS");
                
                ImageIcon imageIcon = new ImageIcon(ANH);
                Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(image);
                model.addRow(new Object[] {resizedIcon, TEN, NGAYSINH, QUEQUAN, TRUONG, MALOP1, MAHS});
            }
            table.setRowHeight(35);
            table.setModel(model);
            
             // Gán ImageRenderer cho cột "ẢNH HÀNG"
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resizeImageForLabel(JLabel label) {
        ImageIcon icon = (ImageIcon) label.getIcon();
        if (icon != null) {
            Image img = icon.getImage();
            Image resizedImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(resizedImage));
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
        btnthemhs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cblop = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfsearch.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        tfsearch.setToolTipText("");
        tfsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        tfsearch.setFocusTraversalKeysEnabled(false);

        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp Xếp", "Tăng dần", "Giảm dần" }));

        btnthemhs.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnthemhs.setText("Thêm học sinh");
        btnthemhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhsActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Ngày sinh", "Quê quán", "Trường", "Lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jButton4.setText("Tìm");

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
        jLabel1.setText("THÀNH VIÊN LỚP ");

        cblop.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        cblop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn một lớp để hiển thị --" }));
        cblop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cblopItemStateChanged(evt);
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
                                .addGap(308, 308, 308)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnthemhs, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addComponent(btnthemhs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(btnxoa)
                        .addComponent(btnsua))
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
//        String MALOP = cblop.getSelectedItem().toString();
//        
//        try {
//            conn = cn.gConnection();
//             DefaultTableModel model = new DefaultTableModel(new String[]{"ẢNH", "TÊN", "NGÀY SINH", "QUÊ QUÁN", "TRƯỜNG", "LỚP", "MAHS"}, 0) {
//                @Override
//                    public boolean isCellEditable(int row, int column) {
//                        // Tất cả các ô sẽ không thể chỉnh sửa
//                        return false;
//                    }
//                    };
//            String query = "SELECT * FROM THANHVIEN WHERE MALOP = '"+MALOP+"'";
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(query);
//            
//            while(rs.next()) {
//                String ANH = rs.getString("ANH");
//                String TEN = rs.getString("TEN");
//                String NGAYSINH = rs.getString("NGAYSINH");
//                String QUEQUAN = rs.getString("QUEQUAN");
//                String TRUONG = rs.getString("TRUONG");
//                String MALOP1 = rs.getString("MALOP");  
//                String MAHS = rs.getString("MAHS");
//                
//                ImageIcon imageIcon = new ImageIcon(ANH);
//                Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//                ImageIcon resizedIcon = new ImageIcon(image);
//                model.addRow(new Object[] {resizedIcon, TEN, NGAYSINH, QUEQUAN, TRUONG, MALOP1, MAHS});
//            }
//            table.setRowHeight(35);
//            table.setModel(model);
//            
//             // Gán ImageRenderer cho cột "ẢNH HÀNG"
//            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            
    }//GEN-LAST:event_cblopItemStateChanged

    private void btnthemhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhsActionPerformed
        // TODO add your handling code here:
        Form_ThemHocSinh themhocsinh = new Form_ThemHocSinh();
        themhocsinh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Gọi hàm load_db() để load lại dữ liệu khi cửa sổ đóng
                load_db();
            }
        });
        themhocsinh.setVisible(true);
    }//GEN-LAST:event_btnthemhsActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
         int selectedRow = table.getSelectedRow();
         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một học sinh để sửa!");
            return;
        }
        String MAHS = "";
        if (selectedRow >= 0) {
            MAHS = table.getValueAt(selectedRow, 6).toString();
        }
        
        Form_ThemHocSinh themhocsinh = new Form_ThemHocSinh(1, MAHS, IMGPATH);
        
        // Lắng nghe sự kiện khi cửa sổ Form_TaoLopHoc đóng lại
        themhocsinh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Gọi hàm load_db() để load lại dữ liệu khi cửa sổ đóng
                load_db();
            }
        });
        themhocsinh.setVisible(true);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        conn = cn.gConnection();
        
        try {
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn học sinh để xóa!");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa học sinh này chứ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
            return;
            }
            
            String MAHS = table.getValueAt(selectedRow, 6).toString();
            String query = "DELETE FROM THANHVIEN WHERE MAHS = '"+MAHS+"'";
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
    }//GEN-LAST:event_btnxoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthemhs;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}