package com.basicjpaweb.basicjpaweb.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty
    private Data data;
    @JsonProperty
    private Support support;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}


/*

        "data": {
        "id": 1,
        "email": "george.bluth@reqres.in",
        "first_name": "George",
        "last_name": "Bluth",
        "avatar": "https://reqres.in/img/faces/1-image.jpg"
        },
        "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
*/

