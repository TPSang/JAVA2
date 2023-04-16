/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assginment;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class frmQuanLyNhanVien extends javax.swing.JFrame {

    NhanVien nv = null;
    int timerun = 0;
    List<NhanVien> listdsnv = new ArrayList<>();
    ArrayList<String> dsnv = new ArrayList<>();
    DefaultTableModel model;
    FileInputStream fis;
    int currentIndex = 0;

    public frmQuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        combobox();            
        thoigian();

    }


    private void combobox() {
        DefaultComboBoxModel cbo = new DefaultComboBoxModel();
        cbo.removeAllElements();
        cbo.addElement("Phòng Kế toán");
        cbo.addElement("Phòng Nhân Sự");
        cbo.addElement("Phòng Kỹ Thuật");
        cbo.addElement("Phòng Kinh Doanh");
        cbo.addElement("Phòng Đại Diện");
        phongban.setModel(cbo);
    }



    private void showItem(int index) {
        try {

            nv = listdsnv.get(index);
            txtmanv.setText(nv.hoVaTen);
            txtmanv.setText(nv.maNhanVien);
            txthovaten.setText(nv.hoVaTen);
            txttuoi.setText(String.valueOf(nv.tuoi));
            txtgmail.setText(nv.gmail);
            nv.pb = (String) phongban.getSelectedItem();
            txtluong.setText(String.valueOf(nv.luong));

        } catch (Exception e) {
        }
    }

    private void first() {
        try {
            showItem(0);
            btnfirst.setEnabled(false);
            btnprevious.setEnabled(false);
        } catch (Exception e) {
        }
    }

    private void previous() {
        try {

            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = 0;
            }
            showItem(currentIndex);
        } catch (Exception e) {
        }
    }

    private void next() {
        try {

            currentIndex++;
            if (currentIndex > listdsnv.size() - 1) {
                currentIndex = listdsnv.size() - 1;
            }
            showItem(currentIndex);

        } catch (Exception e) {
        }
    }

    private void last() {
        try {

            showItem(listdsnv.size() - 1);
        } catch (Exception e) {
        }
    }

    public void thoigian() {
        new Thread() {
            public void run() {
                while (timerun == 0) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    String day_night = "";
                    if (AM_PM == 1) {
                        day_night = "PM";
                    } else {
                        day_night = "AM";
                    }
                    String str = hour + ":" + minute + ":" + second + " " + day_night;
                    timelabt.setText(str);
                }

            }
        }.start();

    }

    public boolean kiemtratrung(String ma) {
        boolean trave = false;
        for (int i = 0; i < listdsnv.size(); i++) {
            if (listdsnv.get(i).maNhanVien.equalsIgnoreCase(ma) == true) {
                trave = true;
            }
        }
        return trave;
    }

    public void add() {
        nv = new NhanVien();
        try {

            nv.maNhanVien = txtmanv.getText();
            if (kiemtratrung(txtmanv.getText()) == true) {
                JOptionPane.showMessageDialog(this, "trùng tên, nhập tên khác");
                return;
            }
            if (nv.maNhanVien.length() == 0) {
                txtmanv.setBackground(Color.RED);
                JOptionPane.showMessageDialog(this, "mời nhập lại mã");
                return;
            }

        } catch (Exception e) {
        }
        try {
            boolean a = true;
            nv.hoVaTen = txthovaten.getText();

            if (nv.hoVaTen.length() == 0) {
                txthovaten.setBackground(Color.RED);
                JOptionPane.showConfirmDialog(this, "bạn mời bạn nhập họ và tên");
                return;
            }

        } catch (Exception e) {
        }

        try {
            nv.tuoi = Integer.parseInt(txttuoi.getText());
            if (nv.tuoi >= 16 && nv.tuoi <= 55) {
            }              
            else {
                txttuoi.setBackground(Color.RED);
                txttuoi.setText("");
                JOptionPane.showMessageDialog(this, "mời bạn nhập lại tuổi .. từ 16 > 55");
                return;
            }

        } catch (Exception e) {

        }
        try {
            nv.gmail = txtgmail.getText();
            String pattern = "^[\\w-_\\.]+\\@[\\w&&[^0-9]]+\\.[\\w&&[^0-9]]+$";
            if (nv.gmail.matches(pattern)) {
            } else {
                txtgmail.setBackground(Color.RED);
                JOptionPane.showMessageDialog(this, "mời bạn nhập lại gmail");
                txtgmail.setText("");
                return;
            }
        } catch (Exception e) {
        }
        try {
            nv.luong = Integer.parseInt(txtluong.getText());
            if (nv.luong > 5000000) {
            } else {
                txtluong.setBackground(Color.RED);
                txtluong.setText("");
                JOptionPane.showMessageDialog(this, "lương phải trên 5 trai nhé");
                return;
            }

        } catch (Exception e) {
        }

        nv.pb = (String) phongban.getSelectedItem().toString();
        listdsnv.add(nv);

    }

