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
import java.util.List;

import static org.shulker.core.ShulkerConstants.SHULKER_IG_PREFIX;
import static org.shulker.core.ShulkerConstants.SHULKER_PREFIX;

public interface ShulkerPlugin
{
	/**
	 * Gets Shulker's version.
	 *
	 * @return The version of Shulker.
	 */
	String getVersion();

	/**
	 * Gets the prefix of Shulker.
	 *
	 * @return Prefix of Shulker.
	 */
	default String getPrefix()
	{
		return SHULKER_PREFIX;
	}

	/**
	 * Gets the prefix of Shulker displayed in-game.
	 *
	 * @return The prefix of Shulker.
	 */
	default String getIGPrefix()
	{
		return SHULKER_IG_PREFIX;
	}

	default void logInfo(@NotNull String message)
	{
		logInfo(null, message);
	}

	void logInfo(@Nullable String prefix, @NotNull String message);

	default void logError(@NotNull String message)
	{
		logError(null, message);
	}

	void logError(@Nullable String prefix, @NotNull String message);

	/**
	 * Gets the base directory of the server.
	 *
	 * @return The base directory.
	 */
	File getBaseDirectory();

	/**
	 * Gets the configuration directory.
	 *
	 * @return The configuration directory.
	 */
	default File getConfigurationDirectory()
	{
		return new File(getBaseDirectory(), "configs/");
	}

	/**
	 * Gets the plugins directory of the server.
	 *
	 * @return Plugins directory.
	 */
	File getPluginsDirectory();

	/**
	 * Gets the configuration manager.
	 *
	 * @return The configuration manager.
	 */
	default @NotNull ConfigManager getConfigManager()
	{
		return ConfigManager.getConfigManager();
	}

	/**
	 * Gets the symbols manager.
	 *
	 * @return Symbols manager.
	 */
	ShulkerSymbols getSymbolsManager();

	/**
	 * Gets the configuration of Shulker.
	 *
	 * @return Shulker's configuration.
	 */
	ShulkerConfiguration getConfiguration();

	/**
	 * Gets the Minecraft manager of Shulker.
	 * Greets access to some Minecraft features like NMS, etc...
	 *
	 * @return Shulker's Minecraft manager.
	 */
	MinecraftManager getMinecraftManager();

	/**
	 * Lists the libraries loaded by Shulker.
	 *
	 * @return The libraries loaded by Shulker.
	 */
	List<ShulkerLibrary> getLibraries();
}