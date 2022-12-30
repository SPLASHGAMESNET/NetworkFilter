package net.splashgames.networkfilter;

import dev.waterdog.waterdogpe.event.EventPriority;
import dev.waterdog.waterdogpe.plugin.Plugin;
import net.splashgames.networkfilter.listener.EventListener;

public class NetworkFilter extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getEventManager().callEvent(new EventListener());
    }
}
