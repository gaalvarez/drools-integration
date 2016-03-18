/**
 * 
 */
package org.cluster.drools;

import java.io.IOException;

import org.cluster.drools.pojo.DataTablePOJO;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 
 * this class is a example of a execution of a business rule from remote maven
 * repository. This remote maven repository is configured in the main pom.xlm of
 * this project.
 * 
 * external repository: http://mvnrepository.com.
 * 
 * jar used for load kcontainer:
 * http://mvnrepository.com/artifact/org.drools/named-kiesession/6.3.0.Final.
 * 
 * example taken from:
 * https://github.com/droolsjbpm/drools/tree/6.0.x/drools-examples-api.
 * 
 * @author @gaalvarez0910 - Gustavo Álvarez
 *
 */
public class KieContainerFromKIEServer {

	public static void main(String[] args) throws IOException {
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId("org.hih", "AsmegRules", "1.2");
		KieContainer kieContainer = ks.newKieContainer(releaseId);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("out", System.out);
		kieSession.insert(new DataTablePOJO("123", "BA", 2, 1));
		kieSession.fireAllRules();
	}

}
