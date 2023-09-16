package dev.vaaaleh.hub.util;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import dev.vaaaleh.hub.HubPlugin;
import org.bukkit.entity.Player;
import java.io.ByteArrayOutputStream;
public class BungeeUtils {

    public static void sendPlayerToServer(Player player, String serverName) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ByteArrayDataOutput out = ByteStreams.newDataOutput(b);
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(HubPlugin.getInstance(),"BungeeCord", b.toByteArray());

    }

}
