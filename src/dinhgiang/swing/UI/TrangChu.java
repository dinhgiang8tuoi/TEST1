/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dinhgiang.swing.UI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import dinhgiang.model.ConnectDB;
import javax.swing.UIManager;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dinhgiang1
 */

public class TrangChu extends javax.swing.JFrame {
    int FLAG = 0; // 0: Trang chủ // 1: Lớp học
    int ROLE = 0; // 0: Giáo viên // 1: Học sinh
    ConnectDB cn = new ConnectDB();
    Connection conn = null;
    String TAIKHOAN = "";
    String sROLE = "";
    String MALOP = "";
    
    
    Color DefaultColor, ClickedColor, DefaultColor1;
    
    public TrangChu() {
        initComponents();
        
        DefaultColor = new Color(255,255,255);
        DefaultColor1 = new Color(0,0,0);
        ClickedColor = new Color (36,95,250);
        
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
        
        btnthanhvien.setEnabled(false);
        btnbaitap.setEnabled(false);
        btnbangdiem.setEnabled(false);
        lbName.setText("Đinh Đức Giang");
        lbsubName.setText("Giáo viên");
        
    }
    public TrangChu(String TAIKHOAN) {
        initComponents();
        this.TAIKHOAN = TAIKHOAN;
        
        DefaultColor = new Color(255,255,255);
        DefaultColor1 = new Color(0,0,0);
        ClickedColor = new Color (36,95,250);
        
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
        
        btnthanhvien.setEnabled(false);
        btnbaitap.setEnabled(false);
        btnbangdiem.setEnabled(false);
        lbName.setText("Đinh Đức Giang");
        lbsubName.setText("Giáo viên");
        
        try {
            conn = cn.gConnection();
            String query = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN = '"+TAIKHOAN+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()) {
                String HOTEN = rs.getString("HOTEN");
                sROLE = rs.getString("ROLE");
                MALOP = rs.getString("MALOP");
    
                lbName.setText(HOTEN);
                if (sROLE.equals("Tôi là giáo viên")) {
                    lbsubName.setText("Giáo viên");
                } else {
                    lbsubName.setText("Học sinh");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDefault() {
        DefaultColor = new Color(255,255,255);
        DefaultColor1 = new Color(0,0,0);
        ClickedColor = new Color (36,95,250);
        
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
        
        btnthanhvien.setEnabled(false);
        btnbaitap.setEnabled(false);
        btnbangdiem.setEnabled(false);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        panelAvata = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbsubName = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        btnlophoc = new javax.swing.JButton();
        btnthanhvien = new javax.swing.JButton();
        btnbaitap = new javax.swing.JButton();
        btnbangdiem = new javax.swing.JButton();
        btntrangchu = new javax.swing.JButton();
        btntaikhoan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnOutSetting = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        panelAvata.setBackground(new java.awt.Color(255, 255, 255));
        panelAvata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dinhgiang/imgs/tellynmy.png"))); // NOI18N
        jLabel1.setText("img");

        lbsubName.setText("Giáo viên");

        lbName.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lbName.setText("Đinh Đức Giang");

        javax.swing.GroupLayout panelAvataLayout = new javax.swing.GroupLayout(panelAvata);
        panelAvata.setLayout(panelAvataLayout);
        panelAvataLayout.setHorizontalGroup(
            panelAvataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAvataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAvataLayout.createSequentialGroup()
                        .addComponent(lbName)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAvataLayout.createSequentialGroup()
                        .addComponent(lbsubName)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelAvataLayout.setVerticalGroup(
            panelAvataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvataLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelAvataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAvataLayout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbsubName)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnlophoc.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnlophoc.setText("Lớp học");
        btnlophoc.setFocusPainted(false);
        btnlophoc.setFocusable(false);
        btnlophoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlophocMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnlophocMousePressed(evt);
            }
        });

        btnthanhvien.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnthanhvien.setFocusable(false);
        btnthanhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthanhvienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnthanhvienMousePressed(evt);
            }
        });

        btnbaitap.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnbaitap.setFocusable(false);
        btnbaitap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbaitapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnbaitapMousePressed(evt);
            }
        });

        btnbangdiem.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnbangdiem.setFocusable(false);
        btnbangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbangdiemMouseClicked(evt);
            }
        });
        btnbangdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbangdiemActionPerformed(evt);
            }
        });

        btntrangchu.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btntrangchu.setText("Trang Chủ");
        btntrangchu.setFocusable(false);
        btntrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrangchuActionPerformed(evt);
            }
        });

        btntaikhoan.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btntaikhoan.setText("Tài Khoản");
        btntaikhoan.setFocusable(false);
        btntaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntaikhoanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btntaikhoanMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        btnOutSetting.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnOutSetting.setForeground(new java.awt.Color(255, 0, 0));
        btnOutSetting.setText("Đăng Xuất");
        btnOutSetting.setBorder(null);
        btnOutSetting.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnOutSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnOutSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAvata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntrangchu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbangdiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbaitap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthanhvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlophoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAvata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnlophoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnthanhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnbaitap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnbangdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btntrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btntaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(971, 639));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlophocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlophocMousePressed
        // TODO add your handling code here:
        btnlophoc.setBackground(ClickedColor);
        btnlophoc.setForeground(DefaultColor);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
        
    }//GEN-LAST:event_btnlophocMousePressed

    private void btnthanhvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthanhvienMousePressed
        // TODO add your handling code here:
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(ClickedColor);
        btnthanhvien.setForeground(DefaultColor);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
      
    }//GEN-LAST:event_btnthanhvienMousePressed

    private void btnbaitapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbaitapMousePressed
        // TODO add your handling code here:
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(ClickedColor);
        btnbaitap.setForeground(DefaultColor);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
       
        
    }//GEN-LAST:event_btnbaitapMousePressed

    private void btntaikhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntaikhoanMousePressed
        // TODO add your handling code here:
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(ClickedColor);
        btntaikhoan.setForeground(DefaultColor);
        btnbangdiem.setBackground(DefaultColor);
        btnbangdiem.setForeground(DefaultColor1);
    

    }//GEN-LAST:event_btntaikhoanMousePressed

    private void btnlophocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlophocMouseClicked
        // TODO add your handling code here:
        if (sROLE.equals("Tôi là giáo viên")) {
            Menu_LopHoc lophoc = new Menu_LopHoc();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(lophoc).setVisible(true);
            FLAG = 1;
            if (FLAG == 1) {
                btnthanhvien.setText("Thành Viên");
                btnbaitap.setText("Bài Tập");
                btnbangdiem.setText("Bảng Điểm");
                btnthanhvien.setEnabled(true);
                btnbaitap.setEnabled(true);
                btnbangdiem.setEnabled(true);
            }
        } else {
            Menu_HocSinh hocsinh = new Menu_HocSinh(MALOP);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(hocsinh).setVisible(true);         
            btnbaitap.setText("Bài Tập");
            btnbangdiem.setText("Bảng Điểm");
            btnthanhvien.setText("Thành Viên");
            btnbaitap.setEnabled(true);
            btnbangdiem.setEnabled(true);
            btnthanhvien.setEnabled(true);
        }               
    }//GEN-LAST:event_btnlophocMouseClicked

    private void btnbangdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbangdiemActionPerformed
        // TODO add your handling code here:
        btnlophoc.setBackground(DefaultColor);
        btnlophoc.setForeground(DefaultColor1);
        btnthanhvien.setBackground(DefaultColor);
        btnthanhvien.setForeground(DefaultColor1);
        btnbaitap.setBackground(DefaultColor);
        btnbaitap.setForeground(DefaultColor1);
        btntaikhoan.setBackground(DefaultColor);
        btntaikhoan.setForeground(DefaultColor1);
        btnbangdiem.setBackground(ClickedColor);
        btnbangdiem.setForeground(DefaultColor);
     
    }//GEN-LAST:event_btnbangdiemActionPerformed

    private void btntrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrangchuActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        FLAG = 0;
        if (FLAG == 0) {
            btnthanhvien.setEnabled(false);
            btnbaitap.setEnabled(false);
            btnbangdiem.setEnabled(false);
            btnthanhvien.setText("");
            btnbaitap.setText("");
            btnbangdiem.setText("");
        }
        setDefault();
    }//GEN-LAST:event_btntrangchuActionPerformed

    private void btnthanhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthanhvienMouseClicked
        // TODO add your handling code here:
        if (sROLE.equals("Tôi là giáo viên")) {
            Menu_LopHoc_ThanhVien THANHVIEN = new Menu_LopHoc_ThanhVien("GV", TAIKHOAN);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(THANHVIEN).setVisible(true);
        } else {
            Menu_LopHoc_ThanhVien THANHVIEN = new Menu_LopHoc_ThanhVien("HS", TAIKHOAN);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(THANHVIEN).setVisible(true);
        }
        
    }//GEN-LAST:event_btnthanhvienMouseClicked

    private void btnbaitapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbaitapMouseClicked
        // TODO add your handling code here:
        if (sROLE.equals("Tôi là giáo viên")) {
            Menu_LopHoc_BaiTap BAITAP = new Menu_LopHoc_BaiTap(TAIKHOAN);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(BAITAP).setVisible(true);
        } else {
            Menu_HocSinh_BaiTap menu_HocSinh_BaiTap = new Menu_HocSinh_BaiTap(TAIKHOAN);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(menu_HocSinh_BaiTap).setVisible(true);
        }
        
    }//GEN-LAST:event_btnbaitapMouseClicked

    private void btnbangdiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbangdiemMouseClicked
        // TODO add your handling code here:
        if (sROLE.equals("Tôi là giáo viên")) {
            Menu_LopHoc_BangDiem BANGDIEM = new Menu_LopHoc_BangDiem();
            jDesktopPane1.removeAll();
            jDesktopPane1.add(BANGDIEM).setVisible(true);
        } else {
            Menu_HocSinh_BangDiem menu_HocSinh_BangDiem = new Menu_HocSinh_BangDiem(TAIKHOAN);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(menu_HocSinh_BangDiem).setVisible(true);
        }
        
    }//GEN-LAST:event_btnbangdiemMouseClicked

    private void btntaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntaikhoanMouseClicked
        // TODO add your handling code here:
        Menu_TaiKhoan menu_TaiKhoan = new Menu_TaiKhoan(TAIKHOAN);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(menu_TaiKhoan).setVisible(true);
    }//GEN-LAST:event_btntaikhoanMouseClicked

    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnOutSetting;
    private javax.swing.JButton btnbaitap;
    private javax.swing.JButton btnbangdiem;
    private javax.swing.JButton btnlophoc;
    private javax.swing.JButton btntaikhoan;
    private javax.swing.JButton btnthanhvien;
    private javax.swing.JButton btntrangchu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbsubName;
    private javax.swing.JPanel panelAvata;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
