package com.projectileoverride;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class ProjectileIds
{
	public static final int NONE = -1;
    public static final int RANDOM = -2;

    public static final int STYLE_MAGIC = 0;
    public static final int STYLE_RANGED = 1;
    public static final int STYLE_MELEE = 2;

    private static final List<Integer>[] ALL_PROJECTILES_PER_STYLE = buildPoolPerStyle();

	private ProjectileIds() {}

    public static int getRandomProjectile(int style) {
        var pool = ALL_PROJECTILES_PER_STYLE[style];
        return pool.get(ThreadLocalRandom.current().nextInt(pool.size()));
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildPoolPerStyle() {
        List<Integer>[] pools = new List[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        BossProjectiles[] allProjectiles = BossProjectiles.values();

        for (var projectile : allProjectiles) {
            addToPool(pools[STYLE_MAGIC], projectile.getMagicOverride());
            addToPool(pools[STYLE_RANGED], projectile.getRangedOverride());
            addToPool(pools[STYLE_MELEE], projectile.getMeleeOverride());
        }

        return pools;
    }

    private static void addToPool(List<Integer> pool, int override) {
        if (override != ProjectileIds.NONE && override != ProjectileIds.RANDOM) {
            pool.add(override);
        }
    }
}
