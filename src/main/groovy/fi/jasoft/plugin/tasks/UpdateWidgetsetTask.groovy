/*
* Copyright 2013 John Ahlroos
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package fi.jasoft.plugin.tasks;

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import fi.jasoft.plugin.TemplateUtil

class UpdateWidgetsetTask extends DefaultTask {

	public UpdateWidgetsetTask(){
		description = "Updates the widgetset xml file"

		project.sourceSets.main.java.srcDirs.each{
			getInputs().files(project.fileTree(it.absolutePath).include('**/*/*.gwt.xml'))
			getOutputs().files(project.fileTree(it.absolutePath).include('**/*/*.gwt.xml'))
		}

		project.sourceSets.main.resources.srcDirs.each{
			getInputs().files(project.fileTree(it.absolutePath).include('**/*/*.gwt.xml'))
			getOutputs().files(project.fileTree(it.absolutePath).include('**/*/*.gwt.xml'))
		}
	}

	@TaskAction
	public void run() {
		if(project.vaadin.widgetset == null){
			return;	
		}

		TemplateUtil.ensureWidgetPresent(project)
	}
}