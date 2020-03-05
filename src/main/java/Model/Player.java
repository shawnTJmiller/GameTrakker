package Model;

public class Player {

    private int playerId;
    private String userName;
    private String firstName;
    private String lastName;
    private String nickName = userName;
    private int age;

    //Constructors
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player(int playerId) { this.playerId = playerId; }

    public Player(String firstName) {
        this.firstName = firstName;
    }

    public Player() {
        //Need to get ^previous Model.Player to resolve in Group.
    }

    //Getters
    public int getPlayerId() { return playerId; }
    public String getUserName() { return userName; }
    public String getFirstName(String first_name) {
        return firstName;
    }
    public String getLastName(String last_name) {
        return lastName;
    }
    public String getNickName(String nickName) {
        return nickName;
    }
    public int getAge(int age) {
        return this.age;
    }

    //Setters
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setAge(int age) {
        this.age = age;
    }
}