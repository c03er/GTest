/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction_Management;

import Inventory_Management.*;
import Database_Management.DBConnection;
import Methods.Methods;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import me.Home;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author pasindu
 */
public class Report1 extends javax.swing.JFrame {

    
    private Connection connection = null;
    private Dimension dimension = null;
    private Home home = null;
    public static Home homeStatic = null;
    
    /**
     * Creates new form AddBrand
     */
    public Report1(Home home) {
        initComponents();
        
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
        
        this.home = home;
        this.homeStatic = home;
        
        //obtain a new database connection;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //override windowClosing method
        this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
           closeApplication();
        }
        });
        
    }
    
    @Override
    protected final CloneNotSupportedException clone() throws java.lang.CloneNotSupportedException{
        
        throw new java.lang.CloneNotSupportedException();
    }
    //make the class nonseriallizeable
    private final void writeObject(ObjectOutputStream out) throws java.io.IOException {
        throw new java.io.IOException("Object cannot be serialized");
    }
    
    
    //make the class nondeserializeable 
    private final void readObject(ObjectInputStream in)
        throws java.io.IOException {
        throw new java.io.IOException("Class cannot be deserialized");
    }
    
    private final void closeApplication(){
        home.enable(true);
        this.dispose();
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
        jLabel14 = new javax.swing.JLabel();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD ITEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel14.setText("START DATE");

        jLabel1.setText("END DATE");

        jButton2.setText("GENERATE REPORT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(106, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(63, 63, 63)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30)))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        if(startDate.getDate() == null){
            final JOptionPane newOptionPane = new JOptionPane("Please select the start date", JOptionPane.WARNING_MESSAGE);
            final JDialog newDialog = newOptionPane.createDialog("Warning");
            newDialog.setAlwaysOnTop(true);
            newDialog.setVisible(true);
        }
        else if(endDate.getDate() == null){
            final JOptionPane newOptionPane = new JOptionPane("Please select the end date", JOptionPane.WARNING_MESSAGE);
            final JDialog newDialog = newOptionPane.createDialog("Warning");
            newDialog.setAlwaysOnTop(true);
            newDialog.setVisible(true);
        }
        else{
            
            final Date startDateNew = new Date(startDate.getDate().getTime());
            final Date endDateNew = new Date(endDate.getDate().getTime());
            
            if(endDateNew.before(startDateNew)){
                final JOptionPane newOptionPane = new JOptionPane("Invalid date combination. Please try again", JOptionPane.WARNING_MESSAGE);
                final JDialog newDialog = newOptionPane.createDialog("Warning");
                newDialog.setAlwaysOnTop(true);
                newDialog.setVisible(true);
            }
            else{
                
                String reportPath = null;
                try {
                    final String sqlStatement1 = "drop table if exists report2";
                    PreparedStatement ps1 = connection.prepareStatement(sqlStatement1);
                    ps1.executeUpdate();
                    
                    final String sqlStatement2 = "create table report2 select name as 'Name', sum(quantity) as 'Quantity', (sum(quantity) * sale) as 'Total_Sales', (sum(quantity) * purchase) as 'Total_Purchases' from monthlyreport where date between ? and ? group by itemID, type  order by name, type";
                    PreparedStatement ps2 = connection.prepareStatement(sqlStatement2);
                    ps2.setDate(1, startDateNew);
                    ps2.setDate(2, endDateNew);
                    
                    ps2.executeUpdate();
                    
                    final String sqlStatement3 = "select sum(Total_Sales) as TS, sum(Total_Purchases) as TP from report2";
                    PreparedStatement ps3 = connection.prepareStatement(sqlStatement3);
                    ResultSet rs3 = ps3.executeQuery();
                    
                    float TS = 0;
                    float TP = 0;
                    float S = 0;
                    
                    while(rs3.next()){
                        TS = rs3.getFloat("TS");
                        TP = rs3.getFloat("TP");
                    }
                    
                    System.out.println("Total Sales: " + TS);
                    System.out.println("Total Purchases: "  + TP);
                    System.out.println("Summary: " + (TS - TP));
                    
                    S = TS - TP;
                    
                    try{
                        final String sqlStatement4 = "select path from settings where name=?";
                        PreparedStatement ps4 = connection.prepareStatement(sqlStatement4);
                        ps4.setString(1, "report");
                        
                        ResultSet rs4 = ps4.executeQuery();
                        while(rs4.next()){
                            reportPath = rs4.getString("path");
                        }
                    }
                    catch(SQLException e){
                        final JOptionPane newOptionPane = new JOptionPane("Unable to acquire report path", JOptionPane.WARNING_MESSAGE);
                        final JDialog newDialog = newOptionPane.createDialog("Warning");
                        newDialog.setAlwaysOnTop(true);
                        newDialog.setVisible(true);
                    }
                    
                    if(reportPath.isEmpty() || reportPath == null || reportPath.equals("Report path has not been set")){
                        final JOptionPane newOptionPane = new JOptionPane("Report path has not been configured", JOptionPane.WARNING_MESSAGE);
                        final JDialog newDialog = newOptionPane.createDialog("Warning");
                        newDialog.setAlwaysOnTop(true);
                        newDialog.setVisible(true);
                    }
                    else{
                         
                    
                        try {

                            JasperDesign jd = JRXmlLoader.load(reportPath + "\\Monthly Report.jrxml");

                            Map<String, Object> parameters = new HashMap<String,Object>();
                            parameters.put("startDate",startDateNew.toString());
                            parameters.put("endDate",endDateNew.toString());
                            parameters.put("TS",TS);
                            parameters.put("TP",TP);
                            parameters.put("S",S);

                            final String query = "select * from report2;";
                            JRDesignQuery q = new JRDesignQuery();
                            q.setText(query);
                            jd.setQuery(q);
                            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
                            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
                            JasperViewer.viewReport(jasperPrint, false);

                        } catch (Exception ex) {
                            Logger.getLogger(Report1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                   
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Report1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        closeApplication();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report1(homeStatic).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser startDate;
    // End of variables declaration//GEN-END:variables
}
