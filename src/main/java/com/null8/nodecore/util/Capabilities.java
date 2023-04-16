package com.null8.nodecore.util;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

/*
 * References to  Forge's built in capabilities.
 * Modders are recommended to use their own CapabilityTokens for 3rd party caps to maintain soft dependencies.
 * However, since nobody has a soft dependency on Forge, we expose this as API.
 */
public class Capabilities
{
    public static final Capability<IItemHandler> ITEM = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    public static final Capability<IFluidHandler> FLUID = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
    public static final Capability<IFluidHandlerItem> FLUID_ITEM = CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY;
}
