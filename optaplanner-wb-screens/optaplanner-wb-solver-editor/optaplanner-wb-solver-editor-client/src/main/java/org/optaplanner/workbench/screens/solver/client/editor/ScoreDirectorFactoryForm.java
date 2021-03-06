/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.optaplanner.workbench.screens.solver.client.editor;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.optaplanner.workbench.screens.solver.model.ScoreDirectorFactoryConfigModel;
import org.uberfire.backend.vfs.Path;

public class ScoreDirectorFactoryForm
        implements IsWidget {

    private ScoreDirectorFactoryFormView view;
    private ScoreDirectorFactoryConfigModel model;

    @Inject
    public ScoreDirectorFactoryForm( final ScoreDirectorFactoryFormView view ) {
        this.view = view;
        view.setPresenter( this );
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    public void setModel( final ScoreDirectorFactoryConfigModel model,
                          final Path path ) {
        this.model = model;

        view.setKSession( model.getKSessionName(),
                          path );
    }

    public void onKSessionNameChange( final String ksessionName ) {
        if ( "defaultKieSession".equals( ksessionName ) ) {
            model.setKSessionName( null );
        } else {
            model.setKSessionName( ksessionName );
        }
    }
}
