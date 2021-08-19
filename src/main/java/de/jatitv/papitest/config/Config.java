// This claas was created by JaTiTV

package de.jatitv.papitest.config;

import de.jatitv.papitest.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static Integer ConfigVersion = 1;

    public static Boolean UpdateCheckOnJoin = true;
    public static Boolean Titel = true;

    public static void configCreate() {

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configYML);

        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Config.yml load...");

        yamlConfiguration.set("ConfigVersion", ConfigVersion);

        if (yamlConfiguration.contains("Plugin.UpdateCheckOnJoin")) {
            UpdateCheckOnJoin = yamlConfiguration.getBoolean("Plugin.UpdateCheckOnJoin");
        } else {
            yamlConfiguration.set("Plugin.UpdateCheckOnJoin", true);
            Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Setting §6UpdateCheckOnJoin §4was added to §9Config.yml§4!");
        }
        if (!Main.minecraft1_8) {
            if (yamlConfiguration.contains("Titel.Enable")) {
                Titel = yamlConfiguration.getBoolean("Titel.Enable");
            } else {
                yamlConfiguration.set("Titel.Enable", true);
                Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§4Setting §6Titel Enable §4was added to §9Config.yml§4!");
            }
        }

        try {
            yamlConfiguration.save(configYML);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Bukkit.getConsoleSender().sendMessage(Main.PrefixHC + "§2Config.yml loaded successfully.");
    }
}
