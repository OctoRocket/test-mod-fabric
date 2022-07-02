package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.NetherStarItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.FeatureUpdater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "tutorial";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("tutorial");
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tutorial", "general"),
			() -> new ItemStack(ExampleMod.MOLTEN_INGOT)
	);

	public static final HeatRune HEAT_RUNE = new HeatRune(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).fireproof());
	public static final Item MOLTEN_INGOT = new Item(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).fireproof());
	public static final NetherStarItem LAVA_STAR = new NetherStarItem(new FabricItemSettings().group(ITEM_GROUP).fireproof());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, "heat_rune"), HEAT_RUNE);
		Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, "molten_ingot"), MOLTEN_INGOT);
		Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, "lava_star"), LAVA_STAR);

		FuelRegistry.INSTANCE.add(HEAT_RUNE, 200000);
		FuelRegistry.INSTANCE.add(LAVA_STAR, 400000);
	}
}
