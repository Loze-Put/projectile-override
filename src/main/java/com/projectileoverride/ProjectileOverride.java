package com.projectileoverride;

import lombok.Getter;
import net.runelite.api.Projectile;

public class ProjectileOverride
{
	@Getter
	private final int overrideProjectileId;

	private final int[] requiredRegion;

    public ProjectileOverride(int overrideProjectileId, int[] requiredRegion) {
		this.overrideProjectileId = overrideProjectileId;
		this.requiredRegion = requiredRegion;
	}

	public boolean canOverride(Projectile projectile) {
		if (requiredRegion == null || requiredRegion.length == 0) {
			return true;
		}

		for (int regionId: requiredRegion)
		{
			if (projectile.getSourcePoint().getRegionID() == regionId) {
				return true;
			}
		}

		return false;
	}
}
