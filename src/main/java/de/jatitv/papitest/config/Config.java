// This claas was created by JaTiTV


package de.jatitv.papitest.config;

import de.jatitv.papitest.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static Boolean UpdateCheckOnJoin = true;
    public static Boolean Titel = true;

    public static void configCreate() {

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration_config = YamlConfiguration.loadConfiguration(configYML);

        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Config.yml load...");

        if (!yamlConfiguration_config.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_config.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_config.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_config.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_config.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_config.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (yamlConfiguration_config.contains("Plugin.UpdateCheckOnJoin")) {
            UpdateCheckOnJoin = yamlConfiguration_config.getBoolean("Plugin.UpdateCheckOnJoin");
        } else {
            yamlConfiguration_config.set("Plugin.UpdateCheckOnJoin", true);
            Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Setting §6UpdateCheckOnJoin §4was added to §9Config.yml§4!");
        }
        if (!Main.minecraft1_8) {
            if (yamlConfiguration_config.contains("Titel.Enable")) {
                Titel = yamlConfiguration_config.getBoolean("Titel.Enable");
            } else {
                yamlConfiguration_config.set("Titel.Enable", true);
                Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Setting §6Titel Enable §4was added to §9Config.yml§4!");
            }
        }


        try {
            yamlConfiguration_config.save(configYML);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2Config.yml loaded successfully.");
    }
}
