package cn.cjd.springboot.modal.db_use.nutz.nutzdao.query;


import java.util.HashMap;
import java.util.Map;

public class Direction {
    private static final Map<String, Direction> directions = new HashMap();
    public static final Direction ASCENDING = new Direction("asc");
    public static final Direction DESCENDING = new Direction("desc");
    private String name;

    public Direction(String name) {
        this.name = name;
        directions.put(name, this);
    }

    public String getName() {
        return this.name;
    }

    public static Direction findByName(String directionName) {
        return (Direction)directions.get(directionName);
    }
}
