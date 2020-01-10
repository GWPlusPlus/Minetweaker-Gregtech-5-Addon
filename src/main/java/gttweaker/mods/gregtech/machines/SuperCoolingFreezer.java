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
import minetweaker.api.liquid.ILiquidStack;

/**
 * Provides access to the Vacuum Freezer recipes.
 *
 * @author Stan Hebben
 */
@ZenClass("mods.gregtech.SuperCoolingFreezer")
@ModOnly(MOD_ID)
public class SuperCoolingFreezer {
	/** Spartak Super Cooling Freezer
     * Adds a Super Cooling Freezer Recipe
     *
     * @param aInput1   must be != null
     * @param aOutput1  must be != null
     * @param aFluidInput  must be != null
     * @param aDuration must be > 0
     */
    //public boolean addSuperCoolingFreezerRecipe(ItemStack aInput1, ItemStack aOutput1, FluidStack aFluidInput, FluidStack aFluidOutput, int aDuration, int aEUt);

	 
	@ZenMethod
	public static void addRecipe(IItemStack output, IIngredient input, ILiquidStack fluidOutput, ILiquidStack fluidInput, int durationTicks, int euPerTick) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding super cooling freezer recipe for " + output, input, output, fluidInput, fluidOutput, durationTicks, euPerTick) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addSuperCoolingFreezerRecipe(i.nextItem(), i.nextItem(), i.nextFluid(), i.nextFluid(), i.nextInt(), i.nextInt());
            }
        });
    }
}