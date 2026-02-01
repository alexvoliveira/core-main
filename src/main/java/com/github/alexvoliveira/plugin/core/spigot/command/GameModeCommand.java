package com.github.alexvoliveira.plugin.core.spigot.command;

import com.github.alexvoliveira.plugin.core.spigot.common.enums.type.GameType;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.entity.Player;

public final class GameModeCommand {

    @Command(
            name = "gamemode",
            aliases = {"gm"},
            target = CommandTarget.PLAYER
    )
    public void handleGMCommand(Context<Player> context, @Optional String modeInput) {
        Player player = context.getSender();

        if (modeInput == null || modeInput.isEmpty()) {
            context.sendMessage("§c§l[!]GM ➜ §fUse: §7/gamemode <modo>");
            return;
        }

        GameType gameType = GameType.get(modeInput);

        if (gameType == null) {
            context.sendMessage("§c§l[!]GM ➜ §fO modo está §cinvalido!");
            return;
        }

        player.setGameMode(gameType.getGameMode());
        context.sendMessage("§a§lGM ➜ §fSeu modo de §ajogo §ffoi mudado para: §e" + gameType.getName());
    }
}