package TelasCliente;

import TelasFuncionario.*;
import DAOJPA.DAOJPA;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.SexoEnum;
import Util.JPAUtil;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ClienteAlteraTela extends javax.swing.JFrame {
    private Cliente cliente;
    private JFrame telaConsulta;
    
    public ClienteAlteraTela() {
        initComponents();
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
        preencheCampos();
    }
    public void setTelaConsulta(JFrame telaConsulta){
    this.telaConsulta=telaConsulta;
    }
    public void preencheCampos(){
        campoNome.setText(cliente.getNome());
        campoCPF.setText(cliente.getCpf());
        campoEndereco.setText(cliente.getEndereco());
        campoTelefone.setText(cliente.getTelefone());
        campoEmail.setText(cliente.getEmail());
        campoDataNasc.setText(cliente.getDataNasc());
        campoCNH.setText(cliente.getCNH());
        
        if(cliente.getSexo().toString().equals("M"))
            radioMasculino.setSelected(true);
        else
            radioFemino.setSelected(true);
    
    }
    public void Atualizar(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
        JOptionPane.showMessageDialog(null, "Dados Atualizados");
    }
    public void atualizaDados(){
        cliente.setNome(campoNome.getText());
        cliente.setCpf(campoCPF.getText());
        cliente.setTelefone(campoTelefone.getText());
        cliente.setEndereco(campoEndereco.getText());
        cliente.setDataNasc(campoDataNasc.getText());
        cliente.setEmail(campoEmail.getText());
        cliente.setCNH(campoCNH.getText());
        if (radioMasculino.isSelected())
            cliente.setSexo(SexoEnum.M);
        else 
            cliente.setSexo(SexoEnum.F);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        campoNome = new javax.swing.JTextField();
        campoTelefone = new javax.swing.JTextField();
        campoCPF = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        radioMasculino = new javax.swing.JRadioButton();
        radioFemino = new javax.swing.JRadioButton();
        campoCNH = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        campoDataNasc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Funcionario");
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(246, 253, 253));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel46.setText("Alterar Cliente");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel47.setText("Nome");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel48.setText("Telefone");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel49.setText("Endereço");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel50.setText("CPF");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel51.setText("Email");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel52.setText("Sexo");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel53.setText("CNH");

        radioMasculino.setText("Masculino");

        radioFemino.setText("Feminino");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel47)
                .addGap(4, 4, 4)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel50)
                .addGap(4, 4, 4)
                .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel55)
                .addGap(4, 4, 4)
                .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel49)
                .addGap(4, 4, 4)
                .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel48)
                .addGap(4, 4, 4)
                .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel52)
                .addGap(4, 4, 4)
                .addComponent(radioMasculino))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(radioFemino))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel51)
                .addGap(4, 4, 4)
                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel53)
                .addGap(8, 8, 8)
                .addComponent(campoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel46))
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel47))
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel55))
                    .addComponent(campoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel49))
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel48))
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel52))
                    .addComponent(radioMasculino))
                .addGap(3, 3, 3)
                .addComponent(radioFemino)
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel51))
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(campoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
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
       atualizaDados();
       Atualizar();
       dispose();
       telaConsulta.dispose();
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
            java.util.logging.Logger.getLogger(ClienteAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteAlteraTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteAlteraTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoCNH;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoDataNasc;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JRadioButton radioFemino;
    private javax.swing.JRadioButton radioMasculino;
    // End of variables declaration//GEN-END:variables
}
