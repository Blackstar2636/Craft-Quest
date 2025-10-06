
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragoncraftquest.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.dragoncraftquest.client.gui.StatsguiScreen;
import net.mcreator.dragoncraftquest.client.gui.CACguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DragonCraftQuestModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DragonCraftQuestModMenus.STATSGUI.get(), StatsguiScreen::new);
			MenuScreens.register(DragonCraftQuestModMenus.CA_CGUI.get(), CACguiScreen::new);
		});
	}
}
