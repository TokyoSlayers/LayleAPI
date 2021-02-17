package net.TokyoSlayer.LayleAPI.Finish.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class PlayerAddToHostEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    public PlayerAddToHostEvent(Player player, Plugin plugin,String permission) {
        if(player.hasPermission("HubLayle.host") && player.getServer().getOnlinePlayers().size() ==0){
            PermissionAttachment attachment = player.addAttachment(plugin);
            perms.put(player.getUniqueId(), attachment);
            PermissionAttachment pperms = perms.get(player.getUniqueId());
            pperms.setPermission(permission, true);
        }
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
