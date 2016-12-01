package TelaInicial;

import TelaAluguel.*;
import TelasFuncionario.*;
import DAOJPA.DAOJPA;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.ItemDeProduto;
import Modelo.Produto;
import ModeloTabela.AluguelTabelaModelo;
import ModeloTabela.FuncionarioTabelaModelo;
import ModeloTabela.ItemDeProdutoTabelaModelo;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class ListarAluguelTela extends javax.swing.JFrame {

    private List<ItemDeProduto> listaProdutos;

    private Aluguel aluguel = new Aluguel();
    private Aluguel aluguelSelecionado = new Aluguel();

    public ListarAluguelTela() {
        initComponents();

        labelTotalGeral.setText("0");
    }

    public void setListaProdutos(List<ItemDeProduto> listaProdutos) {
        this.listaProdutos = listaProdutos;
        Pesquisar();
        totalGeral();

    }

    public void preencherTabela() {
        ItemDeProdutoTabelaModelo modelo = new ItemDeProdutoTabelaModelo(listaProdutos);
        tabelaListaProdutos.setModel(modelo);
    }

    public void Pesquisar() {
        preencherTabela();
    }

    //--------------------------metodos abaixo para consultar item de produto------------------------------------------
    public Aluguel aluguelSelecionado() {
        //aluguelSelecionado = listaProdutos.get(tabelaListaProdutos.getSelectedRow());
        return aluguelSelecionado;
    }

    public void selecionarLinhaTabela(java.awt.event.MouseEvent evt) {
        tabelaListaProdutos.clearSelection();
        int linha = tabelaListaProdutos.rowAtPoint(evt.getPoint());
        tabelaListaProdutos.setRowSelectionInterval(linha, linha);
    }

    public void abrirTelaConsulta() {
        /* FuncionarioConsultaTela consultaTela = new FuncionarioConsultaTela();
        consultaTela.setFuncionario(aluguelSelecionado());
        consultaTela.setVisible(true);*/
    }

    public void totalGeral() {
        double total;
        total = 0;
        for (int i = 0; i < listaProdutos.size(); i++) {
            total = total + listaProdutos.get(i).getTotalParcial();
        }
        labelTotalGeral.setText(String.valueOf(total));
    }

    public void esvaziarLista() {
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i).getProduto();
            int qtde = listaProdutos.get(i).getQuantidade();
            produto.setQuantidade(produto.getQuantidade() + qtde);
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
            em.close();
        }
        listaProdutos.clear();
        JOptionPane.showMessageDialog(null, "Lista Esvaziada!!!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListaProdutos = new javax.swing.JTable();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoCadastrar3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelTotalGeral = new javax.swing.JLabel();
        botaoEsvaziarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Alugueis");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 253, 253));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Alugueis");

        tabelaListaProdutos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelaListaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Produto", "Categoria", "Quantidade", "Valor"
            }
        ));
        tabelaListaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaListaProdutosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaListaProdutos);

        botaoCadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar.setText("Remover");
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

        botaoCadastrar3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCadastrar3.setText("Alterar");
        botaoCadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrar3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor Total Geral");

        labelTotalGeral.setText("$$$$$$$$");

        botaoEsvaziarLista.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoEsvaziarLista.setText("Esvaziar");
        botaoEsvaziarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEsvaziarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCadastrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(labelTotalGeral))
                                    .addComponent(botaoEsvaziarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar)
                        .addGap(11, 11, 11)
                        .addComponent(botaoCadastrar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoEsvaziarLista)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalGeral)
                        .addGap(27, 27, 27)
                        .addComponent(botaoCancelar)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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

    private void tabelaListaProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaListaProdutosMouseReleased
        aluguelSelecionado();
        selecionarLinhaTabela(evt);
        if (evt.getClickCount() > 1) {
            abrirTelaConsulta();
        }
    }//GEN-LAST:event_tabelaListaProdutosMouseReleased

    private void botaoCadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrar3ActionPerformed

    private void botaoEsvaziarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEsvaziarListaActionPerformed
        esvaziarLista();
    }//GEN-LAST:event_botaoEsvaziarListaActionPerformed

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
            java.util.logging.Logger.getLogger(ListarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarAluguelTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAluguelTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCadastrar3;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEsvaziarLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelTotalGeral;
    private javax.swing.JTable tabelaListaProdutos;
    // End of variables declaration//GEN-END:variables
}
