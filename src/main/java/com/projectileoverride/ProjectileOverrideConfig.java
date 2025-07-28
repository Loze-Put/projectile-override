package com.projectileoverride;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("projectileoverride")
public interface ProjectileOverrideConfig extends Config
{
	@ConfigItem(
		keyName = "dom",
		name = "Doom of Mokhaiotl",
		description = "Projectile override for Doom of Mokhaiotl"
	)
	default BossProjectiles DoomOfMokhaiotl()
	{
		return BossProjectiles.DOOM_OF_MOKHAIOTL;
	}

	@ConfigItem(
		keyName = "hueycoatl",
		name = "Hueycoatl",
		description = "Projectile override for Hueycoatl"
	)
	default BossProjectiles Hueycoatl() {
		return BossProjectiles.HUEYCOATL;
	}

	@ConfigItem(
		keyName = "hunllefnormal",
		name = "Hunllef",
		description = "Projectile override for normal Hunllef"
	)
	default BossProjectiles HunllefNormal() {
		return BossProjectiles.HUNLLEF_NORMAL;
	}

	@ConfigItem(
		keyName = "hunllefcorrupted",
		name = "Hunllef (Corrupted)",
		description = "Projectile override for corrupted Hunllef"
	)
	default BossProjectiles HunllefCorrupted() {
		return BossProjectiles.HUNLLEF_CORRUPTED;
	}

	@ConfigItem(
		keyName = "inferno",
		name = "Inferno",
		description = "Projectile override for the blobs in the Inferno"
	)
	default BossProjectiles Inferno() {
		return BossProjectiles.INFERNO;
	}

	@ConfigItem(
		keyName = "leviathan",
		name = "Leviathan",
		description = "Projectile override for Leviathan"
	)
	default BossProjectiles Leviathan() {
		return BossProjectiles.LEVIATHAN;
	}

	@ConfigItem(
		keyName = "olm",
		name = "Olm",
		description = "Projectile override for Olm in the Chambers of Xeric"
	)
	default BossProjectiles Olm() {
		return BossProjectiles.OLM;
	}

	@ConfigItem(
		keyName = "scurrius",
		name = "Scurrius",
		description = "Projectile override for Scurrius"
	)
	default BossProjectiles Scurrius() {
		return BossProjectiles.SCURRIUS;
	}

	@ConfigItem(
		keyName = "sotetseg",
		name = "Sotetseg",
		description = "Projectile override for Sotetseg in the Theatre of Blood"
	)
	default BossProjectiles Sotetseg() {
		return BossProjectiles.SOTETSEG;
	}

	@ConfigItem(
		keyName = "vardorvis",
		name = "Vardorvis",
		description = "Projectile override for Vardorvis"
	)
	default BossProjectiles Vardorvis() {
		return BossProjectiles.VARDORVIS;
	}

	@ConfigItem(
		keyName = "wardens",
		name = "Wardens",
		description = "Projectile override for Wardens in the Tombs of Amascut"
	)
	default BossProjectiles Wardens() {
		return BossProjectiles.WARDENS;
	}

	@ConfigItem(
		keyName = "whisperer",
		name = "Whisperer",
		description = "Projectile override for the Whisperer"
	)
	default BossProjectiles Whisperer() {
		return BossProjectiles.WHISPERER;
	}
}
