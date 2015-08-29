package thjug.cassandra;

import com.datastax.driver.core.*;

import java.util.List;

/**
 * Created by Administrator on 8/29/2015.
 */
public class Query {

    private static final String LOCAL = "SELECT * FROM local;";

    public List<Row> querySystem(){
        final Statement stmt = new SimpleStatement(LOCAL);
        stmt.setConsistencyLevel(ConsistencyLevel.ONE);

        final Session s = Manager.getInstance().createSession("system");
        final ResultSet r = s.execute(stmt);

        return r.all();
    }
}
