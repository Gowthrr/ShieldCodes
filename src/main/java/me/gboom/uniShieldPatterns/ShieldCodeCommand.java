package me.gboom.uniShieldPatterns;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ShieldMeta;
import org.bukkit.block.banner.Pattern;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShieldCodeCommand implements CommandExecutor {

    private static final int MAX_PATTERNS = 16; //  Change to allow more or less creativity, but it probably won't go above 16 without erroring.
    private static final int MAX_STRING_LENGTH = 97; // Probably don't touch this!

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /shieldcode <patternString>");
            return false;
        }
        String input = args[0];
        if (input.length() > MAX_STRING_LENGTH) { // A "fallback" if MAX_PATTERNS fails for any reason.
            player.sendMessage(ChatColor.RED + "Pattern string is too long!");
            return false;
        }
        try {
            ItemStack shield = createShieldWithPatterns(input);
            player.getInventory().addItem(shield);
            player.sendMessage(ChatColor.GREEN + "That works.");
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Invalid pattern string.");
        } catch (IllegalStateException e) {
            player.sendMessage(ChatColor.RED + "Something has gone horribly wrong! ;)"); // Certain patterns higher than MAX_PATTERNS will send errors without this.
        }
        return true;
    }
    private ItemStack createShieldWithPatterns(String input) {
        String[] parts = input.split(";");
        if (parts.length > MAX_PATTERNS + 1) {
            throw new IllegalStateException("Too many patterns!"); // This should happen with most of the patterns above MAX_PATTERNS.
        }
        byte baseColorByte = Byte.parseByte(parts[0]);
        DyeColor baseColor = DyesEnum.fromByte(baseColorByte);
        ItemStack shield = new ItemStack(Material.SHIELD);
        ShieldMeta meta = (ShieldMeta) shield.getItemMeta();
        assert meta != null;
        meta.setBaseColor(baseColor);
        List<Pattern> patterns = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) { // Shit will break without this.
            String patternCodeAndColor = parts[i];
            int j = 0;
            while (j < patternCodeAndColor.length() && Character.isDigit(patternCodeAndColor.charAt(j))) {j++;}
            byte patternColorByte = Byte.parseByte(patternCodeAndColor.substring(0, j));
            DyeColor patternColor = DyesEnum.fromByte(patternColorByte);
            String patternCode = patternCodeAndColor.substring(j);
            ShieldPatternsEnum pattern = ShieldPatternsEnum.fromCode(patternCode);
            patterns.add(new Pattern(patternColor, pattern.getPatternType()));
        }
        meta.setPatterns(patterns);
        shield.setItemMeta(meta);
        return shield;
    }
}

