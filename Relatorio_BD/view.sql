CREATE VIEW PostoEstoqueView AS
SELECT p.n_registro, p.cidade, p.estado, p.rua, p.bairro, p.numero, p.cep, e.tipo_sangue, e.quant_sangue
FROM Posto as p
JOIN Posto_Estoque as e ON p.n_registro = e.registro_posto;


CREATE VIEW PostoDoacaoView AS
SELECT p.n_registro, p.cidade, p.estado, p.rua, p.bairro, p.numero, p.cep, d.tipo_sangue, d.cpf_doador, d.data_doacao
FROM Posto as p
JOIN Doador_Doacao as d ON p.n_registro = d.registro_posto;


CREATE VIEW IdadeMediaPosto AS
SELECT u.cpf, u.primeiro_nome, u.sobrenome, u.cidade, u.estado, u.rua, u.bairro, u.numero, u.cep, u.sexo, u.tipo_sangue,
		u.nascimento, u.nacionalidade, d.estado_civil, d.cpf_doador, dd.registro_posto
FROM Doador as d JOIN Usuario as u 
ON d.cpf_doador = u.cpf JOIN Doador_Doacao as dd on u.cpf = dd.cpf_doador;

CREATE VIEW ReceptorPostos AS
SELECT u.primeiro_nome, u.sobrenome, u.cidade, u.estado, u.rua, u.bairro, u.numero, u.cep, u.sexo, u.tipo_sangue,
		u.nascimento, u.nacionalidade,r.estado_saude, r.cpf_receptor, rr.registro_posto
FROM receptor as r JOIN Usuario as u 
ON r.cpf_receptor = u.cpf JOIN receptor_recebe as rr on u.cpf = rr.cpf_receptor;


CREATE VIEW ReceptorRecebe AS
SELECT u.primeiro_nome, u.sobrenome, u.tipo_sangue,
		u.nascimento, u.nacionalidade,r.estado_saude, r.cpf_receptor, rr.registro_posto, rr.data_receber
FROM receptor as r JOIN Usuario as u 
ON r.cpf_receptor = u.cpf JOIN receptor_recebe as rr on u.cpf = rr.cpf_receptor;

CREATE VIEW DoadorDoacao AS
SELECT u.primeiro_nome, u.sobrenome, u.tipo_sangue,
	 d.cpf_doador, dd.registro_posto, dd.data_doacao
FROM doador as d JOIN Usuario as u 
ON d.cpf_doador = u.cpf JOIN doador_doacao as dd on u.cpf = dd.cpf_doador;


CREATE VIEW IdadeMediaSexo AS
SELECT u.cpf, u.primeiro_nome, u.sobrenome, u.cidade, u.estado, u.rua, u.bairro, u.numero, u.cep, u.sexo, u.tipo_sangue,
		u.nascimento, u.nacionalidade, d.estado_civil, d.cpf_doador
FROM Doador as d JOIN Usuario as u 
ON d.cpf_doador = u.cpf;

CREATE VIEW SumCount AS
SELECT registro_posto, COUNT(cpf_doador) as conta, sexo FROM IdadeMediaPosto GROUP BY registro_posto,sexo;

