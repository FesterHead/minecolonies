package com.minecolonies.core.colony.buildings.workerbuildings;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.buildings.workerbuildings.IBuildingDeliveryman;
import com.minecolonies.api.colony.requestsystem.request.IRequest;
import com.minecolonies.api.colony.requestsystem.requestable.IRequestable;
import com.minecolonies.api.colony.requestsystem.requestable.deliveryman.Delivery;
import com.minecolonies.core.MineColonies;
import com.minecolonies.core.colony.buildings.AbstractBuilding;
import com.minecolonies.core.colony.buildings.modules.WorkerBuildingModule;
import com.minecolonies.core.colony.jobs.JobDeliveryman;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.minecolonies.api.util.constant.BuildingConstants.CONST_DEFAULT_MAX_BUILDING_LEVEL;

/**
 * Class of the warehouse building.
 */
public class BuildingDeliveryman extends AbstractBuilding implements IBuildingDeliveryman
{

    private static final String DELIVERYMAN = "deliveryman";

    /**
     * Instantiates a new warehouse building.
     *
     * @param c the colony.
     * @param l the location
     */
    public BuildingDeliveryman(final IColony c, final BlockPos l)
    {
        super(c, l);
    }

    @NotNull
    @Override
    public String getSchematicName()
    {
        return DELIVERYMAN;
    }

    @Override
    public int getMaxBuildingLevel()
    {
        return CONST_DEFAULT_MAX_BUILDING_LEVEL;
    }

    @Override
    public int getMaxWorkers()
    {
        if (getBuildingLevel() <= 0)
        {
            return 0;
        }
        return getBuildingLevel() * MineColonies.getConfig().getServer().couriersPerHutLevel.get();
    }

    @Override
    public boolean canEat(final ItemStack stack)
    {
        final WorkerBuildingModule module = getFirstModuleOccurance(WorkerBuildingModule.class);
        if (module != null)
        {
            for (final ICitizenData citizenData : module.getAssignedCitizen())
            {
                if (citizenData.getJob() instanceof JobDeliveryman)
                {
                    final JobDeliveryman job = (JobDeliveryman) citizenData.getJob();
                    final IRequest<? extends IRequestable> currentTask = job.getCurrentTask();
                    if (currentTask != null)
                    {
                        final IRequestable request = currentTask.getRequest();
                        if (request instanceof Delivery && ((Delivery) request).getStack().sameItem(stack))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return super.canEat(stack);
    }
}
