package com.projectileoverride;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(ProjectileOverrideConfig.CONFIG_GROUP)
public interface ProjectileOverrideConfig extends Config
{
	public static final String CONFIG_GROUP = "projectileoverride";

	@ConfigItem(
		keyName = "cerberus",
		name = "Cerberus",
		description = "Projectile override for Cerberus"
	)
	default BossProjectiles Cerberus() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "dks",
		name = "Dagganoth Kings",
		description = "Projectile override for the Dagganoth Kings"
	)
	default BossProjectiles DagganothKings() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "dom",
		name = "Doom of Mokhaiotl",
		description = "Projectile override for Doom of Mokhaiotl"
	)
	default BossProjectiles DoomOfMokhaiotl()
	{
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "dom-rocks",
		name = "Doom of Mokhaiotl rocks",
		description = "Projectile override for Doom of Mokhaiotl rocks"
	)
	default BossProjectiles DoomOfMokhaiotlRocks()
	{
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "hueycoatl",
		name = "Hueycoatl",
		description = "Projectile override for Hueycoatl"
	)
	default BossProjectiles Hueycoatl() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "hunllefnormal",
		name = "Hunllef",
		description = "Projectile override for normal Hunllef"
	)
	default BossProjectiles HunllefNormal() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "hunllefcorrupted",
		name = "Hunllef (Corrupted)",
		description = "Projectile override for corrupted Hunllef"
	)
	default BossProjectiles HunllefCorrupted() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "inferno",
		name = "Inferno",
		description = "Projectile override for the blobs in the Inferno"
	)
	default BossProjectiles Inferno() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "leviathan",
		name = "Leviathan",
		description = "Projectile override for Leviathan"
	)
	default BossProjectiles Leviathan() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "olm",
		name = "Olm",
		description = "Projectile override for Olm in the Chambers of Xeric"
	)
	default BossProjectiles Olm() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "scurrius",
		name = "Scurrius",
		description = "Projectile override for Scurrius"
	)
	default BossProjectiles Scurrius() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "sotetseg",
		name = "Sotetseg",
		description = "Projectile override for Sotetseg in the Theatre of Blood"
	)
	default BossProjectiles Sotetseg() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "vardorvis",
		name = "Vardorvis",
		description = "Projectile override for Vardorvis"
	)
	default BossProjectiles Vardorvis() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "wardens",
		name = "Wardens",
		description = "Projectile override for Wardens in the Tombs of Amascut"
	)
	default BossProjectiles Wardens() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "whisperer",
		name = "Whisperer",
		description = "Projectile override for the Whisperer"
	)
	default BossProjectiles Whisperer() {
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "zebak",
		name = "Zebak",
		description = "Projectile override for regular Zebak attacks"
	)
	default BossProjectiles Zebak()
	{
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "zebak-rocks",
		name = "Zebak rocks",
		description = "Projectile override for the rocks and jugs attacks of Zebak"
	)
	default BossProjectiles ZebakRocks()
	{
		return BossProjectiles.DEFAULT;
	}

	@ConfigItem(
		keyName = "zulrah",
		name = "Zulrah",
		description = "Projectile override for Zulrah"
	)
	default BossProjectiles Zulrah() {
		return BossProjectiles.DEFAULT;
	}
}
