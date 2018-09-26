package com.gmail.lev.romanenko.data.constituents;

import java.util.Objects;

public class Question {

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

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

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(this.question, question.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.question);
    }
}
