package com.github.alexvoliveira.plugin.core.spigot.command;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class GameModeCommand {

    @Command(name = "gamemode", aliases = {"gm", "mododejogo", "modo-de-jogo"}, target = CommandTarget.PLAYER)
    public void handleGMCommand(Context<Player> context, @Optional String mode, @Optional Player target) {
        final Player user = context.getSender();

        if(!user.hasPermission("core.command.permission.gm")) {
            user.sendMessage("§4§l[✖]INFO ➜ §fO comando §cnão §ffoi §cencontrado!");
            return;
        }

        if (mode == null) {
            user.sendMessage("§4§lGAMEMODE ➜ §fUso correto: /gamemode <modo> [jogador]");
            return;
        }

        final Player player = target != null ? target : user;
        final GameMode gm = parseGameMode(mode);

        if (gm == null) {
            user.sendMessage("§c§lGAMEMODE ➜ §fModo de jogo §cinválido!");
            return;
        }

        player.setGameMode(gm);
        user.sendMessage("§b§lGAMEMODE ➜ §fModo de jogo de §7" + player.getName() + " §fatualizado para §7" + gm.name());
    }

    private GameMode parseGameMode(String input) {
        if (input == null) return null;

        input = input.toLowerCase();
        switch (input) {
            case "s":
            case "0":
            case "survival":
                return GameMode.SURVIVAL;
            case "c":
            case "1":
            case "creative":
                return GameMode.CREATIVE;
            case "2":
            case "adventure":
                return GameMode.ADVENTURE;
            case "3":
            case "spectator":
                return GameMode.SPECTATOR;
            default:
                return null;
        }
    }
}