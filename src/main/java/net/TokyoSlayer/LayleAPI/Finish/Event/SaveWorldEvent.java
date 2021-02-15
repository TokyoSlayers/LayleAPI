package net.TokyoSlayer.LayleAPI.Finish.Event;

import net.TokyoSlayer.LayleAPI.Finish.Utils.CopyFile;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class SaveWorldEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SaveWorldEvent(Plugin plugin){
        for(World world : plugin.getServer().getWorlds()) {
            if(world.getEnvironment() == World.Environment.NORMAL && !world.getName().equals("WorldCopy")) {
                CopyFile.copyWorld(world, "WorldCopy");
                World unloadWorld = plugin.getServer().getWorld("WorldCopy");
                CopyFile.loadWorld(unloadWorld);
            }
        }
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
