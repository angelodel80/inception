/*
 * Copyright 2020
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.workload.dynamic;

import static de.tudarmstadt.ukp.inception.workload.dynamic.workflow.DefaultWorkflowExtension.DEFAULT_WORKFLOW;

import java.io.Serializable;

/**
 * Trait for dynamic workload
 */
public class DynamicWorkloadTrait
    implements Serializable
{
    private static final long serialVersionUID = 7558423338392462923L;
    private String workflowType;
    private int defaultNumberOfAnnotations;

    public DynamicWorkloadTrait()
    {
        workflowType = DEFAULT_WORKFLOW;
        defaultNumberOfAnnotations = 6;

    }
    public DynamicWorkloadTrait(String aWorkflowType, int aDefaultNumberOfAnnotations)
    {
        workflowType = aWorkflowType;
        defaultNumberOfAnnotations = aDefaultNumberOfAnnotations;
    }

    public String getType()
    {
        return workflowType;
    }

    public int getDefaultNumberOfAnnotations()
    {
        return defaultNumberOfAnnotations;
    }

    public void setDefaultNumberOfAnnotations(int defaultNumberOfAnnotations)
    {
        this.defaultNumberOfAnnotations = defaultNumberOfAnnotations;
    }
}