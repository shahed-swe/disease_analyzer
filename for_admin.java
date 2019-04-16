/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disease_analyzer;

import static disease_analyzer.hospital_registration.age_validation;
import static disease_analyzer.hospital_registration.email_validation;
import static disease_analyzer.hospital_registration.id_validation;
import static disease_analyzer.hospital_registration.phone_validation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class for_admin extends javax.swing.JFrame {

    /**
     * Creates new form for_admin
     */
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public for_admin() {
        initComponents();
    }
    public ArrayList<admin> userList_1(String search_list){
        ArrayList<admin> userList = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select * From `admin`  Where `admin_id` = "+search_list+"";
        try{
            ps = myconnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            admin admin;
            while(rs.next()){
                admin = new admin(rs.getInt("admin_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"),rs.getString("user_name"),rs.getString("password"),rs.getString("age"),rs.getString("phone"),rs.getString("address"));
                userList.add(admin);
            }
        }catch(SQLException ex){
            Logger.getLogger(for_admin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Not found!!");
        }
        return userList;
        
    }
    public ArrayList<doctor> userList_2(String search_list){
        ArrayList<doctor> userList = new ArrayList<>();
        PreparedStatement ps;
        String query = "Select * From `doctor`  Where `doctor_id` = "+search_list+"";
        try{
            ps = myconnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            doctor doctor;
            while(rs.next()){
                doctor = new doctor(rs.getInt("doctor_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"),rs.getString("user_name"),rs.getString("password"),rs.getString("age"),rs.getString("phone"),rs.getString("address"));
                userList.add(doctor);
            }
        }catch(SQLException ex){
            Logger.getLogger(for_admin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Not found!!");
        }
        return userList;
        
    }
    public ArrayList<user> userList_3(String search_list){
        ArrayList<user> userList = new ArrayList<>();
        PreparedStatement ps;
        String query = "SELECT * FROM `user`  WHERE `user_id` = "+search_list+"";
        try{
            ps = myconnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            user user;
            while(rs.next()){
                user = (user) new user(rs.getInt("user_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"),rs.getString("user_name"),rs.getString("password"),rs.getString("age"),rs.getString("phone"),rs.getString("address"));
                userList.add(user);
            }
        }catch(SQLException ex){
            Logger.getLogger(for_admin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Not found!!");
        }
        return userList;
        
    }
    public void show_users_admin(){
        ArrayList<admin> list = userList_1(u_search.getText());
        DefaultTableModel model = (DefaultTableModel)datatable.getModel();
        Object[] row = new Object[]{"User Id","First Name","Last Name","E-mail","User Name","Password","Age","Phone No","Address"};
        for(int  i = 0;i < list.size();i++){
            row[0] = list.get(i).get_admin_id();
            row[1] = list.get(i).get_first_name();
            row[2] = list.get(i).get_last_name();
            row[3] = list.get(i).get_email();
            row[4] = list.get(i).get_user_name();
            row[5] = list.get(i).get_password();
            row[6] = list.get(i).get_age();
            row[7] = list.get(i).get_phone_number();
            row[8] = list.get(i).get_address();
            model.addRow(row);
        }
    }
    public void show_users_doctor(){
        ArrayList<doctor> list = userList_2(u_search.getText());
        DefaultTableModel model = (DefaultTableModel)datatable.getModel(); 
        Object[] row = new Object[]{"User Id","First Name","Last Name","E-mail","User Name","Password","Age","Phone No","Address"};
        for(int  i = 0;i < list.size();i++){
            row[0] = list.get(i).get_doctor_id();
            row[1] = list.get(i).get_first_name();
            row[2] = list.get(i).get_last_name();
            row[3] = list.get(i).get_email();
            row[4] = list.get(i).get_user_name();
            row[5] = list.get(i).get_password();
            row[6] = list.get(i).get_age();
            row[7] = list.get(i).get_phone_number();
            row[8] = list.get(i).get_address();
            model.addRow(row);
        }
    }
    public void show_users_user(){
        ArrayList<user> list = userList_3(u_search.getText());
        DefaultTableModel model = (DefaultTableModel)datatable.getModel();
        Object[] row = new Object[]{"User Id","First Name","Last Name","E-mail","User Name","Password","Age","Phone No","Address"};
        for(int  i = 0;i < list.size();i++){
            row[0] = list.get(i).get_user_id();
            row[1] = list.get(i).get_first_name();
            row[2] = list.get(i).get_last_name();
            row[3] = list.get(i).get_email();
            row[4] = list.get(i).get_user_name();
            row[5] = list.get(i).get_password();
            row[6] = list.get(i).get_age();
            row[7] = list.get(i).get_phone_number();
            row[8] = list.get(i).get_address();
            model.addRow(row);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        u_phone = new javax.swing.JTextField();
        u_age = new javax.swing.JTextField();
        u_address = new javax.swing.JTextField();
        u_email = new javax.swing.JTextField();
        u_lname = new javax.swing.JTextField();
        u_fname = new javax.swing.JTextField();
        u_id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jbtnupdate = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        u_search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        selector = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jpass = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        u_user = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        msg_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImage/send button.png"))); // NOI18N
        msg_send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msg_sendMouseClicked(evt);
            }
        });

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_send)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome To Admin Panel");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("ID Number:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("First Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Last Name:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Address:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Age:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Phone Number:");

        jbtnupdate.setBackground(new java.awt.Color(213, 184, 255));
        jbtnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnupdate.setText("Update");
        jbtnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnupdateActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(213, 184, 255));
        search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "First Name", "Last Name", "E-mail", "User Name", "Password", "Age", "Phone No", "Address"
            }
        ));
        datatable.setGridColor(new java.awt.Color(255, 102, 255));
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datatableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(datatable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("User Id :");

        selector.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Doctor", "User" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Select:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Password:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("User Name:");

        jButton2.setBackground(new java.awt.Color(213, 184, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jbtnupdate))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(u_search, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(u_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_email, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_id, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpass, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_user, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_age, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(u_address, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(u_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(u_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(u_email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_user, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(u_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(u_address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(u_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_textActionPerformed

    private void msg_sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_sendMouseClicked
        
        try {
            String msgout = "";
            msgout = msg_text.getText().trim();
            dout.writeUTF(msgout);
        } catch (IOException ex) {
            Logger.getLogger(for_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_msg_sendMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hospital_login hreg = new hospital_login();
        hreg.setVisible(true);
        hreg.pack();
        hreg.setLocationRelativeTo(null);
        hreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnupdateActionPerformed
        String id = u_id.getText();
        String fname = u_fname.getText();
        String lname = u_lname.getText();
        String email = u_email.getText();
        String username = u_user.getText();
        String pass = String.valueOf(jpass.getPassword());
        String address = u_address.getText();
        String age = u_age.getText();
        String phone = u_phone.getText();
        String searchid = u_search.getText();
        String select = (String) selector.getSelectedItem().toString(); //selecting the options
        PreparedStatement ps;
        String query2 = "";
        switch (select) {
            case "Admin":
                if(id_validation(id) == false){
                    JOptionPane.showMessageDialog(null, "User id formation is not right");
                }
                else if(email_validation(email) == false){
                    JOptionPane.showMessageDialog(null, "Email formation is not right");
                }
                else if(age_validation(age) == false){
                    JOptionPane.showMessageDialog(null, "Age Formation is not right");
                }
                else if(phone_validation(phone) == false){
                    JOptionPane.showMessageDialog(null, "Phone number formation is not right");
                }
                else{
                    query2 = "UPDATE `admin` SET `admin_id`=?,`first_name`=?,`last_name`=?,`email`=?,`user_name`=?,`password`=?,`age`=?,`phone`=?, `address`=? WHERE `admin_id`=?";
                }
                break;
            case "Doctor":
                if(id_validation(id) == false){
                    JOptionPane.showMessageDialog(null, "User id formation is not right");
                }
                else if(email_validation(email) == false){
                    JOptionPane.showMessageDialog(null, "Email formation is not right");
                }
                else if(age_validation(age) == false){
                    JOptionPane.showMessageDialog(null, "Age Formation is not right");
                }
                else if(phone_validation(phone) == false){
                    JOptionPane.showMessageDialog(null, "Phone number formation is not right");
                }
                else{
                    query2 = "UPDATE `doctor` SET `doctor_id`=?,`first_name`=?,`last_name`=?,`email`=?,`user_name`=?,`password`=?,`age`=?,`phone`=?, `address`=? WHERE `doctor_id`=?";
                }
                break;
            default:
                if(id_validation(id) == false){
                    JOptionPane.showMessageDialog(null, "User id formation is not right");
                }
                else if(email_validation(email) == false){
                    JOptionPane.showMessageDialog(null, "Email formation is not right");
                }
                else if(age_validation(age) == false){
                    JOptionPane.showMessageDialog(null, "Age Formation is not right");
                }
                else if(phone_validation(phone) == false){
                    JOptionPane.showMessageDialog(null, "Phone number formation is not right");
                }
                else{
                    query2 = "UPDATE `user` SET `user_id`=?,`first_name`=?,`last_name`=?,`email`=?,`user_name`=?,`password`=?,`age`=?,`phone`=?, `address`=? WHERE `user_id`=?";
                }
                break;
        }
        try {
            ps = myconnection.getConnection().prepareCall(query2);
            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setString(5, username);
            ps.setString(6, pass);
            ps.setString(7, age);
            ps.setString(8, phone);
            ps.setString(9, address);
            ps.setString(10, searchid);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, select+" Data Updated Successfully!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(for_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnupdateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String select = (String) selector.getSelectedItem().toString();
        if(select.equals("Admin")){
            show_users_admin();
        }
        else if(select.equals("Doctor")){
            show_users_doctor();
        }
        else if(select.equals("User")){
            show_users_user();
        }
    }//GEN-LAST:event_searchActionPerformed

    private void datatableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyPressed
        
    }//GEN-LAST:event_datatableKeyPressed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        int i = datatable.getSelectedRow();
        TableModel model = datatable.getModel();
        u_id.setText(model.getValueAt(i, 0).toString());
        u_fname.setText(model.getValueAt(i, 1).toString());
        u_lname.setText(model.getValueAt(i, 2).toString());
        u_email.setText(model.getValueAt(i, 3).toString());
        u_user.setText(model.getValueAt(i, 4).toString());
        jpass.setText(model.getValueAt(i, 5).toString());
        u_age.setText(model.getValueAt(i, 8).toString());
        u_phone.setText(model.getValueAt(i, 7).toString());
        u_address.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_datatableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        u_id.setText("");
        u_fname.setText("");
        u_lname.setText("");
        u_email.setText("");
        u_user.setText("");
        jpass.setText("");
        u_age.setText("");
        u_phone.setText("");
        u_address.setText("");
        DefaultTableModel model = (DefaultTableModel)datatable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static boolean email_validation(String email){
        String emailregex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
        Pattern pat1 = Pattern.compile(emailregex);
        if(email == null){
            return false;
        }
        else
            return pat1.matcher(email).matches();
    }
    public static boolean age_validation(String age){
        String ageregex = "^\\d+$";
        
        Pattern pat2 = Pattern.compile(ageregex);
        if(age == null)
            return false;
        return pat2.matcher(age).matches();
        
    }
    public static boolean phone_validation(String f_phone){
        String phoneregex = "^\\d+$";
        
        Pattern pat3 = Pattern.compile(phoneregex);
        if(f_phone == null){
            return false;
        }
        return pat3.matcher(f_phone).matches();
    }
    public static boolean id_validation(String userid){
        String idregex = "^\\d+$";
        
        Pattern pat4 = Pattern.compile(userid);
        if(userid == null){
            return false;
        }
        return pat4.matcher(userid).matches();
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
            java.util.logging.Logger.getLogger(for_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(for_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(for_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(for_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new for_admin().setVisible(true);
            }
        });
        String msgin = "";
        try{
            ss = new ServerSocket(1201); //server starts at 1201 port number
            s = ss.accept(); //new server will accepts thae connections
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while(!msgin.equals("exit")){
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim()+"\n"+msgin); //displaying the message from client
            }
            
        }catch(Exception e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnupdate;
    private javax.swing.JPasswordField jpass;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JLabel msg_send;
    private javax.swing.JTextField msg_text;
    private javax.swing.JButton search;
    public javax.swing.JComboBox<String> selector;
    private javax.swing.JTextField u_address;
    private javax.swing.JTextField u_age;
    private javax.swing.JTextField u_email;
    private javax.swing.JTextField u_fname;
    private javax.swing.JTextField u_id;
    private javax.swing.JTextField u_lname;
    private javax.swing.JTextField u_phone;
    private javax.swing.JTextField u_search;
    private javax.swing.JTextField u_user;
    // End of variables declaration//GEN-END:variables
}
