package br.com.hospital.Menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.hospital.conexao.ConnectionFactory;
import br.com.hospital.dao.FaturamentoDao;
import br.com.hospital.dao.NotaFiscalDao;
import br.com.hospital.model.Faturamento;
import br.com.hospital.model.NotaFiscal;

public class MenuPrincipal {

    public void inicarMenu() {
        Integer opcao = 0;

        String textoMenu = "------------------------------------------------------------------------------------------\n"
                + "               Sistema Hospitalar - Faturas e  Notas Fiscais\n"
                + "------------------------------------------------------------------------------------------\n"
                + "Escolha uma dessas opções: \n"
                + "1- Gerar notas  fiscais para todos os faturamentos do banco de dados.\n"
                + "2- Gerar uma nota fiscal apartir de uma fatura específica.\n"
                + "3- Sair\n";

        while (opcao != 3) {
            try (Connection connection = new ConnectionFactory().getConnection()) {
                String entrada = JOptionPane.showInputDialog(null, textoMenu, "Menu principal", 3);
                if (entrada == null) {
                    break;
                }
                opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        FaturamentoDao fDao = new FaturamentoDao(connection);
                        List<Faturamento> faturas = fDao.gerarListaFaturamentos();
                        Integer N1 = 1;
                        Integer N2 = 1;

                        JOptionPane.showMessageDialog(null, "Gerando nota fiscal no Formato TXT e CSV...");
                        for (Faturamento notas : faturas) {
                            NotaFiscal nf = new NotaFiscal(notas);
                            nf.gerarNotaFiscalTXT(N1++);
                            nf.gerarNotaFiscalCSV(N2++);
                            fDao.salvarNFBanco(notas);
                        }

                        JOptionPane.showMessageDialog(null,
                                "Notas geradas com sucesso e armazenadas no Banco de dados!");
                        break;

                    case 2:
                        NotaFiscalDao nDao = new NotaFiscalDao(connection);

                        String id = JOptionPane.showInputDialog(null, "Digite o id da fatura", "Menu principal", 3);

                        Integer idBusca = Integer.parseInt(id);

                        NotaFiscal buscaNF = nDao.buscarFatura(idBusca);

                        if (buscaNF != null) {
                            JOptionPane.showMessageDialog(null, "Nota Fiscal encontrada!");
                            String nota = "Hospital: " + buscaNF.getFaturamento().getHospital().getNome() + "\n"
                                    + "CNPJ: " + buscaNF.getFaturamento().getHospital().getCnpj() + "\n"
                                    + "Tipo de Serviço: "
                                    + String.valueOf(buscaNF.getFaturamento().getAtendimento().getTipo()) + "\n"
                                    + "Paciente: " + buscaNF.getFaturamento().getPaciente().getNome() + "\n"
                                    + "CPF: " + buscaNF.getFaturamento().getPaciente().getCpf() + "\n\n"
                                    + "Valor: R$ " + buscaNF.getFaturamento().getValor() + "\n\n"
                                    + "Resumo dos Impostos:\n"
                                    + "PIS: R$ " + buscaNF.getValoresImpostos().getPis() + "\n"
                                    + "COFINS: R$ " + buscaNF.getValoresImpostos().getCofins() + "\n"
                                    + "ISS: R$ " + buscaNF.getValoresImpostos().getIss() + "\n"
                                    + "IRPJ: R$ " + buscaNF.getValoresImpostos().getIrpj() + "\n"
                                    + "CSLL: R$ " + buscaNF.getValoresImpostos().getCsll();

                            JOptionPane.showMessageDialog(null, nota, "Detalhes da Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nota fiscal não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        buscaNF.gerarNotaFiscalCSV(idBusca);

                        JOptionPane.showMessageDialog(null, "Nota gerada com sucesso!", "Exportação Concluída", JOptionPane.INFORMATION_MESSAGE);
                    case 3:
                        JOptionPane.showMessageDialog(null, "Encerrado o programa...", "Atenção", 1);
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", 0);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números", "Erro", 0);
                e.printStackTrace();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
            }
        }

    }

}