//    private static boolean checknumber(String cho) {
//        for (int i = 0; i < cho.length(); i++) {
//            if (Character.isDigit(cho.charAt(i))) {
//
//            } else {
//                return false;
//            }
//
//        }
//
//        return true;
//
//    }
//    public void find() {
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < listdsnv.size(); i++) {
//            if (listdsnv.get(i).maNhanVien.equalsIgnoreCase(txtmanv.getText())) {
//                a = 1;
//                txtmanv.setText(listdsnv.get(i).maNhanVien);
//                txthovaten.setText(listdsnv.get(i).hoVaTen);
//                txttuoi.setText(Integer.toString(listdsnv.get(i).tuoi));
//                txtgmail.setText(listdsnv.get(i).gmail);
//                txtluong.setText(Integer.toString(listdsnv.get(i).luong));
//                phongban.setToolTipText(listdsnv.get(i).toString());
//                ImageIcon icon = new ImageIcon(listdsnv.get(i).toString());
//                //    timkiem.setIcon(icon);
//            } else {
//
//            }
//        }
//        if (a == 1) {
//            JOptionPane.showMessageDialog(this, "Đã tìm thấy !");
//        } else {
//            JOptionPane.showMessageDialog(this, "Không tìm thấy !");
//        }
//    }
    
    public void newmoi() {
        try {
            txtmanv.setText("");
            txthovaten.setText("");
            txtgmail.setText("");
            txttuoi.setText("");
            txtluong.setText("");
        } catch (Exception e) {
        }
    }

    public void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\java2\\data.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listdsnv);
            oos.close();
            fos.close();
        } catch (Exception e) {

        }
    }

    public void open() {
        try {
            fis = new FileInputStream("D:\\java2\\data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            listdsnv = (List<NhanVien>) data;
            fis.close();
            ois.close();
            JOptionPane.showMessageDialog(this, "đọc file thành công");
        } catch (Exception e) {

        }

    }

    public void delete() {
        try {

            int xoa = table.getSelectedRow();
            listdsnv.remove(xoa);
        } catch (Exception e) {
        }
    }

    public void exit() {
       System.exit(0);
    }

    public void hienthi() {
        try {

            model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (NhanVien nv : listdsnv) {
                Object[] row = new Object[]{
                    nv.maNhanVien, nv.hoVaTen, nv.pb, nv.tuoi, nv.gmail, nv.luong
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

//    private void search() {
//        ArrayList<NhanVien> dsnv = new ArrayList<>();
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txthovaten = new javax.swing.JTextField();
        txttuoi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        txtgmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phongban = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        timelabt = new javax.swing.JLabel();
        timkiem = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        btnfind = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        btnprevious = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnnew = new javax.swing.JButton();
        tabs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));
        setMinimumSize(new java.awt.Dimension(1316, 800));
        getContentPane().setLayout(null);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Và Tên", "Phòng Ban", "Tuổi", "Egmail", "Lương"
            }
        ));
        jScrollPane2.setViewportView(Table);

        jSplitPane2.setRightComponent(jScrollPane2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ThôngTin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 204, 0))); // NOI18N

        txthovaten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txthovatenMouseClicked(evt);
            }
        });
        txthovaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthovatenActionPerformed(evt);
            }
        });

        txttuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttuoiMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Tuổi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Họ Và Tên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã Nhân Viên");

        txtmanv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtmanvMouseClicked(evt);
            }
        });
        txtmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanvActionPerformed(evt);
            }
        });

        txtgmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtgmailMouseClicked(evt);
            }
        });
        txtgmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgmailActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Lương");

        txtluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtluongMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Phòng Ban");

        phongban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phongbanActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(63, 63, 63)
                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(phongban, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(28, 28, 28)
                            .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(2, 2, 2)
                            .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(71, 71, 71)
                        .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phongban, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel4);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"01", "TPS", "Phòng Kế toán", "21", "yauisd@gmail.com", "5100000"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Và Tên", "Phòng Ban", "Tuổi", "Email", "Lương"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jSplitPane2.setRightComponent(jScrollPane1);

        getContentPane().add(jSplitPane2);
        jSplitPane2.setBounds(10, 100, 1270, 350);

        btnDelete.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(200, 490, 119, 70);

        btnexit.setBackground(new java.awt.Color(102, 102, 102));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnexit.setText("Exit");
        btnexit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(940, 580, 123, 70);

        timelabt.setBackground(new java.awt.Color(51, 51, 0));
        timelabt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        timelabt.setForeground(new java.awt.Color(255, 0, 0));
        timelabt.setText("time");
        getContentPane().add(timelabt);
        timelabt.setBounds(1140, 20, 134, 44);

        timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemActionPerformed(evt);
            }
        });
        timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                timkiemKeyReleased(evt);
            }
        });
        getContentPane().add(timkiem);
        timkiem.setBounds(450, 600, 261, 35);

        btnOpen.setBackground(new java.awt.Color(102, 102, 102));
        btnOpen.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnOpen.setText("Open");
        btnOpen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpen);
        btnOpen.setBounds(200, 610, 129, 70);

        btnfind.setBackground(new java.awt.Color(102, 102, 102));
        btnfind.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnfind.setText("Find");
        btnfind.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });
        getContentPane().add(btnfind);
        btnfind.setBounds(770, 580, 130, 70);

        btnsave.setBackground(new java.awt.Color(102, 102, 102));
        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnsave.setText("Save");
        btnsave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave);
        btnsave.setBounds(30, 610, 129, 70);

        btnlast.setBackground(new java.awt.Color(102, 102, 102));
        btnlast.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnlast.setText(">>");
        btnlast.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });
        getContentPane().add(btnlast);
        btnlast.setBounds(850, 470, 68, 34);

        btnprevious.setBackground(new java.awt.Color(102, 102, 102));
        btnprevious.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnprevious.setText("<");
        btnprevious.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnprevious);
        btnprevious.setBounds(660, 470, 64, 34);

        btnfirst.setBackground(new java.awt.Color(102, 102, 102));
        btnfirst.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnfirst.setText("<<");
        btnfirst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnfirst);
        btnfirst.setBounds(750, 470, 63, 33);

        btnnext.setBackground(new java.awt.Color(102, 102, 102));
        btnnext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnnext.setText(">");
        btnnext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        getContentPane().add(btnnext);
        btnnext.setBounds(950, 470, 65, 36);

        btnnew.setBackground(new java.awt.Color(102, 102, 102));
        btnnew.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnnew.setText("New");
        btnnew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        getContentPane().add(btnnew);
        btnnew.setBounds(30, 490, 129, 70);
        getContentPane().add(tabs);
        tabs.setBounds(0, -20, 1370, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtegmailActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
    }

    private void phongbanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txthovatenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {
        this.exit();
    }


    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        open();
        hienthi();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        first();

    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
        hienthi();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        newmoi();

    }//GEN-LAST:event_btnnewActionPerformed

    private void txtgmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgmailActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        add();
        hienthi();
        save();

    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
        previous();

    }//GEN-LAST:event_btnpreviousActionPerformed

    private void timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timkiemKeyReleased

    }//GEN-LAST:event_timkiemKeyReleased

    private void timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timkiemActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        next();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
        last();
    }//GEN-LAST:event_btnlastActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//       if(evt.MOUSE_CLICKED==2){
