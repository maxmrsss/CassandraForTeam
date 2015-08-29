package thjug.cassandra;

import beforetest.EmbeddedCassandra;
import com.datastax.driver.core.Row;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 8/29/2015.
 */
public class QueryNGTest {
    @BeforeClass
    public void before() {
        assert EmbeddedCassandra.isStart();
    }

    @Test
    public void testQuerySystem() {
    final Query q = new Query();
        final List<Row> result = q.querySystem();

        assert result.isEmpty() == false : "result should not empty";
    }
}
