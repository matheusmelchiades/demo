package com.dhis.demo.model;

public class Patient {
    private Long id;
    private String name;
    private Double weight;
    private Double height;

    public Patient() {
    }

    public Patient(Long id, String name, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    /**
     * get field
     *
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field
     *
     * @return weight
     */
    public Double getWeight() {
        return this.weight;
    }

    /**
     * set field
     *
     * @param weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * get field
     *
     * @return height
     */
    public Double getHeight() {
        return this.height;
    }

    /**
     * set field
     *
     * @param height
     */
    public void setHeight(Double height) {
        this.height = height;
    }
}
