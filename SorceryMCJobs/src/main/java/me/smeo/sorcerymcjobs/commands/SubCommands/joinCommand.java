package me.smeo.sorcerymcjobs.commands.SubCommands;

import me.smeo.sorcerymcjobs.DB.Database;
import me.smeo.sorcerymcjobs.SorceryMCJobs;
import me.smeo.sorcerymcjobs.commands.SubCommand;
import org.bukkit.entity.Player;

import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;



public class joinCommand extends SubCommand {

    private Database database;
    public joinCommand(Database database) {
        this.database = database;
    }

    @Override
    public String getName() {
        return "join";
    }

    @Override
    public String getDescription() {
        return "to join a job";
    }

    @Override
    public String getSyntax() {
        return "/jobs join <job>";
    }

    @Override
    public void perform(Player player, String[] args) {
        System.out.println("JobJoin1");
        if (args.length > 1){
            System.out.println("JobJoin2");
            String uuid = String.valueOf(player.getUniqueId());
            System.out.println("JobJoin3");
            String job = String.valueOf(args[0]);
            System.out.println("JobJoin4");
            try{
                database = Database.database;
                database.setJob(uuid, job);
                System.out.println("JobJoin5");
                player.sendMessage("Your job is now set to " + job);
            } catch (SQLException e) {
                System.out.println("Failed to set new job for " + player.getName());
            }
        }
    }



}
