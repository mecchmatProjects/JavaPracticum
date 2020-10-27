package text_pack;

import java.util.Arrays;

public class Sentence {
    private Word[] sentence;

    Sentence(String str){
        String[] str_arr = str.split("[ ]+");
        sentence = new Word[str_arr.length];
        for (int i=0;i<str_arr.length;i++){
            sentence[i] = new Word(str_arr[i]);
        }
    }

    Sentence(String[] str){
        sentence = new Word[str.length];
        for (int i=0;i<str.length;i++){
            sentence[i] = new Word(str[i]);
        }
    }

    public boolean equals(Sentence ob) {
        if (this.sentence.length != ob.sentence.length)
            return false;
        for (int i=0;i<this.sentence.length;i++){
            if (!this.sentence[i].equals(ob.sentence[i]))
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
        for (Word word : this.sentence) {
            hash = (int) (hash + word.hashCode() * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Word word: sentence)
            str.append(word.toString()).append(' ');
        return str.toString();
    }
}