//        try {
//
//            model = (DefaultTableModel) table.getModel();
//            txtmanv.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
//            txthovaten.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
//            phongban.setToolTipText(model.getValueAt(table.getSelectedRow(), 2).toString());
//            txttuoi.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
//            txtgmail.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
//            txtluong.setText(model.getValueAt(table.getSelectedRow(), 5).toString());
//        } catch (Exception e) {
//        }
//       }

if(evt.getClickCount()==1){
            this.currentIndex=table.getSelectedRow();
            txtmanv.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
            txthovaten.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
            phongban.setToolTipText(model.getValueAt(table.getSelectedRow(), 2).toString());
            txttuoi.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
            txtgmail.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
            txtluong.setText(model.getValueAt(table.getSelectedRow(), 5).toString());
        
}
    }//GEN-LAST:event_tableMouseClicked

    NhanVien getForm(){
     NhanVien nv = new NhanVien();
      txthovaten.setText(nv.getHoVaTen());
    txtgmail.setText(nv.getGmail());
    txtluong.setText( String.valueOf(nv.getLuong()));
    txtmanv.setText(nv.getMaNhanVien());
    txttuoi.setText(String.valueOf(nv.getTuoi()));
    phongban.setSelectedItem(phongban.getSelectedItem());
         return nv;  
    }
    void setForm(NhanVien nv){
    txthovaten.setText(nv.getHoVaTen());
    txtgmail.setText(nv.getGmail());
    txtluong.setText( String.valueOf(nv.getLuong()));
    txtmanv.setText(nv.getMaNhanVien());
    txttuoi.setText(String.valueOf(nv.getTuoi()));
    phongban.setSelectedItem(phongban.getSelectedItem());
    }
    private void txtgmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtgmailMouseClicked
        txtgmail.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtgmailMouseClicked

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvActionPerformed

    private void txtmanvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtmanvMouseClicked
        txtmanv.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtmanvMouseClicked

    private void txthovatenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txthovatenMouseClicked
        txthovaten.setBackground(Color.WHITE);
    }//GEN-LAST:event_txthovatenMouseClicked

    private void txttuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttuoiMouseClicked
        txttuoi.setBackground(Color.WHITE);
    }//GEN-LAST:event_txttuoiMouseClicked

    private void txtluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtluongMouseClicked
        txtluong.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtluongMouseClicked

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
      
        model.setRowCount(0);
        ArrayList<NhanVien> ds = new ArrayList<>();
        try {

            if (timkiem.getText().length() != 0) {
                for (NhanVien v : listdsnv) {
                    if (v.getMaNhanVien().toLowerCase().matches(".*" + timkiem.getText() + ".*")) {
                        ds.add(v);
                    }
                }
                if (ds.isEmpty()) {
                    JOptionPane.showConfirmDialog(rootPane, "không tìm thấy");
                } else {
                    for (NhanVien v : ds) {
                        Object[] row = new Object[]{
                            v.maNhanVien, v.hoVaTen, v.pb, v.tuoi, v.gmail, v.luong
                        };
                        model.addRow(row);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "nhập thông tin để tìm kiếm");
            }
    }//GEN-LAST:event_btnfindActionPerformed
 catch (Exception e) {
        }
       
    }    /**/
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
            java.util.logging.Logger.getLogger(frmQuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JComboBox<String> phongban;
    private javax.swing.JTable table;
    private javax.swing.JLabel tabs;
    private javax.swing.JLabel timelabt;
    private javax.swing.JTextField timkiem;
    private javax.swing.JTextField txtgmail;
    private javax.swing.JTextField txthovaten;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txttuoi;
    // End of variables declaration//GEN-END:variables

}
