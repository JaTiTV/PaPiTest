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
        String foundVersion = Main.getPlugin().getDescription().getVersion();
        if (player.hasPermission("papitest.admin") || player.isOp()) {
            if (!foundVersion.equals(Main.update_version)) {
                String updateFound = (Main.PrefixHC + "§6A new version of §8[§5PaPi§6Test§8]§6 was found!");
                String yourVersion = (Main.PrefixHC + "§6Your version §c" + foundVersion);
                String currentVersion = (Main.PrefixHC + "§6Current version: §a" + Main.update_version);
                String downloadVersion = (Main.PrefixHC + "§6You can download it here: §e" + Main.Spigot);
                String discord = (Main.PrefixHC + "§6You can find more information about §8[§5PaPi§6Test§8]§6 on Discord: §e" + Main.DiscordLink);

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