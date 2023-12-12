SELECT * FROM posto_estoque

SELECT * FROM receptor

SELECT * FROM receptor_recebe

SELECT
    tc.constraint_name, 
    tc.table_name, 
    kcu.column_name
FROM 
    information_schema.table_constraints AS tc 
    JOIN information_schema.key_column_usage AS kcu
      ON tc.constraint_name = kcu.constraint_name
WHERE 
    tc.constraint_type = 'UNIQUE' 
    AND tc.table_name = 'receptor_recebe';

ALTER TABLE receptor_recebe DROP CONSTRAINT receptor_recebe_cpf_receptor_key;

ALTER TABLE Receptor_recebe ADD COLUMN id SERIAL PRIMARY KEY;


