package com.github.alexvoliveira.plugin.core.spigot.service;

import com.github.alexvoliveira.plugin.core.spigot.CoreSpigot;
import com.github.alexvoliveira.plugin.core.spigot.command.GameModeCommand;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.bukkit.command.BukkitFrame;

@RequiredArgsConstructor
public final class CommandService {

    private final CoreSpigot plugin;

    public void load() {
        final BukkitFrame frame = new BukkitFrame(plugin);

        frame.registerCommands(new GameModeCommand(), plugin);
    }
}
