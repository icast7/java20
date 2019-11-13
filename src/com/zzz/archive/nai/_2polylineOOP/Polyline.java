package com.zzz.archive.nai._2polylineOOP;

import java.util.ArrayList;

public class Polyline {
    private final ArrayList<Point> points;

    private Polyline(ArrayList<Point> points) {
        this.points = points;
    }

    private static Polyline create() {
        return new Polyline(new ArrayList<>());
    }

    public Polyline add(Point point) {
        ArrayList<Point> newPoints = new ArrayList<>(this.points);
        newPoints.add(point);
        return new Polyline(newPoints);
    }

    public int size(){
        return this.points.size();
    }

    public Point getPoint(int index) {
     return points.get(index);
    }
}
