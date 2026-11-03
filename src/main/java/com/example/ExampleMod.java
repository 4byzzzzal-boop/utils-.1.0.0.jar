package com.utilityplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class UtilityPlusClient implements ClientModInitializer {
    public static boolean fullbrightEnabled = false;
    public static boolean hudEnabled = true;

    @Override
    public void onInitializeClient() {
        // Inject a modern menu button into the pause screen
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof GameMenuScreen) {
                var buttons = Screens.getButtons(screen);
                buttons.add(ButtonWidget.builder(
                        Text.literal("UtilityPlus"),
                        button -> client.setScreen(new UtilityPlusScreen(screen))
                )
                .dimensions(scaledWidth / 2 - 102, scaledHeight / 4 + 120, 204, 20)
                .build());
            }
        });
    }
}
