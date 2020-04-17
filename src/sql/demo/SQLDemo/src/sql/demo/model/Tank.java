package sql.demo.model;

import java.time.LocalDateTime;


public class Tank extends BaseModel {

    private int IDforEdit;
    private String country;         // собственно операция (buy, sell)
    private String name;    // калибр
    private String yearofproduction; //  длина орудия

    public Tank() {
    }

    public Tank(long id, int IDforEdit,String name, String country, String yearofproduction) {
        super(id);
        this.IDforEdit = IDforEdit;
        this.country = country;
        this.name = name;
        this.yearofproduction = yearofproduction;
    }

    public Tank(long id, String name,String country, String yearofproduction) {
        super(id);
        this.name = name;
        this.country = country;
        this.yearofproduction = yearofproduction;
    }

    public int getIDforEdit() {
        return IDforEdit;
    }

    public void setIDforEdit(int IDforEdit) {
        this.IDforEdit = IDforEdit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearofproduction() {
        return yearofproduction;
    }

    public void setYearofproduction(String yearofproduction) {
        this.yearofproduction = yearofproduction;
    }
}