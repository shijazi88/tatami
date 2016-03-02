package fr.ippon.tatami.web.rest.dto;

import fr.ippon.tatami.domain.User;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @Pattern(regexp = "^[a-z0-9]*$")
    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    @Size(max = 50)
    private String username;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Size(max = 50)
    private String jobTitle;

    @Size(max = 50)
    private String phoneNumber;

    private boolean activated = false;

    @Size(min = 2, max = 5)
    private String langKey;

    private Set<String> authorities;

    private boolean mentionEmail;

    private String rssUid;

    private boolean weeklyDigest;

    private boolean dailyDigest;

    private String domain;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this(user.getLogin(), null, user.getUsername(), user.getFirstName(), user.getLastName(),
            user.getEmail(), user.getActivated(), user.getLangKey(),
            user.getAuthorities(), user.getJobTitle(), user.getPhoneNumber(), user.getMentionEmail(),
            user.getRssUid(), user.getWeeklyDigest(),
            user.getDailyDigest(), user.getDomain());
    }

    public UserDTO(String login, String password, String username, String firstName, String lastName,
        String email, boolean activated, String langKey, Set<String> authorities,
                   String jobTitle, String phoneNumber,
                   boolean mentionEmail, String rssUid, boolean weeklyDigest,
        boolean dailyDigest, String domain) {

        this.login = login;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.authorities = authorities;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.mentionEmail = mentionEmail;
        this.rssUid = rssUid;
        this.weeklyDigest = weeklyDigest;
        this.dailyDigest = dailyDigest;
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public boolean isMentionEmail() { return mentionEmail; }

    public String getRssUid() { return rssUid; }

    public boolean isWeeklyDigest() { return weeklyDigest; }

    public boolean isDailyDigest() { return dailyDigest; }

    public String getDomain() { return domain; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO user = (UserDTO) o;

        return !(username != null ? !username.equals(user.username) : user.username != null);

    }

    public String toString() {
        return "UserDTO{" +
            "login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", activated=" + activated +
            ", langKey='" + langKey + '\'' +
            ", authorities=" + authorities + '\'' +
            ", jobTitle='" + jobTitle + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", mentionEmail=" + mentionEmail + '\'' +
            ", rssUid=" + rssUid + '\'' +
            ", weeklyDigest=" + weeklyDigest + '\'' +
            ", dailyDigest=" + dailyDigest + '\'' +
            ", domain=" + domain +
            "}";
    }
}
