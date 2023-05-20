package me.smeo.sorcerymcjobs.commands;

import me.smeo.sorcerymcjobs.SorceryMCJobs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class jobsCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 0){

                p.sendMessage(SorceryMCJobs.prefix + "&fPlease use the sub commands available.");
            }
        }

        return true;
    }
}
