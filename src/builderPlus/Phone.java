package builderPlus;

public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String mainBoard;

    protected Phone (Builder builder) {
        cpu = builder.cpu;
        screen = builder.screen;
        memory = builder.memory;
        mainBoard = builder.mainBoard;
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainBoard;

        public Builder() {}

        public Builder cpu(String val) {
            cpu = val;
            return this;
        }

        public Builder screen(String val) {
            screen = val;
            return this;
        }

        public Builder memory(String val) {
            memory = val;
            return this;
        }

        public Builder mainBoard(String val) {
            mainBoard = val;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainBoard + '\'' +
                '}';
    }

}
