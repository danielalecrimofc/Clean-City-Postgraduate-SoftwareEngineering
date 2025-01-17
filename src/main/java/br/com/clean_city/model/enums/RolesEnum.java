package br.com.clean_city.model.enums;

public enum RolesEnum {

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    RolesEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
