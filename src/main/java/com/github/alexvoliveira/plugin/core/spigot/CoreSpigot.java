package com.github.alexvoliveira.plugin.core.spigot;

import com.github.alexvoliveira.plugin.core.spigot.service.CommandService;
import com.google.common.base.Stopwatch;
import com.henryfabio.minecraft.inventoryapi.manager.InventoryManager;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
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

        if (!validateDependencies()) {
            getLogger().severe("§c➜ Desabilitando plugin devido a dependências ausentes.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        loadServices();
        loadInventory();

        getServer().getConsoleSender().sendMessage(
                "§a§lCORE SPIGOT ➜ §7Plugin §aativado §7em §a" + stopwatch.stop());
    }

    @Override
    public void onDisable() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        getServer().getConsoleSender().sendMessage(
                "§4§lCORE SPIGOT ➜ §7Plugin §cdesativado §7em §a" + stopwatch.stop());
    }

    private boolean validateDependencies() {
        PluginManager pm = getServer().getPluginManager();

        boolean npcLib = pm.getPlugin("NPCLibPlugin") != null;
        boolean perms  = pm.getPlugin("LuckPerms") != null;
        boolean papi   = pm.getPlugin("PlaceholderAPI") != null;

        if (!npcLib) getLogger().severe("NPCLibPlugin não encontrado!");
        if (!perms)  getLogger().severe("LuckPerms não encontrado!");
        if (!papi)   getLogger().severe("PlaceholderAPI não encontrado!");

        return npcLib && perms && papi;
    }

    private void loadInventory() {
        try {
            InventoryManager.enable(this);
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Falha ao carregar o §binventário: §c" + e.getMessage());
            getLogger().severe("Erro ao carregar inventário: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void loadServices() {
        commandService = new CommandService(this);

        try {
            commandService.load();
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(
                    "§4§lCORE SPIGOT ➜ §7Falha ao carregar os §aserviços: §c" + e.getMessage());
            getLogger().severe("Erro ao carregar serviços: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }
}