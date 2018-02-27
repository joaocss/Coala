/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Mode.dao.AlunoDao;
import Model.bean.Aluno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RG 295
 */
public class TeladeNotas extends javax.swing.JFrame {

    
    
    public double calcMedia(String [] tx){
        double media = 0;
        int qt=0;
            for(int i = 0; i < tx.length; i++){
                media+= Double.parseDouble(tx[i]);
                qt++;
            }
            return media/qt;
    }

     public void armengue(int tamanho,DefaultTableModel dfm, Aluno a, String[] tx){
            switch(tamanho){
                case 0:
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome()
                
                });
           //  dfm.setValueAt(calcMedia(tx), dfm.getRowCount(), 10);  
                    break;
                case 1:
   
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),
                tx[0],"","","","","",calcMedia(tx)
                  // calcMedia(tx)
                });

          //  alunos.setValueAt(calcMedia(tx), dfm.getRowCount(), 9);
                    break;
                case 2:
     
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],"","","","",calcMedia(tx)
                //calcMedia(tx)

                });
//            dfm.setValueAt(calcMedia(tx), dfm.getRowCount(), 10);
                    break;
                case 3:
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2],"","","",calcMedia(tx)
              //  calcMedia(tx)

                });
                    break;
                case 4:
              
               
            dfm.addRow(new Object[]{
               a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2],
                tx[3],"","",calcMedia(tx)
            //    calcMedia(tx)
             
                });
                    break;
                case 5:
   
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
               tx[1],
                tx[2],
                tx[3],
                tx[4],"",calcMedia(tx)
                
                });
                    break;
        }
}
     public void armengue2(int tamanho,DefaultTableModel dfm, Aluno a, String[] tx){
            switch(tamanho){
                case 0:
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome()
                
                });
           //  dfm.setValueAt(calcMedia(tx), dfm.getRowCount(), 10);  
                    break;
                case 1:
   
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),
                tx[0],"","","","",""//,calcMedia(tx)
                  // calcMedia(tx)
                });

          //  alunos.setValueAt(calcMedia(tx), dfm.getRowCount(), 9);
                    break;
                case 2:
     
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],"","","",""//,calcMedia(tx)
                //calcMedia(tx)

                });
