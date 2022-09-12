package ru.job4j.lombok;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
public class Category {
    @Getter
    @NonNull
    private int id;
    @Getter
    @Setter
    private String name;
}
