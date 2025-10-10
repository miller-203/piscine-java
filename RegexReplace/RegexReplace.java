import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;

public class RegexReplace {

    public static String removeUnits(String input) {
        return input.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }

    public static String obfuscateEmail(String email) {
        String[] emailParts = email.split("@");
        if (emailParts.length != 2) {
            return email;
        }
        String user = emailParts[0];
        String domain = emailParts[1];

        String obfuscatedUser;
        Pattern dashDotUnderscore = Pattern.compile(".*[-._]");
        Matcher matcher = dashDotUnderscore.matcher(user);
        if (matcher.find()) {
            int lastSpecialIdx = user.lastIndexOf(user.substring(matcher.end() - 1));
            String userPrefix = user.substring(0, lastSpecialIdx + 1);
            String userSuffix = user.substring(lastSpecialIdx + 1);
            obfuscatedUser = userPrefix + "*".repeat(userSuffix.length());
        } else if (user.length() > 3) {
            obfuscatedUser = user.substring(0, 3) + "*".repeat(user.length() - 3);
        } else {
            obfuscatedUser = user;
        }

        String obfuscatedDomain;
        String[] domainParts = domain.split("\\.");
        List<String> safeTlds = Arrays.asList("com", "org", "net");

        if (domainParts.length == 3) {
            obfuscatedDomain = "*".repeat(domainParts[0].length()) + "." + domainParts[1] + "."
                    + "*".repeat(domainParts[2].length());
        } else if (domainParts.length == 2) {
            String secondLevel = "*".repeat(domainParts[0].length());
            String topLevel = domainParts[1];
            if (!safeTlds.contains(topLevel)) {
                topLevel = "*".repeat(topLevel.length());
            }
            obfuscatedDomain = secondLevel + "." + topLevel;
        } else {
            obfuscatedDomain = "*".repeat(domain.length());
        }

        return obfuscatedUser + "@" + obfuscatedDomain;
    }
}