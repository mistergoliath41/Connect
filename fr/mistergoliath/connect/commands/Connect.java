package fr.mistergoliath.connect.commands;

import java.net.InetSocketAddress;

import fr.mistergoliath.connect.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Connect extends Command {

	public Connect() {
		super("connect");
	}

	@Override
	public void execute(CommandSender cs, String[] args) {
		String host;
		int port;
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer)cs;
			if (!p.hasPermission("bungeecord.connect")) {
				return;
			}
			if (args.length == 1) {
				if (args[0].split(":").length == 2) {
					host = args[0].split(":")[0];
					port = Integer.parseInt(args[0].split(":")[1]);
				} else {
					host = args[0];
					port = 25565;
				}
				p.connect(ProxyServer.getInstance().constructServerInfo(args[0], new InetSocketAddress(host, port), "", false));
				System.out.println(args[0]);
			}
		}
	}

}
