package com.example.login;

public class Question {
    private static final char DEPRESSION = 'd';
    private static final char STRESS = 's';
    private static final char AXIETY = 'a';
    private String question;
    private char type;
    private static Question[] questionnaire;
    private static Question q = null;

    private Question() {
        addQuestions();
    }

    private void addQuestions(){
        questionnaire = new Question[21];
        questionnaire[0] = new Question('s', "I found it hard to wind down");
        questionnaire[1] = new Question('a', "I was aware of dryness of my mouth");
        questionnaire[2] = new Question('d', "I couldn't seem to experience any positive feeling at all");
        questionnaire[3] = new Question('a',"I experienced breathing difficulty (e.g. excessively rapid breathing, breathlessness in the absence of physical exertion)");
        questionnaire[4] = new Question('d', "I found it difficult to work up the initiative to do things");
        questionnaire[5] = new Question('s', "I tended to over-react to situations");
        questionnaire[6] = new Question('a', "I experienced trembling (e.g. in the hands)");
        questionnaire[7] = new Question('s', "I felt that I was using a lot of nervous energy");
        questionnaire[8] = new Question('a', "I was worried about situations in which I might panic and make a fool of myself");
        questionnaire[9] = new Question('d', "I felt that I had nothing to look forward to");
        questionnaire[10] = new Question('s', "I found myself getting agitated");
        questionnaire[11] = new Question('s', "I found it difficult to relax");
        questionnaire[12] = new Question('d', "I felt down-hearted and blue");
        questionnaire[13] = new Question('s', "I was intolerant of anything that kept me from getting on with what I was doing");
        questionnaire[14] = new Question('a', "I felt I was close to panic");
        questionnaire[15] = new Question('d', "I was unable to become enthusiastic about anything");
        questionnaire[16] = new Question('d', "I felt I wasn't worth much as a person");
        questionnaire[17] = new Question('s', "I felt that I was rather touchy");
        questionnaire[18] = new Question('a', "I was aware of the action of my heart in the absence of physical exertion (e.g. sense of heart rate increase, heart missing a beat)");
        questionnaire[19] = new Question('a', "I felt scared without any good reason");
        questionnaire[20] = new Question('d', "I felt that life was meaningless");
    }

    public static Question getInstance(){
        return q==null? new Question():q;
    }

    public Question at(int i){
        return i<21 && i>=0? questionnaire[i]:null;
    }

    private Question(char type,String question) {
        this.question = question;
        this.type = type;
    }

    public Character getType() {
        return type;
    }
    public String getQuestion() {
        return question;
    }
}
