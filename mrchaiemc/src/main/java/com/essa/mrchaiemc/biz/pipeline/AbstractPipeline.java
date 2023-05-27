package com.essa.mrchaiemc.biz.pipeline;

import com.essa.mrchaiemc.biz.models.BussContext;

public abstract class  AbstractPipeline {
    protected abstract String getNode(BussContext context);

    protected abstract String processTypeDecider(BussContext context);

    protected abstract void preProcess(BussContext context);

    protected abstract void doProcess(BussContext context);

    protected abstract void afterProcess(BussContext context);

}
