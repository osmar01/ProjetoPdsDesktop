package TelaInicial;

import DAOJPA.DAOJPA;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.ItemDeProduto;
import Modelo.Produto;
import ModeloTabela.CategoriaTabelaModelo;
import ModeloTabela.ProdutoAluguelTabelaModelo;
import TelaAluguel.AluguelCadastraTela;
import TelaCategoria.CategoriaPesquisaTela;
import TelaProduto.ProdutoPesquisaTela;
import TelasCliente.ClientePesquisaTela;
import TelasFuncionario.FuncionarioCadastraTela;
import TelasFuncionario.FuncionarioPesquisaTela;
import Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

    private List<Categoria> listaCategorias;
    private List<Produto> listaProduto;
    private List<ItemDeProduto> listaItensProdutos = new ArrayList<ItemDeProduto>();
    private Categoria cat = new Categoria();
    private Categoria catSelecionada;
    private Cliente cliente = new Cliente();
    private Funcionario fun;
    private Produto produtoSelecionado;

    public TelaInicial() {
        initComponents();
        Pesquisar();
        verificaAdm();
    }

    //----------------------- preencher TabelaCategoria----------------
    public void pesquisarBD() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DAOJPA<Categoria> dao = new DAOJPA<>(entityManager, Categoria.class);
        listaCategorias = dao.listar("");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void preencherTabelaCategoria() {
        CategoriaTabelaModelo modelo = new CategoriaTabelaModelo(listaCategorias);
        tabelaCategorias.setModel(modelo);
    }

    public void Pesquisar() {
        pesquisarBD();
        preencherTabelaCategoria();
    }
    //---------------------------------------------------------------

    public Categoria categoriaSelecionada() {
        catSelecionada = listaCategorias.get(tabelaCategorias.getSelectedRow());
        return catSelecionada;
    }

    public void selecionarLinhaTabelaCategoria(java.awt.event.MouseEvent evt) {
        tabelaCategorias.clearSelection();
        int linha = tabelaCategorias.rowAtPoint(evt.getPoint());
        tabelaCategorias.setRowSelectionInterval(linha, linha);
    }

    //-----------------------------------
    public void preencherTabelaProduto() {
        catSelecionada = categoriaSelecionada();

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DAOJPA<Categoria> dao = new DAOJPA<>(entityManager, Categoria.class);
        catSelecionada = dao.Consultar(catSelecionada.getId());

        listaProduto = catSelecionada.getListaProdutos();
        ProdutoAluguelTabelaModelo modelo = new ProdutoAluguelTabelaModelo(listaProduto);
        tabelaProduto.setModel(modelo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    //---------------------------------------
    public Produto produtoSelecionado() {
        produtoSelecionado = listaProduto.get(tabelaProduto.getSelectedRow());
        return produtoSelecionado;
    }

    public void selecionarLinhaTabelaProduto(java.awt.event.MouseEvent evt) {
        tabelaProduto.clearSelection();
        int linha = tabelaProduto.rowAtPoint(evt.getPoint());
        tabelaProduto.setRowSelectionInterval(linha, linha);
    }

    public void abrirProdutoConsultaTela() {
        AlugarProdutosTelaInicial consultaTela = new AlugarProdutosTelaInicial();
        consultaTela.setListaItensProdutos(listaItensProdutos);
        consultaTela.setProduto(produtoSelecionado());
        consultaTela.setVisible(true);

    }
   //------------------------------INSERE ITEM DE PRODUTO ------------------------------

    public void abrirTelaFinalizarAluguel() {
        FinalizarAluguelTela aluguelTela = new FinalizarAluguelTela();
        aluguelTela.setCliente(cliente);
        aluguelTela.setListaItensProdutos(listaItensProdutos);
        aluguelTela.setVisible(true);

    }

    public void abrirTelaListarProduto(){
        ListarAluguelTela aluguelTela = new ListarAluguelTela();
        aluguelTela.setListaProdutos(listaItensProdutos);
        aluguelTela.setVisible(true);
    }
    
    //--------------------------------Login-------------------------------------------
    
    public void verificaLogin(){
        
        fun = consultaFuncionario();
        
        
        if(campoLogin.getText().equals(fun.getLogin())){
            if(campoSenha.getText().equals(fun.getSenha())){
                if(fun.getTipo().equals("adm")){
                    liberaCamposAdm();
                    JOptionPane.showMessageDialog(null, "Bem Vindo Administrador");
                    limpaCampos();
                    botaoEntrar.setEnabled(false);
                    botaoSair.setEnabled(true);
                    bloqueiaCampos();
                }
                else{
                    liberaCamposFun();
                    JOptionPane.showMessageDialog(null, "Bem Vindo");
                    limpaCampos();
                    botaoEntrar.setEnabled(false);
                    botaoSair.setEnabled(true);
                    bloqueiaCampos();
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
            campoSenha.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Login Incorreto!!!");
            
        }
    
    }
    
    public void liberaCamposAdm(){
        menuCadastros.setEnabled(true);
        menuItemFuncionario.setEnabled(true);
        menuItemProduto.setEnabled(true);
        menuItemCategoria.setEnabled(true);
        menuMovimentacoes.setEnabled(true);
        menuRelatorio.setEnabled(true);
        menuSobre.setEnabled(true);
    }
    
    public void liberaCamposFun(){
        menuCadastros.setEnabled(true);
        menuMovimentacoes.setEnabled(true);
        menuRelatorio.setEnabled(true);
        menuSobre.setEnabled(true);
    }
    
    public void sairLogin(){
        bloqueiaMenus();
    
    }
    
    public void bloqueiaMenus(){
        menuCadastros.setEnabled(false);
        menuItemFuncionario.setEnabled(false);
        menuItemProduto.setEnabled(false);
        menuItemCategoria.setEnabled(false);
        menuMovimentacoes.setEnabled(false);
        menuRelatorio.setEnabled(false);
        menuSobre.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Login Encerrado!!!");
    }
    
    public void limpaCampos(){
        campoLogin.setText("");
        campoSenha.setText("");
    }
    
    public void bloqueiaCampos(){
        campoLogin.setEnabled(false);
        campoSenha.setEnabled(false);
    }
    
    public void liberaCampos(){
        campoLogin.setEnabled(true);
        campoSenha.setEnabled(true);
    }
    
    public Funcionario consultaFuncionario(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DAOJPA<Funcionario> dao = new DAOJPA<>(entityManager, Funcionario.class);
        List<Funcionario> listaFuncionarios = dao.listarLogin(campoLogin.getText());
        
        Funcionario fun = listaFuncionarios.get(0);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return fun;
    }
    
    //---------------------------------primeiro Cadastro de Administrador-------------------
    
    public void verificaAdm(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DAOJPA<Funcionario> dao = new DAOJPA<>(entityManager, Funcionario.class);
        List<Funcionario> listaFuncionarios = dao.listar("");
        boolean bol = true;
        for (Funcionario e: listaFuncionarios){
           if(e.getTipo().equals("adm")){
               JOptionPane.showMessageDialog(null, "Aplicacao Iniciada com sucesso!");
               bol=false;
               break;
           }
           else{
               bol=true;
           }
        }
        if(bol){
            JOptionPane.showMessageDialog(null, "A Aplicacao ainda nao tem administrador!\n"
                       + "È necessario Cadastar");
               FuncionarioCadastraTela cadastraTela  = new FuncionarioCadastraTela();
               cadastraTela.setVisible(true);
        }
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCategorias = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        botaoFinalizarLista = new javax.swing.JButton();
        botaoListaProduto = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemFuncionario = new javax.swing.JMenuItem();
        menuItemProduto = new javax.swing.JMenuItem();
        menuItemCategoria = new javax.swing.JMenuItem();
        menuMovimentacoes = new javax.swing.JMenu();
        menuItemAluguel = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AMAZONIA");
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 253, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Amazônia");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Flutuante ");

        jPanel2.setBackground(new java.awt.Color(246, 253, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Login");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Senha");

        botaoEntrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        botaoSair.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setEnabled(false);
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoEntrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEntrar)
                    .addComponent(botaoSair))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Panoramica-Praia-Do-Sono_1.jpg"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel5.setName(""); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(1000, 200));

        jPanel4.setBackground(new java.awt.Color(246, 253, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Faça o seu Aluguel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(246, 253, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N

        tabelaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria"
            }
        ));
        tabelaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaCategoriasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCategorias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço", "Quantidade"
            }
        ));
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseReleased(evt);
            }
        });
        tabelaProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaProdutoFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        botaoFinalizarLista.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoFinalizarLista.setText("Finalizar Lista");
        botaoFinalizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarListaActionPerformed(evt);
            }
        });

        botaoListaProduto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        botaoListaProduto.setText("Ver Lista Produtos");
        botaoListaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListaProdutoActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Detalhes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoListaProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoFinalizarLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoListaProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoFinalizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel6.setText("SGF- Sistema de Gerenciamento de Flutuante Versao 1.2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenuBar1.setFont(new java.awt.Font("Tunga", 1, 12)); // NOI18N

        menuCadastros.setBorder(null);
        menuCadastros.setText("Cadastros");
        menuCadastros.setEnabled(false);
        menuCadastros.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        menuItemCliente.setText("Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemCliente);

        menuItemFuncionario.setText("Funcionario");
        menuItemFuncionario.setEnabled(false);
        menuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFuncionarioActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemFuncionario);

        menuItemProduto.setText("Produto");
        menuItemProduto.setEnabled(false);
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemProduto);

        menuItemCategoria.setText("Categoria");
        menuItemCategoria.setEnabled(false);
        menuItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategoriaActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemCategoria);

        jMenuBar1.add(menuCadastros);

        menuMovimentacoes.setBorder(null);
        menuMovimentacoes.setText("Movimentacoes");
        menuMovimentacoes.setEnabled(false);
        menuMovimentacoes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        menuItemAluguel.setText("Alugueis");
        menuItemAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAluguelActionPerformed(evt);
            }
        });
        menuMovimentacoes.add(menuItemAluguel);

        jMenuBar1.add(menuMovimentacoes);

        menuRelatorio.setBorder(null);
        menuRelatorio.setText("Relatórios");
        menuRelatorio.setEnabled(false);
        menuRelatorio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuBar1.add(menuRelatorio);

        menuSobre.setBorder(null);
        menuSobre.setText("Sobre");
        menuSobre.setEnabled(false);
        menuSobre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuBar1.add(menuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1193, 734));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFuncionarioActionPerformed
        FuncionarioPesquisaTela funcionarioPesquisaTela = new FuncionarioPesquisaTela();
        funcionarioPesquisaTela.setVisible(true);
    }//GEN-LAST:event_menuItemFuncionarioActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        ClientePesquisaTela clientePesquisaTela = new ClientePesquisaTela();
        clientePesquisaTela.setVisible(true);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategoriaActionPerformed
        CategoriaPesquisaTela categoriaPesquisaTela = new CategoriaPesquisaTela();
        categoriaPesquisaTela.setVisible(true);
    }//GEN-LAST:event_menuItemCategoriaActionPerformed

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutoActionPerformed
        ProdutoPesquisaTela produtoPesquisaTela = new ProdutoPesquisaTela();
        produtoPesquisaTela.setVisible(true);
    }//GEN-LAST:event_menuItemProdutoActionPerformed

    private void tabelaCategoriasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCategoriasMouseReleased
        categoriaSelecionada();
        selecionarLinhaTabelaCategoria(evt);
        if (evt.getClickCount() > 1) {
            preencherTabelaProduto();
        }
    }//GEN-LAST:event_tabelaCategoriasMouseReleased

    private void tabelaProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaProdutoFocusGained

    }//GEN-LAST:event_tabelaProdutoFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencherTabelaProduto();
        Pesquisar();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tabelaProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseReleased
        produtoSelecionado();
        selecionarLinhaTabelaProduto(evt);
        if (evt.getClickCount() > 1) {
            abrirProdutoConsultaTela();
        }
    }//GEN-LAST:event_tabelaProdutoMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        produtoSelecionado();
        abrirProdutoConsultaTela();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botaoFinalizarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarListaActionPerformed
        abrirTelaFinalizarAluguel();
    }//GEN-LAST:event_botaoFinalizarListaActionPerformed

    private void menuItemAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAluguelActionPerformed
        AluguelCadastraTela aluguelCadastraTela = new AluguelCadastraTela();
        aluguelCadastraTela.setVisible(true);
    }//GEN-LAST:event_menuItemAluguelActionPerformed

    private void botaoListaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListaProdutoActionPerformed
        abrirTelaListarProduto();
    }//GEN-LAST:event_botaoListaProdutoActionPerformed

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        verificaLogin();
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        bloqueiaMenus();
        botaoEntrar.setEnabled(true);
        botaoSair.setEnabled(false);
        liberaCampos();
    }//GEN-LAST:event_botaoSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoFinalizarLista;
    private javax.swing.JButton botaoListaProduto;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItemAluguel;
    private javax.swing.JMenuItem menuItemCategoria;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemFuncionario;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenu menuMovimentacoes;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JTable tabelaCategorias;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
