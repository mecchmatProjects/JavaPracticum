package text_pack;

public class Word {
    private String word;

    Word(){this.word="";}
    Word(String word){this.word=word;}

    public boolean equals(Word ob) {
        return this.word.equals(ob.word);
    }

    @Override
    public int hashCode() {
        int p = 31;
        int hash = 0;
        long p_pow = 1;
        for (int i=0;i<this.word.length();i++){
            hash = (int)(hash + (this.word.charAt(i)-'a'+1) * p_pow);
            p_pow = p_pow * p;
        }
        return hash;
    }

    @Override
    public String toString() {
        return word;
    }
}
