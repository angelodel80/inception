/*
 * Licensed to the Technische Universität Darmstadt under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Technische Universität Darmstadt 
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.ui.core.menu;

import static de.tudarmstadt.ukp.inception.ui.core.session.SessionMetaData.CURRENT_PROJECT;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.tudarmstadt.ukp.clarin.webanno.api.ProjectService;
import de.tudarmstadt.ukp.clarin.webanno.model.Project;
import de.tudarmstadt.ukp.clarin.webanno.security.UserDao;
import de.tudarmstadt.ukp.clarin.webanno.security.model.User;
import de.tudarmstadt.ukp.clarin.webanno.ui.core.menu.MenuItem;
import de.tudarmstadt.ukp.clarin.webanno.ui.project.ProjectPage;

@Component
public class ProjectSettingsPageMenuItem
    implements MenuItem
{
    private @Autowired UserDao userRepo;
    private @Autowired ProjectService projectService;

    @Override
    public String getPath()
    {
        return "/settings";
    }

    @Override
    public String getIcon()
    {
        return "images/setting_tools.png";
    }

    @Override
    public String getLabel()
    {
        return "Settings";
    }

    /**
     * Only project admins and annotators can see this page
     */
    @Override
    public boolean applies()
    {
        Project sessionProject = Session.get().getMetaData(CURRENT_PROJECT);
        if (sessionProject == null) {
            return false;
        }

        // The project object stored in the session is detached from the persistence context and
        // cannot be used immediately in DB interactions. Fetch a fresh copy from the DB.
        Project project = projectService.getProject(sessionProject.getId());

        // Visible if the current user is a project manager or global admin
        User user = userRepo.getCurrentUser();
        return userRepo.isAdministrator(user) || projectService.isManager(project, user);
    }

    @Override
    public Class<? extends Page> getPageClass()
    {
        return ProjectPage.class;
    }
}