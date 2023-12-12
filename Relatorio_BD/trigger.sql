CREATE OR REPLACE FUNCTION atualizar_estoque_posto()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE posto_estoque
    SET quant_sangue = quant_sangue + 1
    WHERE registro_posto = NEW.registro_posto AND tipo_sangue = NEW.tipo_sangue;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualizar_estoque_posto
AFTER INSERT ON Doador_Doacao
FOR EACH ROW EXECUTE FUNCTION atualizar_estoque_posto();


CREATE OR REPLACE FUNCTION atualizar_estoque_posto2()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE posto_estoque
    SET quant_sangue = quant_sangue - 1
    WHERE registro_posto = NEW.registro_posto AND tipo_sangue = NEW.tipo_sangue;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualizar_estoque_posto2
AFTER INSERT ON Receptor_recebe
FOR EACH ROW EXECUTE FUNCTION atualizar_estoque_posto2();

