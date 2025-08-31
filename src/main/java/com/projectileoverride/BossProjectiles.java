package com.projectileoverride;

public enum BossProjectiles
{
	DEFAULT("Default"),
	CERBERUS("Cerberus"),
	DAGGANOTH_KINGS("DKS"),
	DOOM_OF_MOKHAIOTL("Doom"),
	DOOM_OF_MOKHAIOTL_ROCKS("Doom rocks"),
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
	WHISPERER("Whisperer"),
	ZEBAK("Zebak"),
	ZEBAK_ROCKS("Zebak rocks"),
	ZULRAH("Zulrah");

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
