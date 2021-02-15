package net.TokyoSlayer.LayleAPI.Finish.Event;

import net.TokyoSlayer.LayleAPI.Finish.Utils.MySQL;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class MySQLReloadEvent extends Event {

    private int counter;

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public MySQLReloadEvent(int iReload,String host,String database,String port,String user,String password) {
        int reload = iReload*20;
        new BukkitRunnable() {
            @Override
            public void run() {
                counter++;

                if (counter == reload) {
                    if (!MySQL.isConnected()) {
                        MySQL.disconnect();
                        MySQL.connect(host, database, Integer.parseInt(port), user, password);
                        System.out.println("MySQL ckeck REDEMARER !");
                    } else {
                        System.out.println("MySQL check OK !");
                    }
                    counter = 0;
                }
            }
        };
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
