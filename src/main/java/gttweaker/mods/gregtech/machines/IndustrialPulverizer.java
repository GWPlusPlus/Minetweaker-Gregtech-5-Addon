package gttweaker.mods.gregtech.machines;

import gttweaker.mods.AddMultipleRecipeAction;
import minetweaker.MineTweakerAPI;
import minetweaker.annotations.ModOnly;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import static gregtech.api.enums.GT_Values.MOD_ID;
import static gregtech.api.enums.GT_Values.RA;
import static gttweaker.util.ArrayHelper.itemOrNull;

/**
 * Provides access to the Industrial Pulverizer recipes.
 *
 * @author DreamMasterXXL
 */
@ZenClass("mods.gregtech.IndustrialPulverizer")
@ModOnly(MOD_ID)
public class IndustrialPulverizer {
    /**
     * Adds a IndustrialPulverizer recipe.
     *
     * @param outputs       array with 1-6 outputs
     * @param fluidOutput   primary fluid output
     * @param input         primary input
     * @param fluidInput    primary fluid input
     * @param outChances       chance 1-6
     * @param durationTicks reaction time, in ticks
     * @param euPerTick     eu consumption per tick
		IndustrialPulverizer
		OutputArray, InputStack, InputFluid, OutputFluid, OutputArrayChances, Time in Ticks, EnergyUsage
     */
	@ZenMethod
    public static void addRecipe(IItemStack[] outputs, IIngredient input, ILiquidStack fluidInput, ILiquidStack fluidOutput, int[] outChances, int durationTicks, int euPerTick) {
        if (outputs.length < 1) {
            MineTweakerAPI.logError("Industrial Pulverizer must have at least 1 output");
        } else if (outputs.length != outChances.length) {
            MineTweakerAPI.logError("Number of Outputs does not equal number of Chances");
        } else {
            MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding Industrial Pulverizer recipe for " + input, input, fluidInput, fluidOutput, outputs, outChances, durationTicks, euPerTick) {
                @Override
                protected void applySingleRecipe(ArgIterator i) {
                    RA.addIndustrialPulverizerRecipe(i.nextItem(), i.nextFluid(), i.nextFluid(), i.nextItemArr(), i.nextIntArr(), i.nextInt(), i.nextInt());
                }
            });
        }
    }
	
	
}