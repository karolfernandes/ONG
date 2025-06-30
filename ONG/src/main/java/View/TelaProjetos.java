/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ChamadoController;
import Controller.ProjetoController;
import Model.ChamadoModel;
import Model.ColaboradorModel;
import Model.ProjetoModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class TelaProjetos extends javax.swing.JFrame {

    /**
     * Creates new form Relatorios
     */
    ProjetoController controller = new ProjetoController();
    int idSelecionado;
    ColaboradorModel colaborador = new ColaboradorModel();
    ChamadoController chamadoC = new ChamadoController();
    List<Integer> listaId = new ArrayList<>();
    int idChamadoSelecioando;

    TelaProjetos(ColaboradorModel usuarioLogado) {
        colaborador = usuarioLogado;

        initComponents();
        listarProjetos();
        carregarChamadosNaComboBox();

        tabelaProjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tabelaProjeto.getSelectedRow();
                if (linha >= 0) {
                    idSelecionado = Integer.parseInt(tabelaProjeto.getValueAt(linha, 4).toString());
                    campoHorarioProjeto.setText(tabelaProjeto.getValueAt(linha, 2).toString());
                    campoNomeProjeto.setText(tabelaProjeto.getValueAt(linha, 0).toString());
                    campoDataProjeto.setText(tabelaProjeto.getValueAt(linha, 1).toString());
                    campoDuracaoProjeto.setText(tabelaProjeto.getValueAt(linha, 3).toString());
                }
            }

        });

        listaChamados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int posicao = listaChamados.getSelectedIndex();
                idChamadoSelecioando = listaId.get(posicao);
            }
        });

        pesquisarProjetos.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void pesquisar() {
                String texto = pesquisarProjetos.getText().trim();
                filtrarProjetoTabela(texto);
            }
        });

    }

    // listando os chaMADOS NA COMBOBOX
    private void carregarChamadosNaComboBox() {
        ChamadoController controller = new ChamadoController();
        List<ChamadoModel> chamados = controller.listarChamados();

        listaChamados.removeAllItems(); // limpa a combobox antes de adicionar

        for (ChamadoModel chamado : chamados) {
            listaChamados.addItem(chamado.getProblema()); // toString será usado aqui
            listaId.add(chamado.getIdChamado());
        }
    }

    private void limparCamposProjeto() {
        campoNomeProjeto.setText("");
        campoDataProjeto.setText("");
        campoHorarioProjeto.setText("");
        campoDuracaoProjeto.setText("");
    }

    private void listarProjetos() {
        ProjetoController controller = new ProjetoController();
        List<ProjetoModel> lista = controller.listarProjetosComNomeChamado();

        DefaultTableModel modelo = (DefaultTableModel) tabelaProjeto.getModel();
        modelo.setRowCount(0);

        for (ProjetoModel p : lista) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getDataProjeto(),
                p.getHorario(),
                p.getDuracao(),
                p.getIdProjeto()
            });
        }

        tabelaProjeto.getColumnModel().getColumn(4).setMinWidth(0);
        tabelaProjeto.getColumnModel().getColumn(4).setMaxWidth(0);
        tabelaProjeto.getColumnModel().getColumn(4).setWidth(0);
    }

    public void filtrarProjetoTabela(String textoPesquisa) {
    List<ProjetoModel> listaProjetoTabela = controller.pesquisarPorId(textoPesquisa);

    DefaultTableModel modelo = (DefaultTableModel) tabelaProjeto.getModel();
    modelo.setRowCount(0); // limpa tabela

    for (ProjetoModel p : listaProjetoTabela) {
        // filtro é feito no controller, mas por garantia você pode manter aqui se desejar
        if (p.getNome().toLowerCase().contains(textoPesquisa.toLowerCase())) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getDataProjeto(),
                p.getHorario(),
                p.getDuracao(),
                p.getIdProjeto()              // 5
            });
        }
    }

    // Oculta a coluna do ID (coluna 0 agora)
    tabelaProjeto.getColumnModel().getColumn(4).setMinWidth(0);
    tabelaProjeto.getColumnModel().getColumn(4).setMaxWidth(0);
    tabelaProjeto.getColumnModel().getColumn(4).setWidth(0);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        botaoEditar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProjeto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNomeProjeto = new javax.swing.JTextField();
        campoDataProjeto = new javax.swing.JTextField();
        campoHorarioProjeto = new javax.swing.JTextField();
        campoDuracaoProjeto = new javax.swing.JTextField();
        listaChamados = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TituloProjeto = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        pesquisarProjetos = new javax.swing.JTextField();
        editarProjeto = new javax.swing.JButton();
        excluirProjeto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jButton1.setText("Entrada de Doações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Funcionarios Ativos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botaoEditar.setBackground(new java.awt.Color(0, 102, 0));

        tabelaProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data", "Horario", "Duração", "ID"
            }
        ));
        jScrollPane2.setViewportView(tabelaProjeto);

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setForeground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Chamado:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Horario:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Duração:");

        campoHorarioProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHorarioProjetoActionPerformed(evt);
            }
        });

        listaChamados.setBackground(new java.awt.Color(0, 102, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Data:");

        TituloProjeto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TituloProjeto.setForeground(new java.awt.Color(0, 102, 0));
        TituloProjeto.setText("Projetos");

        jButton8.setBackground(new java.awt.Color(0, 153, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Adicionar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(TituloProjeto))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoDataProjeto))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoHorarioProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(listaChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoDuracaoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton8)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TituloProjeto)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoHorarioProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDataProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDuracaoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaChamados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton8)
                .addGap(20, 20, 20))
        );

        pesquisarProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarProjetosActionPerformed(evt);
            }
        });

        editarProjeto.setBackground(new java.awt.Color(0, 153, 51));
        editarProjeto.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        editarProjeto.setText("Editar");
        editarProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProjetoActionPerformed(evt);
            }
        });

        excluirProjeto.setBackground(new java.awt.Color(0, 153, 51));
        excluirProjeto.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        excluirProjeto.setText("Excluir");
        excluirProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirProjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botaoEditarLayout = new javax.swing.GroupLayout(botaoEditar);
        botaoEditar.setLayout(botaoEditarLayout);
        botaoEditarLayout.setHorizontalGroup(
            botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botaoEditarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(botaoEditarLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(pesquisarProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(botaoEditarLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(botaoEditarLayout.createSequentialGroup()
                                .addComponent(editarProjeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(excluirProjeto))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        botaoEditarLayout.setVerticalGroup(
            botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botaoEditarLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(botaoEditarLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(botaoEditarLayout.createSequentialGroup()
                        .addComponent(pesquisarProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(botaoEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarProjeto)
                            .addComponent(excluirProjeto))
                        .addGap(81, 81, 81))))
        );

        jButton3.setText("Relatorios");

        jButton4.setText("Retirada de Doações");

        jButton5.setText("Calendario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Chamado");

        jButton7.setText("Projetos");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jButton4)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton6)
                .addGap(28, 28, 28)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(botaoVoltar)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        TelaHome telaPrincipal = new TelaHome(colaborador);
        telaPrincipal.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        String nome = campoNomeProjeto.getText();
        String horario = campoHorarioProjeto.getText();
        String data = campoDataProjeto.getText();
        String duracao = campoDuracaoProjeto.getText();

        // Verificar se algum campo está vazio ou se nenhum chamado foi selecionado
        if (nome.isEmpty() || horario.isEmpty() || data.isEmpty() || duracao.isEmpty() || idChamadoSelecioando == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos e selecione um chamado antes de cadastrar.");
        } else {
            ProjetoModel projeto = new ProjetoModel();
            projeto.setNome(nome);
            projeto.setHorario(horario);
            projeto.setDataProjeto(data);
            projeto.setDuracao(duracao);
            projeto.setIdChamado(idChamadoSelecioando); // este campo deve estar no seu modelo

            ProjetoController controller = new ProjetoController();
            Boolean result = controller.cadastrar(projeto);

            if (result != null && result == true) {
                JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar projeto!");
            }
        }
        listarProjetos();
        limparCamposProjeto();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void pesquisarProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarProjetosActionPerformed

    }//GEN-LAST:event_pesquisarProjetosActionPerformed

    private void editarProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProjetoActionPerformed
        // TODO add your handling code here:

        String nome = campoNomeProjeto.getText();
        String horario = campoHorarioProjeto.getText();
        String data = campoDataProjeto.getText();
        String duracao = campoDuracaoProjeto.getText();

        // Verificar se algum campo está vazio ou se nenhum chamado foi selecionado
        if (nome.isEmpty() || horario.isEmpty() || data.isEmpty() || duracao.isEmpty() || idChamadoSelecioando == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos e selecione um chamado antes de cadastrar.");
        } else {
            ProjetoModel projeto = new ProjetoModel();
            projeto.setNome(nome);
            projeto.setIdProjeto(idSelecionado);
            projeto.setHorario(horario);
            projeto.setDataProjeto(data);
            projeto.setDuracao(duracao);
            projeto.setIdChamado(idChamadoSelecioando); // este campo deve estar no seu modelo

            ProjetoController controller = new ProjetoController();
            Boolean result = controller.atualizar(projeto);

            if (result != null && result == true) {
                JOptionPane.showMessageDialog(null, "Projeto editado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar projeto!");
            }
        }
        listarProjetos();
        limparCamposProjeto();

    }//GEN-LAST:event_editarProjetoActionPerformed

    private void campoHorarioProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHorarioProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHorarioProjetoActionPerformed

    private void excluirProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirProjetoActionPerformed
        // TODO add your handling code here:
        Boolean result = controller.excluir(idSelecionado);

        if (result != null && result == true) {
            JOptionPane.showMessageDialog(null, "Projeto excluido com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir projeto!");
        }
        listarProjetos();
    }//GEN-LAST:event_excluirProjetoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                ColaboradorModel colaborador = null;
                new TelaProjetos(colaborador).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloProjeto;
    private javax.swing.JPanel botaoEditar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoDataProjeto;
    private javax.swing.JTextField campoDuracaoProjeto;
    private javax.swing.JTextField campoHorarioProjeto;
    private javax.swing.JTextField campoNomeProjeto;
    private javax.swing.JButton editarProjeto;
    private javax.swing.JButton excluirProjeto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaChamados;
    private javax.swing.JTextField pesquisarProjetos;
    private javax.swing.JTable tabelaProjeto;
    // End of variables declaration//GEN-END:variables
}
