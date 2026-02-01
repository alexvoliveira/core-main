package com.github.alexvoliveira.plugin.core.spigot.view;

import com.github.alexvoliveira.plugin.core.spigot.common.factory.ItemFactory;
import com.github.alexvoliveira.plugin.core.spigot.common.util.PlaceholderUtil;
import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.simple.SimpleInventory;
import com.henryfabio.minecraft.inventoryapi.item.InventoryItem;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class AccountView extends SimpleInventory {
    public AccountView() {
        super("account_view", "Sua Conta.", 9 * 5);
    }

    @Override
    protected void configureInventory(Viewer viewer, InventoryEditor editor) {
        Player player = viewer.getPlayer();

        InventoryItem user = InventoryItem.of(
                new ItemFactory(Material.SKULL_ITEM)
                        .owner(player.getName())
                        .durability((short) 3)
                        .name("§7" + player.getName())
                        .lore("", "§7Seu cargo: " + PlaceholderUtil.getRole(player), "§7Primeiro login:")
                        .build()
        );

        editor.setItem(13, user);
    }
}
