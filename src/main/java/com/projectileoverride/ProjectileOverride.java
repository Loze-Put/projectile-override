package com.projectileoverride;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public class ProjectileOverride
{
    @Getter
    private final int sourceProjectileId;
	private final int overrideProjectileId;
    private final int style;
	private final int[] requiredRegion;

    public ProjectileOverride(int sourceProjectileId, int overrideProjectileId, int style, int[] requiredRegion) {
		this.sourceProjectileId = sourceProjectileId;
        this.overrideProjectileId = overrideProjectileId;
        this.style = style;
		this.requiredRegion = requiredRegion;
	}

    public int getOverrideProjectileId() {
        if (overrideProjectileId == ProjectileIds.RANDOM) {
            return ProjectileIds.getRandomProjectile(style);
        }

        return overrideProjectileId;
    }

	public boolean canOverride(Projectile projectile, Client client) {
		if (requiredRegion == null || requiredRegion.length == 0) {
			return true;
		}

		// Whenever in an instance, the projectile.getSourcePoint().getRegionID() returns the instanced
		// region ID, which changes any time you enter a new instance.
		// This helps us to obtain the actual map region ID.
		final int regionFromInstance = getRegionFromInstance(client);

		for (int regionId : requiredRegion) {
			if (projectile.getSourcePoint().getRegionID() == regionId || regionFromInstance == regionId) {
				return true;
			}
		}

		return false;
	}

	private int getRegionFromInstance(Client client) {
		if (client.getLocalPlayer() == null) {
			return -1;
		}
		LocalPoint playerInstancePoint = client.getLocalPlayer().getLocalLocation();
		return WorldPoint.fromLocalInstance(client, playerInstancePoint).getRegionID();
	}
}
