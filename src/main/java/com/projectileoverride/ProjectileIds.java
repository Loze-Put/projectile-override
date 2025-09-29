package com.projectileoverride;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class ProjectileIds
{
	public static final int NONE = -1;
    public static final int RANDOM = -2;

	// All ids are Mage, Ranged, Melee.
    public static final int[] AKKHA = new int[] {2253, 2255, NONE};
    public static final int[] CERBERUS = new int[] {1242, 1245, NONE};
	public static final int[] DAGGANOTH_KINGS = new int[] {162, 475, NONE};
	public static final int[] DOOM_OF_MOKHAIOTL = new int[] {3379, 3380, 3378};
	public static final int[] DOOM_OF_MOKHAIOTL_ROCKS = new int[] {3385, 3384, NONE};
	public static final int[] HUEYCOATL = new int[] {2975, 2972, 2969};
	public static final int[] HUNLLEF_NORMAL = new int[] {1707, 1711, NONE};
	public static final int[] HUNLLEF_CORRUPTED = new int[] {1708, 1712, NONE};
    public static final int[] HYDRA = new int[] {1662, 1663, NONE};
	public static final int[] INFERNO = new int[] {1380, 1378, NONE};
    public static final int[] KALPHITE_QUEEN = new int[] {280, 288, NONE};
    public static final int[] KREE_ARRA = new int[] {1200, 1199, NONE};
	public static final int[] LEVIATHAN = new int[] {2489, 2487, 2488};
    public static final int[] MANTICORE = new int[] {2681, 2683, 2685};
	public static final int[] OLM = new int[] {1341, 1343, 1345};
	public static final int[] SCRURRIUS = new int[] {2640, 2642, NONE};
	public static final int[] SOTETSEG = new int[] {1606, 1607, NONE};
    public static final int[] TORMENTED_DEMON = new int[] {2853, 2857, NONE};
	public static final int[] VARDORVIS = new int[] {2520, 2521, NONE};
	public static final int[] WARDENS = new int[] {2224, 2241, NONE};
    public static final int[] WARDENS_DIVINE = new int[] {2208, 2206, 2204};
    public static final int[] WHISPERER = new int[] {2445, 2444, NONE};
	public static final int[] ZEBAK = new int[] {2181, 2187, NONE};
	public static final int[] ZEBAK_ROCKS = new int[] {2176, 2178, NONE};
	public static final int[] ZULRAH = new int[] {1046, 1044, NONE};

    private static final List<Integer>[] ALL_PROJECTILES_PER_STYLE = buildPoolPerStyle();

	private ProjectileIds() {}

    public static int getRandomProjectile(int style) {
        var pool = ALL_PROJECTILES_PER_STYLE[style];
        return pool.get(ThreadLocalRandom.current().nextInt(pool.size()));
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildPoolPerStyle() {
        var allProjectiles = new int[][] {
                AKKHA,
                CERBERUS,
                DAGGANOTH_KINGS,
                DOOM_OF_MOKHAIOTL,
                DOOM_OF_MOKHAIOTL_ROCKS,
                HUEYCOATL,
                HUNLLEF_NORMAL,
                HUNLLEF_CORRUPTED,
                HYDRA,
                INFERNO,
                KALPHITE_QUEEN,
                KREE_ARRA,
                LEVIATHAN,
                MANTICORE,
                OLM,
                SCRURRIUS,
                SOTETSEG,
                TORMENTED_DEMON,
                VARDORVIS,
                WARDENS,
                WARDENS_DIVINE,
                WHISPERER,
                ZEBAK,
                ZEBAK_ROCKS,
                ZULRAH
        };

        List<Integer>[] pools = new List[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};

        for (int[] set : allProjectiles) {
            for (int i = 0; i < set.length; i++) {
                if (set[i] != NONE) {
                    pools[i].add(set[i]);
                }
            }
        }

        return pools;
    }
}
