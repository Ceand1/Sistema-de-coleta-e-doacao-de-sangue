package model.entities;

public class Receptor extends Usuario {
    private String estado_saude;

    public Receptor() {
    }

    public Receptor(String estado_saude) {
        this.estado_saude = estado_saude;
    }

    /**
     * @return String return the estado_saude
     */
    public String getEstado_saude() {
        return estado_saude;
    }

    /**
     * @param estado_saude the estado_saude to set
     */
    public void setEstado_saude(String estado_saude) {
        this.estado_saude = estado_saude;
    }

    @Override
    public String toString() {
        return "{" +
                " estado_saude='" + getEstado_saude() + "'" +
                "}";
    }

}
