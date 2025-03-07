package com.mills.enchantCraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.*;

public class ItemsManager {

    private final Map<List<ItemStack>, ItemStack> recipes = new HashMap<>();

    public void setupRecipes() {
        recipes.put(Arrays.asList(
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK)
        ), sharpness6Book());

        recipes.put(Arrays.asList(
                null, new ItemStack(Material.NETHERITE_BLOCK), null,
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                null, new ItemStack(Material.NETHERITE_BLOCK), null
        ), efficiency6Book());

        recipes.put(Arrays.asList(
                new ItemStack(Material.NETHERITE_BLOCK), null, null,
                null, new ItemStack(Material.NETHERITE_BLOCK), null,
                null, null, new ItemStack(Material.NETHERITE_BLOCK)
        ), protection5Book());

        recipes.put(Arrays.asList(
                null, null, new ItemStack(Material.NETHERITE_BLOCK),
                null, new ItemStack(Material.NETHERITE_BLOCK), null,
                new ItemStack(Material.NETHERITE_BLOCK), null, null
        ), unbreaking4Book());

        recipes.put(Arrays.asList(
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.NETHERITE_BLOCK), null, new ItemStack(Material.NETHERITE_BLOCK),
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK)
        ), power6Book());

        recipes.put(Arrays.asList(
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                null, new ItemStack(Material.NETHERITE_BLOCK), null,
                null, new ItemStack(Material.NETHERITE_BLOCK), null
        ), fortune4Book());

        recipes.put(Arrays.asList(
                null, new ItemStack(Material.NETHERITE_BLOCK), null,
                new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK),
                null, new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.NETHERITE_BLOCK)
        ), looting4Book());
    }

    public Map<List<ItemStack>, ItemStack> getRecipes() {
        return recipes;
    }

    public ItemStack sharpness6Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.SHARPNESS, 6, true);
        }
        return book;
    }

    public ItemStack efficiency6Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.EFFICIENCY, 6, true);
        }
        return book;
    }

    public ItemStack protection5Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.PROTECTION, 5, true);
        }
        return book;
    }

    public ItemStack unbreaking4Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.UNBREAKING, 4, true);
        }
        return book;
    }

    public ItemStack power6Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.POWER, 6, true);
        }
        return book;
    }

    public ItemStack fortune4Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FORTUNE, 4, true);
        }
        return book;
    }

    public ItemStack looting4Book() {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.LOOTING, 4, true);
        }
        return book;
    }
}