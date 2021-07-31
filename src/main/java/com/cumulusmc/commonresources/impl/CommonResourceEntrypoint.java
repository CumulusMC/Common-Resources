package com.cumulusmc.commonresources.impl;

import com.cumulusmc.commonresources.api.CommonFormProducers;
import com.cumulusmc.commonresources.api.CommonMaterials;
import com.cumulusmc.commonresources.api.ResourceEntrypoint;

// Adds back all of the vanilla things
@SuppressWarnings("unused")
public class CommonResourceEntrypoint implements ResourceEntrypoint {
    @Override
    public void initializeResources() {
        CommonMaterials.onInitialize();
        CommonFormProducers.onInitialize();


        // TODO: Remove this
        CommonMaterials.ALUMINUM.build()
                .putBool("tools", true)
                .putBool("armor", true);

    }
}
