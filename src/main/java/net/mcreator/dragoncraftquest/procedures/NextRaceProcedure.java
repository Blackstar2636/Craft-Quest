package net.mcreator.dragoncraftquest.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

public class NextRaceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).race + 1;
			entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.race = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).race > 3) {
			{
				double _setval = 1;
				entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
