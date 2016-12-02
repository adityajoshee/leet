package adityajoshee.design.hotelReservation.enums.room;

/**
 * Created by aditya on 11/30/16.
 */
public enum  RoomType {
    TWIN_BED(5000.0f),
    QUEEN_BED(8000.0f),
    KING_BED(10000.0f);

    Float cost;

    RoomType(Float cost){
        this.cost = cost;
    }

    Float getCost(){
        return cost;
    }
}
