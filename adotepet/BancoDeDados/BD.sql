-- Tabela de tipos de animais (ex: cachorro, gato)
CREATE TABLE Tipo_Animal (
id INT AUTO_INCREMENT PRIMARY KEY,
especie VARCHAR(100) NOT NULL
);

-- Tabela de ONGs
CREATE TABLE ONG (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(150) NOT NULL,
cnpj VARCHAR(20) UNIQUE NOT NULL,
telefone VARCHAR(20),
email VARCHAR(100),
endereco TEXT,
instagram VARCHAR(100),
responsavel_nome VARCHAR(100)
);

-- Tabela de tutores (pessoas físicas)
CREATE TABLE Tutor (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(150) NOT NULL,
cpf VARCHAR(20) UNIQUE NOT NULL,
telefone VARCHAR(20),
email VARCHAR(100),
endereco TEXT
);

-- Tabela de animais
CREATE TABLE Animal (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
idade INT,
porte ENUM('pequeno', 'medio', 'grande'),
sexo ENUM('M', 'F'),
descricao TEXT,
foto_url VARCHAR(255),
status ENUM('disponível', 'adotado', 'em tratamento', 'perdido') DEFAULT 'disponível',
id_tipo_animal INT NOT NULL,
id_tutor INT,
id_ong INT,
data_cadastro DATE DEFAULT CURRENT_DATE,
FOREIGN KEY (id_tipo_animal) REFERENCES Tipo_Animal(id),
FOREIGN KEY (id_tutor) REFERENCES Tutor(id),
FOREIGN KEY (id_ong) REFERENCES ONG(id)
);

-- Histórico médico dos animais
CREATE TABLE Historico_Medico (
id INT AUTO_INCREMENT PRIMARY KEY,
id_animal INT NOT NULL,
descricao TEXT NOT NULL,
data_registro DATE DEFAULT CURRENT_DATE,
FOREIGN KEY (id_animal) REFERENCES Animal(id)
);

-- Tabela de vacinas aplicadas aos animais
CREATE TABLE Vacina (
id INT AUTO_INCREMENT PRIMARY KEY,
id_animal INT NOT NULL,
nome_vacina VARCHAR(100) NOT NULL,
data_aplicacao DATE NOT NULL,
FOREIGN KEY (id_animal) REFERENCES Animal(id)
);

-- Tabela de adoções
CREATE TABLE Adocao (
id INT AUTO_INCREMENT PRIMARY KEY,
status ENUM('processando', 'em andamento', 'concluido', 'cancelado') NOT NULL DEFAULT 'processando',
id_pessoa INT NOT NULL,
id_animal INT NOT NULL,
data_peticao DATE DEFAULT CURRENT_DATE,
data_conclusao DATE,
observacoes TEXT,
FOREIGN KEY (id_pessoa) REFERENCES Tutor(id),
FOREIGN KEY (id_animal) REFERENCES Animal(id)
);

-- Tabela de denúncias de maus-tratos
CREATE TABLE Denuncia (
id INT AUTO_INCREMENT PRIMARY KEY,
id_usuario INT NOT NULL,
descricao TEXT NOT NULL,
localizacao TEXT,
data_denuncia DATE DEFAULT CURRENT_DATE,
foto_url VARCHAR(255),
status ENUM('recebido', 'em análise', 'resolvido') DEFAULT 'recebido',
FOREIGN KEY (id_usuario) REFERENCES Tutor(id)
);

-- Tabela de usuários para login (caso queira login administrativo)
CREATE TABLE Usuario (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
email VARCHAR(100) UNIQUE NOT NULL,
senha_hash VARCHAR(255) NOT NULL,
tipo_usuario ENUM('tutor', 'ong', 'admin') NOT NULL,
ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE Doacao (
id INT AUTO_INCREMENT PRIMARY KEY,
id_usuario INT NOT NULL,
id_ong INT NOT NULL,
tipo ENUM('financeira', 'material'),
descricao TEXT,
valor DECIMAL(10,2),
data_doacao DATE DEFAULT CURRENT_DATE,
FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
FOREIGN KEY (id_ong) REFERENCES ONG(id)
);