package me.smeo.sorcerymcjobs;

import me.smeo.sorcerymcjobs.DB.Database;
import me.smeo.sorcerymcjobs.commands.CommandManager;
import me.smeo.sorcerymcjobs.commands.SubCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;

public final class SorceryMCJobs extends JavaPlugin {

    public static String prefix;




    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();
        prefix = getConfig().getString("general.prefix");

        try {
            System.out.println("OE1");
            Database db = new Database(getConfig().getString("database.host"),
                    getConfig().getString("database.port"),
                    getConfig().getString("database.user"),
                    getConfig().getString("database.password"),
                    getConfig().getString("database.database_name"));
            System.out.println("OE2");
            db.initializeDatabase();
        } catch (SQLException e) {
            System.out.println("Unable to connect to the SorceryMC Database.");
        }

        getCommand("jobs").setExecutor(new CommandManager(Database.database));

        System.out.println("SorceryMCJobs loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("SorceryMCJobs has stopped>");

    }

}
