package net.galaxyblast.enchanttablecontrol;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = EnchantTableControl.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue MAX_HORIZONTAL_DIST = BUILDER
            .comment("The maximum horizontal manhattan distance bookshelves can be from an enchanting table.")
            .defineInRange("maxHorizontalDistance", 2, 2, Integer.MAX_VALUE);

    private static final ModConfigSpec.IntValue MAX_VERTICAL_DIST_UP = BUILDER
            .comment("The maximum manhattan distance bookshelves can be above an enchanting table.")
            .defineInRange("maxVerticalDistanceUp", 1, 0, Integer.MAX_VALUE);

    private static final ModConfigSpec.IntValue MAX_VERTICAL_DIST_DOWN = BUILDER
            .comment("The maximum manhattan distance bookshelves can be below an enchanting table.")
            .defineInRange("maxVerticalDistanceDown", 0, 0, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static int maxHorizontalDistance;
    public static int maxVerticalDistanceUp;
    public static int maxVerticalDistanceDown;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        maxHorizontalDistance = MAX_HORIZONTAL_DIST.get();
        maxVerticalDistanceUp = MAX_VERTICAL_DIST_UP.get();
        maxVerticalDistanceDown = MAX_VERTICAL_DIST_DOWN.get();
    }
}
