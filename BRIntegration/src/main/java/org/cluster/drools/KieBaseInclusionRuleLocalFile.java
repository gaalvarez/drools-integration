/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cluster.drools;

import java.io.PrintStream;

import org.cluster.drools.pojo.DataTablePOJO;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * this demo show a basi execution of a business rule from local drl file. the
 * file is located on src/main/resources/kiebaseinclusion
 * 
 * @author @gaalvarez0910 - Gustavo Álvarez
 *
 */
public class KieBaseInclusionRuleLocalFile {

	public void go(PrintStream out) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession2");
		kSession.setGlobal("out", out);

		kSession.insert(new DataTablePOJO("1061729961", "BA", 1, 22));
		kSession.fireAllRules();

	}

	public static void main(String[] args) {
		new KieBaseInclusionRuleLocalFile().go(System.out);
	}

}
