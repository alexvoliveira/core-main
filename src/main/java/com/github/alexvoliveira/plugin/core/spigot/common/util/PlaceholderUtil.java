package com.github.alexvoliveira.plugin.core.spigot.common.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class PlaceholderUtil {

    private PlaceholderUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static String parse(Player user, String text) {
        return PlaceholderAPI.setPlaceholders(user,
                ChatColor.translateAlternateColorCodes('&', text));
    }

    public static String getRole(Player user) {
        return parse(user, "%luckperms_suffix%").trim();
    }
}