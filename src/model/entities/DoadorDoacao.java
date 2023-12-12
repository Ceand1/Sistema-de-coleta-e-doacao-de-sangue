package model.entities;

import java.sql.Timestamp;

public class DoadorDoacao {
    private String cpfDoador;
    private String registroPosto;
    private Timestamp dataDoacao;
    private String tipoSangue;
    private String nomeDoador;
    private String sobrenomeDoador;

    public DoadorDoacao() {
    }

    public DoadorDoacao(String cpfDoador, String registroPosto, Timestamp dataDoacao, String tipoSangue) {
        this.cpfDoador = cpfDoador;
        this.registroPosto = registroPosto;
        this.dataDoacao = dataDoacao;
        this.tipoSangue = tipoSangue;
    }
    public DoadorDoacao comNome( String nomeDoador) {
        this.nomeDoador = nomeDoador;
        return this;
    }

    public DoadorDoacao comSobrenome(String sobrenomeDoador) {
        this.sobrenomeDoador = sobrenomeDoador;
        return this;
    }

    /**
     * @return String return the cpfDoador
     */
    public String getCpfDoador() {
        return cpfDoador;
    }

     /**
     * @return String return the nomeDoador
     */
    public String getNomeDoador() {
        return this.nomeDoador;
    }

     /**
     * @return String return the sobrenomeDoador
     */
    public String getSobrenomeDoador() {
        return this.sobrenomeDoador;
    }

    /**
     * @param cpfDoador the cpfDoador to set
     */
    public void setCpfDoador(String cpfDoador) {
        this.cpfDoador = cpfDoador;
    }

    /**
     * @return String return the registroPosto
     */
    public String getRegistroPosto() {
        return registroPosto;
    }

    /**
     * @param registroPosto the registroPosto to set
     */
    public void setRegistroPosto(String registroPosto) {
        this.registroPosto = registroPosto;
    }

    /**
     * @return Timestamp return the dataDoacao
     */
    public Timestamp getDataDoacao() {
        return dataDoacao;
    }

    /**
     * @param dataDoacao the dataDoacao to set
     */
    public void setDataDoacao(Timestamp dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    /**
     * @return String return the tipoSangue
     */
    public String getTipoSangue() {
        return tipoSangue;
    }

    /**
     * @param tipoSangue the tipoSangue to set
     */
    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

}
