package net.TokyoSlayer.LayleAPI.Finish.Event;

import net.TokyoSlayer.LayleAPI.Finish.Utils.MySQL;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class MySQLStartEvent extends Event {

    private int counter;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MySQLStartEvent(String host, String database, String port, String user, String password)  {
        MySQL.connect(host, database, Integer.parseInt(port), user, password);
        if (!MySQL.isConnected()) {
            MySQL.disconnect();
            MySQL.connect(host, database, Integer.parseInt(port), user, password);
            System.out.println("MySQL ckeck REDEMARER !");
        } else {
            System.out.println("MySQL check OK !");
        }
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
