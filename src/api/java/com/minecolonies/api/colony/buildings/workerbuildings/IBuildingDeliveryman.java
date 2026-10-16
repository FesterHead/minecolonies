package com.minecolonies.api.colony.buildings.workerbuildings;

import com.minecolonies.api.colony.buildings.IBuilding;

/**
 * Marker interface for deliveryman buildings
 */
public interface IBuildingDeliveryman extends IBuilding
{
    /**
     * Get the max workers for this deliveryman hut.
     *
     * @return the max workers count.
     */
    int getMaxWorkers();
}
