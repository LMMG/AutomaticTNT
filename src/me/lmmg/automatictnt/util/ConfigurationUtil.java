package me.lmmg.automatictnt.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationUtil {

	private JavaPlugin plugin;

	private String name;
	private String folder;

	private File file;

	private FileConfiguration configuration;

	public ConfigurationUtil(JavaPlugin plugin, String name, String folder) {

		if (plugin == null) {

			throw new IllegalStateException("The plugin can't be equaled to null!");

		} else {

			this.plugin = plugin;
			this.name = name;
			this.folder = folder;

			if (this.folder == null) {

				this.file = new File(plugin.getDataFolder(), name);

			} else {

				this.file = new File(plugin.getDataFolder() + "/" + this.folder, name);

			}

		}

	}

	public FileConfiguration getConfiguration() {

		if (configuration == null) {

			reloadConfiguration();

		}

		return configuration;

	}

	public File getFile() {

		return file;

	}

	public void reloadConfiguration() {

		configuration = YamlConfiguration.loadConfiguration(file);

		InputStream defaultConfigurationStream = plugin.getResource(name);

		if (defaultConfigurationStream != null) {

			YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigurationStream));

			configuration.setDefaults(defaultConfiguration);

		}

	}

	public void saveConfiguration() {

		if (configuration != null && file != null) {

			try {

				getConfiguration().save(file);

			} catch (IOException exception) {

				plugin.getLogger().warning("An error has occured whilst trying to process the saving the configuration file!");

			}

		}

	}

	public void saveDefaultConfiguration() {

		if (!file.exists()) {

			plugin.saveResource(name, false);

		}

	}

	public void deleteConfiguration() {

		file.delete();

	}

}
