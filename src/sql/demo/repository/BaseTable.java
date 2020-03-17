package sql.demo.repository;

import sql.demo.StockExchangeDB;

import java.io.Closeable;
import java.sql.*;
import java.util.Vector;

// Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц
public class BaseTable implements Closeable {
    Connection connection;  // JDBC-соединение для работы с таблицей
    String tableName;       // Имя таблицы

    BaseTable(String tableName) throws SQLException { // Для реальной таблицы передадим в конструктор её имя
        this.tableName = tableName;
        this.connection = StockExchangeDB.getConnection(); // Установим соединение с СУБД для дальнейшей работы
    }

    // Закрытие
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    // Выполнить SQL команду без параметров в СУБД, по завершению выдать сообщение в консоль
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    };

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    };


    // Активизация соединения с СУБД, если оно не активно.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
  /*  public void printAllTabel() throws SQLException {


        Statement st = null;
        ResultSet rs = null;
        st = connection.createStatement();
        rs = st.executeQuery("SELECT *FROM "+tableName);
        int numColumns = rs.getMetaData().getColumnCount();
        System.out.println("TABEL "+tableName+":");
        while (rs.next()) {
            for (int i = 1; i <= numColumns; i++) {
                System.out.print(rs.getString(i)+" ");
            }
            System.out.println();
        }
    }
*/

    public void printAllTabel(String tablename1, String tablename2, String tablename3, String tablename4 ) throws SQLException {

        Vector<String> V1 = new Vector<>();
        Vector<String> V2 = new Vector<>();
        Vector<String> V3 = new Vector<>();
        Vector<String> V4 = new Vector<>();

        Statement st = null;
        ResultSet rs = null;
        st = connection.createStatement();
        {
            rs = st.executeQuery("SELECT *FROM "+tablename1);
            int numColumns = rs.getMetaData().getColumnCount();
           // System.out.println("TABEL "+tablename1+":");
            while (rs.next()) {
                for (int i = 1; i <= numColumns; i++) {
                    V1.add(rs.getString(i)+" ");
                }
            }
            {
                rs = st.executeQuery("SELECT *FROM " + tablename2);

               // System.out.println("TABEL " + tablename2 + ":");
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; i++) {
                        V2.add(rs.getString(i) + " ");
                    }
                }
            }
            {
                rs = st.executeQuery("SELECT *FROM " + tablename3);

                //System.out.println("TABEL " + tablename3 + ":");
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; i++) {
                        V3.add(rs.getString(i) + " ");
                    }
                }
            }
            {
                rs = st.executeQuery("SELECT *FROM " + tablename4);

               // System.out.println("TABEL " + tablename4 + ":");
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; i++) {
                        V4.add(rs.getString(i));
                    }
                }
            }
            System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n",tablename1, tablename2, tablename3, tablename4);
            System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n","----------", "----------", "----------", "----------");
            //for(int i=1; i<numColumns; i++)
            int j=1;
            while(j<numColumns*V1.size()/3-1)
            {
                if(j%4 ==0)
                {
                    j++;
                    System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n","----------", "----------", "----------", "----------");
                    continue;
                }
                System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n", V1.get(j), V2.get(j), V3.get(j), V4.get(j));
                j++;
            }
            //System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n","----------", "----------", "----------", "----------");
        }
    }

    public int GetMaxId() throws SQLException {

        Statement st = null;
        ResultSet rs = null;
        st = connection.createStatement();
        rs = st.executeQuery("SELECT MAX(id) as maxid FROM "+tableName);
        rs.next();
        String s = rs.getString(1);
        if(s!= null)
            return Integer.parseInt(s);
        else return 0;
    }

   /* public void printOneItem() throws SQLException {

        //super.executeSqlStatement("SELECT * FROM GUN");
        Statement st = null;
        ResultSet rs = null;
        st = connection.createStatement();
        rs = st.executeQuery("SELECT *FROM "+tableName);
        int num = this.
        System.out.println("TABEL "+tableName+":");
        System.out.print(rs.getString(num)+" ");

            System.out.println();
        }
    }*/

    public void deleteTable() throws SQLException {
        executeSqlStatement("DROP TABLE "+tableName);
    }

    public void ClearTabel() throws SQLException {
        executeSqlStatement("TRUNCATE TABLE "+tableName);
    }
}