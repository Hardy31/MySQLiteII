package Lesson3_Select;

import java.sql.*;
import java.util.Scanner;

//https://www.youtube.com/watch?v=OfZpneIn7fM&list=PLt5E226f3KMHwlGPnSQGPuQsic3_2JIlv&index=4
//      !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//      !!!!!!!!!!!   ВАЖНО   !!!!!!
//для того чтобы запустить Program.main()
//Необходимо подключить Библиотеку!
//File->ProjectStructure->Libraries.add()
//        /home/alex/Загрузки/sqlite-jdbc-3.27.2.1.jar



//Sample (Образец)  - Лежит полная редакция урока Евгения Волосатова

//начиная с 9 минуты запуск через консоль


public class Program {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;



    public static void main(String[] args) throws SQLException {
        Program program = new Program();
        program.open();
//        program.insert();
        program.select();
        program.close();
    }


    public Program() {
    }

    void open(){
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./users2.db");
            System.out.println("База Подключена!");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    void insert() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите Имя пользьзователя : ");
        String name = scan.nextLine();
        System.out.println("Введите Имя пользьзователя : ");
        String phone = scan.nextLine();

        String query = "INSERT INTO users2.db (name,phone) VALUES ('"+ name +"','"+ phone +"');";
        statmt = conn.createStatement();
        statmt.executeUpdate(query);

        System.out.println("Данные добавлены!" + query );
        statmt.close();
    }

    void close(){
        try {
            conn.close();
            System.out.println("Соединение с БД закрыто!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void select(){
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM users2 ORDER BY name ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                System.out.println(id +"   "+name +"     \t "+phone );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

//        try {
//            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection("jdbc:sqlite:./us.db");
//            System.out.println("База Подключена!");
//            CreateDB();
//            WriteDB();
//            ReadDB();
//            CloseDB();
//        } catch (Exception var5) {
//            System.out.println(var5.getMessage());
//        }
//
//    }

//    public static void createDB() throws ClassNotFoundException, SQLException {
//        statmt = conn.createStatement();
//        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
//        System.out.println("Таблица создана или уже существует.");
//    }

//    public static void writeDB() throws SQLException {
//        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
//        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
//        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
//        System.out.println("Таблица заполнена");
//    }
//
//    public static void readDB() throws ClassNotFoundException, SQLException {
//        resSet = statmt.executeQuery("SELECT * FROM users");
//
//        while(resSet.next()) {
//            int var0 = resSet.getInt("id");
//            String var1 = resSet.getString("name");
//            String var2 = resSet.getString("phone");
//            System.out.println("ID = " + var0);
//            System.out.println("name = " + var1);
//            System.out.println("phone = " + var2);
//            System.out.println();
//        }
//
//        System.out.println("Таблица выведена");
//    }

//    public static void closeDB() throws ClassNotFoundException, SQLException {
//        conn.close();
//        statmt.close();
//        resSet.close();
//        System.out.println("Соединения закрыты");
//    }


}

