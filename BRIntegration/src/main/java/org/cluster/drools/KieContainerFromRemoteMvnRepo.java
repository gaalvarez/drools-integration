/**
 * 
 */
package org.cluster.drools;

import java.io.PrintStream;

import org.kie.api.KieServices;
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
public class KieContainerFromRemoteMvnRepo {

	public void go(PrintStream out) {
		KieServices ks = KieServices.Factory.get();

		// Install example1 in the local maven repo before to do this
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId(
				"org.drools", "named-kiesession", "6.3.0.Final"));

		KieSession kSession = kContainer.newKieSession("ksession1");
		kSession.setGlobal("out", out);

		Object msg1 = createMessage(kContainer, "Dave",
				"Hello, HAL. Do you read me, HAL?");
		kSession.insert(msg1);
		kSession.fireAllRules();
	}

	public static void main(String[] args) {
		new KieContainerFromRemoteMvnRepo().go(System.out);
	}

	private static Object createMessage(KieContainer kContainer, String name,
			String text) {
		Object o = null;
		try {
			Class cl = kContainer.getClassLoader().loadClass(
					"org.drools.example.api.namedkiesession.Message");
			o = cl.getConstructor(new Class[] { String.class, String.class })
					.newInstance(name, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

}
