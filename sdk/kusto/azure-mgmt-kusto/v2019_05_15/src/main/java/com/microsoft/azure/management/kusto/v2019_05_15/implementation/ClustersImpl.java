/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.kusto.v2019_05_15.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.kusto.v2019_05_15.Clusters;
import com.microsoft.azure.management.kusto.v2019_05_15.Cluster;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import java.util.List;
import com.microsoft.azure.management.kusto.v2019_05_15.CheckNameResult;
import com.microsoft.azure.management.kusto.v2019_05_15.AzureResourceSku;
import com.microsoft.azure.management.kusto.v2019_05_15.SkuDescription;

class ClustersImpl extends GroupableResourcesCoreImpl<Cluster, ClusterImpl, ClusterInner, ClustersInner, KustoManager>  implements Clusters {
    protected ClustersImpl(KustoManager manager) {
        super(manager.inner().clusters(), manager);
    }

    @Override
    protected Observable<ClusterInner> getInnerAsync(String resourceGroupName, String name) {
        ClustersInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        ClustersInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<Cluster> listByResourceGroup(String resourceGroupName) {
        ClustersInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<Cluster> listByResourceGroupAsync(String resourceGroupName) {
        ClustersInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMap(new Func1<Page<ClusterInner>, Observable<ClusterInner>>() {
            @Override
            public Observable<ClusterInner> call(Page<ClusterInner> innerPage) {
                return Observable.from(innerPage.items());
            }
        })
        .map(new Func1<ClusterInner, Cluster>() {
            @Override
            public Cluster call(ClusterInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<Cluster> list() {
        ClustersInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<Cluster> listAsync() {
        ClustersInner client = this.inner();
        return client.listAsync()
            .flatMap(new Func1<Page<ClusterInner>, Observable<ClusterInner>>() {
                @Override
                public Observable<ClusterInner> call(Page<ClusterInner> innerList) {
                    return Observable.from(innerList.items());
                }
            })
            .map(new Func1<ClusterInner, Cluster>() {
                @Override
                public Cluster call(ClusterInner inner) {
                    return wrapModel(inner);
                }
            });
    }

    @Override
    public ClusterImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Completable stopAsync(String resourceGroupName, String clusterName) {
        ClustersInner client = this.inner();
        return client.stopAsync(resourceGroupName, clusterName).toCompletable();
    }

    @Override
    public Completable startAsync(String resourceGroupName, String clusterName) {
        ClustersInner client = this.inner();
        return client.startAsync(resourceGroupName, clusterName).toCompletable();
    }

    @Override
    protected ClusterImpl wrapModel(ClusterInner inner) {
        return  new ClusterImpl(inner.name(), inner, manager());
    }

    @Override
    protected ClusterImpl wrapModel(String name) {
        return new ClusterImpl(name, new ClusterInner(), this.manager());
    }

    private AzureResourceSkuImpl wrapAzureResourceSkuModel(AzureResourceSkuInner inner) {
        return  new AzureResourceSkuImpl(inner, manager());
    }

    @Override
    public Observable<CheckNameResult> checkNameAvailabilityAsync(String location, String name) {
        ClustersInner client = this.inner();
        return client.checkNameAvailabilityAsync(location, name)
        .map(new Func1<CheckNameResultInner, CheckNameResult>() {
            @Override
            public CheckNameResult call(CheckNameResultInner inner) {
                return new CheckNameResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<AzureResourceSku> listSkusByResourceAsync(String resourceGroupName, String clusterName) {
        ClustersInner client = this.inner();
        return client.listSkusByResourceAsync(resourceGroupName, clusterName)
        .flatMap(new Func1<List<AzureResourceSkuInner>, Observable<AzureResourceSkuInner>>() {
            @Override
            public Observable<AzureResourceSkuInner> call(List<AzureResourceSkuInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<AzureResourceSkuInner, AzureResourceSku>() {
            @Override
            public AzureResourceSku call(AzureResourceSkuInner inner) {
                return wrapAzureResourceSkuModel(inner);
            }
        });
    }

    @Override
    public Observable<SkuDescription> listSkusAsync() {
        ClustersInner client = this.inner();
        return client.listSkusAsync()
        .flatMap(new Func1<List<SkuDescriptionInner>, Observable<SkuDescriptionInner>>() {
            @Override
            public Observable<SkuDescriptionInner> call(List<SkuDescriptionInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<SkuDescriptionInner, SkuDescription>() {
            @Override
            public SkuDescription call(SkuDescriptionInner inner) {
                return new SkuDescriptionImpl(inner, manager());
            }
        });
    }

}