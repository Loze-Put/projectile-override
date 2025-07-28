package com.projectileoverride;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ProjectileOverridePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ProjectileOverridePlugin.class);
		RuneLite.main(args);
	}
}