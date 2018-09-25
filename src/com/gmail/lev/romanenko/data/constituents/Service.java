package com.gmail.lev.romanenko.data.constituents;

public class Service {
    String service;

    public Service(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    private static class Variation {
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
