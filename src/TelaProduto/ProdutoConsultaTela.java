package TelaProduto;

import TelasFuncionario.*;
import Modelo.Funcionario;
import Modelo.Produto;
import Util.JPAUtil;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ProdutoConsultaTela extends javax.swing.JFrame {
    private Produto produto;
  
    public ProdutoConsultaTela() {
        initComponents();
    }
    public void setProduto(Produto produto){
        this.produto = produto;
        setLabels();
    }
    public void setLabels(){
        labelNome.setText(produto.getNome());
        labelDescricao.setText(produto.getDescricao());
        labelCategoria.setText(produto.getCategoria().getNome());
        labelPreco.setText(produto.getPreco().toString());
        labelQtde.setText(Integer.toString(produto.getQuantidade()));
        
        String dir = new File("").getAbsolutePath();
        String caminho = dir + File.separator + "src" + File.separator + "Imagens" + File.separator + produto.getCaminho();
        
        ImageIcon img = new ImageIcon(caminho);
        labelImagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_DEFAULT)));
    }
   public void excluir(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        produto = entityManager.find(Produto.class, produto.getId());
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
        JOptionPane.showMessageDialog(null, "Excluído!!!");
        dispose();
   }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelNome = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelQtde = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Funcionário");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 253, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Consultar Produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 590, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 590, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 73, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Preço");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 98, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Categoria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 182, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Descricao");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 154, -1, -1));

        botaoAlterar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 217, 100, -1));

        botaoExcluir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(botaoExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 217, 100, -1));

        botaoCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 217, 100, -1));

        labelNome.setText("*********************");
        jPanel1.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 75, -1, -1));

        labelPreco.setText("*********************");
        jPanel1.add(labelPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 100, -1, -1));

        labelCategoria.setText("*********************");
        jPanel1.add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 184, -1, -1));

        labelDescricao.setText("*********************");
        jPanel1.add(labelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 156, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Quantidade");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 126, -1, -1));

        labelQtde.setText("*********************");
        jPanel1.add(labelQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 128, -1, -1));
        jPanel1.add(labelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 69, 250, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        ProdutoAlteraTela alteraTela = new ProdutoAlteraTela();
        alteraTela.setProduto(produto);
        alteraTela.setTelaConsulta(this);
        alteraTela.setVisible(true);
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    
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
            java.util.logging.Logger.getLogger(ProdutoConsultaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoConsultaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoConsultaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoConsultaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoConsultaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQtde;
    // End of variables declaration//GEN-END:variables
}
