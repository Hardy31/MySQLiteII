package Lesson1_SQLite_Connect;

import java.sql.*;



//      !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//      !!!!!!!!!!!   ВАЖНО   !!!!!!
//для того чтобы запустить Program.main()
//Необходимо подключить Библиотеку!
//File->ProjectStructure->Libraries.add()
//        /home/alex/Загрузки/sqlite-jdbc-3.27.2.1.jar



//Sample (Образец)  - Лежит полная редакция урока Евгения Волосатова

//начиная с 9 минуты запуск через консоль


public class Program {

    public static void main(String[] var0) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:us.db");
            System.out.println("База Подключена!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

