package me.smeo.sorcerymcjobs.DB;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.UUID;

public class Database {

    public static Database database;

    private final String HOST;
    private final String PORT;
    private final String USER;
    private final String PASSWORD;
    private final String DATABASE_NAME;

    public Database(String HOST, String PORT, String USER, String PASSWORD, String DATABASE_NAME) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.DATABASE_NAME = DATABASE_NAME;

    }



    private static Connection connection;


    public Connection getConnection() throws SQLException{
        if(connection != null){
            return connection;
        }
            System.out.println("C1");
            String url = "jdbc:mysql://" + this.HOST + "/" + this.DATABASE_NAME;
            System.out.println(url);
            System.out.println(this.HOST);
            System.out.println(this.DATABASE_NAME);
            String user = "customer_484271_mainsorcerymc";
            String password = "#-OW7tXuYpVvySXGJ45y";
            System.out.println("C2");
            System.out.println(this.USER);
            System.out.println(this.PASSWORD);
            this.connection = DriverManager.getConnection(url, this.USER, this.PASSWORD);
            System.out.println("C3");
            System.out.println("Connected to the SorceryMC Database");

            return this.connection;


    }

    public void initializeDatabase() throws SQLException{
        System.out.println("Attempting to initialize database.");
        Statement statement = getConnection().createStatement();
        System.out.println("I1");
        String sql = "CREATE TABLE IF NOT EXISTS player_Jobs(uuid varchar(36) primary key, job varchar(36), jobStart DATE)";
        statement.execute(sql);
        System.out.println("I2");
        statement.close();
        System.out.println("Jobs table crated in the SMC database.");

    }
    public void setJob(String uuid, String newJob) throws SQLException{
        Statement statement = getConnection().createStatement();
        String sql = "UPDATE player_Jobs SET job = " + newJob + ", jobStart = " + LocalDate.now() + " WHERE uuid = " + uuid;
        statement.execute(sql);

        statement.close();

    }

    public void addPlayerToDatabase(String uuid) throws SQLException{
        Statement statement = getConnection().createStatement();
        String sql ="INSERT INTO player_Jobs VALUES("+uuid+", NULL, NULL;";
        statement.execute(sql);
        statement.close();
    }


}
