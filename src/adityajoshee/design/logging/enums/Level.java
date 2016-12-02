package adityajoshee.design.logging.enums;

/**
 * Created by aditya on 12/2/16.
 */
public enum Level {
    OFF(-1),
    DEBUG(0),
    INFO(1),
    ERROR(2);

    Integer value;

    Level(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }

}
