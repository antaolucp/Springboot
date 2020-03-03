package com.dxh.bookillustration.pojo;

public class Label {
    Integer label_id;
    String label;
    Integer label_num;

    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLabel_num() {
        return label_num;
    }

    public void setLabel_num(Integer label_num) {
        this.label_num = label_num;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label_id=" + label_id +
                ", label='" + label + '\'' +
                ", label_num=" + label_num +
                '}';
    }
}
