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
public class UpdateArtist extends javax.swing.JFrame {

    /**
     * Creates new form UpdateArtist
     */
    private dbConnection db;
    private TP2.AlbumPanel frame;
    private int dbGenre;
    private int idPick;
    private String fileName;
    private String filePath;

    /**
     * Creates new form UpdateAlbum
     */
    public UpdateArtist(TP2.AlbumPanel frame) {
        initComponents();
        db = new dbConnection();
        setTitle("Update Artist");
        this.frame = frame;
        
        genreCBox();
        genreCombo.setSelectedItem(null);
    }
    
    public UpdateArtist(TP2.AlbumPanel frame, int id_artist, String artist_name, String ayear, String image, String genre){
        initComponents();
        db = new dbConnection();
        this.frame = frame;
        
        genreCBox();
        
        fieldArtist.setText(artist_name);
        fieldAYear.setText(ayear);
        genreCombo.setSelectedItem(genre);
        
        idPick = id_artist;
    }
    
     private void genreCBox(){
        String sql = "SELECT * FROM genre";
        ResultSet res = db.selectQuery(sql);
        
        try {
            while(res.next())
            {
                genreCombo.addItem(res.getString("genre_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     public void updateData() throws IOException {
        // Get Data from Form
        String artist = fieldArtist.getText();
        String ayear = fieldAYear.getText();
        String genre = genreCombo.getSelectedItem().toString();
        String image = labelImagePath.getText();
        
        String search = "SELECT * FROM genre WHERE genre_name='"+genre+"'";
        ResultSet res = db.selectQuery(search);
        try {
            if(res.next())
            {
                dbGenre = res.getInt("id_genre");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        // Add New Data
        uploadImage(image);
        String sql = "UPDATE artist SET artist_name='"+artist+"', active_from='"+ayear+"', image='"+image+"', genre='"+dbGenre+"' WHERE id_artist='"+idPick+"'";
        db.updateQuery(sql);
        
        // Show Information
        JOptionPane.showMessageDialog(null, "Data has been successfully updated!");
    }
     
     public void uploadImage(String image) throws IOException{
        String newPath = "src/TP2/img/artist_img/";
        File sourceFile = new File(this.filePath);
        File merge = new File(newPath + image);
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

        jLabel1 = new javax.swing.JLabel();
        fieldArtist = new javax.swing.JTextField();
        fieldAYear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        genreCombo = new javax.swing.JComboBox<>();
        btnUpdateArtist = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        btnUpImage = new javax.swing.JButton();
        labelImagePath = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Artist Name");

        fieldArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldArtistActionPerformed(evt);
            }
        });

        jLabel2.setText("Active From");

        jLabel3.setText("Genre");

        btnUpdateArtist.setText("Update Artist");
        btnUpdateArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateArtistActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        btnUpImage.setText("Upload Image");
        btnUpImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpImageActionPerformed(evt);
            }
        });

        jLabel4.setText("Update Artist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdateArtist)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnUpImage))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldAYear)
                            .addComponent(fieldArtist)
                            .addComponent(genreCombo, 0, 148, Short.MAX_VALUE)
                            .addComponent(labelImagePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpImage)
                    .addComponent(labelImagePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnUpdateArtist)
                .addGap(53, 53, 53)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldArtistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldArtistActionPerformed

    private void btnUpdateArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateArtistActionPerformed
        try {
            // TODO add your handling code here:
            if(labelImagePath.getText().equals("")){
                JOptionPane.showMessageDialog(null, "You haven't selected a cover!");
            }
            else{
                updateData();
                dispose();
                this.frame.setPanelArtist();
            }
        } catch (IOException ex) {
            Logger.getLogger(AddAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateArtistActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void btnUpImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpImageActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        this.fileName = f.getName();
        this.filePath = f.getAbsolutePath();
        labelImagePath.setText(fileName);
    }//GEN-LAST:event_btnUpImageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnUpImage;
    private javax.swing.JButton btnUpdateArtist;
    private javax.swing.JTextField fieldAYear;
    private javax.swing.JTextField fieldArtist;
    private javax.swing.JComboBox<String> genreCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelImagePath;
    // End of variables declaration//GEN-END:variables
}
