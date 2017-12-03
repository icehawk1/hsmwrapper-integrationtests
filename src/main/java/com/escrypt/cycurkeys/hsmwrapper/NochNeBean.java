package com.escrypt.cycurkeys.hsmwrapper;

import java.util.Arrays;

public class NochNeBean {
    private byte[] array;

    public byte[] getArray() {
        return array;
    }

    public void setArray(byte[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NochNeBean that = (NochNeBean) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "NochNeBean{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
