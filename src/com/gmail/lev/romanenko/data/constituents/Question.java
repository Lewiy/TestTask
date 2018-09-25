package com.gmail.lev.romanenko.data.constituents;

public class Question {
    String question;

    public Question(String question) {
        this.question = question;
    }

    private static class Type {
        public Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String type;

        private static class Category {
            public Category(String category) {
                this.category = category;
            }

            private String category;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            private static class SubCategory {
                public SubCategory(String subCategory) {
                    this.subCategory = subCategory;
                }

                private String subCategory;

                public String getSubCategory() {
                    return subCategory;
                }

                public void setSubCategory(String subCategory) {
                    this.subCategory = subCategory;
                }

            }

        }
    }
}
