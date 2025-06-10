package abs;

public abstract class Phone {
    private String name;
    private boolean isPower;

    public Phone( String name) {
        this.name = name;
    }

    public void setIsPower(boolean isPower) {
        if (isPower) {
            System.out.println("Phone is power");
        } else {
            System.out.println("Phone is not power");
        }
    }

    abstract void call();
}
