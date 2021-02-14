package com.sample;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.StringWriter;
import java.util.Properties;

public class Color1 {
    protected VelocityEngine velocityEngine;

    //public static String name = "../src/main/java/com/sample/test2.vm";
    //public static String name = "./src/main/java/com/sample/test2.vm";
    //public static String name = "src/main/java/com/sample/test2.vm";
    //public static String name = "com¥¥sample¥¥test.vm";
    //public static String name = "com/sample/test2.vm";
    public static String name = "test2.vm";
    //public static String name = "/resources/test2.vm";


    String getColor(int i) {
        if (i == 1) {
            return "赤";
        } else if (i == 2) {
            return "青";
        } else {
            return "1or2を入力して下さい";
        }
    }

    /**
     * Velocityエンジンの初期化。
     */
    public void initVelocityEngine() {
        VelocityEngine engine = new VelocityEngine();
        Properties p = new Properties();

        String path = new File(".").getAbsoluteFile().getParent();
        System.out.println(path);

        //p.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
        //p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        p.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        engine.init(p);
        this.velocityEngine = engine;

    }

    public String mergeVelocityTemplate(String name, VelocityContext context) {
        StringWriter sw = new StringWriter();
        //テンプレートの作成
        Template template = this.velocityEngine.getTemplate(name, "UTF-8");
        //テンプレートとマージ
        template.merge(context, sw);
        sw.flush();
        return sw.toString();
    }
}
