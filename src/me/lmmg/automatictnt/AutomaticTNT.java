package me.lmmg.automatictnt;

import org.bukkit.plugin.java.JavaPlugin;

import me.lmmg.automatictnt.managers.ListenerManager;
import me.lmmg.automatictnt.util.ConfigurationUtil;

public class AutomaticTNT extends JavaPlugin {

	public ConfigurationUtil settings;

	public void onEnable() {

		setupConfiguration();
		initiateManagers();

	}

	private void initiateManagers() {

		new ListenerManager(this);

	}

	private void setupConfiguration() {

		settings = new ConfigurationUtil(this, "settings.yml", (String) null);
		settings.saveDefaultConfiguration();

	}

}
