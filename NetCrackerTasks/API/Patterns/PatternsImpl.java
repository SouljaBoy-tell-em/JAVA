import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsImpl implements Patterns{
    @Override
    public Pattern getSQLIdentifierPattern() {

        return Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{0,29}$");
    }

    @Override
    public Pattern getEmailPattern() {
//        return Pattern.compile("^(?=^.{0,22}$)[a-zA-Z0-9][a-zA-Z0-9|_|-]+[^._-]@[a-zA-Z0-9][a-zA-Z0-9|_|-]+[a-zA-Z0-9]\\.[a-zA-Z0-9|.]+[a-zA-Z0-9]$");
        return Pattern.compile("^((?=^.{0,22})[^._-]+[a-zA-Z0-9-_.]*[^._@-])+@[^._-]+[a-zA-Z0-9-_]+[.com|.ru|.net|.org]+$");
    }

    @Override
    public Pattern getHrefTagPattern() {
        return Pattern.compile("(?i)(<a\\s+href\\s*=\\s*[^\\s|>|/|\"]*\\s*[/]{0,1}|<a\\s+href\\s*=\\s*\"+[^>|/]*\"\\s*[/|\\\\]{0,1})" + ">\\s*$");
    }

    @Override
    public List<String> findAll(String input, Pattern pattern) {

        List<String> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
            matches.add(matcher.group());

        return matches;
    }

    @Override
    public int countMatches(String input, String regex) {

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find())
            count++;

        return count;
    }
}
