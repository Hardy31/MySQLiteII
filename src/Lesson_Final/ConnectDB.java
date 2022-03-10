package Lesson_Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Если не подключать библилтеку
// запускаем  терминал
//В каталоге должен быть jar               ---    sqlite-jdbc-3.27.2.1.jar
//В каталоге должна быть  DB                  ---  us.db

// переходим в каталог                   ---     /home/alex/Hardy/MySQLite/src/
//запускаем компилятор                          ---     javac Program.java
//и затем запускаем программу                   ---     java -cp sqlite-jdbc-3.27.2.1.jar:.  Program


// Если не подключать библилтеку -

// File=> ProjectStructure -> Libraries.add
//     /home/alex/Загрузки/sqlite-jdbc-3.27.2.1.jar
//apply

public class ConnectDB {

    public static Connection conn;

    public static void main(String[] var0) throws ClassNotFoundException, SQLException {

        conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:us.db");
            System.out.println("База Подключена!");

        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

    }
}
