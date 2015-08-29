package beforetest;

import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thjug.cassandra.Manager;

/**
 * Created by Administrator on 8/29/2015.
 */
public class InitialKeyspace {
    private static final Logger log = LoggerFactory.getLogger(InitialKeyspace.class);
    private static final InitialKeyspace k = new InitialKeyspace();

    private boolean status = false;
    private static InitialKeyspace initialKeyspace = new InitialKeyspace();

    private InitialKeyspace(){

        final Manager m = Manager.getInstance();
        final Session s = m.createSession();
        try {
            s.execute("CREATE KEYSPACE prsley\n"+" WITH replication = {\n" +
                    "   'class' : 'SimpleStrategy', \n" +
                    "   'replication_factor' : 1\n" +
                    "   };");
            status = true;
        } catch (final RuntimeException ex ) {
            log.error(ex.getMessage());
        }
    }

    public static boolean verify(){
        return k.status;
    }
}
