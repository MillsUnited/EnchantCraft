package com.mills.enchantCraft;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIListener {

    private final Map<List<ItemStack>, ItemStack> recipes = new HashMap<>();

    public void setupRecipes() {
        recipes.put(Arrays.asList(
                new ItemStack(Material.DIAMOND, 2), null, new ItemStack(Material.DIAMOND, 2),
                null, new ItemStack(Material.STICK, 1), null,
                null, null, null
        ), ResultItems.sharpness6Book());
    }
}
