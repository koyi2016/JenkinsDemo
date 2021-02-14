package com.sample;

import static org.junit.Assert.*;

import org.apache.velocity.VelocityContext;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class Color1Test {

    @Test
    public void testGetColor1() {
        Color1 c1 = new Color1();
        String t1 = c1.getColor(1);
        assertThat(t1,is("赤"));
    }
    @Test
    public void testGetColor2() {
        Color1 c1 = new Color1();
        String t1 = c1.getColor(2);
        assertThat(t1,is("青"));
    }
    @Test
    public void testGetColor3() {
        Color1 c1 = new Color1();
        String t1 = c1.getColor(3);
        assertThat(t1,is("1or2を入力して下さい"));
    }

    @Test
    public void testMergeVelocityTemplate() {
        Color1 c1 = new Color1();
        c1.initVelocityEngine();
        VelocityContext context = new VelocityContext();
        String t1 = c1.mergeVelocityTemplate(c1.name, context);
        assertThat(t1,is("import java.io.StringWriter;"));
    }

}
