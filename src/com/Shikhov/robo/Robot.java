//package com.Shikhov.robo;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class Robot {
//    String sortingType;
//    String dataType;
//
//    public static void main(String[] args) {
////        Robot r = new Robot();
////        moveRobot(r, -10, 10);
////        moveRobot(r, 10, -10);
////        moveRobot(r, -10, -10);
////        moveRobot(r, 10, 10);
////        moveRobot(r, 0, 0);
//
//        Scanner scanner = new Scanner(System.in);
//
////        Iterator<String> iterator = new
//    }
//
//    private static void checkArgs(String[] args){
//        List<String> argList = Arrays.asList(args);
//        Iterator<String> listIt = argList.iterator();
//        while (listIt.hasNext()){
//            String currentArg = listIt.next();
//            if ("-dataType".equals(currentArg) && listIt.hasNext()){
//                if (listIt.hasNext()){
//                    getDataType(listIt.next());
//                } else {
//                    System.out.println("No data type defined!");
//                }
//            }
//        }
//    }
//
//    private static void getDataType(String type){
//        try {
//            if ("long".equals(dataType)) {
//
//            }
//        }
//    }
//
//    public class IncorrectSortingType extends Exception {
//        public IncorrectSortingType(String errorMessage){
//            super(errorMessage);
//        }
//    }
//
//    public class IncorrectDataType extends Exception {
//        public IncorrectDataType(String errorMessage){
//            super(errorMessage);
//        }
//    }
//
//
//    /* Do not change code below */
//    public static void methodThrowingExceptions() {
//        if (array == null) {
//            return;
//        }
//        int[] integers = Arrays.stream(array.split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        Object someValue = integers[integers[0]];
//        if (integers[0] + integers[1] == integers[2]){
//            integers = null;
//        }
//        int sum = 0;
//        for (int i : integers){
//            sum += i;
//        }
//        int meanValue = integers.length / sum;
//        if (integers[2] == integers[3]){
//            String string = (String) someValue;
//            System.out.print("Random value is " + string);
//        }
//        System.out.print("Mean is " + meanValue);
//    }
//
//    private static String array = null;
//
//
//
//    int x = 0;
//    int y = 0;
//    Direction direction = Direction.UP;
//
//    public Direction getDirection() {
//        return direction;
//    }
//
//    public enum Direction {
//        UP,
//        DOWN,
//        LEFT,
//        RIGHT
//    }
//
//    public static void moveRobot(Robot robot, int toX, int toY) {
//        switch (robot.getDirection()) {
//            case UP:
//                break;
//            case LEFT:
//                robot.turnRight();
//                break;
//            case RIGHT:
//                robot.turnLeft();
//                break;
//            case DOWN:
//                robot.turnLeft();
//                robot.turnLeft();
//                break;
//        }
//
//        if (robot.getX() > toX) {
//            robot.turnLeft();
//            for (int i = robot.getX(); i < Math.abs(toX); i++) {
//                robot.stepForward();
//            }
//            robot.turnRight();
//        } else if (robot.getX() < toX) {
//            robot.turnRight();
//            for (int i = robot.getX(); i < Math.abs(toX); i++) {
//                robot.stepForward();
//            }
//            robot.turnLeft();
//        }
//
//        if (robot.getY() > toY) {
//            robot.turnLeft();
//            robot.turnLeft();
//            for (int i = robot.getY(); i < Math.abs(toY); i++) {
//                robot.stepForward();
//            }
//            robot.turnLeft();
//            robot.turnLeft();
//        } else if (robot.getY() < toY) {
//            for (int i = robot.getY(); i < Math.abs(toY); i++) {
//                robot.stepForward();
//            }
//        }
//        System.out.println(robot.getX());
//        System.out.println(robot.getY());
//    }
//
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void turnLeft() {
//        if (direction == Direction.DOWN) {
//            this.direction = Direction.RIGHT;
//            return;
//        }
//
//        if (direction == Direction.UP) {
//            this.direction = Direction.LEFT;
//            return;
//        }
//
//        if (direction == Direction.LEFT) {
//            this.direction = Direction.DOWN;
//            return;
//        }
//
//        if (direction == Direction.RIGHT) {
//            this.direction = Direction.UP;
//            return;
//        }
//    }
//
//    public void turnRight() {
//        if (this.direction == Direction.DOWN) {
//            this.direction = Direction.LEFT;
//            return;
//        }
//
//        if (this.direction == Direction.UP) {
//            this.direction = Direction.RIGHT;
//            return;
//        }
//
//        if (this.direction == Direction.LEFT) {
//            this.direction = Direction.UP;
//            return;
//        }
//
//        if (this.direction == Direction.RIGHT) {
//            this.direction = Direction.DOWN;
//            return;
//        }
//    }
//
//    public void stepForward() {
//        if (direction == Direction.DOWN) {
//            this.y--;
//        }
//
//        if (direction == Direction.UP) {
//            this.y++;
//        }
//
//        if (direction == Direction.LEFT) {
//            this.x--;
//        }
//
//        if (direction == Direction.RIGHT) {
//            this.x++;
//        }
//    }
//}