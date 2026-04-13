package com.arthur.cheeseblock.client;

import net.fabricmc.api.ClientModInitializer;

public class CheeseBlockClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModItems.initialize();
	}
}