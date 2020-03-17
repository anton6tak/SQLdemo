package sql.demo.model;

import java.time.LocalDateTime;


public class Body extends BaseModel{
    private int IDforEdit;
    private int armor ; // Время выставления курса
    private int weight;             // Акция, для которой задается курс
    private int persons;            // Курс акции

    public Body() {
    }

    public Body(long id, int IDforEdit, int armor, int weight, int persons) {
        super(id);
        this.IDforEdit = IDforEdit;
        this.armor = armor;
        this.weight = weight;
        this.persons = persons;
    }

    public Body(long id, int armor, int weight, int persons) {
        super(id);
        this.armor = armor;
        this.weight = weight;
        this.persons = persons;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getIDforEdit() {
        return IDforEdit;
    }

    public void setIDforEdit(int IDforEdit) {
        this.IDforEdit = IDforEdit;
    }
}