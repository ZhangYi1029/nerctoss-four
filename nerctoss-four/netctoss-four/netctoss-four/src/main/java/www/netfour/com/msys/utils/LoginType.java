package www.netfour.com.msys.utils;

public enum LoginType {
    USER("User"),  ADMIN("Account");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
