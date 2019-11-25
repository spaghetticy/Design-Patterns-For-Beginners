package com.pattern.creational.builder;

public class SimpleBuilder {
    static class Coffee {
        private String type;
        private int size;
        private boolean sugar;
        private boolean milk;

        // has to be private to force creating object via build() method instead of constructor
        private Coffee(Builder builder) {
            this.type = builder.type;
            this.size = builder.size;
            this.sugar = builder.sugar;
            this.milk = builder.milk;
        }

        public String toString() {
            return "type:" + this.type + " size: " + this.size
                    + " sugar:" + this.sugar + " milk:" + this.milk;
        }

        static class Builder {
            // required member variable(s)
            private String type;
            private int size;

            // optional variable(s)
            private boolean sugar = false;
            private boolean milk = false;

            // builder constructor
            Builder(String type, int size) {
                this.type = type;
                this.size = size;
            }

            // setter method for chain operation
            Builder sugar(boolean value) {
                this.sugar = value;
                return this;
            }

            // setter method for chain operation
            Builder milk(boolean value) {
                this.milk = value;
                return this;
            }

            Coffee build() {
                return new Coffee(this);
            }
        }
    }

    public static void main(String[] args) {
        Coffee medianBlack = new SimpleBuilder.Coffee.Builder("Black", 16)
                .build();
        System.out.println(medianBlack.toString());

        Coffee largeMocha = new Coffee.Builder("Mocha", 20)
                .sugar(true).milk(true)
                .build();
        System.out.println(largeMocha.toString());
    }
}
