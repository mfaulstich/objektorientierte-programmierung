package de.fhswf.inf.oopold.aufgabe3.uebung2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et ");
        lines.add(
                "dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet ");
        lines.add(
                "clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, ");
        lines.add(
                "consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, ");
        lines.add(
                "sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea ");
        lines.add(
                "takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed ");
        lines.add(
                "diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et ");
        lines.add(
                "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        lines.add(
                "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu ");
        lines.add(
                "feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril ");
        lines.add(
                "delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, ");
        lines.add("sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.");
        lines.add(
                "Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea ");
        lines.add(
                "commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, ");
        lines.add(
                "vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent ");
        lines.add("luptatum zzril delenit augue duis dolore te feugait nulla facilisi.");
        lines.add(
                "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim ");
        lines.add(
                "assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet ");
        lines.add(
                "dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit ");
        lines.add("lobortis nisl ut aliquip ex ea commodo consequat.  ");
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String line: lines){
            for (String word: line.split("[\\p{Space}\\p{Punct}]+")){
                Integer count = wordMap.putIfAbsent(word, 1);
                if (count != null){
                    wordMap.put(word, count+1);
                }
            }
        }
        Set<String> words = new TreeSet<>(wordMap.keySet());
        words = Collections.unmodifiableSet(words);
        for (String word: words){
            System.out.printf("%-20s - %3d\n", word, wordMap.get(word));
        }
    }
}
