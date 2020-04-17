package sql.demo.model;


public class Tower extends BaseModel{
    private int IDforEdit;
    private int armor;        // Имя
    private int speed;     // Частота в день
    private int countofguns;  // Применяемый трейдером алгоритм

    public Tower() {
    }

    public Tower(long id, int IDforEdit, int armor, int speed, int countofguns) {
        super(id);
        this.IDforEdit = IDforEdit;
        this.armor = armor;
        this.speed = speed;
        this.countofguns = countofguns;
    }

    public Tower(long id, int armor, int speed, int countofguns) {
        super(id);
        this.armor = armor;
        this.speed = speed;
        this.countofguns = countofguns;
    }

    public int getIDforEdit() {
        return IDforEdit;
    }

    public void setIDforEdit(int IDforEdit) {
        this.IDforEdit = IDforEdit;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCountofguns() {
        return countofguns;
    }

    public void setCountofguns(int countofguns) {
        this.countofguns = countofguns;
    }
}