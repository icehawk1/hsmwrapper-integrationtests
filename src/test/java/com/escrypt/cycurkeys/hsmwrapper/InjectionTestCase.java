package com.escrypt.cycurkeys.hsmwrapper;


import com.acme.ejb.GreetingManager;
import com.acme.ejb.GreetingManagerBean;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ejb.EJB;

/**
 * GreetingManagerTest
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 */
@Test(groups = "integration")
public class InjectionTestCase extends Arquillian {
    @EJB
    private GreetingManager greetingManager;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive result = ShrinkWrap.create(JavaArchive.class)
                .addClasses(GreetingManager.class, GreetingManagerBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return result;
    }

    @Test
    public void shouldBeAbleToInjectEJB() throws Exception {

        String userName = "Devoxx";

        Assert.assertEquals(
                greetingManager.greet(userName),
                "Hello " + userName);
    }
}
