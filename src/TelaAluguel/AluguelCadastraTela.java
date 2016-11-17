
package TelaAluguel;

import TelasFuncionario.*;
import DAOJPA.DAOJPA;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.ItemDeProduto;
import ModeloTabela.AluguelTabelaModelo;
import ModeloTabela.FuncionarioTabelaModelo;
import ModeloTabela.ReservaTabelaModelo;
import Util.JPAUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;


public class AluguelCadastraTela extends javax.swing.JFrame {
    private List<ItemDeProduto> listaReservas = new ArrayList<>();
    private List<Aluguel> listaAlugueis = new ArrayList<>();
    
    private ItemDeProduto itemDeProdutoSelecionado = new ItemDeProduto();
   
    public AluguelCadastraTela() {
        initComponents();
        AtualizarReserva();
        AtualizarAluguel();
    }
    
    
   //----------------Atualizar Reserva------------------------------------------
    public void pesquisarBDReserva(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        DAOJPA<ItemDeProduto> dao = new DAOJPA<>(em,ItemDeProduto.class);
        listaReservas = dao.listarStatus("Pendente");
        em.getTransaction().commit();
        em.close();
    }
    
    public void preencherTabelaReserva(){
        ReservaTabelaModelo modelo = new ReservaTabelaModelo(listaReservas);
        tabelaReservas.setModel(modelo);
    }
    
    public void AtualizarReserva(){
        pesquisarBDReserva();
        preencherTabelaReserva();
    }
    
    //---------------------------Atualizar Aluguel------------------------------
    
    public void pesquisarBDAluguel(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        DAOJPA<Aluguel> dao = new DAOJPA<>(em,Aluguel.class);
        listaAlugueis = dao.listarStatus("Em Andamento");
        em.getTransaction().commit();
        em.close();
    }
    
    public void preencherTabelaAluguel(){
        AluguelTabelaModelo modelo = new AluguelTabelaModelo(listaAlugueis);
        tabelaAluguel.setModel(modelo);
    }
    
    public void AtualizarAluguel(){
        pesquisarBDAluguel();
        preencherTabelaAluguel();
    }
    
    
    //---------------------------Inserindo Aluguel------------------------------
    public void inserirAluguel(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("HH:mm:ss.SSS");
        String formattedDate = formato.format(date);
        
        Aluguel aluguel = new Aluguel();
        
        aluguelSelecionado();        
        Cliente cliente = em.find(Cliente.class,itemDeProdutoSelecionado.getCliente().getId());
        
        itemDeProdutoSelecionado.setStatus("Em Andamento");
        em.merge(itemDeProdutoSelecionado);
        
        aluguel.setClienteAluguel(cliente);
        aluguel.setHoraInicio(formattedDate);
        aluguel.setStatus("Em Andamento");
        DAOJPA<Aluguel> dao = new DAOJPA<>(em,Aluguel.class);
        
        dao.Inserir(aluguel);
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Aluguel Iniciado!!!");
        
    }
    
    
    //--------------------------metodos abaixo para consultar Item de Produto---
    public ItemDeProduto aluguelSelecionado(){
        itemDeProdutoSelecionado = listaReservas.get(tabelaReservas.getSelectedRow());
        return itemDeProdutoSelecionado;
    }
    public void selecionarLinhaTabela(java.awt.event.MouseEvent evt){
        tabelaReservas.clearSelection();
        int linha = tabelaReservas.rowAtPoint(evt.getPoint());
        tabelaReservas.setRowSelectionInterval(linha, linha);
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
        campoCPF = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        botaoIniciar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoCadastrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluguel = new javax.swing.JTable();
        botaoCadastrar3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoNome1 = new javax.swing.JTextField();
        botaoPesquisar1 = new javax.swing.JButton();
        botaoCadastrar4 = new javax.swing.JButton();
        botaoCadastrar5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

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

        campoCPF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        botaoPesquisar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoPesquisar.setText("Pesquisar");

        tabelaReservas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Status", "Valor Total"
            }
        ));
        tabelaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaReservasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaReservas);

        botaoIniciar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoIniciar.setText("Inciar");
        botaoIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIniciarActionPerformed(evt);
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

        tabelaAluguel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Hora inicio", "Status"
            }
        ));
        tabelaAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaAluguelMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAluguel);

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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
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
                                    .addComponent(botaoIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator3))))
                .addGap(19, 19, 19))
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
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrar5)))
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarActionPerformed
        inserirAluguel();
        AtualizarReserva();
        AtualizarAluguel();
        
    }//GEN-LAST:event_botaoIniciarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        AtualizarReserva();
        AtualizarAluguel();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabelaReservasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReservasMouseReleased
        aluguelSelecionado();
        selecionarLinhaTabela(evt);
        if(evt.getClickCount() > 1){
            abrirTelaConsulta();
        }
    }//GEN-LAST:event_tabelaReservasMouseReleased

    private void botaoCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar1ActionPerformed

    private void tabelaAluguelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAluguelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAluguelMouseReleased

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
    private javax.swing.JButton botaoCadastrar1;
    private javax.swing.JButton botaoCadastrar3;
    private javax.swing.JButton botaoCadastrar4;
    private javax.swing.JButton botaoCadastrar5;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoIniciar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoPesquisar1;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoNome1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tabelaAluguel;
    private javax.swing.JTable tabelaReservas;
    // End of variables declaration//GEN-END:variables
}
