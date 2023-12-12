INSERT INTO Usuario (cpf, primeiro_nome, sobrenome, cidade, estado, rua, bairro, numero, cep, sexo, tipo_sangue, nascimento, nacionalidade)
VALUES
    ('12345678901', 'João', 'Silva', 'Quixadá', 'CE', 'Rua A', 'Centro', 123, '01234567', 'M', 'O+', '1990-01-01', 'Brasileiro'),
    ('23456789012', 'Maria', 'Santos', 'Quixadá', 'CE', 'Rua B', 'Copacabana', 456, '12345678', 'F', 'A-', '1985-05-15', 'Brasileira'),
    ('34567890123', 'Pedro', 'Oliveira', 'Quixadá', 'CE', 'Rua C', 'Barra', 789, '23456789', 'M', 'B+', '1982-09-20', 'Brasileiro'),
    ('45678901234', 'Ana', 'Costa', 'Fortaleza', 'CE', 'Rua D', 'Savassi', 101, '34567890', 'F', 'AB-', '1995-03-10', 'Brasileira'),
    ('56789012345', 'Lucas', 'Pereira', 'Fortaleza', 'CE', 'Rua E', 'Boa Viagem', 202, '45678901', 'M', 'O-', '1988-07-03', 'Brasileiro'),
    ('67890123456', 'Julia', 'Almeida', 'Quixadá', 'CE', 'Rua F', 'Moinhos de Vento', 303, '56789012', 'F', 'A+', '1992-11-25', 'Brasileira'),
    ('78901234567', 'Gustavo', 'Rocha', 'Fortaleza', 'CE', 'Rua G', 'Aldeota', 404, '67890123', 'M', 'B-', '1980-12-12', 'Brasileiro'),
    ('89012345678', 'Mariana', 'Ferreira', 'Quixadá', 'CE', 'Rua H', 'Asa Sul', 505, '78901234', 'F', 'AB+', '1998-04-18', 'Brasileira'),
    ('90123456789', 'Rafael', 'Sousa', 'Quixadá', 'CE', 'Rua I', 'Adrianópolis', 606, '89012345', 'M', 'A-', '1987-06-30', 'Brasileiro'),
    ('01234567890', 'Camila', 'Lima', 'Fortaleza', 'CE', 'Rua J', 'Batel', 707, '90123456', 'F', 'O+', '1993-08-08', 'Brasileira'),
    ('44556677889', 'Cristina', 'Santana', 'Fortaleza', 'CE', 'Rua Q', 'Aldeota', 606, '87654321', 'F', 'A+', '1990-03-15', 'Brasileira'),
    ('55667788990', 'Ricardo', 'Silveira', 'Quixadá', 'CE', 'Rua R', 'Cidade Nova', 707, '76543210', 'M', 'O-', '1985-07-20', 'Brasileiro'),
    ('66778899001', 'Aline', 'Souza', 'Fortaleza', 'CE', 'Rua S', 'Dionísio Torres', 808, '65432109', 'F', 'B+', '1992-11-10', 'Brasileira'),
    ('77889900112', 'Gabriel', 'Lima', 'Quixadá', 'CE', 'Rua T', 'Centro', 909, '54321098', 'M', 'AB-', '1988-04-25', 'Brasileiro'),
    ('88990011223', 'Laura', 'Fernandes', 'Fortaleza', 'CE', 'Rua U', 'Mucuripe', 1010, '43210987', 'F', 'A-', '1996-09-05', 'Brasileira'),
    ('99001112234', 'Vinícius', 'Oliveira', 'Quixadá', 'CE', 'Rua V', 'Bela Vista', 1111, '32109876', 'M', 'O+', '1980-12-01', 'Brasileiro'),
    ('11223344556', 'Carla', 'Martins', 'Fortaleza', 'CE', 'Rua X', 'Meireles', 1212, '21098765', 'F', 'AB+', '1994-02-28', 'Brasileira'),
    ('22334455667', 'Felipe', 'Albuquerque', 'Quixadá', 'CE', 'Rua Y', 'Planalto', 1313, '10987654', 'M', 'B-', '1983-10-03', 'Brasileiro'),
    ('33445566778', 'Amanda', 'Costa', 'Fortaleza', 'CE', 'Rua Z', 'Cocó', 1414, '98765432', 'F', 'O-', '1997-05-22', 'Brasileira'),
    ('44556677880', 'Thiago', 'Santos', 'Quixadá', 'CE', 'Rua W', 'Jardim', 1515, '87654321', 'M', 'A+', '1986-07-15', 'Brasileiro'),
    ('55667788992', 'Isabela', 'Lima', 'Fortaleza', 'CE', 'Rua K', 'Varjota', 1616, '76543210', 'F', 'O+', '1991-11-07', 'Brasileira'),
    ('66778899013', 'Rodrigo', 'Pereira', 'Quixadá', 'CE', 'Rua L', 'Alto Brilhante', 1717, '65432109', 'M', 'B+', '1989-04-18', 'Brasileiro'),
    ('77889900124', 'Fernanda', 'Rocha', 'Fortaleza', 'CE', 'Rua M', 'Meireles', 1818, '54321098', 'F', 'A-', '1995-08-30', 'Brasileira');

