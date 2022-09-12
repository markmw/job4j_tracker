package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder(buildMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("rules")
    private List<String> rules;
}
