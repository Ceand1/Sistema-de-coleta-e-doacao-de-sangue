-- Quantidade de sangue O- em cada posto?

SELECT p.*, e.quant_sangue 
FROM posto as p JOIN Posto_estoque as e 
ON p.n_registro = e.registro_posto
WHERE e.tipo_sangue like 'O-';

-- Quantidade de doações por posto?

SELECT p.n_registro, COUNT(d.cpf_doador) AS total_doacoes
FROM Posto as p LEFT JOIN Doador_Doacao as d 
ON p.n_registro = d.registro_posto
GROUP BY p.n_registro;

-- Idade média de homens doadores?

SELECT AVG(EXTRACT(YEAR FROM age(now(), u.nascimento))) AS media_idade_homens
FROM Doador as d JOIN Usuario as u 
ON d.cpf_doador = u.cpf
WHERE u.sexo like 'M';

-- Idade média de mulheres doadoras?

SELECT AVG(EXTRACT(YEAR FROM age(now(), u.nascimento))) AS media_idade_mulheres
FROM Doador as d JOIN Usuario as u 
ON d.cpf_doador = u.cpf
WHERE u.sexo like 'F';

-- Número de doações por doador?
SELECT u.cpf, u.primeiro_nome, u.sobrenome, COUNT(dd.cpf_doador) AS total_doacoes
FROM Doador as d LEFT JOIN Doador_Doacao as dd 
ON d.cpf_doador = dd.cpf_doador
JOIN usuario as u 
ON u.cpf = d.cpf_doador
GROUP BY u.cpf
ORDER BY total_doacoes DESC;

----Qual tipo sanguíneo recebeu menos doação?
SELECT tipo_sangue, COUNT(*) AS total_doacoes
FROM Doador_Doacao
GROUP BY tipo_sangue
ORDER BY total_doacoes ASC
LIMIT 1;

----Qual tipo sanguíneo tem maior número nos homens?
SELECT tipo_sangue, COUNT(*) AS total_homens
FROM Usuario
WHERE sexo = 'M' -- 'M' representa o sexo masculino
GROUP BY tipo_sangue
ORDER BY total_homens DESC
LIMIT 1;
---Qual tipo sanguíneo tem menor número nas mulheres?
SELECT tipo_sangue, COUNT(*) AS total_mulheres
FROM Usuario
WHERE sexo = 'F' -- 'F' representa o sexo feminino
GROUP BY tipo_sangue
ORDER BY total_mulheres ASC
LIMIT 1;

---Qual posto recebeu mais doações?
SELECT registro_posto, COUNT(*) AS total_doacoes
FROM Doador_Doacao
GROUP BY registro_posto
ORDER BY total_doacoes DESC
LIMIT 1;

---Qual posto recebeu menos doações?
SELECT registro_posto, COUNT(*) AS total_doacoes
FROM Doador_Doacao
GROUP BY registro_posto
ORDER BY total_doacoes ASC
LIMIT 1;