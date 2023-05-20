package me.smeo.sorcerymcjobs.commands;

import me.smeo.sorcerymcjobs.DB.Database;
import me.smeo.sorcerymcjobs.commands.SubCommands.joinCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private final Database database;
    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager(Database database){
        this.database = database;
        subcommands.add(new joinCommand(database));
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length > 0){
                for(int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }
}
