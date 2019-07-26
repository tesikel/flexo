package net.runelite.client.plugins.flexobarbfishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.MenuAction;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class FlexoBarbFishOverlay extends Overlay
{
	private static final String TARGET = "Nmz barb fishing";

	private FlexoBarbFish plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private FlexoBarbFishOverlay(FlexoBarbFish plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);

		getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, "Reset state", TARGET));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		String overlayTitle = "Flexo barb fishing";

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(overlayTitle)
			.color(Color.GREEN)
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Enabled (hotkey):")
			.right(Boolean.toString(plugin.isEnabled()))
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("State:")
			.right(plugin.isEnabled() ? String.valueOf(plugin.getState()) : "Disabled")
			.build());

		return panelComponent.render(graphics);
	}
}
