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

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;

/**
 *
 * @author dinhgiang1
 */
public class Menu_LopHoc_ThanhVien extends javax.swing.JInternalFrame {
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    String IMGPATH = "";
    String HS = "";
    String TAIKHOAN = "";

    /**
     * Creates new form LopHoc
     */
    public Menu_LopHoc_ThanhVien(String HS, String TAIKHOAN) {
        initComponents();
        this.HS = HS;
        this.TAIKHOAN = TAIKHOAN;
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        //load_dbcb();
        if (HS.equals("HS")) {
            btnthemhs.setEnabled(false);
            btnxoa.setEnabled(false);
            btnsua.setEnabled(false);
            load_dbcbhs();
        } else {
            load_dbcb();        
        }
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
    
    public void load_dbcbhs() {
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
         String MALOP = cblop.getSelectedItem().toString();
        
        try {
            conn = cn.gConnection();
             DefaultTableModel model = new DefaultTableModel(new String[]{"HỌ TÊN", "TRƯỜNG", "NGÀY SINH", "QUÊ", "MÃ LỚP"}, 0) {
                @Override
                    public boolean isCellEditable(int row, int column) {
                        // Tất cả các ô sẽ không thể chỉnh sửa
                        return false;
                    }
                    };
            String query = "SELECT * FROM TAIKHOAN WHERE MALOP = '"+MALOP+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {               
                String HOTEN = rs.getString("HOTEN");
                String TRUONG = rs.getString("TRUONG");
                String NGAYSINH = rs.getString("NGAYSINH");
                String QUEQUAN = rs.getString("TINH");            
                String MALOP1 = rs.getString("MALOP");  
                               
                model.addRow(new Object[] {HOTEN, TRUONG, NGAYSINH, QUEQUAN, MALOP1});
            }
            table.setRowHeight(35);
            table.setModel(model);                 
            
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
        cbsapxep = new javax.swing.JComboBox<>();
        btnthemhs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cblop = new javax.swing.JComboBox<>();
        btnxuatexcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfsearch.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        tfsearch.setToolTipText("");
        tfsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        tfsearch.setFocusTraversalKeysEnabled(false);
        tfsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsearchKeyReleased(evt);
            }
        });

        cbsapxep.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        cbsapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "Tăng dần theo tên", "Giảm dần theo tên" }));
        cbsapxep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbsapxepItemStateChanged(evt);
            }
        });

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

        btnxuatexcel.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnxuatexcel.setText("Xuất excel");
        btnxuatexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatexcelActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxuatexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnthemhs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cbsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemhs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(btnxoa)
                        .addComponent(btnsua)
                        .addComponent(btnxuatexcel))
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

    private void tfsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchKeyReleased
        // TODO add your handling code here:
        String searchKey = tfsearch.getText().trim();
        String MALOP2 = cblop.getSelectedItem().toString();
        if (searchKey.isEmpty()){
            load_db();
            return;
        }
        
        try {
            conn = cn.gConnection();
            DefaultTableModel model = new DefaultTableModel(new String[]{"HỌ TÊN", "TRƯỜNG", "NGÀY SINH", "QUÊ", "MÃ LỚP"}, 0) {
                @Override
                    public boolean isCellEditable(int row, int column) {
                        // Tất cả các ô sẽ không thể chỉnh sửa
                        return false;
                    }
                    };
              String query = "SELECT HOTEN, TRUONG, NGAYSINH, TINH, MALOP FROM TAIKHOAN WHERE (HOTEN LIKE '%"+searchKey+"%' OR TRUONG LIKE '%"+searchKey+"%' OR NGAYSINH LIKE '%"+searchKey+"%' OR TINH LIKE '%"+searchKey+"%') AND MALOP = '"+MALOP2+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                String HOTEN = rs.getString("HOTEN");
                String TRUONG = rs.getString("TRUONG");
                String NGAYSINH = rs.getString("NGAYSINH");
                String QUEQUAN = rs.getString("TINH");            
                String MALOP1 = rs.getString("MALOP");  
                
                model.addRow(new Object[] {HOTEN, TRUONG, NGAYSINH, QUEQUAN, MALOP1});
            }
            table.setRowHeight(35);
            table.setModel(model);
            table.setRowMargin(10);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tfsearchKeyReleased

    private void sortData(String order) {
    String MALOP = cblop.getSelectedItem().toString();
    
    try {
        conn = cn.gConnection();
        DefaultTableModel model = new DefaultTableModel(new String[]{"HỌ TÊN", "TRƯỜNG", "NGÀY SINH", "QUÊ", "MÃ LỚP"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Câu truy vấn sắp xếp theo thứ tự order (ASC hoặc DESC)
        String query = "SELECT * FROM TAIKHOAN WHERE MALOP = '" + MALOP + "' ORDER BY HOTEN " + order;

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            String HOTEN = rs.getString("HOTEN");
                String TRUONG = rs.getString("TRUONG");
                String NGAYSINH = rs.getString("NGAYSINH");
                String QUEQUAN = rs.getString("TINH");            
                String MALOP1 = rs.getString("MALOP");  
                
                model.addRow(new Object[] {HOTEN, TRUONG, NGAYSINH, QUEQUAN, MALOP1});
        }

        table.setRowHeight(35);
        table.setModel(model);
        table.setRowMargin(10);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    private void cbsapxepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbsapxepItemStateChanged
        // TODO add your handling code here:
        String selectedItem = cbsapxep.getSelectedItem().toString();
        
        if (selectedItem.equals("Tăng dần theo tên")) {
            // Sắp xếp tăng dần theo tên
            sortData("ASC");
        } else if (selectedItem.equals("Giảm dần theo tên")) {
            // Sắp xếp giảm dần theo tên
            sortData("DESC");
        } else if (selectedItem.equals("Sắp xếp")) {
            // Hiển thị lại dữ liệu gốc
            load_db();
        }    
    }//GEN-LAST:event_cbsapxepItemStateChanged

    private void btnxuatexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatexcelActionPerformed
        // TODO add your handling code here:
        // Tạo Workbook mới
        String malop = cblop.getSelectedItem().toString();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("THANHVIEN" + malop);

        // Lấy model của bảng
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Tạo hàng đầu tiên (header)
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }

        // Thêm dữ liệu từ bảng vào Excel
        for (int i = 0; i < model.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1); // Bắt đầu từ hàng 1, vì hàng 0 đã dành cho header
            for (int j = 0; j < model.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                Object value = model.getValueAt(i, j);
                if (value instanceof String) {
                    cell.setCellValue((String) value);
                } else if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Double) {
                    cell.setCellValue((Double) value);
                }
            }
        }
    
        // Đặt đường dẫn cố định
        String filePath = "/Users/dinhgiang1/Downloads/THANHVIEN.xlsx";  // Đường dẫn cố định

        // Chọn nơi lưu file Excel
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Xuất file Excel thất bại!");
        }
    }//GEN-LAST:event_btnxuatexcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthemhs;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxuatexcel;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JComboBox<String> cbsapxep;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}
