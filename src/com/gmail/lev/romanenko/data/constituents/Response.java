package com.gmail.lev.romanenko.data.constituents;

import java.util.Objects;

public class Response {
    String responce;

    public Response(String responce) {
        this.responce = responce;
    }

    public String getResponce() {
        return responce;
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }


    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(this.responce, response.responce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.responce);
    }
}
