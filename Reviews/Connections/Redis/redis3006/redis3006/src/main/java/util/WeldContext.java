package util;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class WeldContext {
    private static final WeldContext instance = new WeldContext();

    private final Weld weld = new Weld();
    private final WeldContainer container = this.weld.initialize();

    private WeldContext() {
        // Utilizado para quando a JVM eh encerrada, encerrar o weld
        Runtime.getRuntime().addShutdownHook(
                new Thread() {

                    @Override
                    public void run() {
                        try {
                            WeldContext.this.weld.shutdown();
                        } catch (IllegalStateException e) {
                            // ignore
                        }
                    }
                });
    }

    public static WeldContext getInstance() {
        return instance;
    }

    @SuppressWarnings("static-access")
    public static <T> T getInstanciatedClass(Class<T> type) {
        return instance.container.current().select(type).get();
    }
}
