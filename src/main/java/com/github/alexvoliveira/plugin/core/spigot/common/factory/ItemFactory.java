package com.github.alexvoliveira.plugin.core.spigot.common.factory;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

@SuppressWarnings("all")
public final class ItemFactory {

    private final ItemStack itemStack;
    private ItemMeta itemMeta;
    private int slot;

    public ItemFactory(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemFactory owner(String owner) {
        if (itemMeta == null) return this;
        if (itemStack.getType() != Material.SKULL_ITEM) return this;
        if (!(itemMeta instanceof SkullMeta)) return this;

        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwner(owner);
        this.itemMeta = skullMeta;

        return this;
    }


    public ItemFactory durability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    public ItemFactory ownerURL(String skinURL) {
        if (itemMeta == null || skinURL == null) return this;
        if (itemStack.getType() != Material.SKULL_ITEM) return this;
        if (!(itemMeta instanceof SkullMeta)) return this;

        try {
            SkullMeta skullMeta = (SkullMeta) itemMeta;

            GameProfile profile = new GameProfile(UUID.randomUUID(), null);

            String json = "{textures:{SKIN:{url:\"" + skinURL + "\"}}}";
            String base64 = Base64.getEncoder()
                    .encodeToString(json.getBytes(StandardCharsets.UTF_8));

            profile.getProperties().put("textures", new Property("textures", base64));

            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);

            this.itemMeta = skullMeta;

        } catch (Exception e) {
            System.err.println("§4§lITEM FACTORY ➜ §7Falha ao definir URL da cabeça: §c" + e.getMessage());
            e.printStackTrace();
        }

        return this;
    }

    public ItemFactory name(String name) {
        if (itemMeta == null) return this;

        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemFactory lore(String... lore) {
        if (itemMeta == null) return this;

        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemFactory slot(int slot) {
        this.slot = slot;
        return this;
    }

    public int getSlot() {
        return slot;
    }

    public ItemStack build() {
        if (itemMeta != null) {
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
