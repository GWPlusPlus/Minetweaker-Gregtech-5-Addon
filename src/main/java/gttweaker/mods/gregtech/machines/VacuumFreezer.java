package gttweaker.mods.gregtech.machines;

import gttweaker.mods.AddMultipleRecipeAction;
import minetweaker.MineTweakerAPI;
import minetweaker.annotations.ModOnly;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import static gregtech.api.enums.GT_Values.MOD_ID;
import static gregtech.api.enums.GT_Values.RA;

/**
 * Provides access to the Vacuum Freezer recipes.
 *
 * @author Stan Hebben
 */
@ZenClass("mods.gregtech.VacuumFreezer")
@ModOnly(MOD_ID)
public class VacuumFreezer {
    /**
     * Adds a vacuum freezer recipe.
     *
     * @param output        recipe output
     * @param input         recipe input
     * @param durationTicks freezing duration, in ticks
     * @param euPerTick     eu consumption per tick	 
     */
	 
	@ZenMethod	 
    public static void addRecipe(IItemStack output, IIngredient input, int durationTicks) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding vacuum freezer recipe for " + output, input, output, durationTicks) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addVacuumFreezerRecipe(i.nextItem(), i.nextItem(), i.nextInt());
            }
        });
    }
	@ZenMethod
	public static void addRecipe(IItemStack output, IIngredient input, int durationTicks, int euPerTick) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding vacuum freezer recipe for " + output, input, output, durationTicks, euPerTick) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addVacuumFreezerRecipe(i.nextItem(), i.nextItem(), i.nextInt(), i.nextInt());
            }
        });
    }
}