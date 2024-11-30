package roustytousty.minecraftPaperPluginTemplate.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

public class ConfigManager {
    private final JavaPlugin plugin;
    private File file;
    private YamlConfiguration config;
    private final Logger logger;

    public ConfigManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
        initialize(fileName);
    }

    private void initialize(String fileName) {
        file = new File(plugin.getDataFolder(), fileName + ".yml");

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        if (!file.exists()) {
            try (InputStream resource = plugin.getResource(fileName + ".yml")) {
                if (resource != null) {
                    Files.copy(resource, file.toPath());
                    logger.info(fileName + ".yml not found. Creating from resource!");
                } else {
                    logger.warning(fileName + ".yml not found in resources. Creating empty file!");
                    file.createNewFile();
                }
            } catch (IOException e) {
                logger.severe("Failed to create " + fileName + ".yml!");
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
        logger.info(fileName + ".yml loaded successfully!");
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(file);
            logger.info(file.getName() + " saved successfully!");
        } catch (IOException e) {
            logger.severe("Could not save " + file.getName() + "!");
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
        logger.info(file.getName() + " reloaded successfully!");
    }
}

