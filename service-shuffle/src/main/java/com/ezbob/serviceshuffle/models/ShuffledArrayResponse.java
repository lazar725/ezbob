package com.ezbob.serviceshuffle.models;

public class ShuffledArrayResponse {
    private int[] shuffledArray;

    public ShuffledArrayResponse(int[] shuffledArray) {
        this.shuffledArray = shuffledArray;
    }

    public int[] getShuffledArray() {
        return shuffledArray;
    }
}
