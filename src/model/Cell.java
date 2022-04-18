package model;

import core.Constants;
import utils.IllegalSetDefaultCellException;

import java.util.HashSet;
import java.util.Set;

public class Cell {

    private final boolean isDefault;
    private Value currentValue = null;
    private final Set<Value> domain = new HashSet<>();

    public Cell(Value value) {
        this.currentValue = value;
        this.isDefault = true;
    }

    public Cell() {
        this.isDefault = false;
        domain.addAll(Value.valueSet());
    }

    public void setValue(Value value) {
        if(isDefault)
            throw new IllegalSetDefaultCellException();

        this.currentValue = value;
    }

    public Value getValue() {
        return currentValue;
    }

    public boolean hasValue() {
        return currentValue != null;
    }

    public void addToDomain(Value value) {
        if(isDefault)
            throw new IllegalSetDefaultCellException();

        domain.add(value);
    }

    public void removeFromDomain(Value value) {
        if(isDefault)
            throw new IllegalSetDefaultCellException();

        domain.remove(value);
    }

    public boolean isDomainEmpty() {
        return domain.isEmpty();
    }

    public boolean isDefault() {
        return isDefault;
    }

    public Value[] getDomain() {
        return domain.toArray(new Value[0]);
    }

    @Override
    public String toString() {
        if(isDefault) {
            if(currentValue == Value.WHITE) {
                return String.valueOf(Constants.WHITE_SQUARE);
            } else {
                return String.valueOf(Constants.BLACK_SQUARE);
            }
        } else if(currentValue == null) {
            return "-";
        } else {
            return switch (currentValue) {
                case WHITE -> String.valueOf(Constants.WHITE_CIRCLE);
                case BLACK -> String.valueOf(Constants.BLACK_CIRCLE);
            };
        }
    }
}
