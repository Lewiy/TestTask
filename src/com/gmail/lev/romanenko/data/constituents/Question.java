package com.gmail.lev.romanenko.data.constituents;

public class Question {

    String question;
    private Category category;


    public Question(String question, Category category) {
        this.question = question;
        this.category = category;
    }

    public Question(String question) {
        this.question = question;
    }

    public static class Category {
        private String category;
        private SubCategory subCategory;

        public Category(String category, SubCategory subCategory) {
            this.category = category;
            this.subCategory = subCategory;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public static class SubCategory {

            private String subCategory;

            public SubCategory(String subCategory) {
                this.subCategory = subCategory;
            }
            public String getSubCategory() {
                return subCategory;
            }

            public void setSubCategory(String subCategory) {
                this.subCategory = subCategory;
            }

        }

    }
}
