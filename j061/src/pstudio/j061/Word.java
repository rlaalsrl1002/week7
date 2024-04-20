package pstudio.j061;

public class Word {
    private String englishWord;
    private String koreanMeaning;
    private int difficultyLevel;

    public Word(String englishWord, String koreanMeaning, int difficultyLevel) {
        this.englishWord = englishWord;
        this.koreanMeaning = koreanMeaning;
        this.difficultyLevel = difficultyLevel;
    }

    // Getter and Setter methods
    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getKoreanMeaning() {
        return koreanMeaning;
    }

    public void setKoreanMeaning(String koreanMeaning) {
        this.koreanMeaning = koreanMeaning;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // toString method
    @Override
    public String toString() {
        return "Word{" +
                "englishWord='" + englishWord + '\'' +
                ", koreanMeaning='" + koreanMeaning + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }
}
