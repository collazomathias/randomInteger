package co.com.sofka.mentoring35.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RandomIntegerModel {

    @Id
    private String idList;

    private Integer initialNumber;
    
    private Integer finalNumber;

    private int[] numbersList;

    private Integer columns;

    public Integer getFinalNumber() {
        return finalNumber;
    }

    public String getIdList() {
        return idList;
    }

    public Integer getInitialNumber() {
        return initialNumber;
    }

    public int[] getNumbersList() {
        return numbersList;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setFinalNumber(Integer finalNumber) {
        this.finalNumber = finalNumber;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public void setInitialNumber(Integer initialNumber) {
        this.initialNumber = initialNumber;
    }

    public void setNumbersList(int[] numbersList) {
        this.numbersList = numbersList;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }
    
}
