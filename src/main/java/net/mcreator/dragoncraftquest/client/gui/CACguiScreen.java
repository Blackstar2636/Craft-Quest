package net.mcreator.dragoncraftquest.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dragoncraftquest.world.inventory.CACguiMenu;
import net.mcreator.dragoncraftquest.procedures.RaceVARProcedure;
import net.mcreator.dragoncraftquest.procedures.PlayerDisplayProcedure;
import net.mcreator.dragoncraftquest.network.CACguiButtonMessage;
import net.mcreator.dragoncraftquest.init.DragonCraftQuestModScreens.WidgetScreen;
import net.mcreator.dragoncraftquest.DragonCraftQuestMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CACguiScreen extends AbstractContainerScreen<CACguiMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = CACguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_prev_button;
	ImageButton imagebutton_next_button;
	ImageButton imagebutton_next_button1;
	ImageButton imagebutton_prev_button1;
	ImageButton imagebutton_next_button2;
	ImageButton imagebutton_prev_button2;

	public CACguiScreen(CACguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("dragon_craft_quest:textures/screens/ca_cgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (PlayerDisplayProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 127, this.topPos + 36, 50, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("dragon_craft_quest:textures/screens/statgui.png"), this.leftPos + -99, this.topPos + -106, 0, 0, 200, 200, 200, 200);

		RenderSystem.disableBlend();
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				RaceVARProcedure.execute(entity), -43, -98, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_prev_button = new ImageButton(this.leftPos + -53, this.topPos + -100, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_prev_button.png"), 16, 32, e -> {
			if (true) {
				DragonCraftQuestMod.PACKET_HANDLER.sendToServer(new CACguiButtonMessage(0, x, y, z, textstate));
				CACguiButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_prev_button", imagebutton_prev_button);
		this.addRenderableWidget(imagebutton_prev_button);
		imagebutton_next_button = new ImageButton(this.leftPos + 47, this.topPos + -101, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_next_button.png"), 16, 32, e -> {
			if (true) {
				DragonCraftQuestMod.PACKET_HANDLER.sendToServer(new CACguiButtonMessage(1, x, y, z, textstate));
				CACguiButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_next_button", imagebutton_next_button);
		this.addRenderableWidget(imagebutton_next_button);
		imagebutton_next_button1 = new ImageButton(this.leftPos + -60, this.topPos + -21, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_next_button1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_next_button1", imagebutton_next_button1);
		this.addRenderableWidget(imagebutton_next_button1);
		imagebutton_prev_button1 = new ImageButton(this.leftPos + -95, this.topPos + -22, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_prev_button1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_prev_button1", imagebutton_prev_button1);
		this.addRenderableWidget(imagebutton_prev_button1);
		imagebutton_next_button2 = new ImageButton(this.leftPos + 82, this.topPos + -22, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_next_button2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_next_button2", imagebutton_next_button2);
		this.addRenderableWidget(imagebutton_next_button2);
		imagebutton_prev_button2 = new ImageButton(this.leftPos + 46, this.topPos + -23, 16, 16, 0, 0, 16, new ResourceLocation("dragon_craft_quest:textures/screens/atlas/imagebutton_prev_button2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_prev_button2", imagebutton_prev_button2);
		this.addRenderableWidget(imagebutton_prev_button2);
	}
}
