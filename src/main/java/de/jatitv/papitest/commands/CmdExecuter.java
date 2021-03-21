// This claas was created by JaTiTV

package de.jatitv.papitest.commands;

import de.jatitv.papitest.config.Config;
import de.jatitv.papitest.system.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CmdExecuter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender.hasPermission("papitest.command") || sender.isOp()) {
            if (args.length == 0) {

                sender.sendMessage(Main.PrefixHC + "§cPlease use §6/papitest §7%placeholder%");
            } else {
                if (args.length == 1) {
                    if (args[0].equals("reload")) {
                        try {
                            Reload.reload(sender);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (Main.PaPi) {
                            if (sender instanceof Player) {
                                Player player = (Player) sender;
                                sender.sendMessage(Main.PrefixHC + "§b" + args[0] + " §7-> " + "§6" + PlaceholderAPI.setPlaceholders(player, "%" + args[0].replace("%", "") + "%"));
                                if (!Main.minecraft1_8 && Config.Titel) {
                                    player.sendTitle("§5PaPi§6Test§8: " + "§b" + "%" + args[0].replace("%", "") + "%", "§6" + PlaceholderAPI.setPlaceholders(player, "%" + args[0].replace("%", "") + "%"));
                                }
                            } else {
                                sender.sendMessage( Main.PrefixHC + "§4Placeholders can be tested only by players and not from the Console!");
                            }
                        } else {
                            Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                                    "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                            if (sender instanceof Player) {
                                sender.sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! §9Please download it here: " +
                                        "§6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                            }
                        }
                    }

                }
            }
        } else {
            sender.sendMessage(Main.PrefixHC + "§cYou do not have permission for §5PaPi§6Test!");
        }
        return false;
    }
}
