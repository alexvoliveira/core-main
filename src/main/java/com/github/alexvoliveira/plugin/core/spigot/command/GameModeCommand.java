package com.github.alexvoliveira.plugin.core.spigot.command;

import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class GameModeCommand {

    @Command(name = "gamemode", aliases = {"gm", "mododejogo", "modo-de-jogo"}, target = CommandTarget.PLAYER)
    public void handleGMCommand(Context<Player> context, @Optional(def = {"s"}) String modeInput) {
        Player user = context.getSender();

        modeInput = modeInput.toLowerCase();

        if (modeInput.equals("c")) {
            user.setGameMode(GameMode.CREATIVE);
            context.sendMessage("Seu modo de jogo foi alterado para CREATIVE.");
            return;
        }

        if (modeInput.equals("s")) {
            user.setGameMode(GameMode.SURVIVAL);
            context.sendMessage("Seu modo de jogo foi alterado para SURVIVAL.");
            return;
        }

        if (modeInput.equals("sp")) {
            user.setGameMode(GameMode.SPECTATOR);
            context.sendMessage("Seu modo de jogo foi alterado para SPECTATOR.");
            return;
        }

        if (modeInput.equals("a")) {
            user.setGameMode(GameMode.ADVENTURE);
            context.sendMessage("Seu modo de jogo foi alterado para ADVENTURE.");
            return;
        }

        context.sendMessage("Modo de jogo inválido! Use c/s/a.");
    }
}