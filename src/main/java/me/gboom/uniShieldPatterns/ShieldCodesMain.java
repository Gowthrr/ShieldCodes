package me.gboom.uniShieldPatterns;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ShieldCodesMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("shieldcode")).setExecutor(new ShieldCodeCommand());
        Objects.requireNonNull(this.getCommand("copyshield")).setExecutor(new CopyShieldCommand());
        getLogger().info("ShieldCodes is operational!");
    }
}
