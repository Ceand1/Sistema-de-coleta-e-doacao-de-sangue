package model.entities;

public class Usuario_email {
    private String cpfUsuario;
    private String email;

    public Usuario_email() {
    }

    public Usuario_email(String cpfUsuario, String email) {
        this.cpfUsuario = cpfUsuario;
        this.email = email;
    }

    /**
     * @return String return the cpfUsuario
     */
    public String getCpfUsuario() {
        return cpfUsuario;
    }

    /**
     * @param cpfUsuario the cpfUsuario to set
     */
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
