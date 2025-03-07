package com.mills.enchantCraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private ItemsManager itemsManager;

    @Override
    public void onEnable() {

        itemsManager = new ItemsManager();
        itemsManager.setupRecipes();

        Bukkit.getPluginManager().registerEvents(new GUIListener(itemsManager), this);
        getCommand("ecraft").setExecutor(new EcraftCommand());
    }
}
