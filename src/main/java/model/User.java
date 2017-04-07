package model;

public class User {

    private String username;
    private String password;
    private String email;
    private RoleEnum role = RoleEnum.USER;
    private boolean isPremiumUser = false;

    public boolean isPremiumUser() {
        if (role.equals(RoleEnum.ADMIN) || role.equals(RoleEnum.PREMIUM)) {
            return true;
        }
        return false;
    }

    public void setPremiumUser(boolean premiumUser) {
        isPremiumUser = premiumUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
