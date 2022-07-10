package com.ezbob.serviceshuffle.services;

import com.ezbob.serviceshuffle.exceptions.InvalidArrayLengthException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShufflingService {
    public int[] getShuffledArrayByLength(int n) throws InvalidArrayLengthException {
        if (n < 1) {
            throw new InvalidArrayLengthException("Array length must be greater or equal to one");
        }

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = i + 1;
        }

        Random r = new Random();

        for (int i = n - 1; i > 0; i--) {
            int swapIndex = r.nextInt(i + 1);

            if (i != swapIndex) {
                output[i] *= output[swapIndex];
                output[swapIndex] = output[i] / output[swapIndex];
                output[i] /= output[swapIndex];
            }
        }

        return output;
    }
}
