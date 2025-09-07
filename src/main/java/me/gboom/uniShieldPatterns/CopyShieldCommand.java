package me.gboom.uniShieldPatterns;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ShieldMeta;
import org.jetbrains.annotations.NotNull;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import java.util.List;

public class CopyShieldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (heldItem.getType() != Material.SHIELD) {
            player.sendMessage(ChatColor.RED + "You must be holding a shield!");
            return false;
        }
        ShieldMeta meta = (ShieldMeta) heldItem.getItemMeta();
        if (meta == null) {
            player.sendMessage(ChatColor.RED + "Could not retrieve NBT");
            return false;
        }
        DyeColor baseColor = meta.getBaseColor();
        byte baseColorByte = DyesEnum.valueOf(baseColor.name()).num;
        StringBuilder patternString = new StringBuilder(String.valueOf(baseColorByte));
        List<Pattern> patterns = meta.getPatterns();
        for (Pattern pattern : patterns) {
            DyeColor patternColor = pattern.getColor();
            byte patternColorByte = DyesEnum.valueOf(patternColor.name()).num;
            String patternCode = getPatternCode(pattern.getPattern());
            patternString.append(";").append(patternColorByte).append(patternCode);
        }
        TextComponent message = new TextComponent(ChatColor.GOLD + "Pattern String(Copy-able): " + ChatColor.UNDERLINE + patternString.toString());
        message.setClickEvent(new ClickEvent(Action.COPY_TO_CLIPBOARD, patternString.toString()));
        player.spigot().sendMessage(message);
        return true;
    }
    private String getPatternCode(org.bukkit.block.banner.PatternType patternType) {
        for (ShieldPatternsEnum pattern : ShieldPatternsEnum.values()) {
            if (pattern.getPatternType() == patternType) {
                return pattern.code;
            }
        }
        return "UNKNOWN"; // Should never happen if the pattern exists!
    }
}
