package com.projectileoverride;

import java.util.ArrayList;
import java.util.List;

public enum BossProjectiles
{
	DEFAULT("Default"),
    RANDOM("Random", ProjectileIds.RANDOM, ProjectileIds.RANDOM, ProjectileIds.RANDOM),
    AKKHA("Akkha", 2253, 2255),
	CERBERUS("Cerberus", 1242, 1245),
	DAGGANOTH_KINGS("DKS", 162, 475, new int[] { 11588, 11589 }),
	DOOM_OF_MOKHAIOTL("Doom", 3379, 3380, 3378),
	DOOM_OF_MOKHAIOTL_ROCKS("Doom rocks", 3385, 3384),
	HUEYCOATL("Hueycoatl", 2975, 2972, 2969),
	HUNLLEF_NORMAL("Hunllef", 1707, 1711),
	HUNLLEF_CORRUPTED("Hunllef (c)", 1708, 1712),
    HYDRA("Hydra", 1662, 1663),
	INFERNO("Inferno", 1380, 1378),
    KALPHITE_QUEEN("Kalphite Queen", 280, 288),
    KREE_ARRA("Kree Arra", 1200, 1199),
    LEVIATHAN("Leviathan", 2489, 2487, 2488),
    MANTICORE("Manticore", 2681, 2683, 2685),
	OLM("Olm", 1341, 1343, 1345),
	SCURRIUS("Scurrius", 2640, 2642),
	SOTETSEG("Sotetseg", 1606, 1607),
	TORMENTED_DEMON("Tormented Demon", 2853, 2857),
	VARDORVIS("Vardorvis", 2520, 2521),
	WARDENS("Wardens", 2224, 2241),
    WARDENS_DIVINE("Wardens divine", 2208, 2206, 2204),
	WHISPERER("Whisperer", 2445, 2444),
	ZEBAK("Zebak", 2181, 2187),
	ZEBAK_ROCKS("Zebak rocks", new int[] { 2176, 2177 }, new int[] { 2178, 2179 }),
	ZULRAH("Zulrah", 1046, 1044);

	private final String name;
    private final int[] magicProjectiles;
    private final int[] rangedProjectiles;
    private final int[] meleeProjectiles;
    private final int[] requiredRegions;

    private BossProjectiles(String name) {
        this(name, new int[0], new int[0]);
    }

    private BossProjectiles(String name, int magicProjectile, int rangedProjectile) {
        this(name, new int[] { magicProjectile }, new int[] { rangedProjectile });
    }

    private BossProjectiles(String name, int magicProjectile, int rangedProjectile, int meleeProjectile) {
        this(name, new int[] { magicProjectile }, new int[] { rangedProjectile }, new int[] { meleeProjectile });
    }

    private BossProjectiles(String name, int magicProjectile, int rangedProjectile, int[] requiredRegions) {
        this(name, new int[] { magicProjectile }, new int[] { rangedProjectile }, new int[0], requiredRegions);
    }

	private BossProjectiles(String name, int[] magicProjectiles, int[] rangedProjectiles) {
		this(name, magicProjectiles, rangedProjectiles, new int[0]);
	}

    private BossProjectiles(String name, int[] magicProjectiles, int[] rangedProjectiles, int[] meleeProjectiles) {
        this(name, magicProjectiles, rangedProjectiles, meleeProjectiles, new int[0]);
    }

    private BossProjectiles(String name, int[] magicProjectiles, int[] rangedProjectiles, int[] meleeProjectiles, int[] requiredRegions) {
        this.name = name;
        this.magicProjectiles = magicProjectiles;
        this.rangedProjectiles = rangedProjectiles;
        this.meleeProjectiles = meleeProjectiles;
        this.requiredRegions = requiredRegions;
    }

    public int getMagicOverride() {
        return this.magicProjectiles.length > 0 ? this.magicProjectiles[0] : ProjectileIds.NONE;
    }

    public int getRangedOverride() {
        return this.rangedProjectiles.length > 0 ? this.rangedProjectiles[0] : ProjectileIds.NONE;
    }

    public int getMeleeOverride() {
        return this.meleeProjectiles.length > 0 ? this.meleeProjectiles[0] : ProjectileIds.NONE;
    }

    public List<ProjectileOverride> createOverride(BossProjectiles override) {
        var result = new ArrayList<ProjectileOverride>();

        result.addAll(createOverride(this.magicProjectiles, override.getMagicOverride(), ProjectileIds.STYLE_MAGIC));
        result.addAll(createOverride(this.rangedProjectiles, override.getRangedOverride(), ProjectileIds.STYLE_RANGED));
        result.addAll(createOverride(this.meleeProjectiles, override.getMeleeOverride(), ProjectileIds.STYLE_MELEE));

        return result;
    }

	@Override
	public String toString()
	{
		return name;
	}

    private List<ProjectileOverride> createOverride(int[] sourceProjectiles, int override, int style) {
        var result = new ArrayList<ProjectileOverride>();

        if (override != ProjectileIds.NONE) {
            for (int source : sourceProjectiles) {
                if(source != ProjectileIds.NONE && source != override) {
                    result.add(new ProjectileOverride(source, override, style, this.requiredRegions));
                }
            }
        }

        return result;
    }
}
