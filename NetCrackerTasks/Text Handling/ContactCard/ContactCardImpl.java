import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactCardImpl implements ContactCard{

    private final String BEGIN_V_CARD = "BEGIN:VCARD";

    private String FullName;
    private String Organization;
    private String Gender;
    private String BDAY;
    private Calendar BDAYCalendar;
    private Map<String, String> Phones;

    public ContactCardImpl() {
        this.Phones = new HashMap<>();
    }
    @Override
    public ContactCard getInstance(Scanner scanner) {

        if(!scanner.nextLine().equals(BEGIN_V_CARD))
            throw new NoSuchElementException();

        boolean[] flags = new boolean[2];
        String field = "";
        while(true) {

            field = scanner.nextLine();
            if(!field.contains(":"))
                throw new InputMismatchException();

            if(field.startsWith("FN:")) {
                if(!root(field, "^FN:.*$"))
                    throw new InputMismatchException();
                FullName = field.substring(field.indexOf("FN:") + 3);
                flags[0] = true;
            }

            else if(field.startsWith("ORG:")) {
                if(!root(field, "^ORG:.*$"))
                    throw new InputMismatchException();
                Organization = field.substring(field.indexOf("ORG:") + 4);
                flags[1] = true;
            }

            else if(field.startsWith("GENDER:")) {
                if(!root(field, "^GENDER:[F|M]*$"))
                    throw new InputMismatchException();
                Gender = field.substring(field.indexOf("GENDER:") + 7);
            }

            else if(field.startsWith("BDAY:")) {
                if(!root(field, "^BDAY:[0-9]{2}-[0-9]{2}-[0-9]{4}$"))
                    throw new InputMismatchException();
//                BDAY = field.substring(field.indexOf("BDAY:") + 5);
//                int date = Integer.parseInt(BDAY.substring(0, 2));
//                int month = Integer.parseInt(BDAY.substring(3, 5));
//                int year = Integer.parseInt(BDAY.substring(6, 10));
//                BDAYCalendar = new GregorianCalendar();
//                BDAYCalendar.set(year, month, date);

//                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//                BDAYCalendar = new GregorianCalendar();
//
//                try {
//
//                    String date = field.substring("BDAY:".length()).trim();
//                    System.out.println();
//                    BDAYCalendar.setTime(sdf.parse(date));
//                } catch (ParseException e) {
//                    throw new InputMismatchException();
//                }

                try {
                    BDAYCalendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    simpleDateFormat.setLenient(false);
                    BDAYCalendar.setTime(simpleDateFormat.parse(field.substring(5)));
                } catch (ParseException e) {

                    throw new InputMismatchException();
                }
            }

            else if(field.startsWith("TEL;")) {
                if(!root(field, "^TEL;TYPE=.+:[0-9]{10}$"))
                    throw new InputMismatchException();

                String type = field.substring(field.indexOf("TYPE=") + 5, field.indexOf(':'));
                String voice = field.substring(field.indexOf(":") + 1);

                if(Phones.get(type) == null)
                    Phones.put(type, voice);
            }

            else if(field.equals("END:VCARD"))
                break;

            else
                throw new InputMismatchException();
        }

        for(int index = 0; index < flags.length; index++)
            if(flags[index] != true)
                throw new NoSuchElementException();

        return this;
    }

    private boolean root(String field, String regex) {

        Matcher matcher = Pattern.compile(regex).matcher(field);

        if(matcher.find() == false)
            return false;

        if(matcher.group() == null)
            return false;
        return true;
    }

    @Override
    public ContactCard getInstance(String data) {
        return getInstance(new Scanner(data));
    }

    @Override
    public String getFullName() {
        return FullName;
    }

    @Override
    public String getOrganization() {
        return Organization;
    }

    @Override
    public boolean isWoman() {

        if(Gender == null || Gender.length() == 0 || Gender.equals("M"))
            return false;
        return true;
    }

    @Override
    public Calendar getBirthday() {

        if(BDAYCalendar == null)
            throw new NoSuchElementException();
        return BDAYCalendar;
    }

    @Override
    public Period getAge() {

        if (BDAYCalendar == null)
            throw new NoSuchElementException();

        else {

            LocalDate startDate = LocalDate.of(BDAYCalendar.get(Calendar.YEAR),
                    BDAYCalendar.get(Calendar.MONTH),
                    BDAYCalendar.get(Calendar.DAY_OF_MONTH));
            LocalDate endDate = LocalDate.now();
            return Period.between(startDate, endDate);
        }
    }

    @Override
    public int getAgeYears() {
        if (BDAYCalendar == null)
            throw new NoSuchElementException();
        return getAge().getYears();
    }

    @Override
    public String getPhone(String type) {

//        if(Phones.get(type) == null)
//            throw new NoSuchElementException();
//
//        String phone = Phones.get(type);
//        return "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10);

//        if (!Phones.containsKey(type))
//            throw new NoSuchElementException();
//
//        else {
//            StringBuilder telephone = new StringBuilder(Phones.get(type));
//            StringBuilder result = new StringBuilder();
//            result.append("(").append(telephone.substring(0, 3)).append(") ");
//            result.append(telephone.substring(3, 6)).append("-");
//            result.append(telephone.substring(6, 10));
//
//            return new String(result);
//        }

        if(!Phones.containsKey(type)) {
            throw new NoSuchElementException();
        }

        StringBuilder stringBuilder = new StringBuilder(Phones.get(type));
        stringBuilder.insert(0, "(");
        stringBuilder.insert(4, ")");
        stringBuilder.insert(5, " ");
        stringBuilder.insert(9, "-");
        return stringBuilder.toString();
    }
}
