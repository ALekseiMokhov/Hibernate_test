package buiseness_logic;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();

        }
        catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
    public static void shutdown(){
        SESSION_FACTORY.close();
    }
}
