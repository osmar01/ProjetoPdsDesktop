
package TelaAluguel;

import TelasFuncionario.*;
import DAOJPA.DAOJPA;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Funcionario;
import ModeloTabela.AluguelTabelaModelo;
import ModeloTabela.FuncionarioTabelaModelo;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


public class AluguelCadastraTela extends javax.swing.JFrame {
    private List<Aluguel> listaAluguel = new ArrayList<>();
    
    private Aluguel aluguel = new Aluguel();
    private Aluguel aluguelSelecionado = new Aluguel();
   
    public AluguelCadastraTela() {
        initComponents();
        Pesquisar();
    }
    
    public void preencherFiltro(){
        Cliente cliente = new Cliente();
        cliente.setNome(campoNome.getText());
        aluguel.setClienteAluguel(cliente);
    }
   
    public void pesquisarBD(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DAOJPA<Aluguel> dao = new DAOJPA<>(entityManager,Aluguel.class);
        listaAluguel = dao.listar(aluguel.getClienteAluguel().getNome());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void preencherTabela(){
        AluguelTabelaModelo modelo = new AluguelTabelaModelo(listaAluguel);
        tabelaAluguel.setModel(modelo);
    }
    
    public void Pesquisar(){
        preencherFiltro();
        pesquisarBD();
        preencherTabela();
    }
    //--------------------------metodos abaixo para consultar funcionario------------------------------------------
    public Aluguel aluguelSelecionado(){
        aluguelSelecionado = listaAluguel.get(tabelaAluguel.getSelectedRow());
        return aluguelSelecionado;
    }
    public void selecionarLinhaTabela(java.awt.event.MouseEvent evt){
        tabelaAluguel.clearSelection();
        int linha = tabelaAluguel.rowAtPoint(evt.getPoint());
        tabelaAluguel.setRowSelectionInterval(linha, linha);
    }
    
    public void abrirTelaConsulta(){
       /* FuncionarioConsultaTela consultaTela = new FuncionarioConsultaTela();
        consultaTela.setFuncionario(aluguelSelecionado());
        consultaTela.setVisible(true);*/
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAluguel = new javax.swing.JTable();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoCadastrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluguel1 = new javax.swing.JTable();
        botaoCadastrar3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoNome1 = new javax.swing.JTextField();
        botaoPesquisar1 = new javax.swing.JButton();
        botaoCadastrar4 = new javax.swing.JButton();
        botaoCadastrar5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Funcionario");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 253, 253));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Alugueis");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("CPF");

        campoNome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        botaoPesquisar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoPesquisar.setText("Pesquisar");

        tabelaAluguel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Status"
            }
        ));
        tabelaAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaAluguelMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAluguel);

        botaoCadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar.setText("Inciar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoCadastrar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar1.setText("Detalhes");
        botaoCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrar1ActionPerformed(evt);
            }
        });

        tabelaAluguel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaAluguel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Hora inicio", "Status"
            }
        ));
        tabelaAluguel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaAluguel1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAluguel1);

        botaoCadastrar3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar3.setText("Detalhes");
        botaoCadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrar3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("CPF");

        campoNome1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        botaoPesquisar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoPesquisar1.setText("Pesquisar");

        botaoCadastrar4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar4.setText("Devolucao");
        botaoCadastrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrar4ActionPerformed(evt);
            }
        });

        botaoCadastrar5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar5.setText("Retirar da Lista");
        botaoCadastrar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCadastrar4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCadastrar5, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(botaoCadastrar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrar5)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastrar4)))
                .addGap(18, 18, 18)
                .addComponent(botaoCancelar)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        FuncionarioCadastraTela cadastraTela = new FuncionarioCadastraTela();
        cadastraTela.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Pesquisar();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabelaAluguelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAluguelMouseReleased
        aluguelSelecionado();
        selecionarLinhaTabela(evt);
        if(evt.getClickCount() > 1){
            abrirTelaConsulta();
        }
    }//GEN-LAST:event_tabelaAluguelMouseReleased

    private void botaoCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar1ActionPerformed

    private void tabelaAluguel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAluguel1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAluguel1MouseReleased

    private void botaoCadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar3ActionPerformed

    private void botaoCadastrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar4ActionPerformed

    private void botaoCadastrar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar5ActionPerformed

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
            java.util.logging.Logger.getLogger(AluguelCadastraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AluguelCadastraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AluguelCadastraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AluguelCadastraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AluguelCadastraTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCadastrar1;
    private javax.swing.JButton botaoCadastrar3;
    private javax.swing.JButton botaoCadastrar4;
    private javax.swing.JButton botaoCadastrar5;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoPesquisar1;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNome1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaAluguel;
    private javax.swing.JTable tabelaAluguel1;
    // End of variables declaration//GEN-END:variables
}
