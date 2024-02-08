import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter {

    private String text;
    private String save;
    public Map<String, Long> cases;
    private List<Map.Entry<String, Long>> EntryCases;
    boolean flag = false;

    public WordCounterImpl() {
        this.text = null;
        this.cases = new HashMap<>();
        this.EntryCases = new ArrayList<>();
    }
    @Override
    public void setText(String text) {
        if(text != null)
            this.text = text.toLowerCase(Locale.ROOT);
        else
            this.text = null;
        updateText();
        Initialize();
    }

    public void updateText() {

        if(text == null)
            return;

        save = "";
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '<') {

                while(text.charAt(i) != '>') {

                    if(i == text.length() - 1)
                        break;
                    i++;
                }
                i++;
            }

            if(i != text.length())
                save += text.charAt(i);
        }

        text = save;
    }

    private void Initialize() {

        if(text == null)
            return;

        if(!flag) {

            cases.clear();
            flag = true;
            String[] words = text.split("\\s+");
            for(int index = 0; index < words.length; index++) {

                if(StatusWord(words[index])) {
                    if(cases.get(words[index]) == null)
                        cases.put(words[index], 1L);
                    else
                        cases.put(words[index], cases.get(words[index]) + 1);
                }
            }
        }

    }

    @Override
    public String getText() {

        if(text.length() > 0)
            return text;
        return null;
    }

    @Override
    public Map<String, Long> getWordCounts() {

        if(text == null)
            throw new IllegalStateException();

        return cases;
    }

    private boolean StatusWord(String word) {
        if(word != null && word.length() > 0 &&
           word.charAt(0) != '<' && word.charAt(word.length() - 1) != '>')
            return true;
        return false;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {

        if(text == null)
            throw new IllegalStateException();

        return sort(cases, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {

                if(o1.getValue().intValue() == o2.getValue().intValue())
                    return o1.getKey().compareTo(o2.getKey());
                return -1 * o1.getValue().compareTo(o2.getValue());
            }
        });
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {

        List<Map.Entry<K, V>> list = new ArrayList<>();
        Set<Map.Entry<K, V>>  set  = map.entrySet();
        Iterator<Map.Entry<K, V>> iterator = set.iterator();

        while(iterator.hasNext())
            list.add(iterator.next());

        Collections.sort(list, comparator);
        return list;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {

        for(int i = 0; i < entries.size(); i++)
            ps.println(entries.get(i).getKey() + " " + entries.get(i).getValue());
    }
}
