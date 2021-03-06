/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of shulker.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.shulker.core.commands.defaults.shulker;

import org.aperlambda.kimiko.Command;
import org.aperlambda.kimiko.CommandContext;
import org.aperlambda.kimiko.CommandResult;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.shulker.core.Shulker;
import org.shulker.core.commands.BukkitCommandExecutor;
import org.shulker.core.commands.BukkitCommandTabCompleter;

import java.util.ArrayList;
import java.util.List;

import static net.md_5.bungee.api.ChatColor.GOLD;
import static net.md_5.bungee.api.ChatColor.GREEN;

public class ReloadCommand implements BukkitCommandExecutor, BukkitCommandTabCompleter
{
    @Override
    public @NotNull CommandResult execute(CommandContext<CommandSender> context, @NotNull Command<CommandSender> command, String label, String[] args)
    {
        if (args.length != 0)
            return CommandResult.ERROR_USAGE;

        context.send_message(Shulker.get_prefix_ig() + GREEN + " Reloading...");
        context.send_message(Shulker.get_prefix_ig() + GREEN + " Reloading " + GOLD + "configuration" + GREEN + "...");
        Shulker.get_configuration().load();
        context.send_message(Shulker.get_prefix_ig() + GREEN + " Reloading " + GOLD + "symbols" + GREEN + "...");
        Shulker.get_symbols_manager().load();
        context.send_message(Shulker.get_prefix_ig() + GREEN + " Reload done!");

        return CommandResult.SUCCESS;
    }

    @Override
    public List<String> on_tab_complete(CommandContext<CommandSender> context, @NotNull Command<CommandSender> command, String label, String[] args)
    {
        return new ArrayList<>();
    }
}