package model.entities;

public class Doador extends Usuario {
    private float altura;
    private float peso;
    private String estado_civil;
    private int n_doacoes;

    public Doador() {
    }

    public Doador(float altura, float peso, String estado_civil, int n_doacoes) {
        this.altura = altura;
        this.peso = peso;
        this.estado_civil = estado_civil;
        this.n_doacoes = n_doacoes;
    }

    /**
     * @return float return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * @return float return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return String return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
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
                " altura='" + getAltura() + "'" +
                ", peso='" + getPeso() + "'" +
                ", estado_civil='" + getEstado_civil() + "'" +
                ", n_doacoes='" + getN_doacoes() + "'" +
                "}";
    }
}
