package com.github.alexvoliveira.plugin.core.spigot.view;

import com.github.alexvoliveira.plugin.core.spigot.common.factory.ItemFactory;
import com.github.alexvoliveira.plugin.core.spigot.common.util.PlaceholderUtil;
import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.simple.SimpleInventory;
import com.henryfabio.minecraft.inventoryapi.item.InventoryItem;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ServerView extends SimpleInventory {
    public ServerView() {
        super("account_view", "Sua Conta.", 9 * 5);
    }

    @Override
    protected void configureInventory(Viewer viewer, InventoryEditor editor) {
        Player player = viewer.getPlayer();

        InventoryItem sky = InventoryItem.of(
                new ItemFactory(Material.EYE_OF_ENDER)
                        .name("§b§l➜ SKYWARS")
                        .lore("", "§7Apenas um teste, não funciona.", "")
                        .build()
        );

        editor.setItem(13, sky);
    }
}
