package net.mcreator.dragoncraftquest.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

public class MpChargeKeyOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MPCharge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
