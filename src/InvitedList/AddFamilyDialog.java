/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvitedList;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author szarkii
 */
public class AddFamilyDialog extends javax.swing.JDialog {

    
    private final InvitersManager invManager;
    private Family family;
    private final JFrameGUI parent;
    
    private boolean editable = false;
    private ArrayList<Invited> invitersBackup = null;
    private int editingFamilyID = -1;
    
    public AddFamilyDialog(JFrameGUI parent, InvitersManager invManager) {
        super(parent, true);
        initComponents();
        
        setLocationRelativeTo(null);
        removeFamilyBtn.setVisible(false);
        
        this.invManager = invManager;
        this.parent = parent;
        
        family = new Family();
        setPersonTypeModel();
    }
    
    public AddFamilyDialog(JFrameGUI parent, InvitersManager invManager, Family editingFamily) {
        this(parent, invManager);
        
        this.editable = true;
        this.editingFamilyID = invManager.getFamilies().indexOf(editingFamily);
        backupInviters(editingFamily);
        
        setTitle("Edytuj Rodzinę");
        removeFamilyBtn.setVisible(true);
        addFamilyBtn.setText("zatwierdź zmiany");
        surnameField.setText(editingFamily.getSurname());
        if (editingFamily.isRequired()) {
            requiredCheckbox.setSelected(true);
        }
        if (editingFamily.isProfitable()) {
            profitableCheckbox.setSelected(true);
        }
        
        family = editingFamily;
        updateInvitersList();
    }
    
    private void backupInviters(Family fam) {
        invitersBackup = new ArrayList(fam.getInviters().size());
        for (Invited inv : fam.getInviters()) {
            invitersBackup.add(new Invited(inv));
        }
    }
    
    private void setPersonTypeModel() {
        final DefaultComboBoxModel model;
        model = new DefaultComboBoxModel(Invited.getInviterTypesDescriptions());
        personType.setModel(model);
    }
    
    private void updateInvitersList() {
        ArrayList<Invited> inviters = family.getInviters();
        String [] descriptions = new String [inviters.size()];
        
        int i = 0;
        for (Invited inv : inviters) {
            descriptions[i++] = inv.getName() + " - " + inv.getDescription();
        }
        
        invitersList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return descriptions.length; }
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

        addingInviter = new javax.swing.JPanel();
        addInviterBtn = new javax.swing.JButton();
        inviterNameLabel = new javax.swing.JLabel();
        personType = new javax.swing.JComboBox<>();
        inviterNameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        requiredCheckbox = new javax.swing.JCheckBox();
        profitableCheckbox = new javax.swing.JCheckBox();
        addFamilyBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invitersList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        removeFamilyBtn = new javax.swing.JButton();
        familyType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj Rodzinę");

        addingInviter.setBorder(javax.swing.BorderFactory.createTitledBorder("Dodaj Członka Rodziny"));

        addInviterBtn.setText("dodaj");
        addInviterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInviterBtnActionPerformed(evt);
            }
        });

        inviterNameLabel.setText("Imię:");

        personType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addingInviterLayout = new javax.swing.GroupLayout(addingInviter);
        addingInviter.setLayout(addingInviterLayout);
        addingInviterLayout.setHorizontalGroup(
            addingInviterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingInviterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingInviterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingInviterLayout.createSequentialGroup()
                        .addComponent(inviterNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(inviterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingInviterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(addingInviterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addInviterBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(personType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        addingInviterLayout.setVerticalGroup(
            addingInviterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingInviterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addingInviterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inviterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inviterNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addInviterBtn))
        );

        surnameLabel.setText("Nazwisko: ");

        surnameField.setToolTipText("wpisz nazwisko rodziny");
        surnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameFieldActionPerformed(evt);
            }
        });

        requiredCheckbox.setText("są wymagani");
        requiredCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requiredCheckboxActionPerformed(evt);
            }
        });

        profitableCheckbox.setText("są opłacalni");
        profitableCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitableCheckboxActionPerformed(evt);
            }
        });

        addFamilyBtn.setText("dodaj");
        addFamilyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFamilyBtnActionPerformed(evt);
            }
        });

        invitersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invitersListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invitersList);

        jLabel2.setText("<html>Lista członków rodziny :<br>\n(dwukrotne kliknięcie usuwa osobę)</html>");

        cancelBtn.setText("anuluj");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        removeFamilyBtn.setText("usuń rodzinę");
        removeFamilyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFamilyBtnActionPerformed(evt);
            }
        });

        familyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familyTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(requiredCheckbox)
                    .addComponent(profitableCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeFamilyBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn))
                    .addComponent(familyType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addingInviter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFamilyBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameLabel)
                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(requiredCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profitableCheckbox)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addingInviter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(familyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addFamilyBtn)
                    .addComponent(removeFamilyBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addingInviter.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void surnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameFieldActionPerformed

    private void requiredCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requiredCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requiredCheckboxActionPerformed

    private void addFamilyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFamilyBtnActionPerformed
        if (family.getInviters().isEmpty()) {
            inviterNameLabel.setForeground(Color.red);
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        
        if (surnameField.getText().equals("")) {
            surnameLabel.setForeground(Color.red);
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        
        family.setSurname(surnameField.getText());
        family.setRequired(requiredCheckbox.isSelected());
        family.setProfitable(profitableCheckbox.isSelected());
        
        if (!editable) {
            invManager.addFamily(family);
        }
        parent.updateFamiliesList();
        parent.updateStatistics();
        this.dispose();
    }//GEN-LAST:event_addFamilyBtnActionPerformed

    private void profitableCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitableCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profitableCheckboxActionPerformed

    private void addInviterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInviterBtnActionPerformed
        if (inviterNameField.getText().equals("")) {
            inviterNameLabel.setForeground(Color.red);
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        
        Invited inv = new Invited(inviterNameField.getText(), 
                Invited.getTypeByDescription((String)personType.getSelectedItem()));
        family.addInviter(inv);

        inviterNameLabel.setForeground(Color.black);
        inviterNameField.setText("");
        updateInvitersList();
    }//GEN-LAST:event_addInviterBtnActionPerformed

    private void personTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personTypeActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (editable) {
            family.setInviters(invitersBackup);
        }
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void invitersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invitersListMouseClicked
        if (evt.getClickCount() == 2) {
            family.removeInviter(invitersList.getSelectedIndex());
            updateInvitersList();
        }
    }//GEN-LAST:event_invitersListMouseClicked

    private void removeFamilyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFamilyBtnActionPerformed
        invManager.removeFamily(this.editingFamilyID);
        parent.updateFamiliesList();
        parent.updateStatistics();
        this.dispose();
    }//GEN-LAST:event_removeFamilyBtnActionPerformed

    private void familyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familyTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_familyTypeActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(AddFamilyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddFamilyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddFamilyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddFamilyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AddFamilyDialog dialog = new AddFamilyDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFamilyBtn;
    private javax.swing.JButton addInviterBtn;
    private javax.swing.JPanel addingInviter;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> familyType;
    private javax.swing.JTextField inviterNameField;
    private javax.swing.JLabel inviterNameLabel;
    private javax.swing.JList<String> invitersList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> personType;
    private javax.swing.JCheckBox profitableCheckbox;
    private javax.swing.JButton removeFamilyBtn;
    private javax.swing.JCheckBox requiredCheckbox;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    // End of variables declaration//GEN-END:variables
}