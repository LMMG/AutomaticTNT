package me.lmmg.automatictnt.managers;

import me.lmmg.automatictnt.AutomaticTNT;
import me.lmmg.automatictnt.listeners.BlockListener;

public class ListenerManager {

	public AutomaticTNT plugin;

	public ListenerManager(AutomaticTNT pl) {

		plugin = pl;

		registerListeners();

	}

	private void registerListeners() {

		new BlockListener(plugin);

	}

}
