package com.github.alexvoliveira.plugin.core.spigot;

import com.github.alexvoliveira.plugin.core.spigot.service.CommandService;
import com.google.common.base.Stopwatch;
import com.henryfabio.minecraft.inventoryapi.manager.InventoryManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@SuppressWarnings("UnstableApiUsage")
public final class CoreSpigot extends JavaPlugin {

    private CommandService commandService;

    @Override
    public void onLoad() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§e§lCORE SPIGOT ➜ §7Plugin §ecarregado §7em §a" + stopwatch);
    }

    @Override
    public void onEnable() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        services();
        inventory();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§a§lCORE SPIGOT ➜ §7Plugin §aativado §7em §a" + stopwatch);
    }

    @Override
    public void onDisable() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        stopwatch.stop();
        getServer().getConsoleSender().sendMessage(
                "§4§lCORE SPIGOT ➜ §7Plugin §cdesativado §7em §a" + stopwatch);
    }

    private void inventory() {
        try {
            InventoryManager.enable(this);
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Falha ao carregar o §binventário: §c" + e.getMessage());
            getLogger().severe("Erro ao carregar inventário: " + e.getMessage());
        }
    }

    private void services() {
        commandService = new CommandService(this);

        try {
            commandService.load();
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Falha ao carregar os §aserviços: §c" + e.getMessage());
            getLogger().severe("Erro ao carregar serviços: " + e.getMessage());
        }
    }
}