package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlaySession {

    private int sessionId;
    private String sessionName;
    private LocalDate sessionDate;
    private String sessionLocation;
    private boolean hasPrize;
    private String prize = "";
    private BigDecimal prizeMoney = new BigDecimal(0.00);

    GamingGroup group = new GamingGroup();

    public PlaySession(String sessionName, LocalDate sessionDate, String sessionLocation, boolean hasPrize, GamingGroup group) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.sessionLocation = sessionLocation;
        this.hasPrize = hasPrize;
        this.group = group;

        setPrizeForGame(hasPrize);
    }

    public PlaySession() {
    }

    //getters
    public int getSessionId() {
        return sessionId;
    }
    public String getSessionName() {
        return sessionName;
    }
    public LocalDate getSessionDate() {
        return sessionDate;
    }
    public String getSessionLocation() {
        return sessionLocation;
    }
    public boolean isHasPrize() {
        return hasPrize;
    }
    public String getPrize() {
        return prize;
    }
    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    //setters
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }
    public void setSessionLocation(String sessionLocation) {
        this.sessionLocation = sessionLocation;
    }
    public void setHasPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }
    public void setPrize(String prize) {
        this.prize = prize;
    }
    public void setPrizeMoney(BigDecimal prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public String setPrizeForGame(Boolean hasPrize) {
        if (hasPrize) {
            setPrize(prize);
            if (prize.equals("Money") || prize.equals("Gift Card")) {
                setPrizeMoney(prizeMoney);
            }
        }
        return prize;
    }

}