//            dfm.setValueAt(calcMedia(tx), dfm.getRowCount(), 10);
                    break;
                case 3:
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2],"","",""//,calcMedia(tx)
              //  calcMedia(tx)

                });
                    break;
                case 4:
              
               
            dfm.addRow(new Object[]{
               a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2],
                tx[3],"",""//,calcMedia(tx)
            //    calcMedia(tx)
             
                });
                    break;
                case 5:
   
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getId(),
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
               tx[1],
                tx[2],
                tx[3],
                tx[4],""//,calcMedia(tx)
                
                });
                    break;
        }
}

    
    public void mostrar(List<Aluno> alu)  { // joga dados da lista na tabela
        DefaultTableModel dfm = (DefaultTableModel) alunos.getModel(); //pega o modelo da tabela
        dfm.setNumRows(0);//setando os dados apartir da coluna zero da Jtable
        
        for (Aluno a : alu) {
            String[] tx = {" "};
            if (a.getNotas() != null){
            // cria o vetor de string para receber a splint q he o a string desconcatenada
           tx = a.getNotas().split(";");//desconcatenar a string notas  
            }
            armengue2(tx.length,dfm,a,tx);

        }  
}
    public void mostraMedia(List<Aluno> alu)  { // joga dados da lista na tabela
        DefaultTableModel dfm = (DefaultTableModel) alunos.getModel(); //pega o modelo da tabela
        dfm.setNumRows(0);//setando os dados apartir da coluna zero da Jtable
        
        for (Aluno a : alu) {
            String[] tx = {"0.0"};
            if (a.getNotas() != null){
            // cria o vetor de string para receber a splint q he o a string desconcatenada
           tx = a.getNotas().split(";");//desconcatenar a string notas  
            }
            armengue(tx.length,dfm,a,tx);

        }  
}
    
    
    public TeladeNotas() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        und = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        calcmedia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 539));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("MOSTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("INSERIR NOTA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nota.setBackground(new java.awt.Color(51, 0, 102));
        nota.setForeground(new java.awt.Color(255, 255, 255));
        nota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        alunos.setBackground(new java.awt.Color(255, 255, 255));
        alunos.setForeground(new java.awt.Color(0, 0, 0));
        alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME DO ALUNO", "TURMA", "NOME DA ESCOLA", "N01", "N02", "N03", "N04", "N05", "N06", "MÉDIA"
            }
        ));
        alunos.setGridColor(new java.awt.Color(0, 0, 0));
        alunos.setSelectionBackground(new java.awt.Color(51, 0, 102));
        alunos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(alunos);
        if (alunos.getColumnModel().getColumnCount() > 0) {
            alunos.getColumnModel().getColumn(0).setMaxWidth(40);
            alunos.getColumnModel().getColumn(1).setMaxWidth(400);
            alunos.getColumnModel().getColumn(2).setMaxWidth(75);
            alunos.getColumnModel().getColumn(3).setMaxWidth(300);
            alunos.getColumnModel().getColumn(4).setMaxWidth(40);
            alunos.getColumnModel().getColumn(5).setMaxWidth(40);
            alunos.getColumnModel().getColumn(6).setMaxWidth(40);
            alunos.getColumnModel().getColumn(7).setMaxWidth(40);
            alunos.getColumnModel().getColumn(8).setMaxWidth(40);
            alunos.getColumnModel().getColumn(9).setMaxWidth(40);
            alunos.getColumnModel().getColumn(10).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOTA:");

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        und.setBackground(new java.awt.Color(51, 0, 102));
        und.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º - UNIDADE", "2º - UNIDADE", "3º - UNIDADE", "4º - UNIDADE", "5º - UNIDADE", "6º - UNIDADE" }));
        und.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("ALTERAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        calcmedia.setBackground(new java.awt.Color(255, 255, 255));
        calcmedia.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        calcmedia.setForeground(new java.awt.Color(0, 0, 0));
        calcmedia.setText("CALCULAR MEDIA");
        calcmedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcmediaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(und, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calcmedia)
                        .addGap(163, 163, 163))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nota)
                        .addComponent(und, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4)
                        .addComponent(jButton1)
                        .addComponent(calcmedia)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AlunoDao aluno = new AlunoDao();
        //try {
            mostrar(aluno.pegaNotas());
       // } catch (Exception ex) {
         //   System.out.println("erro  ao mostrar  " + ex.getMessage());
       // }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AlunoDao aluno = new AlunoDao();

        if (aluno.InsertNotas((int)alunos.getValueAt(alunos.getSelectedRow(), 0), Double.parseDouble(nota.getText()),und.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "NOTA INSERIDA");
        } else {
            JOptionPane.showMessageDialog(this, "NOTA NÃO INSERIDA! CERTIFIQUE-SE DE QUE A NOTA AO QUAL VOCÊ ESTA INSERINDO CORRESPONDE COM A UNIDADE");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AlunoDao aluno = new AlunoDao();
        
           if( aluno.alterarNota(Double.parseDouble(nota.getText()), und.getSelectedItem().toString(),(int)alunos.getValueAt(alunos.getSelectedRow(), 0))){
               JOptionPane.showMessageDialog(this, "NOTA ALTERADA");
           }else{
               JOptionPane.showMessageDialog(this, "NOTA NÃO ALTERADA");
           }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void calcmediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcmediaActionPerformed
        // TODO add your handling code here:
              AlunoDao aluno = new AlunoDao();
        //try {
            mostraMedia(aluno.pegaNotas());
        
    }//GEN-LAST:event_calcmediaActionPerformed

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
            java.util.logging.Logger.getLogger(TeladeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeladeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeladeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeladeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeladeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunos;
    private javax.swing.JButton calcmedia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nota;
    private javax.swing.JComboBox<String> und;
    // End of variables declaration//GEN-END:variables
}
