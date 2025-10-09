
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragoncraftquest.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.mcreator.dragoncraftquest.init.DragonCraftQuestModMenus.GuiSyncMessage;
import net.mcreator.dragoncraftquest.client.gui.StatsguiScreen;
import net.mcreator.dragoncraftquest.client.gui.CACguiScreen;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DragonCraftQuestModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DragonCraftQuestModMenus.STATSGUI.get(), StatsguiScreen::new);
			MenuScreens.register(DragonCraftQuestModMenus.CA_CGUI.get(), CACguiScreen::new);
		});
	}

	static void handleTextBoxMessage(GuiSyncMessage message) {
		String editbox = message.editbox();
		String value = message.value();
		Screen currentScreen = Minecraft.getInstance().screen;
		if (currentScreen instanceof WidgetScreen sc) {
			HashMap<String, Object> widgets = sc.getWidgets();
			Object obj = widgets.get("text:" + editbox);
			if (obj instanceof EditBox box) {
				box.setValue(value);
			}
		}
	}

	public interface WidgetScreen {
		HashMap<String, Object> getWidgets();
	}
}
