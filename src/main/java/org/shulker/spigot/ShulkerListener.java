/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of shulker.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.shulker.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.shulker.core.Shulker;

public class ShulkerListener implements Listener
{
    @EventHandler
    public void on_player_join(PlayerJoinEvent e)
    {
        Shulker.get_mc().add_player(e.getPlayer());
    }

    @EventHandler
    public void on_player_leave(PlayerQuitEvent e)
    {
        Shulker.get_mc().remove_player(e.getPlayer().getUniqueId());
    }
}
