package net.mcreator.dragoncraftquest.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragoncraftquest.network.DragonCraftQuestModVariables;

public class MpVARProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("MP: " + new java.text.DecimalFormat("##.##").format((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MP)) + ""
				+ ("/" + new java.text.DecimalFormat("##.##").format((entity.getCapability(DragonCraftQuestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonCraftQuestModVariables.PlayerVariables())).MaxMP));
	}
}
