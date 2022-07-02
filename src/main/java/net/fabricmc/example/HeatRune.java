package net.fabricmc.example;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeatRune extends FlintAndSteelItem {
    public HeatRune(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<net.minecraft.text.Text> tooltip, TooltipContext context) {

        // formatted red text
        tooltip.add(net.minecraft.text.Text.translatable("item.tutorial.heat_rune.tooltip").formatted(Formatting.RED));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(200);
        attacker.setFireTicks(150);
        return super.postHit(stack, target, attacker);
    }
}
