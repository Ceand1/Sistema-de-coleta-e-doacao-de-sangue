CREATE TABLE Usuario(cpf varchar(11) primary key, primeiro_nome varchar(30), sobrenome varchar(30),
          cidade varchar(30), estado varchar(30), rua varchar(30), bairro varchar(30), numero int,
          cep varchar(8), sexo char, tipo_sangue varchar(3), nascimento date, nacionalidade varchar(30));
          
CREATE TABLE Posto(n_registro varchar(10) primary key, cidade varchar(30), estado varchar(30), rua varchar(30),
           bairro varchar(30), numero int, cep varchar(8), n_doações int);
           
CREATE TABLE Medicacoes(id serial primary key, nome varchar(30), efeito varchar(200));

CREATE TABLE Doencas(id serial primary key, nome varchar(30), sintomas varchar(200));

CREATE TABLE Modificacao(id serial primary key, nome varchar(30), descicao varchar(200));

CREATE TABLE Ilicito(id serial primary key, nome varchar(30), efeito varchar(200));



CREATE TABLE Usuario_email(cpf_usuario varchar(11), email varchar(30));

-- ALTER TABLE Usuario_email
-- ADD COLUMN cpf_usuario varchar(11);

ALTER TABLE Usuario_email
add constraint fkUsuario_email
foreign key(cpf_usuario) references Usuario(cpf);



CREATE TABLE Usuario_telefone(cpf_usuario varchar(11), telefone varchar(11));

-- ALTER TABLE Usuario_telefone
-- ADD COLUMN cpf_usuario varchar(11);

ALTER TABLE Usuario_telefone
add constraint fkUsuario_telefone
foreign key(cpf_usuario) references Usuario(cpf);

-----DOADOR------------------------

CREATE TABLE Doador(cpf_doador varchar(11) unique, altura float, peso float, estado_civil varchar(30), n_doacoes int);


ALTER TABLE Doador
add constraint fkCPF_doador
foreign key(cpf_doador) references Usuario(cpf);

-------Modificacao-----------------

CREATE TABLE Doador_modificacoes_corpo(cpf_doador_mod varchar(11) unique, id_mod int);

ALTER TABLE doador_modificacoes_corpo
add constraint fkCPF_doador_modificacoes
foreign key (cpf_doador_mod) references doador(cpf_doador);

ALTER TABLE Doador_modificacoes_corpo
add constraint fkId_mod_doador_modificacoes
foreign key(id_mod) references Modificacao(id);

-----------------------------------------
-------Doenças---------------------------

CREATE TABLE Doador_doencas(cpf_doador varchar(11) unique, id_doenca int);

ALTER TABLE Doador_doencas
add constraint fkCPF_doador_doencas
foreign key(cpf_doador) references Doador(cpf_doador);

ALTER TABLE Doador_doencas
add constraint fkId_doenca_doador_doencas
foreign key(id_doenca) references Doencas(id);

-----------------------------------------
-------Medicacoes---------------------------

CREATE TABLE Doador_medicacoes(cpf_doador varchar(11) unique, id_medicacao int);

ALTER TABLE Doador_medicacoes
add constraint fkCPF_doador_medicacoes
foreign key(cpf_doador) references Doador(cpf_doador);

ALTER TABLE Doador_medicacoes
add constraint fkId_medicacoes_doador_medicacoes
foreign key(id_medicacao) references Medicacoes(id);

-----------------------------------------
-------Doação---------------------------

CREATE TABLE Doador_Doacao(
            cpf_doador varchar(11), registro_posto varchar(10), 
            data_doacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            tipo_sangue varchar(3), id SERIAL PRIMARY KEY
);

ALTER TABLE Doador_Doacao
add constraint fkCPF_doador_doacao
foreign key(cpf_doador) references Doador(cpf_doador);

ALTER TABLE Doador_Doacao
add constraint fkRegistro_Posto_Doador_doacao
foreign key(registro_posto) references Posto(n_registro);

-----------------------------------------

----Receptor-----------------------------

CREATE TABLE Receptor(
  cpf_receptor varchar(11) unique, 
  estado_saude varchar(30)
);

ALTER TABLE Receptor
add constraint fkCPF_receptor
foreign key(cpf_receptor) references Usuario(cpf);

-------Ilícitos-----------------

CREATE TABLE Receptor_ilicitos(cpf_receptor varchar(11) unique, id_ilicito int);

ALTER TABLE Receptor_ilicitos
add constraint fkCPF_receptor_ilicitos
foreign key(cpf_receptor) references Receptor(cpf_receptor);

ALTER TABLE Receptor_ilicitos
add constraint fkId_ilicito_receptor
foreign key(id_ilicito) references Ilicito(id);

-----------------------------------------
-------Recebe-----------------

CREATE TABLE Receptor_recebe(
            cpf_receptor varchar(11) unique, registro_posto varchar(10), 
            data_receber TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            tipo_sangue varchar(3), id SERIAL PRIMARY KEY
);

ALTER TABLE Receptor_recebe
add constraint fkCPF_receptor_recebe
foreign key(cpf_receptor) references Receptor(cpf_receptor);

ALTER TABLE Receptor_recebe
add constraint fkRegistro_Posto_receptor_recebe
foreign key(registro_posto) references Posto(n_registro);

-----------------------------------------
-------Notificacao-----------------

CREATE TABLE Receptor_notificacao(
            cpf_receptor varchar(11) unique, registro_posto varchar(10), 
            data_receber TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            texto varchar(200)
);

ALTER TABLE Receptor_notificacao
add constraint fkCPF_receptor_notificacao
foreign key(cpf_receptor) references Receptor(cpf_receptor);

ALTER TABLE Receptor_notificacao
add constraint fkRegistro_Posto_receptor_notificacao
foreign key(registro_posto) references Posto(n_registro);

-----------------------------------------

-----------------------------------------
-------Posto-Estoque-----------------

CREATE TABLE if not exists Posto_Estoque(
            registro_posto varchar(10), 
            quant_sangue int,
            tipo_sangue varchar(3)
);

ALTER TABLE Posto_Estoque
add constraint fkPosto_Estoque
foreign key(registro_posto) references Posto(n_registro);

-----------------------------------------

