package com.github.alexvoliveira.plugin.core.spigot.view;

import com.github.alexvoliveira.plugin.core.spigot.common.factory.ItemFactory;
import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.simple.SimpleInventory;
import com.henryfabio.minecraft.inventoryapi.item.InventoryItem;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import org.bukkit.Material;

public class ServerView extends SimpleInventory {
    public ServerView() {
        super("server_view", "Escolha um Modo.", 9 * 5);
    }

    @Override
    protected void configureInventory(Viewer viewer, InventoryEditor editor) {
        InventoryItem sky = InventoryItem.of(
                new ItemFactory(Material.EYE_OF_ENDER)
                        .name("§b§l➜ SKYWARS")
                        .lore("", "§7Apenas um teste, não funciona.", "")
                        .build()
        );

        editor.setItem(13, sky);
    }
}
