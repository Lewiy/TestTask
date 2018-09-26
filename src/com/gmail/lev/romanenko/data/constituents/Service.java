package com.gmail.lev.romanenko.data.constituents;

public class Service {
    String service;
    Variation variation;
    public Service(String service,Variation variation) {
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


}
