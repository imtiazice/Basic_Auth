package com.offtechitbd.basicauth.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("result")
    @Expose
    private Result result;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}

class Logo {

    @SerializedName("path")
    @Expose
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

class Result {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("module")
    @Expose
    private List<String> module = null;
    @SerializedName("theme")
    @Expose
    private Theme theme;
    @SerializedName("logo")
    @Expose
    private Logo logo;
    @SerializedName("tracking")
    @Expose
    private Tracking tracking;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getModule() {
        return module;
    }

    public void setModule(List<String> module) {
        this.module = module;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

}
class Theme {

    @SerializedName("color")
    @Expose
    private Object color;

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

}

class Tracking {

    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}

class UserInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("time_from")
    @Expose
    private String timeFrom;
    @SerializedName("time_to")
    @Expose
    private String timeTo;
    @SerializedName("IMEI_code")
    @Expose
    private String iMEICode;
    @SerializedName("app_version")
    @Expose
    private String appVersion;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getIMEICode() {
        return iMEICode;
    }

    public void setIMEICode(String iMEICode) {
        this.iMEICode = iMEICode;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}