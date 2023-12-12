package model.entities;

public class Posto {
    private String n_registro;
    private String cidade;
    private String estado;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private int n_doacoes;

    public Posto() {
    }

    public Posto(String n_registro, String cidade, String estado, String rua, String bairro, int numero, String cep,
            int n_doacoes) {
        this.n_registro = n_registro;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.n_doacoes = n_doacoes;
    }

    /**
     * @return String return the n_registro
     */
    public String getN_registro() {
        return n_registro;
    }

    /**
     * @param n_registro the n_registro to set
     */
    public void setN_registro(String n_registro) {
        this.n_registro = n_registro;
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
     * @return int return the n_doacoes
     */
    public int getN_doacoes() {
        return n_doacoes;
    }

    /**
     * @param n_doacoes the n_doacoes to set
     */
    public void setN_doacoes(int n_doacoes) {
        this.n_doacoes = n_doacoes;
    }

    @Override
    public String toString() {
        return "{" +
                " n_registro='" + getN_registro() + "'" +
                ", cidade='" + getCidade() + "'" +
                ", estado='" + getEstado() + "'" +
                ", rua='" + getRua() + "'" +
                ", bairro='" + getBairro() + "'" +
                ", numero='" + getNumero() + "'" +
                ", cep='" + getCep() + "'" +
                ", n_doacoes='" + getN_doacoes() + "'" +
                "}";
    }

}
