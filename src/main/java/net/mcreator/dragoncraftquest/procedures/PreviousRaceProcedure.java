package net.mcreator.dragoncraftquest.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

public class PreviousRaceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).race - 1;
			entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.race = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).race < 1) {
			{
				double _setval = 3;
				entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
