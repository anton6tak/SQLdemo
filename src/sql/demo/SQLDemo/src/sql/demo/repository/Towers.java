package sql.demo.repository;

import sql.demo.model.Tower;

import java.sql.SQLException;

public class Towers extends BaseTable implements TableOperations {
    public Towers() throws SQLException {
        super("TOWERS");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS TOWERS (" +
                //"id INTEGER NOT NULL," +
                "id BIGINT PRIMARY KEY," +
                "armor INTEGER NOT NULL," +
                "speed INTEGER NOT NULL," +
                "countofguns INTEGER NOT NULL)", "Создана таблица " + tableName);
    }

    public void AddNewItem(Tower tower) throws SQLException {
        super.executeSqlStatement("INSERT INTO TOWERS VALUES ('"+tower.getId()+"', '"
                +tower.getArmor()+"', '"
                +tower.getSpeed()+"', '"
                +tower.getCountofguns()+"') ");
    }

    public void EditThisItem(Tower tower) throws SQLException {
        super.executeSqlStatement("UPDATE TOWERS SET armor = "+tower.getArmor()
                +", speed = "+tower.getSpeed()
                +", countofguns = " +tower.getCountofguns()
                +" WHERE id = " +tower.getIDforEdit());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}