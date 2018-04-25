/*
 * Copyright © 2018 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of shulker.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.shulker.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.shulker.core.config.ConfigManager;
import org.shulker.core.config.ShulkerConfiguration;
import org.shulker.core.config.ShulkerSymbols;

import java.io.File;

public class Shulker
{
	private static ShulkerPlugin SHULKER;

	public static void init(@NotNull ShulkerPlugin plugin)
	{
		if (SHULKER != null)
			throw new RuntimeException("Shulker is already initialized!");
		SHULKER = plugin;

		logInfo(getPrefix(), "Loading Shulker...");
	}

	/**
	 * Gets the Shulker implementation.
	 *
	 * @return Shulker's implementation.
	 */
	public static ShulkerPlugin getShulker()
	{
		return SHULKER;
	}

	/**
	 * Gets Shulker's version.
	 *
	 * @return The version of Shulker.
	 */
	public static String getVersion()
	{
		return SHULKER.getVersion();
	}

	/**
	 * Gets the prefix of Shulker.
	 *
	 * @return Prefix of Shulker.
	 */
	public static String getPrefix()
	{
		return SHULKER.getPrefix();
	}

	/**
	 * Gets the prefix of Shulker displayed in-game.
	 *
	 * @return The prefix of Shulker.
	 */
	public static String getPrefixIG()
	{
		return SHULKER.getIGPrefix();
	}

	public static void logInfo(@NotNull String message)
	{
		SHULKER.logInfo(message);
	}

	public static void logInfo(@Nullable String prefix, @NotNull String message)
	{
		SHULKER.logInfo(prefix, message);
	}

	public static void logError(@NotNull String message)
	{
		SHULKER.logError(message);
	}

	public static void logError(@Nullable String prefix, @NotNull String message)
	{
		SHULKER.logError(prefix, message);
	}

	/**
	 * Gets the base directory of the server.
	 *
	 * @return The base directory.
	 */
	public static File getBaseDirectory()
	{
		return SHULKER.getBaseDirectory();
	}

	public static File getConfigurationDirectory()
	{
		return SHULKER.getConfigurationDirectory();
	}

	/**
	 * Gets the plugins directory of the server.
	 *
	 * @return Plugins directory.
	 */
	public static File getPluginsDirectory()
	{
		return SHULKER.getPluginsDirectory();
	}

	/**
	 * Gets the configuration manager.
	 *
	 * @return The configuration manager.
	 */
	public static @NotNull ConfigManager getConfigManager()
	{
		return SHULKER.getConfigManager();
	}

	/**
	 * Gets the symbols manager.
	 *
	 * @return Symbols manager.
	 */
	public static ShulkerSymbols getSymbolsManager()
	{
		return SHULKER.getSymbolsManager();
	}

	/**
	 * Gets the configuration of Shulker.
	 *
	 * @return Shulker's configuration.
	 */
	public static ShulkerConfiguration getConfiguration()
	{
		return SHULKER.getConfiguration();
	}

	/**
	 * Gets the Minecraft manager of Shulker.
	 * Greets access to some Minecraft features like NMS, etc...
	 *
	 * @return Shulker's Minecraft manager.
	 */
	public static MinecraftManager getMinecraftManager()
	{
		return SHULKER.getMinecraftManager();
	}
}