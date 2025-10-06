
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragoncraftquest.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dragoncraftquest.network.MpChargeKeyMessage;
import net.mcreator.dragoncraftquest.DragonCraftQuestMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DragonCraftQuestModKeyMappings {
	public static final KeyMapping MP_CHARGE_KEY = new KeyMapping("key.dragon_craft_quest.mp_charge_key", GLFW.GLFW_KEY_C, "key.categories.dragon_craft_quest") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DragonCraftQuestMod.PACKET_HANDLER.sendToServer(new MpChargeKeyMessage(0, 0));
				MpChargeKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MP_CHARGE_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MP_CHARGE_KEY_LASTPRESS);
				DragonCraftQuestMod.PACKET_HANDLER.sendToServer(new MpChargeKeyMessage(1, dt));
				MpChargeKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long MP_CHARGE_KEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MP_CHARGE_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MP_CHARGE_KEY.consumeClick();
			}
		}
	}
}
