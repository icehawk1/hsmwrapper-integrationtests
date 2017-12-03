package com.escrypt.cycurkeys.hsmwrapper;

import java.time.LocalDate;

public class MyBean {
    private int zahl;
    private LocalDate datum;
    private String vorname;
    private String nachname;
    private NochNeBean objekt;

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public NochNeBean getObjekt() {
        return objekt;
    }

    public void setObjekt(NochNeBean objekt) {
        this.objekt = objekt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyBean myBean = (MyBean) o;

        if (zahl != myBean.zahl) return false;
        if (!datum.equals(myBean.datum)) return false;
        if (!vorname.equals(myBean.vorname)) return false;
        if (!nachname.equals(myBean.nachname)) return false;
        return objekt.equals(myBean.objekt);
    }

    @Override
    public int hashCode() {
        int result = zahl;
        result = 31 * result + datum.hashCode();
        result = 31 * result + vorname.hashCode();
        result = 31 * result + nachname.hashCode();
        result = 31 * result + objekt.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "zahl=" + zahl +
                ", datum=" + datum +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", objekt=" + objekt +
                '}';
    }
}
