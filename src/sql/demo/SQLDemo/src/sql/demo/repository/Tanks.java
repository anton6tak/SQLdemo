package sql.demo.repository;

import sql.demo.model.Tank;

import java.sql.SQLException;

public class Tanks extends BaseTable implements TableOperations{
    public Tanks() throws SQLException {
        super("TANKS");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS TANKS(" +
                //"id INTEGER NOT NULL," +
                "id BIGINT PRIMARY KEY," +
                "name VARCHAR(1000) NOT NULL," +
                "CountryName VARCHAR(1000) NOT NULL,"+
                "TankYearOfProduct VARCHAR(1000) NOT NULL)", "Создана таблица " + tableName);
    }

    public void AddNewItem(Tank tank) throws SQLException {
        super.executeSqlStatement("INSERT INTO TANKS VALUES ('"+tank.getId()+"', '"
                +tank.getName()+"', '"
                +tank.getCountry()+"', '"
                +tank.getYearofproduction()+"') ");
    }

    public void EditThisItem(Tank tank) throws SQLException {
        super.executeSqlStatement("UPDATE TANKS SET name = '"+tank.getName()
                +"', CountryName = '"+tank.getCountry()
                +"', TankYearOfProduct = '" +tank.getYearofproduction()
                +"' WHERE id = "+tank.getIDforEdit());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}