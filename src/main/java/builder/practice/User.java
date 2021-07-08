package builder.practice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User
{
    private String name;
    private int age;
    private String nickName;
    private Insurance insurance;

    public static class Builder {

        private final String name;
        private final int age;

        private String nickName = null;
        private Insurance insurance = null;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder nickName(String val) {
            this.nickName = val;
            return this;
        }

        public Builder insurance(Insurance val) {
            this.insurance = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(User.Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.nickName = builder.nickName;
        this.insurance = builder.insurance;
    }
}
