package model.entities;

public class PostoEstoque {
    private String registroPosto;
    private int quantSangue;
    private String tipoSangue;

    public PostoEstoque() {
    }

    public PostoEstoque(String registroPosto, int quantSangue, String tipoSangue) {
        this.registroPosto = registroPosto;
        this.quantSangue = quantSangue;
        this.tipoSangue = tipoSangue;
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
     * @return int return the quantSangue
     */
    public int getQuantSangue() {
        return quantSangue;
    }

    /**
     * @param quantSangue the quantSangue to set
     */
    public void setQuantSangue(int quantSangue) {
        this.quantSangue = quantSangue;
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
