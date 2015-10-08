package org.arquillian.extension.volkswagen;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ExtremeFailingTestCase {

    @Deployment
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void shouldBeFalse() {
        Assert.assertFalse(true);
    }

    @Test
    public void shouldNotFail() {
        Assert.fail("No way!");
    }

    @Test @RunAsClient
    public void shouldBeFalseClient() {
        Assert.assertFalse(true);
    }

    @Test @RunAsClient
    public void shouldNotFailClient() {
        Assert.fail("No way!");
    }
}
