package Business.DB4OUtil;

import Business.ConfigureABusiness;
import Business.NetworkHelp;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

import java.util.ConcurrentModificationException;

/**
 * DB4O Utility class for handling database operations.
 */
public class DB4OUtil {
    private static final String FILENAME = System.getProperty("user.dir") + "/DataBank.db4o";
    private static DB4OUtil dB4OUtil;

    public static synchronized DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected static synchronized void shutdown(ObjectContainer connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            config.common().activationDepth(Integer.MAX_VALUE);
            config.common().updateDepth(Integer.MAX_VALUE);
            config.common().objectClass(NetworkHelp.class).cascadeOnUpdate(true);

            System.out.println(config);

            return Db4oEmbedded.openFile(config, FILENAME);
        } catch (Exception ex) {
            System.out.println("message: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Store the given Environment system in the database.
     *
     * @param system The Environment system to store.
     */
    public synchronized void storeSystem(NetworkHelp system) {
        try {
            ObjectContainer connection = createConnection();
            if (connection != null) {
                connection.store(system);
                connection.commit();
                connection.close();
            }
        } catch (ConcurrentModificationException cme) {
            // Handle ConcurrentModificationException if needed
        }
    }

    /**
     * Retrieve the Environment system from the database.
     *
     * @return The retrieved Environment system.
     */
    public NetworkHelp  retrieveSystem() {
        ObjectContainer connection = null;
        try {
            connection = createConnection();

            if (connection != null) {
                ObjectSet<NetworkHelp > systems = connection.query(NetworkHelp .class);
                 //return ConfigureABusiness.configuration();
                if (systems != null && systems.size() > 0) {
                    return systems.get(systems.size() - 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown(connection);
        }

        // If no valid environment is found, return the default configuration
        return ConfigureABusiness.configuration();
    }
}