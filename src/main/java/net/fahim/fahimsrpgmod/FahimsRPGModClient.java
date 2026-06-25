package net.fahim.fahimsrpgmod;

import com.mojang.blaze3d.platform.IconSet;
import net.fahim.fahimsrpgmod.client.ModHudRenderer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.stb.STBImage;

import java.io.InputStream;
import java.nio.ByteBuffer;

@Mod(value = FahimsRPGMod.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = FahimsRPGMod.MOD_ID, value = Dist.CLIENT)
public class FahimsRPGModClient {

    public FahimsRPGModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Minecraft.getInstance().getWindow().setTitle("⚔ Fahim's RPG Mod ⚔");

            try {
                InputStream iconStream = FahimsRPGModClient.class.getResourceAsStream("/assets/fahimsrpgmod/icon.png");
                if (iconStream != null) {
                    byte[] iconBytes = iconStream.readAllBytes();
                    ByteBuffer iconBuffer = ByteBuffer.allocateDirect(iconBytes.length);
                    iconBuffer.put(iconBytes);
                    iconBuffer.flip();

                    java.lang.reflect.Field handleField = Minecraft.getInstance().getWindow().getClass().getDeclaredField("handle");
                    handleField.setAccessible(true);
                    long windowHandle = (long) handleField.get(Minecraft.getInstance().getWindow());

                    int[] w = new int[1], h = new int[1], channels = new int[1];
                    ByteBuffer pixels = STBImage.stbi_load_from_memory(iconBuffer, w, h, channels, 4);
                    if (pixels != null) {
                        GLFWImage.Buffer icons = GLFWImage.malloc(1);
                        icons.position(0).width(w[0]).height(h[0]).pixels(pixels);
                        GLFW.glfwSetWindowIcon(windowHandle, icons);
                        STBImage.stbi_image_free(pixels);
                        System.out.println("Icon set successfully!");
                    } else {
                        System.out.println("Failed to decode icon PNG");
                    }
                } else {
                    System.out.println("Icon file not found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}