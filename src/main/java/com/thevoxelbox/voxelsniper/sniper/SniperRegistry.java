package com.thevoxelbox.voxelsniper.sniper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class SniperRegistry {

	private Map<UUID, Sniper> snipers = new HashMap<>();

	public void register(Sniper sniper) {
		UUID uuid = sniper.getUuid();
		this.snipers.put(uuid, sniper);
	}

	@Nullable
	public Sniper getSniper(Player player) {
		UUID uuid = player.getUniqueId();
		return getSniper(uuid);
	}

	@Nullable
	public Sniper getSniper(UUID uuid) {
		return this.snipers.get(uuid);
	}

	public Map<UUID, Sniper> getSnipers() {
		return Map.copyOf(this.snipers);
	}
}
