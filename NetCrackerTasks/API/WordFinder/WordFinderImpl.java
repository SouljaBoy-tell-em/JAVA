import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordFinderImpl implements WordFinder{

    private String text;
    public Set<String> list;
    public Stream<String> sortlistStream;
    public boolean trigger = false;
    public boolean trigger1 = false;

    @Override
    public String getText() {

        if(trigger == false)
            return null;
        return text;
    }

    @Override
    public void setText(String text) {
        if(text == null) {
            trigger = false;
            throw new IllegalArgumentException();
        }
        this.text = text;
        trigger = true;
    }

    @Override
    public void setInputStream(InputStream is) throws IOException {

        if(is == null) {
            trigger = false;
            throw new IllegalArgumentException();
        }

        try(Reader reader = new InputStreamReader(is)) {

            String save = "";
            int ch = '\0';

            while((ch = reader.read()) != -1)
                save += (char)ch;
            text = save;
            trigger = true;
        } catch (Exception exception) {
            trigger = false;
        }
    }

    @Override
    public void setFilePath(String filePath) throws IOException {
        if(filePath == null) {
            trigger = false;
            throw new IllegalArgumentException();
        }

        trigger = true;
        setInputStream(new FileInputStream(filePath));
    }

    @Override
    public void setResource(String resourceName) throws IOException {

        if(resourceName == null) {
            trigger = false;
            throw new IllegalArgumentException();
        }
        if(WordFinder.class.getResourceAsStream(resourceName) == null) {
            trigger = false;
            throw new IOException();
        }

        try(InputStream is = WordFinder.class.getResourceAsStream(resourceName)) {
            setInputStream(is);
        } catch (Exception exception) {trigger = false;}
        trigger = true;
    }

    @Override
    public Stream<String> findWordsStartWith(String begin) {

        if(trigger == false) {
            trigger1 = false;
            throw new IllegalArgumentException();
        }

        try {

            list = new HashSet<>();
            String[] words = text.split("\\s+");
            for(int i = 0; i < words.length; i++)
                list.add(words[i].toLowerCase());

            if(begin == null || begin.length() == 0) {
                sortlistStream = list.stream();
                trigger1 = true;
                return list.stream();
            }

            else {

                sortlistStream = list.stream().filter(s -> s.startsWith(begin.toLowerCase()));
                trigger1 = true;
                return list.stream().filter(s -> s.startsWith(begin.toLowerCase()));
            }
        } catch (Exception exception) {
            trigger1 = false;
        }

        trigger1 = false;
        return null;
    }

    @Override
    public void writeWords(OutputStream os) throws IOException {

        if(trigger == false || trigger1 == false)
            throw new IllegalArgumentException();
        if(os == null)
            throw new IOException();

        try (OutputStreamWriter osw = new OutputStreamWriter(os,
                StandardCharsets.UTF_8))
        {
            Stream<String> stream = sortlistStream.sorted();
            Iterator<String> iterator = stream.iterator();
            List<String> save = new ArrayList<>();
            while(iterator.hasNext())
                save.add(iterator.next());

            for(int i = 0; i < save.size(); i++) {
                if(i == save.size() - 1)
                    osw.write(save.get(i));
                else
                    osw.write(save.get(i) + " ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
