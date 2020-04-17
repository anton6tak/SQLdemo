package sql.demo.repository;

import sql.demo.model.Body;

import java.sql.SQLException;

public class Bodies extends BaseTable implements TableOperations{
    public Bodies() throws SQLException {
        super("BODIES");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS BODIES(" +
               // "id INTEGER NOT NULL," +
                "id BIGINT PRIMARY KEY," +
                "armor INTEGER NOT NULL," +
                "weight INTEGER NOT NULL,"+
                "persons INTEGER NOT NULL)", "Создана таблица " + tableName);
    }

    public void AddNewItem(Body body) throws SQLException {
        super.executeSqlStatement("INSERT INTO BODIES VALUES ('"+body.getId()+"', '"
                //super.executeSqlStatement("INSERT INTO BODIES (armor, weight, persons) VALUES ('"
                +body.getArmor()+"', '"
                +body.getWeight()+"', '"
                +body.getPersons()+"') ");
    }

    public void EditThisItem(Body body) throws SQLException {
        super.executeSqlStatement("UPDATE BODIES SET armor = "+body.getArmor()
                +", weight = "+body.getWeight()
                +", persons = '" +body.getPersons()
                +"' WHERE id = " +body.getIDforEdit());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}