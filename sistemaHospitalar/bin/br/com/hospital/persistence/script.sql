CREATE TYPE tipo_cobertura AS ENUM ('NACIONAL', 'REGIONAL');

CREATE TYPE turno_enum AS ENUM ('MANHA', 'TARDE', 'NOITE');

CREATE TYPE tipo_ala AS ENUM ('ENFERMARIA', 'EMERGENCIA', 'UTI', 'PEDIATRIA', 'MATERNIDADE', 'CARDIOLOGIA');

CREATE TYPE status_leito AS ENUM ('OCUPADO', 'MANUTENCAO', 'DISPONIVEL');

CREATE TYPE tipo_atendimento AS ENUM ('CONSULTA', 'EMERGENCIA', 'REVISAO');

CREATE TYPE status_atendimento AS ENUM ('REALIZADO', 'CANCELADO', 'AGENDADO');

CREATE TYPE tipo_laboratorio AS ENUM ('INTERNO', 'EXTERNO');

CREATE TYPE tipo_exame AS ENUM ('SANGUE', 'IMAGEM', 'RAIO_X', 'URINA', 'TOMOGRAFIA', 'ENDOSCOPIA');

CREATE TYPE status_faturamento AS ENUM ('PENDENTE', 'PAGO', 'CANCELADO', 'EM_ANALISE');

CREATE TYPE responsavel_pagamento_enum AS ENUM ('PACIENTE', 'PLANO');

CREATE TABLE hospital(
    id_hospital SERIAL PRIMARY KEY,
    cnpj VARCHAR(100) NOT NULL,
    nome VARCHAR(60) NOT NULL
);

CREATE TABLE plano_saude(
    id_plano_saude SERIAL PRIMARY KEY,
    cobertura tipo_cobertura NOT NULL,
    nome VARCHAR(60) NOT NULL,
    telefone VARCHAR(18) NOT NULL
);

CREATE TABLE credenciamento(
    id_credenciamento SERIAL PRIMARY KEY,
    id_hospital INT NOT NULL,
    id_plano_saude INT NOT NULL,
    data_credenciamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_hospital) REFERENCES hospital(id_hospital),
    FOREIGN KEY (id_plano_saude) REFERENCES plano_saude(id_plano_saude)
);

CREATE TABLE enfermeira(
    id_enfermeira SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cre INT UNIQUE NOT NULL,
    chefe_id INT,
    turno turno_enum NOT NULL,
    FOREIGN KEY (chefe_id) REFERENCES enfermeira(id_enfermeira)
);

CREATE TABLE ala(
    id_ala SERIAL PRIMARY KEY,
    tipo tipo_ala NOT NULL,
    id_responsavel INT,
    id_hospital INT NOT NULL,
    capacidade INT NOT NULL,
    FOREIGN KEY (id_responsavel) REFERENCES enfermeira(id_enfermeira),
    FOREIGN KEY (id_hospital) REFERENCES hospital(id_hospital)
);

CREATE TABLE leito(
    id_leito SERIAL PRIMARY KEY,
    status status_leito NOT NULL,
    id_ala INT NOT NULL,
    identificador VARCHAR(100) UNIQUE NOT NULL,
    FOREIGN KEY (id_ala) REFERENCES ala(id_ala)
);

CREATE TABLE paciente (
    id_paciente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(14) UNIQUE
);

