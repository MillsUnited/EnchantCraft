package com.mills.enchantCraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIManger {

    public static Inventory openGUI(Player player) {
        Inventory ecraft = Bukkit.createInventory(player, 45, "Enchant Craft");

        ItemStack panes = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta paneMeta = panes.getItemMeta();
        if (paneMeta != null) {
            paneMeta.setDisplayName("");
            panes.setItemMeta(paneMeta);
        }
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,10,14,15,16,17,18,19,23,26,27,28,32,33,34,35,36,37,38,39,40,41,42,43,44}) {

            ecraft.setItem(i, panes);

        }

        ItemStack recipe = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta recipeMeta = recipe.getItemMeta();
        if (recipeMeta != null) {
            recipeMeta.setDisplayName(ChatColor.YELLOW.toString() + ChatColor.BOLD + "View recipes");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Enchantments can be upgraded for any tool,");
            lore.add(ChatColor.GRAY + "weapon and armor. To upgrade the item");
            lore.add(ChatColor.GRAY + "to the next enchantment level you need");
            lore.add(ChatColor.GRAY + "previous level already applied");
            recipeMeta.setLore(lore);
            recipe.setItemMeta(recipeMeta);
        }

        ecraft.setItem(25, recipe);

        player.openInventory(ecraft);

        return ecraft;
    }

    public static Inventory viewRecipesGUI(Player player) {
        Inventory recipe = Bukkit.createInventory(player, 36, "Crafting Recipes");

        ItemStack panes = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta paneMeta = panes.getItemMeta();
        if (paneMeta != null) {
            paneMeta.setDisplayName("");
            panes.setItemMeta(paneMeta);
        }
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26,27,28,29,30,32,33,34,35}) {

            recipe.setItem(i, panes);
        }

        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = back.getItemMeta();
        if (backMeta != null) {
            backMeta.setDisplayName(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Back");
            back.setItemMeta(backMeta);
        }
        recipe.setItem(31, back);

        ItemStack fortune = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fortuneMeta = fortune.getItemMeta();
        if (fortuneMeta != null) {
            fortuneMeta.setDisplayName(ChatColor.YELLOW + "Fortune 4 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            fortuneMeta.setLore(lore);
            fortune.setItemMeta(fortuneMeta);
        }
        recipe.setItem(10, fortune);

        ItemStack efficiency = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta efficiencyMeta = efficiency.getItemMeta();
        if (efficiencyMeta != null) {
            efficiencyMeta.setDisplayName(ChatColor.YELLOW + "Efficiency 6 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            efficiencyMeta.setLore(lore);
            efficiency.setItemMeta(efficiencyMeta);
        }
        recipe.setItem(11, efficiency);

        ItemStack protection = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta protectionMeta = protection.getItemMeta();
        if (protectionMeta != null) {
            protectionMeta.setDisplayName(ChatColor.YELLOW + "Protection 5 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            protectionMeta.setLore(lore);
            protection.setItemMeta(protectionMeta);
        }
        recipe.setItem(12, protection);

        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sharpnessMeta = sharpness.getItemMeta();
        if (sharpnessMeta != null) {
            sharpnessMeta.setDisplayName(ChatColor.YELLOW + "Sharpness 6 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            sharpnessMeta.setLore(lore);
            sharpness.setItemMeta(sharpnessMeta);
        }
        recipe.setItem(13, sharpness);

        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta unbreakingMeta = unbreaking.getItemMeta();
        if (unbreakingMeta != null) {
            unbreakingMeta.setDisplayName(ChatColor.YELLOW + "Unbreaking 4 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            unbreakingMeta.setLore(lore);
            unbreaking.setItemMeta(unbreakingMeta);
        }
        recipe.setItem(14, unbreaking);

        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta powerMeta = power.getItemMeta();
        if (powerMeta != null) {
            powerMeta.setDisplayName(ChatColor.YELLOW + "Power 6 Enchant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            powerMeta.setLore(lore);
            power.setItemMeta(powerMeta);
        }
        recipe.setItem(15, power);

        ItemStack looting = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta lootingMeta = looting.getItemMeta();
        if (lootingMeta != null) {
            lootingMeta.setDisplayName(ChatColor.YELLOW + "Looting 4 Enchants");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW.toString() + ChatColor.BOLD + "(!) " + ChatColor.RESET + ChatColor.YELLOW + "Click to see recipe!");
            lootingMeta.setLore(lore);
            looting.setItemMeta(lootingMeta);
        }
        recipe.setItem(16, looting);

        player.openInventory(recipe);

        return recipe;
    }

    public static void openRecipeDataGUI(Player player, List<ItemStack> recipeItems, ItemStack resultItem) {

        Inventory recipeInv = Bukkit.createInventory(player, 54, "Recipe");

        int[] gridSlots = {11,12,13,20,21,22,29,30,31};

        for (int i = 0; i < gridSlots.length; i++) {
            ItemStack ingredient = recipeItems.get(i);
            recipeInv.setItem(gridSlots[i], ingredient != null ? ingredient : new ItemStack(Material.AIR));
        }

        recipeInv.setItem(13, resultItem.clone());

        for (int i = 0; i < recipeInv.getSize(); i++) {
            if (!contains(gridSlots, i) && i != 13) {
                recipeInv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }
        }
        player.openInventory(recipeInv);
    }

    private static boolean contains(int[] arr, int value) {
        for (int a : arr) {
            if (a == value) {
                return true;
            }
        }
        return false;
    }
}
