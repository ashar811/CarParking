import java.time.LocalDateTime;

public class Car {

    private String regNo;

    private LocalDateTime dateTimeCarEntered;

    public Car(String regNo, LocalDateTime dateTimeCarEntered) {
        this.regNo = regNo;
        this.dateTimeCarEntered = dateTimeCarEntered;
    }

    public LocalDateTime getDateTimeCarEntered() {
        return dateTimeCarEntered;
    }

    public void setDateTimeCarEntered(LocalDateTime dateTimeCarEntered) {
        this.dateTimeCarEntered = dateTimeCarEntered;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
