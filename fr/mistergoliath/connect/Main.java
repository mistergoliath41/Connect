package fr.mistergoliath.connect;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import fr.mistergoliath.connect.commands.Connect;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class Main extends Plugin implements Listener {
	
	private static String name = "Connect";

	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, this);
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new Connect());
	}
	
	public static String getName() {
		return name;
	}
	
}
