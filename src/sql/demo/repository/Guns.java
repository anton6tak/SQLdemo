package sql.demo.repository;

import sql.demo.model.Gun;

import java.sql.SQLException;

public class Guns extends BaseTable implements TableOperations{

    public Guns() throws SQLException {
        super("GUNS");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS GUNS(" +
                // "id INTEGER NOT NULL," +
                "id BIGINT PRIMARY KEY," +
                "caliber INTEGER NOT NULL," +
                "lenth INTEGER NOT NULL,"+
                "TypeOfPew VARCHAR(1000) NOT NULL)", "Создана таблица " + tableName);
    }

    public void AddNewItem(Gun gun) throws SQLException {
        super.executeSqlStatement("INSERT INTO GUNS VALUES ('"+gun.getId()+"', '"
                +gun.getCaliber()+"', '"
                +gun.getLenth()+"', '"
                +gun.getTypeOfPew()+"') ");
    }

    public void EditThisItem(Gun gun) throws SQLException {
        super.executeSqlStatement("UPDATE GUNS SET caliber = "+gun.getCaliber()
                +", lenth = "+gun.getLenth()
                +", TypeOfPew = '" +gun.getTypeOfPew()
                +"' WHERE id = " +gun.getIDforEdit());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}