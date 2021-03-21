// This claas was created by JaTiTV

package de.jatitv.papitest.system;

import de.jatitv.papitest.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("commandgui.admin") || player.isOp()) {
            if (Main.update_version != null) {
                String foundVersion = Main.getPlugin().getDescription().getVersion();
                String updateFound = (Main.PrefixHC + "§6A new version of §8[§6Command§9GUI§8]§6 was found!");
                String yourVersion = (Main.PrefixHC + "§6Your version §c" + foundVersion);
                String currentVersion = (Main.PrefixHC + "§6Current version: §a" + Main.update_version);
                String downloadVersion = (Main.PrefixHC + "§6You can download it here: §e" + Main.Spigot);
                String discord = (Main.PrefixHC + "§6You can find more information about §8[§6Command§9GUI§8]§6 on Discord: §e" + Main.DiscordLink);
                String Snapshot = (Main.PrefixHC + "§4Please note!" +
                        "\n" + Main.PrefixHC + "§cYou are using the §6" + foundVersion + " §cof §6Command§9GUI!" +
                        "\n" + Main.PrefixHC + "§cThere may be errors and it is possible that not all functions work as they should!" +
                        "\n" + Main.PrefixHC + "§2If there are any bugs, please report them to me via Discord so I can fix them." +
                        "\n" + Main.PrefixHC + "§7" + Main.DiscordLink);

                if (Config.UpdateCheckOnJoin) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("\n ");
                            player.sendMessage(updateFound);
                            player.sendMessage(yourVersion);
                            player.sendMessage(currentVersion);
                            player.sendMessage(downloadVersion);
                            player.sendMessage(discord);
                        }
                    }.runTaskLater(Main.getPlugin(), 200L);
                }
            }
        }
    }
}