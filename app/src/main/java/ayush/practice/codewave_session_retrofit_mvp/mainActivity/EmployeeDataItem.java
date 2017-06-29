package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ayush Jain on 6/29/17.
 */
public class EmployeeDataItem {
    @SerializedName("updated_on")
    private String updatedOn;

    @SerializedName("authKey")
    private String authKey;

    @SerializedName("address")
    private String address;

    @SerializedName("company_id")
    private String companyId;

    @SerializedName("payment_status")
    private String paymentStatus;

    @SerializedName("fax_number")
    private String faxNumber;

    @SerializedName("token")
    private String token;

    @SerializedName("invite_verified")
    private boolean inviteVerified;

    @SerializedName("profile_image")
    private String profileImage;

    @SerializedName("total_overtime")
    private Object totalOvertime;

    @SerializedName("trail_status")
    private String trailStatus;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_on")
    private String createdOn;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("employee_id")
    private String employeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("_id")
    private String id;

    @SerializedName("department")
    private String department;

    @SerializedName("email")
    private String email;

    @SerializedName("fcm_id")
    private String fcmId;

    @SerializedName("status")
    private String status;

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setInviteVerified(boolean inviteVerified) {
        this.inviteVerified = inviteVerified;
    }

    public boolean isInviteVerified() {
        return inviteVerified;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setTotalOvertime(Object totalOvertime) {
        this.totalOvertime = totalOvertime;
    }

    public Object getTotalOvertime() {
        return totalOvertime;
    }

    public void setTrailStatus(String trailStatus) {
        this.trailStatus = trailStatus;
    }

    public String getTrailStatus() {
        return trailStatus;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    public String getFcmId() {
        return fcmId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "EmployeeDataItem{" +
                        "updated_on = '" + updatedOn + '\'' +
                        ",authKey = '" + authKey + '\'' +
                        ",address = '" + address + '\'' +
                        ",company_id = '" + companyId + '\'' +
                        ",payment_status = '" + paymentStatus + '\'' +
                        ",fax_number = '" + faxNumber + '\'' +
                        ",token = '" + token + '\'' +
                        ",invite_verified = '" + inviteVerified + '\'' +
                        ",profile_image = '" + profileImage + '\'' +
                        ",total_overtime = '" + totalOvertime + '\'' +
                        ",trail_status = '" + trailStatus + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",created_on = '" + createdOn + '\'' +
                        ",company_name = '" + companyName + '\'' +
                        ",employee_id = '" + employeeId + '\'' +
                        ",name = '" + name + '\'' +
                        ",phone_number = '" + phoneNumber + '\'' +
                        ",_id = '" + id + '\'' +
                        ",department = '" + department + '\'' +
                        ",email = '" + email + '\'' +
                        ",fcm_id = '" + fcmId + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
