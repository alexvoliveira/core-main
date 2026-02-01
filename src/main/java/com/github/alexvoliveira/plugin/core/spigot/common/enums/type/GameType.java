package com.github.alexvoliveira.plugin.core.spigot.common.enums.type;

import lombok.Getter;
import org.bukkit.GameMode;

@Getter
public enum GameType {

    SURVIVAL(GameMode.SURVIVAL, "survival", "s", "0"),
    CREATIVE(GameMode.CREATIVE, "criativo", "c", "1"),
    ADVENTURE(GameMode.ADVENTURE, "aventura", "a", "2"),
    SPECTATOR(GameMode.SPECTATOR, "espectador", "sp", "3");

    private final GameMode gameMode;
    private final String name;
    private final String[] aliases;

    GameType(GameMode gameMode, String name, String... aliases) {
        this.gameMode = gameMode;
        this.name = name;
        this.aliases = aliases;
    }

    public static GameType get(String nameOrAlias) {
        for (GameType GameType : values()) {
            if (GameType.name.equalsIgnoreCase(nameOrAlias)) {
                return GameType;
            }
            for (String alias : GameType.aliases) {
                if (alias.equalsIgnoreCase(nameOrAlias)) {
                    return GameType;
                }
            }
        }
        return null;
    }
}