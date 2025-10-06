
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragoncraftquest.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.dragoncraftquest.world.inventory.StatsguiMenu;
import net.mcreator.dragoncraftquest.world.inventory.CACguiMenu;
import net.mcreator.dragoncraftquest.DragonCraftQuestMod;

public class DragonCraftQuestModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DragonCraftQuestMod.MODID);
	public static final RegistryObject<MenuType<StatsguiMenu>> STATSGUI = REGISTRY.register("statsgui", () -> IForgeMenuType.create(StatsguiMenu::new));
	public static final RegistryObject<MenuType<CACguiMenu>> CA_CGUI = REGISTRY.register("ca_cgui", () -> IForgeMenuType.create(CACguiMenu::new));
}
