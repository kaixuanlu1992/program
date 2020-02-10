package com.work.base.se.annotation;

public class SimpleTest {
    @SimpleAnnotation
    int i;
    @SimpleAnnotation
    public SimpleTest() {}
    @SimpleAnnotation
    public void foo() {
        System.out.println("SimpleTest.foo()");
    }
    @SimpleAnnotation
    public void bar(String s, int i, float f) {
        System.out.println("SimpleTest.bar()");
    }
    @SimpleAnnotation
    public static void main(String[] args) {
        @SimpleAnnotation
        SimpleTest st = new SimpleTest();
        st.foo();
    }

}
