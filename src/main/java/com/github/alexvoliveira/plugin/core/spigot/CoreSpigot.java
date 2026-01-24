package com.github.alexvoliveira.plugin.core.spigot;

import com.github.alexvoliveira.plugin.core.spigot.service.CommandService;
import com.google.common.base.Stopwatch;
import com.henryfabio.minecraft.inventoryapi.manager.InventoryManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class CoreSpigot extends JavaPlugin {

    private CommandService commandService;

    @Override
    public void onLoad() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§e§lCORE SPIGOT ➜ §7The plugin §eloaded §7in §a" + stopwatch);
    }

    @Override
    public void onEnable() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        services();
        inventory();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§a§lCORE SPIGOT ➜ §7The was plugin §aactivated §7in §a" + stopwatch);
    }

    @Override
    public void onDisable() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§4§lCORE SPIGOT ➜ §7The was plugin §cdeactivated §7in §a" + stopwatch);
    }

    private void inventory() {
        try {
            InventoryManager.enable(this);
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Failed to load §binventory §c" + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    private void services() {
        commandService = new CommandService(this);

        try {
            commandService.load();
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Failed to load the §aservices: §c" + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
}