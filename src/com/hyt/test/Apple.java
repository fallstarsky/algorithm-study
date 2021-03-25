package com.hyt.test;

/**
 * @author houyutao
 * @date 2021-02-13
 */
public class Apple extends Fruit{

    private Integer id;

    private String name;

    public Apple eatApple() {
        System.out.println(this + "吃苹果咯");
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




    public static void main(String[] args) {
        Character c = '3';
        int[] array = new int[128];
        System.out.println(array[c]);

        int i = 1329;
        System.out.println((char) i);
    }

    public void eat() {
        System.out.println("哈哈，吃苹果");
    }
}
