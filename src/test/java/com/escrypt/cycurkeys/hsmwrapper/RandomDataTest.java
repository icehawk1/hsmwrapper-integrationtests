package com.escrypt.cycurkeys.hsmwrapper;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.charset.Charset;

@RunWith(Arquillian.class)
public class RandomDataTest {
    private EnhancedRandom enhancedRandom;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage("com.escrypt.cycurkeys.hsmwrapper")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Before
    public void setUp() {
        enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().charset(Charset.forName("UTF-8")).seed(987654321).build();

    }

    @Test
    public void myTest() {
        MyBean input = enhancedRandom.nextObject(MyBean.class);

        System.out.println(input);
    }
}
