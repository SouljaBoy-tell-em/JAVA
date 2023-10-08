import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberImpl implements ComplexNumber {

    private double re;
    private double im;

    public ComplexNumberImpl() {}

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }
    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {

        if(im == 0)
            return true;
        return false;
    }

    @Override
    public void set(double re, double im) {

        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {

        boolean flagSign = false;
        int point = 0;

        if(value.equals("i")) {
            re = 0;
            im = 1;
            return;
        }

        if(value.equals("-i")) {
            re = 0;
            im = -1;
            return;
        }

        if(value.charAt(0) == '-') {
            value = value.substring(1);
            flagSign = true;
        }

        Pattern regex = Pattern.compile("[0-9]{1,13}(\\.[0-9]*)?");
        Matcher matcher = regex.matcher(value);

        if (matcher.find()) {

            point = matcher.group(0).length();
            re = Double.parseDouble(matcher.group(0));

            if(flagSign == true) {
                flagSign = false;
                re = re * (-1);
            }
        }

        try {

            if (value.charAt(point) == 'i') {
                im = re;
                re = 0;
            }

            if (value.charAt(point) == '-')
                flagSign = true;

            if(value.charAt(point + 1) == 'i') {

                im = 1;
                if(flagSign)
                    im = -1;

                return;
            }

            if (matcher.find(point)) {


                im = Double.parseDouble(matcher.group(0));
                if (flagSign == true)
                    im = im * (-1);
            }


        } catch (Exception exception) {
            // System.out.println(exception.getMessage());
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(re, im);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        if (im == 0)
            return result.append(re).toString();
        else if (re == 0)
            return result.append(im).append("i").toString();
        else {

            result = result.append(re);
            if (im > 0) {
                result = result.append("+");
            }
            return result.append(im).append("i").toString();
        }
    }

    @Override
    public boolean equals(Object other) {

        if (other instanceof ComplexNumber)
            return (compareTo((ComplexNumber) other) == 0) ? true : false;
        return false;
    }

    @Override
    public int compareTo(ComplexNumber other) {

        if(re == other.getRe() && im == other.getIm())
            return 0;
        else if (Math.sqrt(re * re + im * im) <
                    Math.sqrt(other.getRe() * other.getRe() + other.getIm() * other.getIm()))
            return -1;
        return 1;
    }

    @Override
    public void sort(ComplexNumber[] array) {

//        for (int j = 0; j < array.length; j++) {
//
//            int minInd = j;
//            for (int i = j; i < array.length; i++)
//                if (array[i].compareTo(array[j]) < 0)
//                    minInd = i;
//
//            ComplexNumber save = array[j];
//            array[j] = array[minInd];
//            array[minInd] = save;
//        }

        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {

        re = -re;
        im = -im;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {

        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {

        double SaveRe = re;
        re = re * arg2.getRe() - im * arg2.getIm();
        im = im * arg2.getRe() + SaveRe * arg2.getIm();
        return this;
    }
}
