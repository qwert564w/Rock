package rockstar.profile;

public final class Profile {
    public static String username = "";
    public static int uid = 0;
    public static Role role = Role.DEFAULT;
    public static String subscriptionEndDate = "";
    public static String avatarUrl = "";

    private Profile() {
    }

    public static String getUsername() {
        return username;
    }

    public static int getUid() {
        return uid;
    }

    public static Role getRole() {
        return role;
    }

    public static String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public static String getAvatarUrl() {
        return avatarUrl;
    }
}
