package tacticalaxis.potiongo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("milk").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("milk")) {
                if(player.hasPermission("potiongo.use")) {
                    Collection<PotionEffect> potionEffects = player.getActivePotionEffects();
                    for(PotionEffect potionEffect : potionEffects) {
                        player.removePotionEffect(potionEffect.getType());
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only a player can do this");
        }
        return true;
    }
}
