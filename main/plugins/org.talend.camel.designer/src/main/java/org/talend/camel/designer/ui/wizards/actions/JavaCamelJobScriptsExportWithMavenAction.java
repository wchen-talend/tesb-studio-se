// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.camel.designer.ui.wizards.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.camel.designer.ui.wizards.export.KarafJavaScriptForESBWithMavenManager;
import org.talend.commons.utils.io.FilesUtils;
import org.talend.core.repository.constants.FileConstants;
import org.talend.designer.runprocess.IProcessor;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.ui.wizards.exportjob.action.JobExportAction;
import org.talend.repository.ui.wizards.exportjob.scriptsmanager.JobScriptsManager;
import org.talend.repository.ui.wizards.exportjob.scriptsmanager.JobScriptsManager.ExportChoice;

/**
 * DOC ycbai class global comment. Detailled comment
 */
public class JavaCamelJobScriptsExportWithMavenAction extends JavaCamelJobScriptsExportWSAction {

    private JobScriptsManager scriptsManager;

    private String destinationPath;

    public JavaCamelJobScriptsExportWithMavenAction(Map<ExportChoice, Object> exportChoiceMap, RepositoryNode routeNode,
            String version, String destinationPath, boolean addStatisticsCode) {
        super(routeNode, version, destinationPath, addStatisticsCode);
        this.destinationPath = destinationPath;
        if (!destinationKar.endsWith(FileConstants.KAR_FILE_SUFFIX)) {
            destinationKar = getTempDir() + File.separatorChar + getNodeBundleName(routeNode, version)
                    + FileConstants.KAR_FILE_SUFFIX;
        }
        scriptsManager = new KarafJavaScriptForESBWithMavenManager(exportChoiceMap, destinationKar, null, null,
                IProcessor.NO_STATISTICS, IProcessor.NO_TRACES);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.camel.designer.ui.wizards.actions.JavaCamelJobScriptsExportWSAction#run(org.eclipse.core.runtime.
     * IProgressMonitor)
     */
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        this.monitor = monitor;
        try {
            exportKarOsgiBundles();
            processResults();
            exportMavenResources();
        } finally {
            // remove generated files
            FilesUtils.removeFolder(getTempDir(), true);
        }
    }

    private void exportMavenResources() throws InvocationTargetException, InterruptedException {
        scriptsManager.setMultiNodes(false);
        scriptsManager.setDestinationPath(destinationPath);
        JobExportAction action = new JobExportAction(Collections.singletonList(routeNode), version, bundleVersion,
                scriptsManager, getTempDir(), "Route"); //$NON-NLS-1$
        action.run(monitor);
    }

}