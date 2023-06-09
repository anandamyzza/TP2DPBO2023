/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author anand
 */
public class AddAlbum extends javax.swing.JFrame {
    private dbConnection db;
    private int dbArtist;
    private TP2.AlbumPanel frame;
    private String fileName;
    private String filePath;

    /**
     * Creates new form AddAlbum
     */
    public AddAlbum(TP2.AlbumPanel frame) {
        initComponents();
        db = new dbConnection();
        setTitle("Add Album");
        this.frame = frame;
        
        albumCBox();
        artistCombo.setSelectedItem(null);
    }
    
    private void albumCBox(){
        String sql = "SELECT * FROM artist";
        ResultSet res = db.selectQuery(sql);
        
        try {
            while(res.next())
            {
                artistCombo.addItem(res.getString("artist_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void insertData() throws IOException {
        // Get Data from Form
        String album = fieldAlbum.getText();
        String year = fieldRYear.getText();
        String artist = artistCombo.getSelectedItem().toString();
        String cover = fileName;
        
        String search = "SELECT * FROM artist WHERE artist_name='"+artist+"'";
        ResultSet res = db.selectQuery(search);
        try {
            if(res.next())
            {
                dbArtist = res.getInt("id_artist");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        // Add New Data
        uploadCover(cover);
        String sql = "INSERT INTO album VALUES (NULL, '"+album+"', '"+year+"', '"+dbArtist+"', '"+cover+"')";
        db.updateQuery(sql);
        
        // Show Information
        JOptionPane.showMessageDialog(null, "Data has been successfully added!");
    }
    
    public void uploadCover(String cover) throws IOException{
        String newPath = "src/TP2/img/cover_album/";
        File sourceFile = new File(this.filePath);
        File merge = new File(newPath + cover);
        Files.copy(sourceFile.toPath(), merge.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldAlbum = new javax.swing.JTextField();
        fieldRYear = new javax.swing.JTextField();
        artistCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        btnAddAlbum = new javax.swing.JButton();
        btnUpCover = new javax.swing.JButton();
        labelCoverPath = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAlbumActionPerformed(evt);
            }
        });

        jLabel1.setText("Album Name");

        jLabel2.setText("Release Year");

        jLabel3.setText("Artist");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        btnAddAlbum.setText("Add Album");
        btnAddAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlbumActionPerformed(evt);
            }
        });

        btnUpCover.setText("Upload Cover");
        btnUpCover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpCoverActionPerformed(evt);
            }
        });

        jLabel4.setText("Add Album");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddAlbum)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(btnUpCover))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldRYear)
                                    .addComponent(fieldAlbum)
                                    .addComponent(artistCombo, 0, 148, Short.MAX_VALUE)
                                    .addComponent(labelCoverPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel4)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpCover)
                    .addComponent(labelCoverPath))
                .addGap(18, 18, 18)
                .addComponent(btnAddAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAlbumActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void btnAddAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlbumActionPerformed
        try {
            // TODO add your handling code here:
            if(labelCoverPath.getText().equals("")){
                JOptionPane.showMessageDialog(null, "You haven't selected a cover!");
            }
            else{
                insertData();
                dispose();
                this.frame.setPanelAlbum();
            }
        } catch (IOException ex) {
            Logger.getLogger(AddAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddAlbumActionPerformed

    private void btnUpCoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpCoverActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        this.fileName = f.getName();
        this.filePath = f.getAbsolutePath();
        labelCoverPath.setText(fileName);
    }//GEN-LAST:event_btnUpCoverActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddAlbum().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> artistCombo;
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnAddAlbum;
    private javax.swing.JButton btnUpCover;
    private javax.swing.JTextField fieldAlbum;
    private javax.swing.JTextField fieldRYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelCoverPath;
    // End of variables declaration//GEN-END:variables
}
