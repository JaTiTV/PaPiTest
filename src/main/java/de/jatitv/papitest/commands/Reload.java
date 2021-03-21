// This claas was created by JaTiTV


package de.jatitv.papitest.commands;

import de.jatitv.papitest.config.Config;
import de.jatitv.papitest.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload {

    public static void reload(CommandSender sender) throws InterruptedException {
        if (sender instanceof Player) {
            sender.sendMessage(Main.PrefixHC + "§6Plugin reload...");
        }

        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§6Plugin reload...");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§8-------------------------------");

        Config.configCreate();

        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2");

        if (Main.PaPi) {
            if (sender instanceof Player) {
                sender.sendMessage(Main.PrefixHC + "§2PlaceholderAPI successfully connected!");
                Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2PlaceholderAPI successfully connected!");
            } else Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2PlaceholderAPI successfully connected!");
        } else {
            if (sender instanceof Player) {
                sender.sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                        "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
                Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                        "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
            } else Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                    "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
        }

        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2");
        if (sender instanceof Player) {
            sender.sendMessage(Main.PrefixHC + "§2Plugin successfully reloaded.");
        }
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2Plugin successfully reloaded.");
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§8-------------------------------");
    }
}