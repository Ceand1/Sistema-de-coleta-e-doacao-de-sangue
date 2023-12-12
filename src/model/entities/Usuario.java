package model.entities;

public class Usuario {
    private String cpf;
    private String primeiro_nome;
    private String sobrenome;
    private String cidade;
    private String estado;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private char sexo;
    private String tipo_sangue;
    private String nascimento;
    private String nacionalidade;

    public Usuario() {
    }

    public Usuario(String cpf, String primeiro_nome, String sobrenome, String cidade, String estado, String rua,
            String bairro, int numero, String cep, char sexo, String tipo_sangue, String nascimento,
            String nacionalidade) {
        this.cpf = cpf;
        this.primeiro_nome = primeiro_nome;
        this.sobrenome = sobrenome;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.sexo = sexo;
        this.tipo_sangue = tipo_sangue;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
    }

    public String toString() {
        return "{" +
                " cpf='" + getCpf() + "'" +
                ", primeiro_nome='" + getPrimeiro_nome() + "'" +
                ", sobrenome='" + getSobrenome() + "'" +
                ", cidade='" + getCidade() + "'" +
                ", estado='" + getEstado() + "'" +
                ", rua='" + getRua() + "'" +
                ", bairro='" + getBairro() + "'" +
                ", numero='" + getNumero() + "'" +
                ", cep='" + getCep() + "'" +
                ", sexo='" + getSexo() + "'" +
                ", tipo_sangue='" + getTipo_sangue() + "'" +
                ", nascimento='" + getNascimento() + "'" +
                ", nacionalidade='" + getNacionalidade() + "'" +
                "}";
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the primeiro_nome
     */
    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    /**
     * @param primeiro_nome the primeiro_nome to set
     */
    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    /**
     * @return String return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return String return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return String return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return String return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return int return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return String return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return char return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return String return the tipo_sangue
     */
    public String getTipo_sangue() {
        return tipo_sangue;
    }

    /**
     * @param tipo_sangue the tipo_sangue to set
     */
    public void setTipo_sangue(String tipo_sangue) {
        this.tipo_sangue = tipo_sangue;
    }

    /**
     * @return String return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return String return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
