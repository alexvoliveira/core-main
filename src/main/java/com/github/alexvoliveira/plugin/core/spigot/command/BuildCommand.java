package com.github.alexvoliveira.plugin.core.spigot.command;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class BuildCommand {

    public static final Set<UUID> mode = new HashSet<>();

    @Command(
            name = "build",
            target = CommandTarget.PLAYER
    )
    public void handleBuild(Context<Player> context) {
        Player player = context.getSender();
        UUID uuid = player.getUniqueId();

        if (!player.hasPermission("core.command.admin.build")) {
            context.sendMessage("§c§l[!]BUILD ➜ §fVocê §cnão§f tem §cpermissão.");
            return;
        }

        if (!mode.add(uuid)) {
            mode.remove(uuid);
            context.sendMessage("§c§lBUILD ➜ §fModo construtor §adesativado.");
            return;
        }

        context.sendMessage("§a§lBUILD ➜ §fModo construtor §cativado.");
    }
}