package net.mcreator.dragoncraftquest.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MpChargeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MPCharge == true) {
			if ((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MP < (entity
					.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MaxMP) {
				{
					double _setval = (entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MPTimer + 1;
					entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MPTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MPTimer > 20) {
					{
						double _setval = 0;
						entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MPTimer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MP
								+ (entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MaxMP * 0.05;
						entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
