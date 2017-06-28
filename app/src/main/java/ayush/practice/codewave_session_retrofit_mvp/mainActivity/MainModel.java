package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ayush Jain on 6/26/17.
 */

public class MainModel {

    public class GetModelResponse {

        public class GitHubResponseModel {


            @SerializedName("gists_url")
            private String gistsUrl;

            @SerializedName("repos_url")
            private String reposUrl;

            @SerializedName("following_url")
            private String followingUrl;

            @SerializedName("bio")
            private Object bio;

            @SerializedName("created_at")
            private String createdAt;

            @SerializedName("login")
            private String login;

            @SerializedName("type")
            private String type;

            @SerializedName("blog")
            private String blog;

            @SerializedName("subscriptions_url")
            private String subscriptionsUrl;

            @SerializedName("updated_at")
            private String updatedAt;

            @SerializedName("site_admin")
            private boolean siteAdmin;

            @SerializedName("company")
            private Object company;

            @SerializedName("id")
            private int id;

            @SerializedName("public_repos")
            private int publicRepos;

            @SerializedName("gravatar_id")
            private String gravatarId;

            @SerializedName("email")
            private Object email;

            @SerializedName("organizations_url")
            private String organizationsUrl;

            @SerializedName("hireable")
            private boolean hireable;

            @SerializedName("starred_url")
            private String starredUrl;

            @SerializedName("followers_url")
            private String followersUrl;

            @SerializedName("public_gists")
            private int publicGists;

            @SerializedName("url")
            private String url;

            @SerializedName("received_events_url")
            private String receivedEventsUrl;

            @SerializedName("followers")
            private int followers;

            @SerializedName("avatar_url")
            private String avatarUrl;

            @SerializedName("events_url")
            private String eventsUrl;

            @SerializedName("html_url")
            private String htmlUrl;

            @SerializedName("following")
            private int following;

            @SerializedName("name")
            private String name;

            @SerializedName("location")
            private Object location;

            public void setGistsUrl(String gistsUrl) {
                this.gistsUrl = gistsUrl;
            }

            public String getGistsUrl() {
                return gistsUrl;
            }

            public void setReposUrl(String reposUrl) {
                this.reposUrl = reposUrl;
            }

            public String getReposUrl() {
                return reposUrl;
            }

            public void setFollowingUrl(String followingUrl) {
                this.followingUrl = followingUrl;
            }

            public String getFollowingUrl() {
                return followingUrl;
            }

            public void setBio(Object bio) {
                this.bio = bio;
            }

            public Object getBio() {
                return bio;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public String getLogin() {
                return login;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public void setBlog(String blog) {
                this.blog = blog;
            }

            public String getBlog() {
                return blog;
            }

            public void setSubscriptionsUrl(String subscriptionsUrl) {
                this.subscriptionsUrl = subscriptionsUrl;
            }

            public String getSubscriptionsUrl() {
                return subscriptionsUrl;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setSiteAdmin(boolean siteAdmin) {
                this.siteAdmin = siteAdmin;
            }

            public boolean isSiteAdmin() {
                return siteAdmin;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public Object getCompany() {
                return company;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public void setPublicRepos(int publicRepos) {
                this.publicRepos = publicRepos;
            }

            public int getPublicRepos() {
                return publicRepos;
            }

            public void setGravatarId(String gravatarId) {
                this.gravatarId = gravatarId;
            }

            public String getGravatarId() {
                return gravatarId;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getEmail() {
                return email;
            }

            public void setOrganizationsUrl(String organizationsUrl) {
                this.organizationsUrl = organizationsUrl;
            }

            public String getOrganizationsUrl() {
                return organizationsUrl;
            }

            public void setHireable(boolean hireable) {
                this.hireable = hireable;
            }

            public boolean isHireable() {
                return hireable;
            }

            public void setStarredUrl(String starredUrl) {
                this.starredUrl = starredUrl;
            }

            public String getStarredUrl() {
                return starredUrl;
            }

            public void setFollowersUrl(String followersUrl) {
                this.followersUrl = followersUrl;
            }

            public String getFollowersUrl() {
                return followersUrl;
            }

            public void setPublicGists(int publicGists) {
                this.publicGists = publicGists;
            }

            public int getPublicGists() {
                return publicGists;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

            public void setReceivedEventsUrl(String receivedEventsUrl) {
                this.receivedEventsUrl = receivedEventsUrl;
            }

            public String getReceivedEventsUrl() {
                return receivedEventsUrl;
            }

            public void setFollowers(int followers) {
                this.followers = followers;
            }

            public int getFollowers() {
                return followers;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setEventsUrl(String eventsUrl) {
                this.eventsUrl = eventsUrl;
            }

            public String getEventsUrl() {
                return eventsUrl;
            }

            public void setHtmlUrl(String htmlUrl) {
                this.htmlUrl = htmlUrl;
            }

            public String getHtmlUrl() {
                return htmlUrl;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public int getFollowing() {
                return following;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setLocation(Object location) {
                this.location = location;
            }

            public Object getLocation() {
                return location;
            }

            @Override
            public String toString() {
                return
                        "Response{" +
                                "gists_url = '" + gistsUrl + '\'' +
                                ",repos_url = '" + reposUrl + '\'' +
                                ",following_url = '" + followingUrl + '\'' +
                                ",bio = '" + bio + '\'' +
                                ",created_at = '" + createdAt + '\'' +
                                ",login = '" + login + '\'' +
                                ",type = '" + type + '\'' +
                                ",blog = '" + blog + '\'' +
                                ",subscriptions_url = '" + subscriptionsUrl + '\'' +
                                ",updated_at = '" + updatedAt + '\'' +
                                ",site_admin = '" + siteAdmin + '\'' +
                                ",company = '" + company + '\'' +
                                ",id = '" + id + '\'' +
                                ",public_repos = '" + publicRepos + '\'' +
                                ",gravatar_id = '" + gravatarId + '\'' +
                                ",email = '" + email + '\'' +
                                ",organizations_url = '" + organizationsUrl + '\'' +
                                ",hireable = '" + hireable + '\'' +
                                ",starred_url = '" + starredUrl + '\'' +
                                ",followers_url = '" + followersUrl + '\'' +
                                ",public_gists = '" + publicGists + '\'' +
                                ",url = '" + url + '\'' +
                                ",received_events_url = '" + receivedEventsUrl + '\'' +
                                ",followers = '" + followers + '\'' +
                                ",avatar_url = '" + avatarUrl + '\'' +
                                ",events_url = '" + eventsUrl + '\'' +
                                ",html_url = '" + htmlUrl + '\'' +
                                ",following = '" + following + '\'' +
                                ",name = '" + name + '\'' +
                                ",location = '" + location + '\'' +
                                "}";
            }
        }

    }

    public class PostModelResponse {

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

    }

}
