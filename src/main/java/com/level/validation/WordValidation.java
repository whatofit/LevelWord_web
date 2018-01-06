package com.level.validation;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

public class WordValidation {
    private long id;

    private String frequency;

    private String freqWritten;

    private String freqSpoken;

    @NotEmpty(message="单词不能为空")
    private String spelling;

    private String phoneticDJ;
    
    private String phoneticKK;

    private String level;

    private String partsOfSpeech;

    private String meanings;

    private String sentences;


    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public String getFreqWritten() {
		return freqWritten;
	}


	public void setFreqWritten(String freqWritten) {
		this.freqWritten = freqWritten;
	}


	public String getFreqSpoken() {
		return freqSpoken;
	}


	public void setFreqSpoken(String freqSpoken) {
		this.freqSpoken = freqSpoken;
	}


	public String getSpelling() {
		return spelling;
	}


	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}


	public String getPhoneticDJ() {
		return phoneticDJ;
	}


	public void setPhoneticDJ(String phoneticDJ) {
		this.phoneticDJ = phoneticDJ;
	}


	public String getPhoneticKK() {
		return phoneticKK;
	}


	public void setPhoneticKK(String phoneticKK) {
		this.phoneticKK = phoneticKK;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getPartsOfSpeech() {
		return partsOfSpeech;
	}


	public void setPartsOfSpeech(String partsOfSpeech) {
		this.partsOfSpeech = partsOfSpeech;
	}


	public String getMeanings() {
		return meanings;
	}


	public void setMeanings(String meanings) {
		this.meanings = meanings;
	}


	public String getSentences() {
		return sentences;
	}


	public void setSentences(String sentences) {
		this.sentences = sentences;
	}


	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
