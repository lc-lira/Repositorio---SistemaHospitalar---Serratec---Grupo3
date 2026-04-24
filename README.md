# 🏥 Sistema de Gestão Hospitalar e Faturamento - Projeto Final POO

Este repositório contém o Projeto Final da disciplina de **Programação Orientada a Objetos (POO)**. O sistema simula o banco de dados de um hospital e realiza o processamento de faturas de pacientes para a geração de Notas Fiscais, exportação de arquivos CSV e persistência de dados.

## 👥 Equipe e Orientação
* **Professor:** Roni
* **Integrantes do Grupo:**
  * Bruno Passanami
  * Lucas Lira
  * Maicon Muniz
  * Marcelo Oliveira
  * Rebeka de Oliveira Cardoso

## 🚀 Tecnologias e Conceitos Aplicados
O projeto foi desenvolvido em **Java** e aplica estritamente os pilares e conceitos avançados de POO exigidos no escopo do trabalho:

* **Interfaces e Classes Abstratas:** Modelagem de entidades e contratos de impostos.
* **Herança e Polimorfismo:** Estruturação das regras de negócio.
* **Encapsulamento e Modificadores de Acesso:** Proteção dos dados sensíveis, especialmente financeiros.
* **Enum:** Utilizado para gerenciar regras fixas, como `Turno`, `Status` e cálculo de `TipoImposto` (ISS, PIS, COFINS, IRPJ, CSLL).
* **Coleções (Collections):** Uso de `List`, `Set` ou `Map` para gerenciar os itens das faturas e relacionamentos.
* **Tratamento de Exceções:** Criação de exceções customizadas (ex: `FaturaInexistenteException`) e tratamento de erros de input.
* **Tipos Específicos:** Uso de `BigDecimal` para cálculos financeiros com precisão e `LocalDate`/`LocalDateTime` para controle de datas.
* **Manipulação de Arquivos (I/O):** Geração automática de nota fiscal em formato `.csv`.
* **Banco de Dados (JDBC):** Conexão, consultas (DAO) e scripts DDL/DML para estruturação e população inicial.
* **Interface Gráfica (UI):** Menu interativo utilizando a biblioteca **Swing** (`JOptionPane`).

## 📂 Arquitetura e Separação por Pacotes
O projeto segue a separação lógica de responsabilidades (padrão MVC/Camadas):
* `br.com.hospital.main`: Ponto de entrada da aplicação.
* `br.com.hospital.view`: Interfaces de usuário (Telas Swing/Menu).
* `br.com.hospital.model`: Entidades de domínio (Paciente, Médico, Fatura, NotaFiscal).
* `br.com.hospital.dao`: Classes de acesso ao Banco de Dados.
* `br.com.hospital.service`: Lógica e regras de negócio.
* `br.com.hospital.exceptions`: Exceções personalizadas.
* `br.com.hospital.util`: Ferramentas auxiliares (ex: Gerador de arquivos CSV).

## ⚙️ Como executar o projeto

### 1. Configuração do Banco de Dados
1. Abra o seu SGBD (MySQL/PostgreSQL, etc.).
2. Execute o script `modelo_fisico_ddl.sql` localizado na pasta `/sql` para criar as tabelas.
3. Execute o script `modelo_fisico_dml.sql` para popular o banco com os 10 registros fictícios em cada tabela (exceto `nota_fiscal`).
4. Verifique na classe `ConnectionFactory` (pacote DAO) se as credenciais (`URL`, `USER`, `PASSWORD`) correspondem ao seu banco local.

### 2. Executando a Aplicação
1. Clone este repositório (`git clone <url-do-repo>`).
2. Abra o projeto na sua IDE de preferência (Eclipse, IntelliJ, NetBeans).
3. Execute a classe `Main.java`.
4. Utilize o menu interativo gerado pelo Swing para:
   * Buscar uma fatura e gerar a Nota Fiscal (Calcula impostos, salva no BD e exporta o arquivo `.csv`).
   * Consultar uma Nota Fiscal já existente no Banco de Dados.

## 🌿 Fluxo de Trabalho (Git/GitHub)
Para atender ao requisito de versionamento, este projeto foi desenvolvido utilizando branches individuais para cada integrante, garantindo que todos participassem ativamente da construção do código por meio de Commits e Pull Requests.
