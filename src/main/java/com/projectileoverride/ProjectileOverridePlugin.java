package com.projectileoverride;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Projectile;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Projectile Override"
)
public class ProjectileOverridePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ProjectileOverrideConfig config;

	private HashMap<Integer, ProjectileOverride> overrideMap = new HashMap<>();

	private HashSet<Projectile> overriddenProjectiles = new HashSet<>();

	@Provides
	ProjectileOverrideConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ProjectileOverrideConfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		createOverrideMap();
	}

	@Override
	protected void shutDown() throws Exception {
		overriddenProjectiles.clear();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		if(!ProjectileOverrideConfig.CONFIG_GROUP.equals(event.getGroup())) {
			return;
		}

		createOverrideMap();
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved projectileMoved)
	{
		Projectile projectile = projectileMoved.getProjectile();

		// Prevent overriding projectiles that have already been overridden. This can happen if a player has configured
		// Boss A -> Boss B, Boss B -> Boss C. This will result in Boss A -> Boss C (instead of Boss B). Let's not talk
		// about what happens when you configure Boss A -> Boss B and Boss B -> Boss A.
		if (overriddenProjectiles.contains(projectile)) {
			return;
		}

		ProjectileOverride override = overrideMap.getOrDefault(projectile.getId(), null);

		if (override != null && override.canOverride(projectile)) {
			overriddenProjectiles.removeIf(p -> p.getRemainingCycles() < 0);
			overriddenProjectiles.add(replaceProjectile(projectile, override));
		}
	}

	private Projectile replaceProjectile(Projectile projectile, ProjectileOverride override)
	{
		Projectile overrideProjectile = client.createProjectile(
			override.getOverrideProjectileId(),
			projectile.getSourcePoint(),
			projectile.getStartHeight(), projectile.getSourceActor(),
			projectile.getTargetPoint(),
			projectile.getEndHeight(), projectile.getTargetActor(),
			projectile.getStartCycle(), projectile.getEndCycle(),
			projectile.getSlope(), projectile.getStartPos());

		client.getProjectiles().addLast(overrideProjectile);

		log.debug("Overriding projectile {} with {}", projectile.getId(), override.getOverrideProjectileId());

		// Hide the original projectile.
		projectile.setEndCycle(0);

		return overrideProjectile;
	}

	private void createOverrideMap() {
		overrideMap.clear();
		hydrateOverrideMap(BossProjectiles.CERBERUS, config.Cerberus());
		hydrateOverrideMap(BossProjectiles.DAGGANOTH_KINGS, config.DagganothKings());
		hydrateOverrideMap(BossProjectiles.DOOM_OF_MOKHAIOTL, config.DoomOfMokhaiotl());
		hydrateOverrideMap(BossProjectiles.DOOM_OF_MOKHAIOTL_ROCKS, config.DoomOfMokhaiotlRocks());
		hydrateOverrideMap(BossProjectiles.HUEYCOATL, config.Hueycoatl());
		hydrateOverrideMap(BossProjectiles.HUNLLEF_NORMAL, config.HunllefNormal());
		hydrateOverrideMap(BossProjectiles.HUNLLEF_CORRUPTED, config.HunllefCorrupted());
		hydrateOverrideMap(BossProjectiles.INFERNO, config.Inferno());
		hydrateOverrideMap(BossProjectiles.LEVIATHAN, config.Leviathan());
		hydrateOverrideMap(BossProjectiles.OLM, config.Olm());
		hydrateOverrideMap(BossProjectiles.SCURRIUS, config.Scurrius());
		hydrateOverrideMap(BossProjectiles.SOTETSEG, config.Sotetseg());
		hydrateOverrideMap(BossProjectiles.VARDORVIS, config.Vardorvis());
		hydrateOverrideMap(BossProjectiles.WARDENS, config.Wardens());
		hydrateOverrideMap(BossProjectiles.WHISPERER, config.Whisperer());
		hydrateOverrideMap(BossProjectiles.ZEBAK, config.Zebak());
		hydrateOverrideMap(BossProjectiles.ZEBAK_ROCKS, config.ZebakRocks());
		hydrateOverrideMap(BossProjectiles.ZULRAH, config.Zulrah());
	}

	private void hydrateOverrideMap(BossProjectiles source, BossProjectiles override) {
		var sourceIds = getProjectileIdsForBoss(source);
		var overrideIds = getProjectileIdsForBoss(override);
		var requiredRegion = getRegionIdsForBoss(source);

		for (var i = 0; i < sourceIds.length; i++) {
			if (sourceIds[i] != ProjectileIds.NONE &&
				overrideIds[i] != ProjectileIds.NONE &&
				sourceIds[i] != overrideIds[i]) {
				overrideMap.put(sourceIds[i], new ProjectileOverride(overrideIds[i], requiredRegion));
			}
		}
	}

	private int[] getProjectileIdsForBoss(BossProjectiles boss) {
		switch (boss) {
			case CERBERUS: return ProjectileIds.CERBERUS;
			case DAGGANOTH_KINGS: return ProjectileIds.DAGGANOTH_KINGS;
			case DOOM_OF_MOKHAIOTL: return ProjectileIds.DOOM_OF_MOKHAIOTL;
			case DOOM_OF_MOKHAIOTL_ROCKS: return ProjectileIds.DOOM_OF_MOKHAIOTL_ROCKS;
			case HUEYCOATL: return ProjectileIds.HUEYCOATL;
			case HUNLLEF_NORMAL: return ProjectileIds.HUNLLEF_NORMAL;
			case HUNLLEF_CORRUPTED: return ProjectileIds.HUNLLEF_CORRUPTED;
			case INFERNO: return ProjectileIds.INFERNO;
			case LEVIATHAN: return ProjectileIds.LEVIATHAN;
			case OLM: return ProjectileIds.OLM;
			case SCURRIUS: return ProjectileIds.SCRURRIUS;
			case SOTETSEG: return ProjectileIds.SOTETSEG;
			case VARDORVIS: return ProjectileIds.VARDORVIS;
			case WARDENS: return ProjectileIds.WARDENS;
			case WHISPERER: return ProjectileIds.WHISPERER;
			case ZEBAK: return ProjectileIds.ZEBAK;
			case ZEBAK_ROCKS: return ProjectileIds.ZEBAK_ROCKS;
			case ZULRAH: return ProjectileIds.ZULRAH;
			default:
				return new int[] {ProjectileIds.NONE, ProjectileIds.NONE, ProjectileIds.NONE};
		}
	}

	/**
	 * Gets the required region ids for the boss. Most bosses have unique projectiles so there is no need to configure
	 * regions.
	 */
	private int[] getRegionIdsForBoss(BossProjectiles boss) {
		switch (boss) {
			case DAGGANOTH_KINGS: return RegionIds.DAGGANOTH_KINGS;
			default:
				return RegionIds.NONE;
		}
	}
}
