package se.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Test {
    public static void main( String[] args ){
        List<String> str= Arrays.asList("abc","sss","sssss");
        str=str.stream().map(item->item.toUpperCase()).collect(Collectors.toList());
        str=str.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(str.toString());
    }

    class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }

    }
    enum Type { MEAT, FISH, OTHER }
}
