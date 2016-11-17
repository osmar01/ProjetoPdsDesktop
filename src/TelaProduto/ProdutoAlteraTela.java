package TelaProduto;

import DAOJPA.DAOJPA;
import Modelo.Categoria;
import Modelo.Produto;
import Util.JPAUtil;
import java.awt.Color;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class ProdutoAlteraTela extends javax.swing.JFrame {
    private Produto produto;
    private JFrame telaConsulta;
    
    public ProdutoAlteraTela() {
        initComponents();
        jLabelAst1.setForeground(Color.red);
        jLabelAst2.setForeground(Color.red);
        jLabelAst3.setForeground(Color.red);
        jLabelAst4.setForeground(Color.red);
        jLabelAst5.setForeground(Color.red);
        preencherComboboxCategoria();
    }
    public void setProduto(Produto produto){
        this.produto = produto;
        preencheCampos();
    }
    public void setTelaConsulta(JFrame telaConsulta){
        this.telaConsulta=telaConsulta;
    }
    public void preencherComboboxCategoria(){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();  
        DAOJPA<Categoria> dao = new DAOJPA<>(em,Categoria.class);
        
        List<Categoria> listaCategoria = dao.listar("");         
        comboboxCategoria.removeAllItems();
        
        comboboxCategoria.addItem("Selecione...");
        
        for (Categoria e: listaCategoria){
            comboboxCategoria.addItem(e.getNome());   
        }
        em.getTransaction().commit();
        em.close(); 
    }
    
    public void preencheCampos(){
        campoNome.setText(produto.getNome());
        campoPreco.setText(produto.getPreco().toString());
        campoDescricao.setText(produto.getDescricao());
        spinnerQtde.setValue(produto.getQuantidade());

    }
    public void Atualizar(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
        JOptionPane.showMessageDialog(null, "Dados Atualizados");
    }
    public void atualizaDados(){
        produto.setNome(campoNome.getText());
        produto.setPreco(Double.parseDouble(campoPreco.getText()));
        produto.setDescricao(campoDescricao.getText());
        produto.setQuantidade(Integer.parseInt(spinnerQtde.getValue().toString()));
        
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        String nomeCategoria= comboboxCategoria.getSelectedItem().toString();
        DAOJPA<Categoria> daoCategoria = new DAOJPA<>(em,Categoria.class);
        List<Categoria> listaCategoria = daoCategoria.listar(nomeCategoria);
        Categoria categoria = listaCategoria.get(0);
        
        em.getTransaction().commit();
        em.close();
        
        produto.setCategoria(categoria);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoPreco = new javax.swing.JTextField();
        campoDescricao = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        comboboxCategoria = new javax.swing.JComboBox<>();
        spinnerQtde = new javax.swing.JSpinner();
        jLabelAst1 = new javax.swing.JLabel();
        jLabelAst2 = new javax.swing.JLabel();
        jLabelAst3 = new javax.swing.JLabel();
        jLabelAst4 = new javax.swing.JLabel();
        jLabelAst5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Funcionario");
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(246, 253, 253));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel46.setText("Alterar Produto");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel47.setText("Nome");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel49.setText("Descricao");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel50.setText("Preço");

        botaoSalvar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel55.setText("Quantidade");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel56.setText("Categoria");

        comboboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelAst1.setText("*");

        jLabelAst2.setText("*");

        jLabelAst3.setText("*");

        jLabelAst4.setText("*");

        jLabelAst5.setText("*");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel50)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelAst2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoPreco))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel47)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelAst1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel49)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabelAst3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinnerQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabelAst4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabelAst5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel46)
                .addGap(6, 6, 6)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabelAst1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst2))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(spinnerQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst3))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabelAst4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(comboboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst5))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        campoNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoPreco.setBorder(new LineBorder(Color.LIGHT_GRAY));
        spinnerQtde.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
        comboboxCategoria.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        if(campoNome.getText().equals("")){
            campoNome.setBorder(new LineBorder(Color.RED));
            campoNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoPreco.getText().equals("")){
                    campoPreco.setBorder(new LineBorder(Color.RED));
                    campoPreco.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(spinnerQtde.getValue().equals(0)){
                    spinnerQtde.setBorder(new LineBorder(Color.RED));
                    spinnerQtde.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoDescricao.getText().equals("")){
                    campoDescricao.setBorder(new LineBorder(Color.RED));
                    campoDescricao.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(comboboxCategoria.getSelectedIndex() == 0){
                    comboboxCategoria.setBorder(new LineBorder(Color.RED));
                    comboboxCategoria.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            atualizaDados();
            Atualizar();
            dispose();
            telaConsulta.dispose();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutoAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoAlteraTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPreco;
    private javax.swing.JComboBox<String> comboboxCategoria;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabelAst1;
    private javax.swing.JLabel jLabelAst2;
    private javax.swing.JLabel jLabelAst3;
    private javax.swing.JLabel jLabelAst4;
    private javax.swing.JLabel jLabelAst5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSpinner spinnerQtde;
    // End of variables declaration//GEN-END:variables
}
