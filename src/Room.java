public class Room {

    private String roomName;
    private String roomDescription;

    //De forskellige forbindelser. De er sat til null, da der som udgangspunkt er ingen forbindelse før at andet er lavet
    private Room roomN = null;
    private Room roomE = null;
    private Room roomS = null;
    private Room roomW = null;


    public Room(String name, String description) {
        roomName = name;
        roomDescription = description;

    }

    public String getName () {
        return roomName;
    }

    //Metoden setName og setDescription bliver egentlig ikke brugt, men formalia du ved
    public void setName (String name) {
        roomName = name;
    }

    public String getDescription () {
        return roomDescription;
    }

    public void setDescription (String description) {
        roomDescription = description;
    }

    public Room getNorth () {
        return roomN;
    }

    public void setNorth (Room input) {
        roomN = input;
    }

    public Room getEast () {
        return roomE;
    }

    public void setEast (Room input) {
        roomE = input;
    }

    public Room getSouth () {
        return roomS;
    }

    public void setSouth (Room input) {
        roomS = input;
    }

    public Room getWest () {
        return roomW;
    }

    public void setWest (Room input) {
        roomW = input;
    }

}
