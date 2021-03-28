// This claas was created by JaTiTV

package de.jatitv.papitest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player) {
            List<String> list = new ArrayList<>();

            if (args.length == 0 || args.length == 1) {
                if (sender.hasPermission("papitest.admin") || sender.isOp()) {
                    list.add("<placeholder>");
                    list.add("info");
                    list.add("reload");
                }
                return list;
            }
        }
        return new ArrayList();
    }
}