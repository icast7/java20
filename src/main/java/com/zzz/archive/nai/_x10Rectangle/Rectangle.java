package com.zzz.archive.nai._x10Rectangle;

public class Rectangle {
    public static void main(String[] args) {
        MyRectagle myRectagle = new MyRectagle(0,0, 10, 2);
        System.out.println(myRectagle.contains(11, 0));
        System.out.println(myRectagle.contains(8, 1));
        System.out.println(myRectagle.contains(0, 0));

    }

    public static class MyRectagle {
        private double xOrigin;
        private double yOrigin;
        private double height;
        private double width;

        public MyRectagle(double xOrigin, double yOrigin, double width, double height) {
            this.xOrigin = xOrigin;
            this.yOrigin = yOrigin;
            this.width = width;
            this.height = height;
        }

        public boolean contains(double x, double y) {
            return x > this.xOrigin && x < this.xOrigin + this.width
                && y > this.yOrigin && y < this.yOrigin + this.height;
        }
    }
}
