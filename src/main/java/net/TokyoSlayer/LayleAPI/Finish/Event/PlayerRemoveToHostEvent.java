package net.TokyoSlayer.LayleAPI.Finish.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class PlayerRemoveToHostEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    public PlayerRemoveToHostEvent(Player player, Plugin plugin) {
        if(player.hasPermission("HubLayle.host") && player.getServer().getOnlinePlayers().size() ==0){
            PermissionAttachment attachment = player.addAttachment(plugin);
            perms.put(player.getUniqueId(), attachment);
            perms.get(player.getUniqueId()).unsetPermission("HubLayle.host.ok");
        }
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
