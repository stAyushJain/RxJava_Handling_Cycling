package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ayush Jain on 6/29/17.
 */
public class PostResponseModel {
    @SerializedName("code")
    private int code;

    @SerializedName("response")
    private String response;

    @SerializedName("employeeData")
    private List<EmployeeDataItem> employeeData;

    @SerializedName("status")
    private String status;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setEmployeeData(List<EmployeeDataItem> employeeData) {
        this.employeeData = employeeData;
    }

    public List<EmployeeDataItem> getEmployeeData() {
        return employeeData;
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
                "Response{" +
                        "code = '" + code + '\'' +
                        ",response = '" + response + '\'' +
                        ",employeeData = '" + employeeData + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