-- Inserindo 10 dados fictícios para Medicacoes
INSERT INTO Medicacoes (nome, efeito) VALUES
    ('Paracetamol', 'Alívio da dor e redução da febre'),
    ('Ibuprofeno', 'Anti-inflamatório e alívio da dor'),
    ('Cetirizina', 'Antialérgico para alergias'),
    ('Dipirona', 'Analgésico e antipirético'),
    ('Omeprazol', 'Inibidor de ácido para problemas digestivos'),
    ('Dexametasona', 'Anti-inflamatório e imunossupressor'),
    ('Amoxicilina', 'Antibiótico de amplo espectro'),
    ('Hidroclorotiazida', 'Diurético para hipertensão'),
    ('Escitalopram', 'Antidepressivo'),
    ('Insulina', 'Regulador de glicose para diabetes');

-- Inserindo 10 dados fictícios para Doencas
INSERT INTO Doencas (nome, sintomas) VALUES
    ('Resfriado Comum', 'Congestão nasal, espirros, dor de garganta'),
    ('Gripe', 'Febre, dor muscular, tosse'),
    ('Hipertensão', 'Pressão arterial elevada'),
    ('Diabetes', 'Glicose elevada, sede excessiva, fadiga'),
    ('Enxaqueca', 'Dor de cabeça intensa, náusea, sensibilidade à luz'),
    ('Artrite', 'Inflamação das articulações, dor, inchaço'),
    ('Asma', 'Dificuldade respiratória, chiado no peito'),
    ('Depressão', 'Tristeza persistente, falta de energia, alterações no sono'),
    ('Úlcera Gástrica', 'Dor abdominal, queimação, indigestão'),
    ('Anemia', 'Fadiga, palidez, falta de ar');
	
-- Populate Ilicito table
INSERT INTO Ilicito (nome, efeito)
VALUES
    ('Droga A', 'Causa euforia e aumento da frequência cardíaca.'),
    ('Substância B', 'Pode levar à perda de memória temporária.'),
    ('Estimulante C', 'Aumenta a energia, mas pode causar insônia.'),
    ('Analgésico D', 'Alivia a dor, mas pode causar sonolência.'),
    ('Alucinógeno E', 'Provoca distorções na percepção da realidade.'),
    ('Sedativo F', 'Induz ao relaxamento e sono profundo.'),
    ('Narcótico G', 'Pode levar à dependência e diminuição da respiração.'),
    ('Inalante H', 'Causa euforia, mas pode danificar o sistema respiratório.'),
    ('Esteroide I', 'Aumenta a massa muscular, mas pode ter efeitos colaterais.'),
    ('Alucinógeno J', 'Provoca experiências sensoriais intensas e alterações na percepção do tempo.');


-- Inserindo dados fictícios para Modificacao
INSERT INTO Modificacao (nome, descicao) VALUES
    ('Brinco na Orelha', 'Adorno na orelha'),
    ('Sobrancelhas Micropigmentadas', 'Técnica de maquiagem definitiva'),
    ('Implante Capilar', 'Restauração de cabelo'),
    ('Preenchimento Labial', 'Aumento de volume nos lábios'),
    ('Cirurgia de Redução de Mama', 'Procedimento estético'),
    ('Silicone nos Glúteos', 'Aumento de volume nos glúteos'),
    ('Tatuagem na Sobrancelha', 'Micropigmentação'),
    ('Remoção de Tatuagem a Laser', 'Procedimento para remoção de tatuagem'),
    ('Otoplastia', 'Correção estética das orelhas'),
    ('Lipoaspiração', 'Remoção de gordura localizada');

 

-- Inserindo dados fictícios para Posto
INSERT INTO Posto (n_registro, cidade, estado, rua, bairro, numero, cep, n_doações) VALUES
    ('PQX123', 'Quixadá', 'CE', 'Avenida da Solidariedade', 'Centro', 101, '63000000', 30),
    ('PFOR456', 'Fortaleza', 'CE', 'Rua da Esperança', 'Aldeota', 202, '60000000', 40);

