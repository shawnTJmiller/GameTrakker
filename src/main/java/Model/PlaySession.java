package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlaySession {

    private int sessionId;
    private String sessionName;
    private LocalDateTime sessionDate;
    private String sessionLocation;
    private boolean hasPrize;
    private String prize;
    private BigDecimal prizeMoney = new BigDecimal(0.00);

    public PlaySession(int sessionId, int groupId) {
        this.sessionId = sessionId;
    }
    public PlaySession() {
        //need above constructor to work;
    }

    //getters
    public int getSessionId() {
        return sessionId;
    }
    public String getSessionName() {
        return sessionName;
    }
    public LocalDateTime getSessionDate() {
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
    public void setSessionDate(LocalDateTime sessionDate) {
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

}
