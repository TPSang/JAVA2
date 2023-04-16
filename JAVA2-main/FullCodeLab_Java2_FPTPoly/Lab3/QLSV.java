/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS14885_NguyenDoDuyAn_Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLSV extends javax.swing.JFrame {
// Nắm giữ danh sách sinh viên nhập từ người dùng
    List<Student> list = new ArrayList<>();
    
    public void addStudent(){
    //tạo sinh viên với thông tin nhập từ form
    Student sv = new Student();
    sv.name = txtHoTen.getText();
    sv.marks = Double.parseDouble(txtDiem.getText());
    sv.major = (String) cboNganh.getSelectedItem();
    // Bổ sung sinh viên vào list<Student>        
    list.add(sv);
    //Hiển thị học lực và phần thưởng
    txtHocLuc.setText(sv.getGrade());
    chkThuong.setSelected(sv.isBonus());
    }
    public void removeStudent(){
    //xóa xinh viên tại vị trí được chọn trên bảng
        int index = tblStudents.getSelectedRow();
        list.remove(index);
    } 
    public void updateStudent(){
    //Lấy sinh viên được chọn tawij vị trí trên bảng
        int index = tblStudents.getSelectedRow();
        Student sv = list.get(index);
        //Cập nhật lại thông tin mới từ form  
        sv.name = txtHoTen.getText();
        sv.marks = Double.parseDouble(txtDiem.getText());
        sv.major = (String) cboNganh.getSelectedItem();
        txtHocLuc.setText(sv.getGrade());
        chkThuong.setSelected(sv.isBonus());
    } 
    public void fillToTable(){
    //lấy mô hình dữ liệu của bảng và xóa sạch các hàng
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);
    //Duyệt list<Student> và bổ sung các sinh viên vào bảng
        for (Student sv : list) {
            Object[] row = new Object[]{sv.name,sv.marks,sv.major,sv.getGrade(),sv.isBonus()};
            model.addRow(row);        
        } 
    } 
    public void showDetail(){
    //Lấy sinh viên tại vị trí được chọn trên bảng
     int index = tblStudents.getSelectedRow();
     Student sv = list.get(index);
    //Cập nhật lại thông tin mới từ form
        txtHoTen.setText(sv.getName());
        txtDiem.setText(sv.marks+"");
        cboNganh.setSelectedItem(sv.major);
        txtHocLuc.setText(sv.getGrade());
        chkThuong.setSelected(sv.isBonus());
    }
    @Override
    public void list() {
        super.list(); //To change body of generated methods, choose Tools | Templates.
    }

    public QLSV() {
        initComponents();
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtHocLuc = new javax.swing.JTextField();
        cboNganh = new javax.swing.JComboBox();
        chkThuong = new javax.swing.JCheckBox();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        btnSXTheoTen = new javax.swing.JButton();
        SXTheoDiem = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("HỌ VÀ TÊN");

        jLabel3.setText("ĐIỂM");

        jLabel4.setText("NGÀNH");

        jLabel5.setText("HỌC LỰC");

        cboNganh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ứng dụng phần mềm", "Thiết kế đồ họa", "Thiết kế website", "Lập trình android" }));

        chkThuong.setSelected(true);
        chkThuong.setText("Có phần thưởng?");

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapnhat.setText("CẬP NHẬT");
        btnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatActionPerformed(evt);
            }
        });

        btnNew.setText("NHẬP MỚI");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudents);

        btnSXTheoTen.setText("Sắp xếp theo tên");
        btnSXTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTheoTenActionPerformed(evt);
            }
        });

        SXTheoDiem.setText("Sắp xếp theo điểm");
        SXTheoDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SXTheoDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                                    .addComponent(txtDiem)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCapnhat)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnNew))
                                    .addComponent(chkThuong)
                                    .addComponent(txtHocLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSXTheoTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SXTheoDiem)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHocLuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(chkThuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnCapnhat)
                            .addComponent(btnNew)))
                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSXTheoTen)
                    .addComponent(SXTheoDiem))
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtHoTen.setText("");
        txtDiem.setText("");
        txtHocLuc.setText("");
        chkThuong.setSelected(false);
              
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
      this.addStudent();//Thêm sinh viên vào list<Student>
      this.fillToTable();//Hiển thị list<Student> lên bảng
      
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        this.showDetail();
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.removeStudent();//Xóa sinh viên khỏi List<Student>
        this.fillToTable();//Hiển thị lại bảng
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        this.updateStudent();//Cập nhật thông tin sinh viên
        this.fillToTable();//Hiển thị lại bảng    
    }//GEN-LAST:event_btnCapnhatActionPerformed

    private void btnSXTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTheoTenActionPerformed
        this.orderByName();//gọi phương thức sắp xếp theo tên
        this.fillToTable();//Hiển thị lại bảng
    }//GEN-LAST:event_btnSXTheoTenActionPerformed

    private void SXTheoDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SXTheoDiemActionPerformed
        this.orderByMarks();//gọi phương thức sắp xếp theo điểm
        this.fillToTable();//Hiển thị lại bảng
    }//GEN-LAST:event_SXTheoDiemActionPerformed

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
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SXTheoDiem;
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSXTheoTen;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cboNganh;
    private javax.swing.JCheckBox chkThuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocLuc;
    // End of variables declaration//GEN-END:variables

    private void orderByName() {
       Comparator<Student> com = new Comparator<Student>(){
        @Override
        public int compare(Student o1,Student o2) {
        return o1.name.compareTo(o2.name);
       }
    };
        Collections.sort(list,com);
    }
    
    private void orderByMarks() {
       Comparator<Student> com = new Comparator<Student>(){
        @Override
        public int compare(Student o1,Student o2) {
       Double d1 = o1.marks;
       Double d2 = o2.marks;        
       return d1.compareTo(d2);
       }
    };
        Collections.sort(list,com);
    }
}
