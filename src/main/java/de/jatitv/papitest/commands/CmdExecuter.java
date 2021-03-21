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
        if (sender.hasPermission("papitest.admin") || sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage(Main.PrefixHC + "§cPlease use §6/papitest §7%placeholder%");
            } else {
                switch (args[0].toLowerCase()) {
                    case "info":
                    case "plugin":
                    case "pl":
                    case "version":
                    case "ver":
                        if (sender.hasPermission("papitest.admin") || sender.isOp()) {
                            sender.sendMessage(Main.PrefixHC + "§8-------- §4Plugin-Info §8--------");
                            sender.sendMessage(Main.PrefixHC + "§2This plugin was developed by §9JaTiTV");
                            sender.sendMessage(Main.PrefixHC + "§2");
                            sender.sendMessage(Main.PrefixHC + "§2Twitch: §ehttps://www.twitch.tv/jatitv");
                            sender.sendMessage(Main.PrefixHC + "§2Support-Discord: §e" + Main.DiscordLink);
                            sender.sendMessage(Main.PrefixHC + "§2Spigot: §e" + Main.Spigot);
                            sender.sendMessage(Main.PrefixHC + "§2");
                            sender.sendMessage(Main.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                            if (!Main.PaPi) {
                                sender.sendMessage(Main.PrefixHC + "§8-----------------------------");
                                sender.sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! §9Please download it here: " +
                                        "§6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                                sender.sendMessage(Main.PrefixHC + "§8-----------------------------");
                            }
                            sender.sendMessage(Main.PrefixHC + "§8-----------------------------");
                        }
                        break;
                    case "reload":
                    case "rl":
                        try {
                            Reload.reload(sender);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        if (Main.PaPi) {
                            if (sender instanceof Player) {
                                Player player = (Player) sender;
                                sender.sendMessage(Main.PrefixHC + "§b" + args[0] + " §7-> " + "§6" + PlaceholderAPI.setPlaceholders(player, args[0]));
                                if (!Main.minecraft1_8 && Config.Titel) {
                                    player.sendTitle("§5PaPi§6Test§8: " + "§b" + args[0], "§6" + PlaceholderAPI.setPlaceholders(player, args[0]));
                                }
                            } else {
                                sender.sendMessage(Main.PrefixHC + "§4Placeholders can be tested only by players and not from the Console!");
                            }
                        } else {
                            Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                                    "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                            if (sender instanceof Player) {
                                sender.sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! §9Please download it here: " +
                                        "§6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                            }
                        }
                        break;
                }
            }
        } else {
            sender.sendMessage(Main.PrefixHC + "§cYou do not have permission for §5PaPi§6Test§c!");
        }
        return false;
    }
}
