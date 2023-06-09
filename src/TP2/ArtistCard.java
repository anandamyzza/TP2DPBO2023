/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TP2;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author anand
 */
public class ArtistCard extends javax.swing.JPanel {
    
    private dbConnection db;
    private String dbGenre;
    private String path = "/TP2/img/artist_img/";
    private TP2.AlbumPanel frame;
    
    private String artistPick;
    private String yearPick;
    private String imagePick;
    private int idPick;

    /**
     * Creates new form ArtistCard
     */
    public ArtistCard(TP2.AlbumPanel frame, String artist_name, String active_year, int genre, String image) {
        initComponents();
        db = new dbConnection();
        this.frame=frame;
        
        String genreSearch = "SELECT * FROM genre WHERE id_genre='"+genre+"'";
        ResultSet res = db.selectQuery(genreSearch);
        
        try {
            if(res.next())
            {
                dbGenre = res.getString("genre_name");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        labelNamaArtist.setText(artist_name);
        labelYear.setText(active_year);
        labelGenre.setText(dbGenre);
        labelImage.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(path + image)).getImage().getScaledInstance(113, 113, Image.SCALE_SMOOTH)));
    
        artistPick = artist_name;
        yearPick = active_year;
        imagePick = image;
        
        String artist = "SELECT * FROM artist WHERE artist_name='"+artist_name+"'";
        ResultSet resArtist = db.selectQuery(artist);
        
        try {
            if(resArtist.next())
            {
                idPick = resArtist.getInt("id_artist");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteData(){
        String del = "DELETE FROM artist WHERE id_artist='"+idPick+"'";
        db.updateQuery(del);
        frame.setPanelArtist();
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
        labelNamaArtist = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelYear = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelGenre = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        labelNamaArtist.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNamaArtist.setText("jLabel1");

        jLabel1.setText("Active from");

        labelYear.setText("jLabel2");

        jLabel2.setText("Genre:");

        labelGenre.setText("jLabel3");

        labelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelImage.setPreferredSize(new java.awt.Dimension(113, 113));

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNamaArtist)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelYear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelGenre)))
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelNamaArtist)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(labelYear))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(labelGenre)))
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_NO_OPTION == opsi)
        {
            deleteData();
            JOptionPane.showMessageDialog(null, "Data has been successfully deleted!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        UpdateArtist update = new UpdateArtist(frame, idPick, artistPick, yearPick, imagePick, dbGenre);
        update.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelGenre;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelNamaArtist;
    private javax.swing.JLabel labelYear;
    // End of variables declaration//GEN-END:variables
}
