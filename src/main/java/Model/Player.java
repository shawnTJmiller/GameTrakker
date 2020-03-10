package Model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Player {

    private int playerId;
    @NotEmpty @NotNull @NotBlank
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

    public Player(String userName) {
        this.userName = userName;
    }

    public Player() {
    }

    //Getters
    public int getPlayerId() { return playerId; }
    public String getUserName() { return userName; }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNickName() {
        return nickName;
    }
    public int getAge() {
        return this.age;
    }

    //Setters
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setAge(int age) {
        this.age = age;
    }
}