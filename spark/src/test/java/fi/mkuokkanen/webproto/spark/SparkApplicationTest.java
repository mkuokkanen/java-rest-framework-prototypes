package fi.mkuokkanen.webproto.spark;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

import static org.junit.Assert.assertTrue;


public class SparkApplicationTest {

    @BeforeClass
    public static void beforeClass() {
        SparkApplication.main(null);
    }

    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testSomething() {
        assertTrue(true);
    }
}
