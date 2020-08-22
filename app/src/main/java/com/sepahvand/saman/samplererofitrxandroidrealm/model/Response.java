package com.sepahvand.saman.samplererofitrxandroidrealm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Saman on 8/22/20.
 */

public class Response {
    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (results != null) {
            for (Result result: results) {
                sb.append(result.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}
