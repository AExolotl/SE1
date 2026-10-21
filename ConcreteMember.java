package org.hbrs.se1.ws26.exercises.uebung2;

public class ConcreteMember implements Member {

    private final Integer id;

    public ConcreteMember(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Die ID darf nicht null sein.");
        }
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + id + ")";
    }
}