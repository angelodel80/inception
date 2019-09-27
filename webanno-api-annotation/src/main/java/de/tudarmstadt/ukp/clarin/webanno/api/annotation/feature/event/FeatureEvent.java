/*
 * Copyright 2019
 * Ubiquitous Knowledge Processing (UKP) Lab and FG Language Technology
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
package de.tudarmstadt.ukp.clarin.webanno.api.annotation.feature.event;

import org.apache.wicket.ajax.AjaxRequestTarget;

import de.tudarmstadt.ukp.clarin.webanno.api.annotation.model.FeatureState;

public abstract class FeatureEvent
{
    private final FeatureState fs;
    
    private final AjaxRequestTarget target;
    
    public FeatureEvent(FeatureState aFs, AjaxRequestTarget aTarget)
    {
        fs = aFs;
        target = aTarget;
    }
    
    public FeatureState getFeatureState()
    {
        return fs;
    }
    
    public AjaxRequestTarget getTarget()
    {
        return target;
    }
}
