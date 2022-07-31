package com.gmail.josedanielmmf.game;

import com.gmail.josedanielmmf.utils.ConvertListToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AhorcadoGame {
    private int errors;
    private final List<String> words;
    private List<String> word;
    private boolean error;
    private List<String> resultWord;



    public AhorcadoGame() {
        this.words = new ArrayList<>();
        this.errors = 0;
    }

    public String game(String letter) {
        if (word.contains(letter)) {
            for (int i = 0; i < word.size(); i++) {
                if (word.get(i).equals(letter)) {
                    resultWord.set(i, letter);
                }
            }

            this.error = false;
        } else {
            this.error = true;
            this.errors++;
        }
        return new ConvertListToString(resultWord).getString();
    }



    public void randomWord() {
        Random random = new Random();
        this.word = new ArrayList<>();
        resultWord = new ArrayList<>();
        for (char ch : this.words.get(random.nextInt(words.size())).toCharArray()) {
            word.add(String.valueOf(ch));
            resultWord.add("_");
        }

    }

    public int getErrors() {
        return this.errors;
    }

    public String getWord(){
        return new ConvertListToString(word).getString().replaceAll(" ", "");
    }

    public String getResultWorld(){
        return new ConvertListToString(this.resultWord).getString().replaceAll(" ", "");
    }

    public boolean getError(){
        return this.error;
    }

    public void setWord()throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("Words.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            this.words.add(line.trim().toLowerCase());
        }
        randomWord();
    }


}
