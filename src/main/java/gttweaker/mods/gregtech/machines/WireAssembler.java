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

    /**
     * Adds a Wire Assembler
     *
     * @param aInputs   must be 1-9 ItemStacks
     * @param aFluidInput 0-1 fluids / null
     * @param aOutput  must be != null
     * @param aDuration must be > 0
     * @param aEUt      should be > 0
	 * @param aCleanroom      false/true
	 import mods.gregtech.WireAssembler;
	OutputStack, [InputStack1,InputStack2,.....InputStack9], liquid/null, Time in Ticks, energy usage
	OutputStack, [InputStack1,InputStack2,.....InputStack9], liquid/null, Time in Ticks, energy usage, CleanRoom/true/false
     */
	@ZenClass("mods.gregtech.WireAssembler")
	@ModOnly(MOD_ID)
	public class WireAssembler {
    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient[] inputs, ILiquidStack fluidInput, int durationTicks, int euPerTick) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding wire assembler recipe for " + output, inputs, fluidInput, output, durationTicks, euPerTick) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addWireAssemblerRecipe(i.nextItemArr(), i.nextFluid(), i.nextItem(), i.nextInt(), i.nextInt());
            }
        });
    }
	
	@ZenMethod
    public static void addRecipe(IItemStack output, IIngredient[] inputs, ILiquidStack fluidInput, int durationTicks, int euPerTick, boolean cleanroom) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding wire assembler recipe for " + output, inputs, fluidInput, output, durationTicks, euPerTick, cleanroom) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addWireAssemblerRecipe(i.nextItemArr(), i.nextFluid(), i.nextItem(), i.nextInt(), i.nextInt(), i.nextBool());
            }
        });
    }

}