import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae{

    private String text;
    private Map<String, String> hidden = new HashMap<>();
    private boolean trigger1 = false;
    @Override
    public void setText(String text) {
        this.text = text;
        if(text != null)
            trigger1  = true;
    }

    @Override
    public String getText() {
        if(!trigger1)
            throw new IllegalStateException();
        return text;
    }

    @Override
    public List<Phone> getPhones() {

        if(!trigger1)
            throw new IllegalStateException();

        List<String> numbers = new ArrayList<>();
        List<Phone> phones   = new ArrayList<>();
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
            numbers.add(matcher.group());

        for(int i = 0; i < numbers.size(); i++) {

            String number = numbers.get(i);
            int region = -1;
            int extension = -1;
            if(number.indexOf("ext.") != -1) {
                extension = Integer.parseInt(number
                        .substring(number.indexOf("ext.") + 4));

                if(number.replaceAll("[^0-9]+", "").length() > 7)
                    region = Integer.parseInt(number
                            .substring(0, number.indexOf("ext.") - 4)
                            .replaceAll("[^0-9]+", "")
                            .substring(0, 3));
            }

            if(number.replaceAll("[^0-9]+", "").length() > 7)
                region = Integer.parseInt(number
                        .replaceAll("[^0-9]+", "")
                        .substring(0, 3));
            phones.add(new Phone(number, region, extension));
        }
        return phones;
    }

    @Override
    public String getFullName() {

        if (!trigger1)
            throw new IllegalStateException();

        List FullNameList = new ArrayList();
        String regex = "^[A-Z][a-z]*[a-z.]$";
        String[] words = text.split(" ");

        for(int index = 0; index < words.length; index++) {
            Matcher matcher = Pattern.compile(regex).matcher(words[index]);
            if(matcher.find() == false)
                words[index] = "###";
        }

        int startIndex = -1, endIndex = -1;
        for(int index = 0; index < words.length; index++) {

            if(index <= words.length - 3 &&
                    !words[index].equals("###") &&
                    !words[index + 1].equals("###") &&
                    !words[index + 2].equals("###")) {
                startIndex = index;
                endIndex   = index + 2;
                break;
            }

            if(index <= words.length - 2 &&
                    !words[index].equals("###") &&
                    !words[index + 1].equals("###")) {
                startIndex = index;
                endIndex   = index + 1;
                break;
            }
        }

        if(startIndex == -1 || endIndex == -1)
            throw new NoSuchElementException();

        String res = "";
        if(endIndex - startIndex == 1) {
            res = words[startIndex] + " " + words[startIndex + 1];
            return res;
        }
        if(endIndex - startIndex == 2)
            res = words[startIndex] + " " + words[startIndex + 1] + " " + words[startIndex + 2];
        return res;
    }

    @Override
    public String getFirstName() {
        if(!trigger1)
            throw new IllegalStateException();

        String[] FullNameWords = getFullName().split(" ");
        return FullNameWords[0];
    }

    @Override
    public String getMiddleName() {
        if(!trigger1)
            throw new IllegalStateException();
        String[] FullNameWords = getFullName().split(" ");

        if(FullNameWords.length == 2)
            return null;
        return FullNameWords[1];
    }

    @Override
    public String getLastName() {
        if(!trigger1)
            throw new IllegalStateException();
        String[] FullNameWords = getFullName().split(" ");

        if(FullNameWords.length < 3)
            throw new NoSuchElementException();

        return FullNameWords[2];
    }

    @Override
    public void updateLastName(String newLastName) {

        if (!trigger1)
            throw new IllegalStateException();

        if(getFullName().split(" ").length < 3)
            throw new NoSuchElementException();

        String regex = "^[A-Z][a-z]*[a-z.]$";
        String[] words = text.split(" ");
        String[] words1 = text.split(" ");

        for(int index = 0; index < words.length; index++) {
            Matcher matcher = Pattern.compile(regex).matcher(words[index]);
            if(matcher.find() == false)
                words[index] = "###";
        }

        for(int index = 0; index < words.length; index++) {
            if(index >= 2 &&
                    words[index].equals(getLastName()) &&
                    !words[index - 1].equals("###") &&
                    !words[index - 2].equals("###")) {
                words[index] = newLastName;
                break;
            }
        }

        text = "";
        for(int i = 0; i < words.length - 1; i++) {
            if(words[i].equals("###"))
                text += words1[i] + " ";
            else
                text += words[i] + " ";
        }
        if(words[words.length - 1].equals("###"))
            text += words1[words.length - 1];
        else
            text += words[words.length - 1];
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if(!trigger1)
            throw new IllegalStateException();
        if(text.indexOf(oldPhone.getNumber()) == -1)
            throw new IllegalArgumentException();

        text = text.replaceAll(oldPhone.getNumber(), newPhone.getNumber());
    }

    @Override
    public void hide(String piece) {

        if(!trigger1)
            throw new IllegalStateException();
        if(text.indexOf(piece) == -1)
            throw new IllegalArgumentException();

        int num = text.indexOf(piece);
        StringBuilder textBuilder = new StringBuilder(text);
        String key = "", item = "";

        for(int i = 0; i < textBuilder.length(); i++) {

            if(i >= num && i < num + piece.length()) {
                item += text.charAt(i);
                if(textBuilder.charAt(i) != ' ' &&
                        textBuilder.charAt(i) != '.' &&
                        textBuilder.charAt(i) != '@')
                    textBuilder.setCharAt(i, 'X');
                key += textBuilder.charAt(i);
            }
        }

        hidden.put(key, item);
        text = textBuilder.toString();
    }

    @Override
    public void hidePhone(String phone) {

        if(!trigger1)
            throw new IllegalStateException();
        if(text.indexOf(phone) == -1)
            throw new IllegalArgumentException();

        int num = text.indexOf(phone);
        StringBuilder textBuilder = new StringBuilder(text);
        String key = "", item = "";

        for(int i = 0; i < textBuilder.length(); i++) {

            if(i >= num && i < num + phone.length()) {
                item += text.charAt(i);
                if(textBuilder.charAt(i) != ' ' &&
                        textBuilder.charAt(i) != '-' &&
                        textBuilder.charAt(i) != '(' &&
                        textBuilder.charAt(i) != ')' &&
                        textBuilder.charAt(i) != '.')
                    textBuilder.setCharAt(i, 'X');
                key += textBuilder.charAt(i);
            }
        }

        hidden.put(key, item);
        text = textBuilder.toString();
    }

    @Override
    public int unhideAll() {

        if(!trigger1)
            throw new IllegalStateException();

        Set<Map.Entry<String, String>> entry = hidden.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entry.iterator();

        int amount = 0;
        while(iterator.hasNext()) {
            Map.Entry<String, String> save = iterator.next();
//            System.out.println("KEY: " + save.getKey());
//            System.out.println("VALUE: " + save.getValue());
//            System.out.println("SYMBOL[0]: " + text.charAt(text.indexOf(save.getKey()) + save.getKey().length()));
//            System.out.println("SYMBOL: " + text.charAt(text.indexOf(save.getKey()) + save.getKey().length() + 1));
//            System.out.println("SYMBOL: " + text.charAt(text.indexOf(save.getKey()) + save.getKey().length() + 2));
            if(text.charAt(text.indexOf(save.getKey()) + save.getKey().length()) != 'X')
                text = text.replaceFirst(save.getKey(), save.getValue());
            amount++;
        }
        return amount;
    }
}
