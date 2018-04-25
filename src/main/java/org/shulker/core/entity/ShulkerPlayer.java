/*
 * Copyright © 2018 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of shulker.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.shulker.core.entity;

import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;
import org.shulker.core.Shulker;
import org.shulker.core.packets.ShulkerPacket;
import org.shulker.core.packets.mc.play.ShulkerPacketTitle;

/**
 * Represents a player.
 *
 * @param <T> The server object type.
 */
public interface ShulkerPlayer<T>
{
	/**
	 * Sends a message to the player.
	 *
	 * @param message The components to send.
	 */
	void sendMessage(BaseComponent... message);

	/**
	 * Sends a message in the action bar to the player.
	 *
	 * @param message The component to send.
	 */
	default void sendActionBar(BaseComponent... message)
	{
		sendPacket(Shulker.getMCManager().newPacketTitle(ShulkerPacketTitle.TitleAction.ACTIONBAR, message));
	}

	/**
	 * Sends a title to the player.
	 *
	 * @param title    The title.
	 * @param subTitle The subtitle.
	 * @param fadeIn   Ticks to spend fading in.
	 * @param stay     Ticks to keep the title displayed.
	 * @param fadeOut  Ticks to spend fading out.
	 */
	default void sendTitle(BaseComponent[] title, BaseComponent[] subTitle, int fadeIn, int stay, int fadeOut)
	{
		// Times
		var packet = Shulker.getMCManager().newPacketTitle(ShulkerPacketTitle.TitleAction.RESET);
		sendPacket(packet);
		// Title
		if (title != null)
		{
			packet.setAction(ShulkerPacketTitle.TitleAction.TITLE);
			packet.setChatComponentValue(title);
			sendPacket(packet);
		}
		// Subtitle
		if (subTitle != null)
		{
			packet.setAction(ShulkerPacketTitle.TitleAction.SUBTITLE);
			packet.setChatComponentValue(subTitle);
			sendPacket(packet);
		}

		packet.setAction(ShulkerPacketTitle.TitleAction.TIMES);
		packet.setTimes(fadeIn, stay, fadeOut);
		System.out.println("Action: " + packet.getAction() + ", fadeIn: " + packet.getFadeIn() + ", stay: " + packet.getStay() + ", fadeOut: " + packet.getFadeOut());
		sendPacket(packet);
	}

	/**
	 * Resets the title
	 */
	default void resetTitle()
	{

	}

	/**
	 * Sends a Shulker's packet to the player.
	 *
	 * @param packet The packet to send.
	 */
	default void sendPacket(@NotNull ShulkerPacket<?> packet)
	{
		sendRawPacket(packet.getHandle());
	}

	/**
	 * Sends a raw packet to the player.
	 *
	 * @param rawPacket The packet to send.
	 */
	void sendRawPacket(Object rawPacket);

	/**
	 * Gets the ping of the player in milliseconds.
	 *
	 * @return The ping of the player.
	 */
	int getPing();

	/**
	 * Gets the locale used by the player.
	 *
	 * @return The locale as a string.
	 */
	String getLocale();

	/**
	 * Gets the player handle.
	 *
	 * @return The handle.
	 */
	@NotNull T getPlayerHandle();
}