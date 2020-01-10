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
 * Provides access to the PyrolyseOven recipes.
 *
 * @author DreamMasterXXL
 */
@ZenClass("mods.gregtech.PyrolyseOven")
@ModOnly(MOD_ID)
public class PyrolyseOven {
    /**
     * Adds a Pyrolyse Oven recipe.
     *
     * @param output        recipe output
     * @param fluidOutput   recipe Fluid output
     * @param circuit       circuit preset nr.
     * @param input         recipe input
     * @param fluidInput    recipe Fluid input
     * @param durationTicks reaction time, in ticks
     * @param euPerTick     eu consumption per tick
     */
	 /**
		mods.gregtech.PyrolyseOven.addRecipe(< minecraft:coal:1 >*20, < liquid:creosote >*2000 , 0, < minecraft:log:1 > * 16, null, 200, 64);
		0- circuit number
		null - input fluid
	 */
    @ZenMethod
    public static void addRecipe(IItemStack output, ILiquidStack fluidOutput, int circuit, IIngredient input, ILiquidStack fluidInput, int durationTicks, int euPerTick) {
        MineTweakerAPI.apply(new AddMultipleRecipeAction("Adding Pyrolyse Oven recipe for " + output, input, fluidInput, circuit, output, fluidOutput, durationTicks, euPerTick) {
            @Override
            protected void applySingleRecipe(ArgIterator i) {
                RA.addPyrolyseRecipe(i.nextItem(), i.nextFluid(), i.nextInt(), i.nextItem(), i.nextFluid(), i.nextInt(), i.nextInt());
            }
        });
    }
}

