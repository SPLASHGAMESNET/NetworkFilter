package net.splashgames.networkfilter.listener;

import com.google.common.collect.Lists;
import dev.waterdog.waterdogpe.event.Event;
import dev.waterdog.waterdogpe.event.defaults.PlayerLoginEvent;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

import java.util.List;

public class EventListener extends Event {

    private static List<String> onlinePlayers = Lists.newCopyOnWriteArrayList();
    public void onJoin(PlayerLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        final String address = player.getAddress().getAddress().toString();
        int connected = 0;
        if(player.hasPermission("networkfilter.maxplayers.bypass")) {
            return;
        }

        if(player.hasPermission("networkfilter.maxplayers.4")) {
            if(onlinePlayers.contains(address)) {
                if(player.getAddress().getAddress().toString().equalsIgnoreCase(address)) {
                    connected++;
                }

                if(connected >= 4) {
                    return;
                } else {
                    event.setCancelReason("§9§lSPLASHGAMES§r§8 »§7 Fehler beim Verbinden. Über deine IP sind bereits 4 Accounts online!");
                }
        if(player.hasPermission("networkfilter.maxplayers.3")) {
                    if(onlinePlayers.contains(address)) {
                        if(player.getAddress().getAddress().toString().equalsIgnoreCase(address)) {
                            connected++;
                        }

                        if(connected >= 3) {
                            return;
                        } else {
                            event.setCancelReason("§9§lSPLASHGAMES§r§8 »§7 Fehler beim Verbinden. Über deine IP sind bereits 3 Accounts online!");

                     }
                  }
               } else {
                if(connected >= 2) {
                   return;
                 } else {
                    event.setCancelReason("§9§lSPLASHGAMES§r§8 »§7 Fehler beim Verbinden. Über deine IP sind bereits 2 Accounts online!");
                }
               }
            }
        }
    }
}



