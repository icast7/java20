package com.zzz.archive.nai._7algorithms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogEntry {
    private static ArrayList<String> list = new ArrayList();
    private static String regex  = "^(\\d+)/(\\d+)/(\\d+) (.*) (\\d+)min (\\d+)min (\\S+)$";
    private static Pattern p = Pattern.compile(regex);

    public static void main(String[] args) {
        list.add("9/24/2016 The Magnificent Seven 133min 126min Action");
        list.add("9/30/2016 Miss Peregrine's Home for Peculiar Children 127min 100min Fantasy");
        list.add("11/5/2015 Trolls 92min 40min Fantasy");
        list.add("11/5/2015 Doctor Strange 115min 110min Fantasy");
        list.add("11/19/2016 Fantastic Beasts and Where to Find Them 133min 120min Fantasy");
        list.add("11/12/2016 Arrival 116min 20min SciFi");

        ArrayList<Entry> entries = new ArrayList<>();

        for (String l: list) {
            Matcher m = p.matcher(l);
            if (m.find()) {
                Entry entry = new Entry(m.group(4), Integer.parseInt(m.group(5))
                        , Integer.parseInt(m.group(6)), m.group(7));
                entries.add(entry);
            }
        }
        System.out.println("Watched by length:");
        System.out.println(
                entries.stream().sorted((a,b) -> a.getLength() - b.getLength())
                .map(entry -> entry.toString())
                .collect(Collectors.joining("\n"))
        );
        System.out.println("Avg % watched:");
        System.out.println(
        entries.stream().mapToDouble(entry-> (double) entry.getWatched()/entry.getLength())
        .average()
        .getAsDouble()
        );
        System.out.println("Fav genre:");
        System.out.println(
        entries.stream().filter(entry -> entry.getWatched()*2 >= entry.getLength())
                .collect(Collectors.groupingBy(Entry::getGenre, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.maxBy((a,b)-> (int)(a.getValue() - b.getValue())))
                .get()
                .getKey());
    }

    public static class Entry {
        private String title;
        private int length;
        private int watched;
        private String genre;

        public String getTitle() {
            return title;
        }

        public int getLength() {
            return length;
        }

        public int getWatched() {
            return watched;
        }

        public String getGenre() {
            return genre;
        }

        public Entry(String title, int length, int watched, String genre) {
            this.title = title;
            this.length =length;
            this.watched= watched;
            this.genre = genre;
        }

        @Override
        public String toString(){
            return String.format("| Title: %s | Length: %d | Watched: %d | Genre: %s |",
                    this.title, this.length, this.watched, this.genre);
        }
    }
}
