package com.escrypt.cycurkeys.hsmwrapper;

import com.acme.ejb.Heyda;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;

@Test
public class GreeterTest extends Arquillian {

    @Inject
    Greeter greeter;
    @Inject
    Heyda hey;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive result = ShrinkWrap.create(JavaArchive.class)
                .addPackage("com.escrypt.cycurkeys.hsmwrapper").addClass(Heyda.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return result;
    }

    @Test
    public void should_create_greeting() {
        Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }

    @Test
    public void canInject() {
        Assert.assertNotNull(hey);
        Assert.assertEquals("ABCDEF", hey.bla("abcdef"));
    }
}
