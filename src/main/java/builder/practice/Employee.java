package builder.practice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Employee
{
    private final String name;

    private final int age;

    private String hobby;
}
