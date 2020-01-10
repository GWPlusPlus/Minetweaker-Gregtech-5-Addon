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
@ZenClass("mods.gregtech.FlotationUnit")
@ModOnly(MOD_ID)
public class FlotationUnit {
    /**
     * Adds a Flotation Unit recipe.
     *
     * @param outputs       array with 1-6 outputs
     * @param fluidOutput   primary fluid output
     * @param input1        primary input
     * @param input2        Cell input
     * @param fluidInput    primary fluid input
     * @param chances       chance 1-6
     * @param durationTicks reaction time, in ticks
     * @param euPerTick     eu consumption per tick	 
		FlotationUnit
		OutputArray, InputFluid, InputStack, OutputFluid, OutputArrayChances, Time in Ticks, EnergyUsage	 
     */
    @ZenMethod
    public static void addRecipe(IItemStack[] outputs, ILiquidStack fluidOutput, IIngredient input, ILiquidStack fluidInput, int[] chances, int durationTicks, int euPerTick) {
        if (outputs.length < 1) {
            MineTweakerAPI.logError("Flotation Unit must have at least 1 output");
        } else if (outputs.length != chances.length) {
            MineTweakerAPI.logError("Number of Outputs does not equal number of Chances");
        } else {
            MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding Flotation Unit recipe with Fluids for " + input, input, fluidOutput, fluidInput, outputs[0],
                    itemOrNull(outputs, 1), itemOrNull(outputs, 2), itemOrNull(outputs, 3), itemOrNull(outputs, 4), itemOrNull(outputs, 5), chances, durationTicks, euPerTick) {
                @Override
                protected void applySingleRecipe(ArgIterator i) {
                    RA.addFlotationUnitRecipe(i.nextItem(), i.nextFluid(), i.nextFluid(), i.nextItem(), i.nextItem(),
                            i.nextItem(), i.nextItem(), i.nextItem(), i.nextItem(), i.nextIntArr(), i.nextInt(), i.nextInt());
                }
            });
        }
    }
	
	
}