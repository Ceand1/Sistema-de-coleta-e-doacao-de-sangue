package model.entities;

import java.sql.Timestamp;

public class ReceptorRecebe {
    private String cpfReceptor;
    private String registroPosto;
    private Timestamp dataReceber;
    private String tipoSangue;
    private String nomeReceptor;
    private String sobrenomeReceptor;

    public ReceptorRecebe() {
    }

    public ReceptorRecebe(String cpfReceptor, String registroPosto, Timestamp dataReceber, String tipoSangue) {
        this.cpfReceptor = cpfReceptor;
        this.registroPosto = registroPosto;
        this.dataReceber = dataReceber;
        this.tipoSangue = tipoSangue;
    }
    public ReceptorRecebe comNome( String nomeReceptor) {
        this.nomeReceptor = nomeReceptor;
        return this;
    }

    public ReceptorRecebe comSobrenome(String sobrenomeReceptor) {
        this.sobrenomeReceptor = sobrenomeReceptor;
        return this;
    }
   
    /**
     * @return String return the cpfDoador
     */
    public String getCpfReceptor() {
        return cpfReceptor;
    }

    /**
     * @param cpfDoador the cpfDoador to set
     */
    public void setCpfReceptor(String cpfReceptor) {
        this.cpfReceptor = cpfReceptor;
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
    public Timestamp getDataReceber() {
        return dataReceber;
    }

    /**
     * @param dataDoacao the dataDoacao to set
     */
    public void setDataReceber(Timestamp dataReceber) {
        this.dataReceber = dataReceber;
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

    /**
     * @return String return the NomeReceptor
     */
    public String getPrimeiroNome() {
        return this.nomeReceptor;
    }

    /**
     * @return String return the NomeReceptor
     */
    public String getSobrenome() {
        return this.sobrenomeReceptor;
    }

}
