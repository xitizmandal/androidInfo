package np.com.xitiz.infostore;

/**
 * Created by xitiz on 12/16/16.
 */

public class Info {
    private int mId;
    private String name;
    private String dateOfBirth;
    private String citizenShipNumber;
    private String citizenShipIssueDate;
    private String citizenShipIssuePlace;
    private String bankName;
    private String accNumber;
    private String fatherName;
    private String grandFatherName;
    private String dpID;
    private String clientID;
    private String onlinePWD;
    private String permanentAdd;
    private String currentAdd;

    public Info(String name, String bankName, String accNumber) {
        this.name = name;
        this.bankName = bankName;
        this.accNumber = accNumber;
    }

    public Info(String name,
                String dateOfBirth,
                String citizenShipNumber,
                String citizenShipIssueDate,
                String citizenShipIssuePlace,
                String bankName,
                String accNumber,
                String fatherName,
                String grandFatherName,
                String dpID,
                String clientID,
                String permanentAdd,
                String currentAdd,
                String onlinePWD) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.citizenShipNumber = citizenShipNumber;
        this.citizenShipIssueDate = citizenShipIssueDate;
        this.citizenShipIssuePlace = citizenShipIssuePlace;
        this.bankName = bankName;
        this.accNumber = accNumber;
        this.fatherName = fatherName;
        this.grandFatherName = grandFatherName;
        this.dpID = dpID;
        this.clientID = clientID;
        this.onlinePWD = onlinePWD;
        this.permanentAdd = permanentAdd;
        this.currentAdd = currentAdd;
    }

    public Info(int id, String name,
                String dateOfBirth,
                String citizenShipNumber,
                String citizenShipIssueDate,
                String citizenShipIssuePlace,
                String bankName,
                String accNumber,
                String fatherName,
                String grandFatherName,
                String dpID,
                String clientID,
                String permanentAdd,
                String currentAdd,
                String onlinePWD) {
        this.mId = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.citizenShipNumber = citizenShipNumber;
        this.citizenShipIssueDate = citizenShipIssueDate;
        this.citizenShipIssuePlace = citizenShipIssuePlace;
        this.bankName = bankName;
        this.accNumber = accNumber;
        this.fatherName = fatherName;
        this.grandFatherName = grandFatherName;
        this.dpID = dpID;
        this.clientID = clientID;
        this.onlinePWD = onlinePWD;
        this.permanentAdd = permanentAdd;
        this.currentAdd = currentAdd;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenShipNumber() {
        return citizenShipNumber;
    }

    public void setCitizenShipNumber(String citizenShipNumber) {
        this.citizenShipNumber = citizenShipNumber;
    }

    public String getCitizenShipIssueDate() {
        return citizenShipIssueDate;
    }

    public void setCitizenShipIssueDate(String citizenShipIssueDate) {
        this.citizenShipIssueDate = citizenShipIssueDate;
    }

    public String getCitizenShipIssuePlace() {
        return citizenShipIssuePlace;
    }

    public void setCitizenShipIssuePlace(String citizenShipIssuePlace) {
        this.citizenShipIssuePlace = citizenShipIssuePlace;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getDpID() {
        return dpID;
    }

    public void setDpID(String dpID) {
        this.dpID = dpID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getOnlinePWD() {
        return onlinePWD;
    }

    public void setOnlinePWD(String onlinePWD) {
        this.onlinePWD = onlinePWD;
    }

    public String getPermanentAdd() {
        return permanentAdd;
    }

    public void setPermanentAdd(String permanentAdd) {
        this.permanentAdd = permanentAdd;
    }

    public String getCurrentAdd() {
        return currentAdd;
    }

    public void setCurrentAdd(String currentAdd) {
        this.currentAdd = currentAdd;
    }
}

