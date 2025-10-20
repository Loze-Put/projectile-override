package com.projectileoverride;

import lombok.Getter;
import net.runelite.api.Projectile;

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
