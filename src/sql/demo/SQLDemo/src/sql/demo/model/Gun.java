package sql.demo.model;

// Модель акции GUN
public class Gun extends BaseModel{

    private int IDforEdit;
    private int caliber;    // калибр
    private int lenth; //  длина орудия
    private String TypeOfPew;   // тип снарядов

    public Gun() {
    }

    public Gun(long id, int IDforEdit, int caliber, int lenth, String typeOfPew) {
        super(id);
        this.IDforEdit = IDforEdit;
        this.caliber = caliber;
        this.lenth = lenth;
        TypeOfPew = typeOfPew;
    }

    public Gun(long id, int caliber, int lenth, String TypeOfPew) {
        super(id);
        this.caliber = caliber;
        this.lenth = lenth;
        this.TypeOfPew = TypeOfPew;
    }

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public int getLenth() {
        return lenth;
    }

    public void setLenth(int lenth) {
        this.lenth = lenth;
    }

    public String getTypeOfPew() {
        return TypeOfPew;
    }

    public void setTypeOfPew(String typeOfPew) {
        TypeOfPew = typeOfPew;
    }

    public int getIDforEdit() {
        return IDforEdit;
    }

    public void setIDforEdit(int IDforEdit) {
        this.IDforEdit = IDforEdit;
    }
}