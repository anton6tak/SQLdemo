package sql.demo;

import sql.demo.repository.*;
import java.sql.*;

public class StockExchangeDB {
    // Блок объявления констант
    public static final String DB_URL = "jdbc:h2:/C:/Users/anton/IdeaProjects/SQLDemo/db/tanks";
    public static final String DB_Driver = "org.h2.Driver";

    // Таблицы СУБД
    Towers TOWERS;
    Bodies BODIES;
    Guns GUNS;
    Tanks TANKS;

    // Получить новое соединение с БД
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Инициализация
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        TOWERS = new Towers();
        GUNS = new Guns();
        BODIES = new Bodies();
        TANKS = new Tanks();
    }

    // Создание всех таблиц и ключей между ними
    public void CreateTables() throws SQLException {
        GUNS.createTable();
        BODIES.createTable();
        TOWERS.createTable();
        TANKS.createTable();

    }

    public void CleArllTables() throws SQLException {
        GUNS.ClearTabel();
       // shareRates.ClearTabel();
        TOWERS.ClearTabel();
        TANKS.ClearTabel();
        BODIES.ClearTabel();
       // traiderShareActions.ClearTabel();
    }

    public void DeleteAllTables() throws SQLException {
        GUNS.deleteTable();
        // shareRates.ClearTabel();
        TOWERS.deleteTable();
        TANKS.ClearTabel();
        BODIES.deleteTable();
        // traiderShareActions.ClearTabel();
    }

    public void PrintllTables() throws SQLException {
       /* GUNS.printAllTabel();
        //shareRates.printAllTabel();
        TOWERS.printAllTabel();
        TANKS.printAllTabel();
        BODIES.printAllTabel();*/

        TANKS.printAllTabel("TANKS","TOWERS","BODIES","GUNS");
       // System.out.println("//////////////////////");
        //traiderShareActions.printAllTabel();
    }

    public int getmaxid() throws SQLException
    {
        return BODIES.GetMaxId();
    }


    public static void main(String[] args) {
        try{

            StockExchangeDB stockExchangeDB = new StockExchangeDB();

           stockExchangeDB.DeleteAllTables();
            stockExchangeDB.CreateTables();
           //stockExchangeDB.CleArllTables();

            ZView theView = new ZView();
            ZModel theModel = new ZModel();

            ZController theController = new ZController(theView, theModel, stockExchangeDB);
            theController.GlobalID = stockExchangeDB.getmaxid()+1;
            theView.setVisible(true);

            System.out.println("/////////////////");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC драйвер для СУБД не найден!");
        }
    }
}