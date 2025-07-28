package com.projectileoverride;

public enum BossProjectiles
{
	DOOM_OF_MOKHAIOTL("Doom"),
	HUEYCOATL("Hueycoatl"),
	HUNLLEF_NORMAL("Hunllef"),
	HUNLLEF_CORRUPTED("Hunllef (c)"),
	INFERNO("Inferno"),
	LEVIATHAN("Leviathan"),
	OLM("Olm"),
	SCURRIUS("Scurrius"),
	SOTETSEG("SOTETSEG"),
	VARDORVIS("Vardorvis"),
	WARDENS("Wardens"),
	WHISPERER("Whisperer");

	public final String name;

	private BossProjectiles(String name) {
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