CREATE TABLE internacao(
    id_internacao SERIAL PRIMARY KEY,
    id_leito INT NOT NULL,
    id_paciente INT NOT NULL,
    hora_entrada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    hora_saida TIMESTAMP,
    FOREIGN KEY (id_leito) REFERENCES leito(id_leito),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE medico (
    id_medico SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(50),
    crm INT UNIQUE NOT NULL
);

CREATE TABLE atendimento(
    id_atendimento SERIAL PRIMARY KEY,
    id_paciente INT NOT NULL,
    id_medico INT NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo tipo_atendimento NOT NULL,
    status status_atendimento NOT NULL,
    observacao TEXT,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);

CREATE TABLE medicamento(
    id_medicamento SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE prescricao(
    id_prescricao SERIAL PRIMARY KEY,
    id_medicamento INT NOT NULL,
    id_atendimento INT NOT NULL,
    prescricao TEXT,
    data_prescricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dosagem DECIMAL(10,2),
    FOREIGN KEY (id_medicamento) REFERENCES medicamento(id_medicamento),
    FOREIGN KEY (id_atendimento) REFERENCES atendimento(id_atendimento)
);

CREATE TABLE laboratorio (
    id_laboratorio SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    classificado tipo_laboratorio
);

CREATE TABLE exame_laudo(
    id_exame_laudo SERIAL PRIMARY KEY,
    id_laboratorio INT NOT NULL,
    id_paciente INT NOT NULL, 
    id_medico INT NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_resultado TIMESTAMP,
    tipo tipo_exame NOT NULL,
    custo DECIMAL(10,2) NOT NULL,
    descricao TEXT,
    resultado TEXT,
    anexo BYTEA,
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorio(id_laboratorio),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);

CREATE TABLE faturamento(
    id_faturamento SERIAL PRIMARY KEY,
    id_atendimento INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data_faturamento DATE NOT NULL,
    data_vencimento DATE NOT NULL,
    status status_faturamento NOT NULL,
    forma_pagamento VARCHAR(50) NOT NULL,
    responsavel_pagamento responsavel_pagamento_enum NOT NULL,
    FOREIGN KEY (id_atendimento) REFERENCES atendimento(id_atendimento)
);

CREATE TABLE nota_fiscal(
    id_nota_fiscal SERIAL PRIMARY KEY,
    FOREIGN KEY (id_fatura) REFERENCES faturamento(id_faturamento) NOT NULL,
    paciente VARCHAR(100) NOT NULL,
    cpf VARCHAR(18) NOT NULL,
    hospital VARCHAR(100) NOT NULL,
    cnpj VARCHAR(30),
    descricao TEXT,
    FOREIGN KEY (valor_total) REFERENCES faturamento(valor) NOT NULL,
    valorPagoPIS DECIMAL(10,2) NOT NULL,
    valorPagoCOFINS DECIMAL(10,2) NOT NULL,
    valorPagoISS DECIMAL(10,2) NOT NULL,
    valorPagoIRPJ DECIMAL(10,2) NOT NULL,
    valorPagoCSLL DECIMAL(10,2) NOT NULL,
);

INSERT INTO hospital (cnpj, nome) VALUES
('00.000.000/0001-01','Hospital Central'),
('00.000.000/0001-02','Hospital Vida'),
('00.000.000/0001-03','Hospital São Lucas'),
('00.000.000/0001-04','Hospital Santa Maria'),
('00.000.000/0001-05','Hospital Brasil'),
('00.000.000/0001-06','Hospital Carioca'),
('00.000.000/0001-07','Hospital Popular'),
('00.000.000/0001-08','Hospital Saúde Total'),
('00.000.000/0001-09','Hospital Bem Estar'),
('00.000.000/0001-10','Hospital Esperança');

INSERT INTO plano_saude (cobertura, nome, telefone) VALUES
('NACIONAL','Unimed','1111-1111'),
('REGIONAL','Amil','2222-2222'),
('NACIONAL','Bradesco Saúde','3333-3333'),
('REGIONAL','SulAmérica','4444-4444'),
('NACIONAL','NotreDame','5555-5555'),
('REGIONAL','Hapvida','6666-6666'),
('NACIONAL','Porto Seguro','7777-7777'),
('REGIONAL','Prevent Senior','8888-8888'),
('NACIONAL','Allianz','9999-9999'),
('REGIONAL','Intermédica','1010-1010');

INSERT INTO credenciamento (id_hospital, id_plano_saude) VALUES
(1,1),(1,2),(2,3),(2,4),(3,5),(4,6),(5,7),(6,8),(7,9),(8,10);

INSERT INTO enfermeira (nome, cre, chefe_id, turno) VALUES
('Ana Silva',1001,NULL,'MANHA'),
('Maria Souza',1002,1,'TARDE'),
('Joana Lima',1003,1,'NOITE'),
('Carla Mendes',1004,2,'MANHA'),
('Fernanda Alves',1005,2,'TARDE'),
('Paula Costa',1006,3,'NOITE'),
('Juliana Rocha',1007,3,'MANHA'),
('Patricia Gomes',1008,4,'TARDE'),
('Aline Ribeiro',1009,5,'NOITE'),
('Beatriz Martins',1010,6,'MANHA');

INSERT INTO ala (tipo, id_responsavel, id_hospital, capacidade) VALUES
('UTI',1,1,10),('EMERGENCIA',2,1,20),('ENFERMARIA',3,2,30),
('PEDIATRIA',4,2,15),('MATERNIDADE',5,3,25),('CARDIOLOGIA',6,3,18),
('UTI',7,4,12),('EMERGENCIA',8,5,22),('ENFERMARIA',9,6,28),('PEDIATRIA',10,7,16);

INSERT INTO leito (status, id_ala, identificador) VALUES
('DISPONIVEL',1,'L1'),('OCUPADO',1,'L2'),('MANUTENCAO',2,'L3'),
('DISPONIVEL',2,'L4'),('OCUPADO',3,'L5'),('DISPONIVEL',4,'L6'),
('OCUPADO',5,'L7'),('DISPONIVEL',6,'L8'),('MANUTENCAO',7,'L9'),('DISPONIVEL',8,'L10');

INSERT INTO paciente (nome, cpf) VALUES
('João Pedro','000.000.000-01'),('Lucas Silva','000.000.000-02'),
('Marcos Souza','000.000.000-03'),('Pedro Alves','000.000.000-04'),
('Carlos Lima','000.000.000-05'),('Rafael Costa','000.000.000-06'),
('Bruno Rocha','000.000.000-07'),('Gustavo Gomes','000.000.000-08'),
('Felipe Ribeiro','000.000.000-09'),('André Martins','000.000.000-10');

INSERT INTO internacao (id_leito, id_paciente) VALUES
(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);

INSERT INTO medico (nome, especialidade, crm) VALUES
('Dr. João','Cardiologia',2001),('Dr. Pedro','Ortopedia',2002),
('Dr. Carlos','Pediatria',2003),('Dr. Marcos','Clínico Geral',2004),
('Dr. Rafael','Neurologia',2005),('Dr. Bruno','Dermatologia',2006),
('Dr. Gustavo','Psiquiatria',2007),('Dr. Felipe','Urologia',2008),
('Dr. André','Endocrinologia',2009),('Dr. Lucas','Oncologia',2010);

INSERT INTO atendimento (id_paciente, id_medico, tipo, status) VALUES
(1,1,'CONSULTA','REALIZADO'),(2,2,'EMERGENCIA','REALIZADO'),
(3,3,'REVISAO','AGENDADO'),(4,4,'CONSULTA','CANCELADO'),
(5,5,'EMERGENCIA','REALIZADO'),(6,6,'CONSULTA','AGENDADO'),
(7,7,'REVISAO','REALIZADO'),(8,8,'CONSULTA','REALIZADO'),
(9,9,'EMERGENCIA','CANCELADO'),(10,10,'CONSULTA','AGENDADO');

INSERT INTO medicamento (nome) VALUES
('Dipirona'),('Paracetamol'),('Ibuprofeno'),('Amoxicilina'),
('Azitromicina'),('Omeprazol'),('Losartana'),('Metformina'),
('Insulina'),('Aspirina');

INSERT INTO prescricao (id_medicamento, id_atendimento, prescricao, dosagem) VALUES
(1,1,'Tomar 2x ao dia',500),(2,2,'Tomar 1x ao dia',750),
(3,3,'Após refeições',400),(4,4,'Por 7 dias',500),
(5,5,'Por 5 dias',500),(6,6,'Jejum',20),
(7,7,'Controle pressão',50),(8,8,'Controle glicemia',850),
(9,9,'Aplicar diária',10),(10,10,'Preventivo',100);

INSERT INTO laboratorio (nome, classificado) VALUES
('Lab A','INTERNO'),('Lab B','EXTERNO'),('Lab C','INTERNO'),
('Lab D','EXTERNO'),('Lab E','INTERNO'),('Lab F','EXTERNO'),
('Lab G','INTERNO'),('Lab H','EXTERNO'),('Lab I','INTERNO'),('Lab J','EXTERNO');

INSERT INTO exame_laudo (id_laboratorio, id_paciente, id_medico, tipo, custo) VALUES
(1,1,1,'SANGUE',100),(2,2,2,'IMAGEM',200),(3,3,3,'URINA',50),
(4,4,4,'RAIO_X',150),(5,5,5,'TOMOGRAFIA',500),(6,6,6,'ENDOSCOPIA',400),
(7,7,7,'SANGUE',120),(8,8,8,'IMAGEM',220),(9,9,9,'URINA',60),(10,10,10,'RAIO_X',180);

INSERT INTO faturamento (id_atendimento, valor, data_faturamento, data_vencimento, status, forma_pagamento, responsavel_pagamento) VALUES
(1,200,'2025-01-01','2025-01-10','PAGO','CARTAO','PACIENTE'),
(2,500,'2025-01-02','2025-01-12','PENDENTE','BOLETO','PLANO'),
(3,150,'2025-01-03','2025-01-13','CANCELADO','PIX','PACIENTE'),
(4,300,'2025-01-04','2025-01-14','PAGO','CARTAO','PLANO'),
(5,700,'2025-01-05','2025-01-15','PENDENTE','PIX','PACIENTE'),
(6,250,'2025-01-06','2025-01-16','PAGO','BOLETO','PLANO'),
(7,400,'2025-01-07','2025-01-17','EM_ANALISE','PIX','PACIENTE'),
(8,350,'2025-01-08','2025-01-18','PAGO','CARTAO','PLANO'),
(9,600,'2025-01-09','2025-01-19','PENDENTE','BOLETO','PACIENTE'),
(10,450,'2025-01-10','2025-01-20','PAGO','PIX','PLANO');