-- Continue com os inserts para mais tabelas...


-- Inserindo dados fictícios para Usuario_email
INSERT INTO Usuario_email (cpf_usuario, email)
VALUES
    ('12345678901', 'joao.silva@email.com'),
    ('23456789012', 'maria.santos@email.com'),
    ('34567890123', 'pedro.oliveira@email.com'),
    ('45678901234', 'ana.costa@email.com'),
    ('56789012345', 'lucas.pereira@email.com'),
    ('67890123456', 'julia.almeida@email.com'),
    ('78901234567', 'gustavo.rocha@email.com'),
    ('89012345678', 'mariana.ferreira@email.com'),
    ('90123456789', 'rafael.sousa@email.com'),
    ('01234567890', 'camila.lima@email.com'),
    ('44556677889', 'cristina.santana@email.com'),
    ('55667788990', 'ricardo.silveira@email.com'),
    ('66778899001', 'aline.souza@email.com'),
    ('77889900112', 'gabriel.lima@email.com'),
    ('88990011223', 'laura.fernandes@email.com'),
    ('99001112234', 'vinicius.oliveira@email.com'),
    ('11223344556', 'carla.martins@email.com'),
    ('22334455667', 'felipe.albuquerque@email.com'),
    ('33445566778', 'amanda.costa@email.com'),
    ('44556677880', 'thiago.santos@email.com'),
    ('55667788992', 'isabela.lima@email.com'),
    ('66778899013', 'rodrigo.pereira@email.com'),
    ('77889900124', 'fernanda.rocha@email.com');
-- Inserindo dados fictícios para Usuario_telefone
INSERT INTO Usuario_telefone (cpf_usuario, telefone)
VALUES
    ('12345678901', '987654321'),
    ('23456789012', '876543210'),
    ('34567890123', '765432109'),
    ('45678901234', '654321098'),
    ('56789012345', '543210987'),
    ('67890123456', '432109876'),
    ('78901234567', '321098765'),
    ('89012345678', '210987654'),
    ('90123456789', '109876543'),
    ('01234567890', '987654321'),
    ('44556677889', '876543210'),
    ('55667788990', '765432109'),
    ('66778899001', '654321098'),
    ('77889900112', '543210987'),
    ('88990011223', '432109876'),
    ('99001112234', '321098765'),
    ('11223344556', '210987654'),
    ('22334455667', '109876543'),
    ('33445566778', '987654321'),
    ('44556677880', '876543210'),
    ('55667788992', '765432109'),
    ('66778899013', '654321098'),
    ('77889900124', '543210987');

-- Inserindo dados fictícios para Doador
INSERT INTO Doador (cpf_doador, altura, peso, estado_civil, n_doacoes)
VALUES
    ('12345678901', 175, 70, 'Solteiro', 3),
    ('23456789012', 160, 55, 'Casado', 2),
    ('34567890123', 180, 80, 'Divorciado', 1),
    ('45678901234', 165, 60, 'Solteiro', 4),
    ('56789012345', 170, 75, 'Casado', 2),
    ('67890123456', 155, 50, 'Solteiro', 3),
    ('78901234567', 185, 90, 'Divorciado', 2),
    ('89012345678', 168, 72, 'Casado', 1),
    ('90123456789', 175, 68, 'Solteiro', 5),
    ('01234567890', 162, 58, 'Casado', 2);

-- Inserindo dados fictícios para Doador_modificacoes_corpo
INSERT INTO Doador_modificacoes_corpo (cpf_doador, id_mod)
VALUES
    ('12345678901', 1),
    ('23456789012', 2),
    ('34567890123', 3),
    ('45678901234', 4),
    ('56789012345', 5),
    ('67890123456', 6),
    ('78901234567', 7),
    ('89012345678', 8),
    ('90123456789', 9),
    ('01234567890', 10);

-- Inserindo dados fictícios para Doador_doencas
INSERT INTO Doador_doencas (cpf_doador, id_doenca)
VALUES
    ('12345678901', 11),
    ('23456789012', 12),
    ('34567890123', 13),
    ('45678901234', 14),
    ('56789012345', 15),
    ('67890123456', 16),
    ('78901234567', 17),
    ('89012345678', 18),
    ('90123456789', 19),
    ('01234567890', 20);

-- Inserindo dados fictícios para Doador_medicacoes
INSERT INTO Doador_medicacoes (cpf_doador, id_medicacao)
VALUES
    ('12345678901', 11),
    ('23456789012', 12),
    ('34567890123', 13),
    ('45678901234', 14),
    ('56789012345', 15),
    ('67890123456', 16),
    ('78901234567', 17),
    ('89012345678', 18),
    ('90123456789', 19),
    ('01234567890', 20);

