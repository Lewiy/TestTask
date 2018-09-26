package com.gmail.lev.romanenko.data.constituents;

import java.util.Objects;

public class ServiceEntity {
    String service;
    Variation variation;
    public ServiceEntity(String service, Variation variation) {
        this.service = service;
        this.variation = variation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public static class Variation {
        String variation;

        public Variation(String variation) {
            this.variation = variation;
        }

        public String getVariation() {
            return variation;
        }

        public void setVariation(String variation) {
            this.variation = variation;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceEntity)) return false;
        ServiceEntity serviceEntity = (ServiceEntity) o;
        return Objects.equals(this.service, serviceEntity.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.service);
    }
}
