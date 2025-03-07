package com.mills.enchantCraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GUIListener implements Listener {

    private final ItemsManager itemsManager;
    private final int[] craftingSlots = {11, 12, 13, 20, 21, 22, 29, 30, 31};
    private final int outputSlot = 24;

    public GUIListener(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    @EventHandler
    public void onRecipeInfoClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();

        if (!e.getView().getTitle().startsWith("Recipe")) {
            return;
        }

        int clickedSlot = e.getRawSlot();

        if (clickedSlot == 49) {
            GUIMangaer.viewRecipesGUI((Player) e.getWhoClicked());
        }

        e.setCancelled(true);
    }

    @EventHandler
    public void onClickRecipe(InventoryClickEvent e) {
        if (!e.getView().getTitle().startsWith("Crafting Recipes")) {
            return;
        }

        e.setCancelled(true);

        int clickedSlot = e.getRawSlot();

        if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.BARRIER) {
            GUIMangaer.openGUI((Player) e.getWhoClicked());
            return;
        }

        if (clickedSlot >= 10 && clickedSlot <= 16) {
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem == null) {
                return;
            }

            String clickedName = "";
            if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()) {
                clickedName = clickedItem.getItemMeta().getDisplayName();
            }

            for (Map.Entry<List<ItemStack>, ItemStack> entry : itemsManager.getRecipes().entrySet()) {
                ItemStack resultItem = entry.getValue();
                String resultName = "";
                if (resultItem.hasItemMeta() && resultItem.getItemMeta().hasDisplayName()) {
                    resultName = resultItem.getItemMeta().getDisplayName();
                }

                if (clickedName.equalsIgnoreCase(resultName)) {
                    GUIMangaer.openRecipeDataGUI((Player) e.getWhoClicked(), entry.getKey(), resultItem);
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onClickECraft(InventoryClickEvent e) {
        Inventory inv = e.getInventory();

        if (!e.getView().getTitle().startsWith("Enchant Craft")) {
            return;
        }

        int clickedSlot = e.getRawSlot();

        if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE && !isCraftingSlot(clickedSlot)) {
            e.setCancelled(true);
        }

        if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.KNOWLEDGE_BOOK && !isCraftingSlot(clickedSlot)) {
            GUIMangaer.viewRecipesGUI((Player) e.getWhoClicked());
            return;
        }

        if (isCraftingSlot(clickedSlot) || clickedSlot == outputSlot) {
            ItemStack result = getMatchingRecipe(inv);
            if (result != null) {
                inv.setItem(outputSlot, result.clone());
            } else {
                inv.setItem(outputSlot, new ItemStack(Material.AIR));
            }
        }

        if (clickedSlot == outputSlot) {
            ItemStack crafted = inv.getItem(outputSlot);
            if (crafted != null && crafted.getType() != Material.BARRIER && crafted.getType() != Material.AIR) {
                Player player = (Player) e.getWhoClicked();
                player.getInventory().addItem(crafted.clone());

                for (int slot : craftingSlots) {
                    inv.setItem(slot, new ItemStack(Material.AIR));
                }
                ItemStack newResult = getMatchingRecipe(inv);
                if (newResult != null) {
                    inv.setItem(outputSlot, newResult.clone());
                } else {
                    inv.setItem(outputSlot, new ItemStack(Material.AIR));
                }
                e.setCancelled(true);
            }
        }
    }


    private boolean isCraftingSlot(int slot) {
        for(int cs : craftingSlots) {
            if (slot == cs) {
                return true;
            }
        }
        return false;
    }

    private ItemStack getMatchingRecipe(Inventory inv) {
        List<ItemStack> placedItems = new ArrayList<>();
        for (int slot : craftingSlots) {
            placedItems.add(inv.getItem(slot));
        }

        for (Map.Entry<List<ItemStack>, ItemStack> entry : itemsManager.getRecipes().entrySet()) {
            List<ItemStack> recipeItems = entry.getKey();
            if (matchRecipe(placedItems, recipeItems)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean matchRecipe(List<ItemStack> placed, List<ItemStack> recipe) {
        if (placed.size() != recipe.size()) {
            return false;
        }
        for (int i = 0; i < placed.size(); i++) {
            ItemStack required = recipe.get(i);
            ItemStack placedItem = placed.get(i);

            if (required == null) {
                if (placedItem != null && placedItem.getType() != Material.AIR) {
                    return false;
                }
            } else {
                if (placedItem == null || placedItem.getType() != required.getType() || placedItem.getAmount() < required.getAmount()) {
                    return false;
                }
            }
        }
        return true;
    }

}