-- Inserindo dados fictícios para Doador_Doacao
INSERT INTO Doador_Doacao (cpf_doador, registro_posto, tipo_sangue)
VALUES
    ('12345678901', 'PFOR456', 'O+'),
    ('23456789012', 'PQX123', 'A-'),
    ('34567890123', 'PFOR456', 'B+'),
    ('45678901234', 'PFOR456', 'AB-'),
    ('56789012345', 'PFOR456', 'O-'),
    ('67890123456', 'PQX123', 'A+'),
    ('78901234567', 'PFOR456', 'B-'),
    ('89012345678', 'PQX123', 'AB+'),
    ('90123456789', 'PFOR456', 'A-'),
    ('01234567890', 'PQX123', 'O+');
-- Inserindo dados fictícios para Receptor
INSERT INTO Receptor (cpf_receptor, estado_saude)
VALUES
    ('44556677889', 'Bom'),
    ('55667788990', 'Regular'),
    ('66778899001', 'Bom'),
    ('77889900112', 'Crítico'),
    ('88990011223', 'Regular'),
    ('99001112234', 'Bom'),
    ('11223344556', 'Crítico'),
    ('22334455667', 'Bom'),
    ('33445566778', 'Regular'),
    ('44556677880', 'Bom');

-- Inserindo dados fictícios para Receptor_ilicitos
INSERT INTO Receptor_ilicitos (cpf_receptor, id_ilicito)
VALUES
    ('44556677889', 1),
    ('55667788990', 2),
    ('66778899001', 3),
    ('77889900112', 4),
    ('88990011223', 5),
    ('99001112234', 6),
    ('11223344556', 7),
    ('22334455667', 8),
    ('33445566778', 9),
    ('44556677880', 10);

-- Populate Receptor_recebe table
INSERT INTO Receptor_recebe (cpf_receptor, registro_posto, tipo_sangue)
VALUES
    ('44556677889', 'PFOR456', 'O+'),
    ('55667788990', 'PQX123', 'A-'),
    ('66778899001', 'PFOR456', 'B+'),
    ('77889900112', 'PQX123', 'AB-'),
    ('88990011223', 'PFOR456', 'O-'),
    ('99001112234', 'PQX123', 'A+'),
    ('11223344556', 'PFOR456', 'B-'),
    ('22334455667', 'PQX123', 'AB+'),
    ('33445566778', 'PFOR456', 'A-'),
    ('44556677880', 'PQX123', 'O+');

-- Populate Receptor_notificacao table
INSERT INTO Receptor_notificacao (cpf_receptor, registro_posto, texto)
VALUES
    ('44556677889', 'PFOR456', 'Você receberá uma doação em 7 dias. Por favor, esteja preparado.'),
    ('55667788990', 'PQX123', 'A próxima doação está agendada para daqui a 10 dias. Fique atento à sua saúde.'),
    ('66778899001', 'PFOR456', 'Em virtude da gravidade, sua doação será priorizada. Receberá uma doação em 3 dias.'),
    ('77889900112', 'PQX123', 'Previsão de doação em 14 dias. Agradecemos por sua paciência e colaboração.'),
    ('88990011223', 'PFOR456', 'Sua doação anterior foi essencial. Aguarde 5 dias para a próxima doação.'),
    ('99001112234', 'PQX123', 'A próxima doação está programada para daqui a 8 dias. Continue cuidando de sua saúde.'),
    ('11223344556', 'PFOR456', 'Você receberá uma doação em 6 dias. Mantenha-se saudável.'),
    ('22334455667', 'PQX123', 'Devido à sua condição, a próxima doação será em 2 dias.'),
    ('33445566778', 'PFOR456', 'Em breve, você terá uma doação. Previsão de 12 dias.'),
    ('44556677880', 'PQX123', 'Continue sua dieta rica em ferro. Receberá uma doação em 9 dias.');

-- Adjust the placeholder values for id_ilicito, registro_posto, and texto accordingly.



-- Inserindo dados fictícios para Posto_Estoque
INSERT INTO Posto_Estoque (registro_posto, quant_sangue, tipo_sangue)
VALUES
    ('PFOR456', 5, 'O+'),
    ('PQX123', 5, 'A-'),
    ('PFOR456', 1, 'B+'),
    ('PFOR456', 1, 'AB-'),
    ('PFOR456', 1, 'O-'),
    ('PQX123', 1, 'A+'),
    ('PFOR456', 1, 'B-'),
    ('PQX123', 1, 'AB+'),
    ('PFOR456', 1, 'A-'),
    ('PQX123', 1, 'O+');
