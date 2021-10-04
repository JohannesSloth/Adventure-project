public class Player {

    private Room currentRoom;
    private String playerName;

    public Player() {
        //Spilleren skal ikke have constructor input, da vi ikke har oprettet room-objekter endnu
    }

    public void setPlayerName (String name) {
        this.playerName = name;
    }

    public String getPlayerName () {
        return playerName;
    }

    //Vi bruger faktisk kun denne metode for formalia, men kunne have skiftet direkte i variablen, da metoden ikke bruges andre steder ind i Player klassen
    public void setRoom (Room newRoom) {
        this.currentRoom = newRoom;
    }

    public Room getRoom () {
        return currentRoom;
    }

    //go metoderne bliver kaldt som booleans, da vi ønsker at få at vide om forbindelsen er mulig
    public boolean goNorth () {
        if (currentRoom.getNorth() != null) {
            this.setRoom(currentRoom.getNorth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goEast () {
        if (currentRoom.getEast() != null) {
            this.setRoom(currentRoom.getEast());
            return true;
        } else {
            return false;
        }
    }

    public boolean goSouth () {
        if (currentRoom.getSouth() != null) {
            this.setRoom(currentRoom.getSouth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goWest () {
        if (currentRoom.getWest() != null) {
            this.setRoom(currentRoom.getWest());
            return true;
        } else {
            return false;
        }
    }

}
