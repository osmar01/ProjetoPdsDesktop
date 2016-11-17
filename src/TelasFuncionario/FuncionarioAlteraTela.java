package TelasFuncionario;

import DAOJPA.DAOJPA;
import Modelo.Funcionario;
import Modelo.SexoEnum;
import Util.JPAUtil;
import java.awt.Color;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class FuncionarioAlteraTela extends javax.swing.JFrame {
    private Funcionario fun;
    private JFrame telaConsulta;
    
    public FuncionarioAlteraTela() {
        initComponents();
        jLabelAst1.setForeground(Color.red);
        jLabelAst2.setForeground(Color.red);
        jLabelAst3.setForeground(Color.red);
        jLabelAst4.setForeground(Color.red);
        jLabelAst5.setForeground(Color.red);
        jLabelAst6.setForeground(Color.red);
        jLabelAst7.setForeground(Color.red);
        jLabelAst8.setForeground(Color.red);
    }
    public void setFuncionario(Funcionario fun){
        this.fun = fun;
        preencheCampos();
    }
    public void setTelaConsulta(JFrame telaConsulta){
    this.telaConsulta=telaConsulta;
    }
    public void preencheCampos(){
        campoNome.setText(fun.getNome());
        campoCPF.setText(fun.getCpf());
        campoEndereco.setText(fun.getEndereco());
        campoTelefone.setText(fun.getTelefone());
        campoEmail.setText(fun.getEmail());
        campoDataNasc.setText(fun.getDataNasc());
        campoLogin.setText(fun.getLogin());
        campoSenha.setText(fun.getSenha());
        
        if(fun.getSexo().toString().equals("M"))
            radioMasculino.setSelected(true);
        else
            radioFeminino.setSelected(true);
    
    }
    public void Atualizar(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(fun);
        entityManager.getTransaction().commit();
        entityManager.close();
        JOptionPane.showMessageDialog(null, "Dados Atualizados");
    }
    public void atualizaDados(){
        fun.setNome(campoNome.getText());
        fun.setCpf(campoCPF.getText());
        fun.setTelefone(campoTelefone.getText());
        fun.setEndereco(campoEndereco.getText());
        fun.setDataNasc(campoDataNasc.getText());
        fun.setLogin(campoLogin.getText());
        fun.setSenha(campoSenha.getText());
        fun.setEmail(campoEmail.getText());
        if (radioMasculino.isSelected())
            fun.setSexo(SexoEnum.M);
        else 
            fun.setSexo(SexoEnum.F);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        radioMasculino = new javax.swing.JRadioButton();
        radioFeminino = new javax.swing.JRadioButton();
        campoSenha = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoLogin = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        campoCPF = new javax.swing.JFormattedTextField();
        campoDataNasc = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        jLabelAst3 = new javax.swing.JLabel();
        jLabelAst2 = new javax.swing.JLabel();
        jLabelAst1 = new javax.swing.JLabel();
        jLabelAst4 = new javax.swing.JLabel();
        jLabelAst5 = new javax.swing.JLabel();
        jLabelAst6 = new javax.swing.JLabel();
        jLabelAst7 = new javax.swing.JLabel();
        jLabelAst8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Funcionario");
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(246, 253, 253));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel46.setText("Alterar Funcionário");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel47.setText("Nome");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel48.setText("Telefone");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel49.setText("Endereco");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel50.setText("CPF");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel51.setText("Email");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel52.setText("Sexo");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel53.setText("Senha");

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel54.setText("Login");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioMasculino);
        radioMasculino.setText("Masculino");

        buttonGroup1.add(radioFeminino);
        radioFeminino.setText("Feminino");

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
        jLabel55.setText("Data de Nascimento");

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelAst3.setText("*");

        jLabelAst2.setText("*");

        jLabelAst1.setText("*");

        jLabelAst4.setText("*");

        jLabelAst5.setText("*");

        jLabelAst6.setText("*");

        jLabelAst7.setText("*");

        jLabelAst8.setText("*");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel55)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelAst3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel47)
                                .addComponent(jLabel50))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabelAst1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabelAst2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(20, 20, 20))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGap(80, 80, 80)
                                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel51)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelAst6)
                                        .addComponent(jLabelAst4)
                                        .addComponent(jLabelAst5)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel53)
                                        .addComponent(jLabel54))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelAst7)
                                        .addComponent(jLabelAst8))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioMasculino)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoEndereco)
                                    .addComponent(campoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addComponent(radioFeminino))))
                    .addContainerGap()))
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
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst1))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst2))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst3))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabelAst4)
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst5))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(radioMasculino)
                    .addComponent(jLabelAst6))
                .addGap(3, 3, 3)
                .addComponent(radioFeminino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst7))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAst8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        boolean radioM = radioMasculino.isSelected();
        boolean radioF = radioFeminino.isSelected();
        
        campoNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoCPF.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoDataNasc.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoTelefone.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoLogin.setBorder(new LineBorder(Color.LIGHT_GRAY));
        campoSenha.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        if(campoNome.getText().equals("")){
            campoNome.setBorder(new LineBorder(Color.RED));
            campoNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoCPF.getText().equals("   .   .   -  ")){
                    campoCPF.setBorder(new LineBorder(Color.RED));
                    campoCPF.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoDataNasc.getText().equals("  /  /    ")){
                    campoDataNasc.setBorder(new LineBorder(Color.RED));
                    campoDataNasc.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoEndereco.getText().equals("")){
                    campoEndereco.setBorder(new LineBorder(Color.RED));
                    campoEndereco.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoTelefone.getText().equals("(  )     -    ")){
                    campoTelefone.setBorder(new LineBorder(Color.RED));
                    campoTelefone.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(radioM == false && radioF == false){
                    radioMasculino.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoLogin.getText().equals("")){
                    campoLogin.setBorder(new LineBorder(Color.RED));
                    campoLogin.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else if(campoSenha.getText().equals("")){
                    campoSenha.setBorder(new LineBorder(Color.RED));
                    campoSenha.requestFocus();
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos obrigatórios!!!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            atualizaDados();
            Atualizar();
            dispose();
            telaConsulta.dispose();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioAlteraTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JFormattedTextField campoDataNasc;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabelAst1;
    private javax.swing.JLabel jLabelAst2;
    private javax.swing.JLabel jLabelAst3;
    private javax.swing.JLabel jLabelAst4;
    private javax.swing.JLabel jLabelAst5;
    private javax.swing.JLabel jLabelAst6;
    private javax.swing.JLabel jLabelAst7;
    private javax.swing.JLabel jLabelAst8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JRadioButton radioFeminino;
    private javax.swing.JRadioButton radioMasculino;
    // End of variables declaration//GEN-END:variables
}
