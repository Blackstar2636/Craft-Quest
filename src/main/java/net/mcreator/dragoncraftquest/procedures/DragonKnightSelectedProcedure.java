package net.mcreator.dragoncraftquest.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

public class DragonKnightSelectedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Dragon Knight";
			entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Race = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
