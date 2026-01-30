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
            context.sendMessage("§b§lGM ➜ §fSeu modo de jogo foi alterado para §bcriativo.");
            return;
        }

        if (modeInput.equals("s")) {
            user.setGameMode(GameMode.SURVIVAL);
            context.sendMessage("§a§lGM ➜ §fSeu modo de jogo foi alterado para §asobrevivência.");
            return;
        }

        if (modeInput.equals("sp")) {
            user.setGameMode(GameMode.SPECTATOR);
            context.sendMessage("§7§lGM ➜ §fSeu modo de jogo foi alterado para §7espectador.");
            return;
        }

        if (modeInput.equals("a")) {
            user.setGameMode(GameMode.ADVENTURE);
            context.sendMessage("§e§lGM ➜ §fSeu modo de jogo foi alterado para §eaventura.");
            return;
        }

        context.sendMessage(new String[] {
                "§4§l           [!]GM ➜ §fModo de jogo §cinválido!",
                "",
                "§a▸ §fOs valores corretos são: c/s/sp/a"
        });
    }
}