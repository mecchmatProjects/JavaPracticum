package text_pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Text {
    private Sentence[] text;

    Text(String str){
        String[] str_arr = str.split("[ ]+");
        text = new Sentence[str_arr.length];
        for (int i=0;i<str_arr.length;i++){
            text[i] = new Sentence(str_arr[i]);
        }
    }

    Text(String[] str){
        text = new Sentence[str.length];
        for (int i=0;i<str.length;i++){
            text[i] = new Sentence(str[i]);
        }
    }

    public boolean equals(Text ob) {
        if (this.text.length != ob.text.length)
            return false;
        for (int i=0;i<this.text.length;i++){
            if (!this.text[i].equals(ob.text[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int p = 31;
        int m = 1000000009;
        int hash = 0;
        long p_pow = 1;
        for (Sentence sentence : this.text) {
            hash = (int) (hash + sentence.hashCode() * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Sentence sentence : this.text)
            str.append(sentence.toString()).append(' ');
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Paths.get("\\UnivEdu\\kurs_3\\Java\\Practical 6\\src\\text_pack\\text.txt"), StandardCharsets.UTF_8);
        Text text = new Text(content);
        //Text text2 = new Text(content);
        System.out.println("Hash: "+text.hashCode());
        //System.out.println("Equal: "+text.equals(text2));
        System.out.println(text);
    }
}
