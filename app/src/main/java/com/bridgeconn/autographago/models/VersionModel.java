package com.bridgeconn.autographago.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VersionModel extends RealmObject {

    private String versionName;
    private String versionCode;
    private String languageCode;
    @PrimaryKey
    private String versionId;
    private RealmList<BookModel> bookModels = new RealmList<>();

    public VersionModel(VersionModel model) {
        versionName = model.getVersionName();
        versionCode = model.getVersionCode();
        bookModels = model.getBookModels();
        languageCode = model.getLanguageCode();
        versionId = model.getVersionId();
    }

    public VersionModel() {
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public RealmList<BookModel> getBookModels() {
        return bookModels;
    }

    public void setBookModels(RealmList<BookModel> bookModels) {
        this.bookModels = bookModels;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
}
