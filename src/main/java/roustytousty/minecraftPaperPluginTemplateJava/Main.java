package roustytousty.minecraftPaperPluginTemplateJava;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import roustytousty.minecraftPaperPluginTemplateJava.commands.admincommands.ExampleAdminCommand;
import roustytousty.minecraftPaperPluginTemplateJava.commands.guicommands.ExampleGuiCommand;
import roustytousty.minecraftPaperPluginTemplateJava.commands.playercommands.ExampleArgumentCommand;
import roustytousty.minecraftPaperPluginTemplateJava.commands.playercommands.ExamplePlayerCommand;
import roustytousty.minecraftPaperPluginTemplateJava.gui.ExampleGui;
import roustytousty.minecraftPaperPluginTemplateJava.listeners.ExampleListener;
import roustytousty.minecraftPaperPluginTemplateJava.managers.ConfigManager;
import roustytousty.minecraftPaperPluginTemplateJava.managers.GuiManager;

import java.io.File;

public final class Main extends JavaPlugin {

    private Main instance;
    private PluginManager pluginManager;
    private File dataFolderDir;
    private ConfigManager exampleConfig;

    public Main getInstance() {
        return instance;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public File getDataFolderDir() {
        return dataFolderDir;
    }

    public ConfigManager getExampleConfig() {
        return exampleConfig;
    }

    @Override
    public void onEnable() {
        instance = this;
        dataFolderDir = getDataFolder();
        pluginManager = getServer().getPluginManager();

        GuiManager guiManager = new GuiManager();

        registerEvents();
        registerCommands();
        registerConfigs();

        getLogger().info("Plugin Setup!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }

    private void registerEvents() {
        // Listeners
        pluginManager.registerEvents(new ExampleListener(), this);

        // Gui
        pluginManager.registerEvents(new ExampleGui(), this);
    }

    private void registerCommands() {
        // Player Commands
        this.getCommand("exampleplayercommand").setExecutor(new ExamplePlayerCommand());
        this.getCommand("exampleargumentcommand").setExecutor(new ExampleArgumentCommand());

        // Admin Commands
        this.getCommand("exampleadmincommand").setExecutor(new ExampleAdminCommand());

        // Gui Commands
        this.getCommand("examplegui").setExecutor(new ExampleGuiCommand());
    }

    private void registerConfigs() {
        exampleConfig = new ConfigManager(this, "exampleConfig");
    }
}
