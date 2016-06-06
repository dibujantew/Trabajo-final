package Beans;

public class Atleta {

    private int cod_atl;
    private String nom_atl;
    private int dni_atl;
    private String sex_atl;
    private int eda_atl;
    private double talla;

    public Atleta() {
    }

    public Atleta(int cod_atl, String nom_atl, int dni_atl, String sex_atl, int eda_atl, double talla) {
        this.cod_atl = cod_atl;
        this.nom_atl = nom_atl;
        this.dni_atl = dni_atl;
        this.sex_atl = sex_atl;
        this.eda_atl = eda_atl;
        this.talla = talla;
    }

    /**
     * @return the cod_atl
     */
    public int getCod_atl() {
        return cod_atl;
    }

    /**
     * @param cod_atl the cod_atl to set
     */
    public void setCod_atl(int cod_atl) {
        this.cod_atl = cod_atl;
    }

    /**
     * @return the nom_atl
     */
    public String getNom_atl() {
        return nom_atl;
    }

    /**
     * @param nom_atl the nom_atl to set
     */
    public void setNom_atl(String nom_atl) {
        this.nom_atl = nom_atl;
    }

    /**
     * @return the dni_atl
     */
    public int getDni_atl() {
        return dni_atl;
    }

    /**
     * @param dni_atl the dni_atl to set
     */
    public void setDni_atl(int dni_atl) {
        this.dni_atl = dni_atl;
    }

    /**
     * @return the sex_atl
     */
    public String getSex_atl() {
        return sex_atl;
    }

    /**
     * @param sex_atl the sex_atl to set
     */
    public void setSex_atl(String sex_atl) {
        this.sex_atl = sex_atl;
    }

    /**
     * @return the eda_atl
     */
    public int getEda_atl() {
        return eda_atl;
    }

    /**
     * @param eda_atl the eda_atl to set
     */
    public void setEda_atl(int eda_atl) {
        this.eda_atl = eda_atl;
    }

    /**
     * @return the talla
     */
    public double getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(double talla) {
        this.talla = talla;
    }

}
