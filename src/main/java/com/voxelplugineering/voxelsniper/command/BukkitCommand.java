/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 The Voxel Plugineering Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.voxelplugineering.voxelsniper.command;

import static com.google.common.base.Preconditions.checkNotNull;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.voxelplugineering.voxelsniper.api.ISniperRegistry;
import com.voxelplugineering.voxelsniper.common.command.Command;

/**
 * A wrapper for Gunsmith's commands which may be registered into the bukkit command handler.
 */
public class BukkitCommand extends org.bukkit.command.Command
{

    /**
     * The Gunsmith command underpinning this command.
     */
    Command cmd;
    
    private ISniperRegistry<Player> playerRegistry;

    /**
     * Creates a new {@link BukkitCommand}.
     * 
     * @param name the command name, cannot be null or empty
     * @param cmd the command, cannot be null
     * @param playerRegistry the player registry
     */
    protected BukkitCommand(String name, Command cmd, ISniperRegistry<Player> playerRegistry)
    {
        super(name);
        checkNotNull(cmd, "Command cannot be null");
        this.cmd = cmd;
        this.playerRegistry = playerRegistry;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean execute(CommandSender sender, String command, String[] args)
    {
        if (sender instanceof Player)
        {
            return this.cmd.execute(playerRegistry.get((Player) sender), args);
        } else
        {
            if (cmd.isPlayerOnly())
            {
                sender.sendMessage("Sorry this is a player only command.");
                return true;
            } else
            {
                return this.cmd.execute(playerRegistry.getConsoleSniperProxy(), args);
            }
        }
    }

}
