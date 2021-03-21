// This claas was created by JaTiTV

package de.jatitv.papitest.system;

import de.jatitv.papitest.commands.CmdExecuter;
import de.jatitv.papitest.commands.TabComplete;
import de.jatitv.papitest.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    // Debug Settings
    public static String PrefixHC = "§8[§5PaPi§6Test§8] ";
    public static String Autor = "JaTiTV";
    public static String Spigot = "https://www.spigotmc.org/resources/papitest.90439/";
    public static String DiscordLink = "https://discord.gg/vRyXFFterJ";
    public static String DiscordMSG = "You want to discuss and decide about current bugs, planned updates, new features?\n" +
            "Then come to our Discord. " + DiscordLink;


    // ---------------------------------------------

    public static Main plugin;
    public static Plugin a;
    public static String update_version = null;
    public static Boolean PaPi = false;
    public static boolean minecraft1_8;

    public static Main getPlugin() {
        return plugin;
    }

    public static Plugin thisp() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        a = this;
        minecraft1_8 = Bukkit.getServer().getClass().getPackage().getName().contains("1_8");

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            PaPi = true;
        }

        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§4Plugin load...");
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§8-------------------------------");
        Config.configCreate();
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§8-------------------------------");
        if (Main.PaPi) {
            Bukkit.getConsoleSender().sendMessage(PrefixHC + "§2PlaceholderAPI successfully connected!");
        } else {
            Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4\n" + Main.PrefixHC + "§4PlaceholderAPI could not be connected / found! " +
                    "§9Please download it here: §6https://www.spigotmc.org/resources/placeholderapi.6245/§4\n" + Main.PrefixHC);
        }
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(PrefixHC + "§2Plugin loaded successfully.");

        getCommand("papitest").setExecutor(new CmdExecuter());
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        if (!minecraft1_8){
            getCommand("papitest").setTabCompleter(new TabComplete());
        }

        int pluginId = 10767; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);


        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                (new UpdateChecker((JavaPlugin) Main.thisp(), 90439)).getVersion((version) -> {
                    String foundVersion = Main.thisp().getDescription().getVersion();
                    if (!foundVersion.equalsIgnoreCase(version)) {
                        update_version = version;
                        String updateFound = (PrefixHC + "§6A new version of §8[§5PaPi§6Test§8]§6 was found!");
                        String yourVersion = (PrefixHC + "§6Your version §c" + foundVersion);
                        String currentVersion = (PrefixHC + "§6Current version: §a" + version);
                        String downloadVersion = (PrefixHC + "§6You can download it here: §e" + Spigot);
                        String discord = (PrefixHC + "§6You can find more information about §8[§5PaPi§6Test§8]§6 on Discord: §e" + DiscordLink);

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(PrefixHC + " ");
                                Bukkit.getConsoleSender().sendMessage(updateFound);
                                Bukkit.getConsoleSender().sendMessage(yourVersion);
                                Bukkit.getConsoleSender().sendMessage(currentVersion);
                                Bukkit.getConsoleSender().sendMessage(downloadVersion);
                                Bukkit.getConsoleSender().sendMessage(discord);
                                Bukkit.getConsoleSender().sendMessage(PrefixHC + " ");
                            }
                        }.runTaskLater(Main.getPlugin(), 600L);
                    } else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(PrefixHC + "§2No update found");
                            }
                        }.runTaskLater(Main.getPlugin(), 120L);
                    }
                });
            }
        }, 0L, 20 * 60 * 60L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
