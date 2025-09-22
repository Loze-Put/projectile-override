package com.projectileoverride;

public enum BossProjectiles
{
	DEFAULT("Default"),
    AKKHA("Akkha"),
	CERBERUS("Cerberus"),
	DAGGANOTH_KINGS("DKS"),
	DOOM_OF_MOKHAIOTL("Doom"),
	DOOM_OF_MOKHAIOTL_ROCKS("Doom rocks"),
	HUEYCOATL("Hueycoatl"),
	HUNLLEF_NORMAL("Hunllef"),
	HUNLLEF_CORRUPTED("Hunllef (c)"),
    HYDRA("Hydra"),
	INFERNO("Inferno"),
	LEVIATHAN("Leviathan"),
    KALPHITE_QUEEN("Kalphite Queen"),
    KREE_ARRA("Kree Arra"),
	OLM("Olm"),
	SCURRIUS("Scurrius"),
	SOTETSEG("Sotetseg"),
	VARDORVIS("Vardorvis"),
	WARDENS("Wardens"),
    WARDENS_DIVINE("Wardens divine"),
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
