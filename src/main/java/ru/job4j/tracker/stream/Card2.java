package ru.job4j.tracker.stream;

import java.util.stream.Stream;

public class Card2 {
    private Suit suit;
    private Value value;

    public Card2(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(v -> Stream.of(Value.values()).map(s -> new Card2(v, s)))
                .toList();
    }
}
