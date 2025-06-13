package com.day5;

public class FilterCopy {
    public String[] filter(String[] words){
        String[] newWords = null;
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].length()>6){
                ++count;//3
            }
        }
        System.out.println(count);//3
        newWords = new String[count];
        //새로운 배열로 데이터 복사하기(삭제할 인덱스 제외)
        int newIndex = 0;
        for(int i=0;i< words.length;i++){
            if(words[i].length()>6){
                newWords[newIndex++] = words[i];
            }
        }
        System.out.println(newWords[0]);//null, null, null
        System.out.println(newWords[1]);//null, null, null
        System.out.println(newWords[2]);//null, null, null
        System.out.println(words == newWords);//false
        return newWords;
    }
    public static void main(String[] args) {
        String[] words = {"spray", "elite", "exuberant", "destruction", "present"};
        FilterCopy fc = new FilterCopy();
        fc.filter(words);

    }
}
