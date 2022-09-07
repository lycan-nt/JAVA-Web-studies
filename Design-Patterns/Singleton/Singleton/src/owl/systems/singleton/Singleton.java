package owl.systems.singleton;

public final class Singleton {

    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
            this.value = value;
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static Singleton getInstance(String value) {
        System.out.println("Verify Singleton");
        if (instance == null) {
            System.out.println("Fazendo primeira instancia: " + value);
            instance = new Singleton(value);
        }
        System.out.println("Return");
        return instance;
    }

}
