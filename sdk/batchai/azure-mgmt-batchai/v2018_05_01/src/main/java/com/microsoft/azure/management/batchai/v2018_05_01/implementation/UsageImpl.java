/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_05_01.implementation;

import com.microsoft.azure.management.batchai.v2018_05_01.Usage;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import rx.Observable;
import com.microsoft.azure.management.batchai.v2018_05_01.UsageName;
import com.microsoft.azure.management.batchai.v2018_05_01.UsageUnit;

class UsageImpl extends WrapperImpl<UsageInner> implements Usage {
    private final BatchAIManager manager;

    UsageImpl(UsageInner inner,  BatchAIManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public BatchAIManager manager() {
        return this.manager;
    }



    @Override
    public Integer currentValue() {
        return this.inner().currentValue();
    }

    @Override
    public Long limit() {
        return this.inner().limit();
    }

    @Override
    public UsageName name() {
        return this.inner().name();
    }

    @Override
    public UsageUnit unit() {
        return this.inner().unit();
    }

}