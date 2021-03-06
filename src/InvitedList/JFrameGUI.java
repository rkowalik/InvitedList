package InvitedList;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public final class JFrameGUI extends javax.swing.JFrame {
    
    private final String DATABASE_PATH = "database.ser";

    private final DataManager dbManager;
    private final InvitedManager invManager;
    private final InvitedStatistics statistics;
    
    public JFrameGUI() throws FileNotFoundException, IOException, ClassNotFoundException {
        initComponents();
        
        dbManager = new SerializeManager(DATABASE_PATH);
        invManager = dbManager.getData();
        statistics = new InvitedStatistics(invManager);
        
        adultCostField.setValue(invManager.getAdultCost());
        childCostField.setValue(invManager.getChildCost());
        
        updateFamiliesList();
        updateStatistics();
    }
    
    public void updateStatistics() {
        statistics.calculate();
        int all = statistics.getAdultSum() + (statistics.getAdultWithCompSum() * 2) +
                statistics.getChildAsAdultSum() + statistics.getChildSum();
        int adults = statistics.getAdultSum() + (statistics.getAdultWithCompSum() * 2);
        float adultsCost = adults * invManager.getAdultCost();
        float allCost = (adults + statistics.getChildAsAdultSum()) * invManager.getAdultCost() + statistics.getChildSum() * invManager.getChildCost();
        
        String stats;
        stats = String.format(" Łącznie zaproszono %d osób, w tym:\n   %-3d rodzin(y)\n   %-3d dorosłych - %.2f zł\n   %-3d dzieci liczonych jako dorosłych - %.2f zł\n   %-3d dzieci - %.2f zł\n Całkowity koszt: %.2f zł",
                all, invManager.getFamilies().size(), adults, adultsCost, statistics.getChildAsAdultSum(), statistics.getChildAsAdultSum() * invManager.getAdultCost(), statistics.getChildSum(), statistics.getChildSum() * invManager.getChildCost(), allCost);
        
        statisticsField.setText(stats);
    }
    
    private String formatFamilyEntry(Family fam) {
        char r = 'N', p = 'N';
        if (fam.isRequired()) r = 'T'; 
        if (fam.isProfitable()) p = 'T';
        
        return String.format("%-20s  %2d /%2d %9s %c/%c %6s %.50s", fam.getSurname(),
                fam.getAdultCostQty(), fam.getChildSum(), "", r, p, "", fam.getInvitedNames());
    }
    
    public boolean showFamily(Family fam) {
        if (allRadio.isSelected())
            return true;
        if (requiredRadio.isSelected())
            return fam.isRequired();
        else
            return fam.isProfitable();
    }
    
    public void updateFamiliesList() {
        invManager.sortFamilies();
        ArrayList<Family> families = invManager.getFamilies();
        String [] descriptions = new String [families.size()];
        
        int i = 0;
        for (Family fam : families) {
            if(showFamily(fam))
                descriptions[i] = formatFamilyEntry(fam);
            ++i;
        }
                
        familiesList.setModel(new javax.swing.AbstractListModel<String>() {
            @Override
            public int getSize() { return descriptions.length; }
            @Override
            public String getElementAt(int i) { return descriptions[i]; }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterFamilies = new javax.swing.ButtonGroup();
        invitersListContainer = new javax.swing.JScrollPane();
        familiesList = new javax.swing.JList<>();
        statisticsContainer = new javax.swing.JScrollPane();
        statisticsField = new javax.swing.JTextPane();
        writeDatabase = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        adultCostLabel = new javax.swing.JLabel();
        childCostLabel = new javax.swing.JLabel();
        addFamilyBtn = new javax.swing.JButton();
        childCostField = new JFormattedTextField(NumberFormat.getNumberInstance());
        adultCostField = new JFormattedTextField(NumberFormat.getNumberInstance());
        jLabel1 = new javax.swing.JLabel();
        profitableRadio = new javax.swing.JRadioButton();
        requiredRadio = new javax.swing.JRadioButton();
        allRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista Gości");

        familiesList.setFont(new java.awt.Font("Courier", 0, 12)); // NOI18N
        familiesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                familiesListMouseClicked(evt);
            }
        });
        invitersListContainer.setViewportView(familiesList);

        statisticsField.setEditable(false);
        statisticsField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 222)));
        statisticsField.setMargin(new java.awt.Insets(25, 255, 3, 3));
        statisticsField.setName(""); // NOI18N
        statisticsField.setSelectedTextColor(new java.awt.Color(222, 222, 222));
        statisticsContainer.setViewportView(statisticsField);

        writeDatabase.setText("zapisz");
        writeDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeDatabaseActionPerformed(evt);
            }
        });

        jLabel4.setText("   [rodzina]                             [dorośli / dzieci]  [wymagani / opłacalni]");

        adultCostLabel.setLabelFor(adultCostField);
        adultCostLabel.setText("koszt osoby dorosłej: ");

        childCostLabel.setLabelFor(childCostField);
        childCostLabel.setText("koszt dziecka: ");

        addFamilyBtn.setText("dodaj rodzinę");
        addFamilyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFamilyBtnActionPerformed(evt);
            }
        });

        childCostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childCostFieldActionPerformed(evt);
            }
        });
        childCostField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                childCostFieldKeyReleased(evt);
            }
        });

        adultCostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adultCostFieldActionPerformed(evt);
            }
        });
        adultCostField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adultCostFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adultCostFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("wyświetlanie:");

        filterFamilies.add(profitableRadio);
        profitableRadio.setText("opłacalni");
        profitableRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitableRadioActionPerformed(evt);
            }
        });

        filterFamilies.add(requiredRadio);
        requiredRadio.setText("wymagani");
        requiredRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requiredRadioActionPerformed(evt);
            }
        });

        filterFamilies.add(allRadio);
        allRadio.setSelected(true);
        allRadio.setText("wszyscy");
        allRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invitersListContainer)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addFamilyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(writeDatabase))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statisticsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adultCostLabel)
                            .addComponent(childCostLabel))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adultCostField)
                            .addComponent(childCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(allRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profitableRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(requiredRadio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invitersListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(profitableRadio)
                    .addComponent(requiredRadio)
                    .addComponent(allRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statisticsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adultCostLabel)
                            .addComponent(adultCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(childCostLabel)
                            .addComponent(childCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFamilyBtn)
                    .addComponent(writeDatabase))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addFamilyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFamilyBtnActionPerformed
        AddFamilyDialog dialog = new AddFamilyDialog(this, invManager);
        dialog.setVisible(true);
    }//GEN-LAST:event_addFamilyBtnActionPerformed

    private void writeDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeDatabaseActionPerformed
        if(dbManager.writeData(invManager)) {
            JOptionPane.showMessageDialog(null, "Pomyślnie zapisano bazę danych.", 
                    "Zapisano", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Błąd przy zapisie bazy danych.", 
                    "Błąd", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_writeDatabaseActionPerformed

    private void childCostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childCostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_childCostFieldActionPerformed

    private void adultCostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adultCostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adultCostFieldActionPerformed

    private void adultCostFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adultCostFieldKeyTyped
        
    }//GEN-LAST:event_adultCostFieldKeyTyped

    private void adultCostFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adultCostFieldKeyReleased
        try {
            float cost = Float.parseFloat(adultCostField.getText());        
            invManager.setAdultCost(cost);
            updateStatistics();
            adultCostLabel.setForeground(Color.black);
        } catch (NumberFormatException e) {
            adultCostLabel.setForeground(Color.red);
        }
    }//GEN-LAST:event_adultCostFieldKeyReleased

    private void childCostFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_childCostFieldKeyReleased
        try {
            float cost = Float.parseFloat(childCostField.getText());        
            invManager.setChildCost(cost);
            updateStatistics();
            childCostLabel.setForeground(Color.black);
        } catch (NumberFormatException e) {
            childCostLabel.setForeground(Color.red);
        }
    }//GEN-LAST:event_childCostFieldKeyReleased

    private void familiesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_familiesListMouseClicked
        if (evt.getClickCount() == 2) {
            Family fam = invManager.getFamilies().get(familiesList.getSelectedIndex());
            AddFamilyDialog dialog = new AddFamilyDialog(this, invManager, fam);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_familiesListMouseClicked

    private void allRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRadioActionPerformed
        updateFamiliesList();
        updateStatistics();
    }//GEN-LAST:event_allRadioActionPerformed

    private void profitableRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitableRadioActionPerformed
        updateFamiliesList();
        updateStatistics();
    }//GEN-LAST:event_profitableRadioActionPerformed

    private void requiredRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requiredRadioActionPerformed
        updateFamiliesList();
        updateStatistics();
    }//GEN-LAST:event_requiredRadioActionPerformed

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        
        
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
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameGUI().setVisible(true);    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JFrameGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFrameGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFamilyBtn;
    private javax.swing.JFormattedTextField adultCostField;
    private javax.swing.JLabel adultCostLabel;
    private javax.swing.JRadioButton allRadio;
    private javax.swing.JFormattedTextField childCostField;
    private javax.swing.JLabel childCostLabel;
    private javax.swing.JList<String> familiesList;
    private javax.swing.ButtonGroup filterFamilies;
    private javax.swing.JScrollPane invitersListContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton profitableRadio;
    private javax.swing.JRadioButton requiredRadio;
    private javax.swing.JScrollPane statisticsContainer;
    private javax.swing.JTextPane statisticsField;
    private javax.swing.JButton writeDatabase;
    // End of variables declaration//GEN-END:variables
}
